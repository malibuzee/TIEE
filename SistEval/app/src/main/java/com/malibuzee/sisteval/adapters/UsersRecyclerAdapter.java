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

import com.malibuzee.sisteval.R;
import com.malibuzee.sisteval.model.User;

import java.util.List;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder> {

    private List<User> listUsers;

    public UsersRecyclerAdapter(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textViewName.setText(listUsers.get(position).getName());
        holder.textViewEmail.setText(listUsers.get(position).getEmail());
        holder.textViewPassword.setText(listUsers.get(position).getPassword());
        holder.textViewCct.setText(listUsers.get(position).getCct());
        holder.textViewNomEscuela.setText(listUsers.get(position).getNomescuela());
        holder.textViewGrado.setText(listUsers.get(position).getGrado());
        holder.textViewGrupo.setText(listUsers.get(position).getGrupo());
    }

    @Override
    public int getItemCount() {
        Log.v(UsersRecyclerAdapter.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewPassword;
        public AppCompatTextView textViewCct;
        public AppCompatTextView textViewNomEscuela;
        public AppCompatTextView textViewGrado;
        public AppCompatTextView textViewGrupo;

        public UserViewHolder(View view) {
            super(view);
            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
            textViewPassword = (AppCompatTextView) view.findViewById(R.id.textViewPassword);
            textViewCct = (AppCompatTextView) view.findViewById(R.id.textViewCct);
            textViewNomEscuela = (AppCompatTextView) view.findViewById(R.id.textViewNomEscuela);
            textViewGrado = (AppCompatTextView) view.findViewById(R.id.textViewGrado);
            textViewGrupo = (AppCompatTextView) view.findViewById(R.id.textViewGrupo);
        }
    }






}