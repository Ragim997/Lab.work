package com.permskykit.finalconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonLength(View v) {
        startActivity(new Intent(this, LengthActivity.class));
    }

    public void buttonWeigth(View v) {
        startActivity(new Intent(this, WeigthActivity.class));
    }

    public void buttonFrequency(View v) {
        startActivity(new Intent(this, TimeActivity.class));
    }
}