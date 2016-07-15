package com.example.petio.vacation_tooll.com.vaction_rool;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petio.vacation_tooll.AccountActivity;
import com.example.petio.vacation_tooll.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class RequestActivity extends Fragment {
    String startDate;
    String endDate;
    String username;
    String days;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_request, null);
        Bundle b = getActivity().getIntent().getExtras();
        username = b.get("username").toString();
        days = b.get("days").toString();
  //      TextView text = (TextView) getView().findViewById(R.id.tv_Username);
    //    text.setText("You have" + days + "days");
        Button bt = (Button) view.findViewById(R.id.bt_SignIn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
        return view;
    }
    public void send(){
        EditText start = (EditText) getView().findViewById(R.id.username);
        startDate =start.getText().toString();
        EditText end = (EditText) getView().findViewById(R.id.password);

        endDate = end.getText().toString();

        AsyncHttpClient client = new AsyncHttpClient();
        AsyncHttpResponseHandler responseHandler = new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String str = new String(bytes);
            }
            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {


            }
        };
        String url = "http://192.168.1.103:8085/Vacantion-Tool/Vacarion";//?username=" + username + "&password=" + password;
        RequestParams params = new RequestParams();
        params.add("username",username);
        params.add("dates",startDate + "-" + endDate);
        client.get(url,params,responseHandler);
    }
}
