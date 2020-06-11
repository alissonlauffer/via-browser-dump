package com.flurry.sdk;

import com.flurry.sdk.g2;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class f2 {
    public static final Integer c = 50;
    private static final String d = f2.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f123a;
    LinkedHashMap<String, List<String>> b;

    class a implements n2<List<g2>> {
        a(f2 f2Var) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<List<g2>> a(int i) {
            return new k2(new g2.a());
        }
    }

    class b implements n2<List<g2>> {
        b(f2 f2Var) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<List<g2>> a(int i) {
            return new k2(new g2.a());
        }
    }

    class c implements n2<List<g2>> {
        c(f2 f2Var) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<List<g2>> a(int i) {
            return new k2(new g2.a());
        }
    }

    class d implements n2<List<g2>> {
        d(f2 f2Var) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<List<g2>> a(int i) {
            return new k2(new g2.a());
        }
    }

    class e implements n2<List<g2>> {
        e(f2 f2Var) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<List<g2>> a(int i) {
            return new k2(new g2.a());
        }
    }

    public f2(String str) {
        String str2 = str + "Main";
        this.f123a = str2;
        b(str2);
    }

    private synchronized void a(String str, byte[] bArr) {
        z2.a();
        String str2 = d;
        s1.a(5, str2, "Saving Block File for " + str + " file name:" + e1.a().f110a.getFileStreamPath(e2.a(str)));
        e2.b(str).a(new e2(bArr));
    }

    private void b(String str) {
        this.b = new LinkedHashMap<>();
        ArrayList<String> arrayList = new ArrayList();
        if (c(str)) {
            List<String> d2 = d(str);
            if (d2 != null && d2.size() > 0) {
                arrayList.addAll(d2);
                for (String str2 : arrayList) {
                    e(str2);
                }
            }
            f(str);
        } else {
            List<g2> list = (List) new k1(e1.a().f110a.getFileStreamPath(g(this.f123a)), str, 1, new a(this)).a();
            if (list == null) {
                s1.c(d, "New main file also not found. returning..");
                return;
            }
            for (g2 g2Var : list) {
                arrayList.add(g2Var.f129a);
            }
        }
        for (String str3 : arrayList) {
            this.b.put(str3, h(str3));
        }
    }

    private synchronized boolean c(String str) {
        File fileStreamPath;
        fileStreamPath = e1.a().f110a.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        String str2 = d;
        s1.a(5, str2, "isOldIndexFilePresent: for " + str + fileStreamPath.exists());
        return fileStreamPath.exists();
    }

    private synchronized List<String> d(String str) {
        ArrayList arrayList;
        z2.a();
        String str2 = d;
        s1.a(5, str2, "Reading Index File for " + str + " file name:" + e1.a().f110a.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str))));
        File fileStreamPath = e1.a().f110a.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        ArrayList arrayList2 = null;
        DataInputStream dataInputStream = null;
        if (fileStreamPath.exists()) {
            String str3 = d;
            s1.a(5, str3, "Reading Index File for " + str + " Found file.");
            try {
                DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    int readUnsignedShort = dataInputStream2.readUnsignedShort();
                    if (readUnsignedShort == 0) {
                        z2.a((Closeable) dataInputStream2);
                        return arrayList2;
                    }
                    arrayList = new ArrayList(readUnsignedShort);
                    int i = 0;
                    while (i < readUnsignedShort) {
                        try {
                            int readUnsignedShort2 = dataInputStream2.readUnsignedShort();
                            String str4 = d;
                            s1.a(4, str4, "read iter " + i + " dataLength = " + readUnsignedShort2);
                            byte[] bArr = new byte[readUnsignedShort2];
                            dataInputStream2.readFully(bArr);
                            arrayList.add(new String(bArr));
                            i++;
                        } catch (Throwable th) {
                            th = th;
                            dataInputStream = dataInputStream2;
                            try {
                                s1.a(6, d, "Error when loading persistent file", th);
                                arrayList2 = arrayList;
                                return arrayList2;
                            } finally {
                                z2.a((Closeable) dataInputStream);
                            }
                        }
                    }
                    dataInputStream2.readUnsignedShort();
                    z2.a((Closeable) dataInputStream2);
                    arrayList2 = arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    arrayList = arrayList2;
                    dataInputStream = dataInputStream2;
                    s1.a(6, d, "Error when loading persistent file", th);
                    arrayList2 = arrayList;
                    return arrayList2;
                }
            } catch (Throwable th3) {
                th = th3;
                arrayList = arrayList2;
                s1.a(6, d, "Error when loading persistent file", th);
                arrayList2 = arrayList;
                return arrayList2;
            }
        } else {
            s1.a(5, d, "Agent cache file doesn't exist.");
        }
    }

    private void e(String str) {
        List<String> d2 = d(str);
        if (d2 == null) {
            s1.c(d, "No old file to replace");
            return;
        }
        for (String str2 : d2) {
            byte[] i = i(str2);
            if (i == null) {
                s1.a(6, d, "File does not exist");
            } else {
                a(str2, i);
                z2.a();
                String str3 = d;
                s1.a(5, str3, "Deleting  block File for " + str2 + " file name:" + e1.a().f110a.getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str2))));
                File fileStreamPath = e1.a().f110a.getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str2)));
                if (fileStreamPath.exists()) {
                    boolean delete = fileStreamPath.delete();
                    String str4 = d;
                    s1.a(5, str4, "Found file for " + str2 + ". Deleted - " + delete);
                }
            }
        }
        a(str, d2, ".YFlurrySenderIndex.info.");
        f(str);
    }

    private static void f(String str) {
        z2.a();
        String str2 = d;
        s1.a(5, str2, "Deleting Index File for " + str + " file name:" + e1.a().f110a.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str))));
        File fileStreamPath = e1.a().f110a.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        if (fileStreamPath.exists()) {
            boolean delete = fileStreamPath.delete();
            String str3 = d;
            s1.a(5, str3, "Found file for " + str + ". Deleted - " + delete);
        }
    }

    private static String g(String str) {
        return ".YFlurrySenderIndex.info.".concat(String.valueOf(str));
    }

    private synchronized List<String> h(String str) {
        ArrayList arrayList;
        z2.a();
        String str2 = d;
        s1.a(5, str2, "Reading Index File for " + str + " file name:" + e1.a().f110a.getFileStreamPath(g(str)));
        arrayList = new ArrayList();
        for (g2 g2Var : (List) new k1(e1.a().f110a.getFileStreamPath(g(str)), ".YFlurrySenderIndex.info.", 1, new b(this)).a()) {
            arrayList.add(g2Var.f129a);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static byte[] i(String str) {
        byte[] bArr;
        z2.a();
        String str2 = d;
        s1.a(5, str2, "Reading block File for " + str + " file name:" + e1.a().f110a.getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str))));
        File fileStreamPath = e1.a().f110a.getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str)));
        ? r3 = 0;
        if (fileStreamPath.exists()) {
            String str3 = d;
            s1.a(5, str3, "Reading Index File for " + str + " Found file.");
            try {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort == 0) {
                        z2.a((Closeable) dataInputStream);
                        return r3;
                    }
                    byte[] bArr2 = new byte[readUnsignedShort];
                    dataInputStream.readFully(bArr2);
                    dataInputStream.readUnsignedShort();
                    z2.a((Closeable) dataInputStream);
                    return bArr2;
                } catch (Throwable th) {
                    th = th;
                    r3 = dataInputStream;
                    bArr = r3;
                    try {
                        s1.a(6, d, "Error when loading persistent file", th);
                        return bArr;
                    } finally {
                        z2.a((Closeable) r3);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bArr = r3;
                s1.a(6, d, "Error when loading persistent file", th);
                return bArr;
            }
        } else {
            s1.a(4, d, "Agent cache file doesn't exist.");
            return r3;
        }
    }

    private synchronized boolean j(String str) {
        boolean b2;
        z2.a();
        k1 k1Var = new k1(e1.a().f110a.getFileStreamPath(g(str)), ".YFlurrySenderIndex.info.", 1, new e(this));
        List<String> a2 = a(str);
        if (a2 != null) {
            String str2 = d;
            s1.a(4, str2, "discardOutdatedBlocksForDataKey: notSentBlocks = " + a2.size());
            for (String str3 : a2) {
                e2.b(str3).b();
                s1.a(4, d, "discardOutdatedBlocksForDataKey: removed block = ".concat(String.valueOf(str3)));
            }
        }
        this.b.remove(str);
        b2 = k1Var.b();
        a();
        return b2;
    }

    private synchronized void a(String str, List<String> list, String str2) {
        z2.a();
        String str3 = d;
        s1.a(5, str3, "Saving Index File for " + str + " file name:" + e1.a().f110a.getFileStreamPath(g(str)));
        k1 k1Var = new k1(e1.a().f110a.getFileStreamPath(g(str)), str2, 1, new c(this));
        ArrayList arrayList = new ArrayList();
        for (String str4 : list) {
            arrayList.add(new g2(str4));
        }
        k1Var.a(arrayList);
    }

    public final synchronized void a(e2 e2Var, String str) {
        boolean z;
        s1.a(4, d, "addBlockInfo".concat(String.valueOf(str)));
        String str2 = e2Var.f111a;
        List<String> list = this.b.get(str);
        if (list == null) {
            s1.a(4, d, "New Data Key");
            list = new LinkedList<>();
            z = true;
        } else {
            z = false;
        }
        list.add(str2);
        if (list.size() > c.intValue()) {
            e2.b(list.get(0)).b();
            list.remove(0);
        }
        this.b.put(str, list);
        a(str, list, ".YFlurrySenderIndex.info.");
        if (z) {
            a();
        }
    }

    private synchronized void a() {
        LinkedList linkedList = new LinkedList(this.b.keySet());
        new k1(e1.a().f110a.getFileStreamPath(g(this.f123a)), ".YFlurrySenderIndex.info.", 1, new d(this)).b();
        if (!linkedList.isEmpty()) {
            a(this.f123a, linkedList, this.f123a);
        }
    }

    public final boolean a(String str, String str2) {
        boolean z;
        List<String> list = this.b.get(str2);
        if (list != null) {
            e2.b(str).b();
            z = list.remove(str);
        } else {
            z = false;
        }
        if (list == null || list.isEmpty()) {
            j(str2);
        } else {
            this.b.put(str2, list);
            a(str2, list, ".YFlurrySenderIndex.info.");
        }
        return z;
    }

    public final List<String> a(String str) {
        return this.b.get(str);
    }
}
