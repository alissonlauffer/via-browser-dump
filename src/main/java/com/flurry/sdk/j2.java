package com.flurry.sdk;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class j2<ObjectType> extends i2<ObjectType> {
    public j2(l2<ObjectType> l2Var) {
        super(l2Var);
    }

    @Override // com.flurry.sdk.i2, com.flurry.sdk.l2
    public final void a(OutputStream outputStream, ObjectType objecttype) {
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                try {
                    super.a(gZIPOutputStream2, objecttype);
                    z2.a(gZIPOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    z2.a(gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z2.a(gZIPOutputStream);
                throw th;
            }
        }
    }

    @Override // com.flurry.sdk.i2, com.flurry.sdk.l2
    public final ObjectType a(InputStream inputStream) {
        GZIPInputStream gZIPInputStream = null;
        if (inputStream == null) {
            return null;
        }
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
            try {
                ObjectType a2 = super.a(gZIPInputStream2);
                z2.a((Closeable) gZIPInputStream2);
                return a2;
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                z2.a((Closeable) gZIPInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z2.a((Closeable) gZIPInputStream);
            throw th;
        }
    }
}
