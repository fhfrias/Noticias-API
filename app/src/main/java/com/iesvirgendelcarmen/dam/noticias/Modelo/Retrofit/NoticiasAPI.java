package com.iesvirgendelcarmen.dam.noticias.Modelo.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NoticiasAPI {

    @GET("v2/everything")
    public Call<RespuestaAPI> getNoticias( @Query("sources") String source, @Query("apiKey") String api_key);
}
