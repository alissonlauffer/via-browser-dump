package mark.via.i.a;

import a.a.b.p.d;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mark.via.BrowserApp;
import mark.via.util.b;

/* compiled from: AdBlock */
public class a {
    private static final Set<String> d = new HashSet();
    private static final Set<String> e = new HashSet();
    private static final HashMap<String, String> f = new HashMap<>();
    private static volatile a g;

    /* renamed from: a  reason: collision with root package name */
    private boolean f262a = true;
    private long b = 0;
    private mark.via.f.a c;

    /* renamed from: mark.via.i.a.a$a  reason: collision with other inner class name */
    /* compiled from: AdBlock */
    class C0033a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStreamReader f263a;
        final /* synthetic */ Set b;

        C0033a(a aVar, InputStreamReader inputStreamReader, Set set) {
            this.f263a = inputStreamReader;
            this.b = set;
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00ae A[SYNTHETIC, Splitter:B:47:0x00ae] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00b5 A[Catch:{ Exception -> 0x00bb }] */
        /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
        public void run() {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(this.f263a);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            String trim = readLine.trim();
                            if (!trim.isEmpty()) {
                                if (!trim.startsWith("#")) {
                                    if (trim.contains("\t") || trim.contains(" ")) {
                                        String replace = trim.replace("127.0.0.1", "").replace("0.0.0.0", "").replace("::1", "").replace("\t", "");
                                        int indexOf = replace.indexOf("#");
                                        if (indexOf >= 0) {
                                            replace = replace.substring(0, indexOf);
                                        }
                                        trim = replace.trim();
                                        if (!trim.isEmpty() && !trim.equals("localhost")) {
                                            while (trim.contains(" ")) {
                                                trim = trim.substring(trim.indexOf(" ")).trim();
                                            }
                                        }
                                    }
                                    this.b.add(trim);
                                }
                            }
                        } else {
                            try {
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        try {
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (this.f263a == null) {
                                this.f263a.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            if (this.f263a != null) {
                                this.f263a.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                        }
                        if (this.f263a != null) {
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                if (this.f263a != null) {
                    this.f263a.close();
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (bufferedReader != null) {
                }
                if (this.f263a == null) {
                }
            }
        }
    }

    private a(Context context) {
        this.c = mark.via.f.a.b(context);
        a(context);
    }

    public static a b(Context context) {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a(context);
                }
            }
        }
        return g;
    }

    private void c(Context context) {
        if (this.f262a) {
            d();
            a(context, "hosts.txt", e);
            c();
        }
    }

    private void d() {
        String substring;
        if (f.isEmpty()) {
            String[] split = "/ad.gif\n/images_ad/\n/images/ad_\n/js/ads/\n/js/ad.js\n/ad_js/\n/ad.js?\nPublic/js/duileft.js\nPublic/js/duiright.js\nPublic/js/floatleft.js\nPublic/js/floatright.js\nmyjs/alljs.js\nmyjs/tongji.js\nmyjs/playting.js\nmyjs/playqian.js\n/images/uaredirect.js\n/popunder.\naddthis.com/js/300/addthis_widget.js\nsub.avgle.com/fd/\n/pingd?\nqq.com/collect?\nsohu.com/pv.js\ns.go.sohu.com/cRsd/?callback=\n&ad_type=\n/sa.gif?\nsohu.com/count/\nsina.cn/cm/sinaads_\nsina.cn/wap/impress?\nsina.com.cn/view?\n/atrk.js\n.com/pv.gif?\nbaidu.com/pixel?\nwebterren.com/webdig.js?\nm.592meiju.com/tpl/mstyle/js/dibu.js\nm.592meiju.com/runtime/ad/mobileimg.js\nm.592meiju.com/indexbottom.js".split("\n");
            if (split.length > 0) {
                for (String str : split) {
                    if (str != null && str.length() >= 5) {
                        int i = 0;
                        do {
                            substring = str.substring(i, i + 5);
                            i++;
                            if (!f.containsKey(substring)) {
                                break;
                            }
                        } while (i <= str.length() - 5);
                        if (!f.containsKey(substring)) {
                            f.put(substring, str);
                        } else {
                            f.put(substring, f.get(substring) + "," + str);
                        }
                    }
                }
            }
        }
    }

    public void a(Context context) {
        this.f262a = this.c.a();
        c(context);
    }

    public boolean e(String str) {
        if (!d.contains(str)) {
            return false;
        }
        d.remove(str);
        File b2 = b();
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), ".~hosts.txt");
        try {
            if (!file.exists() && !file.createNewFile()) {
                return false;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(b2));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String trim = readLine.trim();
                if (!trim.equals(str)) {
                    if (!TextUtils.isEmpty(trim)) {
                        bufferedWriter.write(trim + System.getProperty("line.separator"));
                    }
                }
            }
            bufferedWriter.close();
            bufferedReader.close();
            return file.renameTo(b2);
        } catch (Exception e2) {
            d.a(e2);
        }
    }

    private void a(File file) {
        try {
            d.clear();
            if (file == null) {
                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "hosts.txt");
            }
            a(new InputStreamReader(new FileInputStream(file), mark.via.b.a.d), d);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        File b2 = b();
        if (!b2.exists()) {
            try {
                d.clear();
                this.b = System.currentTimeMillis();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (this.b != b2.lastModified()) {
            this.b = b2.lastModified();
            a(b2);
        }
    }

    private File b() {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "hosts.txt");
    }

    public boolean b(String str) {
        return d.contains(str);
    }

    private void a(Context context, String str, Set<String> set) {
        if (set.isEmpty()) {
            try {
                a(new InputStreamReader(context.getAssets().open(str), mark.via.b.a.d), set);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.util.b.a(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      mark.via.util.b.a(android.content.Context, java.lang.String):int
      mark.via.util.b.a(int, java.lang.String):java.lang.String
      mark.via.util.b.a(android.content.Intent, java.lang.String):java.lang.String
      mark.via.util.b.a(android.webkit.WebView, int):void
      mark.via.util.b.a(java.lang.String, boolean):java.lang.String */
    public boolean d(String str) {
        if (!this.f262a || TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("://")) {
            str = str.substring(str.indexOf("://") + 3);
        }
        if (!e.contains(str) && !d.contains(str)) {
            String a2 = b.a(str, false);
            if (!e.contains(a2) && !d.contains(a2)) {
                String f2 = b.f(a2);
                if (!f2.equals(a2) && (e.contains(f2) || d.contains(f2))) {
                    return true;
                }
                if (str.length() < 5) {
                    return false;
                }
                int length = str.length() - 5;
                for (int i = 0; i <= length; i++) {
                    String substring = str.substring(i, i + 5);
                    if (f.containsKey(substring)) {
                        for (String str2 : f.get(substring).split(",")) {
                            if (str.contains(str2)) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean c(String str) {
        return e.contains(str);
    }

    private void a(InputStreamReader inputStreamReader, Set<String> set) {
        BrowserApp.b().execute(new C0033a(this, inputStreamReader, set));
    }

    public void a(boolean z) {
        this.f262a = z;
    }

    public boolean a() {
        return this.f262a;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092 A[SYNTHETIC, Splitter:B:33:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    public void a(String str) {
        if (!d.contains(str)) {
            d.add(str);
            String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + "hosts.txt";
            File file = new File(str2);
            if (!file.exists()) {
                try {
                    if ((!file.getParentFile().exists() && !file.getParentFile().mkdir()) || !file.createNewFile()) {
                        return;
                    }
                } catch (IOException unused) {
                }
            }
            BufferedWriter bufferedWriter = null;
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str2, true)));
                try {
                    bufferedWriter2.write("\n" + str);
                    try {
                        bufferedWriter2.close();
                    } catch (Exception e2) {
                        d.a(e2);
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedWriter = bufferedWriter2;
                    try {
                        e.printStackTrace();
                        if (bufferedWriter == null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedWriter != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e4) {
                            d.a(e4);
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (bufferedWriter == null) {
                    bufferedWriter.close();
                }
            }
        }
    }
}
