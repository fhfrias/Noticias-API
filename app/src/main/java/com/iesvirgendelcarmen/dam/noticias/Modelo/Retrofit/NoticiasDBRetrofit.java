package com.iesvirgendelcarmen.dam.noticias.Modelo.Retrofit;

import com.iesvirgendelcarmen.dam.noticias.Modelo.Noticia;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NoticiasDBRetrofit {
    private static NoticiasDBRetrofit instance;
    private NoticiasAPI api;

    private NoticiasDBRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Configuracion.BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(NoticiasAPI.class);
    }

    public static NoticiasDBRetrofit getInstance(){
        if (instance==null){
            instance = new NoticiasDBRetrofit();
        }
        return instance;
    }

    public void getNoticias(String source, final DataSource.NoticiasCallback noticiasCallback){

        Call<RespuestaAPI> call = api.getNoticias( source, Configuracion.APIKEY);

        call.enqueue(new Callback<RespuestaAPI>() {
            @Override
            public void onResponse(Call<RespuestaAPI> call, Response<RespuestaAPI> response) {
                RespuestaAPI respuestaAPI = response.body();
                List<Noticia> noticias = respuestaAPI.getNoticias();
                noticiasCallback.onNoticiasCargadas(noticias);
            }

            @Override
            public void onFailure(Call<RespuestaAPI> call, Throwable t) {

            }
        });

    }
}
