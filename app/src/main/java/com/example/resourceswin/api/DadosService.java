package com.example.resourceswin.api;

import com.example.resourceswin.model.tblrecursos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DadosService {

    @GET("/Recursos")
    Call<List<tblrecursos>> recuperarLista(); //Método que retorna um objeto CAll, retorna uma chamado com o objeto tblrecursos

}
