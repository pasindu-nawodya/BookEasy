package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class bookRoom extends AppCompatActivity {

    EditText check_in,check_out,noRoom;
    RadioButton radioOption,radioOptionPref;
    RadioGroup pack,pref;
    DatabaseReference dbRef;
    Button btn;
    Room room;

    String packType,prefType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room);

        check_in = findViewById(R.id.checkinText);
        check_out = findViewById(R.id.checkoutText);
        noRoom = findViewById(R.id.noRoom);
        btn = findViewById(R.id.next);
        pack = findViewById(R.id.packageRadioGroup);
        pref = findViewById(R.id.prefRadioGrp);


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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Room");

                room.setCheckinDate(check_in.getText().toString().trim());
                room.setCheckoutDate(check_out.getText().toString().trim());
                room.setPackages(packType.trim());
                room.setNoOfRoom(noRoom.getText().toString().trim());
                room.setPreference(prefType.trim());

                dbRef.child("1").setValue(room);
                Toast.makeText(bookRoom.this, "Reserved Successfully", Toast.LENGTH_LONG).show();

                Intent bookList = new Intent(bookRoom.this,roomBookList.class);
                startActivity(bookList);
            }
        });


    }

}
