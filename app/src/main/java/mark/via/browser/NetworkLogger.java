package mark.via.browser;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.via.adapter.LogItem;

/* renamed from: mark.via.browser.a0 */
/* compiled from: NetworkLogger */
public class NetworkLogger extends Handler {

    /* renamed from: a */
    private List<LogItem> f1204a = new ArrayList();

    /* renamed from: b */
    private int f1205b = -1;

    /* renamed from: c */
    private int f1206c;

    /* renamed from: d */
    private boolean f1207d = false;

    /* renamed from: e */
    private boolean f1208e = false;

    /* renamed from: f */
    private boolean f1209f;

    /* renamed from: g */
    private AbstractC0406a f1210g;

    /* renamed from: mark.via.browser.a0$a */
    /* compiled from: NetworkLogger */
    public interface AbstractC0406a {
        /* renamed from: a */
        void mo806a(boolean z);
    }

    /* renamed from: b */
    private void m1398b() {
        boolean z;
        AbstractC0406a aVar = this.f1210g;
        if (aVar != null && (z = this.f1208e) != this.f1207d) {
            this.f1207d = z;
            aVar.mo806a(z);
        }
    }

    /* renamed from: a */
    public void mo797a(int i) {
        this.f1204a.clear();
        this.f1205b = i;
        this.f1206c = i;
        this.f1208e = false;
        this.f1209f = false;
        m1398b();
    }

    /* renamed from: c */
    public boolean mo798c() {
        return this.f1208e;
    }

    /* renamed from: d */
    public int mo799d() {
        return this.f1205b;
    }

    /* renamed from: e */
    public List<LogItem> mo800e() {
        if (this.f1206c != this.f1205b) {
            return Collections.emptyList();
        }
        return this.f1204a;
    }

    /* renamed from: f */
    public void mo801f() {
        this.f1204a.clear();
        this.f1204a = null;
        this.f1208e = false;
        removeCallbacksAndMessages(null);
    }

    /* renamed from: g */
    public void mo802g(int i, String str, boolean z) {
        if (i == this.f1205b && str != null && !str.isEmpty()) {
            Message message = new Message();
            message.what = 1;
            message.obj = str;
            message.arg1 = z ? 1 : 0;
            sendMessage(message);
        }
    }

    /* renamed from: h */
    public NetworkLogger mo803h(AbstractC0406a aVar) {
        this.f1210g = aVar;
        return this;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            String str = (String) message.obj;
            boolean z = message.arg1 == 1;
            if (str != null && !str.isEmpty()) {
                LogItem cVar = new LogItem(str, z);
                if (!this.f1208e && cVar.mo954e()) {
                    this.f1208e = true;
                    this.f1209f = true;
                }
                this.f1204a.add(cVar);
            }
            m1398b();
        } else if (i != 2) {
            super.handleMessage(message);
        } else {
            removeMessages(1);
            this.f1204a.clear();
        }
    }

    /* renamed from: i */
    public void mo805i(int i) {
        this.f1206c = i;
        this.f1208e = i == this.f1205b && this.f1209f;
        m1398b();
    }
}
