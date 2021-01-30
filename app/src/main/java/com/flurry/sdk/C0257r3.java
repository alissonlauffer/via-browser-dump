package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.flurry.sdk.r3 */
public class C0257r3 extends AbstractRunnableC0267t3 {

    /* renamed from: l */
    private static final String f718l = C0257r3.class.getSimpleName();

    /* renamed from: k */
    private final Context f719k;

    C0257r3(Context context, String str) {
        this.f719k = context;
        this.f750a = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.flurry.sdk.AbstractRunnableC0267t3
    /* renamed from: a */
    public final InputStream mo321a() {
        if (this.f719k != null && !TextUtils.isEmpty(this.f750a)) {
            try {
                return this.f719k.getAssets().open(this.f750a);
            } catch (FileNotFoundException unused) {
                String str = f718l;
                C0260s1.m693j(str, "File Not Found when opening " + this.f750a);
            } catch (IOException unused2) {
                String str2 = f718l;
                C0260s1.m693j(str2, "IO Exception when opening " + this.f750a);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.flurry.sdk.AbstractRunnableC0267t3
    /* renamed from: d */
    public final void mo323d() {
    }
}
