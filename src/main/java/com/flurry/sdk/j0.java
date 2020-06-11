package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f144a;
    private int b;
    public String c;
    private long d;
    public boolean e;
    public boolean f;
    public long g;

    public j0(int i, String str, Map<String, String> map, long j, boolean z) {
        HashMap hashMap = new HashMap();
        this.f144a = hashMap;
        this.b = i;
        this.c = str;
        if (map != null) {
            hashMap.putAll(map);
        }
        this.d = j;
        this.e = z;
        this.f = !z;
    }

    public final void a(long j) {
        this.f = true;
        this.g = j - this.d;
        s1.a(3, "FlurryAgent", "Ended event '" + this.c + "' (" + this.d + ") after " + this.g + "ms");
    }

    public final synchronized void b(Map<String, String> map) {
        this.f144a.clear();
        if (map != null) {
            this.f144a.putAll(map);
        }
    }

    public final synchronized void a(Map<String, String> map) {
        if (map != null) {
            this.f144a.putAll(map);
        }
    }

    public final synchronized byte[] b() {
        Throwable th;
        byte[] bArr;
        DataOutputStream dataOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream2.writeShort(this.b);
                dataOutputStream2.writeUTF(this.c);
                dataOutputStream2.writeShort(this.f144a.size());
                for (Map.Entry<String, String> entry : this.f144a.entrySet()) {
                    dataOutputStream2.writeUTF(z2.b(entry.getKey()));
                    dataOutputStream2.writeUTF(z2.b(entry.getValue()));
                }
                dataOutputStream2.writeLong(this.d);
                dataOutputStream2.writeLong(this.g);
                dataOutputStream2.flush();
                bArr = byteArrayOutputStream.toByteArray();
                z2.a(dataOutputStream2);
            } catch (IOException unused) {
                dataOutputStream = dataOutputStream2;
                try {
                    byte[] bArr2 = new byte[0];
                    z2.a(dataOutputStream);
                    bArr = bArr2;
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
            byte[] bArr22 = new byte[0];
            z2.a(dataOutputStream);
            bArr = bArr22;
            return bArr;
        }
        return bArr;
    }

    public final synchronized Map<String, String> a() {
        return new HashMap(this.f144a);
    }
}
