package com.example.codiacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import com.example.entities.Usuario;

public class FormLogin extends AppCompatActivity {

    private TextView text_tela_de_cadastro;
    private EditText edit_email;
    private EditText edit_password;
    private AppCompatButton bt_entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        bt_entrar = findViewById(R.id.bt_entrar);
        text_tela_de_cadastro = findViewById(R.id.text_tela_cadastro);

        bt_entrar.setOnClickListener(v -> {
            String email = edit_email.getText().toString().trim();
            String senha = edit_password.getText().toString().trim();

            if (email.isEmpty()) {
                edit_email.setError("Digita seu Email");
                return;
            }

            if (senha.isEmpty()) {
                edit_password.setError("Digita sua Senha");
                return;
            }
            Usuario usuario = FormCadastro.usuarioCadastrado;
            if (usuario != null &&
                    usuario.getEmail().equals(email) &&
                    usuario.getPassword().equals(senha)) {
                Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormLogin.this,TelaPrincipal.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
//            if (usuario != null && usuario.getEmail().equals(email) && usuario.getPassword().equals(senha)) {
//                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Sua senha ou Email teve está errado", Toast.LENGTH_SHORT).show();
//            }
        });
        text_tela_de_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormLogin.this,FormCadastro.class);
                startActivity(intent);
            }
        });
    }
    private void iniciarComponentes(){
        text_tela_de_cadastro = findViewById(R.id.text_tela_cadastro);
    }

}
