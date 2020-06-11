package mark.via.component;

import android.content.Context;
import dagger.internal.Preconditions;
import mark.via.preference.PreferenceManager;
import p014d.p015a.Provider;

/* renamed from: mark.via.f.f */
/* compiled from: AppModule_ProvidePreferenceFactory */
public final class AppModule_ProvidePreferenceFactory implements Object<PreferenceManager> {

    /* renamed from: a */
    private final AppModule f1317a;

    /* renamed from: b */
    private final Provider<Context> f1318b;

    public AppModule_ProvidePreferenceFactory(AppModule bVar, Provider<Context> aVar) {
        this.f1317a = bVar;
        this.f1318b = aVar;
    }

    /* renamed from: a */
    public static AppModule_ProvidePreferenceFactory m1647a(AppModule bVar, Provider<Context> aVar) {
        return new AppModule_ProvidePreferenceFactory(bVar, aVar);
    }

    /* renamed from: c */
    public static PreferenceManager m1648c(AppModule bVar, Context context) {
        PreferenceManager d = bVar.mo1011d(context);
        Preconditions.m124c(d, "Cannot return null from a non-@Nullable @Provides method");
        return d;
    }

    /* renamed from: b */
    public PreferenceManager get() {
        return m1648c(this.f1317a, this.f1318b.get());
    }
}
