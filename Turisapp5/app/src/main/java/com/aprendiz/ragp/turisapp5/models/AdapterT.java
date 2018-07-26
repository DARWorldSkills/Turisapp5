package com.aprendiz.ragp.turisapp5.models;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

public class AdapterT extends RecyclerView.Adapter<AdapterT.Holder>{
    List<Sitios> sitiosList;
    private OnItemClickListener mlistener;
    public interface OnItemClickListener{
        void itemClick(int position);
    }
    int item;

    public AdapterT(List<Sitios> sitiosList, int item) {
        this.sitiosList = sitiosList;
        this.item = item;
    }

    public OnItemClickListener getMlistener() {
        return mlistener;
    }

    public void setMlistener(OnItemClickListener mlistener) {
        this.mlistener = mlistener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item,parent,false);
        Holder holder = new Holder(view,mlistener);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return sitiosList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView, OnItemClickListener mlistener) {
            super(itemView);
        }
    }
}
