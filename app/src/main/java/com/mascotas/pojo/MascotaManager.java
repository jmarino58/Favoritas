package com.mascotas.pojo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.mascotas.R;
import com.mascotas.dao.QuerysBBDD;
import com.mascotas.dao.Conector;

import java.util.ArrayList;



public class MascotaManager {


        private static final int CALIFICACIONES = 1;
        private static Context context;
        private ArrayList<Mascota> mascotas;

        public MascotaManager(Context context) {
            this.context = context;
        }

        public ArrayList<Mascota> traeMascotas(){

            QuerysBBDD db = new QuerysBBDD(context);
            SQLiteDatabase database = db.getWritableDatabase();

            db.onUpgrade(database,1,1);

            insertarMascotas(db);
            return db.obtenerTodasMascotas();
        }

        public ArrayList<Mascota> obtenerFavorita(){
            QuerysBBDD db = new QuerysBBDD(context);
            return db.obtenerMascotasFavoritas();
        }

        public void insertarMascotas(QuerysBBDD db){


            ContentValues contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Cebra");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.cebra);

            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,1);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,5);
            db.insertarCalificacionesMascota(contentValues);


            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Conejo");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.conejo);
            db.insertarMascota(contentValues);


            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,2);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,15);
            db.insertarCalificacionesMascota(contentValues);


            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Elefante");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.elefante);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,3);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,0);
            db.insertarCalificacionesMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Panda");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.panda);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,4);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,25);
            db.insertarCalificacionesMascota(contentValues);


            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Gato");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.gato);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,5);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,50);
            db.insertarCalificacionesMascota(contentValues);


            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Jirafa");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.jirafa);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,6);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,0);
            db.insertarCalificacionesMascota(contentValues);


            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Leon");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.leon);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,7);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,0);
            db.insertarCalificacionesMascota(contentValues);


            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Mono");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.mono);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,8);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,3);
            db.insertarCalificacionesMascota(contentValues);


            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Perro");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.perro);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,9);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,300);
            db.insertarCalificacionesMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Simio");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.simio);
            db.insertarMascota(contentValues);


            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,10);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,0);
            db.insertarCalificacionesMascota(contentValues);


            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_MASCOTA_NOMBRE, "Tigre");
            contentValues.put(Conector.TABLA_MASCOTA_FOTO, R.drawable.tigre);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,11);
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,0);
            db.insertarCalificacionesMascota(contentValues);


        }

        public void calificarMascota (Mascota mascota) {
            QuerysBBDD db = new QuerysBBDD(context);
            ContentValues contentValues = new ContentValues();
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA, mascota.getId_mascota());
            contentValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION, CALIFICACIONES);
            db.insertarCalificacionesMascota(contentValues);
        }

        public int obtenerCalificacion (Mascota mascota) {
            QuerysBBDD db = new QuerysBBDD(context);
            return db.obtenerCalificacionMascota(mascota);
        }

        public static void actualizarCalificacion(int id,int valor){
            ContentValues contenValues= new ContentValues();
            contenValues.put(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA,id);
            contenValues.put(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION,valor);
            QuerysBBDD db = new QuerysBBDD(context);
            db.actualizarCalificacion(contenValues);


        }






    }
