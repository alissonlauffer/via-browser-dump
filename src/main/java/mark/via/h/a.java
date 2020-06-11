package mark.via.h;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;
import mark.via.a.c;

/* compiled from: NetworkLogger */
public class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private List<c> f254a = new ArrayList();
    private int b = -1;
    private boolean c = false;
    private C0030a d;

    /* renamed from: mark.via.h.a$a  reason: collision with other inner class name */
    /* compiled from: NetworkLogger */
    public interface C0030a {
        void a();
    }

    public a a(C0030a aVar) {
        this.d = aVar;
        return this;
    }

    public int b() {
        return this.b;
    }

    public List<c> c() {
        return this.f254a;
    }

    public void d() {
        this.f254a.clear();
        this.f254a = null;
        this.c = false;
        removeCallbacksAndMessages(null);
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            String str = (String) message.obj;
            boolean z = message.arg1 == 1;
            if (str != null && !str.isEmpty()) {
                c cVar = new c(str, z);
                if (!this.c && cVar.e()) {
                    this.c = true;
                    C0030a aVar = this.d;
                    if (aVar != null) {
                        aVar.a();
                    }
                }
                this.f254a.add(cVar);
            }
        } else if (i != 2) {
            super.handleMessage(message);
        } else {
            removeMessages(1);
            this.f254a.clear();
        }
    }

    public void a(int i) {
        sendMessage(obtainMessage(2));
        this.b = i;
        this.c = false;
    }

    public void a(int i, String str, boolean z) {
        if (i == this.b && str != null && !str.isEmpty()) {
            Message message = new Message();
            message.what = 1;
            message.obj = str;
            message.arg1 = z ? 1 : 0;
            sendMessage(message);
        }
    }

    public boolean a() {
        return this.c;
    }
}
