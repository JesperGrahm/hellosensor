package com.example.hellosensor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToCompass(View view) {
        Intent intent = new Intent(this, compass.class);
        startActivity(intent);
    }

    public void goToAccelerometer(View view) {
        Intent intent = new Intent(this, accelerometer.class);
        startActivity(intent);
    }
}
