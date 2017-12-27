package com.example.nourah.myapplication;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;


public class p1_y2017 extends AppCompatActivity {
    TextView t1,t2;
    Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("test", "create menu ");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("go back");
        setContentView(R.layout.activity_p1_y2017);
        t1=(TextView)findViewById(R.id.textView) ;
        t2=(TextView)findViewById(R.id.textView2) ;

    }


    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==android.R.id.home){

            this.finish();
        }
        if(id==R.id.share){

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.setType("image/*");

            intent.putExtra(Intent.EXTRA_SUBJECT,t1.getText());
            intent.putExtra(Intent.EXTRA_TEXT,t2.getText());


            startActivity(Intent.createChooser(intent,"Share using"));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.share, menu);
        menu.findItem(R.id.share).setEnabled(true);
        return super.onCreateOptionsMenu(menu);
    }

}