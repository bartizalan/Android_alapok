package com.example.hf_04;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = {"Nemet", "Olasz", "United States","United Kingdom"};

    String[] rovArray = {"GER", "ITA", "USA","UK"};

    Integer[] imageArray = {
            R.drawable.germany,
            R.drawable.italy,
            R.drawable.usa,
            R.drawable.uk

    };

    String [] buyArray = {"5.65464", "5.65464", "5.65464","5.65464"};

    String [] sellArray = {"5.64", "5.66", "5.65","5.63"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView listView = findViewById(R.id.lista);
        CostumList adapter = new CostumList(this, nameArray, rovArray, imageArray, buyArray, sellArray);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = nameArray[position];
                String message = "Rövidítés: " + rovArray[position]
                        + "\nVételi: " + buyArray[position]
                        + "\nEladási: " + sellArray[position];


                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(title)
                        .setMessage(message)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });




}
}