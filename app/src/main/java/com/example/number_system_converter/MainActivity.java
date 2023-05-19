package com.example.number_system_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText Decimal_editText,HexaDecimal_editText,Octal_editText,Binary_editText;
private Button decimalbtn, binaryBtn, octalBtn, hexabtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Decimal_editText = findViewById(R.id.Decimal_editText);
        HexaDecimal_editText = findViewById(R.id.HexaDecimal_editText);
        Octal_editText = findViewById(R.id.Octal_editText);
        Binary_editText = findViewById(R.id.Binary_editText);

        decimalbtn = (Button) findViewById(R.id.decimalbtn);
        binaryBtn = (Button) findViewById(R.id.binaryBtn);
        octalBtn = (Button) findViewById(R.id.octalBtn);
        hexabtn = (Button) findViewById(R.id.hexabtn);

        binaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Binary.class));
            }
        });
        octalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Octal.class));
            }
        });
        hexabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Hexadecimal.class));
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
class NumberSystemConverter {

    public static String decimalToBinary(int decimalNumber) {
        return Integer.toBinaryString(decimalNumber);
    }

    public static String decimalToOctal(int decimalNumber) {
        return Integer.toOctalString(decimalNumber);
    }

    public static String decimalToHexadecimal(int decimalNumber) {
        return Integer.toHexString(decimalNumber);
    }

    public static int binaryToDecimal(String binaryNumber) {
        return Integer.parseInt(binaryNumber, 2);
    }

    public static int octalToDecimal(String octalNumber) {
        return Integer.parseInt(octalNumber, 8);
    }
public static String hexadecimalToDecimal(String hexNumber) {
    try {
        // Convert the hexadecimal number to decimal
        int decimalNumber = Integer.parseInt(hexNumber, 16);
        return String.valueOf(decimalNumber);
    } catch (NumberFormatException e) {
        // Handle the case when an invalid hexadecimal number is entered
        return "";
    }
}


}
