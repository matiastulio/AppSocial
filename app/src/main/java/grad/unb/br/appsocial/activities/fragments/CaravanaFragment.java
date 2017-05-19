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
public class CaravanaFragment extends Fragment implements AdapterView.OnItemClickListener {


    private TypedArray sextaIcons;
    private String[] sextaStrings;
    private ListView lvsexta;

    public CaravanaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_planejar, container, false);

        lvsexta = (ListView) view.findViewById(R.id.lvPlanejar);

        sextaIcons = getResources().obtainTypedArray(R.array.sexta_fragment_array_ic);
        sextaStrings = getResources().getStringArray(R.array.sexta_fragment_array_string);

        ListAdapterTabPage adpt = new ListAdapterTabPage(getActivity(),sextaIcons,sextaStrings);
        lvsexta.setAdapter(adpt);
        lvsexta.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent saida;
        switch (sextaStrings[position]){
            case "Visualizar roteiros":
                saida = new Intent(getActivity(),MapsActivity.class);
                getActivity().startActivity(saida);
                break;
            case "Cadastro dos assistidos":
                saida = new Intent(getActivity(),SortPeopleListPage.class);
                getActivity().startActivity(saida);
                break;
            case "Harmonização":
                break;
            default:
                break;
        }
    }
}
