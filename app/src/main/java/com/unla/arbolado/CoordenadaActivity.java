package com.unla.arbolado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.unla.arbolado.SQLite.CoordenadaSQLite;
import com.unla.arbolado.modelo.Coordenada;

public class CoordenadaActivity extends AppCompatActivity implements LocationListener {

    private EditText et_latitud;
    private EditText et_longitud;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordenada);

        et_latitud = findViewById(R.id.et_latitud);
        et_longitud = findViewById(R.id.et_longitud);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    public void actualizar(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},2);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},2);
            return;
        }
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "Activar GPS", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Buscando coordenadas, espere un momento...", Toast.LENGTH_SHORT).show();
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        et_latitud.setText(location.getLatitude() + "");
        et_longitud.setText(location.getLongitude() + "");
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

    public void continuar(View view) {
        String latitud = et_latitud.getText().toString();
        String longitud = et_longitud.getText().toString();

        if (latitud.isEmpty() || longitud.isEmpty()) {
            Toast.makeText(this, "Debes completar todos los campos", Toast.LENGTH_SHORT).show();
        }
        else {
            long id = CoordenadaSQLite.getInstance(this).agregar(new Coordenada(Double.parseDouble(latitud), Double.parseDouble(longitud)));
            Toast.makeText(getApplicationContext(), "ID registro: " + id, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

}
