package com.example.bookeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class roomBookList extends AppCompatActivity {

    TextView cIn,cOut,rooms,pack,pref;
    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_book_list);

        cIn = findViewById(R.id.checkInDate);
        cOut = findViewById(R.id.checkOutDate);
        pack = findViewById(R.id.packages);
        rooms = findViewById(R.id.noRoom);
        pref = findViewById(R.id.preference);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Room").child("1");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               String in = dataSnapshot.child("checkinDate").getValue().toString();
               String out = dataSnapshot.child("checkoutDate").getValue().toString();
                String pack_s = dataSnapshot.child("packages").getValue().toString();
                String nRoom = dataSnapshot.child("noOfRoom").getValue().toString();
              String prefs = dataSnapshot.child("preference").getValue().toString();

                cIn.setText(in);
                cOut.setText(out);
                pack.setText(pack_s);
                rooms.setText(nRoom);
                pref.setText(prefs);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void updateBook(View view){

        Intent upBook = new Intent(roomBookList.this,updateBooking.class);
        startActivity(upBook);
    }

    public void backHome(View view){
        Intent intent=new Intent(roomBookList.this,appHome.class);
        startActivity(intent);
    }

}
