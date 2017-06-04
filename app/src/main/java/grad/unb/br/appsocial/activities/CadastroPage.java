package grad.unb.br.appsocial.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import grad.unb.br.appsocial.R;
import grad.unb.br.appsocial.models.Usuarios;

public class CadastroPage extends AppCompatActivity {


    //TODO: IMPLEMENTAR O BOTAO DE CADASTRO DE USUARIO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_page);

        getSupportActionBar().setTitle("Cadastrar");

    }

    public void validateAndAddUser(View v){
        EditText nome,telefone,email,senha,senhaCon;
        Spinner spin;

        nome        = (EditText)   findViewById(R.id.edtTxt_nome_cadastro);
        telefone    = (EditText)   findViewById(R.id.edtTxt_telefone_cadastro);
        email       = (EditText)   findViewById(R.id.edtTxt_email_cadastro);
        senha       = (EditText)   findViewById(R.id.edtTxt_senha_cadastro);
        senhaCon    = (EditText)   findViewById(R.id.edtTxt_senha_con_cadastro);
        spin        = (Spinner)    findViewById(R.id.spin_perfil);


        if(senha.getText().toString().compareTo(senhaCon.getText().toString()) == 0){
            Usuarios usr = new Usuarios(nome.getText().toString(),telefone.getText().toString(),email.getText().toString(),senha.getText().toString(),spin.getSelectedItem().toString());
            Log.d("Foi"," ");
            //SALVAR NO BD

        }else {
            Log.d("Senha: ",""+senha.getText().toString());
            Log.d("'Senha Con: ",""+senhaCon.getText().toString());
        }


    }
}
