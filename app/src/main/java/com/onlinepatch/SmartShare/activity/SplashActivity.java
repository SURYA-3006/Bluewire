package com.onlinepatch.SmartShare.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.onlinepatch.SmartShare.R;

public class SplashActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    ImageView splashImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_main);


        splashImg=findViewById(R.id.img);
        splashImg.animate().setDuration(1000).setStartDelay(4000);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        },4000);
    }
}