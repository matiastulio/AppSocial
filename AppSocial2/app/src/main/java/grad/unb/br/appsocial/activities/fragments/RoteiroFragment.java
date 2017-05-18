package grad.unb.br.appsocial.activities.fragments;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import grad.unb.br.appsocial.R;
import grad.unb.br.appsocial.activities.MapsActivity;
import grad.unb.br.appsocial.activities.SortPeopleListPage;
import grad.unb.br.appsocial.controllers.ListAdapterTabPage;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoteiroFragment extends Fragment implements ListView.OnItemClickListener{

    private TypedArray roteiroIcons;
    private String[] roteiroStrings;
    private ListView lvRoteiro;

    public RoteiroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planejar, container, false);

        lvRoteiro = (ListView) view.findViewById(R.id.lvPlanejar);

        roteiroIcons = getResources().obtainTypedArray(R.array.roteiro_fragment_array_ic);
        roteiroStrings = getResources().getStringArray(R.array.roteiro_fragment_array_string);

        ListAdapterTabPage adpt = new ListAdapterTabPage(getActivity(),roteiroIcons,roteiroStrings);
        lvRoteiro.setAdapter(adpt);
        lvRoteiro.setOnItemClickListener(this);



        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent saida;

        switch (roteiroStrings[position]){
            case "Quentinhas":
                break;
            case "Escala":
                break;
            case "Montar roteiro":
                saida = new Intent(getActivity(),MapsActivity.class);
                getActivity().startActivity(saida);
                break;
            case "Visualizar roteiros":
                break;
            default:
                break;
        }

    }
}
