package com.demien.myawesomequiz.QuizActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.demien.myawesomequiz.QuizActivity.AboutQuestions.Show;
import com.demien.myawesomequiz.QuizActivity.CountDown.CountDown;
import com.demien.myawesomequiz.R;
import com.demien.myawesomequiz.SQLiteDatabase.Question;
import com.demien.myawesomequiz.SQLiteDatabase.QuizDbHelper;

import java.util.Collections;
import java.util.List;

import static com.demien.myawesomequiz.QuizActivity.CountDown.CountDown.updateCountdownText;

public class QuizActivity extends AppCompatActivity {
    //extra variable for high score. Use it to put high score to starting Activity
    public static final String EXTRA_SCORE = "extraScore";
    //general variable for countdown timer
    public static final long COUNTDOWN_IN_MILLIS = 30000;

    //initialize textView elements
    public static TextView textViewQuestion;
    public static TextView textViewScore;
    public static TextView textViewQuestionCount;
    public static TextView textViewCountDown;

    //initialize radioGroup elements
    public static RadioGroup rbGroup;

    //initialize RadioButton elements
    public static RadioButton rb1;
    public static RadioButton rb2;
    public static RadioButton rb3;

    //initialize button
    public static Button buttonConfirmNext;

    //initialize ColorStateList for radio buttons
    public static ColorStateList textColorDefaultRb;

    //initialize colorStateList for countdown timer to change a color
    public static ColorStateList textColorDefaultCd;

    //initialize CountDownTimer
    public static CountDownTimer countDownTimer;
    public static long timeLeftInMillis;

    //initialize List of question objects and give to it same name as in QuizDvHelper class
    public static List<Question> questionList;
    //initialize question counter (how many question we showed)
    public static int questionCounter;
    //initialize questionCountTotal (total question that we have in our array list)
    public static int questionCountTotal;
    //initialize Question variable
    public static Question currentquestion;

    //initialize score variable
    public static int score;
    //initialize boolean variable and called it answered
    public static boolean answered;

    //create back pressed time variable for initialize  seconds
    public static long backPressedTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //assignment of the file of the layout of our activity
        setContentView(R.layout.activity_quiz);

        //find view by ID function
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        //called default color for radio button
        textColorDefaultRb = rb1.getTextColors();
        //get color from textViewCountDown
        textColorDefaultCd = textViewCountDown.getTextColors();

        //initialize DbHelper
        QuizDbHelper dbHelper = new QuizDbHelper(this);
        //assignment method that we create and create database
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();

        //assignment onClick listener to buttonConfirmNext
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use if to find correct answer or not find and showNextQuestion
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        //called checkAnswer method
                        sheckanswer();
                    } else {
                        //make toast message if don't select an answer
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //called showNextQuestion method
                    showNextQuestion();
                }
            }
        });
    }

    //create showNextQuestion method
    private void showNextQuestion() {
        //reset text Color of radio buttons
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        //clear
        rbGroup.clearCheck();

        //use if to show next question or finish quizApp
        if (questionCounter < questionCountTotal) {
            //get the next question from question list
            currentquestion = questionList.get(questionCounter);

            //getter method for question witch save in our question object
            textViewQuestion.setText(currentquestion.getQuestion());
            //show option
            rb1.setText(currentquestion.getOption1());
            rb2.setText(currentquestion.getOption2());
            rb3.setText(currentquestion.getOption3());

            //increment questionCounter
            questionCounter++;
            //set Text to textViewQuestionCount
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            //assign to answered false
            answered = false;
            //setText to buttonConfirmNext
            buttonConfirmNext.setText("Confirm");

            //starting countdown timer
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            //called separate method
            finishQuiz();
            overridePendingTransition(R.anim.slide_in_bottom,R.anim.slide_out_top);
        }
    }

    //create startCountDownMethod
    private void startCountDown() {
        //create countDown variable
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //save timeLeftInMillis in member variable
                timeLeftInMillis = millisUntilFinished;
                //called updateCountDownText method
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountdownText();
                sheckanswer();
            }
            //start countDown timer
        }.start();
    }

    //create checkAnswer method
    private void sheckanswer() {
        //set answered tru because uor question have answered
        answered = true;

        // cancel count down if answer == true
        countDownTimer.cancel();

        //selected radiobutton and instead "R.id."" " we use rbGroup and getCheckedRadioButtonId method
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        //initialize answerNr
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentquestion.getAnswerNr()) {
            //increase score
            score++;
            //change textViewScore
            textViewScore.setText("Score: " + score);
        }

        //called showSolution method
        Show.showSolution();
    }


    private void finishQuiz() {
        // create intent variable
        Intent resultIntent = new Intent();
        //put to resultIntent variable high score
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        //close activity that called finish method
        overridePendingTransition(R.anim.slide_in_bottom,R.anim.slide_out_top);
        finish();
    }

    @Override
    //create backPressed method to quit in our quiz
    public void onBackPressed() {
        //the first time when we click on backPressed button we have a toast message and  2 seconds delay in milliseconds
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            //after that call finishQuiz method
            finishQuiz();
            overridePendingTransition(R.anim.slide_in_bottom,R.anim.slide_out_top);
        } else {
            //show toast message
            Toast.makeText(this, "Please press back again to finish", Toast.LENGTH_SHORT).show();
        }

        //initialize backPressedTime
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            //cancel countDown timer
            countDownTimer.cancel();
        }
    }
}
