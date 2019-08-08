package com.unla.arbolado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.unla.arbolado.SQLite.CalleSQLite;
import com.unla.arbolado.modelo.Calle;

public class CalleActivity extends AppCompatActivity {

    private EditText et_calle;
    private EditText et_numerocasa;
    private EditText et_anchovereda;
    private Spinner s_paridad;
    private Spinner s_transito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calle);

        et_calle = findViewById(R.id.et_calle);
        et_numerocasa = findViewById(R.id.et_numerocasa);
        et_anchovereda = findViewById(R.id.et_anchovereda);
        s_paridad = findViewById(R.id.s_paridad);
        s_transito = findViewById(R.id.s_transito);

        String[] op_paridad = {"Paridad", "PAR", "IMPAR"};
        String[] op_transito = {"Transito", "PESADO","PARTICULAR"};

        ArrayAdapter<String> ad_paridad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, op_paridad);
        ArrayAdapter<String> ad_transito = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, op_transito);

        s_paridad.setAdapter(ad_paridad);
        s_transito.setAdapter(ad_transito);
    }

    public void continuar(View view) {
        String calle = et_calle.getText().toString();
        String numerocasa = et_numerocasa.getText().toString();
        String anchovereda = et_anchovereda.getText().toString();
        String paridad = s_paridad.getSelectedItem().toString();
        String transito = s_transito.getSelectedItem().toString();

        if (calle.isEmpty() || numerocasa.isEmpty() || anchovereda.isEmpty()) {
            Toast.makeText(this, "Estas en el campo", Toast.LENGTH_SHORT).show();
        }
        else {
            long id = CalleSQLite.getInstance(this).agregar(new Calle(calle, Integer.parseInt(numerocasa), Float.parseFloat(anchovereda), paridad, transito));
            Toast.makeText(getApplicationContext(), "ID registro: " + id, Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this, ArbolActivity.class);
        startActivity(intent);
    }
}
