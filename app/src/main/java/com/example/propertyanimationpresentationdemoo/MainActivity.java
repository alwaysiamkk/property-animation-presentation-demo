package com.example.propertyanimationpresentationdemoo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ironman_iv;
    ObjectAnimator alphaObjectAnimator, rotateObjectAnimator, translationObjectAnimator, scaleObjectAnimator;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ironman_iv = findViewById(R.id.imageView);

        alphaObjectAnimator = ObjectAnimator.ofFloat(ironman_iv,View.ALPHA,0);
        alphaObjectAnimator.setRepeatCount(1);
        alphaObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);

        translationObjectAnimator = ObjectAnimator.ofFloat(ironman_iv,View.TRANSLATION_X,400);
        translationObjectAnimator.setRepeatCount(1);
        translationObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);

        rotateObjectAnimator = ObjectAnimator.ofFloat(ironman_iv,"rotation",360);
        rotateObjectAnimator.setRepeatCount(2);
        rotateObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);

        PropertyValuesHolder x = PropertyValuesHolder.ofFloat(View.SCALE_X, 3);
        PropertyValuesHolder y = PropertyValuesHolder.ofFloat(View.SCALE_Y, 3);
        scaleObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(ironman_iv, x, y);
        scaleObjectAnimator.setRepeatCount(1);
        scaleObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);

        animatorSet = new AnimatorSet();
        animatorSet.play(translationObjectAnimator).after(alphaObjectAnimator).before(rotateObjectAnimator);
        animatorSet.play(rotateObjectAnimator).after(scaleObjectAnimator);

    }

    public void alphaAnimation(View v){
        alphaObjectAnimator.start();
    }

    public void translationAnimation(View v){
        translationObjectAnimator.start();
    }

    public void rotateAnimation(View v){
        rotateObjectAnimator.start();
    }

    public void scaleAnimation(View v){
        scaleObjectAnimator.start();
    }

    public void setAnimation(View v){
        animatorSet.start();
    }
}