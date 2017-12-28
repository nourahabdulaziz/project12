package com.example.nourah.myapplication;


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


public class login extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    private Cursor cursor2;
    private Cursor cursor;
    Button btnLogin;
    EditText txtEmail, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("test","login");
        txtEmail = (EditText) findViewById(R.id.edemail);
        txtPass = (EditText) findViewById(R.id.edpass);
        btnLogin = (Button) findViewById(R.id.btnlogin);
        openHelper = new dblogreg(this);

    }

    public void onClick(View v) {
        db = openHelper.getReadableDatabase();
        db = openHelper.getWritableDatabase();

        String email = txtEmail.getText().toString();
        String pass = txtPass.getText().toString();


        cursor = db.rawQuery("SELECT * FROM " + dblogreg.TABLE_NAME + " WHERE " + dblogreg.COL_EMAIL + "=? AND " + dblogreg.COL_PASS + "=?", new String[]{email, pass});
        if (cursor != null) {

            if (cursor.getCount() > 0) {
                Log.d("test", "cursor2");

                //Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                SharedPreferences sh = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sh.edit();

                cursor2 = db.rawQuery("select * from registeration where Email=?", new String[]{email});

                if (cursor2.moveToFirst()) {
                    do {

                        String it = cursor2.getString(cursor2.getColumnIndex(dblogreg.COL_FNAME));
                        String it1 = cursor2.getString(cursor2.getColumnIndex(dblogreg.COL_EMAIL));
                        String it2 = cursor2.getString(cursor2.getColumnIndex(dblogreg.COL_PASS));

                        editor.putString("name",it);
                        editor.putString("pass", it2);
                        editor.putString("email", it1);
                        editor.commit();

                        Toast.makeText(getApplicationContext(), it+""+it1+""+it2, Toast.LENGTH_SHORT).show();

                    } while (cursor2.moveToNext());}

                    Intent i = new Intent(this, projectspage.class);
                    startActivity(i);

                } else {

                Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                }
            }
        }

    public void tosignup(View v) {
        Intent i = new Intent(this, registration.class);
        startActivity(i);
    }


}





