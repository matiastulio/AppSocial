package grad.unb.br.appsocial.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import grad.unb.br.appsocial.R;

public class LoginPage extends AppCompatActivity {

    //TODO: IMPLEMENTAR A VERIFICAÇÃO DE USUARIO
    //TODO: IMPLEMENTAR A SAIDA DESSA ACTIVITY DO STACK DE BACK
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        //getSupportActionBar().setTitle("Login");
        getSupportActionBar().hide();
    }





    public void novoCadastro(View view){
        Intent cadastroIntent = new Intent(this,CadastroPage.class);
        this.startActivity(cadastroIntent);


    }

    public void loginApply(View view){
        Intent tabActivityIntent = new Intent(this,TabActivityPage.class);
        this.startActivity(tabActivityIntent);
    }
}
