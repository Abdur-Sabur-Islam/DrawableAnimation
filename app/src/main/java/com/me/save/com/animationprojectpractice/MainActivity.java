package com.me.save.com.animationprojectpractice;

import android.animation.ValueAnimator;
import android.content.Context;

import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static junit.framework.Assert.assertTrue;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;


    Context context;

   static AnimationDrawable rocketAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, new PlaceHolderFragment()).commit();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            rocketAnimation.start();
            return true;
        }
        return super.onTouchEvent(event);
    }


    public static class PlaceHolderFragment extends Fragment {


        public PlaceHolderFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view =  inflater.inflate(R.layout.fragment_place_holder, container, false);

            ImageView progress = (ImageView)view.findViewById(R.id.image);

            progress.setBackgroundResource(R.drawable.rocket_trust);
            rocketAnimation = (AnimationDrawable) progress.getBackground();


            return view;
        }

    }




}

