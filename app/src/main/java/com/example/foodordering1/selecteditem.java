package com.example.foodordering1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class selecteditem extends AppCompatActivity {
TextView tvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_selecteditem );
        tvUser = (TextView)findViewById( R.id.selecteduser );

        Intent intent=getIntent();
        if(intent.getExtras() != null){
            UserModel userModel = (UserModel)intent.getSerializableExtra( "data" );
            tvUser.setText( userModel.getItemname() );
        }
    }
}
