package com.demien.myawesomequiz.QuizActivity.CountDown;

import android.graphics.Color;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Locale;

import static com.demien.myawesomequiz.QuizActivity.QuizActivity.textColorDefaultCd;
import static com.demien.myawesomequiz.QuizActivity.QuizActivity.textViewCountDown;
import static com.demien.myawesomequiz.QuizActivity.QuizActivity.timeLeftInMillis;

public class CountDown {

    public static void updateCountdownText() {
        //initialize minutes and second for countDown
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        //initialize timeFormatted variable
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        // set minutes and second to textViewCountDown
        textViewCountDown.setText(timeFormatted);

        //change color if timeInMillis < 10 seconds
        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextColor(Color.RED);
            //use YoYo library for Flash animation
            YoYo.with(Techniques.Flash).duration(1000).repeat(100).playOn(textViewCountDown);
        } else {
            //set default color for countdown view
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }
}
