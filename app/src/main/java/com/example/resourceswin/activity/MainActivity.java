package com.example.resourceswin.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.resourceswin.R;
import com.example.resourceswin.adapter.Adapter;
import com.example.resourceswin.api.DadosService;
import com.example.resourceswin.model.tblrecursos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private List<tblrecursos> listaDados = new ArrayList<>();
    private RecyclerView recyclerView;

    Adapter adapter = new Adapter(listaDados);
    SwipeRefreshLayout swipeRefreshLayout;

    private boolean inverteLista = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerDados);
        swipeRefreshLayout = findViewById(R.id.swiperLayout);

        //Configuração do RecyclerView
        configRecyclerView();

        //Configuração do Retrofit
        configuraRetrofit();

        final DadosService dadosService = retrofit.create(DadosService.class);
        Call<List<tblrecursos>> call = dadosService.recuperarLista();

        call.enqueue(new Callback<List<tblrecursos>>() {
            @Override
            public void onResponse(Call<List<tblrecursos>> call, Response<List<tblrecursos>> response) {
                if (response.isSuccessful()) {

                    ArrayList<tblrecursos> tblRecursos = (ArrayList<tblrecursos>) response.body();
                    setRecyclerView(tblRecursos);

                }
            }

            @Override
            public void onFailure(Call<List<tblrecursos>> call, Throwable t) {

            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Call<List<tblrecursos>> callRefresh = dadosService.recuperarLista();

                callRefresh.enqueue(new Callback<List<tblrecursos>>() {
                    @Override
                    public void onResponse(Call<List<tblrecursos>> call, Response<List<tblrecursos>> response) {
                        if (response.isSuccessful()) {
                            ArrayList<tblrecursos> tblRecursosRefresh = (ArrayList<tblrecursos>) response.body();
                            setRecyclerView(tblRecursosRefresh);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<tblrecursos>> call, Throwable t) {

                    }
                });

                adapter.notifyDataSetChanged();

                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    private void configuraRetrofit() {
        //Instanciando a Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.0.136:8080")
                .addConverterFactory(GsonConverterFactory.create()) //Conversor JSON
                .build();
    }

    private void setRecyclerView(ArrayList<tblrecursos> listRecycler) {
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //Collections inverte a ordem da Lista.
        Collections.reverse(listRecycler);
        adapter.setListaAdapter(listRecycler);
        recyclerView.setAdapter(adapter);
    }

    public void configRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager); //Configurando o layout no recycler view
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
    }

}