package com.example.foodordering1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

public class feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(feedback.this,"Rating changed,Thank you for Rating "+ ratingBar.getRating(),Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
