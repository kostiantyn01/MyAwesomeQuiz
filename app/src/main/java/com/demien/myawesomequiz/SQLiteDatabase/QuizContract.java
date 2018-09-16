package com.demien.myawesomequiz.SQLiteDatabase;

import android.provider.BaseColumns;

//use this class for different constant for SQLite operations
public final class QuizContract {

    //object in this class
    private QuizContract() {
    }
//inner class for different tablets in the database
                                        //implement base columns interface with 2 constants but we use only one(_ID a simple number with
// an automatic increment to our table with each new entry in the quiz table)
    public static class QuestionTable implements BaseColumns {
        //static variables for different functions in database
        public static final String TABLE_NAME = "quiz_question";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
    }
}
