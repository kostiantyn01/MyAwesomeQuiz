package com.demien.myawesomequiz.Music;

import android.media.MediaPlayer;

import com.demien.myawesomequiz.MyApplication;

public class MusicPlayerManager {

    public static MediaPlayer player;

    public static void playMusic(int uri){
        player = MediaPlayer.create(MyApplication.getAppContext(),uri);
        player.start();
    }
}
