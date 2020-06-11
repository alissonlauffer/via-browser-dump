package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class e3 {
    private static SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

    /* renamed from: a  reason: collision with root package name */
    String f113a;
    long b;

    public e3(String str, long j) {
        this.f113a = str;
        this.b = j;
    }

    public final byte[] a() {
        Throwable th;
        DataOutputStream dataOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream2.writeLong(this.b);
                dataOutputStream2.writeUTF(this.f113a);
                dataOutputStream2.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                z2.a(dataOutputStream2);
                return byteArray;
            } catch (IOException unused) {
                dataOutputStream = dataOutputStream2;
                try {
                    byte[] bArr = new byte[0];
                    z2.a(dataOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    dataOutputStream2 = dataOutputStream;
                    th = th2;
                    z2.a(dataOutputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z2.a(dataOutputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            byte[] bArr2 = new byte[0];
            z2.a(dataOutputStream);
            return bArr2;
        }
    }

    public final String toString() {
        return c.format(Long.valueOf(this.b)) + ": " + this.f113a + "\n";
    }
}
