package com.example.foodordering1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class activity_splash extends AppCompatActivity {

    SQLiteDatabase db;
    String email,password;
    boolean isStored = false;
    FirebaseAuth mAuth;
    EditText txtEmail;
    EditText txtPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        db=openOrCreateDatabase("food", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(email VARCHAR,password VARCHAR);");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        Cursor c=db.rawQuery("SELECT * FROM user", null);


        if(c.moveToFirst()){
            isStored = true;
            email = c.getString(0);
            password = c.getString(1);
            Toast.makeText( this,"Welcome  " + email + " " ,Toast.LENGTH_LONG ).show();dologin(email,password);
        }
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

//                Intent i = new Intent(activity_splash.this, MainActivity.class);
//                startActivity(i);

                if(isStored) {
                    Intent i = new Intent(activity_splash.this, navigation.class);
                    startActivity(i);
                }else{
                    Intent i = new Intent(activity_splash.this, MainActivity.class);
                    startActivity(i);
                }
                finish();
            }
        }, 4000);
    }

   private void dologin(String email,String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    isStored=true;
                }else{
                    isStored=false;
                }
            }
        } );
         }
}
