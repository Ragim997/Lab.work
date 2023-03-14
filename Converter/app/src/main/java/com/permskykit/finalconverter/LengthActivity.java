package com.permskykit.finalconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class LengthActivity extends AppCompatActivity {

    Spinner spFrom;
    Spinner spTo;
    EditText etFrom;
    TextView tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        spFrom = findViewById(R.id.listFrom);
        spTo = findViewById(R.id.listTo);
        etFrom = findViewById(R.id.valueFrom);
        tvTo = findViewById(R.id.valueTo);


        ArrayAdapter<String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    public void buttonConvert(View v) {

        double from = Double.parseDouble(etFrom.getText().toString());

        String sFrom = (String) spFrom.getSelectedItem();
        String sTo = (String) spTo.getSelectedItem();

        double to = 0.0d;
        double m = 0.0d;
        if(sFrom.equals("mm")) m = from / 1000.0d;
        if(sFrom.equals("cm")) m = from / 100.0d;
        if(sFrom.equals("m")) m = from;
        if(sFrom.equals("km")) m = from * 1000.0d;

        if(sTo.equals("mm")) to = m * 1000.0d;
        if(sTo.equals("cm")) to = m * 100.0d;
        if(sTo.equals("m")) to = m;
        if(sTo.equals("km")) to = m / 1000.0;

        tvTo.setText(String.valueOf(to));
    }

    public void buttonToWeigth(View v) {
        startActivity(new Intent(this, WeigthActivity.class));
    }

    public void buttonToTime(View v) {
        startActivity(new Intent(this, TimeActivity.class));
    }
}