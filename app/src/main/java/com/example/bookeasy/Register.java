package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText name,email,password,telephone;
    Button signup;
    Customer customer;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        telephone = findViewById(R.id.telephone);
        signup = findViewById(R.id.signup);

        customer = new Customer();

        signup.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                boolean x = validateForm();

                if(x == true) {
                    dbRef = FirebaseDatabase.getInstance().getReference().child("Customer");

                    customer.setName(name.getText().toString().trim());
                    customer.setEmail(email.getText().toString().trim());
                    customer.setPassword(password.getText().toString().trim());
                    customer.setTelephone(telephone.getText().toString().trim());

                    dbRef.child("1").setValue(customer);
                    Toast.makeText(Register.this, "Data Saved Successfuly", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);

                }
            }

        });

    }
    private boolean validateForm(){

        String inputEmail = email.getText().toString();
        String inputName = name.getText().toString();
        String inputPassword = password.getText().toString();
        String inputTelephone = telephone.getText().toString();

        if(inputEmail.isEmpty() || inputName.isEmpty() || inputPassword.isEmpty() || inputTelephone.isEmpty() ){
            email.setError("Feild can't be empty");
            name.setError("Feild can't be empty");
            password.setError("Feild can't be empty");
            telephone.setError("Feild can't be empty !");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()){
            email.setError("Please enter a valid email address");
            return false;
        }else if(!(telephone.length()==10)){
            telephone.setError("Invalid Telephone Number");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }

    public void Login(View view) {
        Intent intent1 = new Intent(this, Login.class);
        startActivity(intent1);
    }
}
