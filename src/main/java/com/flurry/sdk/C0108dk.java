package com.flurry.sdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.dk */
public class C0108dk extends AbstractC0075c3 {

    /* renamed from: z */
    static final String f320z = C0108dk.class.getSimpleName();

    /* renamed from: e */
    private final C0162i1<String, String> f321e = new C0162i1<>();

    /* renamed from: f */
    public final C0162i1<String, String> f322f = new C0162i1<>();

    /* renamed from: g */
    private final Object f323g = new Object();

    /* renamed from: h */
    public String f324h;

    /* renamed from: i */
    public EnumC0109a f325i;

    /* renamed from: j */
    public int f326j = 10000;

    /* renamed from: k */
    public int f327k = 15000;

    /* renamed from: l */
    public boolean f328l = true;

    /* renamed from: m */
    AbstractC0112d f329m;

    /* renamed from: n */
    private HttpURLConnection f330n;

    /* renamed from: o */
    private boolean f331o;

    /* renamed from: p */
    private boolean f332p;

    /* renamed from: q */
    public boolean f333q;

    /* renamed from: r */
    long f334r = -1;

    /* renamed from: s */
    public long f335s = -1;

    /* renamed from: t */
    public Exception f336t;

    /* renamed from: u */
    public int f337u = -1;

    /* renamed from: v */
    public boolean f338v;

    /* renamed from: w */
    public int f339w = 25000;

    /* renamed from: x */
    private C0326z1 f340x = new C0326z1(this);

    /* renamed from: y */
    public boolean f341y;

    /* renamed from: com.flurry.sdk.dk$a */
    public enum EnumC0109a {
        kUnknown,
        kGet,
        kPost,
        kPut,
        kDelete,
        kHead;

