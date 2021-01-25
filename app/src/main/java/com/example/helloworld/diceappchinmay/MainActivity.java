package com.example.helloworld.diceappchinmay;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView diceImage1 = findViewById(R.id.imgDice1);
        ImageView diceImage2 = findViewById(R.id.imgDice2);

        int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        Button btnRoll = findViewById(R.id.btnRollTheDice);

        final int[] score1 = {0};
        final int[] score2 = {0};

        Button diceScore1 = findViewById(R.id.diceScore1);
        Button diceScore2 = findViewById(R.id.diceScore2);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyDiceApp", "btnRoll is tapped");

                Random rndObject = new Random();
                int myRandomNumber1 = rndObject.nextInt(6);
                int myRandomNumber2 = rndObject.nextInt(6);

                diceImage1.setImageResource(diceImages[myRandomNumber1]);
                diceImage2.setImageResource(diceImages[myRandomNumber2]);

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice1));

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice2));


                mp.start();

                score1[0] += myRandomNumber1 + 1;
                score2[0] += myRandomNumber2 + 1;

                diceScore1.setText("Dice 1: "+ score1[0]);
                diceScore2.setText("Dice 2: "+ score2[0]);
            }
        });
    }
}