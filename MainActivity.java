package com.example.nitish.lsgpsdemo;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.btn);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
        }, 123);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSHelper gh=new GPSHelper(MainActivity.this);
                Location l=gh.fetchLocation();
                if(l!=null){
                    Double lat=l.getLatitude();
                    Double lon=l.getLongitude();
                    Toast.makeText(MainActivity.this, "Latitude " +
                            lat + " Longitude: " + lon, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
