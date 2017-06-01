package grad.unb.br.appsocial.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import grad.unb.br.appsocial.R;

public class CadastroPage extends AppCompatActivity {


    //TODO: IMPLEMENTAR O BOTAO DE CADASTRO DE USUARIO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_page);

        getSupportActionBar().setTitle("Cadastrar");

    }
}
