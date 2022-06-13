package com.bca.firstproject;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class GMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmap);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.my_map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
//        LatLng samriddhiLocation = new LatLng(27.676245297267283, 85.36116946853583);
//        mMap.addMarker(new MarkerOptions().position(samriddhiLocation).title("Samriddhi College"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(samriddhiLocation));
//        mMap.animateCamera(CameraUpdateFactory.zoomTo( 17.0f ));

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        mMap.addMarker(
                                new MarkerOptions().position(
                                new LatLng(location.getLatitude(), location.getLongitude()))
                                .title("My Location"));
                        mMap.moveCamera(
                                CameraUpdateFactory.newLatLng(
                                        new LatLng(location.getLatitude(), location.getLongitude())));
                        mMap.animateCamera(CameraUpdateFactory.zoomTo( 17.0f ));
                    }
                });

//        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
//            @Override
//            public void onMyLocationChange(@NonNull Location location) {
//                mMap.addMarker(
//                        new MarkerOptions().position(
//                                new LatLng(location.getLatitude(), location.getLongitude()))
//                                .title("My Location"));
//                mMap.moveCamera(
//                        CameraUpdateFactory.newLatLng(
//                                new LatLng(location.getLatitude(), location.getLongitude())));
//                mMap.animateCamera(CameraUpdateFactory.zoomTo( 17.0f ));
//
//            }
//        });

    }
}