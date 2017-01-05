package com.prueba.mascotas.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
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
 * Created by Intel on 23/12/2016.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {


    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        activity = (Activity) parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final int pos = position;
        final Mascota mascota   = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.nombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.cantidadMegusta.setText(String.valueOf(mascota.getMegusta()));

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cadena = (String) mascotaViewHolder.cantidadMegusta.getText();
                int cantidad = Integer.parseInt(cadena)+1;
                mascotaViewHolder.cantidadMegusta.setText(String.valueOf(cantidad));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView nombreMascota;
        private TextView  cantidadMegusta;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imFoto);
            nombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            cantidadMegusta = (TextView) itemView.findViewById(R.id.tvCantidadLike);
            btnLike = (ImageButton)itemView.findViewById(R.id.ibFotoLike);
        }

    }
}
