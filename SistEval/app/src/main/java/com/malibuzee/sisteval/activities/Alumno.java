package com.malibuzee.sisteval.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.malibuzee.sisteval.R;
import com.malibuzee.sisteval.sql.DatabaseHelper;

public class Alumno extends AppCompatActivity {

    Button buttonListarAlum;
    Button buttonRegistrarAlum;
    EditText matricula;
    EditText nombreAlumno;
    EditText apellidos;
    EditText edad;
    TextView serialAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        matricula= (EditText) findViewById(R.id.matricula);
        nombreAlumno= (EditText) findViewById(R.id.nombreAlumno);
        apellidos= (EditText) findViewById(R.id.apellidos);
        edad= (EditText) findViewById(R.id.edad);
        serialAlumno= (TextView) findViewById(R.id.serialAlumno);
        buttonRegistrarAlum = (Button) findViewById(R.id.buttonRegistrarAlum);
        buttonListarAlum = (Button) findViewById(R.id.buttonListarAlum);

        final DatabaseHelper usuarioSQLiteHelper=new DatabaseHelper (getApplicationContext());

        //Botón para registrar el Alumno
        buttonRegistrarAlum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuarioSQLiteHelper.agregarAlumno(matricula.getText().toString(), nombreAlumno.getText().toString(),apellidos.getText().toString(),edad.getText().toString(),serialAlumno.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agrego el ALUMNO correctamente", Toast.LENGTH_LONG).show();
            }
        });

        //Botón para Listar los Alumnos
        buttonListarAlum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obtenerAlumno= new Intent(getApplicationContext(), ListaAlumnos.class);
                startActivity(obtenerAlumno);

            }
        });
    }
}
