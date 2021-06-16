package com.example.uteqlibros;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uteqlibros.Adaptador.AdaptadorRecycler;
import com.example.uteqlibros.Interfaz.InterListaLibros;
import com.example.uteqlibros.Modelo.ListaLibrosUteq;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
 public RecyclerView recyclerView;
 public List<ListaLibrosUteq>items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        items = new ArrayList<>();
        date();

    }

    private void date(){
        Retrofit retrofit = new  Retrofit.Builder().baseUrl("https://revistas.uteq.edu.ec/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        //Se aplica la interfaz
        InterListaLibros LibrosUTEQ_R =  retrofit.create(InterListaLibros.class);
        //Lista
        Call<List<ListaLibrosUteq>> call = LibrosUTEQ_R.getLibros();

        call.enqueue(new Callback<List<ListaLibrosUteq>>() {
            @Override
            public void onResponse(Call<List<ListaLibrosUteq>> call, Response<List<ListaLibrosUteq>> response) {
                List<ListaLibrosUteq> LibrosLista = response.body();
                for(ListaLibrosUteq Lista:LibrosLista){
                 /*   String responseTest="";
                    responseTest+=Lista.getIssue_id();
                    Log.v("Tag",""+responseTest);*/
                     items.add(Lista);
                
                }
                PutDataIntoRecyclerView(items);
            }

            @Override
            public void onFailure(Call<List<ListaLibrosUteq>> call, Throwable t) {
               System.out.println(t.toString()+"EBERT");
            }
        });
    }

    private void PutDataIntoRecyclerView(List<ListaLibrosUteq> librosL) {
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(this, (ArrayList<ListaLibrosUteq>) librosL);
 recyclerView.setLayoutManager(new LinearLayoutManager(this));
 recyclerView.setAdapter(adaptadorRecycler);

    }

}