package com.amolina.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splashu extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashu);

        int tiempoTranscurrir = 2000; //1 segundo, 1000 millisegundos.
        ImageView foto= findViewById(R.id.logo);

        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.blink);
        foto.startAnimation(myanim);





        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //***Aquí agregamos el proceso a ejecutar.

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);



                handler.removeCallbacks(null);
            }
        }, tiempoTranscurrir );//define el tiempo.

    }

}