package com.example.bookeasy;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.chrono.JapaneseDate;
import java.util.Calendar;

public class startBooking extends AppCompatActivity {


    EditText date;
    EditText time;
    EditText guest;
    RadioGroup event;
    RadioGroup location;
    RadioButton radioOption;
    RadioButton radioOption2;

    Button done, btn,TimeBtn;
    DatabaseReference dbRef;
    Table tbl;

    private String eventType= "";
    private String locationType= "";

    Calendar c;
    DatePickerDialog dp;

    Context context = this;

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

        btn = (Button) findViewById(R.id.UDatebutton);
        TimeBtn = (Button) findViewById(R.id.UTimebutton);

        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);



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

                boolean check = validateForm();

                if (check == true) {

                    dbRef = FirebaseDatabase.getInstance().getReference().child("Table");


                    tbl.setDate(date.getText().toString().trim());
                    tbl.setTime(time.getText().toString().trim());
                    tbl.setGuest(guest.getText().toString().trim());
                    tbl.setEvent(eventType.trim());
                    tbl.setLocation(locationType.trim());


                    dbRef.child("tbl").setValue(tbl);

                    Toast.makeText(startBooking.this, "Data Saved Successfuly", Toast.LENGTH_SHORT).show();
                    //clearControls();
                    Intent intent = new Intent(startBooking.this, confirmedBooking.class);
                    startActivity(intent);

                }

            }

        });


        //Date Picker
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dp = new DatePickerDialog(startBooking.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int Year, int Month, int Date) {

                        date.setText(Date + "/" + (Month+1) + "/" + Year);
                    }

                }, day, month, year);

                dp.show();
            }


        });

        //Time Picker
        TimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                        time.setText(hour + ":" + minute);
                    }
                },hour,minute, android.text.format.DateFormat.is24HourFormat(context));

                timePickerDialog.show();
            }
        });



    }


    public void startWindow(View view){

        Intent intent = new Intent(startBooking.this,start.class);
        startActivity(intent);

    }

    private boolean validateForm(){

        String date_t = date.getText().toString();
        String time_t = time.getText().toString();
        String guest_t = guest.getText().toString();


        if(date_t.isEmpty() || time_t.isEmpty() || guest_t.isEmpty()){
            time.setError("Feild can't be empty");
            date.setError("Feild can't be empty");
            guest.setError("Feild can't be empty");

            return false;
        }else{
            return  true;
        }
    }



}
