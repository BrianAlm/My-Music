package com.example.brianalmanzar.mymusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {


    private TextView songCurrentlyPlaying;
    private TextView artistOfTheSongCurrentlyPlaying;
    private TextView songEndTime;
    private ImageView playAndPauseButton;
    private Boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);


        artistOfTheSongCurrentlyPlaying = findViewById(R.id.now_playing_artist);
        songCurrentlyPlaying = findViewById(R.id.now_playing_song_name);
        songEndTime = findViewById(R.id.end_time);

        Intent songIntent = getIntent();

        String currentlyPlayingSongName = songIntent.getStringExtra(Song.SONGNAME);
        String currentlyPlayingSongArtist = songIntent.getStringExtra(Song.SONGARTIST);
        String currentlyPlayingSongEndTime = songIntent.getStringExtra(Song.SONGLENGTH);

        songCurrentlyPlaying.setText(currentlyPlayingSongName);
        artistOfTheSongCurrentlyPlaying.setText("By : " + currentlyPlayingSongArtist);
        songEndTime.setText(currentlyPlayingSongEndTime);

        // Hook up the playAndPauseButton
        playAndPauseButton = findViewById(R.id.now_playing_play_pause_button);

        playAndPauseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    playAndPauseButton.setImageResource(R.drawable.play_button);
                    isPlaying = false;
                    Toast.makeText(getApplicationContext(), "Paused", Toast.LENGTH_SHORT).show();
                } else {
                    playAndPauseButton.setImageResource(R.drawable.pause_button);
                    isPlaying = true;
                    Toast.makeText(getApplicationContext(), "Paying", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
