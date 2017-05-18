package grad.unb.br.appsocial.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import grad.unb.br.appsocial.R;

public class SortPeopleListPage extends AppCompatActivity {

    private ListView lvSortedPeople;
    private String[] peoples1,peoples2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_people_list_view);


        lvSortedPeople = (ListView) findViewById(R.id.lvSortedPeople);

        peoples1 = getResources().getStringArray(R.array.planejar_fragment_array_string);
        peoples2 = getResources().getStringArray(R.array.roteiro_fragment_array_string);

        ArrayList<String> peoples = new ArrayList<String>();
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
    }
}
