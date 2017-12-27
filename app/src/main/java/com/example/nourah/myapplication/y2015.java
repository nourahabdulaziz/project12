package com.example.nourah.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nourah.myapplication.projects.ace_arcade;
import com.example.nourah.myapplication.projects.art_gallery;
import com.example.nourah.myapplication.projects.diet_center;
import com.example.nourah.myapplication.projects.game_focus;
import com.example.nourah.myapplication.projects.guess_secret;
import com.example.nourah.myapplication.projects.learn_play;
import com.example.nourah.myapplication.projects.pharmacy_managment_system;
import com.example.nourah.myapplication.projects.task_organaizer;

public class y2015 extends AppCompatActivity {
    ListView list;


    String[] itemname ={
            "Task Organizer",
            "Game Focus",
            "Art Gallery ",
            "Ace Arcade",

    };

    Integer[] imgid={
            R.drawable.task,
            R.drawable.light,
            R.drawable.art,
            R.drawable.game,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y2015);

        adapterprojects adapter = new adapterprojects(this, itemname, imgid);
        list = (ListView) findViewById(R.id.list);

        list.setAdapter(adapter);
        Log.d("rr", "t4");
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(view.getContext(), task_organaizer.class);
                    startActivityForResult(i, 0);
                }

                if (position == 1) {
                    Intent i = new Intent(view.getContext(), game_focus.class);
                    startActivityForResult(i, 1);
                }


                if (position == 2) {
                    Intent i = new Intent(view.getContext(), art_gallery.class);
                    startActivityForResult(i, 2);
                }

                if (position == 3) {
                    Intent i = new Intent(view.getContext(), ace_arcade.class);
                    startActivityForResult(i, 3);
                }

            }
        });
    }}