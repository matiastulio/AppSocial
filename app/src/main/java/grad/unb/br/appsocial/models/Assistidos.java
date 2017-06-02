package grad.unb.br.appsocial.models;


import java.sql.Date;

public class Assistidos implements  Comparable<Assistidos>{
    private int     _id;
    private char    _sexo;
    private String  _nome;
    private String  _relPablo;
    private String  _observacao;
    private String  _assMedica;
    private String  _assSocial;
    private Date    _data;
    private int     _tmCalcado;
    private int     _tmCamisa;
    private int     _tmCalca;
    private int     _idade;

    public Assistidos(String nome){
        this._nome = nome;
    }

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

    public int get_id() { return _id;  }
    public void set_id(int _id) {    this._id = _id;}

    public char get_sexo() {        return _sexo;}
    public void set_sexo(char _sexo) {        this._sexo = _sexo;}

    public String get_assMedica() {        return _assMedica;}
    public void set_assMedica(String _assMedica) {        this._assMedica = _assMedica;}

    public String get_assSocial() {        return _assSocial;}
    public void set_assSocial(String _assSocial) {        this._assSocial = _assSocial;}

    public int get_idade() {        return _idade;}
    public void set_idade(int _idade) {        this._idade = _idade;}


    @Override
    public String toString() {
        return this._nome;
    }

    @Override
    public int compareTo(Assistidos another) {
        return this._nome.compareTo(another.get_nome());
    }
}
