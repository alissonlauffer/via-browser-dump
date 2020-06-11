package com.flurry.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.flurry.sdk.k1 */
public class C0174k1<T> {

    /* renamed from: c */
    private static final String f523c = "k1";

    /* renamed from: a */
    private final File f524a;

    /* renamed from: b */
    private final AbstractC0185l2<T> f525b;

    public C0174k1(File file, String str, int i, AbstractC0201n2<T> n2Var) {
        this.f524a = file;
        this.f525b = new C0169j2(new C0193m2(str, i, n2Var));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* renamed from: a */
    public final T mo252a() {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e;
        File file = this.f524a;
        T t = null;
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            C0260s1.m686c(5, f523c, "No data to read for file:" + this.f524a.getName());
            return null;
        }
        boolean z = false;
        try {
            fileInputStream = new FileInputStream(this.f524a);
            try {
                t = this.f525b.mo106b(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    C0260s1.m687d(3, f523c, "Error reading data file:" + this.f524a.getName(), e);
                    z = true;
                    C0328z2.m890e(fileInputStream);
                    if (z) {
                    }
                    return t;
                } catch (Throwable th2) {
                    th = th2;
                    t = (T) fileInputStream;
                    C0328z2.m890e(t);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C0260s1.m687d(3, f523c, "Error reading data file:" + this.f524a.getName(), e);
            z = true;
            C0328z2.m890e(fileInputStream);
            if (z) {
            }
            return t;
        } catch (Throwable th3) {
            th = th3;
            C0328z2.m890e(t);
            throw th;
        }
        C0328z2.m890e(fileInputStream);
        if (z) {
            C0260s1.m686c(3, f523c, "Deleting data file:" + this.f524a.getName());
            this.f524a.delete();
        }
        return t;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    public final void mo253b(T t) {
        Throwable th;
        Exception e;
        boolean z = true;
        if (t == null) {
            String str = f523c;
            C0260s1.m686c(3, str, "No data to write for file:" + this.f524a.getName());
        } else {
            FileOutputStream fileOutputStream = null;
            try {
                if (C0318y2.m875b(this.f524a)) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.f524a);
                    try {
                        this.f525b.mo105a(fileOutputStream2, t);
                        C0328z2.m890e(fileOutputStream2);
                        z = false;
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        try {
                            String str2 = f523c;
                            C0260s1.m687d(3, str2, "Error writing data file:" + this.f524a.getName(), e);
                            C0328z2.m890e(fileOutputStream);
                            if (z) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            C0328z2.m890e(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        C0328z2.m890e(fileOutputStream);
                        throw th;
                    }
                } else {
                    throw new IOException("Cannot create parent directory!");
                }
            } catch (Exception e3) {
                e = e3;
                String str22 = f523c;
                C0260s1.m687d(3, str22, "Error writing data file:" + this.f524a.getName(), e);
                C0328z2.m890e(fileOutputStream);
                if (z) {
                }
            }
        }
        if (z) {
            String str3 = f523c;
            C0260s1.m686c(3, str3, "Deleting data file:" + this.f524a.getName());
            this.f524a.delete();
        }
    }

    /* renamed from: c */
    public final boolean mo254c() {
        File file = this.f524a;
        if (file == null) {
            return false;
        }
        return file.delete();
    }
}
