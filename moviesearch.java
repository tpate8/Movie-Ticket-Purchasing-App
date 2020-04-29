package com.example.omtp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class moviesearch extends AppCompatActivity {
    SearchView mySearchView;
    ListView myList;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Button cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviesearch);

        mySearchView = (SearchView) findViewById(R.id.searchView);
        myList = (ListView) findViewById(R.id.myList);
        list = new ArrayList<String>();
        list.add("Star Wars");
        list.add("Jumaji");
        list.add("Ford vs ferrari");
        list.add("P.S.I still love you");
        list.add("War");
        // SHOWING DATA IN THE LIST
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        myList.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String S) {
                adapter.getFilter().filter(S);

                return false;
            }
        });
        cont = findViewById(R.id.button1);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(moviesearch.this, movielist.class);
                startActivity(intent);
            }
        });
    }

}



