package com.example.nourah.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nourah.myapplication.projects.ace_arcade;
import com.example.nourah.myapplication.projects.art_gallery;
import com.example.nourah.myapplication.projects.diet_center;
import com.example.nourah.myapplication.projects.english_language;
import com.example.nourah.myapplication.projects.four_questions;
import com.example.nourah.myapplication.projects.game_focus;
import com.example.nourah.myapplication.projects.guess_secret;
import com.example.nourah.myapplication.projects.learn_play;
import com.example.nourah.myapplication.projects.optical_memory_speed;
import com.example.nourah.myapplication.projects.pharmacy_managment_system;
import com.example.nourah.myapplication.projects.prophet;
import com.example.nourah.myapplication.projects.task_organaizer;

import java.util.ArrayList;

public class search extends AppCompatActivity {
    static ArrayList<String> items;
    ListView listView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    BottomNavigationView btmnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listView=(ListView)findViewById(R.id.listview);
        items=new ArrayList<>();
        items.add("project 2017");
        items.add("project 2016");
        items.add("project 2015");
        items.add("project 2014");
        items.add("project 2013");
        items.add("project 2012");
        items.add("project 2011");
        items.add("Questions Game");
        items.add("Development of the english language");
        items.add("Arrangement Words");
        items.add("Questions about the Prophet");
        items.add("Diet Center");
        items.add("Guess Secret Game");
        items.add("Learn &amp; play");
        items.add("Optical Memory Speed Game");
        items.add("Pharmacy Management System");
        items.add("Task Organizer");
        items.add("Game Focus");
        items.add("Art Gallery");
        items.add("Ace Arcade");



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView, View view ,int i,long l){
                String text=listView.getItemAtPosition(i).toString();
                Toast.makeText(search.this,"" +text,Toast.LENGTH_SHORT).show();

            }
        });
        btmnav=(BottomNavigationView)findViewById(R.id.navigation);
        Menu menu=btmnav.getMenu();
        MenuItem menuItem=menu.getItem(1);
        menuItem.setChecked(true);
        btmnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_project:
                        Intent i1=new Intent(search.this,projectspage.class);
                        startActivity(i1);

                        break;
                    case R.id.navigation_search:

                        break;
                    case R.id.navigation_profile:
                        Intent i3=new Intent(search.this,profile.class);
                        Log.d("test","from like page befor go to profile page");
                        startActivity(i3);
                        break;
                }
                return false;
            }
        });
    }@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        final MenuItem item=menu.findItem(R.id.item_search);
        final SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> templist=new ArrayList<>();
                for (String temp : items){
                    if (temp.toLowerCase().contains(newText.toLowerCase())){
                        templist.add(temp);
                    }
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<>(search.this,
                        android.R.layout.simple_list_item_1,templist);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                return true;
            }

            @Override

            public boolean onQueryTextSubmit(String query) {
                // if(query.contains("prophet")){
                //  Intent i = new Intent(search.this, settings.class);
                //startActivityForResult(i, 0);
                //  startActivity(i);
                //}

                return true;
            }

        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //  @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object d=listView.getAdapter().getItem(position);
                String str=d.toString();
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT);

                if (str == "project 2017") {
                    Intent i = new Intent(view.getContext(), y2017.class);
                    startActivity(i);
                }if (str == "project 2016") {
                    Intent i = new Intent(view.getContext(), y2016.class);
                    startActivity(i);
                }if (str == "project 2015") {
                    Intent i = new Intent(view.getContext(), y2015.class);
                    startActivity(i);
                }if (str == "project 2014") {
                    Intent i = new Intent(view.getContext(), y2014.class);
                    startActivity(i);
                }if (str == "project 2013") {
                    Intent i = new Intent(view.getContext(), y2013.class);
                    startActivity(i);
                }if (str == "project 2012") {
                    Intent i = new Intent(view.getContext(), y2012.class);
                    startActivity(i);
                }if (str == "project 2011") {
                    Intent i = new Intent(view.getContext(), y2011.class);
                    startActivity(i);
                }if (str == "Questions Game") {
                    Intent i = new Intent(view.getContext(),four_questions.class);
                    startActivity(i);
                }if (str == "Questions about the Prophet") {
                    Intent i = new Intent(view.getContext(),prophet.class);
                    startActivityForResult(i, 8);
                }if (str == "Development of the english language") {
                    Intent i = new Intent(view.getContext(),english_language.class);
                    startActivity(i);
                }if (str == "Arrangement Words") {
                    Intent i = new Intent(view.getContext(), com.example.nourah.myapplication.Arrangement_words.class);
                    startActivity(i);

                }if (str == "Diet Center") {
                    Intent i = new Intent(view.getContext(),diet_center.class);
                    startActivity(i);

                }if (str == "Guess Secret Game") {
                    Intent i = new Intent(view.getContext(),guess_secret.class);
                    startActivity(i);

                }if (str == "Learn &amp; play") {
                    Intent i = new Intent(view.getContext(),learn_play.class);
                    startActivity(i);

                }if (str == "Optical Memory Speed Game") {
                    Intent i = new Intent(view.getContext(),optical_memory_speed.class);
                    startActivity(i);

                }if (str == "Pharmacy Management System") {
                    Intent i = new Intent(view.getContext(),pharmacy_managment_system.class);
                    startActivity(i);

                }if (str == "Task Organizer") {
                    Intent i = new Intent(view.getContext(),task_organaizer.class);
                    startActivity(i);

                }if (str == "Game Focus") {
                    Intent i = new Intent(view.getContext(),game_focus.class);
                    startActivity(i);

                }if (str == "Art Gallery") {
                    Intent i = new Intent(view.getContext(),art_gallery.class);
                    startActivity(i);

                }if (str == "Ace Arcade") {
                    Intent i = new Intent(view.getContext(),ace_arcade.class);
                    startActivity(i);

                }
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
