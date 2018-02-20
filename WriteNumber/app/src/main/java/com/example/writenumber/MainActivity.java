package com.example.writenumber;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    static boolean playMusic = true;
    MediaPlayer mediaPlayer;
    Button musicButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musicButton = (Button)findViewById(R.id.btn_music);
        PlayMusic();
    }

    private void PlayMusic() {
        //获取音乐实例.
        mediaPlayer = MediaPlayer.create(this,R.raw.main_music);
        //设置循环播放.
        mediaPlayer.setLooping(true);
        //播放音乐.
        mediaPlayer.start();
    }

    public void OnPlay(View view) {
        startActivity(new Intent(MainActivity.this, SelectActivity.class));
    }

    public void OnAbout(View view) {
        startActivity(new Intent(MainActivity.this, AboutActivity.class));

    }

    public void OnMusic(View view) {
        if(playMusic) {
            if(mediaPlayer != null) {
                mediaPlayer.stop();
                musicButton.setBackgroundResource(R.drawable.btn_music2);
                playMusic = false;
            }
        }else {
            PlayMusic();
            playMusic = true;
            musicButton.setBackgroundResource(R.drawable.btn_music1);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (playMusic) {
            PlayMusic();
        }
    }
}
