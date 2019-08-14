package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class updateBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_booking);
    }

    public void bookList(View view){

        Intent bList = new Intent(updateBooking.this,roomBookList.class);
        startActivity(bList);
    }


}
