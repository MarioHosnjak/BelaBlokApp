package com.example.challengeno1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity2 extends AppCompatActivity {

    StringBuilder twTextMi = new StringBuilder("");
    StringBuilder twTextVi = new StringBuilder("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button backBtn = findViewById(R.id.backButton);

        ToggleButton toggleButtonMi = findViewById(R.id.toggleButtonMi);
        toggleButtonMi.setTextOn("");
        toggleButtonMi.setTextOff("");
        ToggleButton toggleButtonVi = findViewById(R.id.toggleButtonVi);
        toggleButtonVi.setTextOn("");
        toggleButtonVi.setTextOff("");

        toggleButtonMi.setBackgroundColor(Color.argb(65, 180, 180, 180));

        TextView twMi = findViewById(R.id.resultTextViewMi);
        TextView twVi = findViewById(R.id.resultTextViewVi);

        class NumPadListener implements View.OnClickListener {

            @Override
            public void onClick(View v) {
                String name = ((Button) v).getText().toString();

                if (toggleButtonMi.isChecked()) {
                    twTextMi.append(name);
                    twMi.setText(twTextMi);
                    twTextVi.delete(0, twTextVi.length());
                    twTextVi.append(162 - Integer.parseInt(twTextMi.toString()));
                    if (Integer.parseInt(twTextVi.toString()) < 0) twVi.setText("0");
                    else twVi.setText(twTextVi);
                } else {
                    twTextVi.append(name);
                    twVi.setText(twTextVi);
                    twTextMi.delete(0, twTextMi.length());
                    twTextMi.append(162 - Integer.parseInt(twTextVi.toString()));
                    if (Integer.parseInt(twTextMi.toString()) < 0) twMi.setText("0");
                    else twMi.setText(twTextMi);
                }
            }
        }

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btn0 = findViewById(R.id.btn0);

        btn1.setOnClickListener(new NumPadListener());
        btn2.setOnClickListener(new NumPadListener());
        btn3.setOnClickListener(new NumPadListener());
        btn4.setOnClickListener(new NumPadListener());
        btn5.setOnClickListener(new NumPadListener());
        btn6.setOnClickListener(new NumPadListener());
        btn7.setOnClickListener(new NumPadListener());
        btn8.setOnClickListener(new NumPadListener());
        btn9.setOnClickListener(new NumPadListener());
        btn0.setOnClickListener(new NumPadListener());

        toggleButtonMi.setOnClickListener(l -> {
            if (toggleButtonVi.isChecked())
                toggleButtonVi.setChecked(false);
            toggleButtonVi.setBackgroundColor(Color.argb(80, 255, 255, 255));
            toggleButtonMi.setChecked(true);
            toggleButtonMi.setBackgroundColor(Color.argb(65, 180, 180, 180));
        });
        toggleButtonVi.setOnClickListener(l -> {
            if (toggleButtonMi.isChecked())
                toggleButtonMi.setChecked(false);
            toggleButtonMi.setBackgroundColor(Color.argb(80, 255, 255, 255));
            toggleButtonVi.setChecked(true);
            toggleButtonVi.setBackgroundColor(Color.argb(65, 180, 180, 180));
        });

        Button zv20Btn = findViewById(R.id.zv20Btn);
        Button zv50Bnt = findViewById(R.id.zv50Btn);
        Button zv100Btn = findViewById(R.id.zv100Btn);
        Button zv150Btn = findViewById(R.id.zv150Btn);
        Button zv200Btn = findViewById(R.id.zv200Btn);


        class ZvanjaListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                String name = ((Button) v).getText().toString();
                System.out.println(Integer.parseInt(name));
                if (toggleButtonMi.isChecked()) {
                    int zvanja = Integer.parseInt(name);
                    if (twMi.getText().toString().contentEquals("MI") || twMi.getText().toString().contentEquals("")) {
                        twMi.setText(String.valueOf(zvanja));
                    } else {
                        int value = Integer.parseInt(twMi.getText().toString());
                        value += zvanja;
                        twMi.setText(String.valueOf(value));
                    }
                } else if (toggleButtonVi.isChecked()) {
                    int zvanja = Integer.parseInt(name);
                    if (twVi.getText().toString().contentEquals("VI") || twVi.getText().toString().contentEquals("")) {
                        twVi.setText(String.valueOf(zvanja));
                    } else {
                        int value = Integer.parseInt(twVi.getText().toString());
                        value += zvanja;
                        twVi.setText(String.valueOf(value));
                    }
                }
            }
        }

        zv20Btn.setOnClickListener(new ZvanjaListener());
        zv50Bnt.setOnClickListener(new ZvanjaListener());
        zv100Btn.setOnClickListener(new ZvanjaListener());
        zv150Btn.setOnClickListener(new ZvanjaListener());
        zv200Btn.setOnClickListener(new ZvanjaListener());


        backBtn.setOnClickListener((l) -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        Button eraseBtn = findViewById(R.id.eraseBtn);
        eraseBtn.setOnClickListener(l -> {
            twMi.setText("");
            twVi.setText("");
            twTextMi.delete(0, twTextMi.length());
            twTextVi.delete(0, twTextVi.length());
        });

        Button saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(l -> {
            int resMi = Integer.parseInt(twMi.getText().toString());
            int resVi = Integer.parseInt(twVi.getText().toString());
            GameResult result = new GameResult(resMi, resVi);

            //System.out.println(result);

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("miResult", result.getMiResult());
            intent.putExtra("viResult", result.getViResult());

            startActivity(intent);

        });
    }
}