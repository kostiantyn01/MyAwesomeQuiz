package com.demien.myawesomequiz.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.demien.myawesomequiz.SQLiteDatabase.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

//class with SQLite database
public class QuizDbHelper extends SQLiteOpenHelper {
    //create constant with database name
    private static final String DATABASE_NAME = "QuizApp.db";
    //create constant with database version
    private static final int DATABASE_VERSION = 1;

    //SQLite database variable called "db" that use it to add same values
    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    //in on create method we create our database
    public void onCreate(SQLiteDatabase db) {

        //save db reference to our db variable and use it to add some values after created database
        this.db = db;

        //create database
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        //add to db the database that we create above using execSQL
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        //create method with variables that we put to it
        fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop table if exist
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        //create db
        onCreate(db);
    }

    //method where we explain our static variables and add values to it
    private void fillQuestionTable() {
        Question q1 = new Question("Your question. Answer - 1", "1", "2", "3", 1);
        addQuestion(q1);
        Question q2 = new Question("Your question. Answer - 3", "1", "2", "3", 3);
        addQuestion(q2);
        Question q3 = new Question("Your question. Answer - 3", "1", "2", "3", 3);
        addQuestion(q3);
        Question q4 = new Question("Your question. Answer - 2", "1", "2", "3", 2);
        addQuestion(q4);

        Question q11 = new Question("Your question. Answer - 1", "1", "2", "3", 1);
        addQuestion(q11);
        Question q21 = new Question("Your question. Answer - 1", "1", "2", "3", 1);
        addQuestion(q21);
        Question q31 = new Question("Your question. Answer - 1", "1", "2", "3", 1);
        addQuestion(q31);
        Question q41 = new Question("Your question. Answer - 2", "1", "2", "3", 2);
        addQuestion(q41);
        Question q12 = new Question("Your question. Answer - 3", "1", "2", "3", 3);
        addQuestion(q12);
        Question q22 = new Question("Your question. Answer - 2", "1", "2", "3", 2);
        addQuestion(q22);
        Question q32 = new Question("Your question. Answer - 1", "1", "2", "3", 1);
        addQuestion(q32);
        Question q42 = new Question("Your question. Answer - 1", "1", "2", "3", 1);
        addQuestion(q42);


    }


    //method where we insert uor questions to our database
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        //inserting variables to database
        db.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    //method where we retrieve our questions
    public List<Question> getAllQuestions() {
        //create array list
        List<Question> questionList = new ArrayList<>();
        //getReadableDatabase called when we created our database
        db = getReadableDatabase();
        //create a cursor
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);

        //there we move uor cursor to the first entry
        if (c.moveToFirst()) {
            //if that is exist move it to first and create
            do {
                Question question = new Question();
                //that is setter method that we created to set a questions string in our question object
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));

                //add all of question objects that we create above and add all of this to the questionList
                questionList.add(question);

                //if exist moveToNext
            } while (c.moveToNext());
        }

        //close
        c.close();
        return questionList;
    }




}
