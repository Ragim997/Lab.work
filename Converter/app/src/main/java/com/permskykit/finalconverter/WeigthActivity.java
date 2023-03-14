package com.permskykit.finalconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class WeigthActivity extends AppCompatActivity {

    Spinner spFrom;
    Spinner spTo;
    EditText etFrom;
    TextView tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weigth);

        spFrom = findViewById(R.id.listFrom);
        spTo = findViewById(R.id.listTo);
        etFrom = findViewById(R.id.valueFrom);
        tvTo = findViewById(R.id.valueTo);


        ArrayAdapter<String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mg");
        adp.add("g");
        adp.add("kg");
        adp.add("t");

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    public void buttonConvert(View v) {

        double from = Double.parseDouble(etFrom.getText().toString());

        String sFrom = (String) spFrom.getSelectedItem();
        String sTo = (String) spTo.getSelectedItem();

        double to = 0.0d;
        double kg = 0.0d;
        if(sFrom.equals("mg")) kg = from / 1000000.0d;
        if(sFrom.equals("g")) kg = from / 1000.0d;
        if(sFrom.equals("kg")) kg = from;
        if(sFrom.equals("t")) kg = from * 1000.0d;

        if(sTo.equals("mg")) to = kg * 1000000.0d;
        if(sTo.equals("g")) to = kg * 1000.0d;
        if(sTo.equals("kg")) to = kg;
        if(sTo.equals("t")) to = kg / 1000.0;

        tvTo.setText(String.valueOf(to));
    }

    public void buttonToLength(View v) {
        startActivity(new Intent(this, LengthActivity.class));
    }

    public void buttonToTime(View v) {
        startActivity(new Intent(this, TimeActivity.class));
    }
}