package com.iesvirgendelcarmen.dam.noticias.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.iesvirgendelcarmen.dam.noticias.Adaptadores.AdaptadorNoticia;
import com.iesvirgendelcarmen.dam.noticias.Callback;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Noticia;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Retrofit.NoticiasFavRetrofit;
import com.iesvirgendelcarmen.dam.noticias.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentoFav extends Fragment {

    @BindView(R.id.lista_noticias)
    ListView listView;

    List<Noticia> listaNoticias;
    AdaptadorNoticia adaptador;

    private Callback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Callback)
            this.callback = (Callback) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lista_noticias, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        NoticiasFavRetrofit.getInstance().getNoticias(new NoticiasFavRetrofit.CallbackNoticias() {
            @Override
            public void onNoticias(List<Noticia> noticias) {
                listaNoticias = noticias;
                adaptador = new AdaptadorNoticia(getContext(), noticias);
                listView.setAdapter(adaptador);
            }

            @Override
            public void onNoticiasError(String mensajeError) {

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callback.detectarNoticia(listaNoticias.get(position), true);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                NoticiasFavRetrofit.getInstance().deleteNoticia(listaNoticias.get(position), new NoticiasFavRetrofit.CallbackDeleteNoticia() {
                    @Override
                    public void onDeleteNoticia() {

                    }

                    @Override
                    public void onDeleteNoticiaError() {

                    }
                });

                listaNoticias.remove(position);
                adaptador.notifyDataSetChanged();
                Toast.makeText(getContext(), "ELIMINADO DE FAVORITOS", Toast.LENGTH_SHORT).show();
                return false;

            }
        });
    }
}