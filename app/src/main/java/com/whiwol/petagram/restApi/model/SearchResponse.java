package com.whiwol.petagram.restApi.model;

import com.whiwol.petagram.pojo.Followers;

/**
 * Created by Jmdra on 08/07/2016.
 */
public class SearchResponse {
    Followers cuenta;

    public Followers getCuenta() {
        return cuenta;
    }

    public void setCuenta(Followers cuenta) {
        this.cuenta = cuenta;
    }
}
