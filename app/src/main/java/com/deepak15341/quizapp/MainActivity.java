package com.deepak15341.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  QuizModel[] questionsAll =new QuizModel[]{
            new QuizModel(R.string.q1,true),
            new QuizModel(R.string.q2,true),
            new QuizModel(R.string.q3,false),
            new QuizModel(R.string.q4,true),
            new QuizModel(R.string.q5,true),
            new QuizModel(R.string.q6,true),
            new QuizModel(R.string.q7,false),
            new QuizModel(R.string.q8,true),
            new QuizModel(R.string.q9,true),
            new QuizModel(R.string.q10,true)
    };

    private int mQuestionindex,mquizQuestion;
    AppCompatButton buttonCorrect, buttonWrong;
    TextView textViewQuestion,textViewQuizStats;
    ProgressBar quizProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonCorrect = findViewById(R.id.correctButton);
        buttonWrong  =findViewById(R.id.wrongButton);
        textViewQuestion =findViewById(R.id.textquestion);
        textViewQuizStats = findViewById(R.id.textquizStats);
        quizProgressBar =findViewById(R.id.quizProgressBar);

        //get question for the first element
        textViewQuestion.setText(questionsAll[mquizQuestion].getmQuestion());
        textViewQuizStats.setText((mQuestionindex+1)+"");




       buttonCorrect.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               questionChange();
           }
       });

       buttonWrong.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               questionChange();
           }
       });


    }

    private void questionChange(){

            mQuestionindex = mQuestionindex + 1;
            if(mQuestionindex<questionsAll.length) {
                mquizQuestion = questionsAll[mQuestionindex].getmQuestion();
                textViewQuestion.setText(mquizQuestion);
                textViewQuizStats.setText((mQuestionindex+1)+"/"+questionsAll.length);


            }

    }

}