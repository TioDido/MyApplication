package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText txtNome, txtSenha;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.tbNome);
        txtSenha = findViewById(R.id.tbSenha);
        btnCalcular = findViewById(R.id.btn_Next);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nome = txtNome.getText().toString();
                    String senha = txtSenha.getText().toString();

                    if (TextUtils.isEmpty(senha)) {
                        Toast.makeText(MainActivity.this, "Senha vazia? Aí complica.", Toast.LENGTH_SHORT).show();
                        return; // Retorna sem prosseguir com o restante do código
                    }

                    if (isNumeric(nome)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Cuidado, burrão!");
                        builder.setMessage("Por mais que entendemos de diversidade, admitimos que ainda não foi descoberto nenhum nome numérico.");
                        builder.setPositiveButton("OK", null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        return; // Retorna sem prosseguir com o restante do código
                    }

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("senha", senha);
                    startActivity(intent);

                } catch (NumberFormatException e) {
                    // Tratamento para erro de conversão do campo de senha
                    // Por exemplo, caso o usuário insira um valor não numérico
                    e.printStackTrace();

                } catch (Exception e) {
                    // Tratamento genérico de exceção
                    // Aqui você pode exibir uma mensagem de erro para o usuário
                    // ou realizar outras ações apropriadas
                    e.printStackTrace();
                }
            }
        });
    }

    private boolean isNumeric(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


