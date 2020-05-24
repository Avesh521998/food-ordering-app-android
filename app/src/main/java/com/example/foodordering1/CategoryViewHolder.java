package com.example.foodordering1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    TextView name,price;
    ImageView profilepic;
    public CategoryViewHolder(@NonNull View itemView) {
        super( itemView );
        name = (TextView)itemView.findViewById( R.id.name );
        price= (TextView)itemView.findViewById( R.id.Price );
        profilepic = (ImageView) itemView.findViewById( R.id.profilePic );

    }
}
