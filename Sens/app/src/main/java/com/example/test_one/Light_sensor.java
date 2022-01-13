package com.example.test_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Light_sensor extends AppCompatActivity implements SensorEventListener { // реализовываем метод класса SensorEventListener

    private static String TAG = "Light_sensor"; //определение тег журнала

    private SensorManager sensorManager; //Менеджер сенсоров аппрата
    private Sensor mLight; // определяем датчик

    TextView light;


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) { // Добавим метод
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType() == Sensor.TYPE_LIGHT ){  //Определяем тип датчика //Если освещенность
            light.setText("Light: " + sensorEvent.values[0]);  //Выводим результат
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) { // Добавим метод

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);  //устанавливает содержимое Activity из layout-файла

        light = (TextView) findViewById(R.id.light);  // текстовое поле для вывода показаний

        Log.d(TAG, "onCreate: Initializing Sensor Services"); // Инициализация служб датчиков

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE); // настройка системной службы диспечера датчиков

        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT); // получение датчика освещенности
        if (mLight !=null){
            sensorManager.registerListener(Light_sensor.this, mLight, sensorManager.SENSOR_DELAY_NORMAL); //указываем сенсор за которым будем наблюдать и водим частоту обновлений по умолчанию;
        }else {
            light.setText("Light Not Supported"); // выводитсяя когда датчик не поддерживается
        }


    }
}