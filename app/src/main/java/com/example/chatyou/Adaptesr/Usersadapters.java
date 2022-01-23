package com.example.chatyou.Adaptesr;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatyou.R;
import com.example.chatyou.models.Users;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Usersadapters extends RecyclerView.Adapter<Usersadapters.ViewHolder> {

    ArrayList<Users> list;
    Context context;

    public Usersadapters(ArrayList<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Users users = list.get(position);
        Picasso.get() .load(users.getProfilepic()).placeholder(R.drawable.avatar).into(holder.image);
        holder.username.setText(users.getUserName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView username, lastmessage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.profile_image);
            username = itemView.findViewById(R.id.usernames);
            image = itemView.findViewById(R.id.lastmessage);
        }
    }
}
