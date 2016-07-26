package com.whiwol.petagram.vista.fragments;

import com.whiwol.petagram.adaptadores.MascotaAdaptador;
import com.whiwol.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Jmdra on 27/06/2016.
 */
public interface IFavoritos {

    //Generando el Layout Lineal Vertical
    public void generarLinealLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

    public void generarToolbar();
}
