package com.example.sqldisplay;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    TextView textView;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);
        textView = findViewById(R.id.textView);

        db = new DBHelper(this);

        btnShow.setOnClickListener(v -> {

            Cursor cursor = db.getData();

            StringBuilder data = new StringBuilder();

            while(cursor.moveToNext()) {

                data.append("ID : ")
                        .append(cursor.getInt(0))
                        .append("\n");

                data.append("Name : ")
                        .append(cursor.getString(1))
                        .append("\n");

                data.append("Course : ")
                        .append(cursor.getString(2))
                        .append("\n\n");
            }

            textView.setText(data.toString());
        });
    }
}