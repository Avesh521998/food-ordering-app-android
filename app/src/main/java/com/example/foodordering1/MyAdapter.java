package com.example.foodordering1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Profile> profiles;
    public MyAdapter(Context c,ArrayList<Profile> p){
        context = c;
        profiles = p;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        return new MyViewHolder( LayoutInflater.from( context ).inflate(R.layout.row_users,parent,false) );
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
            holder.name.setText( profiles.get( position ).getName() );
            holder.price.setText( profiles.get( position ).getPrice() );
            Picasso.get().load( profiles.get( position ).getProfilePic() ).into( holder.profilepic );
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,price;
        ImageView profilepic;
        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            name = (TextView)itemView.findViewById( R.id.name );
            price= (TextView)itemView.findViewById( R.id.Price );
            profilepic = (ImageView) itemView.findViewById( R.id.profilePic );
        }
    }


}
