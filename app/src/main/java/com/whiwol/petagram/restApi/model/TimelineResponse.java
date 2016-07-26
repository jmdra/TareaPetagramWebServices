package com.whiwol.petagram.restApi.model;

import com.whiwol.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Jmdra on 13/07/2016.
 */
public class TimelineResponse {
    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
