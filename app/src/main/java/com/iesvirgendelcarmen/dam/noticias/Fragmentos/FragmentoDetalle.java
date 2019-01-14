package com.iesvirgendelcarmen.dam.noticias.Fragmentos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Noticia;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Retrofit.NoticiasFavRetrofit;
import com.iesvirgendelcarmen.dam.noticias.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentoDetalle extends Fragment {

    @BindView(R.id.detalle_imagen)
    ImageView imagen;
    @BindView(R.id.detalle_titulo)
    TextView titulo;
    @BindView(R.id.detalle_descripcion)
    TextView descripcion;
    @BindView(R.id.detalle_autor)
    TextView autor;
    @BindView(R.id.detalle_fecha)
    TextView fecha;
    @BindView(R.id.btn_favoritos)
    Button botonFav;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.noticia_detalle, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Noticia noticia = (Noticia) getArguments().getSerializable("NOTICIA");
        Boolean estado = (Boolean) getArguments().getBoolean("ESTADO");
        if(estado == true){
            botonFav.setEnabled(false);
        } else {
            botonFav.setEnabled(true);
        }
        titulo.setText(noticia.getTitulo());
        autor.setText(noticia.getAutor());
        descripcion.setText(noticia.getDescripcion());
        fecha.setText(noticia.getFormatoFechaPubli());

        Glide.with(view)
                .load(noticia.getImagen())
                .apply(RequestOptions.placeholderOf(R.color.colorAccent))
                .into(imagen);

        botonFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoticiasFavRetrofit.getInstance().postNoticias(noticia, new NoticiasFavRetrofit.CallbackNoticia() {
                    @Override
                    public void onPostNoticia() {
                        Toast.makeText(getContext(), "AÑADIDO A FAVORITOS", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNoticiaError(String mensajeError) {
                        Toast.makeText(getContext(), "ERROR: NO SE HA PODIDO AÑADIR A FAV", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    }
