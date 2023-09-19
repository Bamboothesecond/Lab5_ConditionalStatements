package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;
    TextView textViewResult;
    Button additionButton, subtractionButton, multiplyButton, divisionButton, clearButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        editTextNumber1 = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        textViewResult = findViewById(R.id.textViewResult);

        additionButton = findViewById(R.id.additionButton);
        subtractionButton = findViewById(R.id.subtractionButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divisionButton = findViewById(R.id.divisionButton);
        clearButton = findViewById(R.id.clearButton);
        backButton = findViewById(R.id.button2);

        additionButton.setOnClickListener(v -> calculate('+'));
        subtractionButton.setOnClickListener(v -> calculate('-'));
        multiplyButton.setOnClickListener(v -> calculate('*'));
        divisionButton.setOnClickListener(v -> calculate('/'));
        clearButton.setOnClickListener(v -> clear());

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the input in the EditText
                editTextNumber1.setText("");
                editTextNumber2.setText("");
                textViewResult.setText("");
                // Go back to MainActivity
                finish();
            }
        });
    }

    private void calculate(char operator) {
        String input1 = editTextNumber1.getText().toString();
        String input2 = editTextNumber2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Both input fields must be provided", Toast.LENGTH_SHORT).show();
            return;
        }

        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);
        int result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            default:
                return;
        }

        textViewResult.setText(String.valueOf(result));
    }

    private void clear() {
        editTextNumber1.setText("");
        editTextNumber2.setText("");
        textViewResult.setText("");
    }
}
