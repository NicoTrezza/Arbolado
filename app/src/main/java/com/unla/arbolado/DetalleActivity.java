package com.unla.arbolado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.unla.arbolado.SQLite.CensoSQLite;
import com.unla.arbolado.modelo.Censo;

public class DetalleActivity extends AppCompatActivity {

    private TextView tv_nombre_u;
    private TextView tv_apellido_u;
    private TextView tv_dni_u;
    private TextView tv_nombre_c;
    private TextView tv_numero_c;
    private TextView tv_ancho_c;
    private TextView tv_paridad_c;
    private TextView tv_transito_c;
    private TextView tv_especie_a;
    private TextView tv_numero_a;
    private TextView tv_distanciaplantas_a;
    private TextView tv_distanciamuro_a;
    private TextView tv_circunferencia_a;
    private TextView tv_cazuela_a;
    private TextView tv_comentario_a;
    private TextView tv_estadosanitario_e;
    private TextView tv_inclinacion_e;
    private TextView tv_ahuecamiento_e;
    private TextView tv_cables_e;
    private TextView tv_luminaria_e;
    private TextView tv_danos_e;
    private TextView tv_veredas_e;
    private TextView tv_podas_e;
    private TextView tv_latitud_co;
    private TextView tv_longitud_co;
    private Censo censo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tv_nombre_u = findViewById(R.id.tv_nombre_u);
        tv_apellido_u = findViewById(R.id.tv_apellido_u);
        tv_dni_u = findViewById(R.id.tv_dni_u);
        tv_nombre_c = findViewById(R.id.tv_nombre_c);
        tv_numero_c = findViewById(R.id.tv_numero_c);
        tv_ancho_c = findViewById(R.id.tv_ancho_c);
        tv_paridad_c = findViewById(R.id.tv_paridad_c);
        tv_transito_c = findViewById(R.id.tv_transito_c);
        tv_especie_a = findViewById(R.id.tv_especie_a);
        tv_numero_a = findViewById(R.id.tv_numero_a);
        tv_distanciaplantas_a = findViewById(R.id.tv_distanciaplantas_a);
        tv_distanciamuro_a = findViewById(R.id.tv_distanciamuro_a);
        tv_circunferencia_a = findViewById(R.id.tv_circunferencia_a);
        tv_cazuela_a = findViewById(R.id.tv_cazuela_a);
        tv_comentario_a = findViewById(R.id.tv_comentario_a);
        tv_estadosanitario_e = findViewById(R.id.tv_estadosanitario_e);
        tv_inclinacion_e = findViewById(R.id.tv_inclinacion_e);
        tv_ahuecamiento_e = findViewById(R.id.tv_ahuecamiento_e);
        tv_cables_e = findViewById(R.id.tv_cables_e);
        tv_luminaria_e = findViewById(R.id.tv_luminaria_e);
        tv_danos_e = findViewById(R.id.tv_danos_e);
        tv_veredas_e = findViewById(R.id.tv_veredas_e);
        tv_podas_e = findViewById(R.id.tv_podas_e);
        tv_latitud_co = findViewById(R.id.tv_latitud_co);
        tv_longitud_co = findViewById(R.id.tv_longitud_co);

        Bundle bundle = getIntent().getExtras();
        censo = null;

        if (bundle != null) {
            censo = (Censo) bundle.getSerializable("censo");
            tv_nombre_u.setText(censo.getUsuario().getNombre().toString());
            tv_apellido_u.setText(censo.getUsuario().getApellido().toString());
            tv_dni_u.setText(String.valueOf(censo.getUsuario().getDni()));

            tv_nombre_c.setText(censo.getCalle().getNombre().toString());
            tv_numero_c.setText(String.valueOf(censo.getCalle().getNumeroFrente()));
            tv_ancho_c.setText(String.valueOf(censo.getCalle().getAnchoVereda()));
            tv_paridad_c.setText(censo.getCalle().getParidad().toString());
            tv_transito_c.setText(censo.getCalle().getTransito().toString());

            tv_especie_a.setText(censo.getArbol().getEspecie().toString());
            tv_numero_a.setText(String.valueOf(censo.getArbol().getNumeroArbol()));
            tv_distanciaplantas_a.setText(String.valueOf(censo.getArbol().getDistanciaEntrePlantas()));
            tv_distanciamuro_a.setText(String.valueOf(censo.getArbol().getDistanciaAlMuro()));
            tv_circunferencia_a.setText(String.valueOf(censo.getArbol().getCircunferenciaDelArbol()));
            tv_cazuela_a.setText(censo.getArbol().getCazuela().toString());
            tv_comentario_a.setText(censo.getArbol().getComentario().toString());

            tv_estadosanitario_e.setText(censo.getEstadoDelArbol().getEstadoSanitario().toString());
            tv_inclinacion_e.setText(censo.getEstadoDelArbol().getInclinacion().toString());
            tv_ahuecamiento_e.setText(censo.getEstadoDelArbol().getAhuecamiento().toString());
            tv_cables_e.setText(censo.getEstadoDelArbol().getCables().toString());
            tv_luminaria_e.setText(censo.getEstadoDelArbol().getLuminaria().toString());
            tv_danos_e.setText(censo.getEstadoDelArbol().getDaños().toString());
            tv_veredas_e.setText(censo.getEstadoDelArbol().getVeredas().toString());
            tv_podas_e.setText(censo.getEstadoDelArbol().getPodas().toString());

            tv_latitud_co.setText(censo.getCoordenada().getLatitud().toString());
            tv_longitud_co.setText(censo.getCoordenada().getLongitud().toString());
        }
    }

    public void eliminar(View view) {
        int n = CensoSQLite.getInstance(this).eliminar(censo.getIdCenso());
        if (n == 1)
            Toast.makeText(this, "Se elimino correctamente", Toast.LENGTH_SHORT).show();
        if (n == 0)
            Toast.makeText(this, "No se pudo eliminar", Toast.LENGTH_SHORT).show();
    }
}
