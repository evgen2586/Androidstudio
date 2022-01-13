package com.example.test_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Gravity_detector extends AppCompatActivity {

    private SensorManager sm;
    private Sensor s;
    private ImageView im;
    private TextView tv;
    private SensorEventListener sv;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity_detector);
        tv = findViewById(R.id.grav_txt);
        im = findViewById(R.id.grav_line);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sm !=null)s = sm.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        sv = new SensorEventListener()
        {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent)
            {

                float[] rotationMatrix = new float[16];
                SensorManager.getRotationMatrixFromVector(rotationMatrix, sensorEvent.values);

                float[] remappedRotationMatrix = new float[16];
                SensorManager.remapCoordinateSystem(rotationMatrix,SensorManager.AXIS_X, SensorManager.AXIS_Z, remappedRotationMatrix);

                float[] oreintation = new float[3];
                SensorManager.getOrientation(remappedRotationMatrix, oreintation);

                for(int i = 0; i < 3; i++)
                {
                    oreintation[i] = (float) (Math.toDegrees(oreintation[i]));
                }


                tv.setText(String.valueOf((int)oreintation[2]));
                im.setRotation(-oreintation[2]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy)
            {

            }
        };

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        sm.registerListener(sv,s,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        sm.unregisterListener(sv);
    }
}