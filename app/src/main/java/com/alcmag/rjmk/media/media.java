package com.alcmag.rjmk.media;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;


public class media extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button bpanda;
    private SeekBar sbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);



        mediaPlayer=new MediaPlayer();
        mediaPlayer= MediaPlayer.create(getApplicationContext(),R.raw.song_zara);
        bpanda = findViewById(R.id.pandabut);
        sbar=findViewById(R.id.seekBar);         
        sbar.setMax(mediaPlayer.getDuration());
        sbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

          mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
              @Override
              public void onCompletion(MediaPlayer mp) {
                  int duration = mp.getDuration();
                  String mduration = String.valueOf(duration);
                  Toast.makeText(getApplicationContext(),"duration" + mduration,Toast.LENGTH_LONG).show();
              }
          });
        bpanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    pausemusic();

                    } else {
                            startmusic();
                    }
                }

        });

    }
     public void pausemusic(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
            bpanda.setText("Play");
        }

     }
     public void startmusic(){
        if(mediaPlayer !=null)
        {
            mediaPlayer.start();
            bpanda.setText("pause");
        }
     }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
             mediaPlayer.release();
             mediaPlayer = null;
        }
        super.onDestroy();
    }
}
