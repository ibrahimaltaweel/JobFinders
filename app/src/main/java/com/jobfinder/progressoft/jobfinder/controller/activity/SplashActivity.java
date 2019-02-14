package com.jobfinder.progressoft.jobfinder.controller.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jobfinder.progressoft.jobfinder.R;

public class SplashActivity extends AppCompatActivity {
    private ImageView logo;
    private static int splashTimeOut=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
        logo=(ImageView)findViewById(R.id._background);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeOut);


    }
}