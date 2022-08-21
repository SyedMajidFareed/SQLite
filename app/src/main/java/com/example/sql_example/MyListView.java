package com.example.sql_example;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListView extends ArrayAdapter {
    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;

    public MyListView(Activity context, String[] maintitle,String[] subtitle) {
        super(context, R.layout.activity_customized_list_view, maintitle);
        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View singleEntityView = inflater.inflate(R.layout.activity_customized_list_view, null,true);
        TextView titleHeading = singleEntityView.findViewById(R.id.textView7);
        TextView titleDetails = singleEntityView.findViewById(R.id.textView8);
        titleHeading.setText(maintitle[position]);
        titleDetails.setText(subtitle[position]);
        return singleEntityView;
    };

}
