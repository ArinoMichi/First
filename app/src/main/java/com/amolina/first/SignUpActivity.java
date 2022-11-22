package com.amolina.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SignUpActivity extends AppCompatActivity {
    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageView fondo = findViewById(R.id.fondo);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.rotate);
        fondo.startAnimation(myanim);

        Glide.with(this)
                .load("https://www.nationalgeographic.com.es/medio/2021/11/06/representacion-artistica-de-la-galaxia-ngp%E2%80%93190387_3ad791b6_2000x1200.jpg")
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(100))
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.grey)))
                .into(fondo);




        volver = findViewById(R.id.boton2);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpActivity.super.onBackPressed();
            }
        });
    }
}