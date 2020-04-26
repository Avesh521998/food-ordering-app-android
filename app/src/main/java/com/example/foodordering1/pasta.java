package com.example.foodordering1;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.Item;

public class pasta extends AppCompatActivity {
Button btn;
RecyclerView recyclerView;
RecyclerView.LayoutManager LayoutManager;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_test);
        recyclerView.setHasFixedSize(true);
        LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(adapter);
        pizza();
    }


    public void pizza() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("TOMATO SAUSE","₹ 350.00","https://raw.githubusercontent.com/Avesh521998/food-ordering-app-android/master/app/src/main/res/drawable-hdpi/component.png"));
        itemList.add(new Item("MARGHERITA","₹ 299.99","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5sku_ZnZ4EJBHfzDmT32athA-Jct8qt2KD3Y5o77Soo_c_mhP&s"));
        itemList.add(new Item("MUSROOM ","₹ 399.99","https://raw.githubusercontent.com/Avesh521998/food-ordering-app-android/master/app/src/main/res/drawable-hdpi/maskgroup2.png"));
        itemList.add(new Item("MOZZARELLA","₹ 499.99","https://raw.githubusercontent.com/Avesh521998/food-ordering-app-android/master/app/src/main/res/drawable-hdpi/maskgroup3.png"));

        itemList.add(new Item("CORN PIZZA","₹ 290.00","https://www.99cakeshop.in/image/cache/data/mix-veggie-pizza-200x200.jpg"));
        itemList.add(new Item("PANEER PIZZA","₹ 299.99","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQR15Wd5UFY7xNNQW1xgOzubruCP3FPzt66qyTlVxORd5N5AQQ&s"));
        itemList.add(new Item("MIX VEG PIZZA  ","₹ 399.99","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0922hiHQ631RASjsJpc8_U3N4J_KVh3bK2zuyPj_pTHC0xJ1t&s"));
        itemList.add(new Item("CHEESE PIZZA","₹ 599.99","https://www.myfoodwifi.com/wp-content/uploads/2018/07/27699734_2023863810963870_6999196684018253824_n.jpg"));

        adapter = new MyAdapter(this,itemList);
        recyclerView.setAdapter(adapter);
    }
}
