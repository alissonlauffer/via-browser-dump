package mark.via.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: mark.via.k.b */
/* compiled from: BrowserBroadcastReceiver */
public class BrowserBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private AbstractC0467a f1392a;

    /* renamed from: mark.via.k.b$a */
    /* compiled from: BrowserBroadcastReceiver */
    public interface AbstractC0467a {
        /* renamed from: a */
        void mo1213a(String str);
    }

    public BrowserBroadcastReceiver(AbstractC0467a aVar) {
        this.f1392a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        AbstractC0467a aVar = this.f1392a;
        if (aVar != null && intent != null) {
            aVar.mo1213a(intent.getAction());
        }
    }
}
