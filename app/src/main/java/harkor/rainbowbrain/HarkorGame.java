package harkor.rainbowbrain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;




public class HarkorGame extends AppCompatActivity {


    int wybrany=0;
    int[]numbers=new int[4];
    int[]numtext=new int[4];
    int haslo,bydzie=0;
    int wynik=0;
    long time_to;
    int czas=5000;
    CountDownTimer odliczacz;

    public void gameover()
    {
        TextView tvWynik=(TextView) findViewById(R.id.tvWynik);
        tvWynik.setText("GAME OVER SCORE: "+wynik);
        tvWynik.setVisibility(View.VISIBLE);
        time_to=5000;



        SharedPreferences sharedPref2;
        SharedPreferences.Editor editor;
        sharedPref2=getSharedPreferences("harkor.rainbowbrain", Context.MODE_PRIVATE);
        editor=sharedPref2.edit();
        int wow=sharedPref2.getInt("score",0);
        if(wynik>wow){
            Toast.makeText(HarkorGame.this,R.string.newBest,Toast.LENGTH_SHORT).show();
            editor.putInt("score",wynik);
            editor.commit();
        }









        wynik=0;
        odliczacz.cancel();
        Button button2=(Button) findViewById(R.id.button2);
        Button button3=(Button) findViewById(R.id.button3);
        Button button4=(Button) findViewById(R.id.button4);
        Button button5=(Button) findViewById(R.id.button5);
        TextView tTytul=(TextView) findViewById(R.id.tTytul);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        button5.setVisibility(View.INVISIBLE);
        tTytul.setVisibility(View.INVISIBLE);
        ProgressBar progresjest=(ProgressBar) findViewById(R.id.progresjest);
        progresjest.setVisibility(View.INVISIBLE);
        Button dalej=(Button) findViewById(R.id.dalej);
        dalej.setVisibility(View.VISIBLE);



        //odliczanko();

        //KONIEC ZAVAWY
        //tscore.setVisibility(View.INVISIBLE);

    }


