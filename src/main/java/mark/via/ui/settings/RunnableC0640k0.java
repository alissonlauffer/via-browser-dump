package mark.via.ui.settings;

import java.io.InputStream;

/* renamed from: mark.via.ui.settings.k0 */
/* compiled from: lambda */
public final /* synthetic */ class RunnableC0640k0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings f1926a;

    /* renamed from: b */
    public final /* synthetic */ InputStream f1927b;

    public /* synthetic */ RunnableC0640k0(GeneralSettings generalSettings, InputStream inputStream) {
        this.f1926a = generalSettings;
        this.f1927b = inputStream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1926a.mo1495x0(this.f1927b);
    }
}
