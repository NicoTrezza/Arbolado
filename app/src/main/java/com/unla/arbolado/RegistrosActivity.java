package com.unla.arbolado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unla.arbolado.SQLite.CensoSQLite;
import com.unla.arbolado.modelo.Censo;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Censo censo = censos.get(i);
                Intent intent = new Intent(RegistrosActivity.this, DetalleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("censo", censo);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
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
