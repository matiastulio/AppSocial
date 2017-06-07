package grad.unb.br.appsocial.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import grad.unb.br.appsocial.Manifest;
import grad.unb.br.appsocial.R;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Toolbar toolbar;
    private boolean isFABOpen;
    private FloatingActionButton fabObs,fabVol,fabIsopor;
    private CardView voluntariosCV, isoporCV,obsCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fabObs = (FloatingActionButton) findViewById(R.id.observacoesFab);
        fabIsopor = (FloatingActionButton) findViewById(R.id.isoporFab);
        fabVol = (FloatingActionButton) findViewById(R.id.voluntariosFAB);

        voluntariosCV = (CardView) findViewById(R.id.voluntariosCV);
        isoporCV = (CardView) findViewById(R.id.isoporCV);
        obsCV = (CardView) findViewById(R.id.observacoesCV);


        toolbar = (Toolbar) findViewById(R.id.toolbar_maps_page);
        //toolbar.setTitle(String.valueOf(idDaView));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = this;

        if (Build.VERSION.SDK_INT < 23) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        } else {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            } else {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2, 0, locationListener);

                Location ultimaLocalizacao = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                mMap.clear();
                LatLng usrLoc = new LatLng(ultimaLocalizacao.getLatitude(), ultimaLocalizacao.getLongitude());
                mMap.addMarker(new MarkerOptions().position(usrLoc).title("Marker in user location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(usrLoc));
            }
        }

        // Add a marker in Sydney and move the camera

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2, 0, (android.location.LocationListener) locationListener);
                }
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
//        Toast.makeText(MapsActivity.this,location.toString(),Toast.LENGTH_SHORT).show();
        LatLng usrLoc = new LatLng(location.getLatitude(), location.getLongitude());
        mMap.addMarker(new MarkerOptions().position(usrLoc).title("Marker in user location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(usrLoc));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.maps_toolbar, menu);
        return true;
    }


    private void showFabMenu() {
        isFABOpen = true;
        // Voluntarios
//        fabVol.setVisibility(View.VISIBLE);
        fabVol.animate().translationY(getResources().getDimension(R.dimen.standard_55));
        voluntariosCV.animate().translationY(getResources().getDimension(R.dimen.standard_55));
        voluntariosCV.setVisibility(View.VISIBLE);

        //Isopor
        fabIsopor.animate().translationY(getResources().getDimension(R.dimen.standard_105));
        isoporCV.animate().translationY(getResources().getDimension(R.dimen.standard_105));
        isoporCV.setVisibility(View.VISIBLE);

        //Observação
        fabObs.animate().translationY(getResources().getDimension(R.dimen.standard_155));
        obsCV.animate().translationY(getResources().getDimension(R.dimen.standard_155));
        obsCV.setVisibility(View.VISIBLE);


    }

    private void hideFabMenu() {
        isFABOpen = false;
        //Voluntarios
        fabVol.animate().translationY(0);
        voluntariosCV.animate().translationY(0);
        voluntariosCV.setVisibility(View.GONE);
//        fabVol.setVisibility(View.GONE);

        //Isopor
        fabIsopor.animate().translationY(0);
        isoporCV.animate().translationY(0);
        isoporCV.setVisibility(View.GONE);

        //Obervacao
        fabObs.animate().translationY(0);
        obsCV.animate().translationY(0);
        obsCV.setVisibility(View.GONE);

    }

    public void onMainFabClick(View v){
        if(!isFABOpen){
            showFabMenu();
        }else{
            hideFabMenu();
        }
    }
    public void onIsoporFabClick(View v){
        Toast.makeText(this,"oi1", Toast.LENGTH_SHORT).show();

    }
    public void onVoluntariosFabClick(View v){
        Toast.makeText(this,"oi2", Toast.LENGTH_SHORT).show();

    }
    public void onObservacoesFabClick(View v){
        Toast.makeText(this,"oi3", Toast.LENGTH_SHORT).show();

    }


}
