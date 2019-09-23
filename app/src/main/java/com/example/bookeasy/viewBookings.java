package com.example.bookeasy;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;


public class viewBookings extends AppCompatActivity {


    TextView date,time,guest,event,location;

    //Table tbl;
    DatabaseReference dbRef;
    Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bookings);

        date = findViewById(R.id.dateView);
        time = findViewById(R.id.timeView);
        guest = findViewById(R.id.guestView);
        event = findViewById(R.id.EventView);
        location = findViewById(R.id.LocationView);

        delete = findViewById(R.id.deleteBtnNext);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Table").child("tbl");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Sdate = dataSnapshot.child("date").getValue().toString();
                String Stime = dataSnapshot.child("time").getValue().toString();
                String Sguest = dataSnapshot.child("guest").getValue().toString();
                String Sevent = dataSnapshot.child("event").getValue().toString();
                String Slocation = dataSnapshot.child("location").getValue().toString();
                //String pref_l = dataSnapshot.child("lunch").getValue().toString();
                //String pref_d = dataSnapshot.child("dinner").getValue().toString();

                date.setText(Sdate);
                time.setText(Stime);
                guest.setText(Sguest);
                event.setText(Sevent);
                location.setText(Slocation);
                //pref.setText(pref_b+" , "+pref_l+" and "+pref_d);

                //
                //Intent intent = new Intent(viewBookings.this,updateBooking.class);
                //startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //deleteTbl();

                //dbRef = FirebaseDatabase.getInstance().getReference().child("Table");
                dbRef.removeValue();

                //dbRef.child("tbl").removeValue();
                Toast.makeText(viewBookings.this, "Data Deleted Successfuly", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(viewBookings.this,startBooking.class);
                startActivity(intent);

            }
        });


    }


    public void update(View v){
        Intent intent = new Intent(viewBookings.this,updateBookingT.class);
        startActivity(intent);

    }
}
