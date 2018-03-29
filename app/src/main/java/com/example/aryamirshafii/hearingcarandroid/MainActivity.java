package com.example.aryamirshafii.hearingcarandroid;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.widget.TextView;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Set;
import java.util.UUID;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    volatile boolean stopWorker;
    private TextView  bluetoothStatusLabel;
    private BluetoothAdapter myBluetooth;
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

        bluetoothStatusLabel = (TextView) findViewById(R.id.bluetoothLabel);
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        adapter.startDiscovery();
        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(mReceiver, filter);


        if(adapter.isEnabled()) {
            bluetoothStatusLabel.setText("Bluetooth on");
        }
    }


    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            System.out.println("in here!!!");

            if (action.equals(myBluetooth.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                        BluetoothAdapter.ERROR);
                switch (state) {
                    case BluetoothAdapter.STATE_OFF:
                        bluetoothStatusLabel.setText("Bluetooth off");
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        bluetoothStatusLabel.setText("Turning Bluetooth off...");
                        break;
                    case BluetoothAdapter.STATE_ON:
                        bluetoothStatusLabel.setText("Bluetooth on");
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        bluetoothStatusLabel.setText("Turning Bluetooth on...");
                        break;
                }
            }
        }
    };




}