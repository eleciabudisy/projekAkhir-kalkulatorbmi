package com.example.myscaleapk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class hasil extends AppCompatActivity {

    FirebaseAuth mAuth;

    TextView mbmidisplay,magedisplay,mweightdisplay,mheightdisplay,mbmicategory,mgender;
    Button mgotomain;
    Button mtips;
    Button mlogout;
    Intent intent;
    String namaUser;

    ImageView mimageview;
    String mbmi;
    String cateogory;
    float intbmi;

    String height;
    String weight;

    float intheight,intweight;

    RelativeLayout mbackground;

    @SuppressLint({"ResourceAsColor", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_hasil);
        getSupportActionBar().setElevation(0);
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#FF018786"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        mAuth = FirebaseAuth.getInstance();
        getSupportActionBar().setTitle("Hasil");


        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        magedisplay=findViewById(R.id.agedisplay);
        mweightdisplay=findViewById(R.id.weightdisplay);
        mbmicategory = findViewById(R.id.bmicategorydispaly);
        mtips = findViewById(R.id.tips);
        mgotomain=findViewById(R.id.gotomain);
        mlogout = findViewById(R.id.logout);

        mimageview=findViewById(R.id.imageview);

        mheightdisplay=findViewById(R.id.heightdisplay);
        mbackground=findViewById(R.id.contentlayout);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");


        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);


        mbmi=Float.toString(intbmi);
        System.out.println(mbmi);

        if(intbmi<16)
        {
            mbmicategory.setText("Sangat Kurus");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);

        }
        else if(intbmi<16.9 && intbmi>16)
        {
            mbmicategory.setText("Kurus");
            mbackground.setBackgroundColor(R.color.hijau);
            mimageview.setImageResource(R.drawable.warning);

        }
        else if(intbmi<18.4 && intbmi>17)
        {
            mbmicategory.setText("Lumayan Kurus");
            mbackground.setBackgroundColor(R.color.hijau);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<24.9 && intbmi>18.5 )
        {
            mbmicategory.setText("Normal");
            mimageview.setImageResource(R.drawable.ok);
        }
        else if(intbmi <29.9 && intbmi>25)
        {
            mbmicategory.setText("Gemuk");
            mbackground.setBackgroundColor(R.color.hijau);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<34.9 && intbmi>30)
        {
            mbmicategory.setText("Obesitas I");
            mbackground.setBackgroundColor(R.color.hijau);
            mimageview.setImageResource(R.drawable.warning);
        }
        else
        {
            mbmicategory.setText("Obesitas II");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }

        magedisplay.setText(intent.getStringExtra("age")+" th");
        mheightdisplay.setText(intent.getStringExtra("height")+" cm");
        mweightdisplay.setText(intent.getStringExtra("weight")+" kg");
        mbmidisplay.setText(mbmi);

        mtips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),tips.class);
                startActivity(intent);
            }
        });


        mgotomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });


        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent2=new Intent(getApplicationContext(),home.class);
                startActivity(intent2);
            }
        });



    }
}

