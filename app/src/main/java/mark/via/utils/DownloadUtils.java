package mark.via.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.BrowserApp;
import mark.via.constants.Constants;
import mark.via.gp.R;

/* renamed from: mark.via.n.i */
/* compiled from: DownloadUtils */
public class DownloadUtils {

    /* renamed from: a */
    private final Context f1516a;

    /* renamed from: b */
    private final Activity f1517b;

    /* renamed from: c */
    private TaoDialog f1518c;

    /* renamed from: d */
    private AbstractC0499d f1519d;

    /* renamed from: e */
    private int f1520e = 0;

    /* renamed from: f */
    private HttpURLConnection f1521f;

    /* renamed from: g */
    private int f1522g;

    /* renamed from: h */
    private String f1523h;

    /* renamed from: i */
    private boolean f1524i;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: j */
    private final Handler f1525j = new HandlerC0497b();

    /* renamed from: k */
    private final Handler f1526k = new Handler();

    /* renamed from: l */
    private final Runnable f1527l = new RunnableC0498c();

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.n.i$a */
    /* compiled from: DownloadUtils */
    public class RunnableC0496a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f1528a;

        RunnableC0496a(String str) {
            this.f1528a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                URL url = new URL(this.f1528a);
                DownloadUtils.this.f1521f = (HttpURLConnection) url.openConnection();
                DownloadUtils.this.f1521f.setRequestMethod("GET");
                DownloadUtils.this.f1521f.setReadTimeout((DownloadUtils.this.f1522g - 1) * 1000);
                if (DownloadUtils.this.f1521f.getResponseCode() == 200) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(DownloadUtils.this.f1521f.getInputStream(), Constants.f1299d));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    DownloadUtils.this.f1523h = new String(sb.toString().getBytes(Constants.f1299d), Constants.f1300e);
                    Message message = new Message();
                    message.what = 111;
                    message.obj = DownloadUtils.this.f1523h;
                    DownloadUtils.this.f1525j.sendMessage(message);
                } else {
                    Message message2 = new Message();
                    message2.what = 112;
                    message2.obj = "";
                    DownloadUtils.this.f1525j.sendMessage(message2);
                }
                if (DownloadUtils.this.f1521f == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (DownloadUtils.this.f1521f == null) {
                    return;
                }
            } catch (Throwable th) {
                if (DownloadUtils.this.f1521f != null) {
                    DownloadUtils.this.f1521f.disconnect();
                }
                throw th;
            }
            DownloadUtils.this.f1521f.disconnect();
        }
    }

    /* renamed from: mark.via.n.i$b */
    /* compiled from: DownloadUtils */
    class HandlerC0497b extends Handler {
        HandlerC0497b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (DownloadUtils.this.f1524i) {
                DownloadUtils.this.f1518c.mo632i();
            }
            switch (message.what) {
                case 111:
                    if (DownloadUtils.this.f1519d != null) {
                        DownloadUtils iVar = DownloadUtils.this;
                        iVar.f1523h = iVar.f1523h.trim().replaceAll("<meta.*?>", "").trim();
                        DownloadUtils.this.f1519d.mo1311a(DownloadUtils.this.f1523h);
                        return;
                    } else if (DownloadUtils.this.f1524i) {
                        QuickUtils.m1380l(DownloadUtils.this.f1517b, DownloadUtils.this.f1516a.getResources().getString(R.string.cr), DownloadUtils.this.f1516a.getResources().getString(R.string.it));
                        return;
                    } else {
                        return;
                    }
                case 112:
                    if (DownloadUtils.this.f1524i) {
                        QuickUtils.m1380l(DownloadUtils.this.f1517b, DownloadUtils.this.f1516a.getResources().getString(R.string.cr), DownloadUtils.this.f1516a.getResources().getString(R.string.bp));
                        return;
                    }
                    return;
                case 113:
                    if (DownloadUtils.this.f1524i) {
                        QuickUtils.m1380l(DownloadUtils.this.f1517b, DownloadUtils.this.f1516a.getResources().getString(R.string.cr), DownloadUtils.this.f1516a.getResources().getString(R.string.bt));
                        return;
                    }
                    return;
                case 114:
                    QuickUtils.m1382n(DownloadUtils.this.f1516a, R.string.fr);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: mark.via.n.i$c */
    /* compiled from: DownloadUtils */
    class RunnableC0498c implements Runnable {
        RunnableC0498c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DownloadUtils.this.f1524i && DownloadUtils.this.f1518c.mo634l()) {
                DownloadUtils.m2132n(DownloadUtils.this);
                if (DownloadUtils.this.f1520e < DownloadUtils.this.f1522g) {
                    DownloadUtils.this.f1526k.postDelayed(this, 1000);
                    return;
                }
                if (DownloadUtils.this.f1521f != null) {
                    DownloadUtils.this.f1521f.disconnect();
                }
                Message message = new Message();
                message.what = 113;
                message.obj = "";
                DownloadUtils.this.f1525j.sendMessage(message);
            }
        }
    }

    /* renamed from: mark.via.n.i$d */
    /* compiled from: DownloadUtils */
    public interface AbstractC0499d {
        /* renamed from: a */
        void mo1311a(String str);
    }

    public DownloadUtils(Context context) {
        this.f1516a = context;
        this.f1517b = (Activity) context;
        this.f1524i = true;
        m2133p();
        this.f1522g = 8;
    }

    /* renamed from: n */
    static /* synthetic */ int m2132n(DownloadUtils iVar) {
        int i = iVar.f1520e;
        iVar.f1520e = i + 1;
        return i;
    }

    /* renamed from: p */
    private void m2133p() {
        TaoDialog g = TaoDialog.m1134g(this.f1516a);
        g.mo616H(R.string.iv);
        g.mo635m(false);
        g.mo636n(false);
        this.f1518c = g;
    }

    /* renamed from: s */
    private void m2134s(String str) {
        BrowserApp.m1389c().execute(new RunnableC0496a(str));
    }

    /* renamed from: o */
    public void mo1305o(String str) {
        if (BrowserUtils.m2095p(this.f1516a) != 0) {
            if (this.f1524i) {
                this.f1518c.mo622N();
            }
            this.f1526k.postDelayed(this.f1527l, 1000);
            m2134s(str);
            return;
        }
        Message message = new Message();
        message.what = 113;
        message.obj = "";
        this.f1525j.sendMessage(message);
    }

    /* renamed from: q */
    public void mo1306q(boolean z) {
        this.f1524i = z;
        if (z) {
            this.f1522g = 8;
        } else {
            this.f1522g = 10;
        }
    }

    /* renamed from: r */
    public void mo1307r(AbstractC0499d dVar) {
        this.f1519d = dVar;
    }
}
