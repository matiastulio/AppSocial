package grad.unb.br.appsocial.models;


import android.location.Location;

import java.sql.Date;

public class LocaisAssistidos {
    private int         _id;
    private Location    _loc;
    private Date        _data;
    private String      _obs;


    public int get_id() {return _id;}
    public void set_id(int _id) {this._id = _id;}


    public Location get_loc() {return _loc;}
    public void set_loc(Location _loc) {this._loc = _loc;}


    public Date get_data() {return _data;}
    public void set_data(Date _data) {this._data = _data;}


    public String get_obs() {return _obs;}
    public void set_obs(String _obs) {this._obs = _obs;}
}
