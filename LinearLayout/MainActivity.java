package com.example.linear_layout;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button loginBtn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        result = findViewById(R.id.result);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("admin") && pass.equals("1234")){
                    result.setText("Login Successful ✅");
                    result.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                } else {
                    result.setText("Invalid Credentials ❌");
                    result.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }

            }
        });
    }
}