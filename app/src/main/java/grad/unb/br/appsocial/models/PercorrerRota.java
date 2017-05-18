package grad.unb.br.appsocial.models;

public class PercorrerRota {

    private int     _id;
    private int     _FKrota;
    private int     _FKLocaisAssistidos;
    private int     _qtdComida;
    private int     _qtdCobertor;


    public int get_id() {return _id;}
    public void set_id(int _id) {this._id = _id;}


    public int get_FKrota() {return _FKrota;}
    public void set_FKrota(int _FKrota) {this._FKrota = _FKrota;}


    public int get_FKLocaisAssistidos() {return _FKLocaisAssistidos;}
    public void set_FKLocaisAssistidos(int _FKLocaisAssistidos) {this._FKLocaisAssistidos = _FKLocaisAssistidos;}


    public int get_qtdComida() {return _qtdComida;}
    public void set_qtdComida(int _qtdComida) {this._qtdComida = _qtdComida;}


    public int get_qtdCobertor() {return _qtdCobertor;}
    public void set_qtdCobertor(int _qtdCobertor) {this._qtdCobertor = _qtdCobertor;}
}
