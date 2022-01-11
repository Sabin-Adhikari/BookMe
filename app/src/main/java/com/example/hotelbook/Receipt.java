package com.example.hotelbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Receipt extends AppCompatActivity {

    TextView name, country, city, price;
    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        Bundle b = new Bundle();
        b = intent.getExtras();
        String[] mybooking = b.getStringArray("paid");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        name = (TextView) findViewById(R.id.myHotelName);
        name.setText(mybooking[1]);
        city = (TextView) findViewById(R.id.mycity);
        city.setText("Sydney");
        price = (TextView) findViewById(R.id.myprice);
        price.setText(mybooking[2] + " - " + "$800");
        country = (TextView) findViewById(R.id.mycountry);
        country.setText(mybooking[0]);
        img = (ImageView) findViewById(R.id.myimage);
        img.setImageResource(Integer.parseInt(mybooking[3]));

        btn = (Button) findViewById(R.id.viewhome);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Receipt.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putStringArray("fromReceipt", mybooking);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}