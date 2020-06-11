package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class r3 extends t3 {
    private static final String l = r3.class.getSimpleName();
    private final Context k;

    r3(Context context, String str) {
        this.k = context;
        ((t3) this).f195a = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.flurry.sdk.t3
    public final InputStream a() {
        if (this.k != null && !TextUtils.isEmpty(((t3) this).f195a)) {
            try {
                return this.k.getAssets().open(((t3) this).f195a);
            } catch (FileNotFoundException unused) {
                String str = l;
                s1.b(str, "File Not Found when opening " + ((t3) this).f195a);
            } catch (IOException unused2) {
                String str2 = l;
                s1.b(str2, "IO Exception when opening " + ((t3) this).f195a);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.flurry.sdk.t3
    public final void b() {
    }
}
