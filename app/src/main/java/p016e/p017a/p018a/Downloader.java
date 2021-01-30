package p016e.p017a.p018a;

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

/* renamed from: e.a.a.a */
/* compiled from: Downloader */
public class Downloader {

    /* renamed from: g */
    private static final Uri f914g = Uri.parse("content://downloads/my_downloads");

    /* renamed from: h */
    private static volatile Downloader f915h;

    /* renamed from: a */
    private DownloadManager f916a;

    /* renamed from: b */
    private String f917b = Environment.DIRECTORY_DOWNLOADS;

    /* renamed from: c */
    private AbstractC0337c f918c;

    /* renamed from: d */
    private ExtraDownloader f919d;

    /* renamed from: e */
    private final ContentObserver f920e = new C0335a(new Handler());

    /* renamed from: f */
    private final BroadcastReceiver f921f = new C0336b();

    /* renamed from: e.a.a.a$a */
    /* compiled from: Downloader */
    class C0335a extends ContentObserver {
        C0335a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            long j;
            super.onChange(z, uri);
            if (Downloader.this.f918c != null && !"my_downloads".equals(uri.getLastPathSegment())) {
                try {
                    j = ContentUris.parseId(uri);
                } catch (Exception e) {
                    e.printStackTrace();
                    j = -1;
                }
                if (-1 != j) {
                    Downloader.this.f918c.mo398a(j);
                }
            }
        }
    }

    /* renamed from: e.a.a.a$b */
    /* compiled from: Downloader */
    class C0336b extends BroadcastReceiver {
        C0336b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && Downloader.this.f918c != null && (action = intent.getAction()) != null) {
                if ("android.intent.action.DOWNLOAD_COMPLETE".equals(action)) {
                    long longExtra = intent.getLongExtra("extra_download_id", -1);
                    if (longExtra != -1) {
                        Downloader.this.f918c.mo399b(longExtra);
                    }
                } else if ("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED".equals(action)) {
                    long[] jArr = new long[0];
                    if (Build.VERSION.SDK_INT >= 11) {
                        jArr = intent.getLongArrayExtra("extra_click_download_ids");
                    }
                    if (jArr != null && jArr.length > 0) {
                        Downloader.this.f918c.mo400c(jArr);
                    }
                }
            }
        }
    }

    /* renamed from: e.a.a.a$c */
    /* compiled from: Downloader */
    public interface AbstractC0337c {
        /* renamed from: a */
        void mo398a(long j);

        /* renamed from: b */
        void mo399b(long j);

        /* renamed from: c */
        void mo400c(long... jArr);
    }

    private Downloader(Context context) {
        this.f916a = (DownloadManager) context.getApplicationContext().getSystemService("download");
        this.f919d = ExtraDownloader.m940c();
    }

    /* renamed from: e */
    public static Downloader m919e(Context context) {
        if (f915h == null) {
            synchronized (Downloader.class) {
                if (f915h == null) {
                    f915h = new Downloader(context);
                }
            }
        }
        return f915h;
    }

    /* renamed from: f */
    private Task m920f(Cursor cursor) {
        String str;
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        int i = cursor.getInt(cursor.getColumnIndex("status"));
        if (Build.VERSION.SDK_INT > 23) {
            String string = cursor.getString(cursor.getColumnIndex("local_uri"));
            str = string != null ? Uri.parse(string).getPath() : null;
        } else {
            str = cursor.getString(cursor.getColumnIndex("local_filename"));
        }
        return new Task(j, i, cursor.getLong(cursor.getColumnIndex("bytes_so_far")), cursor.getLong(cursor.getColumnIndex("total_size")), str, cursor.getString(cursor.getColumnIndex("uri")));
    }

    /* renamed from: b */
    public void mo382b(long j) {
        try {
            this.f916a.remove(j);
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public long mo383c(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        DownloadManager.Request request = null;
        try {
            request = new DownloadManager.Request(Uri.parse(str));
        } catch (Exception unused) {
        }
        if (request != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 11) {
                request.setNotificationVisibility(1);
                if (i < 29) {
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
            request.setDestinationInExternalPublicDir(this.f917b, str2);
            if (i < 29) {
                request.setVisibleInDownloadsUi(true);
            }
        }
        try {
            return this.f916a.enqueue(request);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: d */
    public String[][] mo384d(Activity activity) {
        return this.f919d.mo402b(activity);
    }

    /* renamed from: g */
    public boolean mo385g(Activity activity) {
        return this.f919d.mo404e(activity);
    }

    /* renamed from: h */
    public List<Task> mo386h(String str) {
        String[] split = str.split(",");
        long[] jArr = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                jArr[i] = Long.valueOf(split[i]).longValue();
            } catch (Exception unused) {
            }
        }
        return mo387i(jArr);
    }

    /* renamed from: i */
    public List<Task> mo387i(long... jArr) {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(jArr);
        Cursor query2 = this.f916a.query(query);
        ArrayList arrayList = new ArrayList();
        if (query2 == null) {
            return arrayList;
        }
        if (!query2.moveToFirst()) {
            query2.close();
            return arrayList;
        }
        do {
            arrayList.add(m920f(query2));
        } while (query2.moveToNext());
        query2.close();
        return arrayList;
    }

    /* renamed from: j */
    public Task mo388j(long j) {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(j);
        Cursor query2 = this.f916a.query(query);
        if (query2 == null) {
            return null;
        }
        if (!query2.moveToFirst()) {
            query2.close();
            return null;
        }
        Task f = m920f(query2);
        query2.close();
        return f;
    }

    /* renamed from: k */
    public long mo389k(Task eVar) {
        long c = mo383c(eVar.mo413g(), eVar.mo407b(), null, null);
        if (c != -1) {
            mo382b(eVar.mo409d());
        }
        return c;
    }

    /* renamed from: l */
    public void mo390l(Context context) {
        try {
            context.getContentResolver().registerContentObserver(f914g, true, this.f920e);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
            intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
            context.registerReceiver(this.f921f, intentFilter);
        } catch (Exception unused) {
        }
    }

    /* renamed from: m */
    public Downloader mo391m(AbstractC0337c cVar) {
        this.f918c = cVar;
        return this;
    }

    /* renamed from: n */
    public Downloader mo392n(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this;
        }
        if (TextUtils.isEmpty(str)) {
            str = Environment.DIRECTORY_DOWNLOADS;
        }
        this.f917b = str;
        return this;
    }

    /* renamed from: o */
    public Downloader mo393o(String str) {
        this.f919d.mo405f(str);
        return this;
    }

    /* renamed from: p */
    public void mo394p(Context context) {
        try {
            context.getContentResolver().unregisterContentObserver(this.f920e);
            context.unregisterReceiver(this.f921f);
        } catch (Exception unused) {
        }
    }

    /* renamed from: q */
    public boolean mo395q(Activity activity, String str) {
        return this.f919d.mo403d() && this.f919d.mo401a(activity, str);
    }
}
