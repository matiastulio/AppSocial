package grad.unb.br.appsocial.models;


import java.sql.Date;

public class Assistidos {
    private String  _nome;
    private String  _relPablo;
    private String  _observacao;
    private Date    _data;
    private int     _tmCalcado;
    private int     _tmCamisa;
    private int     _tmCalca;


    public String get_nome() { return _nome;}
    public void set_nome(String _nome) {this._nome = _nome;}


    public Date get_data() { return _data;}
    public void set_data(Date _data) {this._data = _data;}


    public String get_relPablo() {return _relPablo;}
    public void set_relPablo(String _relPablo) {this._relPablo = _relPablo;}


    public String get_observacao() {return _observacao;}
    public void set_observacao(String _observacao) {this._observacao = _observacao;}


    public int get_tmCalcado() {return _tmCalcado;}
    public void set_tmCalcado(int _tmCalcado) {this._tmCalcado = _tmCalcado;}


    public int get_tmCamisa() {return _tmCamisa; }
    public void set_tmCamisa(int _tmCamisa) {this._tmCamisa = _tmCamisa;}


    public int get_tmCalca() { return _tmCalca;}
    public void set_tmCalca(int _tmCalca) {this._tmCalca = _tmCalca;}

}
