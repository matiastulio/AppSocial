package grad.unb.br.appsocial.models;


import java.sql.Date;

public class Kits {
    private int     _id;
    private int     _qtd;
    private String  _nome;
    private Date    _data;


    public int get_id() {return _id;}
    public void set_id(int _id) {this._id = _id;}


    public int get_qtd() {return _qtd;}
    public void set_qtd(int _qtd) {this._qtd = _qtd;}


    public String get_nome() {return _nome;}
    public void set_nome(String _nome) {this._nome = _nome;}


    public Date get_data() {return _data;}
    public void set_data(Date _data) {this._data = _data;}
}
