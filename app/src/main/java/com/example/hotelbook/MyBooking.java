package com.example.hotelbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBooking extends AppCompatActivity {

    TextView name, country, city, price;
    ImageView img;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);

        Intent intent = getIntent();
        Bundle b = new Bundle();
        b = intent.getExtras();
        String[] mybooking = b.getStringArray("fromH");

        name = (TextView) findViewById(R.id.cartHotelName);
        name.setText(mybooking[1]);
        city = (TextView) findViewById(R.id.cartCity);
        city.setText("Sydney");
        price = (TextView) findViewById(R.id.cartPrice);
        price.setText(mybooking[2] + " - " + "$800");
        country = (TextView) findViewById(R.id.cartCountry);
        country.setText(mybooking[0]);
        img = (ImageView) findViewById(R.id.cartImage);
        img.setImageResource(Integer.parseInt(mybooking[3]));

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
