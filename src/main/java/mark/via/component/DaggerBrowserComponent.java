package mark.via.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import mark.via.p042l.ConfManager;
import mark.via.ui.activity.BrowserActivity;
import mark.via.ui.activity.BrowserActivity_MembersInjector;
import p000a.p001a.p002a.Blocker;
import p014d.p015a.Provider;

/* renamed from: mark.via.f.m */
/* compiled from: DaggerBrowserComponent */
public final class DaggerBrowserComponent implements BrowserComponent {

    /* renamed from: a */
    private final AppComponent f1327a;

    /* renamed from: b */
    private Provider<String> f1328b;

    /* renamed from: mark.via.f.m$b */
    /* compiled from: DaggerBrowserComponent */
    public static final class C0449b {

        /* renamed from: a */
        private BrowserModule f1329a;

        /* renamed from: b */
        private AppComponent f1330b;

        /* renamed from: a */
        public C0449b mo1031a(AppComponent aVar) {
            Preconditions.m123b(aVar);
            this.f1330b = aVar;
            return this;
        }

        /* renamed from: b */
        public C0449b mo1032b(BrowserModule iVar) {
            Preconditions.m123b(iVar);
            this.f1329a = iVar;
            return this;
        }

        /* renamed from: c */
        public BrowserComponent mo1033c() {
            if (this.f1329a == null) {
                this.f1329a = new BrowserModule();
            }
            Preconditions.m122a(this.f1330b, AppComponent.class);
            return new DaggerBrowserComponent(this.f1329a, this.f1330b);
        }

        private C0449b() {
        }
    }

    /* renamed from: b */
    public static C0449b m1674b() {
        return new C0449b();
    }

    /* renamed from: c */
    private void m1675c(BrowserModule iVar, AppComponent aVar) {
        this.f1328b = DoubleCheck.m120a(BrowserModule_ProvideHelloFactory.m1655a(iVar));
    }

    /* renamed from: d */
    private BrowserActivity m1676d(BrowserActivity browserActivity) {
        Blocker b = this.f1327a.mo1006b();
        Preconditions.m124c(b, "Cannot return null from a non-@Nullable component method");
        BrowserActivity_MembersInjector.m2561a(browserActivity, b);
        BrowserActivity_MembersInjector.m2563c(browserActivity, this.f1328b.get());
        ConfManager a = this.f1327a.mo1005a();
        Preconditions.m124c(a, "Cannot return null from a non-@Nullable component method");
        BrowserActivity_MembersInjector.m2562b(browserActivity, a);
        return browserActivity;
    }

    @Override // mark.via.component.BrowserComponent
    /* renamed from: a */
    public void mo1023a(BrowserActivity browserActivity) {
        m1676d(browserActivity);
    }

    private DaggerBrowserComponent(BrowserModule iVar, AppComponent aVar) {
        this.f1327a = aVar;
        m1675c(iVar, aVar);
    }
}
