package com.example.test_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
private Button button1;
private Button button2;
private Button button3;
private Button button4;
private Button button5;
private Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Датчик_ориентации();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Гироскоп();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Датчик_освещённости();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Магнитометр();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Датчик_приближения();
            }
        });

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Акселерометр();
            }
        });
    }
    public void Акселерометр()
    {
        Intent intent = new Intent(this, Gravity_detector.class);
        startActivity(intent);
    }
    public void Датчик_приближения()
    {
        Intent intent2 =new Intent(this, Proximity_detector.class);
        startActivity(intent2);
    }
    public void Магнитометр(){
        Intent intent3 = new Intent(this, Magnetomer.class);
        startActivity(intent3);
    }
    public void Датчик_освещённости(){
        Intent intent4 = new Intent(this, Light_sensor.class);
        startActivity(intent4);
    }
    public void Гироскоп(){
        Intent intent5 = new Intent(this, Gyroscope.class);
        startActivity(intent5);
    }
    public void Датчик_ориентации(){
        Intent intent6 = new Intent(this, Orientation_detector.class);
        startActivity(intent6);
    }

}