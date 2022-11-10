package com.example.fundamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class LoginActivity extends AppCompatActivity {
    TextView nuevoUsu;
    ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView mGirl = findViewById(R.id.girl);
        foto=findViewById(R.id.icon);

        Glide.with(this)
          .load("https://as.com/meristation/imagenes/2017/04/22/album/1492840800_840800_000008_album_normal.png")
          //      .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(10))
                .centerCrop()
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.fucsia_200)))
//                .circleCrop()
                .into(mGirl);

        Glide.with(this)
                .load("https://64.media.tumblr.com/bb3dd0247c033d989c151cf5ee9335e7/925a1e04be1a9618-c8/s540x810/f7dc1016002f90004d1fbde3e06e29b8a9f9dc36.jpg")
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade(100))
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.grey)))
                .into(foto);



        nuevoUsu=findViewById(R.id.nuevo);
        nuevoUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });

    }

    public void SignUp(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        //quitar la navegacion
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    }
}