package com.example.test_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Magnetomer extends AppCompatActivity implements SensorEventListener {

    private static String TAG = "Magnetomer";

    private SensorManager sensorManager;
    private Sensor mMagno;

    TextView xMagnoValue, yMagnoValue, zMagnoValue;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if(sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            xMagnoValue.setText("xMValue: "+ sensorEvent.values[0]);
            yMagnoValue.setText("yMValue: "+ sensorEvent.values[1]);
            zMagnoValue.setText("zMValue: "+ sensorEvent.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetomer);

        xMagnoValue = (TextView)findViewById(R.id.xMagnoValue);
        yMagnoValue = (TextView)findViewById(R.id.yMagnoValue);
        zMagnoValue = (TextView)findViewById(R.id.zMagnoValue);

        Log.d(TAG, "onCreate: Initializing Sensor Services");

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        mMagno = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if(mMagno !=null){
            sensorManager.registerListener(Magnetomer.this, mMagno, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Magnometer listener");
        }else {
            xMagnoValue.setText("Magno Not Supported");
            yMagnoValue.setText("Magno Not Supported");
            zMagnoValue.setText("Magno Not Supported");
        }
    }
}