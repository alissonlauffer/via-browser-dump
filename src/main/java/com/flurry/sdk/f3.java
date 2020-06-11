package com.flurry.sdk;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class f3 {
    private static final String d = "com.flurry.sdk.f3";
    private static final char[] e = {'F', 'C', 'B', 'M'};
    private static final String f = new String(e);
    private static final int g;
    private static final int h;
    private static final int i;
    private static final int j;

    /* renamed from: a  reason: collision with root package name */
    private short f124a;
    private boolean b;
    public ByteBuffer c;

    static {
        char[] cArr = e;
        g = (cArr.length * 2) + 2 + 1 + 105984;
        int length = cArr.length * 2;
        h = length;
        int i2 = length + 2;
        i = i2;
        j = i2 + 1;
    }

    public f3() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(g);
        this.c = allocateDirect;
        allocateDirect.asCharBuffer().put(e);
    }

    private e3 a(int i2) {
        this.c.position(j + (i2 * 512));
        return new e3(this.c.asCharBuffer().limit(this.c.getInt()).toString(), this.c.getLong());
    }

    public static int b() {
        return 1;
    }

    public synchronized String toString() {
        short s;
        StringBuilder sb;
        if (this.c == null) {
            s = 0;
        } else {
            s = this.b ? 207 : this.f124a;
        }
        sb = new StringBuilder();
        sb.append("Total number of breadcrumbs: " + ((int) s) + "\n");
        for (e3 e3Var : a()) {
            sb.append(e3Var.toString());
        }
        return sb.toString();
    }

    public f3(File file) {
        int i2;
        boolean z = true;
        s1.a(3, d, String.format(Locale.getDefault(), "Loading crash breadcrumbs from %s", file.getAbsolutePath()));
        this.c = ByteBuffer.allocate(g);
        if (file.length() != ((long) this.c.capacity())) {
            s1.a(6, d, String.format(Locale.getDefault(), "Crash breadcrumbs invalid file length %s != %s", Long.valueOf(file.length()), Integer.valueOf(this.c.capacity())));
            this.c = null;
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            try {
                i2 = channel.read(this.c);
            } catch (IOException unused) {
                s1.a(6, d, "Issue reading breadcrumbs from file.");
                i2 = 0;
            }
            z2.a(channel);
            z2.a((Closeable) fileInputStream);
            if (i2 != this.c.capacity()) {
                s1.a(6, d, String.format(Locale.getDefault(), "YCrashBreadcrumbs unexpected read size %s != %s", Integer.valueOf(i2), Integer.valueOf(this.c.capacity())));
                this.c = null;
                return;
            }
            this.c.position(0);
            String obj = this.c.asCharBuffer().limit(e.length).toString();
            if (!obj.equals(f)) {
                s1.a(6, d, String.format(Locale.getDefault(), "YCrashBreadcrumbs invalid magic string: '%s'", obj));
                this.c = null;
                return;
            }
            short s = this.c.getShort(h);
            this.f124a = s;
            if (s < 0 || s >= 207) {
                s1.a(6, d, String.format(Locale.getDefault(), "YCrashBreadcrumbs invalid index: '%s'", Short.valueOf(this.f124a)));
                this.c = null;
                return;
            }
            this.b = this.c.get(i) != 1 ? false : z;
        } catch (FileNotFoundException unused2) {
            s1.a(6, d, "Issue reading breadcrumbs file.");
            this.c = null;
        }
    }

    public final List<e3> a() {
        ArrayList arrayList = new ArrayList();
        if (this.c == null) {
            return arrayList;
        }
        if (this.b) {
            for (int i2 = this.f124a; i2 < 207; i2++) {
                arrayList.add(a(i2));
            }
        }
        for (int i3 = 0; i3 < this.f124a; i3++) {
            arrayList.add(a(i3));
        }
        return arrayList;
    }
}
