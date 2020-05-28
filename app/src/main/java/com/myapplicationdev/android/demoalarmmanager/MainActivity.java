package com.myapplicationdev.android.demoalarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnAlarm;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlarm = findViewById(R.id.btnAlarm);

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND,5);
                //Create a new PendingIntent and add it to the Alarm Manager
                Intent intent = new Intent(MainActivity.this,AlarmReceiverActivity.class);
                int reqCode = 12345;
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,reqCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                //Get AlarmManager instance
                am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                //Set Alarm
                am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);
            }
        });
    }
}
