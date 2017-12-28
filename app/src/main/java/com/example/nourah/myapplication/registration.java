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
import android.widget.TextView;
import android.widget.Toast;

public class registration extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;

    public static final String MyPREFERENCES = "MyPrefs";
    Button btnreg, btnlogin;
    EditText txtfname, txtlname, txtpass, txtemail,txtconfirm;
    TextView login,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        openHelper = new dblogreg(this);
        txtfname = (EditText) findViewById(R.id.edfname);
        txtlname = (EditText) findViewById(R.id.edlname);
        txtpass = (EditText) findViewById(R.id.pass);
        txtemail = (EditText) findViewById(R.id.edemail);
        txtconfirm= (EditText) findViewById(R.id.confirmpass);
        t2=(TextView)findViewById(R.id.temail) ;
        t3=(TextView)findViewById(R.id.tpass) ;
        btnlogin = (Button) findViewById(R.id.btnlogin);
        login=(TextView)findViewById(R.id.loginpage);
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
        String confirmpass = txtconfirm.getText().toString();
        Log.d("db", "ok here6");

        if (fname.equals("") || pass.equals("") || email.equals("")) {
            //Toast.makeText(getApplicationContext(), "please fill All Fields", Toast.LENGTH_LONG).show();
            t3.setText("please fill All Fields");
            t2.setText("");
        }else
        if(!email.matches(emailPattern)){
            //Toast.makeText(getApplicationContext(), "not rigth email format ", Toast.LENGTH_LONG).show();
            t2.setText("not rigth email format");
            t3.setText("");
        }else
        if(!(pass.equals(confirmpass))){
           // Toast.makeText(getApplicationContext(), "the password not match ", Toast.LENGTH_LONG).show();
             t3.setText("the password not match");
            t2.setText("");
        }
        else {
            t3.setText("");
            t2.setText("");
            cursor = db.rawQuery("SELECT * FROM " + dblogreg.TABLE_NAME + " WHERE " + dblogreg.COL_EMAIL + "=? ", new String[]{email});

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    //Toast.makeText(getApplicationContext(), "the email is already exist", Toast.LENGTH_LONG).show();
                    t2.setText("the email is already exist");
                    t3.setText("");
                } else {


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
        db.insert(dblogreg.TABLE_NAME, null, contentValues);
    }

    public void tologinpage(View v) {
        Intent i=new Intent(this,login.class);
        startActivity(i);
    }


    public void clear(View v) {
        if(v==txtfname){
            txtfname.setText(" ");
        }
        if(v==txtlname){
            txtlname.setText(" ");
    }
       if(v==txtemail){
        txtemail.setText(" ");
    }
        if(v==txtpass){
            txtpass.setText(" ");
}

      if(v==txtconfirm){
            txtconfirm.setText(" ");

}}}