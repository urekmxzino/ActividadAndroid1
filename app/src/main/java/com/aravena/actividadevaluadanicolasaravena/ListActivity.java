
package com.aravena.actividadevaluadanicolasaravena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aravena.actividadevaluadanicolasaravena.adapters.RecetaAdapter;

public class ListActivity extends AppCompatActivity {

    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));


        RecetaAdapter adapter = new RecetaAdapter(FormularioActivity.recetasList);
        recycler.setAdapter(adapter);

    }
}