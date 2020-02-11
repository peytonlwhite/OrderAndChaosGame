/*
Peyton White
Assignment 5
4010

 */
package com.peytonwhite.orderandchaoswhite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PlayScreen extends AppCompatActivity implements ImageButton.OnClickListener{

    //1 = orders, 2 = chaos turn
    int whosTurn = 1;

    //if plays = 36 and order hasnt won then chaos wins (increase plays each click)
    int plays = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        //row 0
        findViewById(R.id.imageButtonR0C0).setOnClickListener(this);
        findViewById(R.id.imageButtonR0C1).setOnClickListener(this);
        findViewById(R.id.imageButtonR0C2).setOnClickListener(this);
        findViewById(R.id.imageButtonR0C3).setOnClickListener(this);
        findViewById(R.id.imageButtonR0C4).setOnClickListener(this);
        findViewById(R.id.imageButtonR0C5).setOnClickListener(this);

        //row 1
        findViewById(R.id.imageButtonR1C0).setOnClickListener(this);
        findViewById(R.id.imageButtonR1C1).setOnClickListener(this);
        findViewById(R.id.imageButtonR1C2).setOnClickListener(this);
        findViewById(R.id.imageButtonR1C3).setOnClickListener(this);
        findViewById(R.id.imageButtonR1C4).setOnClickListener(this);
        findViewById(R.id.imageButtonR1C5).setOnClickListener(this);

        //row 2
        findViewById(R.id.imageButtonR2C0).setOnClickListener(this);
        findViewById(R.id.imageButtonR2C1).setOnClickListener(this);
        findViewById(R.id.imageButtonR2C2).setOnClickListener(this);
        findViewById(R.id.imageButtonR2C3).setOnClickListener(this);
        findViewById(R.id.imageButtonR2C4).setOnClickListener(this);
        findViewById(R.id.imageButtonR2C5).setOnClickListener(this);

        //row 3
        findViewById(R.id.imageButtonR3C0).setOnClickListener(this);
        findViewById(R.id.imageButtonR3C1).setOnClickListener(this);
        findViewById(R.id.imageButtonR3C2).setOnClickListener(this);
        findViewById(R.id.imageButtonR3C3).setOnClickListener(this);
        findViewById(R.id.imageButtonR3C4).setOnClickListener(this);
        findViewById(R.id.imageButtonR3C5).setOnClickListener(this);

        //row 4
        findViewById(R.id.imageButtonR4C0).setOnClickListener(this);
        findViewById(R.id.imageButtonR4C1).setOnClickListener(this);
        findViewById(R.id.imageButtonR4C2).setOnClickListener(this);
        findViewById(R.id.imageButtonR4C3).setOnClickListener(this);
        findViewById(R.id.imageButtonR4C4).setOnClickListener(this);
        findViewById(R.id.imageButtonR4C5).setOnClickListener(this);

        //row 5
        findViewById(R.id.imageButtonR5C0).setOnClickListener(this);
        findViewById(R.id.imageButtonR5C1).setOnClickListener(this);
        findViewById(R.id.imageButtonR5C2).setOnClickListener(this);
        findViewById(R.id.imageButtonR5C3).setOnClickListener(this);
        findViewById(R.id.imageButtonR5C4).setOnClickListener(this);
        findViewById(R.id.imageButtonR5C5).setOnClickListener(this);

        //textviews
        TextView orderTextView = findViewById(R.id.textViewOrder);
        TextView chaosTextView = findViewById(R.id.textViewChaos);
        final TextView textViewWinner = findViewById(R.id.textViewWinner);


        //end turn button


        if(whosTurn == 1)
        {
            orderTextView.setTextColor(Color.CYAN);
            chaosTextView.setTextColor(Color.BLACK);
        }
        else
        {
            orderTextView.setTextColor(Color.BLACK);
            chaosTextView.setTextColor(Color.CYAN);
        }


        //get buttons and add the listeners
        findViewById(R.id.buttonRestart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reset all the images and textviews and the plays count
                textViewWinner.setText("");
                plays = 0;

                //reset all the tags and the images of each square just restarts the class
                Intent intent = new Intent(getApplicationContext(),PlayScreen.class);
                startActivity(intent);



            }
        });


        //goes back to home page
        findViewById(R.id.buttonHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });







    }



    @Override
    public void onClick(View view) {

        //switches
        Switch orderSwitch = findViewById(R.id.switchOrder);
        Switch chaosSwitch = findViewById(R.id.switchChaos);


        //textviews
        TextView orderTextView = findViewById(R.id.textViewOrder);
        TextView chaosTextView = findViewById(R.id.textViewChaos);




        if(whosTurn == 1 && ((Integer)((ImageButton) view).getTag() == null
                || (Integer)((ImageButton) view).getTag() == R.drawable.graybackground)) {

            if (orderSwitch.isChecked()) {
                ((ImageButton) view).setImageResource(R.drawable.xletter);
                ((ImageButton) view).setTag(R.drawable.xletter);
            } else {
                ((ImageButton) view).setImageResource(R.drawable.oletter);
                ((ImageButton) view).setTag(R.drawable.oletter);
            }

            //changes the players turn
            whosTurn = 2;
            plays++;

        }
        else if(whosTurn == 2 && (Integer)((ImageButton) view).getTag() == null
                || (Integer)((ImageButton) view).getTag() == R.drawable.graybackground)
        {
            if (chaosSwitch.isChecked()) {
                ((ImageButton) view).setImageResource(R.drawable.xletter);
                ((ImageButton) view).setTag(R.drawable.xletter);
            } else {
                ((ImageButton) view).setImageResource(R.drawable.oletter);
                ((ImageButton) view).setTag(R.drawable.oletter);
            }

            //changes the players turn
            whosTurn = 1;
            plays++;


        }





        //checks for whos turn then changes the color. to keep track of user turn
        if(whosTurn == 1)
        {
            orderTextView.setTextColor(Color.CYAN);
            chaosTextView.setTextColor(Color.BLACK);
        }
        else
        {
            orderTextView.setTextColor(Color.BLACK);
            chaosTextView.setTextColor(Color.CYAN);
        }




      //check for wins
        boolean choasWins =  checkForChaosWin();
        boolean orderWins =  checkForOrderWin();
        //get the textview for the winneer
        TextView tvWinner = findViewById(R.id.textViewWinner);
        if(orderWins)
        {
            tvWinner.setText("ORDER WINS!");
        }
        else if(choasWins && orderWins == false)
        {
            tvWinner.setText("CHOAS WINS!");


        }










    }




    private boolean checkForOrderWin()
    {

        boolean orderWins = false;

        //options
        //36 if loops for all possilbites testing each square for id

        //set an array of all the pic ids and create a for loop for HVD (3 for loops)

        //get a 2d array and for every image that is pressed set that colum row to true or false


        //sets all the pic ids to all the image buttons
        int arrayPicIds[] = {R.id.imageButtonR0C0,R.id.imageButtonR0C1,R.id.imageButtonR0C2,R.id.imageButtonR0C3,
                             R.id.imageButtonR0C4,R.id.imageButtonR0C5,R.id.imageButtonR1C0,R.id.imageButtonR1C1,
                             R.id.imageButtonR1C2,R.id.imageButtonR1C3,R.id.imageButtonR1C4,R.id.imageButtonR1C5,
                             R.id.imageButtonR2C0,
                             R.id.imageButtonR2C1,R.id.imageButtonR2C2,R.id.imageButtonR2C3,R.id.imageButtonR2C4,
                             R.id.imageButtonR2C5,R.id.imageButtonR3C0,R.id.imageButtonR3C1,R.id.imageButtonR3C2,
                             R.id.imageButtonR3C3,R.id.imageButtonR3C4,R.id.imageButtonR3C5,R.id.imageButtonR4C0,
                             R.id.imageButtonR4C1,R.id.imageButtonR4C2,R.id.imageButtonR4C3,R.id.imageButtonR4C4,
                             R.id.imageButtonR4C5,R.id.imageButtonR5C0,R.id.imageButtonR5C1,R.id.imageButtonR5C2,
                             R.id.imageButtonR5C3,R.id.imageButtonR5C4,R.id.imageButtonR5C5};

        //sets the arraylist for all the images
        ArrayList<ImageButton> arrayPicId = new ArrayList<>();

        for(int i = 0; i < arrayPicIds.length;i++)
        {
            arrayPicId.add((ImageButton)findViewById(arrayPicIds[i]));
        }

        int xFiveInARow = 0;
        int oFiveInARow = 0;
        int endOfRow = 0;


        // go through array with for loop and check to see if there are 5 in a row in each row
        //using two booleans for x and os





        //checks all 5 ways (the hard part)




        //checks for all horizontal wins for both X and O
        for(int i = 0; i < arrayPicIds.length;i++)
        {
            endOfRow++;

            if((Integer)arrayPicId.get(i).getTag() == null)
            {
                arrayPicId.get(i).setTag(R.drawable.graybackground);
            }
           else if((Integer)arrayPicId.get(i).getTag() == R.drawable.xletter)
            {
                xFiveInARow++;

                if(xFiveInARow == 5)
                {
                    orderWins = true;
                    break;
                }
            }
            else if((Integer)arrayPicId.get(i).getTag() == R.drawable.oletter)
            {
                oFiveInARow++;

                if(oFiveInARow == 5)
                {
                    orderWins = true;
                    break;
                }
            }
            else
            {
                xFiveInARow = 0;
                oFiveInARow = 0;
            }

            if(endOfRow == 6)
            {
                endOfRow = 0;
                xFiveInARow = 0;
                oFiveInARow = 0;

            }

        }




        endOfRow = 0;
        xFiveInARow = 0;
        oFiveInARow = 0;


       int arrayPicIdsVertical[] = {R.id.imageButtonR0C0,R.id.imageButtonR1C0,R.id.imageButtonR2C0,
                R.id.imageButtonR3C0,
                R.id.imageButtonR4C0,R.id.imageButtonR5C0,R.id.imageButtonR0C1,R.id.imageButtonR1C1,
                R.id.imageButtonR2C1,R.id.imageButtonR3C1,R.id.imageButtonR4C1,R.id.imageButtonR5C1,
                R.id.imageButtonR0C2,
                R.id.imageButtonR1C2,R.id.imageButtonR2C2,R.id.imageButtonR3C2,R.id.imageButtonR4C2,
                R.id.imageButtonR5C2,R.id.imageButtonR0C3,R.id.imageButtonR1C3,R.id.imageButtonR2C3,
                R.id.imageButtonR3C3,R.id.imageButtonR4C3,R.id.imageButtonR5C3,R.id.imageButtonR0C4,
                R.id.imageButtonR1C4,
                R.id.imageButtonR2C4,R.id.imageButtonR3C4,R.id.imageButtonR4C4,R.id.imageButtonR5C4,
                R.id.imageButtonR0C5,R.id.imageButtonR1C5,R.id.imageButtonR2C5,R.id.imageButtonR3C5,
                R.id.imageButtonR4C5,R.id.imageButtonR5C5};

       arrayPicId.removeAll(arrayPicId);

        for(int i = 0; i < arrayPicIds.length;i++)
        {
            arrayPicId.add((ImageButton)findViewById(arrayPicIdsVertical[i]));
        }


        //checks for all vertical wins
        for(int i = 0; i < arrayPicIds.length;i++)
        {
            endOfRow++;

            if((Integer)arrayPicId.get(i).getTag() == null)
            {
                arrayPicId.get(i).setTag(R.drawable.graybackground);
            }
            else if((Integer)arrayPicId.get(i).getTag() == R.drawable.xletter)
            {
                xFiveInARow++;

                if(xFiveInARow == 5)
                {
                    orderWins = true;
                    break;
                }
            }
            else if((Integer)arrayPicId.get(i).getTag() == R.drawable.oletter)
            {
                oFiveInARow++;

                if(oFiveInARow == 5)
                {
                    orderWins = true;
                    break;
                }
            }
            else
            {
                xFiveInARow = 0;
                oFiveInARow = 0;
            }

            if(endOfRow == 6)
            {
                endOfRow = 0;
                xFiveInARow = 0;
                oFiveInARow = 0;

            }

        }



        //checks for all diagonal wins
        endOfRow = 0;
        xFiveInARow = 0;
        oFiveInARow = 0;


        int arrayPicIdsDiagonal[] = {R.id.imageButtonR0C0,R.id.imageButtonR1C1,R.id.imageButtonR2C2,
                R.id.imageButtonR3C3,
                R.id.imageButtonR4C4,R.id.imageButtonR5C5,R.id.imageButtonR0C1,R.id.imageButtonR1C2,
                R.id.imageButtonR2C3,R.id.imageButtonR3C4,R.id.imageButtonR4C5,R.id.imageButtonR1C0,
                R.id.imageButtonR2C1,
                R.id.imageButtonR3C2,R.id.imageButtonR4C3,R.id.imageButtonR5C4};

        arrayPicId.removeAll(arrayPicId);

        for(int i = 0; i < arrayPicIdsDiagonal.length;i++)
        {
            arrayPicId.add((ImageButton)findViewById(arrayPicIdsDiagonal[i]));
        }


        //checks for all diagonal wins
        for(int i = 0; i < arrayPicIdsDiagonal.length;i++)
        {
            endOfRow++;

            if((Integer)arrayPicId.get(i).getTag() == null)
            {
                arrayPicId.get(i).setTag(R.drawable.graybackground);
            }
            else if((Integer)arrayPicId.get(i).getTag() == R.drawable.xletter)
            {
                xFiveInARow++;

                if(xFiveInARow == 5)
                {
                    orderWins = true;
                    break;
                }
            }
            else if((Integer)arrayPicId.get(i).getTag() == R.drawable.oletter)
            {
                oFiveInARow++;

                if(oFiveInARow == 5)
                {
                    orderWins = true;
                    break;
                }
            }
            else
            {
                xFiveInARow = 0;
                oFiveInARow = 0;
            }

            if(endOfRow == 6)
            {
                endOfRow = 0;
                xFiveInARow = 0;
                oFiveInARow = 0;

            }

        }





        

        return orderWins;
    }

    private boolean checkForChaosWin()
    {

        boolean chaosWins = false;

        if(plays == 36)
        {
            chaosWins = true;
            plays = 0;
        }

        return chaosWins;

    }



}
