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
import com.iesvirgendelcarmen.dam.noticias.Modelo.Periodico;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Retrofit.DataSource;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Retrofit.NoticiasDBRetrofit;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Retrofit.NoticiasFavRetrofit;
import com.iesvirgendelcarmen.dam.noticias.R;

import java.util.List;

public class FragmentoNoticias extends Fragment {

    ListView listView;

    List<Noticia> listaNoticias;
    AdaptadorNoticia adaptador;

    Callback callback;

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

        listView = (ListView) view.findViewById(R.id.lista_noticias);


        Periodico periodico = (Periodico) getArguments().getSerializable("PERIODICO");
        String idPeriodico = periodico.getIdPeriodico();

        NoticiasDBRetrofit.getInstance().getNoticias(idPeriodico, new DataSource.NoticiasCallback() {

            @Override
            public void onNoticiasCargadas(List<Noticia> noticias) {
                listaNoticias = noticias;
                adaptador = new AdaptadorNoticia(getContext(), noticias);
                listView.setAdapter(adaptador);
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callback.detectarNoticia(listaNoticias.get(position), false);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                NoticiasFavRetrofit.getInstance().postNoticias(listaNoticias.get(i), new NoticiasFavRetrofit.CallbackNoticia() {
                    @Override
                    public void onPostNoticia() {
                        Toast.makeText(getContext(), "AÑADIDO A FAVORITOS", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNoticiaError(String mensajeError) {
                        Toast.makeText(getContext(), "ERROR: NO SE HA PODIDO AÑADIR A FAV", Toast.LENGTH_SHORT).show();
                    }
                });
                return false;
            }
        });


    }
}

