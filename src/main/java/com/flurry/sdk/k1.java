package com.flurry.sdk;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class k1<T> {
    private static final String c = "k1";

    /* renamed from: a  reason: collision with root package name */
    private final File f149a;
    private final l2<T> b;

    public k1(File file, String str, int i, n2<T> n2Var) {
        this.f149a = file;
        this.b = new j2(new m2(str, i, n2Var));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    public final T a() {
        T t;
        File file = this.f149a;
        T t2 = null;
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            s1.a(5, c, "No data to read for file:" + this.f149a.getName());
            return null;
        }
        boolean z = false;
        try {
            t = new FileInputStream(this.f149a);
            try {
                t2 = this.b.a(t);
            } catch (Exception e) {
                e = e;
                try {
                    s1.a(3, c, "Error reading data file:" + this.f149a.getName(), e);
                    z = true;
                    z2.a((Closeable) t);
                    if (z) {
                    }
                    return t2;
                } catch (Throwable th) {
                    th = th;
                    t2 = t;
                    z2.a((Closeable) t2);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            t = null;
            s1.a(3, c, "Error reading data file:" + this.f149a.getName(), e);
            z = true;
            z2.a((Closeable) t);
            if (z) {
            }
            return t2;
        } catch (Throwable th2) {
            th = th2;
            z2.a((Closeable) t2);
            throw th;
        }
        z2.a((Closeable) t);
        if (z) {
            s1.a(3, c, "Deleting data file:" + this.f149a.getName());
            this.f149a.delete();
        }
        return t2;
    }

    public final boolean b() {
        File file = this.f149a;
        if (file == null) {
            return false;
        }
        return file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    public final void a(T t) {
        boolean z = true;
        if (t == null) {
            String str = c;
            s1.a(3, str, "No data to write for file:" + this.f149a.getName());
        } else {
            FileOutputStream fileOutputStream = null;
            try {
                if (y2.a(this.f149a)) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.f149a);
                    try {
                        this.b.a(fileOutputStream2, t);
                        z2.a(fileOutputStream2);
                        z = false;
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        try {
                            String str2 = c;
                            s1.a(3, str2, "Error writing data file:" + this.f149a.getName(), e);
                            z2.a(fileOutputStream);
                            if (z) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            z2.a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        z2.a(fileOutputStream);
                        throw th;
                    }
                } else {
                    throw new IOException("Cannot create parent directory!");
                }
            } catch (Exception e2) {
                e = e2;
                String str22 = c;
                s1.a(3, str22, "Error writing data file:" + this.f149a.getName(), e);
                z2.a(fileOutputStream);
                if (z) {
                }
            }
        }
        if (z) {
            String str3 = c;
            s1.a(3, str3, "Deleting data file:" + this.f149a.getName());
            this.f149a.delete();
        }
    }
}
