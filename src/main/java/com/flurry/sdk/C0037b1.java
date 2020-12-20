package com.flurry.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.C0022a1;
import com.flurry.sdk.C0086cs;
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

/* renamed from: com.flurry.sdk.b1 */
public class C0037b1 {

    /* renamed from: e */
    private static final String f120e = "b1";

    /* renamed from: a */
    private C0065c1 f121a;

    /* renamed from: b */
    private byte[] f122b;

    /* renamed from: c */
    private final C0086cs<byte[]> f123c;

    /* renamed from: d */
    private C0174k1<C0022a1> f124d;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.b1$a */
    public class C0038a implements AbstractC0201n2<C0022a1> {
        C0038a(C0037b1 b1Var) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<C0022a1> mo100a(int i) {
            return new C0022a1.C0023a();
        }
    }

    public C0037b1() {
        this.f121a = null;
        this.f122b = null;
        this.f124d = null;
        this.f124d = new C0174k1<>(m221d(), "installationNum", 1, new C0038a(this));
        this.f123c = new C0086cs<>(new C0158h2());
        this.f121a = new C0065c1();
        byte[] c = m220c(m222e());
        if (c != null && Build.VERSION.SDK_INT >= 23) {
            C0318y2.m877d(m221d());
            m219a(c, C0086cs.EnumC0087a.CRYPTO_ALGO_PADDING_7);
        }
        mo119b();
    }

    /* renamed from: a */
    private boolean m219a(byte[] bArr, C0086cs.EnumC0087a aVar) {
        C0022a1 a1Var;
        try {
            C0318y2.m877d(m221d());
            byte[] f = m223f();
            byte[] b = this.f123c.mo155b(bArr, m224g(), new IvParameterSpec(f), aVar);
            if (b != null) {
                a1Var = new C0022a1(b, f, true, aVar.ordinal());
            } else {
                a1Var = new C0022a1(bArr, new byte[0], false, aVar.ordinal());
            }
            this.f124d.mo253b(a1Var);
            return true;
        } catch (IOException e) {
            String str = f120e;
            C0260s1.m687d(5, str, "Error while generating UUID" + e.getMessage(), e);
            return false;
        }
    }

    /* renamed from: c */
    private byte[] m220c(Key key) {
        try {
            C0022a1 a = this.f124d.mo252a();
            if (a == null) {
                return null;
            }
            if (!a.f77a) {
                return a.f79c;
            }
            byte[] bArr = a.f78b;
            byte[] bArr2 = a.f79c;
            C0086cs.EnumC0087a a2 = C0086cs.EnumC0087a.m315a(a.f80d);
            if (bArr == null || bArr2 == null) {
                return null;
            }
            return this.f123c.mo154a(bArr2, key, new IvParameterSpec(bArr), a2);
        } catch (IOException unused) {
            C0260s1.m686c(5, f120e, "Error while reading Android Install Id. Deleting file.");
            return null;
        }
    }

    /* renamed from: d */
    private static File m221d() {
        return new File(C0318y2.m874a().getPath() + File.separator + "installationNum");
    }

    /* renamed from: e */
    private static SecretKey m222e() {
        String str = C0118e1.m386a().f365e;
        String a = C0300w2.m815a(C0118e1.m386a().f361a);
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBEWithSHA256And256BitAES-CBC-BC").generateSecret(new PBEKeySpec(str.toCharArray(), ByteBuffer.allocate(8).putLong(!TextUtils.isEmpty(a) ? C0328z2.m899n(a) : Long.MIN_VALUE).array(), 1000, 256)).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            C0260s1.m687d(4, f120e, "Error in generate secret key", e);
            return null;
        }
    }

    /* renamed from: f */
    private static byte[] m223f() {
        try {
            byte[] bArr = new byte[16];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
            return bArr;
        } catch (NoSuchAlgorithmException e) {
            C0260s1.m687d(4, f120e, "Error in generating iv", e);
            return null;
        }
    }

    /* renamed from: g */
    private Key m224g() {
        if (Build.VERSION.SDK_INT < 23) {
            return m222e();
        }
        return this.f121a.mo139a();
    }

    /* renamed from: b */
    public final synchronized byte[] mo119b() {
        byte[] bArr;
        C0086cs.EnumC0087a aVar;
        bArr = this.f122b;
        if (bArr == null) {
            if (Build.VERSION.SDK_INT < 23) {
                aVar = C0086cs.EnumC0087a.CRYPTO_ALGO_PADDING_5;
            } else {
                aVar = C0086cs.EnumC0087a.CRYPTO_ALGO_PADDING_7;
            }
            byte[] c = m220c(m224g());
            if (c == null) {
                String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.ENGLISH);
                byte[] bArr2 = null;
                if (!TextUtils.isEmpty(lowerCase)) {
                    String replaceAll = lowerCase.replaceAll("[^a-f0-9]+", "");
                    if (replaceAll.length() % 2 != 0) {
                        C0260s1.m686c(4, f120e, "Input string must contain an even number of characters ".concat(String.valueOf(replaceAll)));
                    } else {
                        bArr2 = C0328z2.m898m(replaceAll);
                    }
                }
                m219a(bArr2, aVar);
                bArr = bArr2;
            } else {
                bArr = c;
            }
            this.f122b = bArr;
        }
        return bArr;
    }
}
