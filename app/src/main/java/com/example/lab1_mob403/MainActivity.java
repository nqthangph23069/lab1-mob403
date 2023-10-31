package com.example.lab1_mob403;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.lab1_mob403.bai1.ActivityThread;
import com.example.lab1_mob403.bai2.SplashScreen;
import com.example.lab1_mob403.bai3.ActivityAsyncTask;
import com.example.lab1_mob403.bai4.Activitybai4;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btnBai1);
        btn2 = findViewById(R.id.btnBai2);
        btn3 = findViewById(R.id.btnBai3);
        btn4 = findViewById(R.id.btnBai4);
        btn1.setOnClickListener(v -> {
            startActivity(new Intent(this, ActivityThread.class));
        });
        btn2.setOnClickListener(v -> {
            startActivity(new Intent(this, SplashScreen.class));
        });
        btn3.setOnClickListener(v -> {
            startActivity(new Intent(this, ActivityAsyncTask.class));
        });
        btn4.setOnClickListener(v -> {
            startActivity(new Intent(this, Activitybai4.class));
        });
    }
}