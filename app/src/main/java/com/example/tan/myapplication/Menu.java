package com.example.tan.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by tan on 1/7/2015.
 */
public class Menu extends ListActivity{

    String classes[] = {"Second", "TextPlay", "example2", "example3", "example4", "example5", "example6"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        String cheese = classes[position];

        super.onListItemClick(l, v, position, id);
        try {
            Class ourClass = Class.forName("com.example.tan.myapplication." + cheese);
            Intent ourIntent = new Intent(Menu.this, ourClass);
            startActivity(ourIntent);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
