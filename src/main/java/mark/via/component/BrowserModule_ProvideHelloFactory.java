package mark.via.component;

import dagger.internal.Preconditions;

/* renamed from: mark.via.f.j */
/* compiled from: BrowserModule_ProvideHelloFactory */
public final class BrowserModule_ProvideHelloFactory implements Object<String> {

    /* renamed from: a */
    private final BrowserModule f1319a;

    public BrowserModule_ProvideHelloFactory(BrowserModule iVar) {
        this.f1319a = iVar;
    }

    /* renamed from: a */
    public static BrowserModule_ProvideHelloFactory m1655a(BrowserModule iVar) {
        return new BrowserModule_ProvideHelloFactory(iVar);
    }

    /* renamed from: c */
    public static String m1656c(BrowserModule iVar) {
        String a = iVar.mo1024a();
        Preconditions.m124c(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    /* renamed from: b */
    public String get() {
        return m1656c(this.f1319a);
    }
}
