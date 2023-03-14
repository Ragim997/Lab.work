package com.permskykit.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    EditText ta;
    EditText tb;
    TextView lr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ta = findViewById(R.id.txtA);
        tb = findViewById(R.id.txtB);
        lr = findViewById(R.id.labC);
    }

    public void my_add_click(View v) {
        try {
            String sa = ta.getText().toString();
            String sb = tb.getText().toString();
            float a = Float.parseFloat(sa);
            float b = Float.parseFloat(sb);
            float c = a + b;
            String sc = String.valueOf(c);
            lr.setText(sc);
        } catch (Exception e) {
            lr.setText("Введите числа в оба поля.");
        }
    }

    public void my_sub_click(View v) {
        try {
            String sa = ta.getText().toString();
            String sb = tb.getText().toString();
            float a = Float.parseFloat(sa);
            float b = Float.parseFloat(sb);
            float c = a - b;
            String sc = String.valueOf(c);
            lr.setText(sc);
        } catch (Exception e) {
            lr.setText("Введите числа в оба поля.");
        }
    }

    public void my_mul_click(View v) {
        try {
            String sa = ta.getText().toString();
            String sb = tb.getText().toString();
            float a = Float.parseFloat(sa);
            float b = Float.parseFloat(sb);
            float c = a * b;
            if (a == 0 | b == 0) {
                lr.setText("1.0");
                ;
            } else {
                String sc = String.valueOf(c);
                lr.setText(sc);
            }
        } catch (Exception e) {
            lr.setText("Введите числа в оба поля.");
        }
    }

    public void my_div_click(View v) {
        try {
            String sa = ta.getText().toString();
            String sb = tb.getText().toString();
            float a = Float.parseFloat(sa);
            float b = Float.parseFloat(sb);
            float c = a / b;
            if (b == 0) {
                lr.setText("Делить на ноль нельзя!");
                ;
            } else {
                String sc = String.valueOf(c);
                lr.setText(sc);
            }
        } catch (Exception e) {
            lr.setText("Введите числа в оба поля.");
        }
    }

    public void my_sin_click(View v) {
        try {
            String sa = ta.getText().toString();
            double a = Double.parseDouble(sa);
            double b = Math.toRadians(a);
            double c = Math.sin(b);
            String sc = String.valueOf(c);
            lr.setText(sc);
        } catch (Exception e) {
            lr.setText("Введите число в поле A.");
        }
    }

    public void my_cos_click(View v) {
        try {
            String sa = ta.getText().toString();
            double a = Double.parseDouble(sa);
            double b = Math.toRadians(a);
            double c = Math.cos(b);
            String sc = String.valueOf(c);
            lr.setText(sc);
        } catch (Exception e) {
            lr.setText("Введите число в поле A.");
        }
    }

    public void my_tan_click(View v) {
        try {
            String sa = ta.getText().toString();
            double a = Double.parseDouble(sa);
            double b = Math.toRadians(a);
            double c = Math.tan(b);
            String sc = String.valueOf(c);
            lr.setText(sc);
        } catch (Exception e) {
            lr.setText("Введите число в поле A.");
        }
    }

    public void my_sqrt_click(View v) {
        try {
            String sa = ta.getText().toString();
            double a = Double.parseDouble(sa);
            double c = Math.sqrt(a);
            String sc = String.valueOf(c);
            lr.setText(sc);
        } catch (Exception e) {
            lr.setText("Введите число в поле A.");
        }
    }

    public void my_pow_click(View v) {
        try {
            String sa = ta.getText().toString();
            String sb = tb.getText().toString();
            double a = Double.parseDouble(sa);
            double b = Double.parseDouble(sb);
            double c = Math.pow(a, b);
            String sc = String.valueOf(c);
            lr.setText(sc);
        }
        catch (Exception e) {
            lr.setText("Введите числа в оба поля.");
        }
    }
}