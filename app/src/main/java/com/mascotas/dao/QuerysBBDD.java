package com.mascotas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class QuerysBBDD extends SQLiteOpenHelper {

       private Context context;

        public QuerysBBDD(Context context) {
            super(context, Conector.NombreBaseDatos, null, Conector.VersionBaseDatos);
            this.context = context;

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String queryCrearTablaMascota = " CREATE TABLE " + Conector.TABLA_MASCOTA + "(" +
                    Conector.TABLA_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Conector.TABLA_MASCOTA_NOMBRE + " TEXT, " +
                    Conector.TABLA_MASCOTA_FOTO + " INTEGER " +
                    ")";

            String queryCrearTablaCalificacionesContacto = "CREATE TABLE " + Conector.TABLA_CALIFICACION_MASCOTA + "(" +
                    Conector.TABLA_CALIFICACION_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA + " INTEGER, " +
                    Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION + " INTEGER, " +
                    "FOREIGN KEY (" + Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA + ") " +
                    "REFERENCES " + Conector.TABLA_MASCOTA + "(" + Conector.TABLA_MASCOTA_ID + ")" +
                    ")";

            db.execSQL(queryCrearTablaMascota);
            db.execSQL(queryCrearTablaCalificacionesContacto);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + Conector.TABLA_MASCOTA);
            db.execSQL("DROP TABLE IF EXISTS " + Conector.TABLA_CALIFICACION_MASCOTA);
            onCreate(db);
        }

        public ArrayList<Mascota> obtenerTodasMascotas() {
            ArrayList<Mascota> mascotas = new ArrayList<>();

            //Traemos todos los datos de la tabla mascota
            String query = "SELECT * FROM " + Conector.TABLA_MASCOTA;
            SQLiteDatabase db = this.getWritableDatabase();

            //Generamos cursor donde se guardan los datos
            Cursor registros = db.rawQuery(query, null);

            //Creamos los objetos Mascota con cada registro de la BBDD
            //asignando a cada atributo el dato correspondiente que recuperamos de la BBDD
            while (registros.moveToNext()) {
                Mascota mascota = new Mascota();
                mascota.setId_mascota(registros.getInt(0));
                mascota.setNombre(registros.getString(1));
                mascota.setFoto(registros.getInt(2));

                //Se arma la query para recuperar los likes
                String querycalificaciones = "SELECT SUM(" + Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION + ") as likes " +
                        " FROM " + Conector.TABLA_CALIFICACION_MASCOTA +
                        " WHERE " + Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA + "=" + mascota.getId_mascota();

                //ejecutamos la query y la asignamos a un nuevo cursor
                Cursor calificaciones = db.rawQuery(querycalificaciones, null);

                //Asignamos los likes a la variable
                if (calificaciones.moveToNext()) {
                    mascota.setCalificacion(calificaciones.getInt(0));
                } else {
                    mascota.setCalificacion(0);
                }
                //sumamos el objeto Mascota recuperado de la BBDD a la lista de mascotas
                mascotas.add(mascota);
            }

            db.close();
            return mascotas;
        }


        public ArrayList<Mascota> obtenerMascotasFavoritas() {
            ArrayList<Mascota> mascotas = new ArrayList<>();

            String query = "SELECT * FROM " + Conector.TABLA_MASCOTA + " TM, " + Conector.TABLA_CALIFICACION_MASCOTA + " TC" +
                    " WHERE " + "TM." + Conector.TABLA_MASCOTA_ID + "=" + "TC." + Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA +
                    " ORDER BY " + "TC." + Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION + " DESC" + " LIMIT 5";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor registros = db.rawQuery(query, null);

            while (registros.moveToNext()) {
                Mascota mascota = new Mascota();
                mascota.setId_mascota(registros.getInt(0));
                mascota.setNombre(registros.getString(1));
                mascota.setFoto(registros.getInt(2));

                String queryCalificaciones = "SELECT SUM(" + Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION + ") as likes " +
                        " FROM " + Conector.TABLA_CALIFICACION_MASCOTA +
                        " WHERE " + Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA + "=" + mascota.getId_mascota();

                Cursor calificaciones = db.rawQuery(queryCalificaciones, null);

                if (calificaciones.moveToNext()) {
                    mascota.setCalificacion(calificaciones.getInt(0));
                } else {
                    mascota.setCalificacion(0);
                }

                mascotas.add(mascota);
            }
            db.close();
            return mascotas;
        }

        //obtener mascota favorita
        public Mascota obtenerMascotaFavorita() {
            Mascota mascotafavorita = new Mascota();

            String query = "SELECT * FROM " + Conector.TABLA_MASCOTA + " TM, " + Conector.TABLA_CALIFICACION_MASCOTA + " TC" +
                    " WHERE " + "TM." + Conector.TABLA_MASCOTA_ID + "=" + "TC." + Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA +
                    " ORDER BY " + "TC." + Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION + " DESC" + " LIMIT 1";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor registros = db.rawQuery(query, null);

            while (registros.moveToNext()) {

                mascotafavorita.setId_mascota(registros.getInt(0));
                mascotafavorita.setNombre(registros.getString(1));
                mascotafavorita.setFoto(registros.getInt(2));

                String queryCalificaciones = "SELECT SUM(" + Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION + ") as likes " +
                        " FROM " + Conector.TABLA_CALIFICACION_MASCOTA +
                        " WHERE " + Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA + "=" + mascotafavorita.getId_mascota();

                Cursor calificaciones = db.rawQuery(queryCalificaciones, null);

                if (calificaciones.moveToNext()) {
                    mascotafavorita.setCalificacion(calificaciones.getInt(0));
                } else {
                    mascotafavorita.setCalificacion(0);
                }


            }
            db.close();
            return mascotafavorita;
        }







        public void insertarMascota(ContentValues contentValues) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(Conector.TABLA_MASCOTA, null, contentValues);
            db.close();
        }

        public void insertarCalificacionesMascota(ContentValues contentValues) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(Conector.TABLA_CALIFICACION_MASCOTA, null, contentValues);
            db.close();
        }

        public int obtenerCalificacionMascota(Mascota mascota) {
            int calificacion = 0;

            String query = "SELECT COUNT(" + Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION + ")" +
                    " FROM " + Conector.TABLA_CALIFICACION_MASCOTA +
                    " WHERE " + Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA + "=" + mascota.getId_mascota();

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor registros = db.rawQuery(query, null);

            if (registros.moveToNext()) {
                calificacion = registros.getInt(0);
            }

            db.close();
            return calificacion;
        }

        //update de Calificaciones de mascotas

        public void actualizarCalificacion(ContentValues contentValues){
/*            SQLiteDatabase db = this.getWritableDatabase();
            db.update(Conector.TABLA_CALIFICACION_MASCOTA,contentValues,contentValues.getAsString(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA),
                    contentValues.getAsString(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION));
*/          String id=contentValues.getAsString(Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA);
            String valor=contentValues.getAsString(Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION);


                SQLiteDatabase db = this.getReadableDatabase();
                db.execSQL("UPDATE "+Conector.TABLA_CALIFICACION_MASCOTA+" SET "+ Conector.TABLA_CALIFICACION_MASCOTA_NUMERO_CALIFICACION +
                        "= "+valor+ " WHERE "+ Conector.TABLA_CALIFICACION_MASCOTA_ID_MASCOTA + "=" + id);
                db.close();
            }


        }









