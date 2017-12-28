package com.example.nourah.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class profile extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    BottomNavigationView btmnav;
    ImageView imp, settingimg;
    TextView nameprofile;
    SharedPreferences sh;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sh = getSharedPreferences(registration.MyPREFERENCES, Context.MODE_PRIVATE);
        editor=sh.edit();


        btmnav = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = btmnav.getMenu();
        MenuItem menuItem = menu.getItem(2);

        menuItem.setChecked(true);

        btmnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("test", "project5");
                switch (item.getItemId()) {
                    case R.id.navigation_project:
                        Intent i1 = new Intent(profile.this, projectspage.class);
                        startActivity(i1);
                        Log.d("test", "from project page in navigation main");

                        break;

                    case R.id.navigation_search:
                        Intent i2 = new Intent(profile.this, search.class);
                        Log.d("test", "from project page befor go to like page");
                        startActivity(i2);

                        break;

                    case R.id.navigation_profile:

                        break;

                }
                return false;
            }
        });

    }

    public void goto_setting_page(View V) {
        settingimg = (ImageView) findViewById(R.id.settingimage);

        Intent i = new Intent(getApplicationContext(), settings.class);
        startActivity(i);
    }

    @Override
    public void onResume(){
        super.onResume();
        nameprofile = (TextView) findViewById(R.id.nameprofile);
        nameprofile.setText(sh.getString("name",null));
    }

}