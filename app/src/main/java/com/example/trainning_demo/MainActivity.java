package com.example.trainning_demo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.trainning_demo.recycler_view.MainActivity2;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btn_press, btn_start_service, btn_stopService, btn_send;
    BroadcastReceiver receiver;
//    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        receiver = new MyBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction("action_demo");
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,filter);


        btn_press = findViewById(R.id.btn_press);
        btn_start_service = findViewById(R.id.btn_startService);
        btn_stopService = findViewById(R.id.btn_stopService);
        btn_send = findViewById(R.id.btn_sendNotification);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("action_demo");
                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(it);
            }
        });
        btn_press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(it);
            }
        });
        btn_start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, MyService.class);
                it.putExtra("name","Hao");
                startService(it);


            }
        });
        btn_stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, MyService.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }
}