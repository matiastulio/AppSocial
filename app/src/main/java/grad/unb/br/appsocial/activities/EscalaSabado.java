package grad.unb.br.appsocial.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import grad.unb.br.appsocial.R;

public class EscalaSabado extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escala_sabado);

        toolbar = (Toolbar) findViewById(R.id.toolbar_escala_sabado);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    public void chamaSortPeople(View v) {
        Intent intent = new Intent(this, SortPeopleListPage.class);
        intent.putExtra("retorno", true);
        intent.putExtra("idDaView", v.getId());
        startActivityForResult(intent, 1);

    }


    private void retornoIntent(Intent data) {
        String resultado = data.getStringExtra("resultado");
        int idDaView = data.getIntExtra("idDaView", -1);
        TextView v;
        switch (idDaView) {
            case R.id.escala_sabado_LL1:
                v = (TextView) findViewById(R.id.escala_sabado_l1);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL2:
                v = (TextView) findViewById(R.id.escala_sabado_l2);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL3:
                v = (TextView) findViewById(R.id.escala_sabado_l3);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL4:
                v = (TextView) findViewById(R.id.escala_sabado_l4);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL5:
                v = (TextView) findViewById(R.id.escala_sabado_l5);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL6:
                v = (TextView) findViewById(R.id.escala_sabado_l6);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL7:
                v = (TextView) findViewById(R.id.escala_sabado_l7);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL8:
                v = (TextView) findViewById(R.id.escala_sabado_l8);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL9:
                v = (TextView) findViewById(R.id.escala_sabado_l9);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL10:
                v = (TextView) findViewById(R.id.escala_sabado_l10);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL11:
                v = (TextView) findViewById(R.id.escala_sabado_l11);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL12:
                v = (TextView) findViewById(R.id.escala_sabado_l12);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL13:
                v = (TextView) findViewById(R.id.escala_sabado_l13);
                v.setText(resultado);
                break;
            case R.id.escala_sabado_LL14:
                v = (TextView) findViewById(R.id.escala_sabado_l14);
                v.setText(resultado);
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.escala_sexta_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                retornoIntent(data);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }
}
