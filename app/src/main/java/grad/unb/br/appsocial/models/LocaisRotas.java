package grad.unb.br.appsocial.models;


public class LocaisRotas {

    private int     _FKLocaisAssistidos;
    private int     _FKRotas;
    private int     _posicaoRota;



    public int get_FKLocaisAssistidos() {return _FKLocaisAssistidos;}
    public void set_FKLocaisAssistidos(int _FKLocaisAssistidos) {this._FKLocaisAssistidos = _FKLocaisAssistidos;}


    public int get_FKRotas() {return _FKRotas;}
    public void set_FKRotas(int _FKRotas) {this._FKRotas = _FKRotas;}


    public int get_posicaoRota() {return _posicaoRota;}
    public void set_posicaoRota(int _posicaoRota) {this._posicaoRota = _posicaoRota;}
}