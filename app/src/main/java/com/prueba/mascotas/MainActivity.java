package com.prueba.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.prueba.mascotas.adaptadores.MascotaAdaptador;
import com.prueba.mascotas.adaptadores.PageAdapter;
import com.prueba.mascotas.fragments.MascotaFragment;
import com.prueba.mascotas.fragments.PerfilMascotaFragment;
import com.prueba.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        ImageButton boton = (ImageButton) findViewById(R.id.ibActionView);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , Mascotas_Favoritas.class);
                startActivity(i);
            }
        });

        setSupportActionBar(miActionBar) ;
        setUpViewPager();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }


    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotaFragment());
        fragments.add(new PerfilMascotaFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_face_dog);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case R.id.mAbout:
                i = new Intent(MainActivity.this, BibliografiaDesarrollador.class);
                startActivity(i);
                break;
            case R.id.mContact:
                i = new Intent(MainActivity.this, FormularioCorreo.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
