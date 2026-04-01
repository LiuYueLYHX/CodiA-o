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

public class FormCadastro extends AppCompatActivity {

    //Variáveis de Cadastro
    private EditText edit_name;
    private EditText edit_email;
    private EditText edit_password;
    private AppCompatButton button_CadastroUsuario;

    private TextView text_tela_login;
    public static Usuario usuarioCadastrado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_cadastro);

        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);

        text_tela_login = findViewById(R.id.text_tela_login);

        button_CadastroUsuario = findViewById(R.id.button_CadastroUsuario);

        button_CadastroUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String usuarioName = edit_name.getText().toString();
                String usuarioEmail = edit_email.getText().toString();
                String usuarioPassword = edit_password.getText().toString();
                try{
                    if(usuarioName.isEmpty()){
                        edit_name.setError("Digite seu nome");
                        return;
                    }
                    if(usuarioEmail.isEmpty()){
                        edit_email.setError("Digite um email válido");
                        return;
                    }

                    if(usuarioPassword.isEmpty() || usuarioPassword.length() < 6){
                        edit_password.setError("Senha deve ter pelo menos 6 caracteres");
                        return;
                    }

                    usuarioCadastrado = new Usuario(usuarioEmail, usuarioPassword);


                    // registerUsuario(usuario);
                    Intent intent = new Intent(FormCadastro.this, FormLogin.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        text_tela_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormCadastro.this,FormLogin.class);
                startActivity(intent);
            }
        });
    }
}