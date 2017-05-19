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
import grad.unb.br.appsocial.activities.SortPeopleListPage;
import grad.unb.br.appsocial.controllers.ListAdapterTabPage;

/**
 * A simple {@link Fragment} subclass.
 */
public class FAssisFragment extends Fragment implements ListView.OnItemClickListener{

    private TypedArray sabadoIcons;
    private String[] sabadoStrings;
    private ListView lvsabado;

    public FAssisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_planejar, container, false);

        lvsabado = (ListView) view.findViewById(R.id.lvPlanejar);

        sabadoIcons = getResources().obtainTypedArray(R.array.sabado_fragment_array_ic);
        sabadoStrings = getResources().getStringArray(R.array.sabado_fragment_array_string);

        ListAdapterTabPage adpt = new ListAdapterTabPage(getActivity(),sabadoIcons,sabadoStrings);
        lvsabado.setAdapter(adpt);
        lvsabado.setOnItemClickListener(this);


        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent saida;
        switch (sabadoStrings[position]){
            case "Escala":
                break;
            case "Cadastro dos assistidos":
                saida = new Intent(getActivity(),SortPeopleListPage.class);
                getActivity().startActivity(saida);
                break;
            default:
                break;
        }
    }
}
