package com.example.wosha;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class Seeker extends AppCompatActivity {

    ImageView imgView, imgView2, imgView3, imgView4, imgView5, imgView6, imgView7, imgView8, imgView9, imgView10, imgView11, imgView12;
    Context mContext;
    Button clickMe;
    Dialog popUp;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker);
        mContext = this;
        imgView = findViewById(R.id.imgBell);
        imgView2 = findViewById(R.id.imgBell2);
        imgView3 = findViewById(R.id.imgBell3);
        imgView4 = findViewById(R.id.imgBell4);
        imgView5 = findViewById(R.id.imgBell5);
        imgView6 = findViewById(R.id.imgBell6);
        imgView7 = findViewById(R.id.imgBell7);
        imgView8 = findViewById(R.id.imgBell8);
        imgView9 = findViewById(R.id.imgBell9);
        imgView10 = findViewById(R.id.imgBell10);
        imgView11 = findViewById(R.id.imgBell11);
        imgView12 = findViewById(R.id.imgBell12);
        clickMe = findViewById(R.id.clicker);
        popUp = new Dialog(this);


        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp.setContentView(R.layout.activity_pop_up);
                popUp.show();
            }
        });

        int colorFrom = getResources().getColor(R.color.red);
        int colorTo = getResources().getColor(R.color.green);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(30000); //milliseconds
        colorAnimation.setStartDelay(10000);
        colorAnimation.setRepeatCount(5);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imgView2.setBackgroundColor((int) animation.getAnimatedValue());
                imgView4.setBackgroundColor((int) animation.getAnimatedValue());
                imgView10.setBackgroundColor((int) animation.getAnimatedValue());
                imgView12.setBackgroundColor((int) animation.getAnimatedValue());
            }
        });

        int colorFrom2 = getResources().getColor(R.color.green);
        int colorTo2 = getResources().getColor(R.color.red);
        ValueAnimator colorAnimation2 = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom2, colorTo2);
        colorAnimation2.setDuration(30000);
        colorAnimation2.setStartDelay(20000);
        colorAnimation2.setRepeatCount(5);
        colorAnimation2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imgView.setBackgroundColor((int) animation.getAnimatedValue());
                imgView5.setBackgroundColor((int) animation.getAnimatedValue());
                imgView7.setBackgroundColor((int) animation.getAnimatedValue());
                imgView9.setBackgroundColor((int) animation.getAnimatedValue());
            }
        });

        int colorFrom3 = getResources().getColor(R.color.green);
        int colorTo3 = getResources().getColor(R.color.red);
        ValueAnimator colorAnimation3 = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom3, colorTo3);
        colorAnimation3.setDuration(30000);
        colorAnimation3.setStartDelay(15000);
        colorAnimation3.setRepeatCount(5);
        colorAnimation3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imgView3.setBackgroundColor((int) animation.getAnimatedValue());
                imgView6.setBackgroundColor((int) animation.getAnimatedValue());
                imgView8.setBackgroundColor((int) animation.getAnimatedValue());
                imgView11.setBackgroundColor((int) animation.getAnimatedValue());
            }
        });
        colorAnimation.start();
        colorAnimation2.start();
        colorAnimation3.start();
    }
}