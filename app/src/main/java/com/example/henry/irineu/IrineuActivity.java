package com.example.henry.irineu;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class IrineuActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button irineuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irineu);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.irineu_song);
        irineuButton = (Button) findViewById(R.id.irineuBtn);

        irineuButton.setOnClickListener((event) -> {
            togglePlay();
        });

        mediaPlayer.setOnCompletionListener(player -> {irineuButton.setText("PLAY IRINEU");});

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();
        irineuButton.setText("PLAY IRINEU");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.irineu_song);
    }

    private void togglePlay(){
        if (!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            irineuButton.setText("PAUSE IRINEU");
        }else{
            mediaPlayer.pause();
            irineuButton.setText("PLAY IRINEU");
        }
    }

}
