package com.demien.myawesomequiz.Animation;

import android.os.Handler;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import static com.demien.myawesomequiz.StaticActivity.StartActivity.animationTextView;
import static com.demien.myawesomequiz.StaticActivity.StartActivity.stringForHandler;


public class AnimationWithPause {

    //initialize handler variable for pause
    static Handler handler = new Handler();

    //create static/start animation method
    private static void staticAnimation(final TextView textView, final String stringforText) {
        YoYo.with(Techniques.FlipInX).duration(2500).playOn(textView);
        textView.setText(stringforText);
    }
    //create delay for handler method where we use handler for 1 second delay and after that
    // we call static animation and forHandlerMethod for next delay
    private static void delayForHandlerFirst(final TextView textView, final String stringforText) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                staticAnimation(textView, stringforText);
                forHandler(animationTextView.get(2), stringForHandler.get(2));

            }
            //set 1 second delay
        }, 1000);
    }
    //create same method with delayForHandlerFirst but with another variables
    private static void forHandler(final TextView textView, final String stringforText) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                staticAnimation(textView, stringforText);
                forHandlerSecond(animationTextView.get(3), stringForHandler.get(3));
            }
            //set 1 second delay
        }, 1000);
    }
    //create same method with delayForHandlerFirst but with another variables
    private static void forHandlerSecond(final TextView textView, final String stringforText) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                staticAnimation(textView, stringforText);
                forHandlerThird(animationTextView.get(4), stringForHandler.get(4));
            }
            //set 1 second delay
        }, 1000);
    }

    //create same method with delayForHandlerFirst but with another variables
    private static void forHandlerThird(final TextView textView, final String stringforText) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                staticAnimation(textView, stringforText);
            }
            //set 1 second delay
        }, 1000);
    }




//create final method where we connect all method that we create in this class
    public static void animationForTextViews() {
        //call static animation for animation
        staticAnimation(animationTextView.get(0), stringForHandler.get(0));
        delayForHandlerFirst(animationTextView.get(1), stringForHandler.get(1));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //assignment text to last textView
                animationTextView.get(5).setText(stringForHandler.get(5));
                //call method animationTextView for hide textViews
                AnimationOut.animationOut();
            }
            //set 5 second delay
        }, 5000);
    }
}


