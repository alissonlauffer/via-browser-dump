package mark.via.component;

import dagger.internal.Preconditions;
import mark.via.ui.settings.AdBlockUI;
import mark.via.ui.settings.AdBlockUI_MembersInjector;
import mark.via.ui.settings.CustomFiltersUI;
import mark.via.ui.settings.CustomFiltersUI_MembersInjector;
import mark.via.ui.settings.SubscribedFiltersUI;
import mark.via.ui.settings.SubscribedFiltersUI_MembersInjector;
import p000a.p001a.p002a.Blocker;

/* renamed from: mark.via.f.l */
/* compiled from: DaggerBlockerComponent */
public final class DaggerBlockerComponent implements BlockerComponent {

    /* renamed from: a */
    private final AppComponent f1325a;

    /* renamed from: mark.via.f.l$b */
    /* compiled from: DaggerBlockerComponent */
    public static final class C0447b {

        /* renamed from: a */
        private AppComponent f1326a;

        /* renamed from: a */
        public C0447b mo1029a(AppComponent aVar) {
            Preconditions.m123b(aVar);
            this.f1326a = aVar;
            return this;
        }

        /* renamed from: b */
        public BlockerComponent mo1030b() {
            Preconditions.m122a(this.f1326a, AppComponent.class);
            return new DaggerBlockerComponent(this.f1326a);
        }

        private C0447b() {
        }
    }

    /* renamed from: d */
    public static C0447b m1665d() {
        return new C0447b();
    }

    /* renamed from: e */
    private AdBlockUI m1666e(AdBlockUI adBlockUI) {
        Blocker b = this.f1325a.mo1006b();
        Preconditions.m124c(b, "Cannot return null from a non-@Nullable component method");
        AdBlockUI_MembersInjector.m2910a(adBlockUI, b);
        return adBlockUI;
    }

    /* renamed from: f */
    private CustomFiltersUI m1667f(CustomFiltersUI customFiltersUI) {
        Blocker b = this.f1325a.mo1006b();
        Preconditions.m124c(b, "Cannot return null from a non-@Nullable component method");
        CustomFiltersUI_MembersInjector.m2913a(customFiltersUI, b);
        return customFiltersUI;
    }

    /* renamed from: g */
    private SubscribedFiltersUI m1668g(SubscribedFiltersUI subscribedFiltersUI) {
        Blocker b = this.f1325a.mo1006b();
        Preconditions.m124c(b, "Cannot return null from a non-@Nullable component method");
        SubscribedFiltersUI_MembersInjector.m2916a(subscribedFiltersUI, b);
        return subscribedFiltersUI;
    }

    @Override // mark.via.component.BlockerComponent
    /* renamed from: a */
    public void mo1020a(AdBlockUI adBlockUI) {
        m1666e(adBlockUI);
    }

    @Override // mark.via.component.BlockerComponent
    /* renamed from: b */
    public void mo1021b(SubscribedFiltersUI subscribedFiltersUI) {
        m1668g(subscribedFiltersUI);
    }

    @Override // mark.via.component.BlockerComponent
    /* renamed from: c */
    public void mo1022c(CustomFiltersUI customFiltersUI) {
        m1667f(customFiltersUI);
    }

    private DaggerBlockerComponent(AppComponent aVar) {
        this.f1325a = aVar;
    }
}
