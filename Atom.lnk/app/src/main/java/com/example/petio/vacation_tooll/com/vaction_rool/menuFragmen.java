package com.example.petio.vacation_tooll.com.vaction_rool;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.petio.vacation_tooll.R;

/**
 * Created by petio on 7/11/2016.
 */
public class menuFragmen extends Fragment {
    Fragment frag;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    public menuFragmen(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        frag = new RequestActivity();
        fragmentTransaction = getFragmentManager().beginTransaction().add(R.id.container,frag);
        fragmentTransaction.commit();

        View v = inflater.inflate(R.layout.menu_layout,container,false);


        Button btReq = (Button)v.findViewById(R.id.button_req);
        Button btHis = (Button)v.findViewById(R.id.button2_his);

        btReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag = new RequestActivity();
                fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container,frag);
                fragmentTransaction.commit();
            }
        });

        btHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag = new HistoryActivity();
                fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container,frag);
                fragmentTransaction.commit();

            }
        });

        return v;
    }
}
