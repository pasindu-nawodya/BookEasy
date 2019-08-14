package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class reserve extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
    }

    public void backBookRoom(View view){

        Intent ibook = new Intent(reserve.this,bookRoom.class);
        startActivity(ibook);
    }

    public void bookingList(View view){

        Intent bookList = new Intent(reserve.this,roomBookList.class);
        startActivity(bookList);
    }
}
