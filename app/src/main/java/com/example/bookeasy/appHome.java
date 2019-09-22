package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class appHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);

    }

    public void roomHome(View view){

        Intent homeRoom = new Intent(appHome.this,roomHome.class);
        startActivity(homeRoom);
    }

    public void table(View view){

        Intent homeTable = new Intent(appHome.this,start.class);
        startActivity(homeTable);
    }

    public void account(View view){

        Intent homeAccount = new Intent(appHome.this,Profile.class);
        startActivity(homeAccount);
    }

    public void food(View view){

        Intent homeFood = new Intent(appHome.this,foodHome.class);
        startActivity(homeFood);
    }
}
