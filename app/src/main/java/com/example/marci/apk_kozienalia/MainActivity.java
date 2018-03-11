package com.example.marci.apk_kozienalia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.marci.apk_kozienalia.Fragmenty_ViewHoldery.kalendarz_fragment;
import com.example.marci.apk_kozienalia.Fragmenty_ViewHoldery.mapa_fragment;
import com.example.marci.apk_kozienalia.Fragmenty_ViewHoldery.str_glowna_fragment;
import com.example.marci.apk_kozienalia.Fragmenty_ViewHoldery.ulubione_fragment;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.str_glowna:
                    str_glowna_fragment str_gl_f = new str_glowna_fragment();
                    android.support.v4.app.FragmentManager manager_glowna = getSupportFragmentManager();
                    manager_glowna.beginTransaction().replace(R.id.contentLayout, str_gl_f, str_gl_f.getTag()).commit();
                    return true;
                case R.id.ulubione:
                    ulubione_fragment ulub_f = new ulubione_fragment();
                    android.support.v4.app.FragmentManager manager_ulub = getSupportFragmentManager();
                    manager_ulub.beginTransaction().replace(R.id.contentLayout, ulub_f, ulub_f.getTag()).commit();
                    return true;
                case R.id.kalendarz:
                    kalendarz_fragment kalendarz_f = new kalendarz_fragment();
                    android.support.v4.app.FragmentManager manager_kalendarz = getSupportFragmentManager();
                    manager_kalendarz.beginTransaction().replace(R.id.contentLayout, kalendarz_f, kalendarz_f.getTag()).commit();
                    return true;
                case R.id.mapa:
                    mapa_fragment mapa_f = new mapa_fragment();
                    android.support.v4.app.FragmentManager manager_mapa = getSupportFragmentManager();
                    manager_mapa.beginTransaction().replace(R.id.contentLayout, mapa_f, mapa_f.getTag()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.contentLayout, new str_glowna_fragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getItemTextColor();
    }

}
