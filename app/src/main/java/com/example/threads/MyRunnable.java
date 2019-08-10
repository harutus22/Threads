package com.example.threads;

import android.os.Handler;
import android.os.Message;
import android.util.Log;


public class MyRunnable implements Runnable {
    private boolean isRunning;
    private Handler handler;

    public MyRunnable(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        isRunning = true;
        for(int i = 0; i <= 10; ++i){
            if(!isRunning){
                break;
            }
            Log.d(MainActivity.TAG, String.valueOf(i));
            handler.sendEmptyMessage(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
