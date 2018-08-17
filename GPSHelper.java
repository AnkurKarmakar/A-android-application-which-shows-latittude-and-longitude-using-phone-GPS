package com.example.ankur.lsgpsdemo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by ANKUR on 19-12-2017.
 */

public class GPSHelper implements LocationListener {

    Context context;

    public GPSHelper(Context c){
        context=c;
    }

    public Location fetchLocation(){
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context, "Permission not granted", Toast.LENGTH_SHORT).show();
            return null;
        }
        LocationManager lm =(LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        boolean isGPSenabled=lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(isGPSenabled){
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
            Location l=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return l;


        }else{
            Toast.makeText(context, "Please enable the GPS", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

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
}
