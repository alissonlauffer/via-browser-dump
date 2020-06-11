package mark.via.handler;

import android.os.Handler;
import android.os.Message;

/* renamed from: mark.via.e.a */
/* compiled from: ClickHandler */
public class ClickHandler extends Handler {

    /* renamed from: a */
    private AbstractC0441a f1305a;

    /* renamed from: mark.via.e.a$a */
    /* compiled from: ClickHandler */
    public interface AbstractC0441a {
        /* renamed from: a */
        void mo965a(String str, String str2, String str3);
    }

    /* renamed from: a */
    public ClickHandler mo963a(AbstractC0441a aVar) {
        this.f1305a = aVar;
        return this;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f1305a != null && !message.getData().isEmpty()) {
            this.f1305a.mo965a(message.getData().getString("url"), message.getData().getString("src"), message.getData().getString("title"));
        }
    }
}
