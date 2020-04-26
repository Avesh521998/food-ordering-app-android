package com.example.foodordering1;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class login extends AppCompatActivity{
    ProgressBar progressBar;
    Button btn ;
    SQLiteDatabase db;
    EditText txtEmail;
    EditText txtPassWord;
    TextView textforgot;
    CheckBox checkBox;
    public static final String USER_EMAIL = "Email";
    public static final String PASSWORD = "Password";
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login);
        txtEmail = (EditText) findViewById(R.id.Email);
        txtPassWord = (EditText) findViewById(R.id.PassWord);
        textforgot = (TextView) findViewById(R.id.txtviewforgot);
        btn = (Button) findViewById(R.id.btnSignIn);
        db=openOrCreateDatabase("food", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(email VARCHAR,password VARCHAR);");
        textforgot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this,recoverpassword.class);
                startActivity(i);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signInWithEmailAndPassword(txtEmail.getText().toString(),txtPassWord.getText().toString())
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    db.execSQL("INSERT INTO user VALUES('"+txtEmail.getText().toString()+"','"+txtPassWord.getText().toString()+ "');");
                                    Toast.makeText(login.this, "success", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(login.this, navigation.class);
                                    startActivity(i);
                                    finish();
                                }else{
                                    Toast.makeText(login.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                }
        });

    }
}
