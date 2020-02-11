
/*
Peyton White
Assignment 5
4010

 */
package com.peytonwhite.orderandchaoswhite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AboutOrderAndChaos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_order_and_chaos);

        TextView tv = findViewById(R.id.textViewAbout);

        tv.setText("This game is the ultimate Tic Tac Toe - Peyton White");


        findViewById(R.id.buttonHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }







        });






    }
}
