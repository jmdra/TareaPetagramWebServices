package com.whiwol.petagram.vista.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import com.whiwol.petagram.About;
import com.whiwol.petagram.Contacto;
import com.whiwol.petagram.R;
import com.whiwol.petagram.adaptadores.MascotaAdaptador;
import com.whiwol.petagram.pojo.Mascota;
import com.whiwol.petagram.presentador.FavoritosPresenter;
import com.whiwol.petagram.presentador.IFavoritosPresenter;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity implements IFavoritos{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IFavoritosPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);


        listaMascotas = (RecyclerView) findViewById(R.id.rvContactos2);

        presenter = new FavoritosPresenter(this, getBaseContext());
    }

    //11.- Seteando el Adaptador
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    //12.- Inicializar Lista de Mascotas Hardcoded
    public void inicializarFavs(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Vamo a Calmarno", 15, "R.drawable.squar"));
        mascotas.add(new Mascota("Charmander", 12, "R.drawable.charmander"));
        mascotas.add(new Mascota("Hunter", 10, "R.drawable.hunter"));
        mascotas.add(new Mascota("Mew", 10, "R.drawable.mew"));
        mascotas.add(new Mascota("Ho-Oh", 7, "R.drawable.hooh"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fav_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_contacto:
                //Crear el Intent para Actvity que enviara Email
                Toast.makeText(this, R.string.contacto_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Favoritos.this, Contacto.class);
                startActivity(intent2);
                break;
            case R.id.action_about:
                //Crear el Intent para Activity de Datos de Desarrollador
                Toast.makeText(this, R.string.about_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Favoritos.this, About.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void generarLinealLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public void generarToolbar() {
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.petagram);
        getSupportActionBar().setTitle(R.string.favs);
    }
}
