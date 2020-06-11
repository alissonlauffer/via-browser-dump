package com.flurry.sdk;

import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.flurry.sdk.ep;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g3 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f130a = "g3";

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f131a;

        a(Map map) {
            this.f131a = map;
        }

        public final void run() {
            g3.d(this.f131a);
            g3.a(this.f131a);
            g3.b(this.f131a);
        }
    }

    public static Map<String, String> a(boolean z) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("mem.java.max", Long.toString(Runtime.getRuntime().maxMemory()));
        } catch (RuntimeException e) {
            s1.a(f130a, "Error retrieving max memory", e);
        }
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            hashMap.put("mem.pss", Long.toString((long) (memoryInfo.getTotalPss() * 1024)));
        } catch (RuntimeException e2) {
            s1.a(f130a, "Error retrieving pss memory", e2);
        }
        if (e1.b()) {
            hashMap.put("application.state", Integer.toString(ep.a.ACTIVE.e));
        } else {
            hashMap.put("application.state", Integer.toString(ep.a.BACKGROUND.e));
        }
        int i = -1;
        try {
            q0.a();
            i = q0.k() - 1;
        } catch (Exception unused) {
        }
        hashMap.put("net.status", Integer.toString(i));
        int i2 = 0;
        try {
            i2 = x2.a();
        } catch (RuntimeException unused2) {
        }
        hashMap.put("orientation", Integer.toString(i2));
        if (!z) {
            e1.a().b(new a(hashMap));
        } else {
            d(hashMap);
            a(hashMap);
            b(hashMap);
        }
        return hashMap;
    }

    static void b(Map<String, String> map) {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j = statFs.getBlockSizeLong();
        } else {
            j = (long) statFs.getBlockSize();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockCountLong();
        } else {
            j2 = (long) statFs.getBlockCount();
        }
        map.put("disk.size.total", Long.toString(j2 * j));
    }

    /* access modifiers changed from: private */
    public static void d(Map<String, String> map) {
        BufferedReader bufferedReader;
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
                        z2.a((Closeable) fileInputStream2);
                    } catch (FileNotFoundException e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        z2.a((Closeable) fileInputStream);
                        z2.a(bufferedReader);
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            z2.a((Closeable) fileInputStream);
                            z2.a(bufferedReader);
                        } catch (Throwable th) {
                            th = th;
                            z2.a((Closeable) fileInputStream);
                            z2.a(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        z2.a((Closeable) fileInputStream);
                        z2.a(bufferedReader);
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    bufferedReader = null;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    z2.a((Closeable) fileInputStream);
                    z2.a(bufferedReader);
                } catch (IOException e4) {
                    e = e4;
                    bufferedReader = null;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    z2.a((Closeable) fileInputStream);
                    z2.a(bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    fileInputStream = fileInputStream2;
                    z2.a((Closeable) fileInputStream);
                    z2.a(bufferedReader);
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                bufferedReader = null;
                e.printStackTrace();
                z2.a((Closeable) fileInputStream);
                z2.a(bufferedReader);
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
                e.printStackTrace();
                z2.a((Closeable) fileInputStream);
                z2.a(bufferedReader);
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                z2.a((Closeable) fileInputStream);
                z2.a(bufferedReader);
                throw th;
            }
            z2.a(bufferedReader);
        }
    }

    static void a(Map<String, String> map) {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j = statFs.getBlockSizeLong();
        } else {
            j = (long) statFs.getBlockSize();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getAvailableBlocksLong();
        } else {
            j2 = (long) statFs.getAvailableBlocks();
        }
        map.put("disk.size.free", Long.toString(j2 * j));
    }
}
