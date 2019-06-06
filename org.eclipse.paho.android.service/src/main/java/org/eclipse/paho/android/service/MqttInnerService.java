package org.eclipse.paho.android.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MqttInnerService extends Service {
    public MqttInnerService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public void onCreate() {
        Log.i("MqttInnerService","MqttInnerService onCreate");
        super.onCreate();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {

        }else {
            startForeground(CommonUtil.NOTIFICATION_ID, new Notification());
            MqttInnerService.this.stopSelf();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("MqttInnerService","MqttInnerService onDestroy");
    }
}
