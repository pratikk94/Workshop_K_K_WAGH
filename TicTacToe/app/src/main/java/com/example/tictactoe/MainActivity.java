package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ImageView[] imageViews;
    int[] values;
    int chance = 1;
    ConstraintLayout cl;
    Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();

    }


    public void initializeView(){

        imageViews = new ImageView[9];

        imageViews[0] = findViewById(R.id.iv_0);
        imageViews[1] = findViewById(R.id.iv_1);
        imageViews[2] = findViewById(R.id.iv_2);
        imageViews[3] = findViewById(R.id.iv_3);
        imageViews[4] = findViewById(R.id.iv_4);
        imageViews[5] = findViewById(R.id.iv_5);
        imageViews[6] = findViewById(R.id.iv_6);
        imageViews[7] = findViewById(R.id.iv_7);
        imageViews[8] = findViewById(R.id.iv_8);

        cl = findViewById(R.id.cl);


        values = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};



        for(int i=0;i<9;i++){
            int tempI = i;
            imageViews[i].setOnClickListener(view -> {
                if(values[tempI]==-1){
                    if(chance%2==0) {
                        values[tempI] = 1;
                        imageViews[tempI].setImageResource(R.drawable.o);
                    }
                    else{
                        values[tempI] = 2;
                        imageViews[tempI].setImageResource(R.drawable.x);
                    }
                    chance++;
                }
                else{
                    Snackbar.make(cl,"Already occupied",Snackbar.LENGTH_LONG).show();
                }

                if(checkWinning()!=-1){
                    Snackbar.make(cl,"Winner is"+checkWinning(),Snackbar.LENGTH_LONG).show();
                }

            });
        }

        btnReset = findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

    }

    public void reset(){
        for(int i=0;i<9;i++){
            values[i] = -1;
            imageViews[i].setImageResource(0);
        }
        chance = 1;
    }

    public int checkWinning(){
        //1st horizontal row
        if(values[0]==values[1]&&values[1]==values[2]&&values[0]!=-1)
            return values[0];
        //2nd horizontal row
        else if(values[3]==values[4]&&values[4]==values[5]&&values[3]!=-1)
            return values[5];
        //3rd horizontal row
        else if(values[6]==values[7]&&values[7]==values[8]&&values[6]!=-1)
            return values[6];
        //1st vertical row
        if(values[0]==values[3]&&values[3]==values[6]&&values[0]!=-1)
            return values[0];
        //2nd vertical row
        else if(values[1]==values[4]&&values[4]==values[7]&&values[1]!=-1)
            return values[5];
        //3rd vertical row
        else if(values[2]==values[5]&&values[5]==values[8]&&values[2]!=-1)
            return values[6];
        //left diagonal
        else if(values[0]==values[4]&&values[4]==values[8]&&values[0]!=-1)
            return values[5];
        //right diagonal
        else if(values[2]==values[4]&&values[4]==values[6]&&values[6]!=-1)
            return values[6];

        return -1;
    }


}