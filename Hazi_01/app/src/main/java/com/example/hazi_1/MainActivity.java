package com.example.hazi_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText  szam1;
    private EditText  szam2;
    private Button add,sub,mult,div;
    private TextView  eredmeny;

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

        szam1 = findViewById(R.id.szam1);
        szam2 = findViewById(R.id.szam2);
        eredmeny = findViewById(R.id.eredmeny);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = getNumber(szam1);
                double b = getNumber(szam2);
                eredmeny.setText(String.valueOf(a + b));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = getNumber(szam1);
                double b = getNumber(szam2);
                eredmeny.setText(String.valueOf(a - b));
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = getNumber(szam1);
                double b = getNumber(szam2);
                eredmeny.setText(String.valueOf(a * b));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = getNumber(szam1);
                double b = getNumber(szam2);
                if (b != 0) {
                    eredmeny.setText(String.valueOf(a / b));
                } else {
                    eredmeny.setText("0-val nem lehet osztani!");
                }
            }
        });
    }

    // Segédfüggvény a szám lekéréséhez az EditText-ből
    private double getNumber(EditText editText) {
        String s = editText.getText().toString();
        if (s.isEmpty()) {
            return 0;
        }
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}