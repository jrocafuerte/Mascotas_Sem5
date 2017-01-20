package com.prueba.mascotas.db;

/**
 * Created by Intel on 19/01/2017.
 */

public class ConstantesBD {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLEMASCOTA_NAME = "mascota";
    public static final String TABLEMASCOTA_ID = "id";
    public static final String TABLEMASCOTA_NOMBRE = "nombre";
    public static final String TABLEMASCOTA_FOTO = "foto";
    public static final String TABLEMASCOTA_FOTO_LIKE = "fotolike";

    public static final String TABLEMASCOTALIKE_NAME = "mascotalike";
    public static final String TABLEMASCOTALIKE_ID = "id";
    public static final String TABLEMASCOTALIKE_IDMASCOTA = "id_mascota";
    public static final String TABLEMASCOTALIKE_LIKE = "like";

}
