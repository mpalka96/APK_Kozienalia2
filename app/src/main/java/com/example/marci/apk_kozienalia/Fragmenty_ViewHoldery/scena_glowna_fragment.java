package com.example.marci.apk_kozienalia.Fragmenty_ViewHoldery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marci.apk_kozienalia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class scena_glowna_fragment extends Fragment {


    public scena_glowna_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_scena_glowna, container, false);

    }

}
