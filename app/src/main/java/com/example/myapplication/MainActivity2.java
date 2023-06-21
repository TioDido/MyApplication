package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private TextView tbNome, tbSenha;

    private CheckBox checkBox1;

    private CheckBox checkBox2;

    private CheckBox checkBox3;

    private CheckBox checkBox4;

    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private TextView textViewTotal;
    private TextView textViewTotal2;

    private TextView textViewTotal3;
    private int total = 0;
    private int total2 =0;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMain2Binding binding;

    private Button calcularTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain2.toolbar);
        binding.appBarMain2.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        tbNome = findViewById(R.id.tbNomee);
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        tbNome.setText(nome);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);
        checkBox5 = findViewById(R.id.checkbox5);
        checkBox6 = findViewById(R.id.checkbox6);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewTotal2 = findViewById(R.id.textViewTotal2);
        textViewTotal3 = findViewById(R.id.textViewTotal3);
        calcularTotal  = findViewById(R.id.calcTotal);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    total += 10;
                } else {
                    total -= 10;
                }
                updateTotal();
                updateTotal3();
            }
        });



        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    total += 20;
                } else {
                    total -= 20;
                }
                updateTotal();
                updateTotal3();
            }
        });




        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    total += 30;
                } else {
                    total -= 30;
                }
                updateTotal();
                updateTotal3();
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    total2 += 10;
                } else {
                    total2 -= 10;
                }
                updateTotal2();
                updateTotal3();
            }
        });

        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {
                    total2 += 20;
                } else {
                    total2 -= 20;
                }
                updateTotal2();
                updateTotal3();
            }
        });

        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {
                    total2 += 30;
                } else {
                    total2 -= 30;
                }
                updateTotal2();
                updateTotal3();
            }
        });


        calcularTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                int somaTotal = total + total2; // Substitua pelo valor que deseja passar para a próxima tela
                intent.putExtra("nome", nome);
                intent.putExtra("somaTotal", somaTotal);
                // Iniciar a nova atividade
                startActivity(intent);
            }
        });




        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;


    }


    @Override
    public boolean onSupportNavigateUp() {

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }

    private void updateTotal() {
        textViewTotal.setText("Total em Quarto: $" + total);
    }
    private void updateTotal2() {
        textViewTotal2.setText("Total em Serviços: $" + total2);
    }

    private void updateTotal3() {
        int somaTotal = total + total2;
        textViewTotal3.setText("Acumulo de serviço(s) prestado(s): $" + somaTotal );
    }










}