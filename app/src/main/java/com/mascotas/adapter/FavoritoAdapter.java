package com.mascotas.adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mascotas.pojo.Mascota;
import com.mascotas.R;
import com.mascotas.fragments.RecyclerViewFragment;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static java.security.AccessController.getContext;


public class FavoritoAdapter extends RecyclerView.Adapter<FavoritoAdapter.MyViewHolder> {
    private Mascota mascotaFavorita;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewFavoritoListItem;
        private final TextView cantidadLikes;
        private final ImageView imagenLikes;




        public MyViewHolder(View itemView) {
            super(itemView);



            imageViewFavoritoListItem = itemView.findViewById(R.id.image_favorito_list_item);
            imagenLikes= itemView.findViewById(R.id.imagenlikesPerfil);
            cantidadLikes = itemView.findViewById(R.id.txt_numeroLikes);
        }
    }

    public FavoritoAdapter(Mascota mascota) {
                mascotaFavorita=mascota;
    }

    // Crea una nueva Vista
    @Override
    public FavoritoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View element = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.perfil_items_gridlayout, parent, false);
        return new FavoritoAdapter.MyViewHolder(element);
    }

    // Reemplaza el contenido de la vista
    @Override
    public void onBindViewHolder(@NonNull FavoritoAdapter.MyViewHolder holder, final int position) {
        // Toma cada elemento desde el dataset y reemplaza el contenido de la vista con el
        // elemento


        final TextView textRateInt = holder.cantidadLikes;
        holder.imageViewFavoritoListItem.setImageResource(mascotaFavorita.getImagen().get(position));
        textRateInt.setText(String.valueOf(mascotaFavorita.getCalificacion()));
        holder.imagenLikes.setImageResource(R.drawable.ic_pet_food_yellow);

    }

    // Devuelve tamaño de dataset
    @Override
    public int getItemCount() {
        if (mascotaFavorita!= null) {
            return mascotaFavorita.getImagen().size();
        }else {
            return 0;
        }
    }
}







    /*
    private Context mcontext;

    public FavoritoAdapter(Context c){
        mcontext = c ;
    }

    @Override
    public int getCount() {
        return mThumbsIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @NonNull
    @Override
    public FavoritoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritoAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView image;
        if (convertView==null) {
            image = new ImageView(mcontext);
            image.setLayoutParams(new GridView.LayoutParams(85, 85));
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            image.setPadding(8, 8, 8, 8);
        } else {
            image= (ImageView) convertView;

        }
        image.setImageResource(mThumbsIds[position]);

        return image;
    }


        private static Integer[] mThumbsIds ={

            };

}*/