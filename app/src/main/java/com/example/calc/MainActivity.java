package com.example.calc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    // Creating variables
    String existingNumber = "";
    String operator = "+";
    boolean isUserOperator = true;

    // declaring the edit text
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // declaring the edit text
    result = findViewById(R.id.answer);
    }

    // declaring the function to handle the user events for number buttons
    public void userNumber(View view) {
        if(isUserOperator)
            result.setText("");
        isUserOperator = false;
        String number = result.getText().toString();
        switch (view.getId()){
            case R.id.zero:
                number += "0";
                break;
            case R.id.one:
                number += "1";
                break;
            case R.id.two:
                number += "2";
                break;
            case R.id.three:
                number += "3";
                break;
            case R.id.four:
                number += "4";
                break;
            case R.id.five:
                number += "5";
                break;
            case R.id.six:
                number += "6";
                break;
            case R.id.seven:
                number += "7";
            break;
            case R.id.eight:
                number += "8";
                break;
            case R.id.nine:
                number += "9";
                break;
            case R.id.decimal:
                number += ".";
                break;
            case R.id.plus:
                number += "+";
                break;
            case R.id.minus:
                number += "-";
                break;
            case R.id.multiply:
                number += "x";
                break;
            case R.id.divide:
                number += "??";
                break;
        }
        result.setText(number);
    }

    // Declaring the function to handle the operator buttons
    public void userOperator(View view) {
        isUserOperator = true;
        existingNumber = result.getText().toString();
        switch (view.getId()){
            case R.id.plus: operator = "+"; break;
            case R.id.minus: operator = "-"; break;
            case R.id.multiply: operator = "x"; break;
            case R.id.divide: operator = "??"; break;
        }
    }

    // Declaring the function to handle the answer
    public void userResult(View view) {
        String outputNumber = result.getText().toString();
         double finalResult = 0.0;
        switch (operator){
            case "+":
                finalResult = Double.parseDouble(existingNumber) + Double.parseDouble(outputNumber);
                break;
            case "-":
                finalResult = Double.parseDouble(existingNumber) - Double.parseDouble(outputNumber);
                break;
            case "x":
                finalResult = Double.parseDouble(existingNumber) * Double.parseDouble(outputNumber);
                break;
            case "??":
                finalResult = Double.parseDouble(existingNumber) / Double.parseDouble(outputNumber);
                break;
        }
        result.setText(finalResult+ "");
    }

    public void emptyEvent(View view) {
        result.setText("0");
        isUserOperator = true;
    }
}