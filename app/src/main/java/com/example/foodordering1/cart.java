package com.example.foodordering1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class cart extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference reference;
    RecyclerView.LayoutManager LayoutManager;
    FirebaseRecyclerOptions<Profile> option;
    FirebaseRecyclerAdapter<Profile,CategoryViewHolder> adapter;
    ArrayList<Profile> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        reference = FirebaseDatabase.getInstance().getReference().child( "Profiles" );

        reference.child( "Profiles" ).addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Profile p = dataSnapshot.getValue(Profile.class);
                    list.add( p );
                }
                recyclerView.setAdapter( adapter );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText( cart.this,"Opps somting wrong...",Toast.LENGTH_LONG ).show();
            }
        } );
    }
}