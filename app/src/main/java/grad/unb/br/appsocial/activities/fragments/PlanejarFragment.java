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
import android.widget.Toast;

import grad.unb.br.appsocial.R;
import grad.unb.br.appsocial.activities.AvisoPlanejarPage;
import grad.unb.br.appsocial.activities.EscalaSexta;
import grad.unb.br.appsocial.activities.GenericCardViewPage;
import grad.unb.br.appsocial.controllers.ListAdapterTabPage;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanejarFragment extends Fragment implements ListView.OnItemClickListener {

    private TypedArray planejarIcons;
    private String[] planejarStrings;
    private ListView lvPlanejar;

    public PlanejarFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_planejar, container, false);

        lvPlanejar = (ListView) view.findViewById(R.id.lvPlanejar);

        planejarIcons = getResources().obtainTypedArray(R.array.planejar_fragment_array_ic);
        planejarStrings = getResources().getStringArray(R.array.planejar_fragment_array_string);

        ListAdapterTabPage adpt = new ListAdapterTabPage(getActivity(),planejarIcons,planejarStrings);
        lvPlanejar.setAdapter(adpt);
        lvPlanejar.setOnItemClickListener(this);




        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this.getActivity(),planejarStrings[position], Toast.LENGTH_SHORT).show();
        Intent saida;
        //Intent saida = new Intent(getActivity(),grad.unb.br.appsocial.activities.SortPeopleListPage.class);
        //getActivity().startActivity(saida);

        switch (planejarStrings[position]){
            case "Enviar Aviso":
                saida = new Intent(getActivity(), AvisoPlanejarPage.class);
                getActivity().startActivity(saida);
                break;
            case "Escala":
                saida = new Intent(getActivity(), EscalaSexta.class);
                getActivity().startActivity(saida);
                break;
            case "Isopor":
                saida = new Intent(getActivity(), GenericCardViewPage.class);
                saida.putExtra("tipo",1);
                getActivity().startActivity(saida);
                break;
            case"Visualizar roteiros":
                saida = new Intent(getActivity(), GenericCardViewPage.class);
                saida.putExtra("tipo",2);
                getActivity().startActivity(saida);
                break;
            default:
                break;
        }


    }

}
