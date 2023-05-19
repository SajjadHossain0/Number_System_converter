package com.example.number_system_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Hexadecimal extends AppCompatActivity {
    private EditText Decimal_editText,HexaDecimal_editText,Octal_editText,Binary_editText;
    private Button decimalbtn, binaryBtn, octalBtn, hexabtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexadecimal);

        Decimal_editText = findViewById(R.id.Decimal_editText);
        HexaDecimal_editText = findViewById(R.id.HexaDecimal_editText);
        Octal_editText = findViewById(R.id.Octal_editText);
        Binary_editText = findViewById(R.id.Binary_editText);

        decimalbtn = (Button) findViewById(R.id.decimalbtn);
        binaryBtn = (Button) findViewById(R.id.binaryBtn);
        octalBtn = (Button) findViewById(R.id.octalBtn);
        hexabtn = (Button) findViewById(R.id.hexabtn);

        decimalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hexadecimal.this,MainActivity.class));
            }
        });
        binaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hexadecimal.this,Binary.class));
            }
        });
        octalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hexadecimal.this,Octal.class));
            }
        });

        HexaDecimal_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    String hexadecimalNumber = charSequence.toString();
                    String  decimalNumber = NumberSystemConverter.hexadecimalToDecimal(hexadecimalNumber);
                    Decimal_editText.setText(decimalNumber);
                } else {
                    Decimal_editText.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Decimal_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    String decimalNumber = charSequence.toString();
                    String octalnumber = NumberSystemConverter.decimalToOctal(Integer.parseInt(decimalNumber));
                    Octal_editText.setText(octalnumber);
                } else {
                    Octal_editText.setText("");
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Decimal_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    String decimalNumber = charSequence.toString();
                    String binaryNumber = NumberSystemConverter.decimalToBinary(Integer.parseInt(decimalNumber));
                    Binary_editText.setText(binaryNumber);
                } else {
                    Binary_editText.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}