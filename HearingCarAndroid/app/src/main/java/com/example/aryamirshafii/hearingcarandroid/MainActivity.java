package com.example.aryamirshafii.hearingcarandroid;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Handler;
import android.widget.TextView;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    volatile boolean stopWorker;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
        Button rightButton = (Button) findViewById(R.id.triggerRightHornWarning);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, rightHornWarning.class);
                startActivity(myIntent);
            }
        });


        Button leftButton = (Button) findViewById(R.id.triggerLeftHornWarning);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, leftHornWarning.class);
                startActivity(myIntent);
            }
        });

        Button rightButton2 = (Button) findViewById(R.id.triggerRightSirenWarning);
        rightButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, rightSirenWarning.class);
                startActivity(myIntent);
            }
        });


        Button leftButton2 = (Button) findViewById(R.id.triggerLeftSirenWarning);
        leftButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, leftSirenWarning.class);
                startActivity(myIntent);
            }
        });


    }


}