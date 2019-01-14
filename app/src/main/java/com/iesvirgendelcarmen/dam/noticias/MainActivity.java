package com.iesvirgendelcarmen.dam.noticias;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.iesvirgendelcarmen.dam.noticias.Fragmentos.FragmentoDetalle;
import com.iesvirgendelcarmen.dam.noticias.Fragmentos.FragmentoFav;
import com.iesvirgendelcarmen.dam.noticias.Fragmentos.FragmentoFuentes;
import com.iesvirgendelcarmen.dam.noticias.Fragmentos.FragmentoNoticias;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Noticia;
import com.iesvirgendelcarmen.dam.noticias.Modelo.Periodico;

public class MainActivity extends AppCompatActivity implements Callback {

    Toolbar toolbar;
    FragmentoFuentes fuentes = new FragmentoFuentes();
    FragmentoFav fragmentoFav = new FragmentoFav();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        //Toolbar
        setSupportActionBar(toolbar);
        final ActionBar abar = getSupportActionBar();
        if( abar != null){
            abar.setHomeAsUpIndicator(R.drawable.menu);
            abar.setDisplayHomeAsUpEnabled(true);
        }

        cambiarFragmento(fuentes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.barra_fuente_noticias:
                getSupportActionBar().setTitle("NOTICIA");
                cambiarFragmento(fuentes);
                return true;
            case R.id.barra_favoritos:
                getSupportActionBar().setTitle("FAVORITOS");
                cambiarFragmento(fragmentoFav);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cambiarFragmento(Fragment fragmento) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.contenedor, fragmento);
        ft.commit();
    }

    @Override
    public void detectarPeriodico(Periodico periodico) {
        FragmentoNoticias fragmento = new FragmentoNoticias();
        Bundle bundle = new Bundle();
        bundle.putSerializable("PERIODICO", periodico);
        fragmento.setArguments(bundle);
        cambiarFragmento(fragmento);
    }

    @Override
    public void detectarNoticia(Noticia noticia, Boolean estado) {
        FragmentoDetalle fragmento = new FragmentoDetalle();
        Bundle bundle = new Bundle();
        bundle.putSerializable("NOTICIA", noticia);
        bundle.putBoolean("ESTADO", estado);
        fragmento.setArguments(bundle);
        cambiarFragmento(fragmento);
    }

    @Override
    public void ponerTituloToolbar(String titulo) {
        getSupportActionBar().setTitle(titulo);
    }
}
