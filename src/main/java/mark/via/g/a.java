package mark.via.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: BrowserBroadcastReceiver */
public class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private C0029a f253a;

    /* renamed from: mark.via.g.a$a  reason: collision with other inner class name */
    /* compiled from: BrowserBroadcastReceiver */
    public interface C0029a {
        void a(String str);
    }

    public a(C0029a aVar) {
        this.f253a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        C0029a aVar = this.f253a;
        if (aVar != null && intent != null) {
            aVar.a(intent.getAction());
        }
    }
}
