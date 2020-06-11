package com.flurry.sdk;

import com.flurry.sdk.g;
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

public abstract class t3 implements Runnable {
    private static final String i = t3.class.getSimpleName();
    private static ExecutorService j;

    /* renamed from: a  reason: collision with root package name */
    protected String f195a;
    protected g b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    public String h;

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        int f196a = 0;

        a() {
        }

        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("Flurry-Config-Background-");
            int i = this.f196a + 1;
            this.f196a = i;
            sb.append(i);
            return new Thread(runnable, sb.toString());
        }
    }

    public static Future<?> a(Runnable runnable) {
        s1.a(i, "Submit transport task.");
        if (j == null) {
            j = Executors.newFixedThreadPool(2, new a());
        }
        return j.submit(runnable);
    }

    /* access modifiers changed from: protected */
    public abstract InputStream a();

    /* access modifiers changed from: protected */
    public boolean a(String str) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    public boolean c() {
        return true;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final g h() {
        return this.b;
    }

    public void run() {
        this.b = g.c;
        InputStream inputStream = null;
        try {
            inputStream = a();
            if (this.b != g.c) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        s1.b(i, e2.getMessage(), e2);
                    }
                }
                b();
            } else if (inputStream == null) {
                s1.b(i, "Null InputStream");
                this.b = new g(g.a.IO, "Null InputStream");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        s1.b(i, e3.getMessage(), e3);
                    }
                }
                b();
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
                if (!a(byteArrayOutputStream.toString())) {
                    this.b = new g(g.a.AUTHENTICATE, "Signature Error.");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            s1.b(i, e4.getMessage(), e4);
                        }
                    }
                    b();
                    return;
                }
                this.h = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        s1.b(i, e5.getMessage(), e5);
                    }
                }
                b();
            }
        } catch (MalformedURLException e6) {
            this.b = new g(g.a.OTHER, e6.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    s1.b(i, e7.getMessage(), e7);
                }
            }
            b();
        } catch (SSLException e8) {
            s1.a(i, e8.getMessage(), e8);
            this.b = new g(g.a.UNKNOWN_CERTIFICATE, e8.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                    s1.b(i, e9.getMessage(), e9);
                }
            }
            b();
        } catch (IOException e10) {
            s1.a(i, e10.getMessage(), e10);
            this.b = new g(g.a.IO, e10.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    s1.b(i, e11.getMessage(), e11);
                }
            }
            b();
        } catch (Exception e12) {
            this.b = new g(g.a.OTHER, e12.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e13) {
                    s1.b(i, e13.getMessage(), e13);
                }
            }
            b();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e14) {
                    s1.b(i, e14.getMessage(), e14);
                }
            }
            b();
            throw th;
        }
    }
}
