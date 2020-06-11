package mark.via.c;

import android.os.Handler;
import android.os.Message;

/* compiled from: ClickHandler */
public class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private C0026a f246a;

    /* renamed from: mark.via.c.a$a  reason: collision with other inner class name */
    /* compiled from: ClickHandler */
    public interface C0026a {
        void a(String str, String str2, String str3);
    }

    public a a(C0026a aVar) {
        this.f246a = aVar;
        return this;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f246a != null && !message.getData().isEmpty()) {
            this.f246a.a(message.getData().getString("url"), message.getData().getString("src"), message.getData().getString("title"));
        }
    }
}
