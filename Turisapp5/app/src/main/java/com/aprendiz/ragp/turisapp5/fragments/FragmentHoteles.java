package com.aprendiz.ragp.turisapp5.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aprendiz.ragp.turisapp5.R;
import com.aprendiz.ragp.turisapp5.maps.HotelMaps;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHoteles extends Fragment {


    public FragmentHoteles() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_hoteles, container, false);

        FloatingActionButton hot = view.findViewById(R.id.btnHotel);
        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HotelMaps.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
