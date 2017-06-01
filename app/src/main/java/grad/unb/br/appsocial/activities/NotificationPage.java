package grad.unb.br.appsocial.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import grad.unb.br.appsocial.R;

public class NotificationPage extends AppCompatActivity {

    private Toolbar toolbar;
    private String[] sabadoStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_page);

        toolbar = (Toolbar) findViewById(R.id.toolbar_notification_page);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Notificações");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        sabadoStrings = getResources().getStringArray(R.array.sabado_fragment_array_string);


        //TODO: ARRUMUMAR O TAMANHO DO TEXTO DA LISTVIEW
        //TODO: UTILIZAR O OBJETO DE NOTIFICACAO PARA POPULAR O DIALOG
        //TODO: CRIAR UM CUSTOM ADAPTER PARA A LISTVIEW


        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sabadoStrings);

        ListView lv = (ListView) findViewById(R.id.lvNotificationPage);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(NotificationPage.this,android.support.v7.appcompat.R.style.Base_Theme_AppCompat_Light_Dialog);
                builder.setTitle(sabadoStrings[position]);
                builder.setMessage(sabadoStrings[position]+1);
                builder.setPositiveButton("OK", null);
                AppCompatDialog dialog = builder.create();
                dialog.show();
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
