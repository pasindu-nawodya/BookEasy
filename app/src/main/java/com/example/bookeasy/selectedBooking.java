package com.example.bookeasy;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selectedBooking extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_booking);
    }

    public void startBookings(View view){

        Intent intent = new Intent(selectedBooking.this,startBooking.class);
        startActivity(intent);

    }

    public void ConfirmBookings(View view){

        Intent intent = new Intent(selectedBooking.this,confirmedBooking.class);
        startActivity(intent);

    }

}
