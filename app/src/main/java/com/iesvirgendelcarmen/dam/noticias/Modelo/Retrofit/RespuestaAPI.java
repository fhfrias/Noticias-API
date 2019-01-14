package com.iesvirgendelcarmen.dam.noticias.Modelo.Retrofit;

import com.google.gson.annotations.SerializedName;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Noticia;

import java.util.List;

public class RespuestaAPI {

    @SerializedName("page")
    private int pagina;

    @SerializedName("total_results")
    private int totalResultados;

    @SerializedName("total_pages")
    private int totalPaginas;

    @SerializedName("articles")
    private List<Noticia> noticias;

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getTotalResultados() {
        return totalResultados;
    }

    public void setTotalResultados(int totalResultados) {
        this.totalResultados = totalResultados;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}