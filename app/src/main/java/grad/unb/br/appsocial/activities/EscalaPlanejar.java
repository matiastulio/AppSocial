package grad.unb.br.appsocial.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.Calendar;
import java.util.Date;

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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
