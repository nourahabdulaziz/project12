package com.example.nourah.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nourah.myapplication.projects.diet_center;
import com.example.nourah.myapplication.projects.guess_secret;
import com.example.nourah.myapplication.projects.learn_play;
import com.example.nourah.myapplication.projects.optical_memory_speed;
import com.example.nourah.myapplication.projects.pharmacy_managment_system;

public class y2017 extends AppCompatActivity {
    ListView list;

    String[] itemname ={
            "Learn & Play",
            "Pharmacy Managment System",
            "Guess Secret Game",
            "Optical Memory Speed game",
            "Diet Center"
    };

    Integer[] imgid={
            R.drawable.learn_play,
            R.drawable.phaarmacy_ms,
            R.drawable.guess_secret,
            R.drawable.optical_memory,
            R.drawable.diet_center,
         };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_y2017);


        adapterprojects adapter = new adapterprojects(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list) ;

        list.setAdapter(adapter);
        Log.d("rr", "t4");
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(view.getContext(),learn_play.class);
                    startActivityForResult(i, 0);
                }

                if (position == 1) {
                    Intent i = new Intent(view.getContext(),pharmacy_managment_system.class);
                    startActivityForResult(i, 1);
                }


                if (position == 2) {
                    Intent i = new Intent(view.getContext(),guess_secret.class);
                    startActivityForResult(i, 2);
                }

                if (position == 3) {
                    Intent i = new Intent(view.getContext(),optical_memory_speed.class);
                    startActivityForResult(i, 3);
                }

                if (position == 4) {
                    Intent i = new Intent(view.getContext(),diet_center.class);
                    startActivityForResult(i, 4);
                }


            }
        });
    }


   }