package com.example.threads;

import android.util.Log;

public class MyThread extends Thread {
    private boolean isRunning;

    @Override
    public void run() {
        super.run();
        isRunning = true;
        for(int i = 0; i <= 10; ++i){
            if(!isRunning){
                break;
            }
            Log.d(MainActivity.TAG, String.valueOf(i));
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

