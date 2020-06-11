package com.flurry.sdk;

import com.flurry.sdk.C0143g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import javax.net.ssl.SSLException;

/* renamed from: com.flurry.sdk.t3 */
public abstract class AbstractRunnableC0267t3 implements Runnable {

    /* renamed from: i */
    private static final String f748i = AbstractRunnableC0267t3.class.getSimpleName();

    /* renamed from: j */
    private static ExecutorService f749j;

    /* renamed from: a */
    protected String f750a;

    /* renamed from: b */
    protected C0143g f751b;

    /* renamed from: c */
    protected String f752c;

    /* renamed from: d */
    protected String f753d;

    /* renamed from: e */
    protected String f754e;

    /* renamed from: f */
    protected String f755f;

    /* renamed from: g */
    protected String f756g;

    /* renamed from: h */
    public String f757h;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.t3$a */
    public class ThreadFactoryC0268a implements ThreadFactory {

        /* renamed from: a */
        int f758a = 0;

        ThreadFactoryC0268a() {
        }

        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("Flurry-Config-Background-");
            int i = this.f758a + 1;
            this.f758a = i;
            sb.append(i);
            return new Thread(runnable, sb.toString());
        }
    }

    /* renamed from: b */
    public static Future<?> m704b(Runnable runnable) {
        C0260s1.m688e(f748i, "Submit transport task.");
        if (f749j == null) {
            f749j = Executors.newFixedThreadPool(2, new ThreadFactoryC0268a());
        }
        return f749j.submit(runnable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract InputStream mo321a();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo322c(String str) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo323d();

    /* renamed from: e */
    public boolean mo324e() {
        return true;
    }

    /* renamed from: f */
    public final String mo330f() {
        return this.f752c;
    }

    /* renamed from: g */
    public final String mo331g() {
        return this.f753d;
    }

    /* renamed from: h */
    public final String mo332h() {
        return this.f755f;
    }

    /* renamed from: i */
    public final String mo333i() {
        return this.f756g;
    }

    /* renamed from: j */
    public final C0143g mo334j() {
        return this.f751b;
    }

    public void run() {
        C0143g gVar = C0143g.f436c;
        this.f751b = gVar;
        InputStream inputStream = null;
        try {
            inputStream = mo321a();
            if (this.f751b != gVar) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        C0260s1.m694k(f748i, e.getMessage(), e);
                    }
                }
                mo323d();
            } else if (inputStream == null) {
                C0260s1.m693j(f748i, "Null InputStream");
                this.f751b = new C0143g(C0143g.EnumC0144a.IO, "Null InputStream");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        C0260s1.m694k(f748i, e2.getMessage(), e2);
                    }
                }
                mo323d();
            } else {
                ReadableByteChannel newChannel = Channels.newChannel(inputStream);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                WritableByteChannel newChannel2 = Channels.newChannel(byteArrayOutputStream);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(16384);
                while (true) {
                    if (newChannel.read(allocateDirect) < 0 && allocateDirect.position() <= 0) {
                        break;
                    }
                    allocateDirect.flip();
                    newChannel2.write(allocateDirect);
                    allocateDirect.compact();
                }
                byteArrayOutputStream.flush();
                if (!mo322c(byteArrayOutputStream.toString())) {
                    this.f751b = new C0143g(C0143g.EnumC0144a.AUTHENTICATE, "Signature Error.");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            C0260s1.m694k(f748i, e3.getMessage(), e3);
                        }
                    }
                    mo323d();
                    return;
                }
                this.f757h = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        C0260s1.m694k(f748i, e4.getMessage(), e4);
                    }
                }
                mo323d();
            }
        } catch (MalformedURLException e5) {
            this.f751b = new C0143g(C0143g.EnumC0144a.OTHER, e5.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    C0260s1.m694k(f748i, e6.getMessage(), e6);
                }
            }
            mo323d();
        } catch (SSLException e7) {
            C0260s1.m689f(f748i, e7.getMessage(), e7);
            this.f751b = new C0143g(C0143g.EnumC0144a.UNKNOWN_CERTIFICATE, e7.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                    C0260s1.m694k(f748i, e8.getMessage(), e8);
                }
            }
            mo323d();
        } catch (IOException e9) {
            C0260s1.m689f(f748i, e9.getMessage(), e9);
            this.f751b = new C0143g(C0143g.EnumC0144a.IO, e9.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    C0260s1.m694k(f748i, e10.getMessage(), e10);
                }
            }
            mo323d();
        } catch (Exception e11) {
            this.f751b = new C0143g(C0143g.EnumC0144a.OTHER, e11.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e12) {
                    C0260s1.m694k(f748i, e12.getMessage(), e12);
                }
            }
            mo323d();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e13) {
                    C0260s1.m694k(f748i, e13.getMessage(), e13);
                }
            }
            mo323d();
            throw th;
        }
    }
}
