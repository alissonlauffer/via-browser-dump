package com.flurry.sdk;

import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.flurry.sdk.C0129ep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.g3 */
public class C0151g3 {

    /* renamed from: a */
    public static final String f453a = "g3";

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.g3$a */
    public class RunnableC0152a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Map f454a;

        RunnableC0152a(Map map) {
            this.f454a = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0151g3.m455e(this.f454a);
            C0151g3.m452b(this.f454a);
            C0151g3.m453c(this.f454a);
        }
    }

    /* renamed from: a */
    public static Map<String, String> m451a(boolean z) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("mem.java.max", Long.toString(Runtime.getRuntime().maxMemory()));
        } catch (RuntimeException e) {
            C0260s1.m689f(f453a, "Error retrieving max memory", e);
        }
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            hashMap.put("mem.pss", Long.toString((long) (memoryInfo.getTotalPss() * 1024)));
        } catch (RuntimeException e2) {
            C0260s1.m689f(f453a, "Error retrieving pss memory", e2);
        }
        if (C0118e1.m389h()) {
            hashMap.put("application.state", Integer.toString(C0129ep.EnumC0130a.ACTIVE.f399e));
        } else {
            hashMap.put("application.state", Integer.toString(C0129ep.EnumC0130a.BACKGROUND.f399e));
        }
        int i = -1;
        try {
            C0235q0.m624b();
            i = C0235q0.m635m() - 1;
        } catch (Exception unused) {
        }
        hashMap.put("net.status", Integer.toString(i));
        int i2 = 0;
        try {
            i2 = C0308x2.m837a();
        } catch (RuntimeException unused2) {
        }
        hashMap.put("orientation", Integer.toString(i2));
        if (!z) {
            C0118e1.m386a().mo191g(new RunnableC0152a(hashMap));
        } else {
            m455e(hashMap);
            m452b(hashMap);
            m453c(hashMap);
        }
        return hashMap;
    }

    /* renamed from: b */
    static void m452b(Map<String, String> map) {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            j = statFs.getBlockSizeLong();
        } else {
            j = (long) statFs.getBlockSize();
        }
        if (i >= 18) {
            j2 = statFs.getAvailableBlocksLong();
        } else {
            j2 = (long) statFs.getAvailableBlocks();
        }
        map.put("disk.size.free", Long.toString(j2 * j));
    }

    /* renamed from: c */
    static void m453c(Map<String, String> map) {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            j = statFs.getBlockSizeLong();
        } else {
            j = (long) statFs.getBlockSize();
        }
        if (i >= 18) {
            j2 = statFs.getBlockCountLong();
        } else {
            j2 = (long) statFs.getBlockCount();
        }
        map.put("disk.size.total", Long.toString(j2 * j));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m455e(Map<String, String> map) {
        Throwable th;
        BufferedReader bufferedReader;
        FileNotFoundException e;
        IOException e2;
        if (map != null) {
            Pattern compile = Pattern.compile("^Vm(RSS|Size|Peak):\\s+(\\d+)\\s+kB$");
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(new File("/proc/" + Integer.toString(Process.myPid())), "status"));
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                    try {
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            Matcher matcher = compile.matcher(readLine);
                            if (matcher.find()) {
                                String group = matcher.group(1);
                                String group2 = matcher.group(2);
                                if (!TextUtils.isEmpty(group)) {
                                    if (!TextUtils.isEmpty(group2)) {
                                        char c = 65535;
                                        int hashCode = group.hashCode();
                                        if (hashCode != 81458) {
                                            if (hashCode != 2483455) {
                                                if (hashCode == 2577441) {
                                                    if (group.equals("Size")) {
                                                        c = 1;
                                                    }
                                                }
                                            } else if (group.equals("Peak")) {
                                                c = 2;
                                            }
                                        } else if (group.equals("RSS")) {
                                            c = 0;
                                        }
                                        if (c == 0) {
                                            map.put("mem.rss", group2);
                                        } else if (c == 1) {
                                            map.put("mem.virt", group2);
                                        } else if (c == 2) {
                                            map.put("mem.virt.max", group2);
                                        }
                                    }
                                }
                            }
                        }
                        C0328z2.m890e(fileInputStream2);
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        C0328z2.m890e(fileInputStream);
                        C0328z2.m890e(bufferedReader);
                    } catch (IOException e4) {
                        e2 = e4;
                        fileInputStream = fileInputStream2;
                        try {
                            e2.printStackTrace();
                            C0328z2.m890e(fileInputStream);
                            C0328z2.m890e(bufferedReader);
                        } catch (Throwable th2) {
                            th = th2;
                            C0328z2.m890e(fileInputStream);
                            C0328z2.m890e(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        C0328z2.m890e(fileInputStream);
                        C0328z2.m890e(bufferedReader);
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    bufferedReader = null;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    C0328z2.m890e(fileInputStream);
                    C0328z2.m890e(bufferedReader);
                } catch (IOException e6) {
                    e2 = e6;
                    bufferedReader = null;
                    fileInputStream = fileInputStream2;
                    e2.printStackTrace();
                    C0328z2.m890e(fileInputStream);
                    C0328z2.m890e(bufferedReader);
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    fileInputStream = fileInputStream2;
                    C0328z2.m890e(fileInputStream);
                    C0328z2.m890e(bufferedReader);
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                bufferedReader = null;
                e.printStackTrace();
                C0328z2.m890e(fileInputStream);
                C0328z2.m890e(bufferedReader);
            } catch (IOException e8) {
                e2 = e8;
                bufferedReader = null;
                e2.printStackTrace();
                C0328z2.m890e(fileInputStream);
                C0328z2.m890e(bufferedReader);
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                C0328z2.m890e(fileInputStream);
                C0328z2.m890e(bufferedReader);
                throw th;
            }
            C0328z2.m890e(bufferedReader);
        }
    }
}
