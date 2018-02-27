package com.example.chads.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class AboutMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        final String[] secrets = {"I like turtles", "42", "Peanut butter is the root of all evil", "LOCKDOWN CODE: 1A9E7-4A9Q", "I am indifferent to those who prefer preference over indifference"};


        Button btnSecret = (Button) findViewById(R.id.btn_secret);
        btnSecret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int r = new Random().nextInt(5); // [0, 4]
                Toast.makeText(getApplicationContext(), secrets[r], Toast.LENGTH_LONG).show();
            }
        });

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutMeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
