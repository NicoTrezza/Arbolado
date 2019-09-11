package com.unla.arbolado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CamaraActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        img = findViewById(R.id.img);
    }

    public void fotoCamara(View view) {

    }

    public void fotoGaleria(View view) {

    }

    public void continuar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
