package com.example.not_bad.fragmentfav;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.not_bad.DataBase.model;
import com.example.not_bad.Manger.Manger;
import com.example.not_bad.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Favouret#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Favouret extends Fragment {
    Manger manger;
    ArrayList<model>mo=new ArrayList<>();
    Frag_AD ad;

    public static Favouret newInstance() {
        Favouret fragment = new Favouret();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        manger=new Manger(getContext());
        mo.clear();
        if (manger.retriv().size()>0){
            for (model m:manger.retriv()){
                mo.add(m);
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favouret, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView ff=view.findViewById(R.id.ff);
        ad=new Frag_AD(mo);
        ff.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ff.setAdapter(ad);

        //Frag_AD f=new Frag_AD();
    }
}