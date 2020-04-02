package com.example.foodordering1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class recoverpassword extends AppCompatActivity {
    EditText recoverEmail;
    ProgressBar progressBar;
    Button btnrecover;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setContentView(R.layout.activity_recoverpassword);
        recoverEmail = findViewById(R.id.txtemail);
        btnrecover = findViewById(R.id.btnrecovery);
        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
        progressBar.setVisibility(View.GONE);
        btnrecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                mAuth.sendPasswordResetEmail(recoverEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(recoverpassword.this, "Please check your E-mail", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(recoverpassword.this, login.class);
                            startActivity(i);
                            progressBar.setVisibility(View.GONE);
                        }
                        else{
                            Toast.makeText(recoverpassword.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
