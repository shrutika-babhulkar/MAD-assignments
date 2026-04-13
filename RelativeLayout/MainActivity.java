package com.example.relativelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnPlay, btnPause, btnStop;
    TextView status, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);
        status = findViewById(R.id.status);
        result = findViewById(R.id.result);

        btnPlay.setOnClickListener(v -> {
            status.setText("Playing ▶");
            result.setText("Music Started 🎶");
        });

        btnPause.setOnClickListener(v -> {
            status.setText("Paused ⏸");
            result.setText("Music Paused");
        });

        btnStop.setOnClickListener(v -> {
            status.setText("Stopped ■");
            result.setText("Music Stopped");
        });
    }
}