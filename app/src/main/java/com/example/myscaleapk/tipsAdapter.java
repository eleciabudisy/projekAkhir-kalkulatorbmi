package com.example.myscaleapk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.checkerframework.common.value.qual.StaticallyExecutable;

import java.util.ArrayList;

import javax.xml.validation.TypeInfoProvider;

public class tipsAdapter extends RecyclerView.Adapter<tipsAdapter.ViewHolder> {

    public tipsAdapter(ArrayList<tips_desc> listTips) {
        this.listTips = listTips;
    }

    private ArrayList<tips_desc> listTips;

    @NonNull
    @Override
    public tipsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_tips, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull tipsAdapter.ViewHolder holder, int position) {
        tips_desc tips = listTips.get(position);
        holder.txtJudul.setText(tips.getNama());
        holder.imgFoto.setImageResource(tips.getId_gambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(holder.itemView.getContext(), makanan.getNama(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(holder.itemView.getContext(), tips_detail.class);
                intent.putExtra("nama", tips.getNama());
                intent.putExtra("deskripsi", tips.getDesc());
                intent.putExtra("gambar", tips.getId_gambar());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTips.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtJudul;
        public ImageView imgFoto;
        public RelativeLayout itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtJudul = (TextView) itemView.findViewById(R.id.judul);
            imgFoto = (ImageView) itemView.findViewById(R.id.foto);
            this.itemView = (RelativeLayout) itemView.findViewById(R.id.mainLayout);
        }
    }
}
