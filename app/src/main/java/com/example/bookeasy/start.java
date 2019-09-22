package com.example.bookeasy;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void startBooking(View view){
        Intent intent = new Intent(start.this, startBooking.class);
        startActivity(intent);
    }

    public void checkBooking(View view){
        Intent intent = new Intent(start.this, viewBookings.class);
        startActivity(intent);
    }
}
