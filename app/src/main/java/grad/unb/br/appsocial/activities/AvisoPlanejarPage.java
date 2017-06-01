package grad.unb.br.appsocial.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Spinner;

import grad.unb.br.appsocial.R;

public class AvisoPlanejarPage extends AppCompatActivity {

    private Toolbar toolbar;


    //TODO: IMPLEMENTAR O BOTAO DE ENVIAR O AVISO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejar_aviso_page);


        toolbar = (Toolbar) findViewById(R.id.toolbarAvisoPlanejar);
        toolbar.setTitle("Enviar Aviso");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.planejar_aviso_action_bar,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
