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

import com.iesvirgendelcarmen.dam.noticias.Adaptadores.AdaptadorPeriodico;
import com.iesvirgendelcarmen.dam.noticias.Callback;
import com.iesvirgendelcarmen.dam.noticias.MainActivity;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Periodico;
import com.iesvirgendelcarmen.dam.noticias.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentoFuentes extends Fragment {

    AdaptadorPeriodico adaptador ;
    List<Periodico> listaPeriodicos = new ArrayList<Periodico>();
    ListView listView;

    Callback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Callback)
            this.callback = (Callback) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lista_fuentes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.lista_periodicos);

        listaPeriodicos.clear();
        cargarPeriodicos();
        adaptador = new AdaptadorPeriodico(getContext(), listaPeriodicos);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callback.ponerTituloToolbar(listaPeriodicos.get(position).getNombre());
                callback.detectarPeriodico(listaPeriodicos.get(position));
            }
        });
    }

    private void cargarPeriodicos() {
        Periodico marca = new Periodico("MARCA", "https://is5-ssl.mzstatic.com/image/thumb/Purple128/v4/06/41/a6/0641a631-dd71-4953-d5cd-52e5b3b89db0/AppIcon-0-1x_U007emarketing-0-0-85-220-0-7.png/246x0w.jpg","marca" );
        Periodico elMundo = new Periodico("El MUNDO", "https://is3-ssl.mzstatic.com/image/thumb/Purple128/v4/42/dc/53/42dc53bb-338d-4d01-cd5b-187b81a2e10e/AppIcon-0-1x_U007emarketing-0-0-GLES2_U002c0-512MB-sRGB-0-0-0-85-220-0-0-0-7.png/246x0w.jpg","el-mundo" );
        Periodico cnnEsp = new Periodico("CNN ESP", "https://is5-ssl.mzstatic.com/image/thumb/Music3/v4/a8/bb/3c/a8bb3cac-f51d-91d1-7ce6-716ae98550ba/source/1200x630bb.jpg", "cnn-es");

        listaPeriodicos.add(marca);
        listaPeriodicos.add(elMundo);
        listaPeriodicos.add(cnnEsp);
    }
}
