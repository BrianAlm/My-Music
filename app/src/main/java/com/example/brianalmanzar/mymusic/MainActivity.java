package com.example.brianalmanzar.mymusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(getResources().getString(R.string.love_you), getResources().getString(R.string.brian_alm),350));
        songs.add(new Song(getResources().getString(R.string.got_this), getResources().getString(R.string.ryan_alm),220));
        songs.add(new Song(getResources().getString(R.string.the_way_we_do_it),getResources().getString(R.string.jhombi),450));
        songs.add(new Song(getResources().getString(R.string.the_way_we_do_it), getResources().getString(R.string.jhombi) + ", " + getResources().getString(R.string.ryan_alm),125));
        songs.add(new Song(getResources().getString(R.string.more_of_it),getResources().getString(R.string.super_s),221));
        songs.add(new Song(getResources().getString(R.string.another_one),getResources().getString(R.string.jhonny_jack), 303));
        songs.add(new Song(getResources().getString(R.string.play_by_the_rules),getResources().getString(R.string.great_band),454));

        SongArrayAdapter songListAdapter = new SongArrayAdapter(this, songs);

        ListView referenceToListView = findViewById(R.id.list_view_root_id);

        referenceToListView.setAdapter(songListAdapter);

        // Onclick Listener Implementation For Selected Song On ListView
        referenceToListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Song songSelected = (Song) adapterView.getItemAtPosition(i);

                segueToNowPlayingActivityWith(songSelected);
            }
        });
    }

    private void segueToNowPlayingActivityWith(Song songToPass){
        Intent nowPlayingIntent = new Intent(this, NowPlayingActivity.class);
        nowPlayingIntent.putExtra(Song.SONGNAME, songToPass.getTheNameOfTheSong());
        nowPlayingIntent.putExtra(Song.SONGARTIST, songToPass.getArtistName());
        nowPlayingIntent.putExtra(Song.SONGLENGTH, songToPass.getSongDuration());

        startActivity(nowPlayingIntent);
    }
}
