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
import com.prueba.mascotas.presentador.IMascotaFragmentPresenter;
import com.prueba.mascotas.presentador.MascotaFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragment extends Fragment implements IMascotaFragmentView {

    private RecyclerView listaMascotas;
    private ArrayList<Mascota> mascotas;
    private IMascotaFragmentPresenter iMascotaFragmentPresenter;
    public MascotaFragment() {
   }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascota, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascota);
        iMascotaFragmentPresenter = new MascotaFragmentPresenter(this, getContext(),"N");
        return v;

    }

    @Override
    public void generaLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        return adaptador;
    }

    @Override
    public void inicializarAdaptarRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
