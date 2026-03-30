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

import main.java.com.example.entities.Usuario;

public class FormCadastro extends AppCompatActivity {

    //Variáveis de Cadastro
    private TextInputEditText edit_name;
    private TextInputEditText edit_email;
    private TextInputEditText edit_password;
    private AppCompatButton button_CadastroUsuario;
    public static Usuario usuarioCadastrado = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_cadastro);

        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);

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
                    if(usuarioEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(usuarioEmail).matches()){
                        edit_email.setError("Digite um email válido");
                        return;
                    }

                    if(usuarioPassword.isEmpty() || usuarioPassword.length() < 6){
                        edit_password.setError("Senha deve ter pelo menos 6 caracteres");
                        return;
                    }
                    // Usuario usuario = new Usuario(
                    //     usuarioName,
                    //     usuarioEmail,
                    //     usuarioPassword
                    // );
                    usuarioCadastrado = new Usuario(usuarioName, usuarioEmail, usuarioPassword);

                    Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

                    // registerUsuario(usuario);
                    Intent intent = new Intent(FormCadastro.this, FormLogin.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}