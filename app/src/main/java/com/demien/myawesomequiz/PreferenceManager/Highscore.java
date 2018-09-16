package com.demien.myawesomequiz.PreferenceManager;

import com.demien.myawesomequiz.MyApplication;
import com.demien.myawesomequiz.StaticActivity.QuizTittle;

import static com.demien.myawesomequiz.PreferenceManager.SharedPreferenceManager.getSomeIntValue;
import static com.demien.myawesomequiz.PreferenceManager.SharedPreferenceManager.setSomeIntValue;
import static com.demien.myawesomequiz.StaticActivity.QuizTittle.highscore;
import static com.demien.myawesomequiz.StaticActivity.QuizTittle.textViewHighscore;

public class Highscore {


    public static void updateHighscore(int highScoreNew) {
        highscore = highScoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        setSomeIntValue(MyApplication.getAppContext(), highscore);
    }

    public static void loadHighScore() {
        highscore = getSomeIntValue(MyApplication.getAppContext());
        textViewHighscore.setText("Highscore: " + highscore);
    }
}

