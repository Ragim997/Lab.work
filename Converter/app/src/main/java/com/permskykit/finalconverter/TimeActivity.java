package com.permskykit.finalconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TimeActivity extends AppCompatActivity {

    Spinner spFrom;
    Spinner spTo;
    EditText etFrom;
    TextView tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        spFrom = findViewById(R.id.listFrom);
        spTo = findViewById(R.id.listTo);
        etFrom = findViewById(R.id.valueFrom);
        tvTo = findViewById(R.id.valueTo);

        ArrayAdapter<String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("s");
        adp.add("m");
        adp.add("h");
        adp.add("d");

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    public void buttonConvert(View v) {

        double from = Double.parseDouble(etFrom.getText().toString());

        String sFrom = (String) spFrom.getSelectedItem();
        String sTo = (String) spTo.getSelectedItem();

        double to = 0.0d;
        double s = 0.0d;
        if(sFrom.equals("s")) s = from;
        if(sFrom.equals("m")) s = from * 60.0d;
        if(sFrom.equals("h")) s = from * 3600.0d;
        if(sFrom.equals("d")) s = from * 86400.0d;

        if(sTo.equals("s")) to = s;
        if(sTo.equals("m")) to = s / 60.0d;
        if(sTo.equals("h")) to = s / 3600.0d;
        if(sTo.equals("d")) to = s / 86400.0d;

        tvTo.setText(String.valueOf(to));
    }

    public void buttonToLength(View v) {
        startActivity(new Intent(this, LengthActivity.class));
    }

    public void buttonToWeigth(View v) {
        startActivity(new Intent(this, WeigthActivity.class));
    }
}