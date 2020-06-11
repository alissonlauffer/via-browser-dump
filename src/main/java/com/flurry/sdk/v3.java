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

public class v3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f205a = "v3";
    private static X509TrustManagerExtensions b = new X509TrustManagerExtensions(b());
    public static final Charset c = Charset.forName("UTF-8");

    static {
        if (Build.VERSION.SDK_INT >= 17) {
        }
    }

    public static synchronized boolean a(Context context) {
        boolean b2;
        synchronized (v3.class) {
            b2 = b(context, d(context));
        }
        return b2;
    }

    private static synchronized boolean b(Context context, String str) {
        boolean exists;
        synchronized (v3.class) {
            exists = context.getFileStreamPath(str).exists();
        }
        return exists;
    }

    public static synchronized boolean c(Context context) {
        boolean deleteFile;
        synchronized (v3.class) {
            deleteFile = context.deleteFile(d(context));
            if (deleteFile) {
                s1.e(f205a, "File removed from memory");
            } else {
                s1.e(f205a, "Error in clearing data from memory");
            }
        }
        return deleteFile;
    }

    private static String d(Context context) {
        return context.getPackageName() + ".variants";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x003b */
    public static synchronized void a(Context context, String str) {
        synchronized (v3.class) {
            if (str != null) {
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = context.openFileOutput(d(context), 0);
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
                        s1.a(f205a, "Error in writing data to file", e);
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
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042 A[SYNTHETIC, Splitter:B:25:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0051 A[SYNTHETIC, Splitter:B:35:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0059 A[SYNTHETIC, Splitter:B:42:0x0059] */
    public static synchronized String b(Context context) {
        FileInputStream fileInputStream;
        synchronized (v3.class) {
            try {
                fileInputStream = context.openFileInput(d(context));
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
                        fileInputStream.close();
                    }
                    String sb2 = sb.toString();
                    return sb2;
                } catch (FileNotFoundException unused) {
                    s1.e(f205a, "File not found!");
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (IOException e) {
                    e = e;
                    try {
                        s1.a(f205a, "Error in reading file!", e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException unused5) {
                fileInputStream = null;
                s1.e(f205a, "File not found!");
                if (fileInputStream != null) {
                }
                return null;
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
                s1.a(f205a, "Error in reading file!", e);
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                throw th;
            }
        }
    }

    public static boolean c(String str, String str2, String str3) {
        return a(str, str2, str3, "EC", "SHA256withECDSA");
    }

    public static void a(HttpsURLConnection httpsURLConnection) {
        if (Build.VERSION.SDK_INT >= 17 && b != null) {
            String str = "";
            try {
                Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
                List<X509Certificate> checkServerTrusted = b.checkServerTrusted((X509Certificate[]) Arrays.copyOf(serverCertificates, serverCertificates.length, X509Certificate[].class), "RSA", httpsURLConnection.getURL().getHost());
                if (checkServerTrusted != null) {
                    MessageDigest instance = MessageDigest.getInstance("SHA-256");
                    for (X509Certificate x509Certificate : checkServerTrusted) {
                        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                        instance.update(encoded, 0, encoded.length);
                        String encodeToString = Base64.encodeToString(instance.digest(), 2);
                        if (w3.b.contains(encodeToString)) {
                            s1.a(f205a, "Found matched pin: ".concat(String.valueOf(encodeToString)));
                            return;
                        }
                        str = str + "    sha256/" + encodeToString + ": " + x509Certificate.getSubjectDN().toString() + "\n";
                    }
                    throw new SSLPeerUnverifiedException("Certificate pinning failure!\n  Peer certificate chain:\n".concat(String.valueOf(str)));
                }
                throw new SSLPeerUnverifiedException("Empty trusted chain Certificate.");
            } catch (NoSuchAlgorithmException e) {
                s1.a(f205a, "Error in validating pinning: ", e);
            } catch (CertificateException e2) {
                s1.a(f205a, "Error in getting certificate: ", e2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    private static X509TrustManager b() {
        TrustManagerFactory trustManagerFactory;
        try {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            try {
                trustManagerFactory.init((KeyStore) null);
            } catch (NoSuchAlgorithmException e) {
                e = e;
            } catch (KeyStoreException e2) {
                e = e2;
                s1.a(f205a, "Error in getting trust manager: ", e);
                if (trustManagerFactory != null) {
                }
            }
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            trustManagerFactory = null;
            s1.a(f205a, "Error in getting trust manager: ", e);
            if (trustManagerFactory != null) {
            }
        } catch (KeyStoreException e4) {
            e = e4;
            trustManagerFactory = null;
            s1.a(f205a, "Error in getting trust manager: ", e);
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

    public static boolean b(String str, String str2, String str3) {
        return a(str, str2, str3, "RSA", "SHA256withRSA");
    }

    public static boolean a(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str) || (str4 = w3.f213a.get(str)) == null) {
            return false;
        }
        if (str.indexOf("com.flurry.configkey.prod.ec.") != -1) {
            return c(str4, str2, str3);
        }
        return b(str4, str2, str3);
    }

    private static boolean a(String str, String str2, String str3, String str4, String str5) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(str4).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            Signature instance = Signature.getInstance(str5);
            instance.initVerify(generatePublic);
            instance.update(str2.getBytes(c));
            return instance.verify(Base64.decode(str3, 0));
        } catch (GeneralSecurityException e) {
            s1.b(f205a, "GeneralSecurityException for Signature: ".concat(String.valueOf(e)));
            return false;
        }
    }

    public static boolean a() {
        try {
            KeyFactory.getInstance("EC");
            Signature.getInstance("SHA256withECDSA");
            return true;
        } catch (NoSuchAlgorithmException e) {
            s1.a(f205a, "ECDSA encryption is not available: ".concat(String.valueOf(e)));
            return false;
        }
    }

    public static boolean a(String str) {
        return "com.flurry.configkey.prod.ec.1".equals(str) || "com.flurry.configkey.prod.rot.6".equals(str) || "com.flurry.configkey.prod.fs.0".equals(str);
    }
}
