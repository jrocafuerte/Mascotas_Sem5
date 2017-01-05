package com.prueba.mascotas.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prueba.mascotas.R;
import com.prueba.mascotas.adaptadores.MascotaAdaptador;
import com.prueba.mascotas.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragment extends Fragment {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    public MascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascota, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascota);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarLista();
        inicializaAdaptador();

        return v;

    }

    public void inicializarLista(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(5,"Mascota 1",R.drawable.img1,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(2,"Mascota 2",R.drawable.img2,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(10,"Mascota 3",R.drawable.img3,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(4,"Mascota 4",R.drawable.img4,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(6,"Mascota 5",R.drawable.img5,R.drawable.dog_bone_50));

    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

}
