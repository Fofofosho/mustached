package com.FortTown.Fuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by Olen on 1/26/14.
 */
public class Gameplay extends Activity {

    //Set up timer
    private CountDownTimer countDownTimer;
    public TextView timerText;
    private final long startTime = 5 * 1000;
    private final long interval = 1 * 1000;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);

        //get intent used to create this which can pass a message
        Intent intent = getIntent();

        //get message from intent

        String gameMode = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        //change text to whatever was passed in
        TextView textView = (TextView)this.findViewById(R.id.textView);
        textView.setText(gameMode);

        //Set up timer text
        timerText = (TextView)this.findViewById(R.id.timer);
        countDownTimer = new MyCountDownTimer(startTime, interval);
        timerText.setText(timerText.getText() + String.valueOf(startTime / 1000));

        //Start the timer
        countDownTimer.start();
    }

        public class MyCountDownTimer extends CountDownTimer {
            public MyCountDownTimer(long startTime, long interval) {
                super(startTime, interval);
            }

            @Override
            public void onFinish() {
                timerText.setText("Time's Up!");

                //TODO: Send to end screen
            }

            @Override
            public void onTick(long millisUntilFinished) {
                timerText.setText("" + millisUntilFinished / 1000);
            }
        }
}
