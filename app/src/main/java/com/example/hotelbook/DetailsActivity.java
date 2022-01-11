package com.example.hotelbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelbook.model.hotelView;
import com.google.gson.Gson;

public class DetailsActivity extends AppCompatActivity {
TextView hotelName, price,country,imageUrl;
ImageView hotelImg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent  = getIntent();
        //String h = intent.getStringExtra("hotel");
        Gson gson = new Gson();
        hotelView myHotel;
         myHotel =  gson.fromJson(intent.getStringExtra("hotel"),hotelView.class);

        Log.d("recieved",myHotel.getPlaceName());


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        hotelName = (TextView)findViewById(R.id.textView6);
        hotelName.setText(myHotel.getPlaceName()+" "+",Sydney");
        price = (TextView)findViewById(R.id.textView11);
        price.setText(myHotel.getPrice()+" "+" - $800");
        country = (TextView)findViewById(R.id.textView10);
        country.setText(myHotel.getCountryName());
       // File imageFile  = new File("/Users/sabinadhikari/AndroidStudioProjects/HotelBook/app/src/main/res/drawable/recentimage1.png");
       hotelImg = (ImageView)findViewById(R.id.hotelImg);
       hotelImg.setImageResource(myHotel.getImageUrl());

        Button btn = (Button) findViewById(R.id.makePay);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailsActivity.this,PaymentForm.class);
                Bundle b = new Bundle();
                b.putStringArray("booked",new String[]{myHotel.getCountryName(),
                        myHotel.getPlaceName(),myHotel.getPrice(),(myHotel.getImageUrl()+"")});
               i.putExtras(b);
                startActivity(i);

            }
        });





    }

}