package com.example.bookeasy;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Delete extends AppCompatActivity {

    DatabaseReference dbRef;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delete = findViewById(R.id.delete);

        dbRef = FirebaseDatabase.getInstance().getReference().child("student").child("1");

        delete.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                dbRef = FirebaseDatabase.getInstance().getReference().child("student");


                dbRef.child("1").removeValue();
                Toast.makeText(Delete.this, " Successfuly Removed", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Delete.this,Login.class);
                startActivity(intent);


            }

        });


    }
}