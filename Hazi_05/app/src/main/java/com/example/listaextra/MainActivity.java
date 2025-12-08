package com.example.listaextra;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.myListView);


        listItems = new ArrayList<>();
        listItems.add("Banán");
        listItems.add("Alma");
        listItems.add("Körte");
        listItems.add("Dinnye");
        listItems.add("Szilva");
        listItems.add("Szilva");
        listItems.add("Szilva");
        listItems.add("Alma");
        listItems.add("Retek");
        listItems.add("Dinnye");
        listItems.add("Paprika");
        listItems.add("Eper");
        listItems.add("Mango");


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);


        registerForContextMenu(listView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sort) {

            Collections.sort(listItems);
            adapter.notifyDataSetChanged();
            return true;
        } else if (id == R.id.action_delete) {

            listItems.clear();
            adapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.myListView) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        TextView rowView = (TextView) info.targetView;

        int id = item.getItemId();

        if (id == R.id.color_red) {
            rowView.setTextColor(Color.RED);
            return true;
        } else if (id == R.id.color_green) {
            rowView.setTextColor(Color.GREEN);
            return true;
        } else if (id == R.id.color_yellow) {
            rowView.setTextColor(Color.YELLOW);
            return true;
        } else if (id == R.id.color_blue) {
            rowView.setTextColor(Color.BLUE);
            return true;
        }

        return super.onContextItemSelected(item);
    }
}