package com.example.bookeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class updateBookingT extends AppCompatActivity {

    EditText editDate,editTime,editGuest,editEvent,editLocation;
    DatabaseReference dbRef;

    Table tbl;
    Button update;
    Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_booking_t);


        editDate = findViewById(R.id.UpdateDate);
        editTime = findViewById(R.id.UpdateTime);
        editGuest = findViewById(R.id.UpdateGuest);
        editEvent = findViewById(R.id.UpdateEvent);
        editLocation = findViewById(R.id.UpdateLocation);


        update = findViewById(R.id.updateBtnNextR);
        delete = findViewById(R.id.deleteBtnNext);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Table").child("tbl");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Edate = dataSnapshot.child("date").getValue().toString();
                String Etime = dataSnapshot.child("time").getValue().toString();
                String Eguest = dataSnapshot.child("guest").getValue().toString();
                String Eevent = dataSnapshot.child("event").getValue().toString();
                String Elocation = dataSnapshot.child("location").getValue().toString();
                //String pref_l = dataSnapshot.child("lunch").getValue().toString();
                //String pref_d = dataSnapshot.child("dinner").getValue().toString();

                editDate.setText(Edate);
                editTime.setText(Etime);
                editGuest.setText(Eguest);
                editEvent.setText(Eevent);
                editLocation.setText(Elocation);
                //pref.setText(pref_b+" , "+pref_l+" and "+pref_d);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        tbl = new Table();

        update.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Table");



                tbl.setDate(editDate.getText().toString().trim());
                tbl.setTime(editTime.getText().toString().trim());
                tbl.setGuest(editGuest.getText().toString().trim());
                tbl.setEvent(editEvent.getText().toString().trim());
                tbl.setLocation(editLocation.getText().toString().trim());




                dbRef.child("tbl").setValue(tbl);
                //dbRef.push().child("Table").setValue("Male");
                // dbRef.push().child("tbl").setValue("eventType");

                Toast.makeText(updateBookingT.this, "Data Updated Successfuly", Toast.LENGTH_SHORT).show();
                //clearControls();
                 Intent intent = new Intent(updateBookingT.this,viewBookings.class);
                startActivity(intent);

            }

        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //deleteTbl();

                //dbRef = FirebaseDatabase.getInstance().getReference().child("Table");
                dbRef.removeValue();

                //dbRef.child("tbl").removeValue();
                Toast.makeText(updateBookingT.this, "Data Deleted Successfuly", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(updateBookingT.this,startBooking.class);
                startActivity(intent);

            }
        });









    }




}

