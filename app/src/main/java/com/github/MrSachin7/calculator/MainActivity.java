package com.github.MrSachin7.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.github.MrSachin7.calculator.logics.ExpressionSolver;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        textView = findViewById(R.id.showHere);
    }

    public void numberPressed(View view) {
        switch (view.getId()) {

            case (R.id.one):
                textView.append("1");
                break;
            case (R.id.two):
                textView.append("2");
                break;
            case (R.id.three) :
                textView.append("3");
                break;
            case (R.id.four) :
                textView.append("4");
                break;
            case (R.id.five) :
                textView.append("5");
                break;
            case (R.id.six) :
                textView.append("6");
                break;

            case (R.id.seven) :
                textView.append("7");
                break;
            case (R.id.eight) :
                textView.append("8");
                break;
            case (R.id.nine) :
                textView.append("9");
                break;
            case (R.id.zero) :
                textView.append("0");
                break;

        }


    }

    public void operatorPressed(View view) {
        char lastChar = textView.getText().charAt((textView.getText().length()-1));
        if (lastChar=='-' || lastChar =='+' || lastChar=='*' || lastChar =='/'){
            Toast.makeText(this, "No two operators in a row, please..", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (view.getId()){
            case (R.id.c) :
                textView.setText("");
                break;

            case (R.id.plus):
                textView.append("+");
                break;

            case (R.id.minus):
                textView.append("-");
                break;

            case (R.id.divide):
                textView.append("/");
                break;

            case (R.id.multiply):
                textView.append("*");
                break;

            case (R.id.equals):
                // Look for divide first
                double result = ExpressionSolver.evaluate(String.valueOf(textView.getText()));
                textView.setText(result+"");
        }
    }





}