package com.example.foodordering1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.Item;

public class pasta extends AppCompatActivity {
Button btn;
RecyclerView recyclerView;
LinearLayoutManager LayoutManager;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_test);
        recyclerView.setHasFixedSize(true);
        LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
    generateItem();
    }

    private void generateItem() {
        List<Item> itemList = new ArrayList<>();
        for(int i=0;i<50;i++)
        {
            itemList.add(new Item("Tomato sauce"+(++i),"₹ 250.99","https://raw.githubusercontent.com/Avesh521998/food-ordering-app-android/master/app/src/main/res/drawable-hdpi/component.png"));
        }
         adapter = new MyAdapter(this,itemList);
         recyclerView.setAdapter(adapter);
    }
}
