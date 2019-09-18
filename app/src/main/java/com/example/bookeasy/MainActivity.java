package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Login(View view) {
        Intent intent1 = new Intent(this, Login.class);
        startActivity(intent1);
    }

    public void Register(View view) {
        Intent intent2 = new Intent(this, Register.class);
        startActivity(intent2);
    }


}
