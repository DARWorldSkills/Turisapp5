package com.aprendiz.ragp.turisapp5.models;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.aprendiz.ragp.turisapp5.R;

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
    public void onBindViewHolder(Holder holder, int position){
        holder.connectData(sitiosList.get(position));

    }

    @Override
    public int getItemCount() {
        return sitiosList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView txtNombre;
        TextView txtUbicacion;
        TextView txtDescripcion;
        ImageView imagen = itemView.findViewById(R.id.imgItem);

        public Holder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position =getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            listener.itemClick(position);
                        }
                    }
                }
            });
        }

        public void connectData(Sitios sitios){
            if (item==R.layout.item_list){
                txtNombre = itemView.findViewById(R.id.txtNombreLi);
                txtUbicacion = itemView.findViewById(R.id.txtUbicacionLi);
                txtDescripcion = itemView.findViewById(R.id.txtDescripcionLi);

                txtNombre.setText(sitios.getNombre());
                txtUbicacion.setText(sitios.getUbicacion());
                txtDescripcion.setText(sitios.getDescripcionc());
            }

            if (item==R.layout.item_land){
                txtNombre = itemView.findViewById(R.id.txtNombreL);

                txtNombre.setText(sitios.getNombre());
            }

            if (item==R.layout.item_grid){
                txtNombre = itemView.findViewById(R.id.txtNombreG);
                txtUbicacion = itemView.findViewById(R.id.txtUbicacionG);

                txtNombre.setText(sitios.getNombre());
                txtUbicacion.setText(sitios.getUbicacion());
            }
        }
    }
}
