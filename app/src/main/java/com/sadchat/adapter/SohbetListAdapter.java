package com.sadchat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sadchat.R;
import com.sadchat.model.SohbetList;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SohbetListAdapter extends RecyclerView.Adapter<SohbetListAdapter.Holder> {

    private List<SohbetList> list;
    private Context context;

    public SohbetListAdapter(List<SohbetList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.kisiler_satir_tasarimi,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        SohbetList sohbetList = list.get(position);

        holder.tvAd.setText(sohbetList.getKullaniciAdi());
        holder.tvTarih.setText(sohbetList.getTarih());
        holder.tvDurum.setText(sohbetList.getDurum());

        //Resim

        Glide.with(context).load(sohbetList.getProfilResmiUrl()).into(holder.profilResmi);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView tvAd,tvDurum,tvTarih;
        private CircleImageView profilResmi;

        public Holder(@NonNull View itemView) {
            super(itemView);

            tvAd=itemView.findViewById(R.id.tv_ad);
            tvTarih=itemView.findViewById(R.id.tv_tarih);
            tvDurum=itemView.findViewById(R.id.tv_durum);

            profilResmi=itemView.findViewById(R.id.profil_resmi);
        }
    }
}
