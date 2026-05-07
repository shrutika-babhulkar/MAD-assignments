package com.example.ratingprogressdemo;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    ProgressBar progressBar;
    TextView txtRating;
    Button btnStart;

    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        progressBar = findViewById(R.id.progressBar);
        txtRating = findViewById(R.id.txtRating);
        btnStart = findViewById(R.id.btnStart);

        // ⭐ INTERACTIVE RATING BAR
        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar,
                                                float rating,
                                                boolean fromUser) {

                        txtRating.setText("Rating: " + rating);

                        // Update progress based on rating
                        progressBar.setProgress((int) (rating * 20));

                        Toast.makeText(MainActivity.this,
                                "You selected: " + rating,
                                Toast.LENGTH_SHORT).show();
                    }
                });

        // 🔄 INTERACTIVE PROGRESS BAR (Auto Loading)
        btnStart.setOnClickListener(v -> {
            progress = 0;

            new Thread(() -> {
                while (progress <= 100) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progress += 5;

                    handler.post(() -> progressBar.setProgress(progress));
                }

                handler.post(() ->
                        Toast.makeText(MainActivity.this,
                                "Loading Complete!",
                                Toast.LENGTH_SHORT).show());
            }).start();
        });
    }
}