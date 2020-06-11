package com.flurry.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.a1;
import com.flurry.sdk.cs;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import java.util.UUID;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class b1 {
    private static final String e = "b1";

    /* renamed from: a  reason: collision with root package name */
    private c1 f64a;
    private byte[] b;
    private final cs<byte[]> c;
    private k1<a1> d;

    class a implements n2<a1> {
        a(b1 b1Var) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<a1> a(int i) {
            return new a1.a();
        }
    }

    public b1() {
        this.f64a = null;
        this.b = null;
        this.d = null;
        this.d = new k1<>(b(), "installationNum", 1, new a(this));
        this.c = new cs<>(new h2());
        this.f64a = new c1();
        byte[] a2 = a(c());
        if (a2 != null && Build.VERSION.SDK_INT >= 23) {
            y2.b(b());
            a(a2, cs.a.CRYPTO_ALGO_PADDING_7);
        }
        a();
    }

    private static File b() {
        return new File(y2.a().getPath() + File.separator + "installationNum");
    }

    private static SecretKey c() {
        String str = e1.a().e;
        String a2 = w2.a(e1.a().f110a);
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBEWithSHA256And256BitAES-CBC-BC").generateSecret(new PBEKeySpec(str.toCharArray(), ByteBuffer.allocate(8).putLong(!TextUtils.isEmpty(a2) ? z2.f(a2) : Long.MIN_VALUE).array(), 1000, 256)).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            s1.a(4, e, "Error in generate secret key", e2);
            return null;
        }
    }

    private static byte[] d() {
        try {
            byte[] bArr = new byte[16];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
            return bArr;
        } catch (NoSuchAlgorithmException e2) {
            s1.a(4, e, "Error in generating iv", e2);
            return null;
        }
    }

    private Key e() {
        if (Build.VERSION.SDK_INT < 23) {
            return c();
        }
        return this.f64a.a();
    }

    public final synchronized byte[] a() {
        byte[] bArr;
        cs.a aVar;
        bArr = this.b;
        if (bArr == null) {
            if (Build.VERSION.SDK_INT < 23) {
                aVar = cs.a.CRYPTO_ALGO_PADDING_5;
            } else {
                aVar = cs.a.CRYPTO_ALGO_PADDING_7;
            }
            byte[] a2 = a(e());
            if (a2 == null) {
                String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.ENGLISH);
                byte[] bArr2 = null;
                if (!TextUtils.isEmpty(lowerCase)) {
                    String replaceAll = lowerCase.replaceAll("[^a-f0-9]+", "");
                    if (replaceAll.length() % 2 != 0) {
                        s1.a(4, e, "Input string must contain an even number of characters ".concat(String.valueOf(replaceAll)));
                    } else {
                        bArr2 = z2.e(replaceAll);
                    }
                }
                a(bArr2, aVar);
                bArr = bArr2;
            } else {
                bArr = a2;
            }
            this.b = bArr;
        }
        return bArr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: MutableMD:(byte[], java.security.Key, javax.crypto.spec.IvParameterSpec, com.flurry.sdk.cs$a):byte[]
     arg types: [byte[], java.security.Key, javax.crypto.spec.IvParameterSpec, com.flurry.sdk.cs$a]
     candidates:
      com.flurry.sdk.cs.a(byte[], java.security.Key, javax.crypto.spec.IvParameterSpec, com.flurry.sdk.cs$a):ObjectType
      MutableMD:(byte[], java.security.Key, javax.crypto.spec.IvParameterSpec, com.flurry.sdk.cs$a):byte[] */
    private boolean a(byte[] bArr, cs.a aVar) {
        a1 a1Var;
        try {
            y2.b(b());
            byte[] d2 = d();
            byte[] a2 = this.c.a(bArr, e(), new IvParameterSpec(d2), aVar);
            if (a2 != null) {
                a1Var = new a1(a2, d2, true, aVar.ordinal());
            } else {
                a1Var = new a1(bArr, new byte[0], false, aVar.ordinal());
            }
            this.d.a(a1Var);
            return true;
        } catch (IOException e2) {
            String str = e;
            s1.a(5, str, "Error while generating UUID" + e2.getMessage(), e2);
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.cs.a(byte[], java.security.Key, javax.crypto.spec.IvParameterSpec, com.flurry.sdk.cs$a):ObjectType
     arg types: [byte[], java.security.Key, javax.crypto.spec.IvParameterSpec, com.flurry.sdk.cs$a]
     candidates:
      MutableMD:(byte[], java.security.Key, javax.crypto.spec.IvParameterSpec, com.flurry.sdk.cs$a):byte[]
      com.flurry.sdk.cs.a(byte[], java.security.Key, javax.crypto.spec.IvParameterSpec, com.flurry.sdk.cs$a):ObjectType */
    private byte[] a(Key key) {
        try {
            a1 a2 = this.d.a();
            if (a2 == null) {
                return null;
            }
            if (!a2.f56a) {
                return a2.c;
            }
            byte[] bArr = a2.b;
            byte[] bArr2 = a2.c;
            cs.a a3 = cs.a.a(a2.d);
            if (bArr == null || bArr2 == null) {
                return null;
            }
            return this.c.a(bArr2, key, new IvParameterSpec(bArr), a3);
        } catch (IOException unused) {
            s1.a(5, e, "Error while reading Android Install Id. Deleting file.");
            return null;
        }
    }
}
