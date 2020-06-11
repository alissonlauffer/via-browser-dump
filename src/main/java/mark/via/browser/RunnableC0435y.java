package mark.via.browser;

import android.webkit.PermissionRequest;

/* renamed from: mark.via.browser.y */
/* compiled from: lambda */
public final /* synthetic */ class RunnableC0435y implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ PermissionRequest f1260a;

    public /* synthetic */ RunnableC0435y(PermissionRequest permissionRequest) {
        this.f1260a = permissionRequest;
    }

    public final void run() {
        this.f1260a.deny();
    }
}
