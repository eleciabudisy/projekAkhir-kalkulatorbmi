package com.example.myscaleapk;

import androidx.appcompat.app.AppCompatActivity;


import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    EditText edtRegEmail, edtRegPassword, edtRegNama, edtRegConfirm;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_regis);

        edtRegEmail = findViewById(R.id.edt_email);
        edtRegNama = findViewById(R.id.edt_nama);
        edtRegPassword = findViewById(R.id.edt_passw);
        edtRegConfirm = findViewById(R.id.edt_conf);

        mAuth = FirebaseAuth.getInstance();
    }

    public void register(View v){
        String email, nama, password, confirm;
        email = edtRegEmail.getText().toString();
        nama = edtRegNama.getText().toString();
        password = edtRegPassword.getText().toString();
        confirm = edtRegConfirm.getText().toString();

        if(password.equals(confirm)){
            mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class)
                                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), "Registrasi Gagal, Paasword harus lebih dari 6 karakter", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

        } else {
            Toast.makeText(this,"Password dan Konfirmasi tidak sama", Toast.LENGTH_LONG).show();
        }
    }

    public void toLogin(View v){
        startActivity(new Intent(this, login.class));
    }
}
