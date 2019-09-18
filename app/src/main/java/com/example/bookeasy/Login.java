package com.example.bookeasy;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Profile(View view) {
        Intent intent2 = new Intent(this, appHome.class);
        startActivity(intent2);
    }

    public void ResetPassword(View view) {
        Intent intent3 = new Intent(this, ResetPassword.class);
        startActivity(intent3);
    }

    public void Register(View view) {
        Intent intent4 = new Intent(this, Register.class);
        startActivity(intent4);
    }
}