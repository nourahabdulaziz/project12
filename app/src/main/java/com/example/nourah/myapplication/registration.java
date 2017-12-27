package com.example.nourah.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    dblogreg dblg;
    Cursor cursor;

    public static final String MyPREFERENCES = "MyPrefs";
    Button btnreg, btnlogin;
    EditText txtfname, txtlname, txtpass, txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //Log.d("db", "ok here");
        openHelper = new dblogreg(this);
        txtfname = (EditText) findViewById(R.id.edfname);
        txtlname = (EditText) findViewById(R.id.edlname);
        txtpass = (EditText) findViewById(R.id.edpass);
        txtemail = (EditText) findViewById(R.id.edemail);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnreg = (Button) findViewById(R.id.btnreg);

    }

    public void toregister(View v) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]";

        Log.d("db", "ok here");
        db = openHelper.getWritableDatabase();
        String fname = txtfname.getText().toString();
        String lname = txtlname.getText().toString();
        String pass = txtpass.getText().toString();
        String email = txtemail.getText().toString();
        Log.d("db", "ok here6");

        if (fname.equals("") || pass.equals("") || email.equals("")) {
            Toast.makeText(getApplicationContext(), "please fill All Fields", Toast.LENGTH_LONG).show();
            Log.d("db", "ok here1");}
        if(!email.matches(emailPattern)){
            Toast.makeText(getApplicationContext(), "not rigth email format ", Toast.LENGTH_LONG).show();
        }
        else {
            cursor = db.rawQuery("SELECT * FROM " + dblogreg.TABLE_NAME + " WHERE " + dblogreg.COL_EMAIL + "=? ", new String[]{email});

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    Toast.makeText(getApplicationContext(), "the email is already exist", Toast.LENGTH_LONG).show();
                } else {

                    Log.d("db", "ok here3");
                    /*SharedPreferences sh=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sh.edit();
                    editor.putString("name",fname);
                    editor.putString("pass",pass);
                    editor.putString("email",email);
                    editor.commit();*/


                    insertdata(fname, lname, pass, email);
                    Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(this,login.class);
                    startActivity(i);


                }
            }
        }


    }
        public void insertdata(String fname, String lname, String pass, String email) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dblogreg.COL_FNAME, fname);
        contentValues.put(dblogreg.COL_LNAME, lname);
        contentValues.put(dblogreg.COL_PASS, pass);
        contentValues.put(dblogreg.COL_EMAIL, email);
        //Log.d("db", "Add record2");
        db.insert(dblogreg.TABLE_NAME, null, contentValues);
    }

    public void tologinpage(View v) {
        Intent i=new Intent(this,login.class);
        startActivity(i);
    }

}