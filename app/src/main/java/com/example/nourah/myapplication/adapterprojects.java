package com.example.nourah.myapplication;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by nourah on 25 ديس، 2017 م.
 */

public class adapterprojects extends ArrayAdapter<String> {
    private Context mContext;
    ListView l;
    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public adapterprojects(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.list, itemname);
        Log.d("rr", "t7");
        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
        Log.d("rr", "t8");


    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        Log.d("rr", "t9");

        View rowView = inflater.inflate(R.layout.list, null, true);
        Log.d("rr", "t5");

        final TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


        txtTitle.setText(itemname[position]);
        Log.d("rr", "t7");

        imageView.setImageResource(imgid[position]);

        return rowView;

    }

}
