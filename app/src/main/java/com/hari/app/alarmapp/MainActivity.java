package com.hari.app.alarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText hh,mm;
    Button set;

    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hh=findViewById(R.id.hh);
        mm=findViewById(R.id.mm);
        set=findViewById(R.id.set);

        alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);

        final Calendar calendar = Calendar.getInstance();

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hh.getText().toString()));
                calendar.set(Calendar.MINUTE, Integer.parseInt(mm.getText().toString()));

                Intent sendAlarm = new Intent(MainActivity.this,AlarmReceiver.class);

                pendingIntent = PendingIntent.getBroadcast(MainActivity.this,99,sendAlarm,0);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

                Toast.makeText(MainActivity.this,"SENT alarm for "+calendar.getTime().toString(),Toast.LENGTH_SHORT).show();

                /*PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this,99,sendAlarm,0);
                pendingIntent2.cancel();*/
                        // 7am 7.30am 8am
                // Realm db - requestCode - uniqueID for each alarm
                //
            }
        });
    }
}
