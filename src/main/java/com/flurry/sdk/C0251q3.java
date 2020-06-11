package com.flurry.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.C0143g;
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

/* renamed from: com.flurry.sdk.q3 */
public class C0251q3 extends AbstractRunnableC0267t3 {

    /* renamed from: n */
    private static final String f706n = C0251q3.class.getSimpleName();

    /* renamed from: o */
    private static String f707o;

    /* renamed from: k */
    private HttpsURLConnection f708k;

    /* renamed from: l */
    private String f709l;

    /* renamed from: m */
    private boolean f710m;

    C0251q3(String str) {
        this.f750a = str;
        f707o = "Flurry-Config/1.0 (Android " + Build.VERSION.RELEASE + "/" + Build.ID + ")";
    }

    /* renamed from: k */
    private boolean m671k(String str) {
        if (TextUtils.isEmpty(str)) {
            C0260s1.m693j(f706n, "Content-Signature is empty.");
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
        this.f753d = str3;
        if (TextUtils.isEmpty(str3)) {
            C0260s1.m693j(f706n, "Error to get keyid from Signature.");
            return false;
        }
        this.f754e = C0301w3.f831a.get(this.f753d);
        String str4 = f706n;
        C0260s1.m688e(str4, "Signature keyid: " + this.f753d + ", key: " + this.f754e);
        if (this.f754e == null) {
            C0260s1.m693j(str4, "Unknown keyid from Signature.");
            return false;
        }
        String str5 = "sha256ecdsa";
        boolean containsKey = hashMap.containsKey(str5);
        this.f710m = containsKey;
        if (!containsKey) {
            str5 = "sha256rsa";
        }
        String str6 = (String) hashMap.get(str5);
        this.f755f = str6;
        if (TextUtils.isEmpty(str6)) {
            C0260s1.m693j(str4, "Error to get rsa from Signature.");
            return false;
        }
        C0260s1.m688e(str4, "Signature rsa: " + this.f755f);
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0117  */
    @Override // com.flurry.sdk.AbstractRunnableC0267t3
    /* renamed from: a */
    public final InputStream mo321a() {
        BufferedWriter bufferedWriter;
        OutputStream outputStream;
        Throwable th;
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(this.f750a).openConnection();
        this.f708k = httpsURLConnection;
        httpsURLConnection.setReadTimeout(10000);
        this.f708k.setConnectTimeout(15000);
        this.f708k.setRequestMethod("POST");
        this.f708k.setRequestProperty("User-Agent", f707o);
        this.f708k.setRequestProperty("Content-Type", "application/json");
        this.f708k.setDoInput(true);
        this.f708k.setDoOutput(true);
        this.f708k.connect();
        C0284v3.m748b(this.f708k);
        this.f752c = UUID.randomUUID().toString().toUpperCase(Locale.ENGLISH);
        try {
            outputStream = this.f708k.getOutputStream();
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
                bufferedWriter.write(C0262s3.m702a(this.f752c));
                bufferedWriter.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = this.f708k.getResponseCode();
                if (responseCode < 400) {
                    this.f709l = this.f708k.getHeaderField("Content-Signature");
                    this.f756g = this.f708k.getHeaderField("ETag");
                    String str = f706n;
                    C0260s1.m688e(str, "Content-Signature: " + this.f709l + ", ETag: " + this.f756g);
                    if (responseCode == 304) {
                        if (mo322c(this.f752c)) {
                            this.f751b = C0143g.f437d;
                            C0260s1.m688e(str, "Empty 304 payload; No Change.");
                        } else {
                            this.f751b = new C0143g(C0143g.EnumC0144a.AUTHENTICATE, "GUID Signature Error.");
                            C0260s1.m693j(str, "Authentication error: " + this.f751b);
                        }
                    }
                    return this.f708k.getInputStream();
                }
                throw new IOException("Server response code is ".concat(String.valueOf(responseCode)));
            } catch (Throwable th3) {
                th = th3;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            bufferedWriter = null;
            th = th4;
            outputStream = null;
            if (bufferedWriter != null) {
            }
            if (outputStream != null) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.flurry.sdk.AbstractRunnableC0267t3
    /* renamed from: c */
    public final boolean mo322c(String str) {
        boolean z;
        if (!m671k(this.f709l)) {
            return false;
        }
        if (this.f710m) {
            z = C0284v3.m759m(this.f754e, str, this.f755f);
        } else {
            z = C0284v3.m757k(this.f754e, str, this.f755f);
        }
        if (z) {
            return true;
        }
        C0260s1.m693j(f706n, "Incorrect signature for response.");
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.flurry.sdk.AbstractRunnableC0267t3
    /* renamed from: d */
    public final void mo323d() {
        HttpsURLConnection httpsURLConnection = this.f708k;
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
    }

    @Override // com.flurry.sdk.AbstractRunnableC0267t3
    /* renamed from: e */
    public final boolean mo324e() {
        return "https://cfg.flurry.com/sdk/v1/config".equals(this.f750a);
    }
}
