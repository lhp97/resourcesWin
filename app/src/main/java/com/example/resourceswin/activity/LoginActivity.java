package com.example.resourceswin.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resourceswin.R;

public class LoginActivity extends AppCompatActivity {

    private Button botaoAcessar;
    private TextView campoUsuario, campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        configuraActionBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Chamada do inicializador de componentes
        inicializarComponentes();

        //Clique do Botao Acessar
        botaoAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = campoUsuario.getText().toString();
                String senha = campoSenha.getText().toString();

                if (!usuario.isEmpty()) {
                    if (!senha.isEmpty()) {
                        if (usuario.equals("123") && senha.equals("123")) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();

                        } else {
                            Toast.makeText(LoginActivity.this, "Erro ao fazer LOGIN", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(LoginActivity.this, "SENHA não informada!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "USUÁRIO não informado!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Método abrirDados quando o ACESSAR é clicado
    public void abrirDados(View view) {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }

    //Inicialização dos componentes de tela
    public void inicializarComponentes() {
        botaoAcessar = findViewById(R.id.btnAcessar);
        campoUsuario = findViewById(R.id.edtUsuario);
        campoSenha = findViewById(R.id.edtSenha);
    }

    public void configuraActionBar() {
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#6200EE"));

        if (actionBar != null) actionBar.setBackgroundDrawable(colorDrawable);
    }

}