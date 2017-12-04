package com.example.johnny.gpsapplication;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private double latitude = 0.0;
    private double longitude = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getLocal();





    }


    private void initView() {
        text = findViewById(R.id.text);
    }

    private void getLocal() {

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (location != null) {
                    Log.e("Map", "Location changed : Lat: "
                            + location.getLatitude() + " Lng: "
                            + location.getLongitude());

                    text.setText("Location changed : Lat: "
                            + location.getLatitude() + " Lng: "
                            + location.getLongitude());
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };


        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0f, locationListener);

        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }

        Log.e("Map", "Location changed : Lat: "
        );
    }


}
