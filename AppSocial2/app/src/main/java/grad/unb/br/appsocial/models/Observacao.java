package grad.unb.br.appsocial.models;

import android.location.Location;

import java.sql.Date;


public class Observacao {

    private int         _id;
    private String      _observacao;
    private Date        _data;
    private Location    _loc;


    public int get_id() {return _id;}
    public void set_id(int _id) {this._id = _id;}


    public String get_observacao() {return _observacao;}
    public void set_observacao(String _observacao) {this._observacao = _observacao;}


    public Date get_data() {return _data;}
    public void set_data(Date _data) {this._data = _data;}


    public Location get_loc() {return _loc;}
    public void set_loc(Location _loc) {this._loc = _loc;}
}
