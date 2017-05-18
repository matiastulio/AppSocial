package grad.unb.br.appsocial.models;

import java.sql.Date;


public class Rotas {
    private int     _id;
    private String  _lider;
    private Date    _data;


    public int get_id() {return _id;}
    public void set_id(int _id) {this._id = _id;}


    public String get_lider() {return _lider;}
    public void set_lider(String _lider) {this._lider = _lider;}


    public Date get_data() {return _data;}
    public void set_data(Date _data) {this._data = _data;}
}
