package com.example.nourah.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
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


public class projectspage extends AppCompatActivity {
    ListView listView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    BottomNavigationView btmnav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectspage);
        Log.d("test","project");

        String [] year_project={"\nGRADUATE-2017\n","\nGRADUATE-2016\n","\nGRADUATE-2015\n","\nGRADUATE-2014\n",
                "\nGRADUATE-2013\n","\nGRADUATE-2012\n","\nGRADUATE-2011\n"};
        listView =(ListView)findViewById(R.id.listview);
        Log.d("test","project1");
        //create adapter
        ArrayAdapter<String>array_Adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                year_project);
        Log.d("test","project2");
        //to make a list
        listView.setAdapter(array_Adapter);

        Log.d("test","project3");
        btmnav=(BottomNavigationView)findViewById(R.id.navigation);
        Log.d("test","project4");
        Menu menu=btmnav.getMenu();
        MenuItem menuItem=menu.getItem(0);
        menuItem.setChecked(true);
        btmnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("test","project5");
                switch (item.getItemId()) {
                    case R.id.navigation_project:

                        break;
                    case R.id.navigation_search:
                        Intent i2=new Intent(projectspage.this,search.class);
                        startActivity(i2);

                        break;

                    case R.id.navigation_profile:
                        Intent i3=new Intent(projectspage.this,profile.class);
                        startActivity(i3);
                        break;

                }
                return false;
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                if (position == 0) {
                    Intent i = new Intent(view.getContext(), y2017.class);
                    startActivityForResult(i, 0);
                }

                if (position == 1) {
                    Intent i = new Intent(view.getContext(), y2016.class);
                    startActivityForResult(i, 1);
                }


                if (position == 2) {
                    Intent i = new Intent(view.getContext(), y2015.class);
                    startActivityForResult(i, 2);
                }

                if (position == 3) {
                    Intent i = new Intent(view.getContext(), y2014.class);
                    startActivityForResult(i, 3);
                }

                if (position == 4) {
                    Intent i = new Intent(view.getContext(), y2013.class);
                    startActivityForResult(i, 4);
                }

                if (position == 5) {
                    Intent i = new Intent(view.getContext(), y2012.class);
                    startActivityForResult(i, 5);
                }

                if (position == 6) {
                    Intent i = new Intent(view.getContext(), y2011.class);
                    startActivityForResult(i, 6);
                }


            }

});}


}
