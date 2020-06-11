package mark.via.util;

import a.a.b.i.g;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import mark.via.BrowserApp;
import mark.via.gp.R;

/* compiled from: DownloadUtils */
public class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f481a;
    /* access modifiers changed from: private */
    public final Activity b;
    /* access modifiers changed from: private */
    public g c;
    /* access modifiers changed from: private */
    public d d;
    /* access modifiers changed from: private */
    public int e = 0;
    /* access modifiers changed from: private */
    public HttpURLConnection f;
    /* access modifiers changed from: private */
    public int g;
    /* access modifiers changed from: private */
    public String h;
    /* access modifiers changed from: private */
    public boolean i;
    /* access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    public final Handler j = new b();
    /* access modifiers changed from: private */
    public final Handler k = new Handler();
    private final Runnable l = new c();

    /* compiled from: DownloadUtils */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f482a;

        a(String str) {
            this.f482a = str;
        }

        public void run() {
            try {
                HttpURLConnection unused = e.this.f = (HttpURLConnection) new URL(this.f482a).openConnection();
                e.this.f.setRequestMethod("GET");
                e.this.f.setReadTimeout((e.this.g - 1) * 1000);
                if (e.this.f.getResponseCode() == 200) {
                    a.a.b.p.d.a("success");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(e.this.f.getInputStream(), mark.via.b.a.d));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    String unused2 = e.this.h = new String(sb.toString().getBytes(mark.via.b.a.d), mark.via.b.a.e);
                    Message message = new Message();
                    message.what = 111;
                    message.obj = e.this.h;
                    e.this.j.sendMessage(message);
                } else {
                    a.a.b.p.d.a("failed");
                    Message message2 = new Message();
                    message2.what = 112;
                    message2.obj = "";
                    e.this.j.sendMessage(message2);
                }
                if (e.this.f == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (e.this.f == null) {
                    return;
                }
            } catch (Throwable th) {
                if (e.this.f != null) {
                    e.this.f.disconnect();
                }
                throw th;
            }
            e.this.f.disconnect();
        }
    }

    /* compiled from: DownloadUtils */
    class b extends Handler {
        b() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (e.this.i) {
                e.this.c.c();
            }
            switch (message.what) {
                case 111:
                    if (e.this.d != null) {
                        e eVar = e.this;
                        String unused = eVar.h = eVar.h.trim().replaceAll("<meta.*?>", "").trim();
                        e.this.d.a(e.this.h);
                        return;
                    } else if (e.this.i) {
                        a.a.b.p.e.b(e.this.b, e.this.f481a.getResources().getString(R.string.cl), e.this.f481a.getResources().getString(R.string.i8));
                        return;
                    } else {
                        return;
                    }
                case 112:
                    if (e.this.i) {
                        a.a.b.p.e.b(e.this.b, e.this.f481a.getResources().getString(R.string.cl), e.this.f481a.getResources().getString(R.string.bn));
                        return;
                    }
                    return;
                case 113:
                    if (e.this.i) {
                        a.a.b.p.e.b(e.this.b, e.this.f481a.getResources().getString(R.string.cl), e.this.f481a.getResources().getString(R.string.br));
                        return;
                    }
                    return;
                case 114:
                    a.a.b.p.e.a(e.this.f481a, (int) R.string.f8);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: DownloadUtils */
    class c implements Runnable {
        c() {
        }

        public void run() {
            if (e.this.i && e.this.c.f()) {
                e.l(e.this);
                if (e.this.e < e.this.g) {
                    e.this.k.postDelayed(this, 1000);
                    return;
                }
                if (e.this.f != null) {
                    e.this.f.disconnect();
                }
                Message message = new Message();
                message.what = 113;
                message.obj = "";
                e.this.j.sendMessage(message);
            }
        }
    }

    /* compiled from: DownloadUtils */
    public interface d {
        void a(String str);
    }

    public e(Context context) {
        this.f481a = context;
        this.b = (Activity) context;
        this.i = true;
        a();
        this.g = 8;
    }

    static /* synthetic */ int l(e eVar) {
        int i2 = eVar.e;
        eVar.e = i2 + 1;
        return i2;
    }

    private void b(String str) {
        BrowserApp.b().execute(new a(str));
    }

    public void a(boolean z) {
        this.i = z;
        if (z) {
            this.g = 8;
        } else {
            this.g = 10;
        }
    }

    private void a() {
        g gVar = new g(this.f481a);
        gVar.c(R.string.i_);
        gVar.b(false);
        g gVar2 = gVar;
        gVar2.c(false);
        this.c = gVar2;
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public void a(String str) {
        a.a.b.p.d.a("fetching:", str);
        if (b.g(this.f481a) != 0) {
            if (this.i) {
                this.c.g();
            }
            this.k.postDelayed(this.l, 1000);
            b(str);
            return;
        }
        Message message = new Message();
        message.what = 113;
        message.obj = "";
        this.j.sendMessage(message);
    }
}
