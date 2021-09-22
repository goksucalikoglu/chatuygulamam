package com.sadchat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sadchat.R;
import com.sadchat.model.AramaList;
import com.sadchat.model.SohbetList;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AramaListAdapter extends RecyclerView.Adapter<AramaListAdapter.Holder> {
    private List<AramaList> list;
    private Context context;

    public AramaListAdapter(List<AramaList> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sohbetler_satir_tasarimi,parent,false);


        return new Holder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        AramaList aramaList = list.get(position);
        holder.tvAd.setText(aramaList.getKullaniciAdi());
        holder.tvTarih.setText(aramaList.getTarih());

        if (aramaList.getCagriTuru().equals("cevapsız"))
        {
            holder.ok.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_arrow_downward_24));
            holder.ok.getDrawable().setTint(context.getResources().getColor(android.R.color.holo_red_dark));
        }
        else if (aramaList.getCagriTuru().equals("gelen"))
        {
            holder.ok.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_arrow_upward_24));
            holder.ok.getDrawable().setTint(context.getResources().getColor(android.R.color.holo_green_dark));
        }
        else
        {
            holder.ok.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_arrow_upward_24));
            holder.ok.getDrawable().setTint(context.getResources().getColor(android.R.color.holo_green_dark));
        }
        //resmi profilde gösterme
        Glide.with(context).load(aramaList.getProfilURL()).into(holder.profilResmi);

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private CircleImageView profilResmi;
        private TextView tvAd,tvTarih;
        private ImageView ok;




        public Holder(@NonNull View itemView) {

            super(itemView);

            profilResmi=itemView.findViewById(R.id.profil_resmi);
            tvAd=itemView.findViewById(R.id.tv_ad);
            tvTarih=itemView.findViewById(R.id.tv_tarih);
            ok=itemView.findViewById(R.id.img_ok);
        }
    }
}
