package com.malibuzee.sisteval.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.malibuzee.sisteval.R;
import com.malibuzee.sisteval.adapters.AlumRecyclerAdapter;
import com.malibuzee.sisteval.sql.DatabaseHelper;

public class ListaAlumnos extends AppCompatActivity {

    private RecyclerView alumViewObject;
    private AlumRecyclerAdapter alumRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alum_list);

        alumViewObject=(RecyclerView)findViewById(R.id.recyclerViewAlum);
        alumViewObject.setLayoutManager(new LinearLayoutManager(this));

        DatabaseHelper usuarioSQLiteHelper=new DatabaseHelper(getApplicationContext());

        alumRecyclerAdapter=new AlumRecyclerAdapter(usuarioSQLiteHelper.obtenerAlumno());
        alumViewObject.setAdapter(alumRecyclerAdapter);

    }

}
