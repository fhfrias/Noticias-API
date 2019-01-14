package com.iesvirgendelcarmen.dam.noticias.Modelo.Retrofit;

import com.iesvirgendelcarmen.dam.noticias.Modelo.Noticia;

import java.util.List;

public interface DataSource {

    public void getNoticias(NoticiasCallback noticiasCallback);
    public void getPelicula(int id, NoticiaCallback noticiaCallback);

    interface NoticiaCallback {
        public void onNoticiaCargada(Noticia noticia);
    }


    interface NoticiasCallback {
        public void onNoticiasCargadas(List<Noticia> noticias);
    }
}