package com.kodesnippets.aaqib.alarm;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends Activity {
    Button b1, stop, start2, stop2;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    public static String INTENT_NAME="asdfas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);
        stop = (Button) findViewById(R.id.button);
        start2 = (Button) findViewById(R.id.start2);
        stop2 = (Button) findViewById(R.id.stop2);

        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startAlert();
            }
        });

        stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAlert();
            }
        });
        start2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlert();
            }
        });

        stop2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAlert();
            }
        });

    }

    public void startAlert() {
        EditText text = (EditText) findViewById(R.id.time);
        int i = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 10);
        calendar.set(Calendar.MINUTE, 40);
        TempModel tempModel = new TempModel();
        tempModel.setMessage("Nothing Special");
        tempModel.setName("Moosa");
        tempModel.setTime("1234123");
        intent.putExtra(INTENT_NAME, tempModel);
        pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        // alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
        //         + (i * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_LONG).show();

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), 60000, pendingIntent);

    }

    public void stopAlert() {

        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
            Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
        }


    }
}