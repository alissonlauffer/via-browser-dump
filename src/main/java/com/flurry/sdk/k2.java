package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class k2<T> implements l2<List<T>> {

    /* renamed from: a  reason: collision with root package name */
    l2<T> f150a;

    class a extends DataOutputStream {
        a(k2 k2Var, OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public final void close() {
        }
    }

    class b extends DataInputStream {
        b(k2 k2Var, InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public final void close() {
        }
    }

    public k2(l2<T> l2Var) {
        this.f150a = l2Var;
    }

    /* renamed from: b */
    public final List<T> a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        int readInt = new b(this, inputStream).readInt();
        ArrayList arrayList = new ArrayList(readInt);
        int i = 0;
        while (i < readInt) {
            T a2 = this.f150a.a(inputStream);
            if (a2 != null) {
                arrayList.add(a2);
                i++;
            } else {
                throw new IOException("Missing record.");
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: MutableMD:(java.io.OutputStream, java.util.List):void
     arg types: [java.io.OutputStream, java.util.List<T>]
     candidates:
      com.flurry.sdk.k2.a(java.io.OutputStream, java.lang.Object):void
      MutableMD:(java.io.OutputStream, java.lang.Object):void
      MutableMD:(java.io.OutputStream, java.util.List):void */
    @Override // com.flurry.sdk.l2
    public final /* bridge */ /* synthetic */ void a(OutputStream outputStream, Object obj) {
        a(outputStream, (List) ((List) obj));
    }

    public final void a(OutputStream outputStream, List<T> list) {
        if (outputStream != null) {
            a aVar = new a(this, outputStream);
            int size = list != null ? list.size() : 0;
            aVar.writeInt(size);
            for (int i = 0; i < size; i++) {
                this.f150a.a(outputStream, list.get(i));
            }
            aVar.flush();
        }
    }
}
