package com.example.number_system_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Binary extends AppCompatActivity {
    private EditText Decimal_editText,HexaDecimal_editText,Octal_editText,Binary_editText;
    private Button decimalbtn, binaryBtn, octalBtn, hexabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);

        Decimal_editText = findViewById(R.id.Decimal_editText);
        HexaDecimal_editText = findViewById(R.id.HexaDecimal_editText);
        Octal_editText = findViewById(R.id.Octal_editText);
        Binary_editText = findViewById(R.id.Binary_editText);

        HexaDecimal_editText.setEnabled(false);
        Octal_editText.setEnabled(false);
        Decimal_editText.setEnabled(false);


        decimalbtn = (Button) findViewById(R.id.decimalbtn);
        binaryBtn = (Button) findViewById(R.id.binaryBtn);
        octalBtn = (Button) findViewById(R.id.octalBtn);
        hexabtn = (Button) findViewById(R.id.hexabtn);

        decimalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Binary.this,MainActivity.class));
            }
        });
        octalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Binary.this,Octal.class));
            }
        });
        hexabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Binary.this,Hexadecimal.class));
            }
        });

        Binary_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    String binaryNumber = charSequence.toString();
                    try {
                    String  decimalNumber = String.valueOf(NumberSystemConverter.binaryToDecimal(String.valueOf(Integer.parseInt(binaryNumber))));
                    Decimal_editText.setText(decimalNumber);
                    } catch (NumberFormatException e) {
                        Toast.makeText(Binary.this, "Invalid binary number", Toast.LENGTH_SHORT).show();
                    }
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
                    String hexadecimalNumber = NumberSystemConverter.decimalToHexadecimal(Integer.parseInt(decimalNumber));
                    HexaDecimal_editText.setText(hexadecimalNumber);
                } else {
                    HexaDecimal_editText.setText("");
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

    }
}
