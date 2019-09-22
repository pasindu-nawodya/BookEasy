package com.example.bookeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class updateBooking extends AppCompatActivity {
    
    EditText in,out,nRoom;
    TextView packView,prefView;
    RadioGroup pack,pref;
    RadioButton radioOption,radioOptionPref;
    Button senDbBtn, checkin, checkout;
    String packType,prefType;
    Room room;

    DatabaseReference dbRef;

    Calendar c;
    DatePickerDialog dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_booking);
        
        in = findViewById(R.id.checkinText);
        out = findViewById(R.id.checkoutText);
        nRoom = findViewById(R.id.noRoom);
        pack = findViewById(R.id.packageRadioGroup);
        pref = findViewById(R.id.prefRadioGrp);
        packView = findViewById(R.id.packdata);
        prefView = findViewById(R.id.prefdata);
        senDbBtn = findViewById(R.id.update);

        checkin = (Button) findViewById(R.id.checkin);
        checkout = (Button) findViewById(R.id.checkout);

        Calendar calendar = Calendar.getInstance();


        dbRef = FirebaseDatabase.getInstance().getReference().child("Room").child("1");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String cin = dataSnapshot.child("checkinDate").getValue().toString();
                String cout = dataSnapshot.child("checkoutDate").getValue().toString();
                String pack_s = dataSnapshot.child("packages").getValue().toString();
                String room = dataSnapshot.child("noOfRoom").getValue().toString();
                String pref_s = dataSnapshot.child("preference").getValue().toString();

                in.setText(cin);
                out.setText(cout);
                nRoom.setText(room);
                packView.setText(pack_s);
                prefView.setText(pref_s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //pref Radio
        pref.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                radioOptionPref = pref.findViewById(i);

                switch (i){

                    case R.id.BreakFast_Lunch:
                        prefType = radioOptionPref.getText().toString();

                        break;

                    case R.id.Dinner:
                        prefType = radioOptionPref.getText().toString();
                        break;

                    case R.id.All:
                        prefType = radioOptionPref.getText().toString();
                        break;


                    default:

                }
            }
        });

        //update
        //radio button
        pack.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                radioOption = pack.findViewById(i);

                switch (i){

                    case R.id.gold:
                        packType = radioOption.getText().toString();

                        break;

                    case R.id.silver:
                        packType = radioOption.getText().toString();
                        break;

                    case R.id.regular:
                        packType = radioOption.getText().toString();
                        break;


                    default:

                }

            }
        });

        //send data to database
        room = new Room();

        senDbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Room");

                room.setCheckinDate(in.getText().toString().trim());
                room.setCheckoutDate(out.getText().toString().trim());
                room.setPackages(packType.trim());
                room.setNoOfRoom(nRoom.getText().toString().trim());
                room.setPreference(prefType.trim());

                dbRef.child("1").setValue(room);
                Toast.makeText(updateBooking.this, "Update Successfully", Toast.LENGTH_LONG).show();

                Intent bookList = new Intent(updateBooking.this,roomBookList.class);
                startActivity(bookList);
            }
        });

        checkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dp = new DatePickerDialog(updateBooking.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int Year, int Month, int Date) {

                        in.setText(Date + "/" + (Month+1) + "/" + Year);
                    }

                }, day, month, year);

                dp.show();
            }


        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dp = new DatePickerDialog(updateBooking.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int Year, int Month, int Date) {

                        out.setText(Date + "/" + (Month+1) + "/" + Year);
                    }

                }, day, month, year);

                dp.show();
            }


        });

    }

}
