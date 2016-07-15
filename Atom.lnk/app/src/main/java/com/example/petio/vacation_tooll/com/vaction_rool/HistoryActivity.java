package com.example.petio.vacation_tooll.com.vaction_rool;



import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.petio.vacation_tooll.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class HistoryActivity extends android.support.v4.app.Fragment {
    String username;
    private ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> listAdapter;
    private ListView listList;



    public HistoryActivity(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_history,null);
        Bundle b = getActivity().getIntent().getExtras();
        username = b.get("username").toString();


        listAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);
        listList = (ListView) view.findViewById(R.id.arrayList);
        listList.setAdapter(listAdapter);

        refresh();
        return view;
    }
    public void refresh(){
        list.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        AsyncHttpResponseHandler responseHandler = new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String str = new String(bytes);
                if(str.length() > 0) {
                    String[] arr = str.split("\n");
                    for (String row : arr) {
                        list.add(row.split(":")[0] + "   " + row.split(":")[1]);
                        listAdapter.notifyDataSetChanged();
                    }
                }
            }
            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {


            }
        };
        String url = "http://192.168.1.103:8085/Vacantion-Tool/History";//?username=" + username + "&password=" + password;
        RequestParams params = new RequestParams();
        params.add("username",username);
        client.get(url, params, responseHandler);
    }
}
