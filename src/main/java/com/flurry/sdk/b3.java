package com.flurry.sdk;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class b3 implements Runnable {
    private static final String c = b3.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private PrintStream f66a;
    private PrintWriter b;

    public abstract void a();

    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            PrintStream printStream = this.f66a;
            if (printStream != null) {
                th.printStackTrace(printStream);
            } else {
                PrintWriter printWriter = this.b;
                if (printWriter != null) {
                    th.printStackTrace(printWriter);
                } else {
                    th.printStackTrace();
                }
            }
            s1.a(6, c, "", th);
        }
    }
}
