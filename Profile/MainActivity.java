package com.example.profile;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView name, role, email, phone, location, education, skill1, skill2, skill3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        role = findViewById(R.id.role);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        location = findViewById(R.id.location);
        education = findViewById(R.id.education);
        skill1 = findViewById(R.id.skill1);
        skill2 = findViewById(R.id.skill2);
        skill3 = findViewById(R.id.skill3);

        // YOUR PROFILE DATA
        name.setText("Shrutika Avinash Babhulkar");
        role.setText("Student | Android & Web Developer");

        email.setText("Email: babhulkarshrutika@gmail.com");
        phone.setText("Phone: 7758093936");
        location.setText("Location: Kolhapur, Maharashtra");

        education.setText("Pursuing BTech in Computer Science & Engineering\n"
                + "Interested in Android & Web Development");

        skill1.setText("HTML, CSS, JavaScript");
        skill2.setText("Basic Python");
        skill3.setText("Database: MySQL");
    }
}