package com.example.tablelayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this,
                    "All Students Data Displayed 📊",
                    Toast.LENGTH_SHORT).show();
        });
    }
}