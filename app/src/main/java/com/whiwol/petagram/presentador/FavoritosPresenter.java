package com.whiwol.petagram.presentador;

import android.content.Context;

import com.whiwol.petagram.db.ConstructorMascotas;
import com.whiwol.petagram.pojo.Mascota;
import com.whiwol.petagram.vista.fragments.IFavoritos;

import java.util.ArrayList;

/**
 * Created by Jmdra on 27/06/2016.
 */
public class FavoritosPresenter implements IFavoritosPresenter {

    private IFavoritos iFavoritos;
    private Context context;
    ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;

    public FavoritosPresenter(IFavoritos iFavoritos, Context context) {
        this.iFavoritos = iFavoritos;
        this.context = context;
        obtenerFavoritosBaseDatos();
    }

    @Override
    public void obtenerFavoritosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarFavoritos();
    }

    @Override
    public void mostrarFavoritos() {
        iFavoritos.inicializarAdaptadorRV(iFavoritos.crearAdaptador(mascotas));
        iFavoritos.generarLinealLayoutVertical();
        iFavoritos.generarToolbar();
    }
}
