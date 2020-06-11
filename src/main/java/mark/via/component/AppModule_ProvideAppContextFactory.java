package mark.via.component;

import android.content.Context;
import dagger.internal.Preconditions;

/* renamed from: mark.via.f.c */
/* compiled from: AppModule_ProvideAppContextFactory */
public final class AppModule_ProvideAppContextFactory implements Object<Context> {

    /* renamed from: a */
    private final AppModule f1311a;

    public AppModule_ProvideAppContextFactory(AppModule bVar) {
        this.f1311a = bVar;
    }

    /* renamed from: a */
    public static AppModule_ProvideAppContextFactory m1638a(AppModule bVar) {
        return new AppModule_ProvideAppContextFactory(bVar);
    }

    /* renamed from: c */
    public static Context m1639c(AppModule bVar) {
        Context a = bVar.mo1008a();
        Preconditions.m124c(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    /* renamed from: b */
    public Context get() {
        return m1639c(this.f1311a);
    }
}
