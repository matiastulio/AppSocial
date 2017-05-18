package grad.unb.br.appsocial.models;

import java.sql.Date;
import java.util.Calendar;

public class Cardapio {
    private int     _id;
    private String  _cardapio;
    private Date    _data;

    public int get_id() {return _id;}
    public void set_id(int _id) {this._id = _id;}


    public String get_cardapio() {return _cardapio;}
    public void set_cardapio(String _cardapio) {this._cardapio = _cardapio;}


    public Date get_data() {return _data;}
    public void set_data(Date _data) {this._data = _data;}
}
