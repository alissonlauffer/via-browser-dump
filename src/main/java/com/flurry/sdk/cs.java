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

public class cs<ObjectType> {
    private static final String b = "cs";

    /* renamed from: a  reason: collision with root package name */
    private l2<ObjectType> f94a;

    public enum a {
        NONE(""),
        CRYPTO_ALGO_PADDING_7("AES/CBC/PKCS7Padding"),
        CRYPTO_ALGO_PADDING_5("AES/CBC/PKCS5Padding");
        
        String d;

        private a(String str) {
            this.d = str;
        }

        public static a a(int i) {
            a[] values = values();
            for (a aVar : values) {
                if (aVar.ordinal() == i) {
                    return aVar;
                }
            }
            return NONE;
        }
    }

    public cs(l2<ObjectType> l2Var) {
        this.f94a = l2Var;
    }

    public final byte[] a(ObjectType objecttype, Key key, IvParameterSpec ivParameterSpec, a aVar) {
        if (objecttype == null || key == null || aVar == null) {
            s1.a(5, b, "Cannot encrypt, invalid params.");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f94a.a(byteArrayOutputStream, objecttype);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            Cipher instance = Cipher.getInstance(aVar.d);
            instance.init(1, key, ivParameterSpec);
            return instance.doFinal(byteArray);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            String str = b;
            s1.a(5, str, "Error in encrypt " + e.getMessage());
            return null;
        }
    }

    public final ObjectType a(byte[] bArr, Key key, IvParameterSpec ivParameterSpec, a aVar) {
        if (bArr == null || key == null || aVar == null) {
            s1.a(5, b, "Cannot decrypt, invalid params.");
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance(aVar.d);
            instance.init(2, key, ivParameterSpec);
            return this.f94a.a(new ByteArrayInputStream(instance.doFinal(bArr)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            String str = b;
            s1.a(5, str, "Error in decrypt " + e.getMessage());
            return null;
        }
    }
}
