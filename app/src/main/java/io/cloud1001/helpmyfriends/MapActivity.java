package io.cloud1001.helpmyfriends;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
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

        // Add a marker in Sydney and move the camera
        List<LatLng> locations = getLocations();

        Marker harry = mMap.addMarker(new MarkerOptions().position(locations.get(0)).title("Harry Chaiescu"));
        harry.setTag("108023029965945");

        Marker carol = mMap.addMarker(new MarkerOptions().position(locations.get(1)).title("Carol Yangescu"));
        carol.setTag("106489403453261");

        Marker karen = mMap.addMarker(new MarkerOptions().position(locations.get(2)).title("Karen Bowerswitz"));
        karen.setTag("114369772663137");

        Marker tom = mMap.addMarker(new MarkerOptions().position(locations.get(3)).title("Tom Bushaksky"));
        tom.setTag("113951469371495");

        mMap.moveCamera(CameraUpdateFactory.newLatLng(locations.get(0)));
    }

    private List<LatLng> getLocations() {
        List<LatLng> locations = new ArrayList<LatLng>();

        LatLng dobie = new LatLng(30.283362, -97.741341);
        LatLng northoffice = new LatLng(30.291151, -97.737512);
        LatLng gdc = new LatLng(30.286225, -97.736606);
        LatLng pcl = new LatLng(30.282639, -97.738187);

        locations.add(dobie);
        locations.add(northoffice);
        locations.add(gdc);
        locations.add(pcl);

        return locations;
    }
}
