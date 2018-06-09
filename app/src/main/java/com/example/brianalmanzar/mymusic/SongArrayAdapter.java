package com.example.brianalmanzar.mymusic;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/*
    Extend the ArrayAdapter class to adopted to be used explicitly for displaying
    songs.
 */
public class SongArrayAdapter extends ArrayAdapter<Song> {

      public SongArrayAdapter(Activity context, ArrayList<Song> songList){
          super(context, 0, songList);
      }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View songView = convertView;

        if(songView == null){
            // R.layout.song_array_view_list is the layout we to display the songs information
            songView = LayoutInflater.from(getContext()).inflate(R.layout.song_array_list_view, parent, false);
        }

        // Get the song that was clicked
        Song currentSongToDisplay = getItem(position);

        TextView songNameView = songView.findViewById(R.id.song_name);
        TextView songArtistView = songView.findViewById(R.id.artist_name);
        TextView songDurationView = songView.findViewById(R.id.song_duration_view);

        songNameView.setText(currentSongToDisplay.getTheNameOfTheSong());
        songArtistView.setText("by : " + currentSongToDisplay.getArtistName());
        songDurationView.setText(currentSongToDisplay.getSongDuration());

        return songView;
    }
}
