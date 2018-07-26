package com.aprendiz.ragp.turisapp5.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aprendiz.ragp.turisapp5.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestorDB extends SQLiteOpenHelper{
    public GestorDB(Context context) {
        super(context, "sitios.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE LUGARES (IMAGEN TEXT, NOMBRE TEXT, DESCRIPCIONC TEXT, UBICACION TEXT, DESCRIPCION TEXT, LATITUD TEXT, LONGITUD TEXT, LUGAR TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void inputSitios(Context context) throws IOException {
        String linea;
        InputStream is = context.getResources().openRawResource(R.raw.sitiosm);
        SQLiteDatabase db = getWritableDatabase();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null){
            int i=0;
            while ((linea = reader.readLine())!=null){
                ContentValues values = new ContentValues();
                values.put("IMAGEN",Constants.listaSitios[i]);
                values.put("NOMBRE",linea.split(";")[0]);
                values.put("DESCRIPCIONC",linea.split(";")[1]);
                values.put("UBICACION",linea.split(";")[2]);
                values.put("DESCRIPCION",linea.split(";")[3]);
                values.put("LATITUD",linea.split(";")[4]);
                values.put("LONGITUD",linea.split(";")[5]);
                values.put("LUGAR","sitio");
                db.insert("LUGARES",null, values);

            }
        }

        db.close();
    }


    public void inputHoteles(Context context) throws IOException {
        String linea;
        InputStream is = context.getResources().openRawResource(R.raw.hotelesm);
        SQLiteDatabase db = getWritableDatabase();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null){
            int i=0;
            while ((linea = reader.readLine())!=null){
                ContentValues values = new ContentValues();
                values.put("IMAGEN",Constants.listaHoteles[i]);
                values.put("NOMBRE",linea.split(";")[0]);
                values.put("DESCRIPCIONC",linea.split(";")[1]);
                values.put("UBICACION",linea.split(";")[2]);
                values.put("DESCRIPCION",linea.split(";")[3]);
                values.put("LATITUD",linea.split(";")[4]);
                values.put("LONGITUD",linea.split(";")[5]);
                values.put("LUGAR","hotel");
                db.insert("LUGARES",null, values);

            }
        }

        db.close();
    }


    public void inputRestaurantes(Context context) throws IOException {
        String linea;
        InputStream is = context.getResources().openRawResource(R.raw.restaurantesm);
        SQLiteDatabase db = getWritableDatabase();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null){
            int i=0;
            while ((linea = reader.readLine())!=null){
                ContentValues values = new ContentValues();
                values.put("IMAGEN",Constants.listaRestaurantes[i]);
                values.put("NOMBRE",linea.split(";")[0]);
                values.put("DESCRIPCIONC",linea.split(";")[1]);
                values.put("UBICACION",linea.split(";")[2]);
                values.put("DESCRIPCION",linea.split(";")[3]);
                values.put("LATITUD",linea.split(";")[4]);
                values.put("LONGITUD",linea.split(";")[5]);
                values.put("LUGAR","restaurante");
                db.insert("LUGARES",null, values);

            }
        }

        db.close();
    }



    public List<Sitios> sitiosList(){
        List<Sitios> results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LUGARES WHERE LUGAR ='sitio'; ",null);
        if (cursor.moveToFirst()){
            do {
                Sitios sitios = new Sitios();
                sitios.setImagen(Integer.parseInt(cursor.getString(0)));
                sitios.setNombre(cursor.getString(1));
                sitios.setDescripcionc(cursor.getString(2));
                sitios.setUbicacion(cursor.getString(3));
                sitios.setDescripcion(cursor.getString(4));
                sitios.setLatitud(Float.parseFloat(cursor.getString(5)));
                sitios.setLongitud(Float.parseFloat(cursor.getString(6)));
                sitios.setLugar(cursor.getString(7));

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return results;
    }


    public List<Sitios> hotelList(){
        List<Sitios> results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LUGARES WHERE LUGAR ='hotel'; ",null);
        if (cursor.moveToFirst()){
            do {
                Sitios sitios = new Sitios();
                sitios.setImagen(Integer.parseInt(cursor.getString(0)));
                sitios.setNombre(cursor.getString(1));
                sitios.setDescripcionc(cursor.getString(2));
                sitios.setUbicacion(cursor.getString(3));
                sitios.setDescripcion(cursor.getString(4));
                sitios.setLatitud(Float.parseFloat(cursor.getString(5)));
                sitios.setLongitud(Float.parseFloat(cursor.getString(6)));
                sitios.setLugar(cursor.getString(7));

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return results;
    }

    public List<Sitios> restauranteList(){
        List<Sitios> results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LUGARES WHERE LUGAR ='restaurante'; ",null);
        if (cursor.moveToFirst()){
            do {
                Sitios sitios = new Sitios();
                sitios.setImagen(Integer.parseInt(cursor.getString(0)));
                sitios.setNombre(cursor.getString(1));
                sitios.setDescripcionc(cursor.getString(2));
                sitios.setUbicacion(cursor.getString(3));
                sitios.setDescripcion(cursor.getString(4));
                sitios.setLatitud(Float.parseFloat(cursor.getString(5)));
                sitios.setLongitud(Float.parseFloat(cursor.getString(6)));
                sitios.setLugar(cursor.getString(7));

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return results;
    }

}
