package grad.unb.br.appsocial.controllers;

import android.app.Activity;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import grad.unb.br.appsocial.R;

public class ListAdapterTabPage extends ArrayAdapter<String> {

    private final Activity Context;
    private final String[] ListItemsName;
    private final TypedArray ImageName;

    public ListAdapterTabPage(Activity context, TypedArray content, String[] ImageName) {

        super(context, R.layout.list_view_row_tab_page, ImageName);

        this.Context = context;
        this.ListItemsName = ImageName;
        this.ImageName = content;
    }

    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = Context.getLayoutInflater();
        View ListViewSingle = inflater.inflate(R.layout.list_view_row_tab_page, null, true);

        TextView ListViewItems = (TextView) ListViewSingle.findViewById(R.id.row_TxtV);
        ImageView ListViewImage = (ImageView) ListViewSingle.findViewById(R.id.row_imV);

        ListViewItems.setText(ListItemsName[position]);
        ListViewImage.setImageDrawable(ImageName.getDrawable(position));
        return ListViewSingle;

    };



}