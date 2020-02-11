/*
Peyton White
Assignment 5
4010

 */
package com.peytonwhite.orderandchaoswhite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.peytonwhite.orderandchaoswhite.AboutOrderAndChaos;
import com.peytonwhite.orderandchaoswhite.PlayScreen;
import com.peytonwhite.orderandchaoswhite.R;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        findViewById(R.id.buttonPlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), PlayScreen.class);
                startActivity(intent);

            }
        });


        findViewById(R.id.buttonAboutOrder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AboutOrderAndChaos.class);
                startActivity(intent);

            }
        });





        findViewById(R.id.buttonMoreAbout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://en.wikipedia.org/wiki/Order_and_Chaos");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);


            }
        });





    }
}
