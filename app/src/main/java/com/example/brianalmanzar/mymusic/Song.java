package com.example.brianalmanzar.mymusic;

import android.os.Parcel;
import android.os.Parcelable;

/*
    Represent an individual song that can be part of an album or as a single

 */
public class Song{
    public final static String SONGNAME= "com.example.brianalmanzar.mymusic.songName";
    public final static String SONGARTIST = "com.example.brianalmanzar.mymusic.songArtist";
    public final static String SONGLENGTH = "com.example.brianalmanzar.mymusic.songLength";

    private String name;
    private String artist;
    private int length;
    private String lengthAsString;

    /*
         @param sonName : The name of the song as its name refers to

         @param artistName : The name the person that sings the song. If there
                are multiples artists just use a comma ( , ) to separate them

         @param songLength : The many seconds is the son
     */
    public Song(String songName, String artistName, int songLengthInSeconds){
        this.name = songName;
        this.artist = artistName;
        this.length = songLengthInSeconds;
        this.lengthAsString = convertTheSongDurationIntoAnString(songLengthInSeconds);
    }


    /*  getter for the song name
        @return String : The name of the song
     */
    public String getTheNameOfTheSong(){
        return this.name;
    }


    /*
        getter for the artist of the song
        @return String : Son Artist
     */
    public String getArtistName(){
        return  this.artist;
    }

    /*
        @return String : The song duration on a regular format : ex. 2:20
     */
    public String getSongDuration(){
        return this.lengthAsString;
    }
    /*
        Convert the song duration from seconds into a regular format : ex. 2:20

        @param songLength : The length of the song in seconds

        @return String : The length of the song as String in the format given above
     */

    private String convertTheSongDurationIntoAnString(int songLength){
        String resultString = "";
        int minutes = songLength / 60;
        int seconds = songLength % 60;

        if(minutes < 0){
            minutes = 0;
        }

        resultString += String.valueOf(minutes);

        if(seconds < 10){
            resultString += ":0" + String.valueOf(seconds);
        }else{
            resultString += ":" + String.valueOf(seconds);
        }
        return resultString;
    }
}

