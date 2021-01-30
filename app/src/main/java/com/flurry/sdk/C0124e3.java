package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.flurry.sdk.e3 */
public final class C0124e3 {

    /* renamed from: c */
    private static SimpleDateFormat f370c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

    /* renamed from: a */
    String f371a;

    /* renamed from: b */
    long f372b;

    public C0124e3(String str, long j) {
        this.f371a = str;
        this.f372b = j;
    }

    /* renamed from: a */
    public final byte[] mo194a() {
        Throwable th;
        DataOutputStream dataOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream2.writeLong(this.f372b);
                dataOutputStream2.writeUTF(this.f371a);
                dataOutputStream2.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                C0328z2.m890e(dataOutputStream2);
                return byteArray;
            } catch (IOException unused) {
                dataOutputStream = dataOutputStream2;
                try {
                    byte[] bArr = new byte[0];
                    C0328z2.m890e(dataOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    dataOutputStream2 = dataOutputStream;
                    th = th2;
                    C0328z2.m890e(dataOutputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                C0328z2.m890e(dataOutputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            byte[] bArr = new byte[0];
            C0328z2.m890e(dataOutputStream);
            return bArr;
        }
    }

    public final String toString() {
        return f370c.format(Long.valueOf(this.f372b)) + ": " + this.f371a + "\n";
    }
}
