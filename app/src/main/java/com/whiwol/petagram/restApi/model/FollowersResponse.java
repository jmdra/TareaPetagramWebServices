package com.whiwol.petagram.restApi.model;

import com.whiwol.petagram.pojo.Followers;

import java.util.ArrayList;

/**
 * Created by Jmdra on 12/07/2016.
 */
public class FollowersResponse {
   ArrayList<Followers> cuenta;

    public ArrayList<Followers> getCuenta() {
        return cuenta;
    }

    public void setCuenta(ArrayList<Followers> cuenta) {
        this.cuenta = cuenta;
    }
}
