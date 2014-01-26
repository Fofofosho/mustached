package com.FortTown.Fuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Olen on 1/26/14.
 */
public class Gameplay extends Activity {
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


    }

}