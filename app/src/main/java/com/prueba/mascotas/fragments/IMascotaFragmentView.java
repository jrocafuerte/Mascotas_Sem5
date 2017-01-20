package com.prueba.mascotas.fragments;

import com.prueba.mascotas.adaptadores.MascotaAdaptador;
import com.prueba.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Intel on 19/01/2017.
 */

public interface IMascotaFragmentView {

    public void generaLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptarRV(MascotaAdaptador adaptador);
}
