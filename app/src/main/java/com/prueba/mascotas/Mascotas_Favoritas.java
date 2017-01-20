package com.prueba.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.prueba.mascotas.adaptadores.MascotaAdaptador;
import com.prueba.mascotas.fragments.IMascotaFragmentView;
import com.prueba.mascotas.pojo.Mascota;
import com.prueba.mascotas.presentador.IMascotaFragmentPresenter;
import com.prueba.mascotas.presentador.MascotaFragmentPresenter;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class Mascotas_Favoritas extends AppCompatActivity implements IMascotaFragmentView {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    private IMascotaFragmentPresenter iMascotaFragmentPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        ImageButton boton = (ImageButton) findViewById(R.id.ibActionView);
        boton.setVisibility(View.INVISIBLE);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setLogo(R.drawable.chevron_left_48);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotaFavorita);
        iMascotaFragmentPresenter = new MascotaFragmentPresenter(this, getApplicationContext(),"S");

        //inicializarLista();
        //inicializaAdaptador();
    }

    @Override
    public void generaLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
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

  /*  public void inicializarLista(){
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
    }*/
}
