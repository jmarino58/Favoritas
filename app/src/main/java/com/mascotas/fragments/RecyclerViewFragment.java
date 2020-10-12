package com.mascotas.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mascotas.MainActivity;
import com.mascotas.dao.QuerysBBDD;
import com.mascotas.pojo.Mascota;
import com.mascotas.R;
import com.mascotas.adapter.MascotasAdapter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {


    QuerysBBDD conexion;

    // Creamos un nuevo ArrayList para guardar la lista ordenada
    public static ArrayList<Mascota> mascotasFavoritas = new ArrayList<>();

    MascotasAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentrecyclerview_listado,container,false);
        RecyclerView recyclerViewListaMascotas = v.findViewById(R.id.recycler_view_layout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewListaMascotas.setLayoutManager(layoutManager);
        //conexion= new QuerysBBDD(getContext());
        //initData();


        adapter = new MascotasAdapter(MainActivity.datosMascotas);
        recyclerViewListaMascotas.setAdapter(adapter);



        return v;
    }

    public void initData() {
//        MainActivity.datosMascotas = conexion.obtenerTodasMascotas();
        /*
        datosMascotas.add(new Mascota(R.drawable.cebra, getString(R.string.Cebra)));

        datosMascotas.add(new Mascota(R.drawable.conejo, getString(R.string.Conejo)));

        datosMascotas.add(new Mascota(R.drawable.elefante, getString(R.string.Elefante)));

        datosMascotas.add(new Mascota(R.drawable.leon, getString(R.string.Leon)));

        datosMascotas.add(new Mascota(R.drawable.jirafa, getString(R.string.Jirafa)));

        datosMascotas.add(new Mascota(R.drawable.gato, getString(R.string.Gato)));

        datosMascotas.add(new Mascota(R.drawable.mono, getString(R.string.Mono)));

        datosMascotas.add(new Mascota(R.drawable.panda, getString(R.string.Panda)));

        datosMascotas.add(new Mascota(R.drawable.perro, getString(R.string.Perro)));

        datosMascotas.add(new Mascota(R.drawable.simio, getString(R.string.Simio)));

        datosMascotas.add(new Mascota(R.drawable.tigre, getString(R.string.Tigre)));
        */
    }

    public static void calcularDatosFavorito(QuerysBBDD conexion) {

        mascotasFavoritas= conexion.obtenerMascotasFavoritas();
        //mascotasFavoritas.subList(5, mascotasFavoritas.size()).clear();


        /*
        // agregamos un objeto a la lista ordenada
        mascotasFavoritas.add(datosMascotas.get(0));
        boolean set;
        // se recorre el dataset
        for (int firstList = 1; firstList < datosMascotas.size(); firstList++) {
            set = false;
            for (int secondList = 0; (secondList < mascotasFavoritas.size() && !set); secondList++) {
                // se realiza la evaluación para ordenar los elementos de la lista favoritos
                //de mayor a menor puntaje
                //if (datosMascotas.get(firstList).getCalificacion()!=0) {
                if (datosMascotas.get(firstList).getCalificacion() >= mascotasFavoritas.get(secondList).getCalificacion()) {
                    mascotasFavoritas.add(secondList, datosMascotas.get(firstList));
                    set = true;

                    //}
                }
            }
            if (!set) mascotasFavoritas.add(datosMascotas.get(firstList));
        }
        mascotasFavoritas.subList(5, mascotasFavoritas.size()).clear();
        cargarImagenes(8);*/
    }

    public static void cargarImagenes(Mascota mascota, int cantidad) {

        for (int x = 0; x <= cantidad; x++) {

            mascota.setImagen(mascota.getFoto());

        }
    }



    }

