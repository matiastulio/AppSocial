package grad.unb.br.appsocial.activities;

import android.app.Activity;
import android.content.Context;
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
import grad.unb.br.appsocial.models.Assistidos;
import grad.unb.br.appsocial.models.Constantes;
import grad.unb.br.appsocial.models.Usuarios;

public class SortPeopleListPage extends AppCompatActivity {

    private ListView lvSortedPeople;
    private String[] peoples1,peoples2;
    private boolean retorno = false;
    private String retornoString = "";
    private int itemSelecionado = -1;
    private int idDaView=-1;
    private Context contexto;
    private Toolbar toolbar;
    private ArrayList<Usuarios> usrs;
    private ArrayList<Assistidos> assistidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_people_list_view);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            retorno = extras.getBoolean("retorno");
            itemSelecionado = extras.getInt("itemSelecionado");
            idDaView = extras.getInt("idDaView");
//            usrs                = extras.get
        }


        toolbar = (Toolbar) findViewById(R.id.toolbar_sort_people_list_view);
        //toolbar.setTitle(String.valueOf(idDaView));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        lvSortedPeople = (ListView) findViewById(R.id.lvSortedPeople);

        sortPeopleMethod(Constantes.TYPE_USUARIO);

        contexto = this;

    }


    public void sortPeopleMethod(int objectType){
        if(objectType == Constantes.TYPE_ASSISTIDO){

            assistidos = new ArrayList<>();

            assistidos.add(new Assistidos("foo "+50));
            for(int i=0;i<10;i++)
                assistidos.add(new Assistidos("foo"+i));

            Collections.sort(assistidos);
            ArrayAdapter<Assistidos> adpt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,assistidos);
            lvSortedPeople.setAdapter(adpt);

        }else if(objectType == Constantes.TYPE_USUARIO){

            usrs = new ArrayList<>();

            usrs.add(new Usuarios("foo "+50));
            for(int i=0;i<10;i++)
                usrs.add(new Usuarios("foo"+i));

            Collections.sort(usrs);
            ArrayAdapter<Usuarios> adpt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,usrs);
            lvSortedPeople.setAdapter(adpt);

        }else if (objectType == Constantes.TYPE_STRING_ARRAY){

            peoples1 = getResources().getStringArray(R.array.planejar_fragment_array_string);
            peoples2 = getResources().getStringArray(R.array.roteiro_fragment_array_string);

            final ArrayList<String> peoples = new ArrayList<>();
            peoples.addAll(Arrays.asList(peoples1));
            peoples.addAll(Arrays.asList(peoples2));

//            Collections.sort(peoples, new Comparator<String>() {
//                @Override
//                public int compare(String lhs, String rhs) {
//                    return lhs.compareTo(rhs);
//                }
//            });

            Collections.sort(peoples);
            ArrayAdapter<String> laPeoples = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,peoples);

            lvSortedPeople.setAdapter(laPeoples);
            lvSortedPeople.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            lvSortedPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    retornoString = peoples.get(position);
                    if(retorno)
                        toolbar.setTitle(retornoString);
                }
            });
        }

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        if(retorno)
            getMenuInflater().inflate(R.menu.sort_people_toolbar,menu);
        else
            getMenuInflater().inflate(R.menu.generic_cardview_toolbar,menu);
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
                returnIntent.putExtra("idDaView",idDaView);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
        }else if(item.getItemId() == R.id.action_add_people){
            chamaActivity();
        }

        return super.onOptionsItemSelected(item);
    }


    private void chamaActivity(){
        Intent saida = new Intent(contexto,CadastroAssistidoPage.class);
        contexto.startActivity(saida);

    }
}
