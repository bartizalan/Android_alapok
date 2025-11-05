package com.example.hazi_03;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private EditText pc;
    private EditText pn;
    private EditText pp;

    private Button ap;
    private Button can;
    private Button listB;
    private TextView list;
    private TextView uzi;


    private ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pc = findViewById(R.id.pct);
        pn = findViewById(R.id.pnt);
        pp = findViewById(R.id.ppt);
        ap = findViewById(R.id.ap);
        can = findViewById(R.id.can);
        listB = findViewById(R.id.listB);
        list = findViewById(R.id.list);
        uzi = findViewById(R.id.uzi);


        // törlés gomb
        can.setOnClickListener(view -> {
            pc.setText("");
            pn.setText("");
            pp.setText("");
        });

        // hozzáadás gomb
        ap.setOnClickListener(view -> {
            String code = pc.getText().toString().trim();
            String name = pn.getText().toString().trim();

            if (code.isEmpty() || name.isEmpty() || pp.getText().toString().trim().isEmpty()) {
                uzi.setText("Tölts ki minden mezőt!");
                return;
            }

            double price = Double.parseDouble(pp.getText().toString().trim());
            boolean found = false;

            for (Product prod : products) {
                if (prod.getPc().equals(code) &&
                        prod.getPn().equals(name) &&
                        prod.getPp() == price) {


                    prod.increaseDb();
                    found = true;
                    uzi.setText("Mar letezo termek, noveltuk a mennyiseget");
                    break;
                }
            }


            if (!found) {
                products.add(new Product(code, name, price, 1));
                uzi.setText("Sikeres hozzaadas");
            }


        });


        listB.setOnClickListener(view -> {
            list.setText("");
            for (Product p : products) {
                list.append(p.getPn() + " (" + p.getDb() + " db, " + p.getPp() + " RON)\n");
            }
        });
    }
}
