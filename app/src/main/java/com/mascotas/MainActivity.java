package com.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mascotas.fragments.RecyclerViewFragment;
import com.mascotas.pojo.Mascota;
import com.mascotas.pojo.MascotaManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Mascota> datosMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MascotaManager managerDB=new MascotaManager(getApplicationContext());
        datosMascotas= managerDB.traeMascotas();
        Toolbar customActionBar = findViewById(R.id.custom_action_bar);
        setSupportActionBar(customActionBar);
    }
    public void Inicio(View view){
        Intent intent = new Intent(this,ListaMascotas.class);
        startActivity(intent);
    }
}