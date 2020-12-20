package mark.via.helpers;

import android.annotation.SuppressLint;
import android.util.Log;
import com.tuyafeng.nuwa.Nuwa;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import timber.log.Timber;

/* renamed from: mark.via.h.n */
/* compiled from: FileLoggingHelper */
public class FileLoggingHelper {

    /* renamed from: e */
    private static final String f1372e = "n";

    /* renamed from: f */
    private static volatile FileLoggingHelper f1373f;

    /* renamed from: a */
    private final Timber.Tree f1374a = new C0462b();

    /* renamed from: b */
    private boolean f1375b = false;

    /* renamed from: c */
    private StringBuilder f1376c = new StringBuilder();

    /* renamed from: d */
    private File f1377d = null;

    /* access modifiers changed from: private */
    /* renamed from: mark.via.h.n$b */
    /* compiled from: FileLoggingHelper */
    public class C0462b extends Timber.Tree {
        private C0462b() {
        }

        /* access modifiers changed from: protected */
        @Override // timber.log.Timber.Tree
        @SuppressLint({"LogNotTimber"})
        /* renamed from: i */
        public void mo436i(int i, String str, String str2, Throwable th) {
            if (th != null) {
                Log.e(FileLoggingHelper.f1372e, str2, th);
            } else {
                Log.d(FileLoggingHelper.f1372e, str2);
            }
            FileLoggingHelper nVar = FileLoggingHelper.this;
            if (th != null) {
                str2 = Nuwa.m915b(th);
            }
            nVar.m1726c(str2);
        }
    }

    private FileLoggingHelper() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043 A[SYNTHETIC, Splitter:B:23:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    private void m1726c(String str) {
        Throwable th;
        IOException e;
        StringBuilder sb = this.f1376c;
        sb.append(str);
        sb.append("\n");
        if (this.f1377d != null) {
            BufferedWriter bufferedWriter = null;
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(this.f1377d, true));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.newLine();
                    bufferedWriter2.flush();
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedWriter = bufferedWriter2;
                    try {
                        e.printStackTrace();
                        if (bufferedWriter == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                if (bufferedWriter == null) {
                    bufferedWriter.close();
                }
            }
        }
    }

    /* renamed from: d */
    public static FileLoggingHelper m1727d() {
        if (f1373f == null) {
            synchronized (FileLoggingHelper.class) {
                if (f1373f == null) {
                    f1373f = new FileLoggingHelper();
                }
            }
        }
        return f1373f;
    }

    /* renamed from: e */
    public String mo1053e() {
        return this.f1376c.length() == 0 ? "Empty" : this.f1376c.toString();
    }

    /* renamed from: f */
    public boolean mo1054f() {
        return this.f1375b;
    }

    /* renamed from: g */
    public void mo1055g(String str, String str2) {
        if (str != null && str2 != null) {
            File file = new File(str);
            this.f1377d = file;
            if (file.exists() || this.f1377d.mkdirs()) {
                this.f1377d = new File(str, str2);
            } else {
                this.f1377d = null;
            }
        }
    }

    /* renamed from: h */
    public void mo1056h() {
        if (!this.f1375b) {
            this.f1375b = true;
            StringBuilder sb = this.f1376c;
            sb.delete(0, sb.length());
            if (this.f1377d.exists()) {
                this.f1377d.delete();
            }
            Timber.plant(this.f1374a);
        }
    }

    /* renamed from: i */
    public void mo1057i() {
        if (this.f1375b) {
            this.f1375b = false;
            Timber.uproot(this.f1374a);
        }
    }
}
