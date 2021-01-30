package com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.a4 */
public class C0028a4 {

    /* renamed from: d */
    private static final String f81d = "a4";

    /* renamed from: a */
    private final File f82a;

    /* renamed from: b */
    boolean f83b;

    /* renamed from: c */
    private String f84c;

    public C0028a4() {
        this(C0118e1.m386a().f361a);
    }

    /* renamed from: c */
    private void m192c(String str) {
        if (str != null) {
            this.f84c = str;
        }
    }

    /* renamed from: d */
    private void m193d() {
        if (!this.f83b) {
            this.f83b = true;
            String str = f81d;
            C0260s1.m686c(4, str, "Loading referrer info from file: " + this.f82a.getAbsolutePath());
            String e = C0318y2.m878e(this.f82a);
            C0260s1.m688e(str, "Referrer file contents: ".concat(String.valueOf(e)));
            m192c(e);
        }
    }

    /* renamed from: a */
    public final synchronized Map<String, List<String>> mo111a() {
        m193d();
        return C0041b4.m229a(this.f84c);
    }

    /* renamed from: b */
    public final synchronized String mo112b() {
        m193d();
        return this.f84c;
    }

    public C0028a4(Context context) {
        File fileStreamPath = context.getFileStreamPath(".flurryinstallreceiver.");
        this.f82a = fileStreamPath;
        String str = f81d;
        C0260s1.m686c(3, str, "Referrer file name if it exists:  " + fileStreamPath);
    }
}
