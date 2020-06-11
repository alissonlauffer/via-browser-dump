package com.flurry.sdk;

import com.flurry.sdk.dk;
import java.io.InputStream;
import java.io.OutputStream;

public final class y1<RequestObjectType, ResponseObjectType> extends dk {
    public b<RequestObjectType, ResponseObjectType> A;
    public RequestObjectType B;
    /* access modifiers changed from: private */
    public ResponseObjectType C;
    public l2<RequestObjectType> D;
    public l2<ResponseObjectType> E;

    public interface b<RequestObjectType, ResponseObjectType> {
        void a(y1<RequestObjectType, ResponseObjectType> y1Var, ResponseObjectType responseobjecttype);
    }

    static /* synthetic */ void d(y1 y1Var) {
        if (y1Var.A != null && !y1Var.h()) {
            y1Var.A.a(y1Var, y1Var.C);
        }
    }

    class a implements dk.d {
        a() {
        }

        @Override // com.flurry.sdk.dk.d
        public final void a(OutputStream outputStream) {
            if (y1.this.B != null && y1.this.D != null) {
                y1.this.D.a(outputStream, y1.this.B);
            }
        }

        @Override // com.flurry.sdk.dk.d
        public final void a(dk dkVar, InputStream inputStream) {
            if (dkVar.e() && y1.this.E != null) {
                y1 y1Var = y1.this;
                Object unused = y1Var.C = y1Var.E.a(inputStream);
            }
        }

        @Override // com.flurry.sdk.dk.d
        public final void a() {
            y1.d(y1.this);
        }
    }

    @Override // com.flurry.sdk.b3, com.flurry.sdk.dk
    public final void a() {
        ((dk) this).m = new a();
        super.a();
    }
}
