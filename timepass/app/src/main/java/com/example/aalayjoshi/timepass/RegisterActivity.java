package com.example.aalayjoshi.timepass;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText rg_name = (EditText) findViewById(R.id.rg_name);
        final EditText rg_username = (EditText) findViewById(R.id.rg_username);
        final EditText rg_password = (EditText) findViewById(R.id.rg_password);
        final EditText rg_age = (EditText) findViewById(R.id.rg_age);
        final Button rg_btn = (Button) findViewById(R.id.rg_btn);

        rg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = rg_name.getText().toString();
                final int age = Integer.parseInt(rg_age.getText().toString());
                final String username = rg_username.getText().toString();
                final String password = rg_password.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse =  new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");

                            if(success)
                            {
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            }
                            else

                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Registration Failed!!")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name , username , age , password , responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
