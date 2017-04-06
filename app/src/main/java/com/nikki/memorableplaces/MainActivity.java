package com.nikki.memorableplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    static ArrayAdapter<String> arrayAdapter;
    static ArrayList<String> arrayPlaces=new ArrayList<>();
    static ArrayList<LatLng> lngArrayList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);


        arrayPlaces.add("Add a new place");
        lngArrayList.add(new LatLng(0,0));


       arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayPlaces);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                intent.putExtra("place position", position);
                startActivity(intent);

            }
        });


    }
}
