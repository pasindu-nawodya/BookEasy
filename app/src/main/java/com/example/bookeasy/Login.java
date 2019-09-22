package com.example.bookeasy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button button;
    Customer customer;
    String email1;
    String password1;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emaillog);
        password = findViewById(R.id.passwordlog);
        button = findViewById(R.id.button);

        dbref = FirebaseDatabase.getInstance().getReference().child("Customer").child("1");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                email1 = dataSnapshot.child("email").getValue().toString();
                password1 = dataSnapshot.child("password").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean x = validateLogin();

                if(x==true){
                    Intent intent1 = new Intent(Login.this, appHome.class);
                    startActivity(intent1);
                }else{
                    Toast.makeText(Login.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private boolean validateLogin(){

        String inputEmail = email.getText().toString();
        String inputPassword = password.getText().toString();

        if(inputEmail.equals(email1) && inputPassword.equals(password1)) {
            return true;
        }else if(inputEmail.isEmpty() || inputPassword.isEmpty()){
            email.setError("Feild can't be empty");
            password.setError("Feild can't be empty");
            return false;
        }else{
            return false;
        }
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