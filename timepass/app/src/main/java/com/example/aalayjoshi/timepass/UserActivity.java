package com.example.aalayjoshi.timepass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final EditText view_username = (EditText) findViewById(R.id.view_username);
        final EditText view_age = (EditText) findViewById(R.id.view_age);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);

        view_username.setText(username);
        view_age.setText(age + "");


    }
}
