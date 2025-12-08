package com.example.hf_04;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = {"Nemet", "Olasz", "United States", "United Kingdom"};
    String[] rovArray = {"GER", "ITA", "USA", "UK"};
    Integer[] imageArray = {
            R.drawable.germany,
            R.drawable.italy,
            R.drawable.usa,
            R.drawable.uk,
    };
    String[] buyArray = {"5.65464", "5.65464", "5.65464", "5.65464"};
    String[] sellArray = {"5.64", "5.66", "5.65", "5.63"};

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


        RecyclerView recyclerView = findViewById(R.id.lista);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        CostumList adapter = new CostumList(this, nameArray, rovArray, imageArray, buyArray, sellArray, position -> {

            String title = nameArray[position];
            String message = "Rövidítés: " + rovArray[position]
                    + "\nVételi: " + buyArray[position]
                    + "\nEladási: " + sellArray[position];

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .show();
        });


        recyclerView.setAdapter(adapter);
    }
}