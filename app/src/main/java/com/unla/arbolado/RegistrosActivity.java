package com.unla.arbolado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unla.arbolado.SQLite.ArbolSQLite;
import com.unla.arbolado.SQLite.CalleSQLite;
import com.unla.arbolado.SQLite.CensoSQLite;
import com.unla.arbolado.SQLite.CoordenadaSQLite;
import com.unla.arbolado.SQLite.EstadoDelArbolSQLite;
import com.unla.arbolado.SQLite.UsuarioSQLite;
import com.unla.arbolado.modelo.Arbol;
import com.unla.arbolado.modelo.Calle;
import com.unla.arbolado.modelo.Censo;
import com.unla.arbolado.modelo.Coordenada;
import com.unla.arbolado.modelo.EstadoDelArbol;
import com.unla.arbolado.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RegistrosActivity extends AppCompatActivity {

    private ListView listView;
    private List<Censo> censos;
    private List<String> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        listView = findViewById(R.id.lista);
        censos = CensoSQLite.getInstance(this).traer(this);

        getInfo();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, info);
        listView.setAdapter(adapter);

    }

    private void getInfo() {
        info = new ArrayList<String>();

        for (Censo censo : censos) {
            if (censo.getCalle().getNombre().isEmpty()) {
                info.add(censo.getUsuario().getApellido() + "\n" +
                        censo.getArbol().getNumeroArbol() + " " + censo.getArbol().getEspecie() + "\n" +
                        censo.getCoordenada().getLatitud() + " " + censo.getCoordenada().getLongitud());
            }
            else {
                info.add(censo.getUsuario().getApellido() + "\n" +
                        censo.getArbol().getNumeroArbol() + " " + censo.getArbol().getEspecie() + "\n" +
                        censo.getCalle().getNombre() + " " + censo.getCalle().getNumeroFrente() + "\n" +
                        censo.getCoordenada().getLatitud() + " " + censo.getCoordenada().getLongitud());
            }
        }
    }
}
