package com.example.cheersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoPlayer;
        videoPlayer = (VideoView) findViewById(R.id.videoPlayer_id);
        Uri myVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hbvideo);
        videoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);

        Button stop = (Button) findViewById(R.id.stopBtn);
        Button play = (Button) findViewById(R.id.playBtn);
        Button pause = (Button) findViewById(R.id.pauseBtn);
        Button coontinue = (Button) findViewById(R.id.continueBtn);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoPlayer.stopPlayback();
                videoPlayer.resume();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoPlayer.pause();
            }
        });

        coontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoActivity.this, ConclusionActivity.class);
                startActivity(intent);
            }
        });
    }
}