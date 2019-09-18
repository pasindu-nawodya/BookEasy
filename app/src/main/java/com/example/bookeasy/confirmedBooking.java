package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class confirmedBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmed_booking);
    }

    public void Home(View view){

        Intent intent = new Intent(confirmedBooking.this,start.class);
        startActivity(intent);

    }

    public void viewBookings(View view){

        Intent intent = new Intent(confirmedBooking.this,viewBookings.class);
        startActivity(intent);

    }




}
