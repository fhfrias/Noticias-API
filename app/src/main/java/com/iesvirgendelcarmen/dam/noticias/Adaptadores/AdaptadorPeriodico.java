package com.iesvirgendelcarmen.dam.noticias.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Periodico;
import com.iesvirgendelcarmen.dam.noticias.R;

import java.util.List;

public class AdaptadorPeriodico extends BaseAdapter {

    private Context context;
    private List<Periodico> listaPeriodicos;

    public AdaptadorPeriodico(Context context, List<Periodico> listaPeriodicos) {
        this.context = context;
        this.listaPeriodicos = listaPeriodicos;
    }

    @Override
    public int getCount() {
        return listaPeriodicos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPeriodicos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Periodico periodico = listaPeriodicos.get(position);
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.periodicos_item, parent, false);
        }

        ImageView imagePeriodico = convertView.findViewById(R.id.item_periodico_imagen);
        TextView nombrePeriodico = convertView.findViewById(R.id.item_periodico_texto);

        Glide.with(context)
                .load(periodico.getIconoPeriodico())
                .into(imagePeriodico);
        nombrePeriodico.setText(periodico.getNombre());

        return convertView;
    }
}
