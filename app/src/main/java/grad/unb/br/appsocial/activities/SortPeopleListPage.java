package grad.unb.br.appsocial.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import grad.unb.br.appsocial.R;

public class SortPeopleListPage extends AppCompatActivity {

    private ListView lvSortedPeople;
    private String[] peoples1,peoples2;
    private boolean retorno = false;
    private String retornoString = "";
    private int itemSelecionado = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_people_list_view);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            retorno = extras.getBoolean("retorno");
            itemSelecionado = extras.getInt("itemSelecionado");
        }


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_sort_people_list_view);
        toolbar.setTitle("Escolha");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        lvSortedPeople = (ListView) findViewById(R.id.lvSortedPeople);

        peoples1 = getResources().getStringArray(R.array.planejar_fragment_array_string);
        peoples2 = getResources().getStringArray(R.array.roteiro_fragment_array_string);

        final ArrayList<String> peoples = new ArrayList<String>();
        peoples.addAll(Arrays.asList(peoples1));
        peoples.addAll(Arrays.asList(peoples2));

        Collections.sort(peoples, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        });

        ArrayAdapter<String> laPeoples = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,peoples);

        lvSortedPeople.setAdapter(laPeoples);
        lvSortedPeople.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lvSortedPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                retornoString = peoples.get(position);
                toolbar.setTitle(retornoString);
            }
        });

    }



    public boolean onCreateOptionsMenu(Menu menu) {
        if(retorno)
            getMenuInflater().inflate(R.menu.sort_people_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onSupportNavigateUp() {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.finish_sort_people_activity){
            if(retorno){
                Intent returnIntent = new Intent();
                returnIntent.putExtra("resultado",retornoString);
                returnIntent.putExtra("itemSelecionado",itemSelecionado);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
        }

        return super.onOptionsItemSelected(item);
    }
}
