package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class roomBookList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_book_list);
    }

    public void updateBook(View view){

        Intent upBook = new Intent(roomBookList.this,updateBooking.class);
        startActivity(upBook);
    }

    public void roomHome(View view){

        Intent homeRoom = new Intent(roomBookList.this,roomHome.class);
        startActivity(homeRoom);
    }
}
