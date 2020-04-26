package com.example.foodordering1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;
public class navigation extends AppCompatActivity {
    SQLiteDatabase db;
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    TextView txtEmail;
    //FirebaseUser Email;
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
                        Intent k = new Intent(navigation.this,pasta.class);
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
    }
}

