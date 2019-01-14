package com.iesvirgendelcarmen.dam.noticias;

import com.iesvirgendelcarmen.dam.noticias.Modelo.Noticia;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Periodico;

public interface Callback {
    void detectarPeriodico(Periodico periodico);
    void detectarNoticia(Noticia noticia, Boolean estado);
    void ponerTituloToolbar(String titulo);
}
