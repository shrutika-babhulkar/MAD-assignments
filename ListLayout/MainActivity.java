package com.example.listlayout;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] foodItems = {
            "Pizza ", "Burger ", "Pasta ",
            "Sandwich ", "Fries ", "Ice Cream ",
            "Biryani ", "Dosa "
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Customizing adapter directly
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                foodItems
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView text = (TextView) view.findViewById(android.R.id.text1);

                // Change text color & style
                text.setTextColor(Color.BLACK);
                text.setTextSize(18);
                text.setPadding(20, 20, 20, 20);

                return view;
            }
        };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String item = foodItems[position];
            Toast.makeText(MainActivity.this,
                    "You selected: " + item,
                    Toast.LENGTH_SHORT).show();
        });
    }
}