package com.example.bookeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class roomHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_home);
    }

    public void bookRoom(View view){

        Intent intent = new Intent(roomHome.this,bookRoom.class);
        startActivity(intent);
    }

    public void bookList(View view){

        Intent bList = new Intent(roomHome.this,roomBookList.class);
        startActivity(bList);
    }

    public void MainAct(View view){

        Intent main = new Intent(roomHome.this,appHome.class);
        startActivity(main);
    }
}
