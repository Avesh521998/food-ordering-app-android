package com.example.foodordering1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class login extends AppCompatActivity{
    ProgressBar progressBar;
    Button btn ;
    EditText txtEmail;
    EditText txtPassWord;

    FirebaseAuth mAuth;
    //FirebaseFirestore store;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login);
        txtEmail = (EditText) findViewById(R.id.Email);
        txtPassWord = (EditText) findViewById(R.id.PassWord);
        btn = (Button) findViewById(R.id.btnSignIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mAuth.signInWithEmailAndPassword(txtEmail.getText().toString(),txtPassWord.getText().toString())
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(login.this, "success", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(login.this, Menupage.class);
                                    startActivity(i);
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


                                    //Toast.makeText(login.this, "successful", Toast.LENGTH_SHORT).show();
                                    //Intent i = new Intent(login.this, Menuactivity.class);
                                    //startActivity(i);
                                }else{
                                    Toast.makeText(login.this, "fail", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
