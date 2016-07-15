package com.example.petio.vacation_tooll;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class RegisterActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    // UI references.
    private String mNameView;
    private EditText mUsernameView;
    private EditText mFullnameView;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Set up the login form.
        final String fielderror = "This field is required!";
        mUsernameView = (EditText) findViewById(R.id.username);
        mFullnameView = (EditText) findViewById(R.id.fullname);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);

        Button mEmailSignInButton = (Button) findViewById(R.id.signinbtn);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String regcomplete = "Registration complete!";
                boolean checkreg = true;
                /**
                 * Attempts to sign in or register the account specified by the login form.
                 */
                // Reset errors.
                mUsernameView.setError(null);
                mFullnameView.setError(null);
                mEmailView.setError(null);
                mPasswordView.setError(null);

                // Store values at the time of the login attempt.
                String username = mUsernameView.getText().toString();
                String fullname = mFullnameView.getText().toString();
                String email = mEmailView.getText().toString();
                String password = mPasswordView.getText().toString();

                //Check username
                if (TextUtils.isEmpty(username)) {
                    mUsernameView.setError(fielderror);
                    checkreg = false;
                }

                //Check full name
                if (TextUtils.isEmpty(fullname)) {
                    mFullnameView.setError(fielderror);
                    checkreg = false;
                }

                // Check for a valid password, if the user entered one.
                if (TextUtils.isEmpty(password)) {
                    mPasswordView.setError(fielderror);
                    checkreg = false;
                }

                // Check for a valid email address.
                if (TextUtils.isEmpty(email)) {
                    mEmailView.setError(getString(R.string.error_field_required));
                    checkreg = false;
                } else if (!isEmailValid(email)) {
                    mEmailView.setError(getString(R.string.error_invalid_email));
                    checkreg = false;
                }
                if (checkreg == true) {
                    AsyncHttpClient client = new AsyncHttpClient();
                    AsyncHttpResponseHandler responseHandler = new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int i, Header[] headers, byte[] bytes) {
                            String str = new String(bytes);
                            if (str.split(",")[0].equals("reason")) {
                                Toast.makeText(getApplicationContext(), str.split(",")[1].toString(), Toast.LENGTH_SHORT);
                                return;
                            }
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);

                        }

                        @Override
                        public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {


                        }
                    };
                    String url = "http://192.168.1.103:8085/Vacantion-Tool/Register";//?username=" + username + "&password=" + password;
                    RequestParams params = new RequestParams();
                    params.add("username", username);
                    params.add("email", email);
                    params.add("password", password);
                    client.get(url, params, responseHandler);

                }
            }
        });
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }
}

