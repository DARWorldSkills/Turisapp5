
package com.aprendiz.ragp.turisapp5.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;

import com.aprendiz.ragp.turisapp5.R;
import com.aprendiz.ragp.turisapp5.models.AdapterT;
import com.aprendiz.ragp.turisapp5.models.GestorDB;
import com.aprendiz.ragp.turisapp5.models.Sitios;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSitios#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSitios extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    Sitios sitios;
    int position;
    int valorcito=0;


    public FragmentSitios() {
        // Required empty public constructor
    }

    public static FragmentSitios newInstance(String param1, String param2) {
        FragmentSitios fragment = new FragmentSitios();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_sitios, container, false);
        recyclerView = view.findViewById(R.id.recyclerS);


        return view;
    }

    public void inputAdapterR(){
        GestorDB gestorDB = new GestorDB(getContext());
        List<Sitios> sitiosList = gestorDB.sitiosList();

        position= getActivity().getWindowManager().getDefaultDisplay().getRotation();
        if (position== Surface.ROTATION_0 || position== Surface.ROTATION_180) {
            if (valorcito==0) {
                AdapterT adapterT = new AdapterT(sitiosList, R.layout.item_list);
            }else {
                AdapterT adapterT = new AdapterT(sitiosList, R.layout.item_grid);
            }
        }

        if (position== Surface.ROTATION_270 || position== Surface.ROTATION_90) {
            AdapterT adapterT = new AdapterT(sitiosList, R.layout.item_land);
        }

    }

}
