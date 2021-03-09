package com.example.akanksha.media_179;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {
    Button playbt;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playbt=findViewById(R.id.playid);
        seekBar=findViewById(R.id.seekBarid);
        mediaPlayer=new MediaPlayer();
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.queen);
        seekBar.setMax(mediaPlayer.getDuration());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

        playbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    pausemedia();
                }else{
                    playmedia();
                }
            }
        });
    }
    private void pausemedia(){
        if(mediaPlayer!=null){
            mediaPlayer.pause();
            playbt.setText("Play");
        }
    }

    private void playmedia(){
        if(mediaPlayer!=null){
            mediaPlayer.start();
            playbt.setText("Pause");
        }
    }

}

