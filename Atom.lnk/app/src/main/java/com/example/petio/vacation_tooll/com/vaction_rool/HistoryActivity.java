package com.example.petio.vacation_tooll.com.vaction_rool;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petio.vacation_tooll.R;

public class HistoryActivity extends android.support.v4.app.Fragment {

    public HistoryActivity(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_history,null);
        return view;
    }
}
