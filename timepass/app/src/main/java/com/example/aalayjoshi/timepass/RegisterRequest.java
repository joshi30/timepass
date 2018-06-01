package com.example.aalayjoshi.timepass;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class RegisterRequest extends StringRequest {

    private static final String Register_Url="https://smeary-instance.000webhostapp.com/register.php";
    private Map<String,String>params;

    public RegisterRequest(String name,String username,int age,String password,Response.Listener<String>listener){
        super(Method.POST,Register_Url,listener,null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("age",age + "");
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
