package com.demien.myawesomequiz.StaticActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.demien.myawesomequiz.Animation.AnimationWithPause;
import com.demien.myawesomequiz.R;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity implements View.OnTouchListener {
    //initialize variables for the screen elements(Text View)
    public static TextView tvWelcome, tvTo, tvMy, tvAw, tvQuiz, tvPress;

    //initialize ArrayList for textViews names
    public static ArrayList<String> stringForHandler = new ArrayList<>();
    //initialize ArrayList for the screen elements(Text View)
    public static ArrayList<TextView> animationTextView = new ArrayList<>();

    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assignment of the file of the layout of our activity
        setContentView(R.layout.activity_start);

        //use findViewById for connect textViews
        tvWelcome = findViewById(R.id.tvWelcome);
        tvTo = findViewById(R.id.tvTo);
        tvMy = findViewById(R.id.tvMy);
        tvAw = findViewById(R.id.tvAw);
        tvQuiz = findViewById(R.id.tvQuiz);
        tvPress = findViewById(R.id.tvPress);
        //assign touch listener to button
        tvPress.setOnTouchListener(this);

        //add views to ArrayList
        animationTextView.add(tvWelcome);
        animationTextView.add(tvTo);
        animationTextView.add(tvMy);
        animationTextView.add(tvAw);
        animationTextView.add(tvQuiz);
        animationTextView.add(tvPress);

        //add text to ArrayList
        stringForHandler.add("Welcome");
        stringForHandler.add("To");
        stringForHandler.add("My");
        stringForHandler.add("Awesome");
        stringForHandler.add("Quiz");
        stringForHandler.add("Press on Me");

        //call animation method
        AnimationWithPause.animationForTextViews();
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    //use on touch
    public boolean onTouch(View v, MotionEvent event) {
        //use the switch function to find the desired component using ID
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //use Intent to move to the next activity
                Intent intent = new Intent(this, QuizTittle.class);
                startActivity(intent);
        }
        return true;
    }


}
