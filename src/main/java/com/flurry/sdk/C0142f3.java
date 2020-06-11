package com.flurry.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.flurry.sdk.f3 */
public class C0142f3 {

    /* renamed from: d */
    private static final String f426d = "com.flurry.sdk.f3";

    /* renamed from: e */
    private static final char[] f427e;

    /* renamed from: f */
    private static final String f428f;

    /* renamed from: g */
    private static final int f429g;

    /* renamed from: h */
    private static final int f430h;

    /* renamed from: i */
    private static final int f431i;

    /* renamed from: j */
    private static final int f432j;

    /* renamed from: a */
    private short f433a;

    /* renamed from: b */
    private boolean f434b;

    /* renamed from: c */
    public ByteBuffer f435c;

    static {
        char[] cArr = {'F', 'C', 'B', 'M'};
        f427e = cArr;
        f428f = new String(cArr);
        f429g = (cArr.length * 2) + 2 + 1 + 105984;
        int length = cArr.length * 2;
        f430h = length;
        int i = length + 2;
        f431i = i;
        f432j = i + 1;
    }

    public C0142f3() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(f429g);
        this.f435c = allocateDirect;
        allocateDirect.asCharBuffer().put(f427e);
    }

    /* renamed from: a */
    private C0124e3 m437a(int i) {
        this.f435c.position(f432j + (i * 512));
        return new C0124e3(this.f435c.asCharBuffer().limit(this.f435c.getInt()).toString(), this.f435c.getLong());
    }

    /* renamed from: c */
    public static int m438c() {
        return 1;
    }

    /* renamed from: b */
    public final List<C0124e3> mo206b() {
        ArrayList arrayList = new ArrayList();
        if (this.f435c == null) {
            return arrayList;
        }
        if (this.f434b) {
            for (int i = this.f433a; i < 207; i++) {
                arrayList.add(m437a(i));
            }
        }
        for (int i2 = 0; i2 < this.f433a; i2++) {
            arrayList.add(m437a(i2));
        }
        return arrayList;
    }

    public synchronized String toString() {
        short s;
        StringBuilder sb;
        if (this.f435c == null) {
            s = 0;
        } else {
            s = this.f434b ? 207 : this.f433a;
        }
        sb = new StringBuilder();
        sb.append("Total number of breadcrumbs: " + ((int) s) + "\n");
        for (C0124e3 e3Var : mo206b()) {
            sb.append(e3Var.toString());
        }
        return sb.toString();
    }

    public C0142f3(File file) {
        int i;
        String str = f426d;
        boolean z = true;
        C0260s1.m686c(3, str, String.format(Locale.getDefault(), "Loading crash breadcrumbs from %s", file.getAbsolutePath()));
        this.f435c = ByteBuffer.allocate(f429g);
        if (file.length() != ((long) this.f435c.capacity())) {
            C0260s1.m686c(6, str, String.format(Locale.getDefault(), "Crash breadcrumbs invalid file length %s != %s", Long.valueOf(file.length()), Integer.valueOf(this.f435c.capacity())));
            this.f435c = null;
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            try {
                i = channel.read(this.f435c);
            } catch (IOException unused) {
                C0260s1.m686c(6, f426d, "Issue reading breadcrumbs from file.");
                i = 0;
            }
            C0328z2.m890e(channel);
            C0328z2.m890e(fileInputStream);
            if (i != this.f435c.capacity()) {
                C0260s1.m686c(6, f426d, String.format(Locale.getDefault(), "YCrashBreadcrumbs unexpected read size %s != %s", Integer.valueOf(i), Integer.valueOf(this.f435c.capacity())));
                this.f435c = null;
                return;
            }
            this.f435c.position(0);
            String obj = this.f435c.asCharBuffer().limit(f427e.length).toString();
            if (!obj.equals(f428f)) {
                C0260s1.m686c(6, f426d, String.format(Locale.getDefault(), "YCrashBreadcrumbs invalid magic string: '%s'", obj));
                this.f435c = null;
                return;
            }
            short s = this.f435c.getShort(f430h);
            this.f433a = s;
            if (s < 0 || s >= 207) {
                C0260s1.m686c(6, f426d, String.format(Locale.getDefault(), "YCrashBreadcrumbs invalid index: '%s'", Short.valueOf(this.f433a)));
                this.f435c = null;
                return;
            }
            this.f434b = this.f435c.get(f431i) != 1 ? false : z;
        } catch (FileNotFoundException unused2) {
            C0260s1.m686c(6, f426d, "Issue reading breadcrumbs file.");
            this.f435c = null;
        }
    }
}
