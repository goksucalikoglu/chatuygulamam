package com.sadchat.menü;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sadchat.R;
import com.sadchat.adapter.SohbetListAdapter;
import com.sadchat.model.SohbetList;

import java.util.ArrayList;
import java.util.List;

public class SohbetlerFragment extends Fragment {



    public SohbetlerFragment() {
        // Required empty public constructor
    }
    private List<SohbetList> list=new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sohbetListesiAl();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sohbetler, container, false);

        recyclerView= view.findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new SohbetListAdapter(list,getContext()));

        return view;
    }

    private void sohbetListesiAl() {

        list.add(new SohbetList("1","Göksu","Bende Buradayım","18/07/2021","https://lh3.googleusercontent.com/proxy/sYKRSqW-Ie_RE5fV0fVzkrlVJyooVn0WoOB07qoQezMrx3mlHTP4yNKbKx3NUssVrgmUAXcAKQgby9uP6bdO6qbCKRrcYjpTamNBTos71U9ASWaQDtH_Uf0"));
        list.add(new SohbetList("2","Nergiz","Bende Oradayım","13/08/2021","https://static.yakala.co/images/0274883_0.jpeg"));
        list.add(new SohbetList("3","Yusuf","Bende Şuradayım","13/04/2020","https://www.cumhuriyet.com.tr/Archive/2020/10/16/1773906/kapak_121223.jpg"));
        list.add(new SohbetList("4","Evren","Bende Heryerdeyim","15/03/2021","https://images.bursadabugun.com/haber/2020/07/03/1308889-bursa-iznik-sahili-nakis-gibi-islendi-5eff19c20bb75.jpg"));
    }


}