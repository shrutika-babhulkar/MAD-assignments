package com.example.implicitintent_services;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnBrowser, btnMap, btnCall, btnContacts, btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowser = findViewById(R.id.btnBrowser);
        btnMap = findViewById(R.id.btnMap);
        btnCall = findViewById(R.id.btnCall);
        btnContacts = findViewById(R.id.btnContacts);
        btnCamera = findViewById(R.id.btnCamera);


        btnBrowser.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        btnMap.setOnClickListener(view -> {
            Uri location = Uri.parse("geo:0,0");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            startActivity(mapIntent);
        });
        btnCall.setOnClickListener(view->{
            Intent dial=new Intent(Intent.ACTION_DIAL);
            dial.setData(Uri.parse("tel: 7758093936"));
            startActivity(dial);
        });

        btnContacts.setOnClickListener(view -> {
            Intent contactIntent = new Intent(Intent.ACTION_PICK);
            contactIntent.setType("vnd.android.cursor.dir/contact");
            startActivity(contactIntent);
        });

        btnCamera.setOnClickListener(view -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(cameraIntent);
        });
    }
}