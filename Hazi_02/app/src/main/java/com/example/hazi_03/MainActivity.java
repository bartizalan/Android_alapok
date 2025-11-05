package com.example.hazi_03;

import android.app.Activity;
import android.content.Intent;
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

import com.example.hazi_03.R;
import com.example.hazi_03.SecondActivity;



public class MainActivity extends AppCompatActivity {

    private EditText password;
    private EditText email;
    private Button log;
    private Button home;
    private Button sign;

    private TextView hiba;
    private ArrayList<User> users = new ArrayList<>();

    private boolean checkUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

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

        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        log = findViewById(R.id.log);
        home = findViewById(R.id.home);
        sign = findViewById(R.id.sign);
        hiba = findViewById(R.id.hiba);




        home.setOnClickListener(view -> {
            email.setText("");
            password.setText("");
        });



        log.setOnClickListener(view -> {
            if (checkUser(email.getText().toString(), password.getText().toString())) {
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
            } else {
                hiba.setText("Nincs ilyen felhasználó!");
            }
        });



        sign.setOnClickListener(view -> {
            if (checkUser(email.getText().toString(), password.getText().toString())) {
                hiba.setText("Már van ilyen felhasználó!");
            } else {
                users.add(new User(email.getText().toString(), password.getText().toString()));
                hiba.setText("Sikeres regisztráció!");
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
            }
        });


    }
}