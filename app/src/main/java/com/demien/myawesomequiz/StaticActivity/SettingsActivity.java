package com.demien.myawesomequiz.StaticActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.demien.myawesomequiz.Music.MusicPlayerManager;
import com.demien.myawesomequiz.R;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    //initialize back button
    Button back;
    //initialize switch for music
    Switch switchMusic;
    //initialize toolBar
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assignment of the file of the layout of our activity
        setContentView(R.layout.activity_settings);
        //find view by ID function
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //find view by ID function
        back = findViewById(R.id.back);
        //assign onClick listener to button
        back.setOnClickListener(this);

        //find view by ID function
        switchMusic = findViewById(R.id.switchMusic);

        if(MusicPlayerManager.player.isPlaying()){
            switchMusic.setChecked(true);
        }else{
            switchMusic.setChecked(false);
        }
    }

    @Override
    public void onClick(View v) {
        //use the switch function to find the desired component using ID
        switch (v.getId()) {
            case R.id.back:
                //use if to do stop or start function
                if (switchMusic.isChecked()) {
                    MusicPlayerManager.player.start();
                    switchMusic.setChecked(true);
                    finish();
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                } else {
                    MusicPlayerManager.player.pause();
                    switchMusic.setChecked(false);
                    finish();
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //use if to do stop or start function
        if (switchMusic.isChecked()) {
            MusicPlayerManager.player.start();
            switchMusic.setChecked(true);
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        } else {
            MusicPlayerManager.player.pause();
            switchMusic.setChecked(false);
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }
}
