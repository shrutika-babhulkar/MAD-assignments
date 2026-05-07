package com.example.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.*;
import android.widget.*;

public class MyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my, container, false);

        EditText input = view.findViewById(R.id.inputName);
        Button btn = view.findViewById(R.id.btnShow);
        TextView result = view.findViewById(R.id.resultText);

        btn.setOnClickListener(v -> {

            String name = input.getText().toString().trim();

            if (name.isEmpty()) {
                result.setText("⚠ Please enter your name");
            } else {
                result.setText("Hello " + name + "\nWelcome to Fragment UI!");
            }
        });

        return view;
    }
}