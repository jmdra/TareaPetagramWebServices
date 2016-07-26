package com.whiwol.petagram.vista.fragments;

import com.whiwol.petagram.adaptadores.FotosPerfilAdaptador;
import com.whiwol.petagram.adaptadores.MascotaAdaptador;
import com.whiwol.petagram.pojo.Followers;
import com.whiwol.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Jmdra on 07/07/2016.
 */
public interface IPerfilPet {

    //Generando el Layout Lineal Vertical
    public void generarGridLayout();

    public FotosPerfilAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(FotosPerfilAdaptador adaptador);

    public  void crearImagenPerfil(Followers profileUser);

}
