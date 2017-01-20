package com.prueba.mascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.prueba.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Intel on 19/01/2017.
 */

public class BaseDatosAuxiliar extends SQLiteOpenHelper {

    private Context context;
    public BaseDatosAuxiliar(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE "+ConstantesBD.TABLEMASCOTA_NAME+"("+
                                                        ConstantesBD.TABLEMASCOTA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                                        ConstantesBD.TABLEMASCOTA_NOMBRE +" TEXT,"+
                                                        ConstantesBD.TABLEMASCOTA_FOTO +" INTEGER,"+
                                                        ConstantesBD.TABLEMASCOTA_FOTO_LIKE +" INTEGER )";

        String queryCrearTablaLikeMascota = "CREATE TABLE "+ConstantesBD.TABLEMASCOTALIKE_NAME+"("+
                                                            ConstantesBD.TABLEMASCOTALIKE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                                            ConstantesBD.TABLEMASCOTALIKE_IDMASCOTA+" INTERGER ,"+
                                                            ConstantesBD.TABLEMASCOTALIKE_LIKE+" INTERGER, "+
                                                            "FOREIGN KEY ("+ConstantesBD.TABLEMASCOTALIKE_IDMASCOTA+")"+
                                                            "REFERENCES "+ConstantesBD.TABLEMASCOTA_NAME + "("+ConstantesBD.TABLEMASCOTA_ID+"))";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikeMascota);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ConstantesBD.TABLEMASCOTA_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ConstantesBD.TABLEMASCOTALIKE_NAME);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodoslosRegistros(String band){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros;
        int count = 0;

        if(band.equals("S")){
            query = "SELECT MAS.*,LIK."+ConstantesBD.TABLEMASCOTALIKE_LIKE+" FROM "+ConstantesBD.TABLEMASCOTA_NAME + " MAS JOIN "+
                    ConstantesBD.TABLEMASCOTALIKE_NAME+" LIK ON MAS."+ConstantesBD.TABLEMASCOTA_ID +" = LIK."+ConstantesBD.TABLEMASCOTALIKE_IDMASCOTA+
                    " ORDER BY LIK."+ConstantesBD.TABLEMASCOTALIKE_LIKE+" DESC ";

            registros = db.rawQuery(query,null);

            while(registros.moveToNext()){
                count= count +1;
                Mascota mascotaActual = new Mascota();
                mascotaActual.setId(registros.getInt(0));
                mascotaActual.setNombre(registros.getString(1));
                mascotaActual.setFoto(registros.getInt(2));
                mascotaActual.setFotolike(registros.getInt(3));
                mascotaActual.setMegusta(registros.getInt(4));

                mascotas.add(mascotaActual);
                if (count == 5){
                    break;
                }

            }
            db.close();

        }else{
            query = "SELECT * FROM "+ConstantesBD.TABLEMASCOTA_NAME;


            registros = db.rawQuery(query,null);

            while(registros.moveToNext()){
                Mascota mascotaActual = new Mascota();
                mascotaActual.setId(registros.getInt(0));
                mascotaActual.setNombre(registros.getString(1));
                mascotaActual.setFoto(registros.getInt(2));
                mascotaActual.setFotolike(registros.getInt(3));


                String queryLike = "SELECT "+ConstantesBD.TABLEMASCOTALIKE_LIKE+
                        " FROM "+ConstantesBD.TABLEMASCOTALIKE_NAME +
                        " WHERE "+ConstantesBD.TABLEMASCOTALIKE_IDMASCOTA + " = " + mascotaActual.getId();


                Cursor registrosLike = db.rawQuery(queryLike,null);
                if(registrosLike.moveToNext()){
                    mascotaActual.setMegusta(registrosLike.getInt(0));
                }else{
                    mascotaActual.setMegusta(0);
                }

                mascotas.add(mascotaActual);
            }
            db.close();

        }

        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLEMASCOTA_NAME,null,contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLEMASCOTALIKE_NAME,null,contentValues);
        db.close();
    }

    public int obtenerLikes(Mascota mascota){
        int result=0;

        String query = "SELECT " +ConstantesBD.TABLEMASCOTALIKE_LIKE+
                       " FROM "+ConstantesBD.TABLEMASCOTALIKE_NAME +
                       " WHERE "+ConstantesBD.TABLEMASCOTALIKE_IDMASCOTA + " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            result = registros.getInt(0);
        }
        db.close();
        return result;
    }

   public void actualizaLikeContacto(Mascota mascota,ContentValues contentValues){
       String where;
       SQLiteDatabase db = this.getWritableDatabase();
       where = ConstantesBD.TABLEMASCOTALIKE_IDMASCOTA +" = "+ mascota.getId();
       db.update(ConstantesBD.TABLEMASCOTALIKE_NAME,contentValues,where,null);
       db.close();
   }
}
