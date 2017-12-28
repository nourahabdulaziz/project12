package com.example.nourah.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class settings extends AppCompatActivity {
ListView listView;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        String [] settings_options={"\nAccount\n","\ncontact_us\n","\nlogout\n"};
        listView =(ListView)findViewById(R.id.listview);
        ArrayAdapter<String> array_Adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                settings_options);

        listView.setAdapter(array_Adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {


            if (position == 0) {
                Intent i = new Intent(view.getContext(), account.class);
                startActivityForResult(i, 0);
            }

            else if (position == 1) {
                Intent i = new Intent(view.getContext(), contact_us.class);
                startActivityForResult(i, 1);
            }
            else if (position == 2) {
                Intent i = new Intent(view.getContext(), login.class);
                startActivityForResult(i, 2);
            }

        }
});}

}
