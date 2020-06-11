package com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;

public class i2<ObjectType> implements l2<ObjectType> {

    /* renamed from: a  reason: collision with root package name */
    protected final l2<ObjectType> f140a;

    public i2(l2<ObjectType> l2Var) {
        this.f140a = l2Var;
    }

    @Override // com.flurry.sdk.l2
    public void a(OutputStream outputStream, ObjectType objecttype) {
        l2<ObjectType> l2Var = this.f140a;
        if (l2Var != null && outputStream != null && objecttype != null) {
            l2Var.a(outputStream, objecttype);
        }
    }

    @Override // com.flurry.sdk.l2
    public ObjectType a(InputStream inputStream) {
        l2<ObjectType> l2Var = this.f140a;
        if (l2Var == null || inputStream == null) {
            return null;
        }
        return l2Var.a(inputStream);
    }
}
