package mark.via.component;

import android.content.Context;
import dagger.internal.Preconditions;
import mark.via.preference.PreferenceManager;
import p000a.p001a.p002a.Blocker;
import p014d.p015a.Provider;

/* renamed from: mark.via.f.d */
/* compiled from: AppModule_ProvideBlockerFactory */
public final class AppModule_ProvideBlockerFactory implements Object<Blocker> {

    /* renamed from: a */
    private final AppModule f1312a;

    /* renamed from: b */
    private final Provider<Context> f1313b;

    /* renamed from: c */
    private final Provider<PreferenceManager> f1314c;

    public AppModule_ProvideBlockerFactory(AppModule bVar, Provider<Context> aVar, Provider<PreferenceManager> aVar2) {
        this.f1312a = bVar;
        this.f1313b = aVar;
        this.f1314c = aVar2;
    }

    /* renamed from: a */
    public static AppModule_ProvideBlockerFactory m1641a(AppModule bVar, Provider<Context> aVar, Provider<PreferenceManager> aVar2) {
        return new AppModule_ProvideBlockerFactory(bVar, aVar, aVar2);
    }

    /* renamed from: c */
    public static Blocker m1642c(AppModule bVar, Context context, PreferenceManager aVar) {
        Blocker b = bVar.mo1009b(context, aVar);
        Preconditions.m124c(b, "Cannot return null from a non-@Nullable @Provides method");
        return b;
    }

    /* renamed from: b */
    public Blocker get() {
        return m1642c(this.f1312a, this.f1313b.get(), this.f1314c.get());
    }
}
