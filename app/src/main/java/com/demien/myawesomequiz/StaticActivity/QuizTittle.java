package com.demien.myawesomequiz.StaticActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.preference.MultiSelectListPreference;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.demien.myawesomequiz.Music.MusicPlayerManager;
import com.demien.myawesomequiz.QuizActivity.QuizActivity;
import com.demien.myawesomequiz.R;

import static com.demien.myawesomequiz.PreferenceManager.Highscore.loadHighScore;
import static com.demien.myawesomequiz.PreferenceManager.Highscore.updateHighscore;


public class QuizTittle extends AppCompatActivity implements View.OnClickListener {

    //initialize constant for intent
    public static final int REQUEST_CODE_QUIZ = 1;

    //initialize textView elements
    public static TextView textViewHighscore;
    public static TextView welcomeTv;

    //initialize int variable
    public static int highscore;

    //initialize RelativeLayout variable to then assign it to an animation
    RelativeLayout rlLayout;

    //initialize Animation Drawable variable to then doing an animation with Relative Layout background
    AnimationDrawable animationDrawable;

    //initialize start activity buttons
    Button startQuiz, buttonSettings;

    public static Context tittleContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //assignment of the file of the layout of our activity
        setContentView(R.layout.quiztitle_layout);


        //find view by ID function
        textViewHighscore = findViewById(R.id.tvHighs);

        //call loadHighScore method to update our high score
        loadHighScore();

        //find view by ID function
        buttonSettings = findViewById(R.id.settingsButton);
        //assign onClick listener to button
        buttonSettings.setOnClickListener(this);


        //find view by ID function
        startQuiz = findViewById(R.id.startQuiz);
        //assign onClick listener to button
        startQuiz.setOnClickListener(this);


        //find view by ID function
        rlLayout = findViewById(R.id.rlLayout);
        //receiving and assigning a background from Relative Layout
        animationDrawable = (AnimationDrawable) rlLayout.getBackground();
        //assign duration to animationDrawable
        animationDrawable.setEnterFadeDuration(3500);
        animationDrawable.setEnterFadeDuration(3500);
        //start animation
        animationDrawable.start();

        //find view by ID function
        welcomeTv = findViewById(R.id.welcomeTv);
        //using YoYo library for animation
        YoYo.with(Techniques.Flash).duration(1500).repeat(9999999).playOn(welcomeTv);

        MusicPlayerManager.playMusic(R.raw.sound2);
    }


    @Override
    public void onClick(View v) {
        //use the switch function to find the desired component using ID
        switch (v.getId()) {
            case R.id.startQuiz:
                //use Intent to move to the next activity
                Intent intent1 = new Intent(this, QuizActivity.class);
                //use startActivityForResult function to get variable from Quiz Activity
                startActivityForResult(intent1, REQUEST_CODE_QUIZ);
                overridePendingTransition(R.anim.slide_in_top,R.anim.slide_out_bottom);
                break;
            case R.id.settingsButton:
                //use Intent to move to the next activity
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                //use animation from anim folder to do slide animation
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
        }
    }

    @Override
    //use onActivityResult method to get variables from QuizActivity class
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //use if to compere constant with highScore
        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    //use updateHighScore method
                    updateHighscore(score);
                }
            }
        }
    }


}
