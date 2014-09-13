package com.example.altafshaikh.badgecustomview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import badgecustomview.CustomBadge;


public class MyActivity extends Activity {
    CustomBadge customBadge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        customBadge =(CustomBadge)findViewById(R.id.customebadge);
        customBadge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customBadge.clearTextBadge();
            }
        });


    }



}
