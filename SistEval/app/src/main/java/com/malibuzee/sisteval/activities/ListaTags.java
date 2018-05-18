package com.malibuzee.sisteval.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.malibuzee.sisteval.R;
import com.malibuzee.sisteval.adapters.RecyclerViewAdapter;
import com.malibuzee.sisteval.sql.DatabaseHelper;

public class ListaTags extends AppCompatActivity {

    private RecyclerView recyclerViewObject;
    private RecyclerViewAdapter adaptadorObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispositvos_bt);

        recyclerViewObject=(RecyclerView)findViewById(R.id.recyclerObject);
        recyclerViewObject.setLayoutManager(new LinearLayoutManager(this));

        DatabaseHelper usuarioSQLiteHelper=new DatabaseHelper(getApplicationContext());

        adaptadorObject=new RecyclerViewAdapter(usuarioSQLiteHelper.obtenerTags());
        recyclerViewObject.setAdapter(adaptadorObject);

    }

}
