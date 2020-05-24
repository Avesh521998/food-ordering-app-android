package com.example.foodordering1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Menupage extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager LayoutManager;
    MyAdapter adapter;
    SearchView mySearchView;
    Button btnpizza = (Button) findViewById( R.id.btnpizza );
    String names[] = {"PIZZA","PASTA","SANDWICH","DOSA","BURGER","FRANKIE","KULCHA","NOODLES"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menupage );

        mySearchView = (SearchView)findViewById( R.id.searchView );

    }

   /* public void itemselect(View v) {
        Button clickedButton = (Button) v;
        switch (clickedButton.getId()) {
            case R.id.btnpizza:
                Intent i = new Intent(Menupage.this,cart.class);
                startActivity(i);
                break;

            case R.id.btnpasta:
                Intent j = new Intent( Menupage.this,cart.class);
                startActivity(j);
                break;

            case R.id.btnburger:
                Intent k = new Intent(Menupage.this,cart.class);
                startActivity(k);
                break;

            case R.id.btnsandwich:
                Intent l = new Intent(Menupage.this,cart.class);
                startActivity(l);
                break;

            case R.id.btnfrankie:
                Intent m = new Intent(Menupage.this,cart.class);
                startActivity(m);
                break;
            case R.id.btnnoodles:
                Intent n = new Intent(Menupage.this,cart.class);
                startActivity(n);
                break;
            case R.id.btnkulcha:
                Intent o = new Intent(Menupage.this,cart.class);
                startActivity(o);
                break;
            case R.id.btnndosa:
                Intent p = new Intent(Menupage.this,cart.class);
                startActivity(p);
                break;
        }
    }*/
}