package com.example.shruti.kaunbanegacrorepati;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity implements View.OnClickListener {

    int random;
    TextView quest,opt1,opt2,opt3,opt4,scor;

    int score=0;
    String ques[]={"What is the name of the first Indian Prime Minister?",
            "Which of these place is a major producer of apples?",
            "Who was the lead actor in the movie Sultan?",
            "Who scored highest score[401] in a test match?",
            "In India, under which Union Ministry does the ‘Rajbhasha Vibhag’ function?",
            "According to a proverb, what is said to be ‘the mother of invention’ ?",
            "The power to decide an election petition is vested in the",
            "The Indian to beat the computers in mathematical wizardry is",
            "Who wrote the famous book - 'We the people'?",
            "Who is the famous Sarod player?",
            "Sanjay Dutt, a noted film actor was held under",
            "After the battle of Kurukshetra who gave Yudhisthira lessons on Raj Dharma?",
            "Which of these countries has Narendra Modi not visited as prime minister of India?",
            "The name of which of these cities means a fort?",
            "In which county is the historic city of Bukhara?"
        };
    boolean flag[]={false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    String options[][]={
            {"Lalbahadur Shastri","Rajiv Gandhi","Moraji Desai","Jawarharlal Nehru"},
            {"Leh","Ooty","Manali","Kodaikanal"},
            {"Salman Khan","Dinu Moriya","Shahrukh khan","Farhan Akhtar"},
            {"Yusuf Pathan","Brian Lara","Virender Sehwag","Robin Peterson"},
            {"Home Affairs","HRD","Culture","Law & Justice"},
            {"Society","Problem" ,"Science" ,"Necessity"},
            {"Parliament", "Supreme Court","High courts","Election Commission"},
            {"Ramanujam" ,"Rina Panigrahi","Raja Ramanna", "Shakunthala Devi"},
            {"T.N.Kaul","J.R.D. Tata","Khushwant Singh","Nani Palkhivala"},
            {"Hari Prasad","Zakir Hussain","Ram Narain","Amjad Ali Khan"},
            {"TADA","Narcotic Act","Act 302","Anti-Defence Act"},
            {"Krishna", "Bhishma", "Vidur", "Ved Vyas"},
            {"Brazil","Bhutan","Japan", "Bangladesh"},
            {"Ambikapur","Dantewada","Jagdalpur","Durg"},
            {"Uzbekistan","Afghanistan","Turkmenistan","Kazakhstan"}
        };

    String answers[]={"Jawarharlal Nehru","Manali","Salman Khan","Brian Lara","Home Affairs"
            ,"Necessity","High courts","Shakunthala Devi","Nani Palkhivala","Amjad Ali Khan","TADA","Bhishma","Bangladesh",
            "Durg","Uzbekistan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        scor=(TextView)findViewById(R.id.score);
        quest= (TextView)findViewById(R.id.ques);
        opt1=(TextView)findViewById(R.id.opt1);
        opt2=(TextView)findViewById(R.id.opt2);
        opt3=(TextView)findViewById(R.id.opt3);
        opt4=(TextView)findViewById(R.id.opt4);

        setQuestion();

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);

    }

    private void setQuestion() {
        int ch = 0;

        if(score==10)
        {
            Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Score.class);
            i.putExtra("score",(score)+"");
            startActivity(i);
        }
        else
        {
        for (int i = 0; i < ques.length; i++)
            if (!flag[i])
                ch = 1;

        if (ch == 1) {

            random = (int) (Math.random() * 15);
            while (flag[random])
                random = (int) (Math.random() * 15);
            flag[random] = true;

            quest.setText(ques[random]);

            opt1.setText(options[random][0]);
            opt2.setText(options[random][1]);
            opt3.setText(options[random][2]);
            opt4.setText(options[random][3]);
        } else {

            Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Score.class);
            i.putExtra("score",score+"");
            startActivity(i);
        }
    }}

    @Override
    public void onClick(View v) {

        boolean flag=true;

       // opt1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
       // opt2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        //opt3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        //opt4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        switch (v.getId())
        {
            case R.id.opt1:
                if(answers[random].equals(opt1.getText().toString())) {
                    opt1.setBackgroundColor(Color.GREEN);
                    new Thread(){
                        @Override
                        public void run() {

                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                    score++;
                    opt1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    setQuestion();
                }
                else
                {
                    flag=false;
                    opt1.setBackgroundColor(Color.RED);
                    Toast.makeText(this,"Wrong answer",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.opt2:
                if(answers[random].equals(opt2.getText().toString())) {
                    opt2.setBackgroundColor(Color.GREEN);
                    new Thread(){
                        @Override
                        public void run() {

                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                    score++;
                    opt2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    setQuestion();
                }
                else
                {
                    flag=false;
                    opt2.setBackgroundColor(Color.RED);
                    Toast.makeText(this,"Wrong answer",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.opt3:
                if(answers[random].equals(opt3.getText().toString())) {
                    opt3.setBackgroundColor(Color.GREEN);
                    new Thread(){
                        @Override
                        public void run() {

                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                        }
                    }.start();
                    opt3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    score++;
                    setQuestion();
                }
                else
                {
                    flag=false;
                    opt3.setBackgroundColor(Color.RED);
                    Toast.makeText(this,"Wrong answer",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.opt4:
                if(answers[random].equals(opt4.getText().toString())) {
                    opt4.setBackgroundColor(Color.GREEN);
                    new Thread(){
                        @Override
                        public void run() {

                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                        }
                    }.start();
                    score++;
                    opt4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    setQuestion();
                }
                else
                {
                    flag=false;
                    opt4.setBackgroundColor(Color.RED);
                    Toast.makeText(this,"Wrong answer",Toast.LENGTH_SHORT).show();
                }
                break;
        }

        if(!flag) {
            Intent i = new Intent(this, Score.class);
            i.putExtra("score",score+"");
            startActivity(i);
        }

        scor.setText(score+"");

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
