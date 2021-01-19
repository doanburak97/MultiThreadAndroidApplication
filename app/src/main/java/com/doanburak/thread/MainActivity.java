package com.doanburak.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    private TextView tv_second, tv_minute, tv_hour, tv_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_second = findViewById(R.id.tv_second);
        tv_minute = findViewById(R.id.tv_minute);
        tv_hour = findViewById(R.id.tv_hour);
        tv_day = findViewById(R.id.tv_day);

        Handler updaterSecond = new Handler();
        Handler updaterMinute = new Handler();
        Handler updaterHour = new Handler();
        Handler updaterDay = new Handler();


        //Thread for second
        Thread threadSecond = new Thread(){
            @Override
            public void run(){

                int counter = 1;

                while(true){

                    if (counter == 60){counter = 0;}

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int finalCounter = counter;
                    updaterSecond.post(new Runnable() {
                        @Override
                        public void run() {
                            tv_second.setText("" + finalCounter);
                        }
                    });

                    counter++;
                }
            }
        };
        threadSecond.start();


        //Thread for minute
        Thread threadMinute = new Thread(){
            @Override
            public void run(){

                int counter = 1;

                while(true){

                    if (counter == 60){counter = 0;}

                    try {
                        sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int finalCounter = counter;
                    updaterMinute.post(new Runnable() {
                        @Override
                        public void run() {
                            tv_minute.setText("" + finalCounter);
                        }
                    });

                    counter++;
                }
            }
        };
        threadMinute.start();


        //Thread for hour
        Thread threadHour = new Thread(){
            @Override
            public void run(){

                int counter = 1;

                while(true){

                    if (counter == 24){counter = 0;}

                    try {
                        sleep(1440000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int finalCounter = counter;
                    updaterHour.post(new Runnable() {
                        @Override
                        public void run() {
                            tv_hour.setText("" + finalCounter);
                        }
                    });

                    counter++;
                }
            }
        };
        threadHour.start();


        //Thread for day
        Thread threadDay = new Thread(){
            @Override
            public void run(){

                int counter = 1;

                while(true){

                    if (counter == 31){counter = 0;}

                    try {
                        sleep(1440000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int finalCounter = counter;
                    updaterDay.post(new Runnable() {
                        @Override
                        public void run() {
                            tv_day.setText("" + finalCounter);
                        }
                    });

                    counter++;
                }
            }
        };
        threadDay.start();

    }


}