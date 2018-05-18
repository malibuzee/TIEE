package com.malibuzee.sisteval.adapters;

/**
 * Created by F129 on 08/04/2018.
 */

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.malibuzee.sisteval.R;
import com.malibuzee.sisteval.activities.Alumno;
import com.malibuzee.sisteval.model.AlumnoModelo;
import com.malibuzee.sisteval.model.TagModelo;
import com.malibuzee.sisteval.model.User;

import java.util.List;

public class AlumRecyclerAdapter extends RecyclerView.Adapter <AlumRecyclerAdapter.AlumViewHolder> {
    public static class AlumViewHolder extends RecyclerView.ViewHolder {
        private TextView matricula, nombresalumn, apellidosalum, edad, serial_num;



        public AlumViewHolder(View itemView) {
            super(itemView);
            matricula=(TextView)itemView.findViewById(R.id.textViewMatriculaAlum);
            nombresalumn=(TextView)itemView.findViewById(R.id.textViewNombresAlum);
            apellidosalum=(TextView)itemView.findViewById(R.id.textViewApellidosAlum);
            edad=(TextView)itemView.findViewById(R.id.textViewEdad);
            serial_num=(TextView)itemView.findViewById(R.id.textViewSerialNum);

        }
    }

    public List<AlumnoModelo> alumnoModeloList;

    public AlumRecyclerAdapter(List<AlumnoModelo> alumnoModeloList){
        this.alumnoModeloList = alumnoModeloList;
    }

    @Override
    public AlumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alum_recycler,parent,false);
        AlumViewHolder viewHolder=new AlumViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AlumViewHolder holder, int position) {
        holder.matricula.setText(alumnoModeloList.get(position).getMatricula());
        holder.nombresalumn.setText(alumnoModeloList.get(position).getNombres());
        holder.apellidosalum.setText(alumnoModeloList.get(position).getApellidos());
        holder.edad.setText(alumnoModeloList.get(position).getEdad());
        holder.serial_num.setText(alumnoModeloList.get(position).getSerial_alum());

    }

    @Override
    public int getItemCount() {
        return alumnoModeloList.size();
    }

}