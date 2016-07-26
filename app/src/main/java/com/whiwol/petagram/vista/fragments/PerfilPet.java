package com.whiwol.petagram.vista.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.whiwol.petagram.R;
import com.whiwol.petagram.adaptadores.FotosPerfilAdaptador;
import com.whiwol.petagram.pojo.Followers;
import com.whiwol.petagram.pojo.Mascota;
import com.whiwol.petagram.presentador.IPerfilPetPresenter;
import com.whiwol.petagram.presentador.PerfilPetPresenter;

import java.util.ArrayList;


public class PerfilPet extends Fragment implements IPerfilPet {

    private RecyclerView listaMascotas;
    private RecyclerView.LayoutManager lManager;
    private CircularImageView circularImageView;
    private TextView tvNombrePerfil;
    private IPerfilPetPresenter perfilPresentador;
    private RecyclerView.Adapter adapter;

    ArrayList<Mascota> mascotas;


    public PerfilPet() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_pet, container, false);

        circularImageView = (CircularImageView)v.findViewById(R.id.civFotoPerfil) ;
        tvNombrePerfil = (TextView)v.findViewById(R.id.tvNombrePerfil);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvFotosPerfil);
        listaMascotas.setHasFixedSize(true);
        perfilPresentador = new PerfilPetPresenter(this, getContext(), obtenerProfileInstagram());

        return v;
    }

    private String obtenerProfileInstagram(){
        SharedPreferences misReferencias = this.getActivity().getSharedPreferences("shared", Context.MODE_PRIVATE);
        return misReferencias.getString("perfilInstagram", "");
    }

    @Override
    public void generarGridLayout() {
        lManager = new GridLayoutManager(getActivity(), 3);
        listaMascotas.setLayoutManager(lManager);
    }

    @Override
    public FotosPerfilAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        FotosPerfilAdaptador adaptador = new FotosPerfilAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(FotosPerfilAdaptador adapter) {
        listaMascotas.setHasFixedSize(true);
        listaMascotas.setAdapter(adapter);
    }

    @Override
    public void crearImagenPerfil(Followers profileUser) {
        Picasso.with(getActivity())
                .load(profileUser.getUrlFotoPerfil())
                .placeholder(R.drawable.hunter)
                .into(circularImageView);

        tvNombrePerfil.setText(profileUser.getNombre());

    }
}
