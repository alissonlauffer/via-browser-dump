package com.flurry.sdk;

import com.flurry.sdk.C0147g2;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.flurry.sdk.f2 */
public class C0136f2 {

    /* renamed from: c */
    public static final Integer f422c = 50;

    /* renamed from: d */
    private static final String f423d = C0136f2.class.getSimpleName();

    /* renamed from: a */
    String f424a;

    /* renamed from: b */
    LinkedHashMap<String, List<String>> f425b;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.f2$a */
    public class C0137a implements AbstractC0201n2<List<C0147g2>> {
        C0137a(C0136f2 f2Var) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<List<C0147g2>> mo100a(int i) {
            return new C0175k2(new C0147g2.C0148a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.f2$b */
    public class C0138b implements AbstractC0201n2<List<C0147g2>> {
        C0138b(C0136f2 f2Var) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<List<C0147g2>> mo100a(int i) {
            return new C0175k2(new C0147g2.C0148a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.f2$c */
    public class C0139c implements AbstractC0201n2<List<C0147g2>> {
        C0139c(C0136f2 f2Var) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<List<C0147g2>> mo100a(int i) {
            return new C0175k2(new C0147g2.C0148a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.f2$d */
    public class C0140d implements AbstractC0201n2<List<C0147g2>> {
        C0140d(C0136f2 f2Var) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<List<C0147g2>> mo100a(int i) {
            return new C0175k2(new C0147g2.C0148a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.f2$e */
    public class C0141e implements AbstractC0201n2<List<C0147g2>> {
        C0141e(C0136f2 f2Var) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<List<C0147g2>> mo100a(int i) {
            return new C0175k2(new C0147g2.C0148a());
        }
    }

    public C0136f2(String str) {
        String str2 = str + "Main";
        this.f424a = str2;
        m420g(str2);
    }

    /* renamed from: b */
    private synchronized void m417b() {
        LinkedList linkedList = new LinkedList(this.f425b.keySet());
        new C0174k1(C0118e1.m386a().f361a.getFileStreamPath(m425l(this.f424a)), ".YFlurrySenderIndex.info.", 1, new C0140d(this)).mo254c();
        if (!linkedList.isEmpty()) {
            String str = this.f424a;
            m418d(str, linkedList, str);
        }
    }

    /* renamed from: d */
    private synchronized void m418d(String str, List<String> list, String str2) {
        C0328z2.m889d();
        String str3 = f423d;
        C0260s1.m686c(5, str3, "Saving Index File for " + str + " file name:" + C0118e1.m386a().f361a.getFileStreamPath(m425l(str)));
        C0174k1 k1Var = new C0174k1(C0118e1.m386a().f361a.getFileStreamPath(m425l(str)), str2, 1, new C0139c(this));
        ArrayList arrayList = new ArrayList();
        for (String str4 : list) {
            arrayList.add(new C0147g2(str4));
        }
        k1Var.mo253b(arrayList);
    }

    /* renamed from: e */
    private synchronized void m419e(String str, byte[] bArr) {
        C0328z2.m889d();
        String str2 = f423d;
        C0260s1.m686c(5, str2, "Saving Block File for " + str + " file name:" + C0118e1.m386a().f361a.getFileStreamPath(C0119e2.m394a(str)));
        C0119e2.m395b(str).mo253b(new C0119e2(bArr));
    }

    /* renamed from: g */
    private void m420g(String str) {
        this.f425b = new LinkedHashMap<>();
        ArrayList<String> arrayList = new ArrayList();
        if (m421h(str)) {
            List<String> i = m422i(str);
            if (i != null && i.size() > 0) {
                arrayList.addAll(i);
                for (String str2 : arrayList) {
                    m423j(str2);
                }
            }
            m424k(str);
        } else {
            List<C0147g2> list = (List) new C0174k1(C0118e1.m386a().f361a.getFileStreamPath(m425l(this.f424a)), str, 1, new C0137a(this)).mo252a();
            if (list == null) {
                C0260s1.m697n(f423d, "New main file also not found. returning..");
                return;
            }
            for (C0147g2 g2Var : list) {
                arrayList.add(g2Var.f452a);
            }
        }
        for (String str3 : arrayList) {
            this.f425b.put(str3, m426m(str3));
        }
    }

    /* renamed from: h */
    private synchronized boolean m421h(String str) {
        File fileStreamPath;
        fileStreamPath = C0118e1.m386a().f361a.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        String str2 = f423d;
        C0260s1.m686c(5, str2, "isOldIndexFilePresent: for " + str + fileStreamPath.exists());
        return fileStreamPath.exists();
    }

    /* renamed from: i */
    private synchronized List<String> m422i(String str) {
        ArrayList arrayList;
        Throwable th;
        C0328z2.m889d();
        String str2 = f423d;
        C0260s1.m686c(5, str2, "Reading Index File for " + str + " file name:" + C0118e1.m386a().f361a.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str))));
        File fileStreamPath = C0118e1.m386a().f361a.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        ArrayList arrayList2 = null;
        DataInputStream dataInputStream = null;
        if (fileStreamPath.exists()) {
            C0260s1.m686c(5, str2, "Reading Index File for " + str + " Found file.");
            try {
                DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    int readUnsignedShort = dataInputStream2.readUnsignedShort();
                    if (readUnsignedShort == 0) {
                        C0328z2.m890e(dataInputStream2);
                        return arrayList2;
                    }
                    arrayList = new ArrayList(readUnsignedShort);
                    for (int i = 0; i < readUnsignedShort; i++) {
                        try {
                            int readUnsignedShort2 = dataInputStream2.readUnsignedShort();
                            String str3 = f423d;
                            C0260s1.m686c(4, str3, "read iter " + i + " dataLength = " + readUnsignedShort2);
                            byte[] bArr = new byte[readUnsignedShort2];
                            dataInputStream2.readFully(bArr);
                            arrayList.add(new String(bArr));
                        } catch (Throwable th2) {
                            th = th2;
                            dataInputStream = dataInputStream2;
                            try {
                                C0260s1.m687d(6, f423d, "Error when loading persistent file", th);
                                arrayList2 = arrayList;
                                return arrayList2;
                            } finally {
                                C0328z2.m890e(dataInputStream);
                            }
                        }
                    }
                    dataInputStream2.readUnsignedShort();
                    C0328z2.m890e(dataInputStream2);
                    arrayList2 = arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    arrayList = arrayList2;
                    dataInputStream = dataInputStream2;
                    C0260s1.m687d(6, f423d, "Error when loading persistent file", th);
                    arrayList2 = arrayList;
                    return arrayList2;
                }
            } catch (Throwable th4) {
                th = th4;
                arrayList = arrayList2;
                C0260s1.m687d(6, f423d, "Error when loading persistent file", th);
                arrayList2 = arrayList;
                return arrayList2;
            }
        } else {
            C0260s1.m686c(5, str2, "Agent cache file doesn't exist.");
        }
        return arrayList2;
    }

    /* renamed from: j */
    private void m423j(String str) {
        List<String> i = m422i(str);
        if (i == null) {
            C0260s1.m697n(f423d, "No old file to replace");
            return;
        }
        for (String str2 : i) {
            byte[] n = m427n(str2);
            if (n == null) {
                C0260s1.m686c(6, f423d, "File does not exist");
            } else {
                m419e(str2, n);
                C0328z2.m889d();
                String str3 = f423d;
                C0260s1.m686c(5, str3, "Deleting  block File for " + str2 + " file name:" + C0118e1.m386a().f361a.getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str2))));
                File fileStreamPath = C0118e1.m386a().f361a.getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str2)));
                if (fileStreamPath.exists()) {
                    boolean delete = fileStreamPath.delete();
                    C0260s1.m686c(5, str3, "Found file for " + str2 + ". Deleted - " + delete);
                }
            }
        }
        m418d(str, i, ".YFlurrySenderIndex.info.");
        m424k(str);
    }

    /* renamed from: k */
    private static void m424k(String str) {
        C0328z2.m889d();
        String str2 = f423d;
        C0260s1.m686c(5, str2, "Deleting Index File for " + str + " file name:" + C0118e1.m386a().f361a.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str))));
        File fileStreamPath = C0118e1.m386a().f361a.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        if (fileStreamPath.exists()) {
            boolean delete = fileStreamPath.delete();
            C0260s1.m686c(5, str2, "Found file for " + str + ". Deleted - " + delete);
        }
    }

    /* renamed from: l */
    private static String m425l(String str) {
        return ".YFlurrySenderIndex.info.".concat(String.valueOf(str));
    }

    /* renamed from: m */
    private synchronized List<String> m426m(String str) {
        ArrayList arrayList;
        C0328z2.m889d();
        String str2 = f423d;
        C0260s1.m686c(5, str2, "Reading Index File for " + str + " file name:" + C0118e1.m386a().f361a.getFileStreamPath(m425l(str)));
        arrayList = new ArrayList();
        for (C0147g2 g2Var : (List) new C0174k1(C0118e1.m386a().f361a.getFileStreamPath(m425l(str)), ".YFlurrySenderIndex.info.", 1, new C0138b(this)).mo252a()) {
            arrayList.add(g2Var.f452a);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: n */
    private static byte[] m427n(String str) {
        Throwable th;
        byte[] bArr;
        C0328z2.m889d();
        String str2 = f423d;
        C0260s1.m686c(5, str2, "Reading block File for " + str + " file name:" + C0118e1.m386a().f361a.getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str))));
        File fileStreamPath = C0118e1.m386a().f361a.getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str)));
        ?? r4 = 0;
        if (fileStreamPath.exists()) {
            C0260s1.m686c(5, str2, "Reading Index File for " + str + " Found file.");
            try {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort == 0) {
                        C0328z2.m890e(dataInputStream);
                        return r4;
                    }
                    byte[] bArr2 = new byte[readUnsignedShort];
                    dataInputStream.readFully(bArr2);
                    dataInputStream.readUnsignedShort();
                    C0328z2.m890e(dataInputStream);
                    return bArr2;
                } catch (Throwable th2) {
                    th = th2;
                    r4 = dataInputStream;
                    bArr = r4;
                    try {
                        C0260s1.m687d(6, f423d, "Error when loading persistent file", th);
                        return bArr;
                    } finally {
                        C0328z2.m890e(r4);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bArr = r4;
                C0260s1.m687d(6, f423d, "Error when loading persistent file", th);
                return bArr;
            }
        } else {
            C0260s1.m686c(4, str2, "Agent cache file doesn't exist.");
            return r4;
        }
    }

    /* renamed from: o */
    private synchronized boolean m428o(String str) {
        boolean c;
        C0328z2.m889d();
        C0174k1 k1Var = new C0174k1(C0118e1.m386a().f361a.getFileStreamPath(m425l(str)), ".YFlurrySenderIndex.info.", 1, new C0141e(this));
        List<String> a = mo203a(str);
        if (a != null) {
            String str2 = f423d;
            C0260s1.m686c(4, str2, "discardOutdatedBlocksForDataKey: notSentBlocks = " + a.size());
            for (String str3 : a) {
                C0119e2.m395b(str3).mo254c();
                C0260s1.m686c(4, f423d, "discardOutdatedBlocksForDataKey: removed block = ".concat(String.valueOf(str3)));
            }
        }
        this.f425b.remove(str);
        c = k1Var.mo254c();
        m417b();
        return c;
    }

    /* renamed from: a */
    public final List<String> mo203a(String str) {
        return this.f425b.get(str);
    }

    /* renamed from: c */
    public final synchronized void mo204c(C0119e2 e2Var, String str) {
        boolean z;
        String str2 = f423d;
        C0260s1.m686c(4, str2, "addBlockInfo".concat(String.valueOf(str)));
        String str3 = e2Var.f367a;
        List<String> list = this.f425b.get(str);
        if (list == null) {
            C0260s1.m686c(4, str2, "New Data Key");
            list = new LinkedList<>();
            z = true;
        } else {
            z = false;
        }
        list.add(str3);
        if (list.size() > f422c.intValue()) {
            C0119e2.m395b(list.get(0)).mo254c();
            list.remove(0);
        }
        this.f425b.put(str, list);
        m418d(str, list, ".YFlurrySenderIndex.info.");
        if (z) {
            m417b();
        }
    }

    /* renamed from: f */
    public final boolean mo205f(String str, String str2) {
        boolean z;
        List<String> list = this.f425b.get(str2);
        if (list != null) {
            C0119e2.m395b(str).mo254c();
            z = list.remove(str);
        } else {
            z = false;
        }
        if (list == null || list.isEmpty()) {
            m428o(str2);
        } else {
            this.f425b.put(str2, list);
            m418d(str2, list, ".YFlurrySenderIndex.info.");
        }
        return z;
    }
}
