package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class bookRoom extends AppCompatActivity {

    EditText check_in,check_out,noRoom;
    RadioGroup pack;
    CheckBox breakfast,lunch,dinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room);

        check_in = findViewById(R.id.checkinText);
        check_out = findViewById(R.id.checkoutText);
        noRoom = findViewById(R.id.noRoom);
        pack = findViewById(R.id.packageRadioGroup);
        breakfast = findViewById(R.id.breakFast);
        lunch = findViewById(R.id.lunch);
        dinner = findViewById(R.id.dinner);
    }

    public void confReserve(View view){

        Intent iRes = new Intent(bookRoom.this,reserve.class);

        String checkIn = check_in.getText().toString();
        String checkout = check_out.getText().toString();
        String no_room = noRoom.getText().toString();
        String packages = String.valueOf(pack.getCheckedRadioButtonId());
        String breakFast = breakfast.getText().toString();
        //String Lunch = lunch.getText().toString();
        //String Dinner = dinner.getText().toString();

        iRes.putExtra("in",checkIn);
        iRes.putExtra("out",checkout);
        iRes.putExtra("room",no_room);
        iRes.putExtra("pack",packages);
        iRes.putExtra("bFast",breakFast);
        //iRes.putExtra("Lunch",Lunch);
        //iRes.putExtra("dinner",Dinner);

        startActivity(iRes);
    }


}
