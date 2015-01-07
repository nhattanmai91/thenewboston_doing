package com.example.tan.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by tan on 1/6/2015.
 */
public class Main extends Activity {

    Button go_second_btn;
    int count;

    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.main);

        ourSong = MediaPlayer.create(Main.this, R.raw.nobody);

        go_second_btn = (Button) findViewById(R.id.go_second_btn);
        go_second_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
               go_second_btn.setText(count+"");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Thread mThread = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent openStartingPoint = new Intent("com.example.tan.myapplication.TEXTPLAY");
                    startActivity(openStartingPoint);
                }
            }
        };
        mThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        ourSong.start();
        finish();
    }
}
