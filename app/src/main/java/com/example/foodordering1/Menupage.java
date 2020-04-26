package com.example.foodordering1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Menupage extends AppCompatActivity {
    SearchView mySearchView;
    ListView myList;
    ArrayList<Button> list;
    ArrayAdapter<Button> adapter;
    Button btnpizza = (Button)findViewById( R.id.btnpizza );
    String btnpizzaa = btnpizza.getText().toString();
    String names[] = {"PIZZA","PASTA","SANDWICH","DOSA","BURGER","FRANKIE","KULCHA","NOODLES"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menupage );
        mySearchView = (SearchView)findViewById( R.id.searchView );
       // myList = (ListView)findViewById( R.id.myList );
    }
}