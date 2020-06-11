package com.flurry.sdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class dk extends c3 {
    static final String z = dk.class.getSimpleName();
    private final i1<String, String> e = new i1<>();
    public final i1<String, String> f = new i1<>();
    private final Object g = new Object();
    public String h;
    public a i;
    public int j = 10000;
    public int k = 15000;
    public boolean l = true;
    d m;
    /* access modifiers changed from: private */
    public HttpURLConnection n;
    private boolean o;
    private boolean p;
    public boolean q;
    long r = -1;
    public long s = -1;
    public Exception t;
    public int u = -1;
    public boolean v;
    public int w = 25000;
    private z1 x = new z1(this);
    public boolean y;

    public enum a {
        kUnknown,
        kGet,
        kPost,
        kPut,
        kDelete,
        kHead;

        public final String toString() {
            int i = c.f107a[ordinal()];
            if (i == 1) {
                return "POST";
            }
            if (i == 2) {
                return "PUT";
            }
            if (i == 3) {
                return "DELETE";
            }
            if (i == 4) {
                return "HEAD";
            }
            if (i != 5) {
                return null;
            }
            return "GET";
        }
    }

    class b extends Thread {
        b() {
        }

        public final void run() {
            try {
                if (dk.this.n != null) {
                    dk.this.n.disconnect();
                }
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f107a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[a.values().length];
            f107a = iArr;
            iArr[a.kPost.ordinal()] = 1;
            f107a[a.kPut.ordinal()] = 2;
            f107a[a.kDelete.ordinal()] = 3;
            f107a[a.kHead.ordinal()] = 4;
            f107a[a.kGet.ordinal()] = 5;
        }
    }

    public interface d {
        void a();

        void a(dk dkVar, InputStream inputStream);

        void a(OutputStream outputStream);
    }

    private void i() {
        if (!this.o) {
            this.o = true;
            if (this.n != null) {
                new b().start();
            }
        }
    }

    private void j() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th2;
        OutputStream outputStream;
        if (!this.p) {
            this.h = z2.a(this.h);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.h).openConnection();
                this.n = httpURLConnection;
                httpURLConnection.setConnectTimeout(this.j);
                this.n.setReadTimeout(this.k);
                this.n.setRequestMethod(this.i.toString());
                this.n.setInstanceFollowRedirects(this.l);
                this.n.setDoOutput(a.kPost.equals(this.i));
                this.n.setDoInput(true);
                for (Map.Entry<String, String> entry : this.e.b()) {
                    this.n.addRequestProperty(entry.getKey(), entry.getValue());
                }
                if (!a.kGet.equals(this.i) && !a.kPost.equals(this.i)) {
                    this.n.setRequestProperty("Accept-Encoding", "");
                }
                if (!this.p) {
                    if (a.kPost.equals(this.i)) {
                        try {
                            outputStream = this.n.getOutputStream();
                            try {
                                bufferedOutputStream = new BufferedOutputStream(outputStream);
                            } catch (Throwable th3) {
                                bufferedOutputStream = null;
                                th2 = th3;
                                z2.a(bufferedOutputStream);
                                z2.a(outputStream);
                                throw th2;
                            }
                            try {
                                if (this.m != null && !h()) {
                                    this.m.a(bufferedOutputStream);
                                }
                                z2.a(bufferedOutputStream);
                                z2.a(outputStream);
                            } catch (Throwable th4) {
                                th2 = th4;
                                z2.a(bufferedOutputStream);
                                z2.a(outputStream);
                                throw th2;
                            }
                        } catch (Throwable th5) {
                            bufferedOutputStream = null;
                            th2 = th5;
                            outputStream = null;
                            z2.a(bufferedOutputStream);
                            z2.a(outputStream);
                            throw th2;
                        }
                    }
                    if (this.q) {
                        this.r = System.currentTimeMillis();
                    }
                    if (this.v) {
                        this.x.a((long) this.w);
                    }
                    this.u = this.n.getResponseCode();
                    if (this.q && this.r != -1) {
                        this.s = System.currentTimeMillis() - this.r;
                    }
                    this.x.a();
                    for (Map.Entry<String, List<String>> entry2 : this.n.getHeaderFields().entrySet()) {
                        for (String str : entry2.getValue()) {
                            this.f.a(entry2.getKey(), str);
                        }
                    }
                    if (!a.kGet.equals(this.i) && !a.kPost.equals(this.i)) {
                        k();
                    } else if (this.p) {
                        k();
                    } else {
                        try {
                            inputStream = this.n.getInputStream();
                            try {
                                bufferedInputStream = new BufferedInputStream(inputStream);
                                try {
                                    if (this.m != null && !h()) {
                                        this.m.a(this, bufferedInputStream);
                                    }
                                    z2.a((Closeable) bufferedInputStream);
                                    z2.a((Closeable) inputStream);
                                    k();
                                } catch (Throwable th6) {
                                    th = th6;
                                    z2.a((Closeable) bufferedInputStream);
                                    z2.a((Closeable) inputStream);
                                    throw th;
                                }
                            } catch (Throwable th7) {
                                bufferedInputStream = null;
                                th = th7;
                                z2.a((Closeable) bufferedInputStream);
                                z2.a((Closeable) inputStream);
                                throw th;
                            }
                        } catch (Throwable th8) {
                            bufferedInputStream = null;
                            th = th8;
                            inputStream = null;
                            z2.a((Closeable) bufferedInputStream);
                            z2.a((Closeable) inputStream);
                            throw th;
                        }
                    }
                }
            } finally {
                k();
            }
        }
    }

    private void k() {
        if (!this.o) {
            this.o = true;
            HttpURLConnection httpURLConnection = this.n;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    @Override // com.flurry.sdk.c3
    public final void b() {
        g();
    }

    public final boolean c() {
        return !d() && e();
    }

    public final boolean d() {
        return this.t != null;
    }

    public final boolean e() {
        int i2 = this.u;
        return i2 >= 200 && i2 < 400 && !this.y;
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        if (this.m != null && !h()) {
            this.m.a();
        }
    }

    public final void g() {
        String str = z;
        s1.a(3, str, "Cancelling http request: " + this.h);
        synchronized (this.g) {
            this.p = true;
        }
        i();
    }

    public final boolean h() {
        boolean z2;
        synchronized (this.g) {
            z2 = this.p;
        }
        return z2;
    }

    public final void a(String str, String str2) {
        this.e.a(str, str2);
    }

    public final List<String> a(String str) {
        return this.f.a(str);
    }

    @Override // com.flurry.sdk.b3
    public void a() {
        try {
            if (this.h != null) {
                if (!by.b().b) {
                    String str = z;
                    s1.a(3, str, "Network not available, aborting http request: " + this.h);
                } else {
                    if (this.i == null || a.kUnknown.equals(this.i)) {
                        this.i = a.kGet;
                    }
                    j();
                    String str2 = z;
                    s1.a(4, str2, "HTTP status: " + this.u + " for url: " + this.h);
                }
            }
        } catch (Exception e2) {
            String str3 = z;
            s1.a(4, str3, "HTTP status: " + this.u + " for url: " + this.h);
            String str4 = z;
            StringBuilder sb = new StringBuilder("Exception during http request: ");
            sb.append(this.h);
            s1.a(3, str4, sb.toString(), e2);
            if (this.n != null) {
                this.n.getReadTimeout();
                this.n.getConnectTimeout();
            }
            this.t = e2;
        } catch (Throwable th) {
            this.x.a();
            f();
            throw th;
        }
        this.x.a();
        f();
    }
}
