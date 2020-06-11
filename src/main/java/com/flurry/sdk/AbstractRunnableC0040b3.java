package com.flurry.sdk;

import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: com.flurry.sdk.b3 */
public abstract class AbstractRunnableC0040b3 implements Runnable {

    /* renamed from: c */
    private static final String f131c = AbstractRunnableC0040b3.class.getSimpleName();

    /* renamed from: a */
    private PrintStream f132a;

    /* renamed from: b */
    private PrintWriter f133b;

    /* renamed from: a */
    public abstract void mo121a();

    public final void run() {
        try {
            mo121a();
        } catch (Throwable th) {
            if (this.f132a != null) {
                th.printStackTrace(this.f132a);
            } else {
                PrintWriter printWriter = this.f133b;
                if (printWriter != null) {
                    th.printStackTrace(printWriter);
                } else {
                    th.printStackTrace();
                }
            }
            C0260s1.m687d(6, f131c, "", th);
        }
    }
}
