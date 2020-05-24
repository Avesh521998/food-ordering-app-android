package com.example.foodordering1;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class navigation extends AppCompatActivity {
    SQLiteDatabase db;
   // private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    TextView txtEmail;
    DatabaseReference reference;
    //FirebaseUser Email;
    Button btpizza,btnpasta,btburger,btsandwich,btfrankie,btnoodles,btkulcha,btdosa;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.findViewById(R.id.nav_logout);
        navigationView.findViewById(R.id.nav_about);
        navigationView.findViewById(R.id.nav_gallery);
        navigationView.findViewById(R.id.nav_help);
        btpizza = (Button)findViewById( R.id.btnpizza );
        btnpasta = (Button)findViewById( R.id.btnpasta );
        btburger = (Button)findViewById( R.id.btnburger );
        btsandwich = (Button)findViewById( R.id.btnsandwich );
        btfrankie = (Button)findViewById( R.id.btnfrankie );
        btnoodles = (Button)findViewById( R.id.btnnoodles );
        btkulcha = (Button)findViewById( R.id.btnkulcha );
        btdosa = (Button)findViewById( R.id.btnndosa );
         //final DatabaseReference mDatabaseReference;

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_logout:
                        db=openOrCreateDatabase("food", Context.MODE_PRIVATE, null);
                        db.execSQL("DROP TABLE user;");
                        Intent i = new Intent(navigation.this, login.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        Toast.makeText(navigation.this, " ☺ Thank you ☺ ", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case R.id.nav_about:
                        Intent j = new Intent(navigation.this,pasta.class);
                        startActivity(j);
                        break;
                    case R.id.nav_gallery:
                        Intent k = new Intent(navigation.this,feedback.class);
                        startActivity(k);
                        break;
                    case R.id.nav_help:
                        Intent l = new Intent(navigation.this,help.class);
                        startActivity(l);
                        break;
                }
                return true;
            }
        });
        btpizza.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference("Profiles");
                ValueEventListener valueEventListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                };
                Intent i = new Intent(navigation.this,cart.class);
                startActivity(i);
            }
        } );
        btnpasta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(navigation.this,cart.class);
                startActivity(i);
            }
        } );
    }
    /*public void itemselect(View v) {
        Button clickedButton = (Button) v;
        switch (clickedButton.getId()) {
            case R.id.btnpizza:
                Intent i = new Intent(navigation.this,cart.class);
                startActivity(i);
                break;

            case R.id.btnpasta:
                Intent j = new Intent( navigation.this,cart.class);
                startActivity(j);
                break;

            case R.id.btnburger:
                Intent k = new Intent(navigation.this,cart.class);
                startActivity(k);
                break;

            case R.id.btnsandwich:
                Intent l = new Intent(navigation.this,cart.class);
                startActivity(l);
                break;

            case R.id.btnfrankie:
                Intent m = new Intent(navigation.this,cart.class);
                startActivity(m);
                break;
            case R.id.btnnoodles:
                Intent n = new Intent(navigation.this,cart.class);
                startActivity(n);
                break;
            case R.id.btnkulcha:
                Intent o = new Intent(navigation.this,cart.class);
                startActivity(o);
                break;
            case R.id.btnndosa:
                Intent p = new Intent(navigation.this,cart.class);
                startActivity(p);
                break;
        }
    }*/
}

