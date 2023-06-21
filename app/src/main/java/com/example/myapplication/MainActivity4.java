package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView finalResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

            finalResult = findViewById(R.id.finalResult);
            Intent intent = getIntent();
            int somaTotal = intent.getIntExtra("somaTotal", 0);
            finalResult.setText(String.valueOf(somaTotal));
    }
}