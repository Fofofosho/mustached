package com.FortTown.Fuji;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
    public final static String EXTRA_MESSAGE = "GameType";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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

    public void clickDialog(View view) {
        final Dialog dialog = new Dialog(MyActivity.this);
        dialog.setContentView(R.layout.dialog);
        //dialog.setTitle("Category");

        TextView text = (TextView) dialog.findViewById(R.id.textView);
        text.setText("Custom text example AKA poop on my butt");

        dialog.show();

        Button exitButton = (Button) dialog.findViewById(R.id.button);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
}
