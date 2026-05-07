package com.example.menudemo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.textView);
        btnPopup = findViewById(R.id.btnPopup);

        // Context Menu
        registerForContextMenu(textView);

        // Popup Menu
        btnPopup.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(this, btnPopup);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.popup_hello) {
                    textView.setText("Hello User 👋");
                } else if (item.getItemId() == R.id.popup_clear) {
                    textView.setText("");
                }
                return true;
            });

            popup.show();
        });
    }

    // Toolbar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Toolbar Menu Click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_red) {
            textView.setTextColor(Color.RED);

        } else if (id == R.id.menu_blue) {
            textView.setTextColor(Color.BLUE);

        } else if (id == R.id.menu_big) {
            textView.setTextSize(30);
        }

        return true;
    }

    // Context Menu Create
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // Context Menu Click
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.context_bold) {
            textView.setTypeface(null, Typeface.BOLD);

        } else if (item.getItemId() == R.id.context_reset) {
            textView.setText("Reset Done");
            textView.setTextSize(20);
            textView.setTextColor(Color.BLACK);
            textView.setTypeface(null, Typeface.NORMAL);
        }

        return true;
    }
}