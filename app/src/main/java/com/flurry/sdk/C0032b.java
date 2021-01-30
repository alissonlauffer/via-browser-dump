package com.flurry.sdk;

import com.flurry.sdk.C0228p0;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/* renamed from: com.flurry.sdk.b */
public final class C0032b {

    /* renamed from: a */
    private static final String f107a = "b";

    /* renamed from: a */
    public static C0228p0 m197a(File file) {
        DataInputStream dataInputStream;
        FileInputStream fileInputStream;
        Throwable th;
        Exception e;
        if (file == null || !file.exists()) {
            return null;
        }
        C0228p0.C0229a aVar = new C0228p0.C0229a();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                dataInputStream = new DataInputStream(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                dataInputStream = null;
                try {
                    C0260s1.m687d(3, f107a, "Error loading legacy agent data.", e);
                    C0328z2.m890e(dataInputStream);
                    C0328z2.m890e(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    C0328z2.m890e(dataInputStream);
                    C0328z2.m890e(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dataInputStream = null;
                C0328z2.m890e(dataInputStream);
                C0328z2.m890e(fileInputStream);
                throw th;
            }
            try {
                if (dataInputStream.readUnsignedShort() != 46586) {
                    C0260s1.m686c(3, f107a, "Unexpected file type");
                } else {
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort != 2) {
                        C0260s1.m686c(6, f107a, "Unknown agent file version: ".concat(String.valueOf(readUnsignedShort)));
                    } else {
                        C0228p0 p0Var = (C0228p0) aVar.mo106b(dataInputStream);
                        C0328z2.m890e(dataInputStream);
                        C0328z2.m890e(fileInputStream);
                        return p0Var;
                    }
                }
                C0328z2.m890e(dataInputStream);
                C0328z2.m890e(fileInputStream);
                return null;
            } catch (Exception e3) {
                e = e3;
                C0260s1.m687d(3, f107a, "Error loading legacy agent data.", e);
                C0328z2.m890e(dataInputStream);
                C0328z2.m890e(fileInputStream);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            dataInputStream = null;
            fileInputStream = null;
            C0260s1.m687d(3, f107a, "Error loading legacy agent data.", e);
            C0328z2.m890e(dataInputStream);
            C0328z2.m890e(fileInputStream);
            return null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            dataInputStream = null;
            C0328z2.m890e(dataInputStream);
            C0328z2.m890e(fileInputStream);
            throw th;
        }
    }
}
