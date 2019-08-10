package com.example.threads;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Main";
//    private MyThread thread;
    private Thread thread;
    private MyRunnable myRunnable;
    private Handler h;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);

        h = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                String text = msg.what * 10 + "%";
                textView.setText(text);
                return false;
            }
        });

    }

    public void onStart(View view){
//        thread = new MyThread();
//        thread.start();

        myRunnable = new MyRunnable(h);
        thread = new Thread(myRunnable);
        thread.start();

    }

    public void onStop(View view){
//        thread.setRunning(false);

        myRunnable.setRunning(false);
    }

    public void nextActivity(View view){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}
