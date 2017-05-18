package grad.unb.br.appsocial.models;

public class Usuarios {

    private int     _id;
    private int     _telefone;
    private String  _nome;
    private String  _perfil;
    private String  _email;
    private String  _senha;


    public int get_id() {return _id;}
    public void set_id(int _id) { this._id = _id;}


    public int get_telefone() {return _telefone;}
    public void set_telefone(int _telefone) {this._telefone = _telefone;}


    public String get_nome() {return _nome;}
    public void set_nome(String _nome) {this._nome = _nome;}


    public String get_perfil() {return _perfil;}
    public void set_perfil(String _perfil) {this._perfil = _perfil;}

    public String get_Email() {return _email;}
    public void set_Email(String email) {this._email = email;}


    public String get_Senha() {return _senha;}
    public void set_Senha(String senha) {this._senha = senha;}
}
