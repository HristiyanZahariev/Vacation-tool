package com.example.petio.vacation_tooll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;


public class LoginActivity extends AppCompatActivity {
    final String fielderror = "This field is required!";
    private EditText mUsername;
    private EditText mPassword;
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
        boolean checklog = true;
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);

        // Reset errors.
        mUsername.setError(null);
        mPassword.setError(null);

        // Store the data
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

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
            Intent intent = new Intent(v.getContext(), AccountActivity.class);
            startActivity(intent);
        }
    }
}
