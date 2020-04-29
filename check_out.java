package com.example.omtp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class check_out extends AppCompatActivity {

    Button submit;
    EditText name, password, email, contact, date;
    Random Number;
    int Rnumber;
    TextView RandomNumber;
    DatabaseReference databaseconf;
    Spinner sp1,sp2,sp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        name = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText4);
        date = (EditText) findViewById(R.id.editText3);
        contact = (EditText) findViewById(R.id.editText5);
        submit = (Button) findViewById(R.id.button);
        RandomNumber = (TextView)findViewById(R.id.randomnym);
        sp1=(Spinner)findViewById(R.id.spinner2);
        sp2=(Spinner)findViewById(R.id.spinner3);
        sp3=(Spinner)findViewById(R.id.spinner4);
        databaseconf= FirebaseDatabase.getInstance().getReference("Confirmations");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone= contact.getText().toString().trim();
                String cvv=password.getText().toString().trim();
                String card=name.getText().toString().trim();
                if (name.getText().toString().isEmpty() || password.getText().toString().isEmpty() || email.getText().toString().isEmpty() || date.getText().toString().isEmpty()
                        || contact.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter the Data", Toast.LENGTH_SHORT).show();
                }
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (!email.getText().toString().trim().matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                }
                if(cvv.length()>3){
                    Toast.makeText(getApplicationContext(), "Enter Vlaid CVV", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(phone.length()<3){
                    Toast.makeText(getApplicationContext(), "Enter Vlaid CVV", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(phone.length()>10){
                    Toast.makeText(getApplicationContext(), "Enter Vlaid Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(phone.length()<10){
                    Toast.makeText(getApplicationContext(), "Enter Vlaid Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(card.length()>16){
                    Toast.makeText(getApplicationContext(), "Enter Vlaid Card Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(card.length()<16){
                    Toast.makeText(getApplicationContext(), "Enter Vlaid Card Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Number = new Random();
                    Rnumber = Number.nextInt(10000);
                    RandomNumber.setText(Integer.toString(Rnumber));
                    /* Toast.makeText(getApplicationContext(), "Name -  " + name.getText().toString() + " \n" + "Password -  " + password.getText().toString()
                            + " \n" + "E-Mail -  " + email.getText().toString() + " \n" + "Date -  " + date.getText().toString()
                            + " \n" + "Contact -  " + contact.getText().toString(), Toast.LENGTH_SHORT).show();*/
                addConf();;
                }
            }
        });

    }
    private void addConf(){
        String em= email.getText().toString().trim();
        Number num=Rnumber;
        String movie=sp1.getSelectedItem().toString();
        String quantity=sp2.getSelectedItem().toString();
        String time=sp3.getSelectedItem().toString();

       String id= databaseconf.push().getKey();
       conf confirm=new conf(id,em,num,movie,quantity,time);
        databaseconf.child(id).setValue(confirm);



    }
}
