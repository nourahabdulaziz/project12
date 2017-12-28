package com.example.nourah.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class contact_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


    }
    public void send_feedback(View v){

        TextView message=(TextView) findViewById(R.id.tv1);


        if(message.getText().toString().equals(""))
            message.setError("madatory feild");
        else {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:"));
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"projectslibrary@app.sa"});
            i.putExtra(Intent.EXTRA_SUBJECT,"Feedback/Question re: projects library app ");
            i.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
            message.setText("message");

            try {
                startActivity(Intent.createChooser(i, "send mail"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this, "no mail app found", Toast.LENGTH_SHORT).show();
            }
         //to check the email format if not rigth this catch will exception
        catch(Exception ex) {
            Toast.makeText(this, "unexpected error" + ex.toString(),Toast.LENGTH_LONG).show();
        }

    }

}}
