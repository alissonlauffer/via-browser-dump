package com.flurry.sdk;

import android.annotation.TargetApi;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.KeyGenerator;

/* renamed from: com.flurry.sdk.c1 */
public class C0065c1 {

    /* renamed from: b */
    private static final String f207b = "c1";

    /* renamed from: a */
    private KeyStore f208a;

    @TargetApi(23)
    public C0065c1() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                this.f208a = instance;
                instance.load(null);
                if (!this.f208a.containsAlias("fl.install.id.sec.key")) {
                    KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    instance2.init(new KeyGenParameterSpec.Builder("fl.install.id.sec.key", 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).setDigests("SHA-256", "SHA-512").build());
                    instance2.generateKey();
                }
            } catch (IOException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | CertificateException e) {
                String str = f207b;
                C0260s1.m687d(5, str, "Error while generating Key" + e.getMessage(), e);
            }
        }
    }

    /* renamed from: a */
    public final Key mo139a() {
        KeyStore keyStore;
        if (Build.VERSION.SDK_INT < 23 || (keyStore = this.f208a) == null) {
            return null;
        }
        try {
            return keyStore.getKey("fl.install.id.sec.key", null);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException unused) {
            C0260s1.m686c(6, f207b, "Error in getting key.");
            return null;
        }
    }
}
