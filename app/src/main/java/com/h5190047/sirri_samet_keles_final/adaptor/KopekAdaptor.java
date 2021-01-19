package com.h5190047.sirri_samet_keles_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190047.sirri_samet_keles_final.R;
import com.h5190047.sirri_samet_keles_final.model.KopekModel;
import com.h5190047.sirri_samet_keles_final.utils.GlideUtil;

import java.util.List;

public class KopekAdaptor extends RecyclerView.Adapter<KopekViewHolder> {

    public interface OnItemClickListener {
        void onClick(int pos);

    }
    List<KopekModel> kopekler;
    Context context;
    OnItemClickListener itemClickListener;

    public KopekAdaptor(List<KopekModel> kopekler, Context context , OnItemClickListener itemClickListener) {

        this.kopekler = kopekler;
        this.context = context;
        this.itemClickListener= itemClickListener;
    }

    @NonNull
    @Override
    public KopekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_kopekler,parent,false);
        return new KopekViewHolder(itemView,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull KopekViewHolder viewHolder, int position) {

        viewHolder.txtKariyerineBasladigiYer.setText(kopekler.get(position).getKariyerineBasladigiYer());
        viewHolder.txtKopekAdi.setText(kopekler.get(position).getCinsi());
        viewHolder.txtYasamSuresi.setText(kopekler.get(position).getYasamSuresi());
        GlideUtil.resmiIndiripGoster(context,kopekler.get(position).getKucukResim(),viewHolder.imgKopekLogo);
    }

    @Override
    public int getItemCount() {
        return kopekler.size();
    }
}
