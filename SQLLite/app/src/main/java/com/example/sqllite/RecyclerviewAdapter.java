    package com.example.sqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.Holder> {
    Context context;
    List<PersonBean> listPersonInfo;
    OnUserClickListener listener;

    public RecyclerviewAdapter(Context context, List<PersonBean>listPersonInfo,OnUserClickListener listener) {
        this.context=context;
        this.listPersonInfo=listPersonInfo;
        this.listener=listener;
    }
    public interface OnUserClickListener{
        void onUserClick(PersonBean currentPerson, String action);
    }
    @NonNull
    @Override
    public RecyclerviewAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.Holder holder, int position) {
        final PersonBean currentPerson=listPersonInfo.get(position);
        holder.inpJudul.setText(currentPerson.getJudul());
        holder.inpDeskripsi.setText(currentPerson.getDeskripsi());
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(currentPerson,"Edit");
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(currentPerson,"Delete");
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPersonInfo.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView inpJudul, inpDeskripsi;
        ImageView imgEdit, imgDelete;
        public Holder(@NonNull View itemView) {
            super(itemView);
            inpJudul=itemView.findViewById(R.id.judul);
            inpDeskripsi=itemView.findViewById(R.id.deskripsi);
            imgDelete=itemView.findViewById(R.id.btndelete);
            imgEdit=itemView.findViewById(R.id.btnedit);
        }
    }
}
