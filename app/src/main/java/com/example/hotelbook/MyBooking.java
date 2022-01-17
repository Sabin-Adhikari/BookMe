package com.example.hotelbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyBooking extends AppCompatActivity {

    TextView name, country, city, price, service,customer, services;
    ImageView img;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);

        Intent intent = getIntent();
        Bundle b = new Bundle();
        b = intent.getExtras();
        ArrayList<String> mybooking = new ArrayList<String>();
         mybooking = b.getStringArrayList("fromH");

        name = (TextView) findViewById(R.id.myHotelName);
        name.setText(mybooking.get(1));
        price = (TextView) findViewById(R.id.myHotelPrice);
        price.setText(mybooking.get(2) + " - " + "$800");
        country = (TextView) findViewById(R.id.myCountry);
        country.setText(mybooking.get(0) +" ,Sydney");
        img = (ImageView) findViewById(R.id.myImage);
        img.setImageResource(Integer.parseInt(mybooking.get(3)));
        service = (TextView)findViewById(R.id.myServicePrice);
        service.setText("Additional Service Price: $"+mybooking.get(5));
        customer = (TextView)findViewById(R.id.myName);
        customer.setText(mybooking.get(4));
        services = (TextView)findViewById(R.id.myServices);
        services.setText("Additonal Services: "+mybooking.get(6)+"");

        btn = (Button) findViewById(R.id.viewhome);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i = new Intent(mybooking.this, MainActivity.class);
//                Bundle b = new Bundle();
//                b.putStringArray("fromReceipt", mybooking);
              finish();
            }
        });
    }
    }
