package com.kodesnippets.aaqib.alarm;

/**
 * Created by silen on 4/24/2016.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;


public class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        TempModel tempModel = intent.getParcelableExtra(MainActivity.INTENT_NAME);
        mp = MediaPlayer.create(context, R.raw.alrm);
        mp.start();
        Toast.makeText(context, "Alarm...."+tempModel.getMessage(), Toast.LENGTH_LONG).show();
        Log.d("Test","Chalbhae");
    }
}