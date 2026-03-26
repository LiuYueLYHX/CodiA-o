package com.example.codiacao;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class FormCadastro extends AppCompatActivity {

    //Variáveis de Cadastro
    private TextInputEditText edit_name;
    private TextInputEditText edit_email;
    private TextInputEditText edit_senha;
    private AppCompatButton button_CadastroUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_cadastro);

        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);

        button_CadastroUsuario = findViewById(R.id.button_CadastroUsuario);

        button_CadastroUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String usuarioName = edit_name.getText().toString();
                String usuarioEmail = edit_email.getText().toString();
                String usuarioSenha = edit_senha.getText().toString();
                try{
                    if(usuarioName.isEmpty()){
                        edit_name.setError("Digite seu nome");
                        return;
                    }
                    // Usuario usuario = new Usuario(
                    //     usuarioName,
                    //     usuarioEmail,
                    //     usuarioSenha
                    // );
                    // registerUsuario(usuario);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}