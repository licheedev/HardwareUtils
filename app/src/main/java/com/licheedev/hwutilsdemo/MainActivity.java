package com.licheedev.hwutilsdemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.licheedev.hwutils.SystemClockEx;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 started!");
                SystemClockEx.sleepUntil(3000);
                System.out.println("Thread1 finished!");
            }
        });
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Interrupt Thread1!");
                thread1.interrupt();
            }
        });
        thread1.start();
        thread2.start();
    }
}