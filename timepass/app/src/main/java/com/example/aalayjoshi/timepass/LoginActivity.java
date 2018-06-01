package com.example.aalayjoshi.timepass;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText lg_username = (EditText) findViewById(R.id.lg_username);
        final EditText lg_password = (EditText) findViewById(R.id.lg_password);
        final Button login_btn = (Button) findViewById(R.id.login_btn);

        final TextView lg_register = (TextView) findViewById(R.id.lg_register);

        lg_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username = lg_username.getText().toString();
                final String password = lg_password.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success){

                                String name = jsonResponse.getString("name");
                                int age = jsonResponse.getInt("age");

                                Intent intent = new Intent(LoginActivity.this,UserActivity.class);

                                intent.putExtra("name",name);
                                intent.putExtra("username",username);
                                intent.putExtra("age",age);

                                LoginActivity.this.startActivity(intent);

                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed!!")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };


                LoginRequest loginRequest = new LoginRequest(username , password , responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
