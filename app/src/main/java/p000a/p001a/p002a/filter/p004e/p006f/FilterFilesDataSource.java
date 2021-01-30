package p000a.p001a.p002a.filter.p004e.p006f;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import p000a.p001a.p002a.filter.Filter;
import p000a.p001a.p002a.filter.FilterSubscription;
import p000a.p001a.p002a.filter.p004e.FilterSubscriptionDataSource;
import p000a.p001a.p002a.util.FilterUtils;

/* renamed from: a.a.a.f.e.f.a */
/* compiled from: FilterFilesDataSource */
public class FilterFilesDataSource implements FilterSubscriptionDataSource {

    /* renamed from: a */
    private String f34a;

    /* renamed from: b */
    private List<FilterSubscription> f35b;

    /* renamed from: c */
    private boolean f36c = false;

    public FilterFilesDataSource(String str) {
        this.f34a = str;
        this.f35b = new ArrayList();
    }

    /* renamed from: d */
    private List<FilterSubscription> m85d() {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        String str = this.f34a;
        sb.append(str.substring(0, str.lastIndexOf(47) + 1));
        sb.append(System.currentTimeMillis());
        sb.append(".txt");
        String sb2 = sb.toString();
        if (Locale.getDefault().getLanguage().equals("zh")) {
            arrayList.add(new FilterSubscription("https://cdn.jsdelivr.net/gh/o0HalfLife0o/list/ad3.txt", sb2, false));
        } else {
            arrayList.add(new FilterSubscription("https://easylist.to/easylist/easylist.txt", sb2, false));
        }
        return arrayList;
    }

    /* renamed from: e */
    private List<Filter> m86e(List<FilterSubscription> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (FilterSubscription cVar : list) {
            if (cVar != null && cVar.mo28e()) {
                arrayList.addAll(FilterUtils.m110o(cVar.mo24a()));
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private void m87f() {
        String str = this.f34a;
        if (str != null && !str.isEmpty()) {
            File file = new File(this.f34a);
            if (!file.isDirectory() && file.exists()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    try {
                        this.f35b.clear();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                bufferedReader.close();
                                return;
                            } else if (!readLine.isEmpty()) {
                                FilterSubscription f = FilterSubscription.m22f(readLine);
                                if (f != null) {
                                    this.f35b.add(f);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        this.f35b = m85d();
        return;
        throw th;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterSubscriptionDataSource
    /* renamed from: a */
    public boolean mo65a(List<FilterSubscription> list) {
        String str = this.f34a;
        if (str != null && !str.isEmpty()) {
            File file = new File(this.f34a);
            if (!file.isDirectory()) {
                this.f35b = list;
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                    try {
                        for (FilterSubscription cVar : list) {
                            bufferedWriter.write(cVar.mo38n());
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.close();
                        return true;
                    } catch (Throwable unused) {
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return false;
        throw th;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterSubscriptionDataSource
    /* renamed from: b */
    public List<Filter> mo66b() {
        if (!this.f36c) {
            m87f();
            this.f36c = true;
        }
        return m86e(this.f35b);
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterSubscriptionDataSource
    /* renamed from: c */
    public List<FilterSubscription> mo67c() {
        return this.f35b;
    }
}
