package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        clearButton = findViewById(R.id.clearButton);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    String choice = editText.getText().toString().toUpperCase();
                    switch (choice) {
                        case "A":
                            Intent intentA = new Intent(MainActivity.this, Activity2.class);
                            startActivity(intentA);
                            editText.setText("");
                            break;
                        case "B":
                            Intent intentB = new Intent(MainActivity.this, Activity3.class);
                            startActivity(intentB);
                            editText.setText("");
                            break;
                        default:
                            // Handle invalid input
                            Toast.makeText(MainActivity.this, "Invalid input! Please enter either 'A' or 'B'.", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return true;
                }
                return false;
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the input in the EditText
                editText.setText("");
            }
        });
    }
}