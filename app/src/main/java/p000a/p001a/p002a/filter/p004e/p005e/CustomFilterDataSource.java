package p000a.p001a.p002a.filter.p004e.p005e;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import p000a.p001a.p002a.filter.Filter;
import p000a.p001a.p002a.filter.RequestFilter;
import p000a.p001a.p002a.filter.p004e.FilterDataSource;
import p000a.p001a.p002a.util.FilterUtils;

/* renamed from: a.a.a.f.e.e.a */
/* compiled from: CustomFilterDataSource */
public class CustomFilterDataSource implements FilterDataSource {

    /* renamed from: a */
    private String f32a;

    /* renamed from: b */
    private List<Filter> f33b;

    public CustomFilterDataSource(String str) {
        this.f32a = str;
    }

    /* renamed from: e */
    private File m79e() {
        String str = this.f32a;
        if (str == null || str.isEmpty()) {
            return null;
        }
        File file = new File(this.f32a);
        if (file.getParentFile() == null || file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            return file;
        }
        return null;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataSource
    /* renamed from: b */
    public List<Filter> mo62b() {
        List<Filter> o = FilterUtils.m110o(this.f32a);
        this.f33b = o;
        return o;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataSource
    /* renamed from: c */
    public Filter mo63c(String str) {
        File e;
        Filter t;
        if (str == null || str.isEmpty() || str.charAt(0) == '!' || (e = m79e()) == null || (t = FilterUtils.m115t(str)) == null) {
            return null;
        }
        if (this.f33b.contains(t)) {
            System.out.println("Filter is in filterList");
            return null;
        }
        this.f33b.add(t);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(e, true)));
            try {
                bufferedWriter.newLine();
                bufferedWriter.write(str);
                bufferedWriter.close();
                return t;
            } catch (Throwable unused) {
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        throw th;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataSource
    /* renamed from: d */
    public Filter mo64d(String str) {
        File e;
        Filter t;
        if (str == null || str.isEmpty() || str.charAt(0) == '!' || (e = m79e()) == null || (t = FilterUtils.m115t(str)) == null) {
            return null;
        }
        if (!this.f33b.contains(t)) {
            System.out.println("Filter is not in filterList");
            return null;
        }
        this.f33b.remove(t);
        String parent = e.getParent();
        File file = new File(parent, "." + e.getName());
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(e)));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String trim = readLine.trim();
                        if (!trim.equals(str)) {
                            if (!trim.isEmpty()) {
                                bufferedWriter.write(trim);
                                bufferedWriter.newLine();
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!file.renameTo(e)) {
                    System.out.println("Rename custom filters file error");
                }
                bufferedWriter.close();
                bufferedReader.close();
                return t;
            } catch (Throwable unused2) {
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        throw th;
        throw th;
    }

    /* renamed from: f */
    public RequestFilter mo61a(String str) {
        RequestFilter g;
        if (str == null || str.isEmpty() || (g = RequestFilter.m37g(str)) == null || !this.f33b.contains(g)) {
            return null;
        }
        return g;
    }
}
