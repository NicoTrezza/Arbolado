package com.unla.arbolado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.unla.arbolado.SQLite.UsuarioSQLite;
import com.unla.arbolado.modelo.Usuario;

public class UsuarioActivity extends AppCompatActivity {

    private EditText et_nombre;
    private EditText et_apellido;
    private EditText et_dni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        et_nombre = findViewById(R.id.et_nombre);
        et_apellido = findViewById(R.id.et_apellido);
        et_dni = findViewById(R.id.et_dni);

        SharedPreferences preferences = getSharedPreferences("usuario", Context.MODE_PRIVATE);

        et_nombre.setText(preferences.getString("nombre", ""));
        et_apellido.setText(preferences.getString("apellido", ""));
        et_dni.setText(preferences.getString("dni", ""));
    }

    public void continuar(View view) {
        String nombre = et_nombre.getText().toString();
        String apellido = et_apellido.getText().toString();
        String dni = et_dni.getText().toString();

        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
            Toast.makeText(this, "Debes completar todos los campos", Toast.LENGTH_SHORT).show();
        }
        if (dni.length() < 7 || dni.length() > 9) {
            Toast.makeText(this, "DNI debe estar entre 7 y 9 digitos", Toast.LENGTH_SHORT).show();
        }
        else {
            SharedPreferences preferences = getSharedPreferences("usuario", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre", nombre);
            editor.putString("apellido", apellido);
            editor.putString("dni", dni);
            editor.commit();

            long id = UsuarioSQLite.getInstance(this).agregar(new Usuario(nombre, apellido, Integer.parseInt(dni)));
            Toast.makeText(getApplicationContext(), "ID registro: " + id, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, CalleActivity.class);
            intent.putExtra("idUsuario", id);
            startActivity(intent);
        }
    }
}
