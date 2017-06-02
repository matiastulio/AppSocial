package grad.unb.br.appsocial.controllers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import grad.unb.br.appsocial.models.Assistidos;
import grad.unb.br.appsocial.models.Constantes;
import grad.unb.br.appsocial.models.Usuarios;

/**
 * Created by Tulio on 02/06/2017.
 */
public class ListAdapterSortPeople extends ArrayAdapter<Object>{
    private ArrayList<Usuarios> users;
    private ArrayList<Assistidos> assistidos;
    private int _type;


    public ListAdapterSortPeople(Context context, int resource, int TYPE_OBJ, ArrayList<Assistidos> ass, ArrayList<Usuarios> usrs) {
        super(context, resource);
        this._type = TYPE_OBJ;

        if(_type==Constantes.TYPE_ASSISTIDO)
            assistidos = ass;
        else if(_type==Constantes.TYPE_USUARIO)
            usrs = users;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }
}
