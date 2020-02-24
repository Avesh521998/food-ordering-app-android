package com.example.foodordering1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menupage extends AppCompatActivity {
    Button btn;
    TextView pizzatextView1;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pizzatextView1 = (TextView) findViewById(R.id.pizza1counter);
    }
    public void countIN(View View)
    {
        counter++;
        pizzatextView1.setText(Integer.toString(counter));
    }
    public void countDE(View View)
    {
        counter--;
        pizzatextView1.setText(Integer.toString(counter));
    }
    public void resetcount(View View)
    {
        counter=0;
        pizzatextView1.setText(Integer.toString(counter));
    }
}