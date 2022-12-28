package com.example.myscaleapk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class home extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);

       mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        if(user != null){
            startActivity(new Intent(this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }

        Button login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                masuk (view);
            }
        });

        Button register = (Button) findViewById(R.id.btn_regis);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                daftar (view);
            }
        });
    }

    public void masuk(View view){
        Intent it = new Intent(this, login.class);
        startActivity(it);
    }

    public void daftar(View view){
        Intent it = new Intent(this, register.class);
        startActivity(it);
    }

}
