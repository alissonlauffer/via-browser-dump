package com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.i2 */
public class C0163i2<ObjectType> implements AbstractC0185l2<ObjectType> {

    /* renamed from: a */
    protected final AbstractC0185l2<ObjectType> f495a;

    public C0163i2(AbstractC0185l2<ObjectType> l2Var) {
        this.f495a = l2Var;
    }

    @Override // com.flurry.sdk.AbstractC0185l2
    /* renamed from: a */
    public void mo105a(OutputStream outputStream, ObjectType objecttype) {
        AbstractC0185l2<ObjectType> l2Var = this.f495a;
        if (l2Var != null && outputStream != null && objecttype != null) {
            l2Var.mo105a(outputStream, objecttype);
        }
    }

    @Override // com.flurry.sdk.AbstractC0185l2
    /* renamed from: b */
    public ObjectType mo106b(InputStream inputStream) {
        AbstractC0185l2<ObjectType> l2Var = this.f495a;
        if (l2Var == null || inputStream == null) {
            return null;
        }
        return l2Var.mo106b(inputStream);
    }
}
