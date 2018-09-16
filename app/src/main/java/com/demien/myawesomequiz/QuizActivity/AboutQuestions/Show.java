package com.demien.myawesomequiz.QuizActivity.AboutQuestions;

import android.graphics.Color;

import static com.demien.myawesomequiz.QuizActivity.QuizActivity.buttonConfirmNext;
import static com.demien.myawesomequiz.QuizActivity.QuizActivity.currentquestion;
import static com.demien.myawesomequiz.QuizActivity.QuizActivity.questionCountTotal;
import static com.demien.myawesomequiz.QuizActivity.QuizActivity.questionCounter;
import static com.demien.myawesomequiz.QuizActivity.QuizActivity.rb1;
import static com.demien.myawesomequiz.QuizActivity.QuizActivity.rb2;
import static com.demien.myawesomequiz.QuizActivity.QuizActivity.rb3;
import static com.demien.myawesomequiz.QuizActivity.QuizActivity.textViewQuestion;

public class Show {

    public static void showSolution() {
        //change radio buttons text color to RED
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);


        //use switch to find witch answer correct
        switch (currentquestion.getAnswerNr()) {
            case 1:
                //change radioButtons color to Green
                rb1.setTextColor(Color.GREEN);
                //set text to TextView
                textViewQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                //change radioButtons color to Green
                rb2.setTextColor(Color.GREEN);
                //set text to TextView
                textViewQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                //change radioButtons color to Green
                rb3.setTextColor(Color.GREEN);
                //set text to TextView
                textViewQuestion.setText("Answer 3 is correct");
                break;

        }
        //use if to identify
        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");
        } else {
            buttonConfirmNext.setText("Finish");
        }
    }
}
