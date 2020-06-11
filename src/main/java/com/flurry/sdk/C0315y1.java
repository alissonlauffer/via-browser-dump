package com.flurry.sdk;

import com.flurry.sdk.C0108dk;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.y1 */
public final class C0315y1<RequestObjectType, ResponseObjectType> extends C0108dk {

    /* renamed from: A */
    public AbstractC0317b<RequestObjectType, ResponseObjectType> f866A;

    /* renamed from: B */
    public RequestObjectType f867B;

    /* renamed from: C */
    private ResponseObjectType f868C;

    /* renamed from: D */
    public AbstractC0185l2<RequestObjectType> f869D;

    /* renamed from: E */
    public AbstractC0185l2<ResponseObjectType> f870E;

    /* renamed from: com.flurry.sdk.y1$a */
    class C0316a implements C0108dk.AbstractC0112d {
        C0316a() {
        }

        @Override // com.flurry.sdk.C0108dk.AbstractC0112d
        /* renamed from: a */
        public final void mo183a() {
            C0315y1.m868s(C0315y1.this);
        }

        @Override // com.flurry.sdk.C0108dk.AbstractC0112d
        /* renamed from: b */
        public final void mo184b(C0108dk dkVar, InputStream inputStream) {
            if (dkVar.mo177h() && C0315y1.this.f870E != null) {
                C0315y1 y1Var = C0315y1.this;
                y1Var.f868C = y1Var.f870E.mo106b(inputStream);
            }
        }

        @Override // com.flurry.sdk.C0108dk.AbstractC0112d
        /* renamed from: c */
        public final void mo185c(OutputStream outputStream) {
            if (C0315y1.this.f867B != null && C0315y1.this.f869D != null) {
                C0315y1.this.f869D.mo105a(outputStream, C0315y1.this.f867B);
            }
        }
    }

    /* renamed from: com.flurry.sdk.y1$b */
    public interface AbstractC0317b<RequestObjectType, ResponseObjectType> {
        /* renamed from: a */
        void mo165a(C0315y1<RequestObjectType, ResponseObjectType> y1Var, ResponseObjectType responseobjecttype);
    }

    /* renamed from: s */
    static /* synthetic */ void m868s(C0315y1 y1Var) {
        if (y1Var.f866A != null && !y1Var.mo180k()) {
            y1Var.f866A.mo165a(y1Var, y1Var.f868C);
        }
    }

    @Override // com.flurry.sdk.AbstractRunnableC0040b3, com.flurry.sdk.C0108dk
    /* renamed from: a */
    public final void mo121a() {
        this.f329m = new C0316a();
        super.mo121a();
    }
}
