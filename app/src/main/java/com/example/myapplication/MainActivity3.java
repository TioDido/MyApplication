package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity3 extends AppCompatActivity {
    private TextView textViewResultado;

    private TextView tntNome;

    private TextView tntSomaTotal;
    Button button;

    Button buttonCancel;



    private  int somaTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Intent intent = getIntent();
        tntSomaTotal = findViewById(R.id.tntSomaTotal);
        tntNome = findViewById(R.id.tntNome);
        String nome = intent.getStringExtra("nome");
        int somaTotal = intent.getIntExtra("somaTotal", 0);
        tntNome.setText(nome);
        buttonCancel = findViewById(R.id.cancelade);
        button = findViewById(R.id.buttonxd);
        tntSomaTotal.setText(String.valueOf(somaTotal));





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("somaTotal", somaTotal);
                startActivity(intent);
            }
        });


        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Fecha a activity atual e retorna à activity anterior
            }
        });
    }
    }
