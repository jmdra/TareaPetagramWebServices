package com.whiwol.petagram.vista.fragments;

import com.whiwol.petagram.adaptadores.MascotaAdaptador;
import com.whiwol.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Jmdra on 12/07/2016.
 */
public interface IInicioPet {

    public void generarGridLayout();
    public MascotaAdaptador crearAdaptadorTimeline(ArrayList<Mascota> mascota);
    public void iniciarAdaptadorRVTimeline(MascotaAdaptador adaptador);
}
