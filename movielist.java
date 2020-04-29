package com.example.omtp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class movielist extends AppCompatActivity {
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist);

        spinner=findViewById(R.id.spinner);
        List<String> catagories=new ArrayList<>();
        catagories.add(0,"Select movie");
        catagories.add("Star Wars");
        catagories.add("Jumanji");
        catagories.add("Ford vs ferrari");
        catagories.add("P.S.I still love you");
        catagories.add("War");

        //style and populate the spinner
        ArrayAdapter<String> dataAdapter;
        dataAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,catagories);

        //Dropdown layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Select movie")) {
                    // do nothing
                } else {
                    //on selecting a spinner item
                    String item = parent.getItemAtPosition(position).toString();
                    // SHOW SELECTED SPINNER ITEM
                    Toast.makeText(parent.getContext(), "selected: " + item, Toast.LENGTH_SHORT).show();
                    if (parent.getItemAtPosition(position).equals("Star Wars")) {
                        Intent intent = new Intent(movielist.this, item_select.class);
                        startActivity(intent);
                    }
                    else if (parent.getItemAtPosition(position).equals("Jumanji")) {
                        Intent intent = new Intent(movielist.this, item2.class);
                        startActivity(intent);
                    }
                    else if (parent.getItemAtPosition(position).equals("Ford vs ferrari")) {
                        Intent intent = new Intent(movielist.this, item3.class);
                        startActivity(intent);
                    }
                    else if (parent.getItemAtPosition(position).equals("P.S.I still love you")) {
                        Intent intent = new Intent(movielist.this, item4.class);
                        startActivity(intent);
                    }
                    else if (parent.getItemAtPosition(position).equals("War")) {
                        Intent intent = new Intent(movielist.this, item5.class);
                        startActivity(intent);
                    }
                }
            }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });

        }
    }
