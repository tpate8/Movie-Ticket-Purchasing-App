package com.example.omtp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        mFullName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mLoginBtn = findViewById(R.id.creatText);
        mRegisterBtn = findViewById(R.id.registerbtn);

        fAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressBar);

       /* if the device is already registered then below method will directly open search movies page when user open app

       if(fAuth.getCurrentUser() != null){

            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();

        }*/
       mLoginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(),Login.class));

           }
       });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String phone = mPhone.getText().toString().trim();
                String Fullname=mFullName.getText().toString().trim();
                // if user donot enter email or password
                if (TextUtils.isEmpty(Fullname)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter Full Name", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter Email", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                    return;
                }
                if(TextUtils.isEmpty(phone)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter Phone Number", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                    return;
                }


                if (password.length()<6){
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter Valid Password", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                    return;
                }
                if(phone.length()>10){
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter Valid Phone Number", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                    return;
                }
                if(phone.length()<10){
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter Valid Phone Number", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                //register the user
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this,"account created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),moviesearch.class));
                        }
                        else {
                            Toast.makeText(Register.this,"Error occurd please register again" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
