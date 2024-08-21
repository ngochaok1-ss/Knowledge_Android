package com.example.trainning_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int value = intent.getIntExtra("key", 0);
        Log.d("MyBroadCastReceiver", "action : " + intent.getAction() + " - value : " + value);
    }
}
