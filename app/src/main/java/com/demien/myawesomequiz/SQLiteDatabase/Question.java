package com.demien.myawesomequiz.SQLiteDatabase;

/* this class work as bridge between SQLite database and the app
* in this class contain information for single question, different answer options */
public class Question {

    //this is question variable
    private String question;
    //string with option1 correct
    private String option1;
    //string with option2 correct
    private String option2;
    //string with option3 correct
    private String option3;
    //int variable with correct answer number
    private int answerNr;


//make empty constructor
    public Question() {}


    //generate constructor to create object in this question class
    public Question(String question, String option1, String option2, String option3, int answerNr) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
    }


    //create setter method to use this values to question object
    //create getter methods to get this values out of this object
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }



    }


