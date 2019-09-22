package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class foodHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_home);
    }

    public void orderFood(View view){

        Intent main = new Intent(foodHome.this,orderFood.class);
        startActivity(main);
    }

    public void orderFoodlist(View view){

        Intent main = new Intent(foodHome.this,food_list.class);
        startActivity(main);
    }

    public void MainAct(View view){

        Intent main = new Intent(foodHome.this,appHome.class);
        startActivity(main);
    }
}
