package com.example.hellosensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;




public class accelerometer extends AppCompatActivity implements SensorEventListener {


    private SensorManager sensorManager;
    Sensor accelerometer;

    TextView xValue, yValue, zValue, dir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer , SensorManager.SENSOR_DELAY_NORMAL);
        xValue = (TextView) findViewById(R.id.x_axis);
        yValue = (TextView) findViewById(R.id.y_axis);
        zValue = (TextView) findViewById(R.id.z_axis);
        dir = (TextView) findViewById(R.id.dir);

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public float convert(float a ){
        float p = a*100;
        float l = Math.round(p);
        float h = l / 100;
        return h;
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        xValue.setText("X:" + Float.toString(convert(event.values[0])));
        yValue.setText("Y:" + Float.toString(convert(event.values[1])));
        zValue.setText("Z:" + Float.toString(convert(event.values[2])));
        //dir.setText("Direction:" + Float.toString(convert(event.values[3])));

        if(event.values[0] <= -4.0){
            dir.setText("Höger");
            setActivityBackgroundColor(0xfffaa000);
        }

        if(event.values[0] >= 4.0){
            dir.setText("Vänster");
            setActivityBackgroundColor(0xffaaa000);
        }

        if( -4.0 < event.values[0] && event.values[0] < 4.0){
            dir.setText("Fram");
            setActivityBackgroundColor(0xffaaaff0);
        }
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }


}