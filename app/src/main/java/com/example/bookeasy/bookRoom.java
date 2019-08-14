package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bookRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room);
    }

    public void confReserve(View view){

        Intent iRes = new Intent(bookRoom.this,reserve.class);
        startActivity(iRes);
    }
}
