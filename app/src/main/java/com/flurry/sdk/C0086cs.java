package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.flurry.sdk.cs */
public class C0086cs<ObjectType> {

    /* renamed from: b */
    private static final String f258b = "cs";

    /* renamed from: a */
    private AbstractC0185l2<ObjectType> f259a;

    /* renamed from: com.flurry.sdk.cs$a */
    public enum EnumC0087a {
        NONE(""),
        CRYPTO_ALGO_PADDING_7("AES/CBC/PKCS7Padding"),
        CRYPTO_ALGO_PADDING_5("AES/CBC/PKCS5Padding");
        

        /* renamed from: d */
        String f264d;

        private EnumC0087a(String str) {
            this.f264d = str;
        }

        /* renamed from: a */
        public static EnumC0087a m315a(int i) {
            EnumC0087a[] values = values();
            for (EnumC0087a aVar : values) {
                if (aVar.ordinal() == i) {
                    return aVar;
                }
            }
            return NONE;
        }
    }

    public C0086cs(AbstractC0185l2<ObjectType> l2Var) {
        this.f259a = l2Var;
    }

    /* renamed from: a */
    public final ObjectType mo154a(byte[] bArr, Key key, IvParameterSpec ivParameterSpec, EnumC0087a aVar) {
        if (bArr == null || key == null || aVar == null) {
            C0260s1.m686c(5, f258b, "Cannot decrypt, invalid params.");
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance(aVar.f264d);
            instance.init(2, key, ivParameterSpec);
            return this.f259a.mo106b(new ByteArrayInputStream(instance.doFinal(bArr)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            String str = f258b;
            C0260s1.m686c(5, str, "Error in decrypt " + e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public final byte[] mo155b(ObjectType objecttype, Key key, IvParameterSpec ivParameterSpec, EnumC0087a aVar) {
        if (objecttype == null || key == null || aVar == null) {
            C0260s1.m686c(5, f258b, "Cannot encrypt, invalid params.");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f259a.mo105a(byteArrayOutputStream, objecttype);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            Cipher instance = Cipher.getInstance(aVar.f264d);
            instance.init(1, key, ivParameterSpec);
            return instance.doFinal(byteArray);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            String str = f258b;
            C0260s1.m686c(5, str, "Error in encrypt " + e.getMessage());
            return null;
        }
    }
}
