package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.j0 */
public final class C0167j0 {

    /* renamed from: a */
    private final Map<String, String> f505a;

    /* renamed from: b */
    private int f506b;

    /* renamed from: c */
    public String f507c;

    /* renamed from: d */
    private long f508d;

    /* renamed from: e */
    public boolean f509e;

    /* renamed from: f */
    public boolean f510f;

    /* renamed from: g */
    public long f511g;

    public C0167j0(int i, String str, Map<String, String> map, long j, boolean z) {
        HashMap hashMap = new HashMap();
        this.f505a = hashMap;
        this.f506b = i;
        this.f507c = str;
        if (map != null) {
            hashMap.putAll(map);
        }
        this.f508d = j;
        this.f509e = z;
        this.f510f = !z;
    }

    /* renamed from: a */
    public final synchronized Map<String, String> mo239a() {
        return new HashMap(this.f505a);
    }

    /* renamed from: b */
    public final void mo240b(long j) {
        this.f510f = true;
        this.f511g = j - this.f508d;
        C0260s1.m686c(3, "FlurryAgent", "Ended event '" + this.f507c + "' (" + this.f508d + ") after " + this.f511g + "ms");
    }

    /* renamed from: c */
    public final synchronized void mo241c(Map<String, String> map) {
        if (map != null) {
            this.f505a.putAll(map);
        }
    }

    /* renamed from: d */
    public final synchronized void mo242d(Map<String, String> map) {
        this.f505a.clear();
        if (map != null) {
            this.f505a.putAll(map);
        }
    }

    /* renamed from: e */
    public final synchronized byte[] mo243e() {
        Throwable th;
        byte[] bArr;
        DataOutputStream dataOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream2.writeShort(this.f506b);
                dataOutputStream2.writeUTF(this.f507c);
                dataOutputStream2.writeShort(this.f505a.size());
                for (Map.Entry<String, String> entry : this.f505a.entrySet()) {
                    dataOutputStream2.writeUTF(C0328z2.m894i(entry.getKey()));
                    dataOutputStream2.writeUTF(C0328z2.m894i(entry.getValue()));
                }
                dataOutputStream2.writeLong(this.f508d);
                dataOutputStream2.writeLong(this.f511g);
                dataOutputStream2.flush();
                bArr = byteArrayOutputStream.toByteArray();
                C0328z2.m890e(dataOutputStream2);
            } catch (IOException unused) {
                dataOutputStream = dataOutputStream2;
                try {
                    byte[] bArr2 = new byte[0];
                    C0328z2.m890e(dataOutputStream);
                    bArr = bArr2;
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
            byte[] bArr2 = new byte[0];
            C0328z2.m890e(dataOutputStream);
            bArr = bArr2;
            return bArr;
        }
        return bArr;
    }
}
