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
        songs.add(new Song("Love You", "Brian Almanzar",350));
        songs.add(new Song("Got This!", "Ryan Almanzar",220));
        songs.add(new Song("The Way We Do It","Jhombi Jhombi",450));
        songs.add(new Song("Lets Bring It Down", "Jhombi Jhombi, Ryan Almanzar",125));
        songs.add(new Song("More Of It","Super Stars",221));
        songs.add(new Song("Another One","Jhonny Jack", 303));
        songs.add(new Song("Play By The Rules","Great Band",454));

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
