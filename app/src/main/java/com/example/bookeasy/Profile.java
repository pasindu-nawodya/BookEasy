package com.example.bookeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    TextView name,email,password,telephone;
    DatabaseReference dbRef;
    Customer customer;
    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        telephone = findViewById(R.id.telephone);
        update = findViewById(R.id.save);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Customer").child("1");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name1 = dataSnapshot.child("name").getValue().toString();
                String email1 = dataSnapshot.child("email").getValue().toString();
                String password1 = dataSnapshot.child("password").getValue().toString();
                String telephone1 = dataSnapshot.child("telephone").getValue().toString();

                name.setText(name1);
                email.setText(email1);
                password.setText(password1);
                telephone.setText(telephone1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        customer = new Customer();

        update.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                dbRef = FirebaseDatabase.getInstance().getReference().child("Customer");

                customer.setName(name.getText().toString().trim());
                customer.setEmail(email.getText().toString().trim());
                customer.setPassword(password.getText().toString().trim());
                customer.setTelephone(telephone.getText().toString().trim());

                dbRef.child("1").setValue(customer);
                Toast.makeText(Profile.this, "Update Successfuly........", Toast.LENGTH_SHORT).show();


            }

        });


    }
    public void Delete(View view) {
        Intent intent4 = new Intent(this, Delete.class);
        startActivity(intent4);
    }

    public void Home(View view) {
        Intent intent4 = new Intent(this, Login.class);
        startActivity(intent4);
    }
}
