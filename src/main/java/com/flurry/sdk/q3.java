package com.flurry.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.g;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;

public class q3 extends t3 {
    private static final String n = q3.class.getSimpleName();
    private static String o;
    private HttpsURLConnection k;
    private String l;
    private boolean m;

    q3(String str) {
        ((t3) this).f195a = str;
        o = "Flurry-Config/1.0 (Android " + Build.VERSION.RELEASE + "/" + Build.ID + ")";
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x011b  */
    @Override // com.flurry.sdk.t3
    public final InputStream a() {
        BufferedWriter bufferedWriter;
        OutputStream outputStream;
        Throwable th;
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(((t3) this).f195a).openConnection();
        this.k = httpsURLConnection;
        httpsURLConnection.setReadTimeout(10000);
        this.k.setConnectTimeout(15000);
        this.k.setRequestMethod("POST");
        this.k.setRequestProperty("User-Agent", o);
        this.k.setRequestProperty("Content-Type", "application/json");
        this.k.setDoInput(true);
        this.k.setDoOutput(true);
        this.k.connect();
        v3.a(this.k);
        ((t3) this).c = UUID.randomUUID().toString().toUpperCase(Locale.ENGLISH);
        try {
            outputStream = this.k.getOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            } catch (Throwable th2) {
                bufferedWriter = null;
                th = th2;
                if (bufferedWriter != null) {
                }
                if (outputStream != null) {
                }
                throw th;
            }
            try {
                bufferedWriter.write(s3.a(((t3) this).c));
                bufferedWriter.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = this.k.getResponseCode();
                if (responseCode < 400) {
                    this.l = this.k.getHeaderField("Content-Signature");
                    ((t3) this).g = this.k.getHeaderField("ETag");
                    s1.a(n, "Content-Signature: " + this.l + ", ETag: " + ((t3) this).g);
                    if (responseCode == 304) {
                        if (a(((t3) this).c)) {
                            ((t3) this).b = g.d;
                            s1.a(n, "Empty 304 payload; No Change.");
                        } else {
                            ((t3) this).b = new g(g.a.AUTHENTICATE, "GUID Signature Error.");
                            s1.b(n, "Authentication error: " + ((t3) this).b);
                        }
                    }
                    return this.k.getInputStream();
                }
                throw new IOException("Server response code is ".concat(String.valueOf(responseCode)));
            } catch (Throwable th3) {
                th = th3;
                if (bufferedWriter != null) {
                }
                if (outputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            bufferedWriter = null;
            th = th4;
            outputStream = null;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.flurry.sdk.t3
    public final void b() {
        HttpsURLConnection httpsURLConnection = this.k;
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
    }

    @Override // com.flurry.sdk.t3
    public final boolean c() {
        return "https://cfg.flurry.com/sdk/v1/config".equals(((t3) this).f195a);
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            s1.b(n, "Content-Signature is empty.");
            return false;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split(";");
        for (String str2 : split) {
            int indexOf = str2.indexOf("=");
            if (indexOf > 0) {
                hashMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        }
        String str3 = (String) hashMap.get("keyid");
        ((t3) this).d = str3;
        if (TextUtils.isEmpty(str3)) {
            s1.b(n, "Error to get keyid from Signature.");
            return false;
        }
        ((t3) this).e = w3.f213a.get(((t3) this).d);
        s1.a(n, "Signature keyid: " + ((t3) this).d + ", key: " + ((t3) this).e);
        if (((t3) this).e == null) {
            s1.b(n, "Unknown keyid from Signature.");
            return false;
        }
        String str4 = "sha256ecdsa";
        boolean containsKey = hashMap.containsKey(str4);
        this.m = containsKey;
        if (!containsKey) {
            str4 = "sha256rsa";
        }
        String str5 = (String) hashMap.get(str4);
        ((t3) this).f = str5;
        if (TextUtils.isEmpty(str5)) {
            s1.b(n, "Error to get rsa from Signature.");
            return false;
        }
        s1.a(n, "Signature rsa: " + ((t3) this).f);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.flurry.sdk.t3
    public final boolean a(String str) {
        boolean z;
        if (!b(this.l)) {
            return false;
        }
        if (this.m) {
            z = v3.c(((t3) this).e, str, ((t3) this).f);
        } else {
            z = v3.b(((t3) this).e, str, ((t3) this).f);
        }
        if (z) {
            return true;
        }
        s1.b(n, "Incorrect signature for response.");
        return false;
    }
}
