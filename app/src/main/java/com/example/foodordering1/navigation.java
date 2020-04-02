package com.example.foodordering1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import  com.google.firebase.auth.FirebaseAuth;
import  com.google.firebase.auth.FirebaseUser;
import com.example.foodordering1.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.auth.FirebaseAuth;
public class navigation extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    TextView txtEmail;
    FirebaseUser Email;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.findViewById(R.id.nav_logout);
        navigationView.findViewById(R.id.nav_about);
        navigationView.findViewById(R.id.nav_gallery);
        navigationView.findViewById(R.id.nav_help);
        txtEmail = (TextView)findViewById(R.id.navigatetextView);
        Email = FirebaseAuth.getInstance().getCurrentUser();
        uid = Email.getEmail();
       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_logout:
                        Intent i = new Intent(navigation.this, login.class);
                        startActivity(i);
                        Toast.makeText(navigation.this, " ☺ Thank you ☺ ", Toast.LENGTH_SHORT).show();
                    case R.id.nav_about:
                        Intent j = new Intent(navigation.this,Aboutus.class);
                        startActivity(j);

                    case R.id.nav_gallery:
                        Intent k = new Intent(navigation.this,feedback.class);
                        startActivity(k);
                    case R.id.nav_help:
                        Intent l = new Intent(navigation.this,help.class);
                        startActivity(l);
                }
                return true;
            }
        });
    }
}

