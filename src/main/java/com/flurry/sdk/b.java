package com.flurry.sdk;

import com.flurry.sdk.p0;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f61a = "b";

    public static p0 a(File file) {
        DataInputStream dataInputStream;
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        p0.a aVar = new p0.a();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                dataInputStream = new DataInputStream(fileInputStream);
            } catch (Exception e) {
                e = e;
                dataInputStream = null;
                try {
                    s1.a(3, f61a, "Error loading legacy agent data.", e);
                    z2.a((Closeable) dataInputStream);
                    z2.a((Closeable) fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    z2.a((Closeable) dataInputStream);
                    z2.a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
                z2.a((Closeable) dataInputStream);
                z2.a((Closeable) fileInputStream);
                throw th;
            }
            try {
                if (dataInputStream.readUnsignedShort() != 46586) {
                    s1.a(3, f61a, "Unexpected file type");
                } else {
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort != 2) {
                        s1.a(6, f61a, "Unknown agent file version: ".concat(String.valueOf(readUnsignedShort)));
                    } else {
                        p0 p0Var = (p0) aVar.a(dataInputStream);
                        z2.a((Closeable) dataInputStream);
                        z2.a((Closeable) fileInputStream);
                        return p0Var;
                    }
                }
                z2.a((Closeable) dataInputStream);
                z2.a((Closeable) fileInputStream);
                return null;
            } catch (Exception e2) {
                e = e2;
                s1.a(3, f61a, "Error loading legacy agent data.", e);
                z2.a((Closeable) dataInputStream);
                z2.a((Closeable) fileInputStream);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            dataInputStream = null;
            fileInputStream = null;
            s1.a(3, f61a, "Error loading legacy agent data.", e);
            z2.a((Closeable) dataInputStream);
            z2.a((Closeable) fileInputStream);
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            dataInputStream = null;
            z2.a((Closeable) dataInputStream);
            z2.a((Closeable) fileInputStream);
            throw th;
        }
    }
}
