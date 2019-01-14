package com.iesvirgendelcarmen.dam.noticias.Adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Noticia;
import com.iesvirgendelcarmen.dam.noticias.R;

import java.util.List;


public class AdaptadorNoticia extends BaseAdapter {

    private Context context;
    private List<Noticia> noticias;


    public AdaptadorNoticia(Context context, List<Noticia> noticias) {
        this.context = context;
        this.noticias = noticias;
    }

    @Override
    public int getCount() {
        return noticias.size();
    }

    @Override
    public Object getItem(int i) {
        return noticias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Noticia noticia = noticias.get(position);
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.noticias_item, parent, false);
        }

        ImageView imageNoticia = convertView.findViewById(R.id.item_noticia_imagen);
        TextView tituloNoticia = convertView.findViewById(R.id.item_noticia_titulo);
        TextView autorNoticia = convertView.findViewById(R.id.item_noticia_autor);
        TextView fechaNoticia = convertView.findViewById(R.id.item_noticia_fecha);

        Glide.with(context)
                .load(noticia.getImagen())
                .into(imageNoticia);
        tituloNoticia.setText(noticia.getTitulo());
        autorNoticia.setText(noticia.getAutor());
        fechaNoticia.setText(noticia.getFormatoFechaPubli());

        return convertView;
    }

}