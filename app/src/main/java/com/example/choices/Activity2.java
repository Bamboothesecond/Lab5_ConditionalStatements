package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView textView;
    EditText inputText;
    Button button, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textView = findViewById(R.id.textView);
        inputText = findViewById(R.id.editTextText);
        button = findViewById(R.id.button);
        backButton = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = inputText.getText().toString();

                textView.setText("Hello " + name + "!");
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the input in the EditText
                inputText.setText("");
                // Go back to MainActivity
                finish();
            }
        });
    }
}