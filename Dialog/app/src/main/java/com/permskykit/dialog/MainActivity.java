package com.permskykit.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox[] chk = new CheckBox[4];
    EditText[] num = new EditText[4];
    EditText[] price = new EditText[4];
    EditText value;
    Switch switchWindow;
    Switch switchToast;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk[0] = findViewById(R.id.CheckBox0);
        chk[1] = findViewById(R.id.CheckBox1);
        chk[2] = findViewById(R.id.CheckBox2);
        chk[3] = findViewById(R.id.CheckBox3);

        num[0] = findViewById(R.id.num0);
        num[1] = findViewById(R.id.num1);
        num[2] = findViewById(R.id.num2);
        num[3] = findViewById(R.id.num3);

        price[0] = findViewById(R.id.price0);
        price[1] = findViewById(R.id.price1);
        price[2] = findViewById(R.id.price2);
        price[3] = findViewById(R.id.price3);

        value = findViewById(R.id.valueResult);
        switchWindow = findViewById(R.id.switchWindow);
        switchToast = findViewById(R.id.switchToast);
    }

    public void onCalc (View v) {

        //Проверка на количество включённых чекбоксов.

        try {
            float n = 0.0f;
            for (int i = 0; i < 4; i++) {
                if (num[i].length() >= 1) {
                    n = n + Float.parseFloat(num[i].getText().toString());
                }
            }
        }catch (Exception e){
            value.setText("0.0");
        }

        //Просчёт значений.

        float sum = 0.0f;
        try {
            for (int i = 0; i < 4; i++) {
                if (Float.parseFloat(num[i].getText().toString()) <= 0){
                    value.setText("0.0");
                }
                else if (Float.parseFloat(price[i].getText().toString()) <= 0){
                    value.setText("0.0");
                }
                else if (chk[i].isChecked()) {
                    float q = Float.parseFloat(num[i].getText().toString());
                    float val = q * Float.parseFloat(price[i].getText().toString());
                    sum += val;
                }
            }
        }catch (Exception e) {
            value.setText("0.0");
        }

        //Создание диалогового окна.

        value.setText(String.valueOf(sum));
        if (switchWindow.isChecked()) {
            AlertDialog.Builder bld = new AlertDialog.Builder(this);
            AlertDialog dlg = bld.create();
            dlg.setIcon(R.drawable.money);
            dlg.setTitle("Result:");
            dlg.setMessage(String.valueOf(sum));
            dlg.show();
        }

        //Создание уведомления.

        if(switchToast.isChecked()){
            Toast toast = Toast.makeText(getApplicationContext(), "Result:" + (sum), Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}