package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class reserve extends AppCompatActivity {

    TextView inDate,outDate,noRoom,packages,pref;
    String in_Date,out_Date,no_Room,pack_s,pref_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        inDate = findViewById(R.id.checkInDate);
        outDate = findViewById(R.id.checkOutDate);
        packages = findViewById(R.id.packages);
        noRoom = findViewById(R.id.noRoom);
        pref = findViewById(R.id.preference);

        Intent intent = getIntent();

        in_Date = intent.getStringExtra("in");
        out_Date = intent.getStringExtra("out");
        no_Room = intent.getStringExtra("room");
        pack_s = intent.getStringExtra("pack");
        pref_s = intent.getStringExtra("bFast");

        inDate.setText(in_Date);
        outDate.setText(out_Date);
        packages.setText(pack_s);
        noRoom.setText(no_Room);
        pref.setText(pref_s);

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
