package com.example.calculator; // make sure this matches your actual package name

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        tvResult = findViewById(R.id.tvResult);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input1 = etNum1.getText().toString().trim();
                String input2 = etNum2.getText().toString().trim();

                if (input1.isEmpty() || input2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                double num1 = Double.parseDouble(input1);
                double num2 = Double.parseDouble(input2);
                double result = 0;

                int id = view.getId();

                if (id == R.id.btnAdd) {
                    result = num1 + num2;
                } else if (id == R.id.btnSubtract) {
                    result = num1 - num2;
                } else if (id == R.id.btnMultiply) {
                    result = num1 * num2;
                } else if (id == R.id.btnDivide) {
                    if (num2 == 0) {
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 / num2;
                }

                tvResult.setText("Result: " + result);
            }
        };

        btnAdd.setOnClickListener(listener);
        btnSubtract.setOnClickListener(listener);
        btnMultiply.setOnClickListener(listener);
        btnDivide.setOnClickListener(listener);
    }
}
