package grad.unb.br.appsocial.models;

import java.sql.Date;


public class Quentinhas {

    private int     _id;
    private int     _prontas;
    private int     _emPreparo;
    private Date    _data;


    public int get_id() {return _id;}
    public void set_id(int _id) {this._id = _id;}


    public int get_prontas() {return _prontas;}
    public void set_prontas(int _prontas) {this._prontas = _prontas;}


    public int get_emPreparo() {return _emPreparo;}
    public void set_emPreparo(int _emPreparo) {this._emPreparo = _emPreparo;}


    public Date get_data() {return _data;}
    public void set_data(Date _data) {this._data = _data;}
}
