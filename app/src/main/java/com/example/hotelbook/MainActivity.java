package com.example.hotelbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hotelbook.adapter.RecentsAdapter;
import com.example.hotelbook.adapter.TopPlacesAdapter;
import com.example.hotelbook.model.RecentsData;
import com.example.hotelbook.model.TopPlacesData;
import com.google.android.gms.location.LocationServices;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity  {
    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;
    ImageView img;
ArrayList<String>customerBooking = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Log.d("h1",String.valueOf(customerBooking));
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
 if(getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
     Toast.makeText(MainActivity.this,"Location Permission Granted!",Toast.LENGTH_SHORT).show();
 }else{
     requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION},1);
 }
        }
        else{
            Toast.makeText(MainActivity.this,"Location Permission Granted!",Toast.LENGTH_SHORT).show();
        }
        img = (ImageView)findViewById(R.id.viewcart);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customerBooking.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please make a booking first in order to view your booking!", Toast.LENGTH_SHORT).show();
                   // Log.d("home", String.valueOf(customerBooking.length));
                }
             else
                 {
                Intent intent = getIntent();
                Bundle b = new Bundle();
                b = intent.getExtras();
                customerBooking = b.getStringArrayList("fromR");
                Log.d("homeR", String.valueOf(customerBooking.size()));

                Intent i = new Intent(MainActivity.this, MyBooking.class);
                Bundle b1 = new Bundle();
                b1.putStringArrayList("fromH", customerBooking);

                i.putExtras(b1);
                Toast.makeText(MainActivity.this, "Finding your booking, Please Wait!", Toast.LENGTH_SHORT).show();
                startActivity(i);


              }

            }
        });



        // Now here we will add some dummy data in our model class

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Meriton Hotel","Australia","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Pagoda Hotel","Australia","From $300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("Oyo Hotel","Australia","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Yehs Hotel","Australia","From $300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("Hotel Mary","Australia","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Ocean Hotel","Australia","From $300",R.drawable.recentimage2));

        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Hotel Wonder","Australia","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Hotel Wonder","Australia","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Sunshine Hotel","Australia","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Sunshine Hotel","Australia","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Sunshine Hotel","Australia","$200 - $500",R.drawable.topplaces));

        setTopPlacesRecycler(topPlacesDataList);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode ==1){
            if(grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this,"Location Permission Granted!",Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(MainActivity.this,"Location Permission Denied!",Toast.LENGTH_SHORT).show();
            }
    }

}

    private  void setRecentRecycler(List<RecentsData> recentsDataList){

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private  void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }



}