        public final String toString() {
            int i = C0111c.f350a[ordinal()];
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

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.dk$b */
    public class C0110b extends Thread {
        C0110b() {
        }

        public final void run() {
            try {
                if (C0108dk.this.f330n != null) {
                    C0108dk.this.f330n.disconnect();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.dk$c */
    public static /* synthetic */ class C0111c {

        /* renamed from: a */
        static final /* synthetic */ int[] f350a;

        static {
            int[] iArr = new int[EnumC0109a.values().length];
            f350a = iArr;
            try {
                iArr[EnumC0109a.kPost.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f350a[EnumC0109a.kPut.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f350a[EnumC0109a.kDelete.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f350a[EnumC0109a.kHead.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f350a[EnumC0109a.kGet.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: com.flurry.sdk.dk$d */
    public interface AbstractC0112d {
        /* renamed from: a */
        void mo183a();

        /* renamed from: b */
        void mo184b(C0108dk dkVar, InputStream inputStream);

        /* renamed from: c */
        void mo185c(OutputStream outputStream);
    }

    /* renamed from: l */
    private void m368l() {
        if (!this.f331o) {
            this.f331o = true;
            if (this.f330n != null) {
                new C0110b().start();
            }
        }
    }

    /* renamed from: m */
    private void m369m() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th2;
        OutputStream outputStream;
        if (!this.f332p) {
            this.f324h = C0328z2.m888c(this.f324h);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f324h).openConnection();
                this.f330n = httpURLConnection;
                httpURLConnection.setConnectTimeout(this.f326j);
                this.f330n.setReadTimeout(this.f327k);
                this.f330n.setRequestMethod(this.f325i.toString());
                this.f330n.setInstanceFollowRedirects(this.f328l);
                this.f330n.setDoOutput(EnumC0109a.kPost.equals(this.f325i));
                this.f330n.setDoInput(true);
                for (Map.Entry<String, String> entry : this.f321e.mo234e()) {
                    this.f330n.addRequestProperty(entry.getKey(), entry.getValue());
                }
                if (!EnumC0109a.kGet.equals(this.f325i) && !EnumC0109a.kPost.equals(this.f325i)) {
                    this.f330n.setRequestProperty("Accept-Encoding", "");
                }
                if (!this.f332p) {
                    if (EnumC0109a.kPost.equals(this.f325i)) {
                        try {
                            outputStream = this.f330n.getOutputStream();
                            try {
                                bufferedOutputStream = new BufferedOutputStream(outputStream);
                            } catch (Throwable th3) {
                                bufferedOutputStream = null;
                                th2 = th3;
                                C0328z2.m890e(bufferedOutputStream);
                                C0328z2.m890e(outputStream);
                                throw th2;
                            }
                            try {
                                if (this.f329m != null && !mo180k()) {
                                    this.f329m.mo185c(bufferedOutputStream);
                                }
                                C0328z2.m890e(bufferedOutputStream);
                                C0328z2.m890e(outputStream);
                            } catch (Throwable th4) {
                                th2 = th4;
                                C0328z2.m890e(bufferedOutputStream);
                                C0328z2.m890e(outputStream);
                                throw th2;
                            }
                        } catch (Throwable th5) {
                            bufferedOutputStream = null;
                            th2 = th5;
                            outputStream = null;
                            C0328z2.m890e(bufferedOutputStream);
                            C0328z2.m890e(outputStream);
                            throw th2;
                        }
                    }
                    if (this.f333q) {
                        this.f334r = System.currentTimeMillis();
                    }
                    if (this.f338v) {
                        this.f340x.mo372c((long) this.f339w);
                    }
                    this.f337u = this.f330n.getResponseCode();
                    if (this.f333q && this.f334r != -1) {
                        this.f335s = System.currentTimeMillis() - this.f334r;
                    }
                    this.f340x.mo371b();
                    for (Map.Entry<String, List<String>> entry2 : this.f330n.getHeaderFields().entrySet()) {
                        for (String str : entry2.getValue()) {
                            this.f322f.mo233d(entry2.getKey(), str);
                        }
                    }
                    if (!EnumC0109a.kGet.equals(this.f325i) && !EnumC0109a.kPost.equals(this.f325i)) {
                        m370n();
                    } else if (this.f332p) {
                        m370n();
                    } else {
                        try {
                            inputStream = this.f330n.getInputStream();
                            try {
                                bufferedInputStream = new BufferedInputStream(inputStream);
                                try {
                                    if (this.f329m != null && !mo180k()) {
                                        this.f329m.mo184b(this, bufferedInputStream);
                                    }
                                    C0328z2.m890e(bufferedInputStream);
                                    C0328z2.m890e(inputStream);
                                    m370n();
                                } catch (Throwable th6) {
                                    th = th6;
                                    C0328z2.m890e(bufferedInputStream);
                                    C0328z2.m890e(inputStream);
                                    throw th;
                                }
                            } catch (Throwable th7) {
                                bufferedInputStream = null;
                                th = th7;
                                C0328z2.m890e(bufferedInputStream);
                                C0328z2.m890e(inputStream);
                                throw th;
                            }
                        } catch (Throwable th8) {
                            bufferedInputStream = null;
                            th = th8;
                            inputStream = null;
                            C0328z2.m890e(bufferedInputStream);
                            C0328z2.m890e(inputStream);
                            throw th;
                        }
                    }
                }
            } finally {
                m370n();
            }
        }
    }

    /* renamed from: n */
    private void m370n() {
        if (!this.f331o) {
            this.f331o = true;
            HttpURLConnection httpURLConnection = this.f330n;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    @Override // com.flurry.sdk.AbstractRunnableC0040b3
    /* renamed from: a */
    public void mo121a() {
        try {
            if (this.f324h != null) {
                if (!C0054by.m254a().f176b) {
                    String str = f320z;
                    C0260s1.m686c(3, str, "Network not available, aborting http request: " + this.f324h);
                } else {
                    EnumC0109a aVar = this.f325i;
                    if (aVar == null || EnumC0109a.kUnknown.equals(aVar)) {
                        this.f325i = EnumC0109a.kGet;
                    }
                    m369m();
                    String str2 = f320z;
                    C0260s1.m686c(4, str2, "HTTP status: " + this.f337u + " for url: " + this.f324h);
                }
            }
        } catch (Exception e) {
            String str3 = f320z;
            C0260s1.m686c(4, str3, "HTTP status: " + this.f337u + " for url: " + this.f324h);
            StringBuilder sb = new StringBuilder("Exception during http request: ");
            sb.append(this.f324h);
            C0260s1.m687d(3, str3, sb.toString(), e);
            HttpURLConnection httpURLConnection = this.f330n;
            if (httpURLConnection != null) {
                httpURLConnection.getReadTimeout();
                this.f330n.getConnectTimeout();
            }
            this.f336t = e;
        } catch (Throwable th) {
            this.f340x.mo371b();
            mo178i();
            throw th;
        }
        this.f340x.mo371b();
        mo178i();
    }

    @Override // com.flurry.sdk.AbstractC0075c3
    /* renamed from: b */
    public final void mo147b() {
        mo179j();
    }

    /* renamed from: d */
    public final List<String> mo173d(String str) {
        return this.f322f.mo230a(str);
    }

    /* renamed from: e */
    public final void mo174e(String str, String str2) {
        this.f321e.mo233d(str, str2);
    }

    /* renamed from: f */
    public final boolean mo175f() {
        return !mo176g() && mo177h();
    }

    /* renamed from: g */
    public final boolean mo176g() {
        return this.f336t != null;
    }

    /* renamed from: h */
    public final boolean mo177h() {
        int i = this.f337u;
        return i >= 200 && i < 400 && !this.f341y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final void mo178i() {
        if (this.f329m != null && !mo180k()) {
            this.f329m.mo183a();
        }
    }

    /* renamed from: j */
    public final void mo179j() {
        String str = f320z;
        C0260s1.m686c(3, str, "Cancelling http request: " + this.f324h);
        synchronized (this.f323g) {
            this.f332p = true;
        }
        m368l();
    }

    /* renamed from: k */
    public final boolean mo180k() {
        boolean z;
        synchronized (this.f323g) {
            z = this.f332p;
        }
        return z;
    }
}
