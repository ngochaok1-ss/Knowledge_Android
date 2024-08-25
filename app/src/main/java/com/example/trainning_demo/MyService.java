package com.example.trainning_demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private String TAG = "MyService";
    @Override
    public void onCreate() {
        Log.d(TAG, "#onCreate");
        super.onCreate();
//        startForegroundService()
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "#onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "#onStartCommand");
        String value = intent.getStringExtra("name");
        Log.d(TAG, "value : " + value);
        Log.d("Service Status","Starting Service");
        for (int i =0 ; i<= 10 ; i++)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Log.d(TAG, "Service + " + Thread.currentThread().getName() + " : " + i);
        }
        return START_STICKY;
    }

    @Override
    public boolean stopService(Intent name) {
        Log.d(TAG, "Stop Service");
        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "#onDestroy");
        super.onDestroy();
    }
}
