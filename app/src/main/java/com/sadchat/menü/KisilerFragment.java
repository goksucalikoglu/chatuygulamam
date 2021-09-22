package com.sadchat.menü;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sadchat.R;
import com.sadchat.adapter.AramaListAdapter;
import com.sadchat.model.AramaList;

import java.util.ArrayList;
import java.util.List;

public class KisilerFragment extends Fragment {


    public KisilerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_kisiler, container, false);

        List<AramaList>list=new ArrayList<>();

        RecyclerView recyclerView=view.findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list.add(new AramaList("1","Göksu","11/04/2020, 9:10 am","https://lh3.googleusercontent.com/proxy/sYKRSqW-Ie_RE5fV0fVzkrlVJyooVn0WoOB07qoQezMrx3mlHTP4yNKbKx3NUssVrgmUAXcAKQgby9uP6bdO6qbCKRrcYjpTamNBTos71U9ASWaQDtH_Uf0","cevapsız"));
        list.add(new AramaList("2","Nergiz","11/04/2020, 9:10 pm","https://static.yakala.co/images/0274883_0.jpeg","gelen"));
        list.add(new AramaList("3","Yusuf","11/04/2020, 9:10 am","https://www.cumhuriyet.com.tr/Archive/2020/10/16/1773906/kapak_121223.jpg","giden"));

        recyclerView.setAdapter(new AramaListAdapter(list,getContext()));

        return view;

    }
}