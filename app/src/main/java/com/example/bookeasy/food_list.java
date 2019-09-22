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

public class food_list extends AppCompatActivity {

    TextView fname,qty,type,price;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);


        fname= findViewById(R.id.fname);
        qty= findViewById(R.id.qty);
        price= findViewById(R.id.price);
        type= findViewById(R.id.type);


        dbRef = FirebaseDatabase.getInstance().getReference().child("Food").child("1");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String foodname = dataSnapshot.child("foodname").getValue().toString();
                String qtyf = dataSnapshot.child("qty").getValue().toString();
                String typf = dataSnapshot.child("type").getValue().toString();

                int prz;
                String prizeS;

                if(foodname.equals("Submarine")) {

                    prz= Integer.parseInt(qtyf)*500;
                    prizeS = String.valueOf(prz);

                }else if(foodname.equals("Burger")){
                    prz= Integer.parseInt(qtyf)*300;
                    prizeS = String.valueOf(prz);

                }else{
                    prz= Integer.parseInt(qtyf)*200;
                    prizeS = String.valueOf(prz);

                }



                fname.setText(foodname);
                qty.setText(qtyf);
                price.setText(prizeS);
                type.setText(typf);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void backFHome(View view){

        Intent intent = new Intent(this,foodHome.class);
        startActivity(intent);
    }

    public void update(View view){

        Intent intent = new Intent(this,foodUpdate.class);
        startActivity(intent);
    }

    public void delete(View view){

        Intent intent = new Intent(this,foodHome.class);
        startActivity(intent);
    }
}
