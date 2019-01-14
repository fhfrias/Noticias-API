package com.iesvirgendelcarmen.dam.noticias.Modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


public class Noticia implements Serializable {

    @SerializedName("author")
    private String autor;

    @SerializedName("title")
    private String titulo;

    @SerializedName("description")
    private String descripcion;

    @SerializedName("url")
    private String url;

    @SerializedName("urlToImage")
    private String imagen;

    @SerializedName("publishedAt")
    private Date fechaPubli;

    @SerializedName("id")
    private String id;

    public Noticia(String autor, String titulo, String descripcion, String url, String imagen, Date fechaPubli) {
        this.autor = autor;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.imagen = imagen;
        this.fechaPubli = fechaPubli;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFechaPubli() {
        return fechaPubli;
    }

    public void setFechaPubli(Date fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormatoFechaPubli() {
        int dateStyle = DateFormat.MEDIUM;
        int timeStyle = DateFormat.SHORT;
        DateFormat df = DateFormat.getDateTimeInstance(dateStyle, timeStyle, Locale.getDefault());
        return df.format(fechaPubli);
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", url='" + url + '\'' +
                ", imagen='" + imagen + '\'' +
                ", fechaPubli=" + fechaPubli +
                '}';
    }
}