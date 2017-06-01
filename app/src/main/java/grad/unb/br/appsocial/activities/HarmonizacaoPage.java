package grad.unb.br.appsocial.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import grad.unb.br.appsocial.R;

public class HarmonizacaoPage extends AppCompatActivity {

    //TODO: IMPLEMENTAR O BOTAO DE ADICIONAR PARA A SEMANA
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harmonizacao_page);


        toolbar = (Toolbar) findViewById(R.id.toolbar_harmonizacao_page);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    public void checkBoxClickado(View v){
        LinearLayout ll = (LinearLayout) v;
        CheckBox cb = (CheckBox) ll.getChildAt(1);

        if(cb.isChecked())
            cb.setChecked(false);
        else
            cb.setChecked(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_add_people){
//            LinearLayout ll = new LinearLayout(this);
//            ll.setOrientation(LinearLayout.HORIZONTAL);
//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//            ll.setLayoutParams(lp);


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.generic_cardview_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
