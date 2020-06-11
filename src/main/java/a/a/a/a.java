package a.a.a;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Downloader */
public class a {
    private static final Uri g = Uri.parse("content://downloads/my_downloads");
    private static volatile a h;

    /* renamed from: a  reason: collision with root package name */
    private DownloadManager f2a;
    private String b = Environment.DIRECTORY_DOWNLOADS;
    /* access modifiers changed from: private */
    public c c;
    private c d;
    private final ContentObserver e = new C0000a(new Handler());
    private final BroadcastReceiver f = new b();

    /* renamed from: a.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: Downloader */
    class C0000a extends ContentObserver {
        C0000a(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z, Uri uri) {
            long j;
            super.onChange(z, uri);
            if (a.this.c != null && !"my_downloads".equals(uri.getLastPathSegment())) {
                try {
                    j = ContentUris.parseId(uri);
                } catch (Exception e) {
                    e.printStackTrace();
                    j = -1;
                }
                if (-1 != j) {
                    a.this.c.b(j);
                }
            }
        }
    }

    /* compiled from: Downloader */
    class b extends BroadcastReceiver {
        b() {
        }

        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && a.this.c != null && (action = intent.getAction()) != null) {
                if ("android.intent.action.DOWNLOAD_COMPLETE".equals(action)) {
                    long longExtra = intent.getLongExtra("extra_download_id", -1);
                    if (longExtra != -1) {
                        a.this.c.a(longExtra);
                    }
                } else if ("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED".equals(action)) {
                    long[] jArr = new long[0];
                    if (Build.VERSION.SDK_INT >= 11) {
                        jArr = intent.getLongArrayExtra("extra_click_download_ids");
                    }
                    if (jArr != null && jArr.length > 0) {
                        a.this.c.a(jArr);
                    }
                }
            }
        }
    }

    /* compiled from: Downloader */
    public interface c {
        void a(long j);

        void a(long... jArr);

        void b(long j);
    }

    private a(Context context) {
        this.f2a = (DownloadManager) context.getApplicationContext().getSystemService("download");
        this.d = c.b();
    }

    public static a c(Context context) {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a(context);
                }
            }
        }
        return h;
    }

    public a b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = Environment.DIRECTORY_DOWNLOADS;
        }
        this.b = str;
        return this;
    }

    public a a(c cVar) {
        this.c = cVar;
        return this;
    }

    public boolean b(Activity activity) {
        return this.d.a(activity);
    }

    public String[][] a(Activity activity) {
        return this.d.a((Context) activity);
    }

    public e b(long j) {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(j);
        Cursor query2 = this.f2a.query(query);
        if (query2 == null) {
            return null;
        }
        if (!query2.moveToFirst()) {
            query2.close();
            return null;
        }
        e a2 = a(query2);
        query2.close();
        return a2;
    }

    public boolean a(Activity activity, String str) {
        return this.d.a() && this.d.a(activity, str);
    }

    public long a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        DownloadManager.Request request = null;
        try {
            request = new DownloadManager.Request(Uri.parse(str));
        } catch (Exception unused) {
        }
        if (request != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                request.setNotificationVisibility(1);
                if (Build.VERSION.SDK_INT < 29) {
                    request.allowScanningByMediaScanner();
                }
            } else {
                request.setShowRunningNotification(true);
            }
            request.setTitle(str2);
            request.setDescription(str);
            if (str4 != null) {
                request.setMimeType(str4);
            }
            request.addRequestHeader("Cookie", CookieManager.getInstance().getCookie(str));
            if (str3 != null) {
                request.addRequestHeader("User-Agent", str3);
            }
            request.setDestinationInExternalPublicDir(this.b, str2);
            if (Build.VERSION.SDK_INT < 29) {
                request.setVisibleInDownloadsUi(true);
            }
        }
        try {
            return this.f2a.enqueue(request);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public a c(String str) {
        this.d.a(str);
        return this;
    }

    public void b(Context context) {
        try {
            context.getContentResolver().unregisterContentObserver(this.e);
            context.unregisterReceiver(this.f);
        } catch (Exception unused) {
        }
    }

    public List<e> a(String str) {
        String[] split = str.split(",");
        long[] jArr = new long[split.length];
        int i = 0;
        while (i < split.length) {
            try {
                jArr[i] = Long.valueOf(split[i]).longValue();
                i++;
            } catch (Exception unused) {
            }
        }
        return a(jArr);
    }

    public List<e> a(long... jArr) {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(jArr);
        Cursor query2 = this.f2a.query(query);
        ArrayList arrayList = new ArrayList();
        if (query2 == null) {
            return arrayList;
        }
        if (!query2.moveToFirst()) {
            query2.close();
            return arrayList;
        }
        do {
            arrayList.add(a(query2));
        } while (query2.moveToNext());
        query2.close();
        return arrayList;
    }

    private e a(Cursor cursor) {
        String str;
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        int i = cursor.getInt(cursor.getColumnIndex("status"));
        if (Build.VERSION.SDK_INT > 23) {
            String string = cursor.getString(cursor.getColumnIndex("local_uri"));
            str = string != null ? Uri.parse(string).getPath() : null;
        } else {
            str = cursor.getString(cursor.getColumnIndex("local_filename"));
        }
        return new e(j, i, cursor.getLong(cursor.getColumnIndex("bytes_so_far")), cursor.getLong(cursor.getColumnIndex("total_size")), str, cursor.getString(cursor.getColumnIndex("uri")));
    }

    public void a(long j) {
        try {
            this.f2a.remove(j);
        } catch (Exception unused) {
        }
    }

    public long a(e eVar) {
        long a2 = a(eVar.g(), eVar.b(), null, null);
        if (a2 != -1) {
            a(eVar.d());
        }
        return a2;
    }

    public void a(Context context) {
        try {
            context.getContentResolver().registerContentObserver(g, true, this.e);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
            intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
            context.registerReceiver(this.f, intentFilter);
        } catch (Exception unused) {
        }
    }
}
