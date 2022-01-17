package com.example.hotelbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Receipt extends AppCompatActivity {

    TextView name, country, city, price, service,customer, services;
    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<String> mybooking = new ArrayList<String>();
        ArrayList<String> clone = new ArrayList<String>();
        Intent intent = getIntent();
        Bundle b = new Bundle();
        b = intent.getExtras();
       mybooking = b.getStringArrayList("paid");
       for(int i=0;i<mybooking.size();i++){
           clone.add(mybooking.get(i));
       }
       // Log.d("receipt",String.valueOf(mybooking.size());
         Log.d("receipt",mybooking.get(6)+"");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        name = (TextView) findViewById(R.id.cartHotelName);
        name.setText(mybooking.get(1));
        price = (TextView) findViewById(R.id.cartPrice);
        price.setText(mybooking.get(2) + " - " + "$800");
        country = (TextView) findViewById(R.id.cartCountry);
        country.setText(mybooking.get(0) +" ,Sydney");
        img = (ImageView) findViewById(R.id.cartImage);
        img.setImageResource(Integer.parseInt(mybooking.get(3)));
        service = (TextView)findViewById(R.id.cartServicePrice);
        service.setText("Additional Service Price: $"+mybooking.get(5));
        customer = (TextView)findViewById(R.id.cartCustomerName);
        customer.setText("Customer Name: "+mybooking.get(4));
        services = (TextView)findViewById(R.id.cartServices);
        services.setText("Additonal Services: "+mybooking.get(6)+"");

        btn = (Button) findViewById(R.id.viewhome);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Receipt.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putStringArrayList("fromR",clone);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}