package com.unla.arbolado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unla.arbolado.SQLite.ArbolSQLite;
import com.unla.arbolado.SQLite.CalleSQLite;
import com.unla.arbolado.SQLite.CoordenadaSQLite;
import com.unla.arbolado.SQLite.EstadoDelArbolSQLite;
import com.unla.arbolado.SQLite.UsuarioSQLite;
import com.unla.arbolado.modelo.Arbol;
import com.unla.arbolado.modelo.Calle;
import com.unla.arbolado.modelo.Coordenada;
import com.unla.arbolado.modelo.EstadoDelArbol;
import com.unla.arbolado.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RegistrosActivity extends AppCompatActivity {

    private ListView listView;
    private List<Usuario> usuarios;
    private List<Calle> calles;
    private List<Arbol> arboles;
    private List<EstadoDelArbol> estados;
    private List<Coordenada> coordenadas;
    private List<String> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        listView = findViewById(R.id.lista);
        usuarios = UsuarioSQLite.getInstance(this).traer();
        calles = CalleSQLite.getInstance(this).traer();
        arboles = ArbolSQLite.getInstance(this).traer();
        estados = EstadoDelArbolSQLite.getInstance(this).traer();
        coordenadas = CoordenadaSQLite.getInstance(this).traer();

        getInfo();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, info);
        listView.setAdapter(adapter);

    }

    private void getInfo() {
        info = new ArrayList<String>();

        for (int i = 0; i < usuarios.size(); i++) {
            info.add("Apellido: " + usuarios.get(i).getApellido() + "\nCalle: " + calles.get(i).getNombre()
            + "\nEspecie: " + arboles.get(i).getEspecie() + ". numero: " + arboles.get(i).getNumeroArbol()
            + "\n" + estados.get(i).getEstadoSanitario() + estados.get(i).getInclinacion() + estados.get(i).getAhuecamiento() + estados.get(i).getCables()
            + estados.get(i).getLuminaria() + estados.get(i).getDaños() + estados.get(i).getVeredas() + estados.get(i).getPodas()
            + "\nLatitud: " + coordenadas.get(i).getLatitud() + ", longitud: " + coordenadas.get(i).getLongitud());
        }
    }
}
