package com.aprendiz.ragp.turisapp5.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.aprendiz.ragp.turisapp5.R;
import com.aprendiz.ragp.turisapp5.models.GestorDB;
import com.aprendiz.ragp.turisapp5.models.Sitios;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class HotelMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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


        GestorDB gestorDB = new GestorDB(this);
        List<Sitios> sitiosList = gestorDB.hotelList();
        for (int i=0; i<sitiosList.size();i++){

            Sitios sitios =sitiosList.get(i);
            LatLng tmp = new LatLng(sitios.getLatitud(),sitios.getLongitud());
            mMap.addMarker(new MarkerOptions().position(tmp).title(sitios.getNombre()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tmp,10));

        }
    }
}
