package mark.via.component;

import android.app.Application;
import android.content.Context;
import mark.via.p042l.ConfManager;
import mark.via.p042l.p043d.ConfDbHelper;
import mark.via.preference.PreferenceManager;
import mark.via.utils.FileUtils;
import p000a.p001a.p002a.Blocker;

/* renamed from: mark.via.f.b */
/* compiled from: AppModule */
public class AppModule {

    /* renamed from: a */
    private final Context f1310a;

    public AppModule(Application application) {
        this.f1310a = application;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Context mo1008a() {
        return this.f1310a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Blocker mo1009b(Context context, PreferenceManager aVar) {
        return Blocker.m3k(context, FileUtils.m2155k(context, "custom.txt"), FileUtils.m2155k(context, "subscribed.txt"), aVar.mo1163l());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ConfManager mo1010c(Context context) {
        return new ConfManager(new ConfDbHelper(context));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public PreferenceManager mo1011d(Context context) {
        return PreferenceManager.m1743M(context);
    }
}
