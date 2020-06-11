package mark.via.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import timber.log.Timber;

/* renamed from: mark.via.k.a */
/* compiled from: BlockerReceiver */
public class BlockerReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private AbstractC0466a f1391a;

    /* renamed from: mark.via.k.a$a */
    /* compiled from: BlockerReceiver */
    public interface AbstractC0466a {
        /* renamed from: a */
        void mo1209a(String str);

        /* renamed from: b */
        void mo1210b(String str, boolean z);

        /* renamed from: c */
        void mo1211c();
    }

    public BlockerReceiver(AbstractC0466a aVar) {
        this.f1391a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action;
        if (intent != null && this.f1391a != null && (action = intent.getAction()) != null) {
            boolean z = true;
            Timber.m971a("Receiver action %s", action);
            if (action.equals("mark.via.fetching")) {
                String stringExtra = intent.getStringExtra("url");
                if (stringExtra != null) {
                    int intExtra = intent.getIntExtra("status", 0);
                    if (intExtra != -1) {
                        if (intExtra == 0) {
                            this.f1391a.mo1209a(stringExtra);
                            return;
                        } else if (intExtra != 1) {
                            return;
                        }
                    }
                    AbstractC0466a aVar = this.f1391a;
                    if (intExtra != 1) {
                        z = false;
                    }
                    aVar.mo1210b(stringExtra, z);
                }
            } else if (action.equals("mark.via.fetching")) {
                this.f1391a.mo1211c();
            }
        }
    }
}
