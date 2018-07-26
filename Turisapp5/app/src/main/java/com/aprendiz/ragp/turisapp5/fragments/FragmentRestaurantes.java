package com.aprendiz.ragp.turisapp5.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aprendiz.ragp.turisapp5.R;
import com.aprendiz.ragp.turisapp5.maps.RestaurantMaps;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRestaurantes extends Fragment {


    public FragmentRestaurantes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_restaurantes, container, false);

        FloatingActionButton res = view.findViewById(R.id.btnrestau);
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RestaurantMaps.class);
                startActivity(intent);

            }
        });


        return view;
    }

}