    public void odliczanko()
    {

        czas=(int)time_to;
        ProgressBar progresjest=(ProgressBar) findViewById(R.id.progresjest);
        progresjest.setMax(czas);
        odliczacz = new CountDownTimer(time_to,100)
        {


            public void onTick(long przed_koncem)
            {

                    czas = (int) przed_koncem;
                    ProgressBar progresjest = (ProgressBar) findViewById(R.id.progresjest);
                    progresjest.setProgress(czas);


            }
            public void onFinish()
            {
                    ProgressBar progresjest = (ProgressBar) findViewById(R.id.progresjest);
                    progresjest.setProgress(0);
                    //TextView tscore = (TextView) findViewById(R.id.tscore);
                   // tscore.setText("END SCORE: "+wynik);
                    //time_to = 5000;
                    //wynik = 0;
                gameover();
            }
        }.start();




    }
    public void losowanko(){
        Random losowanie = new Random();
        //               DODANIE ELEMENTÓW
        Button button2=(Button) findViewById(R.id.button2);
        Button button3=(Button) findViewById(R.id.button3);
        Button button4=(Button) findViewById(R.id.button4);
        Button button5=(Button) findViewById(R.id.button5);
        TextView tTytul=(TextView) findViewById(R.id.tTytul);



        //losowanie do kolorów przycisków
        numbers[0]=(1+losowanie.nextInt(4));
        do {
            numbers[1]=(1+losowanie.nextInt(4));
        }while(numbers[0]==numbers[1]);

        do {
            numbers[2]=(1+losowanie.nextInt(4));
        }while(numbers[2]==numbers[1]||numbers[2]==numbers[0]);
        numbers[3]=10-numbers[0]-numbers[1]-numbers[2];

        //losowanie do kolejności napisów
        numtext[0]=(1+losowanie.nextInt(4));
        do {
            numtext[1]=(1+losowanie.nextInt(4));
        }while(numtext[0]==numtext[1]);

        do {
            numtext[2]=(1+losowanie.nextInt(4));
        }while(numtext[2]==numtext[1]||numtext[2]==numtext[0]);
        numtext[3]=10-numtext[0]-numtext[1]-numtext[2];

        haslo=(1+losowanie.nextInt(4)); //poprawna odpowiedz
        //                            KOLOR NAPISU
        if(haslo%4==0)
        {
            tTytul.setTextColor(Color.YELLOW);
        }
        else if(haslo%3==0)
        {
            tTytul.setTextColor(Color.BLUE);
        }
        else if(haslo%2==0)
        {
            tTytul.setTextColor(Color.GREEN);
        }
        else
        {
            tTytul.setTextColor(Color.RED);
        }

        //                          KOLORY PRZYCISKÓW

        if(numbers[0]==1)
        {
            button2.setBackgroundColor(Color.RED);
        }
        else if(numbers[0]==2)
        {
            button2.setBackgroundColor(Color.GREEN);
        }
        else if(numbers[0]==3)
        {
            button2.setBackgroundColor(Color.BLUE);
        }
        else
        {
            button2.setBackgroundColor(Color.YELLOW);
        }
        //2
        if(numbers[1]==1)
        {
            button3.setBackgroundColor(Color.RED);
        }
        else if(numbers[1]==2)
        {
            button3.setBackgroundColor(Color.GREEN);
        }
        else if(numbers[1]==3)
        {
            button3.setBackgroundColor(Color.BLUE);
        }
        else
        {
            button3.setBackgroundColor(Color.YELLOW);
        }
        //3
        if(numbers[2]==1)
        {
            button4.setBackgroundColor(Color.RED);
        }
        else if(numbers[2]==2)
        {
            button4.setBackgroundColor(Color.GREEN);
        }
        else if(numbers[2]==3)
        {
            button4.setBackgroundColor(Color.BLUE);
        }
        else
        {
            button4.setBackgroundColor(Color.YELLOW);
        }
        //4
        if(numbers[3]==1)
        {
            button5.setBackgroundColor(Color.RED);
        }
        else if(numbers[3]==2)
        {
            button5.setBackgroundColor(Color.GREEN);
        }
        else if(numbers[3]==3)
        {
            button5.setBackgroundColor(Color.BLUE);
        }
        else
        {
            button5.setBackgroundColor(Color.YELLOW);
        }

        if(numtext[0]==1)
        {
            button2.setText(R.string.sRED);
        }
        else if(numtext[0]==2)
        {
            button2.setText(R.string.sGREEN);
        }
        else if(numtext[0]==3)
        {
            button2.setText(R.string.sBLUE);
        }
        else
        {
            button2.setText(R.string.sYELLOW);
        }

        //2
        if(numtext[1]==1)
        {
            button3.setText(R.string.sRED);
        }
        else if(numtext[1]==2)
        {
            button3.setText(R.string.sGREEN);
        }
        else if(numtext[1]==3)
        {
            button3.setText(R.string.sBLUE);
        }
        else
        {
            button3.setText(R.string.sYELLOW);
        }

        //3
        if(numtext[2]==1)
        {
            button4.setText(R.string.sRED);
        }
        else if(numtext[2]==2)
        {
            button4.setText(R.string.sGREEN);
        }
        else if(numtext[2]==3)
        {
            button4.setText(R.string.sBLUE);
        }
        else
        {
            button4.setText(R.string.sYELLOW);
        }
        //4
        if(numtext[3]==1)
        {
            button5.setText(R.string.sRED);
        }
        else if(numtext[3]==2)
        {
            button5.setText(R.string.sGREEN);
        }
        else if(numtext[3]==3)
        {
            button5.setText(R.string.sBLUE);
        }
        else
        {
            button5.setText(R.string.sYELLOW);
        }
    }
    protected void onCreate(Bundle savedInstanceState) //                                            CREATE
    {
        time_to=5000;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harkor_game);

        losowanko();

        odliczanko();
        //bydzie=wynik;
        //long czasS=System.currentTimeMillis();
    }


    public void batony()   //                                                                       PO KLIKU
    {
        TextView tscore=(TextView) findViewById(R.id.tscore);
        if (numtext[wybrany-1]==haslo)   //                                                         WIN
        {
            wynik++;
            String lololo=Integer.toString(wynik);

            tscore.setText(lololo);
            losowanko();
            time_to=time_to*95/100;
            odliczacz.cancel();
            odliczanko();
            bydzie=wynik;
        }
        else { //                                                                                   PORAŻKA
            gameover();



        }

    }


    public void baton1(View view) {
        wybrany=1;

        batony();

    }
    public void baton2(View view) {
        wybrany = 2;

        batony();
    }
    public void baton3(View view) {
        wybrany = 3;

        batony();
    }
    public void baton4(View view) {
        wybrany = 4;

        batony();
    }
    public void dalejdalej(View view){
        //Intent intent = new Intent(this, HarkorMenu.class);
       // startActivity(intent);
        finish();
        System.exit(0);

    }


}

