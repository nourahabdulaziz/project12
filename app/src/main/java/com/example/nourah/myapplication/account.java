package com.example.nourah.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class account extends AppCompatActivity {
EditText email,pass,username;
    SharedPreferences sh;
    SharedPreferences.Editor editor;
    String e,n;
    Menu menu;

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        openHelper = new dblogreg(this);
        db = openHelper.getWritableDatabase();


        email = (EditText) findViewById(R.id.editText1);
        pass = (EditText) findViewById(R.id.editText2);
        username = (EditText) findViewById(R.id.editText3);
        sh=getSharedPreferences(login.MyPREFERENCES, Context.MODE_PRIVATE);
        pass.setOnTouchListener(handle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email.setText(sh.getString("email",null));
        pass.setText(sh.getString("pass",null));
        username.setText(sh.getString("name",null));

         editor = sh.edit();

        email.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

           public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               e=email.getText().toString();}

           public void onTextChanged(CharSequence s, int start, int before, int count) {
               menu.findItem(R.id.done).setEnabled(true);
           }

        });

        username.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                n=username.getText().toString();}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                menu.findItem(R.id.done).setEnabled(true);

            }

        });

    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==android.R.id.home){
            this.finish();
        }
        if(id==R.id.done){
          after(username);
          after(email);
          this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

        View.OnTouchListener handle=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_UP){
                Intent i=new Intent(getApplicationContext(),pop_up_pass.class);

                startActivity(i);
                return true;
            }

            return false;

        }
        };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.cancle_done, menu);
        menu.findItem(R.id.done).setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    public void after(View v) {

        if (v == username) {

            Toast.makeText(getApplicationContext(), sh.getString("name", null), Toast.LENGTH_SHORT).show();
            db.execSQL("update " + dblogreg.TABLE_NAME + " set " + dblogreg.COL_FNAME + "='" + username.getText().toString() +
                    "' where " + dblogreg.COL_FNAME + "='" + n + "';");

            Log.d("test", username.getText().toString());

            editor.putString("name", username.getText().toString());
            editor.commit();
            //Log.d("test",it1);
        }

        if (v == email) {

            Toast.makeText(getApplicationContext(), sh.getString("email", null), Toast.LENGTH_SHORT).show();
            Log.d("test", "stert method ");
            db.execSQL("update " + dblogreg.TABLE_NAME + " set " + dblogreg.COL_EMAIL + "='" + email.getText().toString() +
                    "' where " + dblogreg.COL_EMAIL + "='" + e + "';");

            Log.d("test", email.getText().toString());
            Log.d("test", "after update");

            editor.putString("email", email.getText().toString());
            editor.commit();
        }
    }

        public void delete(View view){

            String em =  email.getText().toString();

            db.delete(dblogreg.TABLE_NAME ,"Email = ?" , new String[]{em});

            Toast.makeText(getApplicationContext(),"account is deleted",Toast.LENGTH_LONG).show();

            Intent i=new Intent(getApplicationContext(),login.class);
            startActivity(i);



        }

}

