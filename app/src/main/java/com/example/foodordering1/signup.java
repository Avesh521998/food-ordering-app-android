package com.example.foodordering1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class signup extends AppCompatActivity {
ProgressBar progressBar;
Button btn ;

    EditText txtUserName;
    EditText txtEmail;
    EditText txtPassWord;
    ImageView imageView;
    FirebaseAuth mAuth;
//FirebaseFirestore store;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        //store = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_signup);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassWord = (EditText) findViewById(R.id.txtPassWord);
        imageView = (ImageView) findViewById(R.id.imggif);
        progressBar.setVisibility(View.GONE);
        btn = (Button) findViewById(R.id.btn_sign);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            progressBar.setVisibility(View.VISIBLE);

            mAuth.createUserWithEmailAndPassword(txtEmail.getText().toString(),txtPassWord.getText().toString())
                    .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(signup.this, "success", Toast.LENGTH_SHORT).show();
                        //String currentuser = mAuth.getCurrentUser().getUid();
//                        Map<String, Object> user = new HashMap<>();
//                        user.put("name", txtUserName.getText().toString());
//
//                        store.collection("user").document(currentuser).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                Toast.makeText(signup.this, "success", Toast.LENGTH_SHORT).show();
//                            }
//                        });

                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(signup.this, " sign up successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(signup.this, login.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
                //Toast.makeText(MainActivity.this, "loading..", Toast.LENGTH_SHORT).show();
               // Toast.makeText(signup.this, "success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
