package com.malibuzee.sisteval.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.malibuzee.sisteval.R;

public class CrearActividad extends AppCompatActivity {

    Spinner momentos, objetos;
    Button buttonRegistrarActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_actividad);

        buttonRegistrarActividad = (Button) findViewById(R.id.buttonRegistrarActividad);

        momentos = (Spinner)findViewById(R.id.spinnerCAMomentos);
        objetos = (Spinner)findViewById(R.id.spinnerCAObjetos);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.momentos, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.objetos, android.R.layout.simple_spinner_item);
        momentos.setAdapter(adapter);
        objetos.setAdapter(adapter2);

        //Botón para registrar el Actividad
        buttonRegistrarActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //         usuarioSQLiteHelper.agregarEscuela(IdBufferIn.getText().toString(), IdName.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agrego el OBEJTO a la ACTIVIDAD", Toast.LENGTH_LONG).show();
            }
        });


    }
}
