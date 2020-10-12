package com.mascotas.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.mascotas.R;
import com.mascotas.adapter.FavoritoAdapter;
import com.mascotas.adapter.MascotasAdapter;
import com.mascotas.dao.QuerysBBDD;
import com.mascotas.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;


public class FragmentPerfil extends Fragment {


    QuerysBBDD conexion;
    private CircularImageView perfil;
    private TextView textoFavorito;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        RecyclerView recyclerViewFavoritoMascotas = v.findViewById(R.id.recyclerFavorito);

        GridLayoutManager grid = new GridLayoutManager(getActivity(), 3);

        recyclerViewFavoritoMascotas.setLayoutManager(grid);


        conexion= new QuerysBBDD(getContext());



        perfil = v.findViewById(R.id.circularImageView);
        textoFavorito = v.findViewById(R.id.txt_mascotaFavorita);



        perfil.setCircleColor(R.color.colorAccent);
        perfil.setBorderColor(R.color.colorPrimaryDark);
        perfil.setShadowColor(R.color.colorAccent);
        perfil.setImageResource(conexion.obtenerMascotaFavorita().getFoto());
        perfil.setElevation(10);

        textoFavorito.setText(conexion.obtenerMascotaFavorita().getNombre());


        Mascota favorita=conexion.obtenerMascotaFavorita();
        RecyclerViewFragment.cargarImagenes(favorita,8);
        FavoritoAdapter adaptador = new FavoritoAdapter(favorita);

        recyclerViewFavoritoMascotas.setAdapter(adaptador);

        return v;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

}



