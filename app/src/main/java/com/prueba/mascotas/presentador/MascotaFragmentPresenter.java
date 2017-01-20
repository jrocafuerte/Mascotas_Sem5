package com.prueba.mascotas.presentador;

import android.content.Context;

import com.prueba.mascotas.adaptadores.MascotaAdaptador;
import com.prueba.mascotas.db.ConstructorMascotas;
import com.prueba.mascotas.fragments.IMascotaFragmentView;
import com.prueba.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Intel on 19/01/2017.
 */

public class MascotaFragmentPresenter implements IMascotaFragmentPresenter {


    private IMascotaFragmentView iMascotaFragmentView;
    private Context  context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    /*public MascotaFragmentPresenter(IMascotaFragmentView iMascotaFragmentView, Context context ){
        this.iMascotaFragmentView = iMascotaFragmentView;
        this.context = context;
        obtenerMascotas();
    }*/

    public MascotaFragmentPresenter(IMascotaFragmentView iMascotaFragmentView, Context context,String band ){
        this.iMascotaFragmentView = iMascotaFragmentView;
        this.context = context;
        obtenerMascotas(band);
    }


    @Override
    public void obtenerMascotas(String band) {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos(band);
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iMascotaFragmentView.inicializarAdaptarRV(iMascotaFragmentView.crearAdaptador(mascotas));
        iMascotaFragmentView.generaLinearLayoutVertical();
    }
}
