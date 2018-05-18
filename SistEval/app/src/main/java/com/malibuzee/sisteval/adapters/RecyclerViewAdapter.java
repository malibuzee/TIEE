package com.malibuzee.sisteval.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.malibuzee.sisteval.R;
import com.malibuzee.sisteval.model.TagModelo;

import java.util.List;

/**
 * Created by F129 on 08/04/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView serial, nombreObj;
        private TextView IDROW;


        public ViewHolder(View itemView) {
            super(itemView);
            serial=(TextView)itemView.findViewById(R.id.txtSerial);
            nombreObj=(TextView)itemView.findViewById(R.id.txtNombreObj);
            IDROW=(TextView)itemView.findViewById(R.id.txtidDtag);


        }
    }

    public List<TagModelo> tagModeloList;

    public RecyclerViewAdapter(List<TagModelo> tagModeloList){
        this.tagModeloList = tagModeloList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_tags,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.serial.setText(tagModeloList.get(position).getSerial());
        holder.nombreObj.setText(tagModeloList.get(position).getNombreObj());
        //holder.IDROW.setText(tagModeloList.get(position).getIdRow());
    }

    @Override
    public int getItemCount() {
        return tagModeloList.size();
    }


}