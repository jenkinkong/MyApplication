package com.umeng.myapplication.recevier;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

import com.umeng.myapplication.MainActivity;
import com.umeng.myapplication.R;

public class AlarmRecevier extends BroadcastReceiver {

    private Vibrator vibrator;
    public static final String ALARM_ACTION = "com.umeng.application";
    private static final int NOTIFICATION_FLAG = 3;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String msg = intent.getStringExtra("msg");
        int ring = intent.getIntExtra("ringType", 0);
        long timeInMillis = intent.getLongExtra("timeInMillis", 0);
//        if (intervalMillis != 0) {
//            AlarmManagerUtil.setAlarmTime(context, System.currentTimeMillis() + intervalMillis,
//                    intent);
//        }
        int flag = intent.getIntExtra("soundOrVibrator", 0);
        int id = intent.getIntExtra("id", 0);
//        到时间弹出闹钟
//        Intent clockIntent = new Intent(context, ClockAlarmActivity.class);
//        clockIntent.putExtra("msg", msg);
//        clockIntent.putExtra("flag", flag);
//        clockIntent.putExtra("ringType", ring);
//        clockIntent.putExtra("id", id);
//        clockIntent.putExtra("timeInMillis", timeInMillis);
//        clockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(clockIntent);

        Intent intent1 = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent1, 0);
        Notification notify = new Notification.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher) // 设置状态栏中的小图片，尺寸一般建议在24×24
//                    .setLargeIcon(bitmap) // 这里也可以设置大图标
                .setTicker("参与红包") // 设置显示的提示文字
                .setContentTitle("发红包啦") // 设置显示的标题
                .setContentText("来御财抢红包") // 消息的详细内容
                .setContentIntent(pendingIntent) // 关联PendingIntent
                .setNumber(1) // 在TextView的右方显示的数字，可以在外部定义一个变量，点击累加setNumber(count),这时显示的和
//                    .getNotification(); // 需要注意build()是在API level16及之后增加的，在API11中可以使用getNotificatin()来
                .build();
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_FLAG, notify);

    }
}
