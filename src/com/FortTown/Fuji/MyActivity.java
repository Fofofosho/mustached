package com.FortTown.Fuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {
    public final static String EXTRA_MESSAGE = "GameType";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void clickPlay(View view) {
        Intent intent = new Intent(this, Gameplay.class);
        //get ID of button that sent us here
        switch(view.getId()) {
            case R.id.button:
                intent.putExtra(EXTRA_MESSAGE, "Movies");
                break;
            case R.id.button2:
                intent.putExtra(EXTRA_MESSAGE, "Video Games");
                break;
            default:
                intent.putExtra(EXTRA_MESSAGE, "Movies");
                break;
        }
        startActivity(intent);
    }
}
