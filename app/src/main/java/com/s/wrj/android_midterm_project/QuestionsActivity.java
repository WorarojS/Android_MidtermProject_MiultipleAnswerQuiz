package com.s.wrj.android_midterm_project;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class QuestionsActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private static final long COUNTDOWN_IN_MILLIS = 15000;

    private TextView mScoreView;
    private TextView mQuestionView;
    private TextView qCount;
    private RadioGroup radioGroup;
    private RadioButton mButtonChoise1;
    private RadioButton mButtonChoise2;
    private RadioButton mButtonChoise3;
    private RadioButton mButtonChoise4;
    private ImageView mQuestionPic;
    private TextView countdown;
    private Button confirm;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;


    private String mAnswer;
    private boolean answered;
    private int mScore = 0;
    private int mCount = 1;
    private int mQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        qCount = (TextView)findViewById(R.id.qCount);
        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        mButtonChoise1 = (RadioButton)findViewById(R.id.answer1);
        mButtonChoise2 = (RadioButton)findViewById(R.id.answer2);
        mButtonChoise3 = (RadioButton)findViewById(R.id.answer3);
        mButtonChoise4 = (RadioButton)findViewById(R.id.answer4);
        mQuestionPic = (ImageView)findViewById(R.id.imageView);
        confirm = (Button)findViewById(R.id.confirmButt);
        countdown = (TextView)findViewById(R.id.countDown);

        textColorDefaultRb = mButtonChoise1.getTextColors();
        textColorDefaultCd = countdown.getTextColors();


        updateQuestion();

        mButtonChoise1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                answered = true;
                if (mButtonChoise1.getText() == mAnswer){
                    mScore++;
                }else{
                }
            }
        });

        mButtonChoise2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                answered = true;
                if (mButtonChoise2.getText() == mAnswer){
                    mScore++;
                }else{
                }
            }
        });

        mButtonChoise3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                answered = true;
                if (mButtonChoise3.getText() == mAnswer){
                    mScore++;
                }else{
                }
            }
        });

        mButtonChoise4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                answered = true;
                if (mButtonChoise4.getText() == mAnswer){
                    mScore++;
                }else{
                }
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    Toast.makeText(QuestionsActivity.this, "Choose one", Toast.LENGTH_SHORT).show();
                }else{
                    if (mCount < 11) {
                        countDownTimer.cancel();
                        updateScore(mScore);
                        mCount++;
                        questionCount(mCount);
                        updateQuestion();
                    }else {
                        finished();
                    }
                }

            }
        });



    }
    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mQuestionPic.setImageResource(mQuestionLibrary.getmQuestionPic(mQuestionNumber));
        mButtonChoise1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoise2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoise3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mButtonChoise4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mButtonChoise1.setChecked(false);
        mButtonChoise2.setChecked(false);
        mButtonChoise3.setChecked(false);
        mButtonChoise4.setChecked(false);
        mQuestionNumber++;
        answered = false;
        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        startCountDown();

    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                updateQuestion();

            }
        }.start();
    }

    private void updateCountDownText(){
        int miniutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d",miniutes,seconds);

        countdown.setText(timeFormatted);

        if (timeLeftInMillis < 1000) {
            countdown.setTextColor(Color.RED);
        }else {
            countdown.setTextColor(textColorDefaultCd);
        }
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
    private void questionCount(int count){
        qCount.setText(mCount + "/11");
    }




    private void finished(){
        confirm.setText("Finish");
        goFinished();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
    }

    private void goFinished(){
        Intent intent = new Intent(this,FinishActivity.class);
        intent.putExtra("score",mScore);
        startActivity(intent);
    }
}
