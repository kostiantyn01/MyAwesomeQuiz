package com.demien.myawesomequiz.Animation;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import static com.demien.myawesomequiz.StaticActivity.StartActivity.animationTextView;
//create class for animationOut
public class AnimationOut {

    //create method
    public static void animationOut(){
        //use YoYo library for textViews animation
        YoYo.with(Techniques.Hinge).duration(2000).playOn(animationTextView.get(0));
        YoYo.with(Techniques.Hinge).duration(2000).playOn(animationTextView.get(1));
        YoYo.with(Techniques.Hinge).duration(2000).playOn(animationTextView.get(2));
        YoYo.with(Techniques.Hinge).duration(2000).playOn(animationTextView.get(3));
        YoYo.with(Techniques.Hinge).duration(2000).playOn(animationTextView.get(4));

        YoYo.with(Techniques.Flash).duration(2500).repeat(9999999).playOn(animationTextView.get(5));
    }
}
