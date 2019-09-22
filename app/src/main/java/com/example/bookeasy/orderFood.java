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

public class orderFood extends AppCompatActivity {

    RadioButton radioOption, radioOptionType;
    RadioGroup food, ftype;
    EditText qty;
    Button send;
    Food foodClass;
    DatabaseReference dbRef;
    String prize,qtyString;
    String qtyFood,totPrize;
    String foodName;
    String foodType;
    Integer prizeq;
    Integer fqty;
    String prizef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_food);


        food = findViewById(R.id.packageRadioGroup);
        qty = findViewById(R.id.qty);
        ftype = findViewById(R.id.prefRadioGrp);
        send = findViewById(R.id.next);

        //fqty = Integer.parseInt(qty.getText().toString());


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
                        foodName="not work";

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
                        foodType="not work";

                }
            }
        });


        //send data to database
        foodClass = new Food();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean check = validateForm();

                if (check == true) {

                    dbRef = FirebaseDatabase.getInstance().getReference().child("Food");

                    foodClass.setFoodname(foodName.trim());
                    foodClass.setQty(qty.getText().toString().trim());
                    foodClass.setType(foodType.trim());


                    dbRef.child("1").setValue(foodClass);
                    Toast.makeText(orderFood.this, "Ordered Successfully", Toast.LENGTH_LONG).show();

                    Intent main = new Intent(orderFood.this, food_list.class);
                    startActivity(main);
                }
            }
        });
    }

    private boolean validateForm(){

        String qtyF = qty.getText().toString();


        if(qtyF.isEmpty()){
            qty.setError("Feild can't be empty");

            return false;
        }else{
            return  true;
        }
    }

}
