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
    EditText email,pass,fname;
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
        db = openHelper.getReadableDatabase();

        email = (EditText) findViewById(R.id.editemail);
        pass = (EditText) findViewById(R.id.editpassword);
        fname = (EditText) findViewById(R.id.editfname);
        sh=getSharedPreferences(login.MyPREFERENCES, Context.MODE_PRIVATE);
        pass.setOnTouchListener(handle);


        email.setText(sh.getString("email",null));
        pass.setText(sh.getString("pass",null));
        fname.setText(sh.getString("name",null));

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

        fname.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                n=fname.getText().toString();}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                menu.findItem(R.id.done).setEnabled(true);

            }

        });

    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.done){
          after(fname);
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

    public void after(View  v) {

        if (v == fname) {

            db.execSQL("update " + dblogreg.TABLE_NAME + " set " + dblogreg.COL_FNAME + "='" + fname.getText().toString() +
                    "' where " + dblogreg.COL_EMAIL + "='" + e + "';");

            editor.putString("name", fname.getText().toString());
            Toast.makeText(getApplicationContext(), fname.getText().toString(), Toast.LENGTH_SHORT).show();
            editor.commit();
        }

        if (v == email) {

            db.execSQL("update " + dblogreg.TABLE_NAME + " set " + dblogreg.COL_EMAIL + "='" + email.getText().toString() +
                    "' where " + dblogreg.COL_EMAIL + "='" + e + "';");


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

