package com.prueba.mascotas.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.prueba.mascotas.R;
import com.prueba.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Intel on 04/01/2017.
 */

public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaViewHolder> {


    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaPerfilAdaptador(ArrayList<Mascota> mascotas) {
        Log.d("LLego ","MascotaPerfilAdaptador");
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        activity = (Activity) parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascotas,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final int pos = position;
        final Mascota mascota   = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.cantidadMegusta.setText(String.valueOf(mascota.getMegusta()));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView  cantidadMegusta;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imFoto);
            cantidadMegusta = (TextView) itemView.findViewById(R.id.tvCantidadLike);
        }

    }
}
