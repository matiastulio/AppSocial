package grad.unb.br.appsocial.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

import grad.unb.br.appsocial.R;

public class EscalaPlanejar extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escala_planejar);

        toolbar = (Toolbar) findViewById(R.id.toolbar_escala_planejar);
        toolbar.setTitle(setupTitle());
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    private String setupTitle() {
        Calendar c = Calendar.getInstance();
//        Date d = c.getTime();
        int i = c.get(Calendar.DAY_OF_MONTH);
        i++;
        String s;
        int aux = c.get(Calendar.WEEK_OF_YEAR);

        aux*=7;
        c.set(Calendar.DAY_OF_YEAR,aux);
        i = c.get(Calendar.DAY_OF_WEEK);
//        s= c.get(Calendar.DAY_OF_WEEK)+", "+ i +"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR);

        switch (i){
            case 0: s = "Domingo"; break;
            case 1: s = "Segunda"; break;
            case 2: s = "Terça";   break;
            case 3: s = "Quarta";  break;
            case 4: s = "Quinta";  break;
            case 5: s = "Sexta";   break;
            case 6: s = "Sabado";  break;
            default:s = "";
        }
        return s;
    }

    public void coordenadorSexta(View v){
        Intent intent = new Intent(this,SortPeopleListPage.class);
        intent.putExtra("retorno",true);
        intent.putExtra("itemSelecionado",1);
        startActivityForResult(intent, 1);

    }
    public void coordenadorRoteiro1(View v){

    }
    public void coordenadorRoteiro2(View v){

    }
    public void voluntariosSexta(View v){

    }
    public void responsavelHarmonizacao(View v){

    }

    private void retornoIntent(Intent data){
        String resultado = data.getStringExtra("resultado");
        int opcaoSelecionada = data.getIntExtra("itemSelecionado",-1);
        TextView v;
        switch (opcaoSelecionada){
            case 1:
                v = (TextView) findViewById(R.id.escala_planejar_l1);
                v.setText(resultado);
                break;
            case 2:
                v = (TextView) findViewById(R.id.escala_planejar_l1);
                v.setText(resultado);
                break;
            case 3:
                v = (TextView) findViewById(R.id.escala_planejar_l1);
                v.setText(resultado);
                break;
            case 4:
                v = (TextView) findViewById(R.id.escala_planejar_l1);
                v.setText(resultado);
                break;
            case 5:
                v = (TextView) findViewById(R.id.escala_planejar_l1);
                v.setText(resultado);
                break;
            default:
                break;
        }
        toolbar.setTitle(resultado);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.escala_planejar_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                retornoIntent(data);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }
}
