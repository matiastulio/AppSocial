package grad.unb.br.appsocial.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;

import grad.unb.br.appsocial.R;

public class GenericCardViewPage extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_cardview_page);
        Bundle extras = getIntent().getExtras();

        int tipo = -1;
        if (extras != null) {
            tipo = extras.getInt("tipo");
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar_isopor_planejar);
        if(tipo==1) {
            toolbar.setTitle("Isopor");
            ListView lv = (ListView) findViewById(R.id.lvGenericCardview);
            lv.setClickable(false);
            lv.setDivider(null);
            lv.setDividerHeight(0);
            lv.setSelector(android.R.color.transparent);
//
//            android:clickable="false"
//            android:dividerHeight="0dp"
//            android:divider="@null"
//            android:contextClickable="false"
//            android:listSelector="@android:color/transparent"

        }else if (tipo==2) {
            toolbar.setTitle("Visualizar Roteiros");

}else
            toolbar.setTitle("Ta errado isso ai");


        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.generic_cardview_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
