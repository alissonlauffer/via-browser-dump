package com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Map;

public class a4 {
    private static final String d = "a4";

    /* renamed from: a  reason: collision with root package name */
    private final File f57a;
    boolean b;
    private String c;

    public a4() {
        this(e1.a().f110a);
    }

    private void c() {
        if (!this.b) {
            this.b = true;
            String str = d;
            s1.a(4, str, "Loading referrer info from file: " + this.f57a.getAbsolutePath());
            String c2 = y2.c(this.f57a);
            s1.a(d, "Referrer file contents: ".concat(String.valueOf(c2)));
            a(c2);
        }
    }

    public final synchronized Map<String, List<String>> a() {
        c();
        return b4.a(this.c);
    }

    public final synchronized String b() {
        c();
        return this.c;
    }

    public a4(Context context) {
        new b4();
        this.f57a = context.getFileStreamPath(".flurryinstallreceiver.");
        String str = d;
        s1.a(3, str, "Referrer file name if it exists:  " + this.f57a);
    }

    private void a(String str) {
        if (str != null) {
            this.c = str;
        }
    }
}
