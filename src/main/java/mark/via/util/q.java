package mark.via.util;

import a.a.b.i.g;
import a.a.b.p.e;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import mark.via.BrowserApp;
import mark.via.gp.R;

/* compiled from: UploadUtils */
public class q {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f490a;
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
    @SuppressLint({"HandlerLeak"})
    public final Handler g = new b();
    /* access modifiers changed from: private */
    public final Handler h = new Handler();
    private final Runnable i = new c();

    /* compiled from: UploadUtils */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f491a;
        final /* synthetic */ String b;

        a(Map map, String str) {
            this.f491a = map;
            this.b = str;
        }

        public void run() {
            byte[] bytes = q.b(this.f491a).toString().getBytes(mark.via.b.a.d);
            try {
                HttpURLConnection unused = q.this.f = (HttpURLConnection) new URL(this.b).openConnection();
                q.this.f.setConnectTimeout(3000);
                q.this.f.setDoInput(true);
                q.this.f.setDoOutput(true);
                q.this.f.setRequestMethod("POST");
                q.this.f.setUseCaches(false);
                q.this.f.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                q.this.f.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                q.this.f.getOutputStream().write(bytes);
                int responseCode = q.this.f.getResponseCode();
                Message message = new Message();
                message.what = 111;
                if (responseCode == 200) {
                    message.obj = "0";
                } else {
                    message.obj = "1";
                }
                q.this.g.sendMessage(message);
                if (q.this.f == null) {
                    return;
                }
            } catch (IOException unused2) {
                if (q.this.f == null) {
                    return;
                }
            } catch (Throwable th) {
                if (q.this.f != null) {
                    q.this.f.disconnect();
                }
                throw th;
            }
            q.this.f.disconnect();
        }
    }

    /* compiled from: UploadUtils */
    class b extends Handler {
        b() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            q.this.c.c();
            if (message.what == 111) {
                int parseInt = Integer.parseInt((String) message.obj);
                if (parseInt != 0) {
                    if (parseInt != 2) {
                        e.b(q.this.b, q.this.f490a.getResources().getString(R.string.cl), q.this.f490a.getResources().getString(R.string.bn));
                    } else {
                        e.b(q.this.b, q.this.f490a.getResources().getString(R.string.cl), q.this.f490a.getResources().getString(R.string.br));
                    }
                } else if (q.this.d != null) {
                    q.this.d.a();
                } else {
                    e.b(q.this.b, q.this.f490a.getResources().getString(R.string.cl), q.this.f490a.getResources().getString(R.string.ik));
                }
            }
        }
    }

    /* compiled from: UploadUtils */
    class c implements Runnable {
        c() {
        }

        public void run() {
            if (q.this.c.f()) {
                q.h(q.this);
                if (q.this.e < 5) {
                    q.this.h.postDelayed(this, 1000);
                    return;
                }
                if (q.this.f != null) {
                    q.this.f.disconnect();
                }
                Message message = new Message();
                message.what = 111;
                message.obj = "2";
                q.this.g.sendMessage(message);
            }
        }
    }

    /* compiled from: UploadUtils */
    public interface d {
        void a();
    }

    public q(Context context) {
        this.f490a = context;
        this.b = (Activity) context;
        a();
    }

    static /* synthetic */ int h(q qVar) {
        int i2 = qVar.e;
        qVar.e = i2 + 1;
        return i2;
    }

    private void b(String str, Map<String, String> map) {
        BrowserApp.b().execute(new a(map, str));
    }

    /* access modifiers changed from: private */
    public static StringBuffer b(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue());
                stringBuffer.append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return stringBuffer;
    }

    private void a() {
        g gVar = new g(this.f490a);
        gVar.c(R.string.i_);
        gVar.b(false);
        g gVar2 = gVar;
        gVar2.c(false);
        this.c = gVar2;
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public void a(String str, Map<String, String> map) {
        if (b.g(this.f490a) != 0) {
            this.c.g();
            this.h.postDelayed(this.i, 1000);
            b(str, map);
        }
    }
}
