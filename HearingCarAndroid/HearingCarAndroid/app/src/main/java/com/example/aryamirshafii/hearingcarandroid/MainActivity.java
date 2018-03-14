package com.example.aryamirshafii.hearingcarandroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
        Button rightButton = (Button) findViewById(R.id.triggerRightWarning);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, rightWarning.class);
                startActivity(myIntent);
            }
        });


        Button leftButton = (Button) findViewById(R.id.triggerLeftWarning);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, leftWarning.class);
                startActivity(myIntent);
            }
        });


    }
}
