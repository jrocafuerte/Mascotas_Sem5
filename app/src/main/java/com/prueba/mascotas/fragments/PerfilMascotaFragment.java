package com.prueba.mascotas.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prueba.mascotas.R;
import com.prueba.mascotas.adaptadores.MascotaAdaptador;
import com.prueba.mascotas.adaptadores.MascotaPerfilAdaptador;
import com.prueba.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotaFragment extends Fragment {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    public PerfilMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);
        // Inflate the layout for this fragment
        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotaPerfil);
        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);
        inicializarLista();
        inicializaAdaptador();

        return v;
    }

    public void inicializarLista(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(5,"Mascota 1",R.drawable.img1,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(2,"Mascota 2",R.drawable.img1,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(10,"Mascota 3",R.drawable.img1,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(4,"Mascota 4",R.drawable.img1,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(6,"Mascota 5",R.drawable.img1,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(0,"Mascota 5",R.drawable.img1,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(7,"Mascota 4",R.drawable.img1,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(9,"Mascota 5",R.drawable.img1,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(12,"Mascota 5",R.drawable.img1,R.drawable.dog_bone_50));

    }

    public void inicializaAdaptador(){
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
}
