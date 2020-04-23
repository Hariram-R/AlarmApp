package com.hari.app.alarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    Button dismiss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        mediaPlayer=MediaPlayer.create(getBaseContext(),getAlarmUri());
        mediaPlayer.start();

        dismiss=findViewById(R.id.dismiss);

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                AlarmActivity.this.finish();
            }
        });


    }

    private Uri getAlarmUri() {
        return RingtoneManager.getActualDefaultRingtoneUri(this, RingtoneManager.TYPE_RINGTONE);
    }
}
