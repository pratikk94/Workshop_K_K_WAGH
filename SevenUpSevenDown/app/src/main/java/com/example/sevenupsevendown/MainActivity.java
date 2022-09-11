package com.example.sevenupsevendown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_dice1,iv_dice2;
    Button btnLess,btnGreater,btnEquals;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_dice1 = findViewById(R.id.iv_dice_1);
        iv_dice2 = findViewById(R.id.iv_dice_2);

        btnLess = findViewById(R.id.btn_less_7);
        btnEquals = findViewById(R.id.btn_equals_7);
        btnGreater = findViewById(R.id.btn_greater_7);

        cl = findViewById(R.id.cl);

        btnLess.setOnClickListener(view -> clickButton(1));
        btnEquals.setOnClickListener(view -> clickButton(2));
        btnGreater.setOnClickListener(view -> clickButton(3));

    }

    public void clickButton(int choice){
        Random random = new Random();

        int dice1 = random.nextInt(6);
        int dice2 = random.nextInt(6);

        changeImage(dice1,iv_dice1);
        changeImage(dice2,iv_dice2);

        if(checkWin(choice,dice1+dice2+2)){
            cl.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else{
            cl.setBackgroundColor(getResources().getColor(R.color.red));
        }
    }


    public boolean checkWin(int choice,int number){
        if(choice ==1 &number<7){
            return true;
        }
        else if(choice == 2 && number == 7){
            return true;
        }
        else if(choice == 3 && number > 7){
            return true;
        }
        else{
            return false;
        }
    }

    public void changeImage(int imageIndex,ImageView iv){
        switch (imageIndex){
            case 0:
                iv.setImageResource(R.drawable.white1);
                break;
            case 1:
                iv.setImageResource(R.drawable.white2);
                break;
            case 2:
                iv.setImageResource(R.drawable.white3);
                break;
            case 3:
                iv.setImageResource(R.drawable.white4);
                break;
            case 4:
                iv.setImageResource(R.drawable.white5);
                break;
            case 5:
                iv.setImageResource(R.drawable.white6);
                break;
        }
    }



}