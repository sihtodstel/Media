package com.alcmag.rjmk.media;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable panda_anim;
    private ImageView panda;
    private MediaPlayer mplayer;
    private Button skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        panda=findViewById(R.id.PandaID);

//        panda.setBackgroundResource(R.drawable.anim_media);
//        panda_anim=(AnimationDrawable) panda.getBackground();

        panda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     Intent nt=new Intent(MainActivity.this,media.class);
                     startActivity(nt);
            }
        });
     skip=(Button) findViewById(R.id.act3);
     skip.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent ntnt= new Intent(MainActivity.this,last.class);
                startActivity(ntnt);
         }
     });

    }



//    public boolean onTouchEvent(MotionEvent event) {
////        panda_anim.start();
//        Handler mhand = new Handler();
//        mhand.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
////                Animation startanim = AnimationUtils.loadAnimation(getApplicationContext(),
////                        R.anim.fadein_anim);
////                panda.startAnimation(startanim);
//
//            }
//        },500);
//        return super.onTouchEvent(event);
//    }
}
