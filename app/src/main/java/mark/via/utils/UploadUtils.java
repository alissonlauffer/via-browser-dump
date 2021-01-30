package mark.via.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.BrowserApp;
import mark.via.constants.Constants;
import mark.via.gp.R;

/* renamed from: mark.via.n.x */
/* compiled from: UploadUtils */
public class UploadUtils {

    /* renamed from: a */
    private final Context f1535a;

    /* renamed from: b */
    private final Activity f1536b;

    /* renamed from: c */
    private TaoDialog f1537c;

    /* renamed from: d */
    private AbstractC0505d f1538d;

    /* renamed from: e */
    private int f1539e = 0;

    /* renamed from: f */
    private HttpURLConnection f1540f;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: g */
    private final Handler f1541g = new HandlerC0503b();

    /* renamed from: h */
    private final Handler f1542h = new Handler();

    /* renamed from: i */
    private final Runnable f1543i = new RunnableC0504c();

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.n.x$a */
    /* compiled from: UploadUtils */
    public class RunnableC0502a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Map f1544a;

        /* renamed from: b */
        final /* synthetic */ String f1545b;

        RunnableC0502a(Map map, String str) {
            this.f1544a = map;
            this.f1545b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bytes = UploadUtils.m2209m(this.f1544a).toString().getBytes(Constants.f1299d);
            try {
                URL url = new URL(this.f1545b);
                UploadUtils.this.f1540f = (HttpURLConnection) url.openConnection();
                UploadUtils.this.f1540f.setConnectTimeout(3000);
                UploadUtils.this.f1540f.setDoInput(true);
                UploadUtils.this.f1540f.setDoOutput(true);
                UploadUtils.this.f1540f.setRequestMethod("POST");
                UploadUtils.this.f1540f.setUseCaches(false);
                UploadUtils.this.f1540f.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                UploadUtils.this.f1540f.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                UploadUtils.this.f1540f.getOutputStream().write(bytes);
                int responseCode = UploadUtils.this.f1540f.getResponseCode();
                Message message = new Message();
                message.what = 111;
                if (responseCode == 200) {
                    message.obj = "0";
                } else {
                    message.obj = "1";
                }
                UploadUtils.this.f1541g.sendMessage(message);
                if (UploadUtils.this.f1540f == null) {
                    return;
                }
            } catch (IOException unused) {
                if (UploadUtils.this.f1540f == null) {
                    return;
                }
            } catch (Throwable th) {
                if (UploadUtils.this.f1540f != null) {
                    UploadUtils.this.f1540f.disconnect();
                }
                throw th;
            }
            UploadUtils.this.f1540f.disconnect();
        }
    }

    /* renamed from: mark.via.n.x$b */
    /* compiled from: UploadUtils */
    class HandlerC0503b extends Handler {
        HandlerC0503b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            UploadUtils.this.f1537c.mo632i();
            if (message.what == 111) {
                int parseInt = Integer.parseInt((String) message.obj);
                if (parseInt != 0) {
                    if (parseInt != 2) {
                        QuickUtils.m1380l(UploadUtils.this.f1536b, UploadUtils.this.f1535a.getResources().getString(R.string.cr), UploadUtils.this.f1535a.getResources().getString(R.string.bp));
                    } else {
                        QuickUtils.m1380l(UploadUtils.this.f1536b, UploadUtils.this.f1535a.getResources().getString(R.string.cr), UploadUtils.this.f1535a.getResources().getString(R.string.bt));
                    }
                } else if (UploadUtils.this.f1538d != null) {
                    UploadUtils.this.f1538d.mo1317a();
                } else {
                    QuickUtils.m1380l(UploadUtils.this.f1536b, UploadUtils.this.f1535a.getResources().getString(R.string.cr), UploadUtils.this.f1535a.getResources().getString(R.string.ja));
                }
            }
        }
    }

    /* renamed from: mark.via.n.x$c */
    /* compiled from: UploadUtils */
    class RunnableC0504c implements Runnable {
        RunnableC0504c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UploadUtils.this.f1537c.mo634l()) {
                UploadUtils.m2206j(UploadUtils.this);
                if (UploadUtils.this.f1539e < 5) {
                    UploadUtils.this.f1542h.postDelayed(this, 1000);
                    return;
                }
                if (UploadUtils.this.f1540f != null) {
                    UploadUtils.this.f1540f.disconnect();
                }
                Message message = new Message();
                message.what = 111;
                message.obj = "2";
                UploadUtils.this.f1541g.sendMessage(message);
            }
        }
    }

    /* renamed from: mark.via.n.x$d */
    /* compiled from: UploadUtils */
    public interface AbstractC0505d {
        /* renamed from: a */
        void mo1317a();
    }

    public UploadUtils(Context context) {
        this.f1535a = context;
        this.f1536b = (Activity) context;
        m2208l();
    }

    /* renamed from: j */
    static /* synthetic */ int m2206j(UploadUtils xVar) {
        int i = xVar.f1539e;
        xVar.f1539e = i + 1;
        return i;
    }

    /* renamed from: l */
    private void m2208l() {
        TaoDialog g = TaoDialog.m1134g(this.f1535a);
        g.mo616H(R.string.iv);
        g.mo635m(false);
        g.mo636n(false);
        this.f1537c = g;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public static StringBuffer m2209m(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue());
                stringBuffer.append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    /* renamed from: o */
    private void m2210o(String str, Map<String, String> map) {
        BrowserApp.m1389c().execute(new RunnableC0502a(map, str));
    }

    /* renamed from: n */
    public void mo1312n(AbstractC0505d dVar) {
        this.f1538d = dVar;
    }

    /* renamed from: p */
    public void mo1313p(String str, Map<String, String> map) {
        if (BrowserUtils.m2095p(this.f1535a) != 0) {
            this.f1537c.mo622N();
            this.f1542h.postDelayed(this.f1543i, 1000);
            m2210o(str, map);
        }
    }
}
