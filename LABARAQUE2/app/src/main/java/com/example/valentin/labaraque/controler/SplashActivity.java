package com.example.valentin.labaraque.controler;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.valentin.labaraque.MenuActivity;
import com.example.valentin.labaraque.R;
import com.example.valentin.labaraque.model.MyBounceInterpolator;
import com.example.valentin.labaraque.model.PrefManager;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    private static int TIME_OUT = 8000;
    private ImageView img,img2;
    private PrefManager prefManager;
    private Random random;
    private int nombrealeatoire;
    Animation frombottom,fromtop,bounce;
    MyBounceInterpolator interpolator;
    //private int tab[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }
        setContentView(R.layout.activity_splash);



        img = (ImageView) findViewById(R.id.logosplash);
        img2 = (ImageView) findViewById(R.id.fondsplah);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        interpolator = new MyBounceInterpolator(0.2,20);
        bounce.setInterpolator(interpolator);

        random = new Random();
        nombrealeatoire = random.nextInt(8 - 0 + 1)+ 0;
        //img2.setBackgroundResource(tab[nombrealeatoire]);

        //img.setAnimation(frombottom);
        img.setAnimation(bounce);


        //final SpringAnimation springAnim = new SpringAnimation(img, DynamicAnimation.TRANSLATION_Y);
        //springAnim.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY);
        //springAnim.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this,MenuActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },TIME_OUT);
    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(true);
        startActivity(new Intent(SplashActivity.this, MenuActivity.class));
        finish();
    }
}
