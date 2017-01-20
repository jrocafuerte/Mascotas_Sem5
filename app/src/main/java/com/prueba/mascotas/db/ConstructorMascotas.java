package com.prueba.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.prueba.mascotas.R;
import com.prueba.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Intel on 19/01/2017.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;


    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(String band){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        BaseDatosAuxiliar bd = new BaseDatosAuxiliar(context);
        insertarContactos(bd);
        if(band.equals("S")){
            mascotas = bd.obtenerTodoslosRegistros("S");
        }else{
            mascotas = bd.obtenerTodoslosRegistros("N");
        }


        return mascotas;
    }

    public void insertarContactos(BaseDatosAuxiliar bd){
        ContentValues values = new ContentValues();
        values.put(ConstantesBD.TABLEMASCOTA_NOMBRE,"Roberth");
        values.put(ConstantesBD.TABLEMASCOTA_FOTO,R.drawable.img1);
        values.put(ConstantesBD.TABLEMASCOTA_FOTO_LIKE,R.drawable.dog_bone_50);
        bd.insertarMascotas(values);

        values.put(ConstantesBD.TABLEMASCOTA_NOMBRE,"Chester");
        values.put(ConstantesBD.TABLEMASCOTA_FOTO,R.drawable.img2);
        values.put(ConstantesBD.TABLEMASCOTA_FOTO_LIKE,R.drawable.dog_bone_50);
        bd.insertarMascotas(values);

        values.put(ConstantesBD.TABLEMASCOTA_NOMBRE,"Firulays");
        values.put(ConstantesBD.TABLEMASCOTA_FOTO,R.drawable.img3);
        values.put(ConstantesBD.TABLEMASCOTA_FOTO_LIKE,R.drawable.dog_bone_50);
        bd.insertarMascotas(values);

        values.put(ConstantesBD.TABLEMASCOTA_NOMBRE,"Lassy");
        values.put(ConstantesBD.TABLEMASCOTA_FOTO,R.drawable.img4);
        values.put(ConstantesBD.TABLEMASCOTA_FOTO_LIKE,R.drawable.dog_bone_50);
        bd.insertarMascotas(values);

        values.put(ConstantesBD.TABLEMASCOTA_NOMBRE,"Rintinting");
        values.put(ConstantesBD.TABLEMASCOTA_FOTO,R.drawable.img5);
        values.put(ConstantesBD.TABLEMASCOTA_FOTO_LIKE,R.drawable.dog_bone_50);
        bd.insertarMascotas(values);

        values.put(ConstantesBD.TABLEMASCOTA_NOMBRE,"Baldo");
        values.put(ConstantesBD.TABLEMASCOTA_FOTO,R.drawable.img1);
        values.put(ConstantesBD.TABLEMASCOTA_FOTO_LIKE,R.drawable.dog_bone_50);
        bd.insertarMascotas(values);

        values.put(ConstantesBD.TABLEMASCOTA_NOMBRE,"Manchas");
        values.put(ConstantesBD.TABLEMASCOTA_FOTO,R.drawable.img2);
        values.put(ConstantesBD.TABLEMASCOTA_FOTO_LIKE,R.drawable.dog_bone_50);
        bd.insertarMascotas(values);

        values.put(ConstantesBD.TABLEMASCOTA_NOMBRE,"Lassy 2");
        values.put(ConstantesBD.TABLEMASCOTA_FOTO,R.drawable.img3);
        values.put(ConstantesBD.TABLEMASCOTA_FOTO_LIKE,R.drawable.dog_bone_50);
        bd.insertarMascotas(values);
    }

    public void darLike(Mascota mascota){
        // Valido Registro en BD
        int result = 0;
        ContentValues values = new ContentValues();
        BaseDatosAuxiliar bd = new BaseDatosAuxiliar(context);
        result = bd.obtenerLikes(mascota);
        if(result > 0){
            // actualizo el valor
            Log.d("Actualiza JRO","JRO Actualiza");
            values.put(ConstantesBD.TABLEMASCOTALIKE_LIKE , result+1);
            bd.actualizaLikeContacto(mascota,values);
        }else{
            // Inserto Registro
            values.put(ConstantesBD.TABLEMASCOTALIKE_IDMASCOTA, mascota.getId());
            values.put(ConstantesBD.TABLEMASCOTALIKE_LIKE , LIKE);
            bd.insertarLikeContacto(values);
        }





    }

    public int obtenerLike(Mascota mascota){

       BaseDatosAuxiliar bd = new BaseDatosAuxiliar(context);
        return bd.obtenerLikes(mascota);
    }
}
