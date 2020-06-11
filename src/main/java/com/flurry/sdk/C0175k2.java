package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.flurry.sdk.k2 */
public final class C0175k2<T> implements AbstractC0185l2<List<T>> {

    /* renamed from: a */
    AbstractC0185l2<T> f526a;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.k2$a */
    public class C0176a extends DataOutputStream {
        C0176a(C0175k2 k2Var, OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public final void close() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.k2$b */
    public class C0177b extends DataInputStream {
        C0177b(C0175k2 k2Var, InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public final void close() {
        }
    }

    public C0175k2(AbstractC0185l2<T> l2Var) {
        this.f526a = l2Var;
    }

    /* renamed from: c */
    public final void mo105a(OutputStream outputStream, List<T> list) {
        if (outputStream != null) {
            C0176a aVar = new C0176a(this, outputStream);
            int size = list != null ? list.size() : 0;
            aVar.writeInt(size);
            for (int i = 0; i < size; i++) {
                this.f526a.mo105a(outputStream, list.get(i));
            }
            aVar.flush();
        }
    }

    /* renamed from: d */
    public final List<T> mo106b(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        int readInt = new C0177b(this, inputStream).readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            T b = this.f526a.mo106b(inputStream);
            if (b != null) {
                arrayList.add(b);
            } else {
                throw new IOException("Missing record.");
            }
        }
        return arrayList;
    }
}
