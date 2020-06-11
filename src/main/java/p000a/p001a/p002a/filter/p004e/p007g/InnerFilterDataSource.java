package p000a.p001a.p002a.filter.p004e.p007g;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.p002a.filter.Filter;
import p000a.p001a.p002a.filter.RequestFilter;
import p000a.p001a.p002a.filter.p004e.FilterDataSource;
import p000a.p001a.p002a.util.FilterUtils;

/* renamed from: a.a.a.f.e.g.a */
/* compiled from: InnerFilterDataSource */
public class InnerFilterDataSource implements FilterDataSource {

    /* renamed from: a */
    private Context f37a;

    public InnerFilterDataSource(Context context) {
        this.f37a = context;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataSource
    /* renamed from: b */
    public List<Filter> mo62b() {
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f37a.getAssets().open("simple.txt"), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Filter t = FilterUtils.m115t(readLine);
                    if (t != null) {
                        arrayList.add(t);
                    }
                } catch (Throwable unused) {
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
        throw th;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataSource
    /* renamed from: c */
    public Filter mo63c(String str) {
        return null;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataSource
    /* renamed from: d */
    public Filter mo64d(String str) {
        return null;
    }

    /* renamed from: e */
    public RequestFilter mo61a(String str) {
        return null;
    }
}
