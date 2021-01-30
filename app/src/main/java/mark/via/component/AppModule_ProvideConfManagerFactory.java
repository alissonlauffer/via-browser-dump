package mark.via.component;

import android.content.Context;
import dagger.internal.Preconditions;
import mark.via.p042l.ConfManager;
import p014d.p015a.Provider;

/* renamed from: mark.via.f.e */
/* compiled from: AppModule_ProvideConfManagerFactory */
public final class AppModule_ProvideConfManagerFactory implements Object<ConfManager> {

    /* renamed from: a */
    private final AppModule f1315a;

    /* renamed from: b */
    private final Provider<Context> f1316b;

    public AppModule_ProvideConfManagerFactory(AppModule bVar, Provider<Context> aVar) {
        this.f1315a = bVar;
        this.f1316b = aVar;
    }

    /* renamed from: a */
    public static AppModule_ProvideConfManagerFactory m1644a(AppModule bVar, Provider<Context> aVar) {
        return new AppModule_ProvideConfManagerFactory(bVar, aVar);
    }

    /* renamed from: c */
    public static ConfManager m1645c(AppModule bVar, Context context) {
        ConfManager c = bVar.mo1010c(context);
        Preconditions.m124c(c, "Cannot return null from a non-@Nullable @Provides method");
        return c;
    }

    /* renamed from: b */
    public ConfManager get() {
        return m1645c(this.f1315a, this.f1316b.get());
    }
}
