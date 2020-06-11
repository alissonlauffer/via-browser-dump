package mark.via.services;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import mark.via.gp.R;
import p000a.p001a.p002a.util.FilterUtils;
import timber.log.Timber;

@TargetApi(11)
public class BlockerService extends IntentService {

    /* renamed from: a */
    private HashSet<String> f1559a = new HashSet<>();

    public BlockerService() {
        super("Blocker");
    }

    /* renamed from: a */
    private void m2268a(String str, String str2) {
        if (!this.f1559a.contains(str)) {
            this.f1559a.add(str);
            int i = 1;
            Timber.m971a("Fetching started: %s", str);
            m2269b(str, 0);
            boolean c = FilterUtils.m98c(str, str2);
            Timber.m971a("Fetching finished(%s): %s", Boolean.valueOf(c), str);
            if (!c) {
                i = -1;
            }
            m2269b(str, i);
            this.f1559a.remove(str);
            if (this.f1559a.isEmpty()) {
                m2270c();
            }
        }
    }

    /* renamed from: b */
    private void m2269b(String str, int i) {
        Timber.m971a("Send fetching action(%d): %s", Integer.valueOf(i), str);
        Intent intent = new Intent("mark.via.fetching");
        intent.putExtra("url", str);
        intent.putExtra("status", i);
        sendBroadcast(intent);
    }

    /* renamed from: c */
    private void m2270c() {
        Timber.m971a("Send finished action", new Object[0]);
        Intent intent = new Intent("mark.via.fetching");
        intent.putExtra("status", 1);
        sendBroadcast(intent);
    }

    /* renamed from: d */
    public static void m2271d(Context context, String str, String str2) {
        Intent intent = new Intent(context, BlockerService.class);
        intent.putExtra("u", str);
        intent.putExtra("p", str2);
        context.startService(intent);
    }

    public void onCreate() {
        Notification notification;
        super.onCreate();
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            Notification.Builder builder = new Notification.Builder(this);
            builder.setContentTitle(getString(R.string.j_)).setSmallIcon(R.drawable.a2);
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("download", getString(R.string.d4), 3));
                builder.setChannelId("download");
                builder.setProgress(100, 50, true);
            }
            if (i < 16) {
                notification = builder.getNotification();
            } else {
                notification = builder.build();
            }
            startForeground(1, notification);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("u") && extras.containsKey("p")) {
            m2268a(extras.getString("u"), extras.getString("p"));
        }
    }
}
