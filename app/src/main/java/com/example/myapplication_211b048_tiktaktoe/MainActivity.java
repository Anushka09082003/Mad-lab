package com.example.myapplication_211b048_tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClicked=-1;
    int x=1;
    int [][]winningState={{0,1,2},{3,4,5},{6,7,8}};
    int []gameState= {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public void load(View view) {
            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imageClicked= gameState[tag];
        if(isWinner==false && imageClicked==-1) {
            if (x == 1) {
                v.setImageResource(R.drawable.cross);
                gameState[tag] = x;
                x = 0;
                //Toast.makeText(this, tag+" "+"cross", Toast.LENGTH_SHORT).show();
            } else {
                v.setImageResource(R.drawable.zero);
                gameState[tag] = x;
                //Toast.makeText(this, tag+" "+"zero", Toast.LENGTH_SHORT).show();
                x = 1;
            }
            for (int i = 0; i < winningState.length; i++) {
                if (gameState[winningState[i][0]] == gameState[winningState[i][1]] && gameState[winningState[i][1]] == gameState[winningState[i][2]] && gameState[winningState[i][1]] > -1) {
                    Toast.makeText(this, "winner is " + (x == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                } else if (gameState[winningState[0][i]] == gameState[winningState[1][i]] && gameState[winningState[1][i]] == gameState[winningState[2][i]] && gameState[winningState[1][i]] > -1) {
                    Toast.makeText(this, "winner is " + (x == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                } else if (gameState[winningState[0][0]] == gameState[winningState[1][1]] && gameState[winningState[1][1]] == gameState[winningState[2][2]] && gameState[winningState[1][1]] > -1) {
                    Toast.makeText(this, "winner is " + (x == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                    break;
                } else if (gameState[winningState[0][2]] == gameState[winningState[1][1]] && gameState[winningState[1][1]] == gameState[winningState[2][0]] && gameState[winningState[1][1]] > -1) {
                    Toast.makeText(this, "winner is " + (x == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                    break;
                }
            }
        }
    }

    public void reset(View view){

        androidx.gridlayout.widget.GridLayout g= findViewById(R.id.gridLayout);
        int total_images= g.getChildCount();
        for(int i=0;i<total_images;i++){
            ImageView v= (ImageView) g.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner = false;
        imageClicked= -1;
        x=1;
        for(int j=0 ;j< gameState.length;j++)
        {
            gameState[j] = -1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}