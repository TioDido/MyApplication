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
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
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
    private TextView textViewTotal;

    private int total = 0;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMain2Binding binding;
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
        textViewTotal = findViewById(R.id.textview_total);


        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    total += 10;
                } else {
                    total -= 10;
                }
                updateTotal();
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
        textViewTotal.setText("Total: $" + total);
    }

}