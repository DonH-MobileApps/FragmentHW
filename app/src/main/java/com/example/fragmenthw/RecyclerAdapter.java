package com.example.fragmenthw;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    ArrayList<User> userArrayList;


    public RecyclerAdapter(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_input, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, final int position) {

        User currentUserBeingPopulated = userArrayList.get(position);

        viewHolder.tvUserName.setText(currentUserBeingPopulated.getUserName());
        viewHolder.tvUserEmail.setText(currentUserBeingPopulated.getUserEmail());
        viewHolder.tvUserPassword.setText(currentUserBeingPopulated.getUserPassword());

        Log.d("TAG", "onBindViewHolder: item being rendered = " + position);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName;
        TextView tvUserEmail;
        TextView tvUserPassword;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvUserEmail = itemView.findViewById(R.id.tvUserEmail);
            tvUserPassword = itemView.findViewById(R.id.tvUserPassword);
        }
    }
}
