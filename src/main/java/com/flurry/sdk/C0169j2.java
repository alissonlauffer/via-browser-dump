package com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.flurry.sdk.j2 */
public final class C0169j2<ObjectType> extends C0163i2<ObjectType> {
    public C0169j2(AbstractC0185l2<ObjectType> l2Var) {
        super(l2Var);
    }

    @Override // com.flurry.sdk.C0163i2, com.flurry.sdk.AbstractC0185l2
    /* renamed from: a */
    public final void mo105a(OutputStream outputStream, ObjectType objecttype) {
        Throwable th;
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                try {
                    super.mo105a(gZIPOutputStream2, objecttype);
                    C0328z2.m890e(gZIPOutputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = gZIPOutputStream2;
                    C0328z2.m890e(gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                C0328z2.m890e(gZIPOutputStream);
                throw th;
            }
        }
    }

    @Override // com.flurry.sdk.C0163i2, com.flurry.sdk.AbstractC0185l2
    /* renamed from: b */
    public final ObjectType mo106b(InputStream inputStream) {
        Throwable th;
        GZIPInputStream gZIPInputStream = null;
        if (inputStream == null) {
            return null;
        }
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
            try {
                ObjectType objecttype = (ObjectType) super.mo106b(gZIPInputStream2);
                C0328z2.m890e(gZIPInputStream2);
                return objecttype;
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream = gZIPInputStream2;
                C0328z2.m890e(gZIPInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            C0328z2.m890e(gZIPInputStream);
            throw th;
        }
    }
}
