package com.example.myscaleapk;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tips_detail extends AppCompatActivity {

    String nama, deskripsi;
    int gambar;
    TextView dtl_makanan, dtl_deskripsi;
    ImageView dtl_gambar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_detail);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nama = bundle.getString("nama");
            deskripsi = bundle.getString("deskripsi");
            gambar = bundle.getInt("gambar");
        }

        dtl_makanan = findViewById(R.id.dtl_judul);
        dtl_makanan.setText(nama);

        dtl_deskripsi = findViewById(R.id.dtl_deskripsi);
        dtl_deskripsi.setText(deskripsi);


        dtl_gambar = findViewById(R.id.dtl_gambar);
        dtl_gambar.setImageResource(gambar);
}}
