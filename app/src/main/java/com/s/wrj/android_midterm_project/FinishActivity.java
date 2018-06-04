package com.s.wrj.android_midterm_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    private TextView finalScore;
    private TextView result;
    private Button retry;
    private Button home;
    private Button exit;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        finalScore = (TextView) findViewById(R.id.score);
        retry = (Button) findViewById(R.id.retry);
        home = (Button) findViewById(R.id.home);
        exit = (Button) findViewById(R.id.exit);
        result = (TextView) findViewById(R.id.result);

        Bundle bundle = getIntent().getExtras();
        int scores = bundle.getInt("score");
        finalScore.setText("" + String.valueOf(scores) +"/11" );
        result();



        retry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goRetry();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });


    }

    public void result(){
        Bundle bundle = getIntent().getExtras();
        int scores = bundle.getInt("score");


        if (scores >= 9){
            result.setText("You passed the Test");
        }else{
            result.setText("You failed the Test");
        }
    }
    public void goRetry(){
        Intent intent = new Intent(this,QuestionsActivity.class);
        startActivity(intent);
    }

    public void goHome(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }


}
