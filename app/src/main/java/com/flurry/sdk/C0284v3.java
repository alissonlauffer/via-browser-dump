package com.flurry.sdk;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.flurry.sdk.v3 */
public class C0284v3 {

    /* renamed from: a */
    private static final String f788a = "v3";

    /* renamed from: b */
    private static X509TrustManagerExtensions f789b = new X509TrustManagerExtensions(m755i());

    /* renamed from: c */
    public static final Charset f790c = Charset.forName("UTF-8");

    static {
        if (Build.VERSION.SDK_INT >= 17) {
        }
    }

    /* renamed from: a */
    public static synchronized void m747a(Context context, String str) {
        synchronized (C0284v3.class) {
            if (str != null) {
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = context.openFileOutput(m760n(context), 0);
                    fileOutputStream.write(str.getBytes());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                } catch (IOException e) {
                    try {
                        C0260s1.m689f(f788a, "Error in writing data to file", e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (IOException unused2) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                return;
            }
            return;
        }
    }

    /* renamed from: b */
    public static void m748b(HttpsURLConnection httpsURLConnection) {
        if (Build.VERSION.SDK_INT >= 17 && f789b != null) {
            String str = "";
            try {
                Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
                List<X509Certificate> checkServerTrusted = f789b.checkServerTrusted((X509Certificate[]) Arrays.copyOf(serverCertificates, serverCertificates.length, X509Certificate[].class), "RSA", httpsURLConnection.getURL().getHost());
                if (checkServerTrusted != null) {
                    MessageDigest instance = MessageDigest.getInstance("SHA-256");
                    for (X509Certificate x509Certificate : checkServerTrusted) {
                        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                        instance.update(encoded, 0, encoded.length);
                        String encodeToString = Base64.encodeToString(instance.digest(), 2);
                        if (C0301w3.f832b.contains(encodeToString)) {
                            C0260s1.m688e(f788a, "Found matched pin: ".concat(String.valueOf(encodeToString)));
                            return;
                        }
                        str = str + "    sha256/" + encodeToString + ": " + x509Certificate.getSubjectDN().toString() + "\n";
                    }
                    throw new SSLPeerUnverifiedException("Certificate pinning failure!\n  Peer certificate chain:\n".concat(String.valueOf(str)));
                }
                throw new SSLPeerUnverifiedException("Empty trusted chain Certificate.");
            } catch (NoSuchAlgorithmException e) {
                C0260s1.m689f(f788a, "Error in validating pinning: ", e);
            } catch (CertificateException e2) {
                C0260s1.m689f(f788a, "Error in getting certificate: ", e2);
            }
        }
    }

    /* renamed from: c */
    public static boolean m749c() {
        try {
            KeyFactory.getInstance("EC");
            Signature.getInstance("SHA256withECDSA");
            return true;
        } catch (NoSuchAlgorithmException e) {
            C0260s1.m688e(f788a, "ECDSA encryption is not available: ".concat(String.valueOf(e)));
            return false;
        }
    }

    /* renamed from: d */
    public static synchronized boolean m750d(Context context) {
        boolean j;
        synchronized (C0284v3.class) {
            j = m756j(context, m760n(context));
        }
        return j;
    }

    /* renamed from: e */
    public static boolean m751e(String str) {
        return "com.flurry.configkey.prod.ec.1".equals(str) || "com.flurry.configkey.prod.rot.6".equals(str) || "com.flurry.configkey.prod.fs.0".equals(str);
    }

    /* renamed from: f */
    public static boolean m752f(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str) || (str4 = C0301w3.f831a.get(str)) == null) {
            return false;
        }
        if (str.indexOf("com.flurry.configkey.prod.ec.") != -1) {
            return m759m(str4, str2, str3);
        }
        return m757k(str4, str2, str3);
    }

    /* renamed from: g */
    private static boolean m753g(String str, String str2, String str3, String str4, String str5) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(str4).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            Signature instance = Signature.getInstance(str5);
            instance.initVerify(generatePublic);
            instance.update(str2.getBytes(f790c));
            return instance.verify(Base64.decode(str3, 0));
        } catch (GeneralSecurityException e) {
            C0260s1.m693j(f788a, "GeneralSecurityException for Signature: ".concat(String.valueOf(e)));
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0042 A[SYNTHETIC, Splitter:B:26:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0051 A[SYNTHETIC, Splitter:B:36:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0059 A[SYNTHETIC, Splitter:B:43:0x0059] */
    /* renamed from: h */
    public static synchronized String m754h(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        IOException e;
        synchronized (C0284v3.class) {
            try {
                fileInputStream = context.openFileInput(m760n(context));
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return sb.toString();
                } catch (FileNotFoundException unused2) {
                    C0260s1.m701r(f788a, "File not found!");
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C0260s1.m689f(f788a, "Error in reading file!", e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException unused6) {
                fileInputStream = null;
                C0260s1.m701r(f788a, "File not found!");
                if (fileInputStream != null) {
                }
                return null;
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
                C0260s1.m689f(f788a, "Error in reading file!", e);
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* renamed from: i */
    private static X509TrustManager m755i() {
        TrustManagerFactory trustManagerFactory;
        NoSuchAlgorithmException e;
        KeyStoreException e2;
        try {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            try {
                trustManagerFactory.init((KeyStore) null);
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
            } catch (KeyStoreException e4) {
                e2 = e4;
                C0260s1.m689f(f788a, "Error in getting trust manager: ", e2);
                if (trustManagerFactory != null) {
                }
            }
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            trustManagerFactory = null;
            C0260s1.m689f(f788a, "Error in getting trust manager: ", e);
            if (trustManagerFactory != null) {
            }
        } catch (KeyStoreException e6) {
            e2 = e6;
            trustManagerFactory = null;
            C0260s1.m689f(f788a, "Error in getting trust manager: ", e2);
            if (trustManagerFactory != null) {
            }
        }
        if (trustManagerFactory != null) {
            return null;
        }
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    /* renamed from: j */
    private static synchronized boolean m756j(Context context, String str) {
        boolean exists;
        synchronized (C0284v3.class) {
            exists = context.getFileStreamPath(str).exists();
        }
        return exists;
    }

    /* renamed from: k */
    public static boolean m757k(String str, String str2, String str3) {
        return m753g(str, str2, str3, "RSA", "SHA256withRSA");
    }

    /* renamed from: l */
    public static synchronized boolean m758l(Context context) {
        boolean deleteFile;
        synchronized (C0284v3.class) {
            deleteFile = context.deleteFile(m760n(context));
            if (deleteFile) {
                C0260s1.m701r(f788a, "File removed from memory");
            } else {
                C0260s1.m701r(f788a, "Error in clearing data from memory");
            }
        }
        return deleteFile;
    }

    /* renamed from: m */
    public static boolean m759m(String str, String str2, String str3) {
        return m753g(str, str2, str3, "EC", "SHA256withECDSA");
    }

    /* renamed from: n */
    private static String m760n(Context context) {
        return context.getPackageName() + ".variants";
    }
}
