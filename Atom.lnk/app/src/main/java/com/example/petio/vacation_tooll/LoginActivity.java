package com.example.petio.vacation_tooll;

import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import cz.msebera.android.httpclient.Header;


import android.view.View;

import android.widget.EditText;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


public class LoginActivity extends AppCompatActivity {
    final String fielderror = "This field is required!";
    private EditText mUsername;
    private EditText mPassword;
    private String username;
    private String password;
    boolean checklog = true;
    int freeDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button regbutton = (Button) findViewById(R.id.regbtn);
        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegisterActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    public void logIn(View v){
        // Set up the login form.
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);

        // Reset errors.
        mUsername.setError(null);
        mPassword.setError(null);

        // Store the data
         username = mUsername.getText().toString();
         password = mPassword.getText().toString();

        //Check username
        if (TextUtils.isEmpty(username)) {
            mUsername.setError(fielderror);
            checklog = false;
        }

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPassword.setError(fielderror);
            checklog = false;
        }
        if(checklog == true) {
            loginUser();
        }


    }
    public void loginUser(){
        AsyncHttpClient client = new AsyncHttpClient();
        AsyncHttpResponseHandler responseHandler = new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String str = new String(bytes);
                if(str.split(",")[0].equals("reason")){
                    Toast.makeText(getApplicationContext(), str.split(",")[1], Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("days", str);
                startActivity(intent);            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {


            }
        };
        String url = "http://192.168.1.103:8085/Vacantion-Tool/loginUser";//?username=" + username + "&password=" + password;
        RequestParams params = new RequestParams();
        params.add("username",username);
        params.add("password",password);
        client.get(url,params,responseHandler);

    }
}
