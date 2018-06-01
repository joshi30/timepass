package com.example.aalayjoshi.timepass;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AALAY JOSHI on 6/1/2018.
 */

public class LoginRequest extends StringRequest {
    private static final String Login_Url="https://smeary-instance.000webhostapp.com/login.php";
    private Map<String,String> params;

    public LoginRequest(String username,String password,Response.Listener<String>listener){
        super(Method.POST,Login_Url,listener,null);
        params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
