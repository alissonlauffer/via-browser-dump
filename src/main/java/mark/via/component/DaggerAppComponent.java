package mark.via.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import mark.via.p042l.ConfManager;
import mark.via.preference.PreferenceManager;
import p000a.p001a.p002a.Blocker;
import p014d.p015a.Provider;

/* renamed from: mark.via.f.k */
/* compiled from: DaggerAppComponent */
public final class DaggerAppComponent implements AppComponent {

    /* renamed from: a */
    private Provider<Context> f1320a;

    /* renamed from: b */
    private Provider<PreferenceManager> f1321b;

    /* renamed from: c */
    private Provider<Blocker> f1322c;

    /* renamed from: d */
    private Provider<ConfManager> f1323d;

    /* renamed from: mark.via.f.k$b */
    /* compiled from: DaggerAppComponent */
    public static final class C0445b {

        /* renamed from: a */
        private AppModule f1324a;

        /* renamed from: a */
        public C0445b mo1027a(AppModule bVar) {
            Preconditions.m123b(bVar);
            this.f1324a = bVar;
            return this;
        }

        /* renamed from: b */
        public AppComponent mo1028b() {
            Preconditions.m122a(this.f1324a, AppModule.class);
            return new DaggerAppComponent(this.f1324a);
        }

        private C0445b() {
        }
    }

    /* renamed from: d */
    public static C0445b m1658d() {
        return new C0445b();
    }

    /* renamed from: e */
    private void m1659e(AppModule bVar) {
        Provider<Context> a = DoubleCheck.m120a(AppModule_ProvideAppContextFactory.m1638a(bVar));
        this.f1320a = a;
        Provider<PreferenceManager> a2 = DoubleCheck.m120a(AppModule_ProvidePreferenceFactory.m1647a(bVar, a));
        this.f1321b = a2;
        this.f1322c = DoubleCheck.m120a(AppModule_ProvideBlockerFactory.m1641a(bVar, this.f1320a, a2));
        this.f1323d = DoubleCheck.m120a(AppModule_ProvideConfManagerFactory.m1644a(bVar, this.f1320a));
    }

    @Override // mark.via.component.AppComponent
    /* renamed from: a */
    public ConfManager mo1005a() {
        return this.f1323d.get();
    }

    @Override // mark.via.component.AppComponent
    /* renamed from: b */
    public Blocker mo1006b() {
        return this.f1322c.get();
    }

    @Override // mark.via.component.AppComponent
    /* renamed from: c */
    public PreferenceManager mo1007c() {
        return this.f1321b.get();
    }

    private DaggerAppComponent(AppModule bVar) {
        m1659e(bVar);
    }
}
