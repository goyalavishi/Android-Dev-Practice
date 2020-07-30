package com.example.hrc.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button keypad[];
    TextView txt;
    boolean flag,finfinity,resFlag;
    int operand1,operand2,operators,number,ctr;
    /*
    1-add 2-subtract 3-multiply 4-divide
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        flag=finfinity=resFlag=false;
        operand1=operand2=operators=ctr=0;
        keypad=new Button[17];
        txt=(TextView)findViewById(R.id.Text);
        keypad[0]=(Button)findViewById(R.id.zero);
        keypad[1]=(Button)findViewById(R.id.one);
        keypad[2]=(Button)findViewById(R.id.two);
        keypad[3]=(Button)findViewById(R.id.three);
        keypad[4]=(Button)findViewById(R.id.four);
        keypad[5]=(Button)findViewById(R.id.five);
        keypad[6]=(Button)findViewById(R.id.six);
        keypad[7]=(Button)findViewById(R.id.seven);
        keypad[8]=(Button)findViewById(R.id.eight);
        keypad[9]=(Button)findViewById(R.id.nine);
        keypad[10]=(Button)findViewById(R.id.add);
        keypad[11]=(Button)findViewById(R.id.sub);
        keypad[12]=(Button)findViewById(R.id.divide);
        keypad[13]=(Button)findViewById(R.id.mul);
        keypad[14]=(Button)findViewById(R.id.equal);
        keypad[15]=(Button)findViewById(R.id.decimal);
        keypad[16]=(Button)findViewById(R.id.clear);

        for(int i=0;i<10;i++)
            keypad[i].setOnClickListener(this);
        keypad[16].setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void operator(View view)
    {
        flag=true;
        if(operators!=0&& ctr!=0) {
            operand1 = res();
            operand2=0;
            txt.setText("" + operand1);
        }
        else

            operand1=number;
        number=0;


        resFlag=false;
        //Toast.makeText(this,""+operand1+" "+operand2,Toast.LENGTH_SHORT).show();
        switch (view.getId())
        {
            case R.id.add:
                operators=1;
                ctr++;
                break;
            case R.id.sub:
                operators=2;
                ctr++;
                break;
            case R.id.divide:
                operators=4;
                ctr++;
                break;
            case R.id.mul:
                operators=3;
                ctr++;
                break;
        }




    }

    public void equal(View view)
    {
        operand1=res();
        resFlag=true;
        if(finfinity!=true)
        txt.setText(""+operand1);
        operand2=0;
        operators=0;
    }

    private int res() {
        if(operators==1)
            return operand1+operand2;
        else
        if(operators==2)
            return operand1-operand2;
        else
        if(operators==3)
            return operand2*operand1;
        else
        if(operators==4) {
            {
                if(operand2==0)
                {
                    txt.setText("Infinity");
                    finfinity=true;
                    return 0;
                }

                return operand1 / operand2;
            }
        }
        return 0;
    }

    @Override
    public void onClick(View view) {

        if(number!=0 && finfinity==false)
        number=Integer.parseInt(txt.getText().toString());
        else
        if(finfinity)
            txt.setText("Infinity");


        if(finfinity!=true)
        switch(view.getId())
        {
            case R.id.zero:
                if(resFlag==false)
                number= number*10+0;
                txt.setText(""+number);
                break;
            case R.id.one:
                if(resFlag==false)
                number= number*10+1;
                txt.setText(""+number);
                break;
            case R.id.two:
                if(resFlag==false)
                number= number*10+2;
                txt.setText(""+number);
                break;
            case R.id.three:
                if(resFlag==false)
                number= number*10+3;
                txt.setText(""+number);
                break;
            case R.id.four:
                if(resFlag==false)
                number= number*10+4;
                txt.setText(""+number);
                break;
            case R.id.five:
                if(resFlag==false)
                number= number*10+5;
                txt.setText(""+number);
                break;
            case R.id.six:
                if(resFlag==false)
                number= number*10+6;
                txt.setText(""+number);
                break;
            case R.id.seven:
                if(resFlag==false)
                number= number*10+7;
                txt.setText(""+number);
                break;
            case R.id.eight:
                if(resFlag==false)
                number= number*10+8;
                txt.setText(""+number);
                break;
            case R.id.nine:
                if(resFlag==false)
                number= number*10+9;
                txt.setText(""+number);
                break;
            case R.id.clear:
                resFlag=false;
                number= 0;
                finfinity=false;
                operand1=operand2=0;
                txt.setText(""+number);
                break;

        }
        if(view.getId()==R.id.clear)
        {
            number= 0;
            finfinity=false;
            operand1=operand2=0;
            txt.setText(""+number);
        }

        if(flag==true)
            operand2=number;



    }
}
