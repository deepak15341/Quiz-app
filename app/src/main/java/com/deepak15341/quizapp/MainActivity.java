package com.deepak15341.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

    private int mQuestionindex,mquizQuestion,result=0;
    final int USER_PROGRESS = (int) Math.ceil(100.0/questionsAll.length);
    private AppCompatButton buttonCorrect, buttonWrong;
    private TextView textViewQuestion,textViewQuizStats;
    private ProgressBar quizProgressBar;

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

        // textViewQuizStats.setText((mQuestionindex+1)+"/"+questionsAll.length);
        textViewQuizStats.setText(result+"/"+10);




        buttonCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateAnswer(true);
                questionChange();

            }
        });

        buttonWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateAnswer(false);
                questionChange();
            }
        });


    }

    private void questionChange(){

        quizProgressBar.incrementProgressBy(USER_PROGRESS);
        mQuestionindex = mQuestionindex + 1;
        if(mQuestionindex<questionsAll.length) {
            mquizQuestion = questionsAll[mQuestionindex].getmQuestion();
            textViewQuestion.setText(mquizQuestion);

            //textViewQuizStats.setText((mQuestionindex+1)+"/"+questionsAll.length);
        }
        else if(mQuestionindex>=questionsAll.length){
            AlertDialog.Builder quizAlert = new AlertDialog.Builder(this);
            quizAlert.setCancelable(false);
            quizAlert.setTitle("the Quiz has Finished");
            quizAlert.setMessage("your score is : "+result);
            quizAlert.setPositiveButton("Finish The Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            quizAlert.show();
        }

    }

    private void evaluateAnswer(boolean userGuess) {

        if (mQuestionindex < questionsAll.length) {
            boolean currentQuestionAnswer = questionsAll[mQuestionindex].ismAnswer();
            if (currentQuestionAnswer == userGuess) {
                Toast.makeText(getApplicationContext(), R.string.correct_toast_message, Toast.LENGTH_SHORT).show();
                result++;
                textViewQuizStats.setText(result+"/"+10);
            } else {
                Toast.makeText(getApplicationContext(), R.string.incorrect_toast_message, Toast.LENGTH_SHORT).show();
            }
        }
    }

}