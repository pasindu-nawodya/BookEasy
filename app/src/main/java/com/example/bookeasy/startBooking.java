package com.example.bookeasy;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.chrono.JapaneseDate;

public class startBooking extends AppCompatActivity {


    EditText date;
    EditText time;
    EditText guest;
    RadioGroup event;
    RadioGroup location;
    RadioButton radioOption;
    RadioButton radioOption2;

    Button done;
    DatabaseReference dbRef;
    Table tbl;

    private String eventType= "";
    private String locationType= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_booking);


        date = findViewById(R.id.DateeditText);
        time = findViewById(R.id.TimeeditText);
        guest = findViewById(R.id.NoOfGuesteditText);
        event = findViewById(R.id.specialEvents);
        location = findViewById(R.id.location);

        done = findViewById(R.id.buttonNext);


        event.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                radioOption = event.findViewById(i);

                switch (i){

                    case R.id.radioBirthday:
                        eventType = radioOption.getText().toString();

                        break;

                    case R.id.radioParty:
                        eventType = radioOption.getText().toString();
                        break;


                    default:

                }

            }
        });

        location.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                radioOption2 = location.findViewById(i);

                switch (i){

                    case R.id.radioIndoor:
                        locationType = radioOption2.getText().toString();

                        break;

                    case R.id.radioOutdoor:
                        locationType = radioOption2.getText().toString();
                        break;


                    default:

                }

            }
        });

        tbl = new Table();

        done.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Table");



                tbl.setDate(date.getText().toString().trim());
                tbl.setTime(time.getText().toString().trim());
                tbl.setGuest(guest.getText().toString().trim());
                tbl.setEvent(eventType.trim());
                tbl.setLocation(locationType.trim());


                // dbRef.child("tbl").setValue(eventType);
                //tbl.setEvent(event.getText().);
                // Table.setContNum(Integer.parseInt(contact_student.getText().toString().trim()));

                dbRef.child("tbl").setValue(tbl);
                //dbRef.push().child("Table").setValue("Male");
                // dbRef.push().child("tbl").setValue("eventType");

                Toast.makeText(startBooking.this, "Data Saved Successfuly", Toast.LENGTH_SHORT).show();
                //clearControls();
                Intent intent = new Intent(startBooking.this,confirmedBooking.class);
                startActivity(intent);

            }

        });




    }
    /*public void sendData(View view){

        Intent intent = new Intent(startBooking.this,selectedBooking.class);

        String Edate = date.getText().toString();
        String Etime = time.getText().toString();
        String Eguest = guest.getText().toString();
        String Eevent = String.valueOf(event.getCheckedRadioButtonId());
        String ELocation = String.valueOf(location.getCheckedRadioButtonId());

        intent.putExtra("date",Edate);
        intent.putExtra("time",Etime);
        intent.putExtra("guest",Eguest);
        intent.putExtra("event",Eevent);
        intent.putExtra("location",ELocation);

        startActivity(intent);



    }
*/

    public void startWindow(View view){

        Intent intent = new Intent(startBooking.this,start.class);
        startActivity(intent);

    }

    /*public void selectedBooking(View view){

        Intent intent = new Intent(startBooking.this,selectedBooking.class);
        startActivity(intent);
    }

    */


}
