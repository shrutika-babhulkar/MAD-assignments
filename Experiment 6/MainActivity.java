package com.example.experimen6;


import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName;

    CheckBox checkMusic, checkSports;

    RadioGroup radioGroup;
    RadioButton selectedRadio;

    ToggleButton toggleButton;

    Button btnSubmit;

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect XML with Java
        editName = findViewById(R.id.editName);

        checkMusic = findViewById(R.id.checkMusic);
        checkSports = findViewById(R.id.checkSports);

        radioGroup = findViewById(R.id.radioGroup);

        toggleButton = findViewById(R.id.toggleButton);

        btnSubmit = findViewById(R.id.btnSubmit);

        txtResult = findViewById(R.id.txtResult);

        // Button Click Event
        btnSubmit.setOnClickListener(v -> {

            String name = editName.getText().toString();

            String hobbies = "";

            if (checkMusic.isChecked()) {
                hobbies += "Music ";
            }

            if (checkSports.isChecked()) {
                hobbies += "Sports ";
            }

            int selectedId = radioGroup.getCheckedRadioButtonId();

            selectedRadio = findViewById(selectedId);

            String gender = selectedRadio.getText().toString();

            String toggleStatus;

            if (toggleButton.isChecked()) {
                toggleStatus = "Notifications ON";
            } else {
                toggleStatus = "Notifications OFF";
            }

            String result =
                    "Name: " + name +
                            "\\nHobbies: " + hobbies +
                            "\\nGender: " + gender +
                            "\\n" + toggleStatus;

            txtResult.setText(result);
        });
    }
}