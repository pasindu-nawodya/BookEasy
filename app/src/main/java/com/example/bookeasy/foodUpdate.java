package com.example.bookeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class foodUpdate extends AppCompatActivity {

    EditText qty;
    TextView fname,type;
    Button update;
    Food foodClass;
    RadioGroup ftype,food;
    RadioButton radioOption,radioOptionType;
    String foodName,foodType;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_update);

        fname = findViewById(R.id.flav);
        type=findViewById(R.id.typeUpdate);
        qty = findViewById(R.id.qty);
        ftype = findViewById(R.id.prefRadioGrp);
        food = findViewById(R.id.packageRadioGroup);
        update = findViewById(R.id.updateFood);

        //food radio
        food.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                radioOption = food.findViewById(i);

                switch (i) {

                    case R.id.Submarine:
                        foodName = radioOption.getText().toString();
                        break;

                    case R.id.Burger:
                        foodName = radioOption.getText().toString();
                        break;

                    case R.id.Sandwich:
                        foodName = radioOption.getText().toString();
                        break;


                    default:

                }
            }
        });

        //food Type
        ftype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                radioOptionType = ftype.findViewById(i);

                switch (i) {

                    case R.id.Veg:
                        foodType = radioOptionType.getText().toString();
                        break;

                    case R.id.Non_Veg:
                        foodType = radioOptionType.getText().toString();
                        break;

                    default:

                }
            }
        });


        //show oreder details
        dbRef = FirebaseDatabase.getInstance().getReference().child("Food").child("1");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String foodname = dataSnapshot.child("foodname").getValue().toString();
                String qtyf = dataSnapshot.child("qty").getValue().toString();
                String typf = dataSnapshot.child("type").getValue().toString();


                fname.setText(foodname);
                qty.setText(qtyf);
                type.setText(typf);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //send data to database
        foodClass = new Food();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Food");

                foodClass.setFoodname(foodName.trim());
                foodClass.setQty(qty.getText().toString().trim());
                foodClass.setType(foodType.trim());
                //  foodClass.setPrice(prize.trim());


                dbRef.child("1").setValue(foodClass);
                Toast.makeText(foodUpdate.this, "Order Update Successfully", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(foodUpdate.this,food_list.class);
                startActivity(intent);
            }
        });



    }
}

