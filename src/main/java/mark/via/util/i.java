package mark.via.util;

import a.a.b.o.c;
import a.a.b.p.d;
import a.a.b.p.e;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mark.via.f.a;
import mark.via.gp.R;
import mark.via.ui.activity.BrowserActivity;
import mark.via.ui.settings.BlockSettings;
import mark.via.ui.settings.ScriptSettings;
import org.json.JSONObject;

/* compiled from: InfoUtils */
public final class i {

    /* compiled from: InfoUtils */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f485a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ a.a.b.i.i e;

        /* renamed from: mark.via.util.i$a$a  reason: collision with other inner class name */
        /* compiled from: InfoUtils */
        class C0054a extends c {
            C0054a() {
            }

            @Override // a.a.b.o.c
            public void a() {
                Context context = a.this.f485a;
                a aVar = a.this;
                context.startActivity(new Intent(aVar.f485a, aVar.b == 1 ? BlockSettings.class : ScriptSettings.class));
            }
        }

        a(Context context, int i, String str, String str2, a.a.b.i.i iVar) {
            this.f485a = context;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = iVar;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.c.b.a(java.lang.String, java.lang.String, boolean):void
         arg types: [java.lang.String, java.lang.String, int]
         candidates:
          mark.via.c.b.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String
          mark.via.c.b.a(java.lang.String, int, int):void
          mark.via.c.b.a(java.lang.String, java.lang.String, boolean):void */
        public void onClick(View view) {
            mark.via.c.b a2 = mark.via.c.b.a(this.f485a);
            try {
                if (this.b == 1) {
                    a2.a(this.c, this.d, true);
                } else {
                    a2.a(new mark.via.a.a(this.c, this.d));
                }
                if (this.e == null) {
                    e.a(this.f485a, (int) R.string.e_, (int) R.string.h, new C0054a());
                } else {
                    e.a(this.f485a, (int) R.string.e_);
                }
                a.a.b.i.i iVar = this.e;
                if (iVar != null) {
                    iVar.a(new String[]{this.c, this.d});
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                a.a.b.i.i iVar2 = this.e;
                if (iVar2 != null) {
                    iVar2.a(new String[]{this.c, this.d});
                }
            } catch (Throwable th) {
                a.a.b.i.i iVar3 = this.e;
                if (iVar3 != null) {
                    iVar3.a(new String[]{this.c, this.d});
                }
                throw th;
            }
        }
    }

    /* compiled from: InfoUtils */
    class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f487a;
        final /* synthetic */ String b;

        b(Context context, String str) {
            this.f487a = context;
            this.b = str;
        }

        public void onClick(View view) {
            this.f487a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.b), this.f487a, BrowserActivity.class));
        }
    }

    public static String a(String str) {
        try {
            return URLEncoder.encode(new String(Base64.encode(str.trim().getBytes(mark.via.b.a.d), 0), mark.via.b.a.d), mark.via.b.a.e);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b(String str) {
        if (str == null) {
            str = "";
        }
        return Base64.encodeToString(str.getBytes(mark.via.b.a.d), 0);
    }

    public static String c(String str) {
        if (str == null) {
            str = "";
        }
        try {
            return new String(Base64.decode(str.getBytes(mark.via.b.a.d), 0), mark.via.b.a.d);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLDecoder.decode(str, mark.via.b.a.e);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String e(Context context, boolean z) {
        try {
            List<mark.via.a.a> b2 = mark.via.c.b.a(context).b();
            JSONObject jSONObject = new JSONObject();
            for (mark.via.a.a aVar : b2) {
                if (aVar.h() && (!z || aVar.f() == 0)) {
                    jSONObject.put(aVar.g().trim(), aVar.b().trim());
                }
            }
            String str = new String(Base64.encode(jSONObject.toString().trim().getBytes(mark.via.b.a.d), 0), mark.via.b.a.d);
            if (z) {
                return URLEncoder.encode(str, mark.via.b.a.e);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String f(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            List<mark.via.a.a> b2 = mark.via.c.b.a(context).b();
            JSONObject jSONObject = new JSONObject();
            for (mark.via.a.a aVar : b2) {
                jSONObject.put("oid", aVar.f());
                jSONObject.put("name", aVar.e());
                jSONObject.put("author", aVar.a());
                jSONObject.put("url", aVar.g());
                jSONObject.put("info", aVar.d());
                jSONObject.put("code", aVar.b());
                jSONObject.toString().length();
                sb.append(jSONObject.toString());
                sb.append("\n");
            }
            String str = new String(Base64.encode(sb.toString().trim().getBytes(mark.via.b.a.d), 0), mark.via.b.a.d);
            if (z) {
                return URLEncoder.encode(str, mark.via.b.a.e);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String g(Context context, boolean z) {
        try {
            mark.via.f.a b2 = mark.via.f.a.b(context);
            JSONObject jSONObject = new JSONObject();
            String[] strArr = a.C0028a.f252a;
            for (String str : strArr) {
                if (b2.a(str)) {
                    jSONObject.put(str, b2.b(str));
                }
            }
            String[] strArr2 = a.C0028a.b;
            for (String str2 : strArr2) {
                if (b2.a(str2)) {
                    jSONObject.put(str2, b2.d(str2));
                }
            }
            String[] strArr3 = a.C0028a.c;
            for (String str3 : strArr3) {
                if (b2.a(str3)) {
                    jSONObject.put(str3, b2.c(str3));
                }
            }
            String str4 = new String(Base64.encode(jSONObject.toString().trim().getBytes(mark.via.b.a.d), 0), mark.via.b.a.d);
            if (z) {
                return URLEncoder.encode(str4, mark.via.b.a.e);
            }
            return str4;
        } catch (Exception e) {
            d.a(e);
            return "";
        }
    }

    private static String b(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            List<mark.via.a.b> e = mark.via.c.b.a(context).e();
            JSONObject jSONObject = new JSONObject();
            for (mark.via.a.b bVar : e) {
                jSONObject.put("title", bVar.e());
                jSONObject.put("url", bVar.f());
                jSONObject.put("folder", bVar.a());
                jSONObject.put("order", bVar.d());
                sb.append(jSONObject.toString());
                sb.append("\n");
            }
            String str = new String(Base64.encode(sb.toString().trim().getBytes(mark.via.b.a.d), 0), mark.via.b.a.d);
            if (z) {
                return URLEncoder.encode(str, mark.via.b.a.e);
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static HashMap<String, String> c(Context context, boolean z) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bookmark", b(context, z));
        if (!z) {
            hashMap.put("favorite", d(context, false));
        }
        hashMap.put("settings", g(context, z));
        hashMap.put("adrules", a(context, z));
        if (z) {
            hashMap.put("other", e(context, true));
        } else {
            hashMap.put("addons", f(context, false));
        }
        return hashMap;
    }

    private static String d(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            List<mark.via.a.b> f = mark.via.c.b.a(context).f();
            JSONObject jSONObject = new JSONObject();
            for (mark.via.a.b bVar : f) {
                jSONObject.put("title", bVar.e());
                jSONObject.put("url", bVar.f());
                jSONObject.put("folder", bVar.a());
                jSONObject.put("order", bVar.d());
                sb.append(jSONObject.toString());
                sb.append("\n");
            }
            String str = new String(Base64.encode(sb.toString().trim().getBytes(mark.via.b.a.d), 0), mark.via.b.a.d);
            if (z) {
                return URLEncoder.encode(str, mark.via.b.a.e);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String a(Context context, boolean z) {
        try {
            List<mark.via.a.d> d = mark.via.c.b.a(context).d();
            JSONObject jSONObject = new JSONObject();
            for (mark.via.a.d dVar : d) {
                if (dVar.c()) {
                    jSONObject.put(dVar.b().trim(), dVar.a().trim());
                }
            }
            String str = new String(Base64.encode(jSONObject.toString().trim().getBytes(mark.via.b.a.d), 0), mark.via.b.a.d);
            if (z) {
                return URLEncoder.encode(str, mark.via.b.a.e);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, str2);
            return URLEncoder.encode(new String(Base64.encode(jSONObject.toString().trim().getBytes(mark.via.b.a.d), 0), mark.via.b.a.d), mark.via.b.a.e);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b(Context context, String str, String str2) {
        String a2 = a(str, str2);
        if (a2.isEmpty()) {
            return "";
        }
        if ("*".equals(str)) {
            str = a.a.b.p.a.e(context, R.string.ay);
        }
        return context.getResources().getString(R.string.h2, str, a2);
    }

    public static String a(Context context, String str, String str2) {
        String a2 = a(str, str2);
        if (a2.isEmpty()) {
            return "";
        }
        return context.getResources().getString(R.string.h1, str, a2);
    }

    public static void a(Context context) {
        a(context, (a.a.b.i.i) null);
    }

    public static void a(Context context, a.a.b.i.i iVar) {
        int i;
        int i2;
        String str;
        String a2 = e.a(context);
        if (!TextUtils.isEmpty(a2)) {
            try {
                int indexOf = a2.indexOf("}");
                int indexOf2 = a2.indexOf("viascript{");
                int indexOf3 = a2.indexOf("viarule{");
                int indexOf4 = a2.indexOf("viaurl{");
                int i3 = 1;
                if (indexOf2 > -1 && indexOf > indexOf2) {
                    i2 = indexOf2 + 10;
                    i = 0;
                } else if (indexOf3 > -1 && indexOf > indexOf3) {
                    i2 = indexOf3 + 8;
                    i = 1;
                } else if (indexOf4 <= -1 || indexOf <= indexOf4) {
                    i2 = 0;
                    i = -1;
                } else {
                    i2 = indexOf4 + 7;
                    i = 2;
                }
                if (i != -1) {
                    String str2 = new String(Base64.decode(URLDecoder.decode(a2.substring(0, indexOf).substring(i2), "utf-8"), 0), mark.via.b.a.d);
                    int i4 = R.string.cl;
                    if ((i == 0 || i == 1) && !str2.isEmpty() && str2 != JSONObject.NULL) {
                        JSONObject jSONObject = new JSONObject(str2);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String str3 = (String) jSONObject.get(next);
                            a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(context).b(i4);
                            StringBuilder sb = new StringBuilder();
                            Resources resources = context.getResources();
                            int i5 = i == 0 ? R.string.e9 : R.string.e8;
                            Object[] objArr = new Object[i3];
                            objArr[0] = "*".equals(next) ? a.a.b.p.a.e(context, R.string.ay) : next;
                            sb.append(resources.getString(i5, objArr));
                            if (i == 0) {
                                str = c(str3);
                            } else {
                                str = "";
                            }
                            sb.append(str);
                            cVar.c(sb.toString());
                            ((a.a.b.i.c) ((a.a.b.i.c) cVar.c(17039370, new a(context, i, next, str3, iVar))).a(17039360, (View.OnClickListener) null)).g();
                            i3 = 1;
                            i4 = R.string.cl;
                        }
                    } else if (i == 2 && !str2.isEmpty()) {
                        a.a.b.i.c cVar2 = (a.a.b.i.c) new a.a.b.i.c(context).b(R.string.cl);
                        cVar2.c(a.a.b.p.a.a(context, (int) R.string.ea, str2));
                        ((a.a.b.i.c) ((a.a.b.i.c) cVar2.c(17039370, new b(context, str2))).a(17039360, (View.OnClickListener) null)).g();
                    }
                    e.a(context, "", (String) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.c.b.a(java.lang.String, java.lang.String, boolean):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      mark.via.c.b.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String
      mark.via.c.b.a(java.lang.String, int, int):void
      mark.via.c.b.a(java.lang.String, java.lang.String, boolean):void */
    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            mark.via.f.a b2 = mark.via.f.a.b(context);
            mark.via.c.b a2 = mark.via.c.b.a(context);
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception e) {
                d.a(e);
            }
            if (jSONObject != null) {
                try {
                    String str2 = new String(Base64.decode(jSONObject.optString("bookmark"), 0), mark.via.b.a.e);
                    if (!TextUtils.isEmpty(str2)) {
                        ArrayList arrayList = new ArrayList();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str2.getBytes(mark.via.b.a.d)), mark.via.b.a.d));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (TextUtils.isEmpty(readLine)) {
                                break;
                            }
                            JSONObject jSONObject2 = new JSONObject(readLine);
                            mark.via.a.b bVar = new mark.via.a.b();
                            bVar.b(jSONObject2.getString("title"));
                            bVar.c(jSONObject2.getString("url"));
                            bVar.a(jSONObject2.getString("folder"));
                            bVar.c(jSONObject2.getInt("order"));
                            arrayList.add(bVar);
                        }
                        bufferedReader.close();
                        a2.b(arrayList);
                    }
                } catch (Exception e2) {
                    d.a(e2);
                }
                try {
                    String str3 = new String(Base64.decode(jSONObject.optString("favorite"), 0), mark.via.b.a.e);
                    if (!TextUtils.isEmpty(str3)) {
                        ArrayList arrayList2 = new ArrayList();
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str3.getBytes(mark.via.b.a.d)), mark.via.b.a.d));
                        while (true) {
                            String readLine2 = bufferedReader2.readLine();
                            if (TextUtils.isEmpty(readLine2)) {
                                break;
                            }
                            JSONObject jSONObject3 = new JSONObject(readLine2);
                            mark.via.a.b bVar2 = new mark.via.a.b();
                            bVar2.b(jSONObject3.getString("title"));
                            bVar2.c(jSONObject3.getString("url"));
                            bVar2.a(jSONObject3.getString("folder"));
                            bVar2.c(jSONObject3.getInt("order"));
                            arrayList2.add(bVar2);
                        }
                        bufferedReader2.close();
                        a2.c(arrayList2);
                    }
                } catch (Exception e3) {
                    d.a(e3);
                }
                try {
                    String str4 = new String(Base64.decode(jSONObject.optString("adrules"), 0), mark.via.b.a.d);
                    if (!TextUtils.isEmpty(str4)) {
                        JSONObject jSONObject4 = new JSONObject(str4);
                        Iterator<String> keys = jSONObject4.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            a2.a(next, (String) jSONObject4.get(next), true);
                        }
                    }
                } catch (Exception e4) {
                    d.a(e4);
                }
                try {
                    String str5 = new String(Base64.decode(jSONObject.optString("other"), 0), mark.via.b.a.d);
                    if (!TextUtils.isEmpty(str5)) {
                        JSONObject jSONObject5 = new JSONObject(str5);
                        Iterator<String> keys2 = jSONObject5.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            a2.a(new mark.via.a.a(next2, (String) jSONObject5.get(next2)));
                        }
                    }
                } catch (Exception e5) {
                    d.a(e5);
                }
                try {
                    String str6 = new String(Base64.decode(jSONObject.optString("addons"), 0), mark.via.b.a.e);
                    if (!TextUtils.isEmpty(str6)) {
                        ArrayList arrayList3 = new ArrayList();
                        BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str6.getBytes(mark.via.b.a.d)), mark.via.b.a.d));
                        while (true) {
                            String readLine3 = bufferedReader3.readLine();
                            if (TextUtils.isEmpty(readLine3)) {
                                break;
                            }
                            JSONObject jSONObject6 = new JSONObject(readLine3);
                            mark.via.a.a aVar = new mark.via.a.a();
                            aVar.b(jSONObject6.getInt("oid"));
                            aVar.d(jSONObject6.optString("name"));
                            aVar.a(jSONObject6.optString("author"));
                            aVar.e(jSONObject6.optString("url"));
                            aVar.c(jSONObject6.optString("info"));
                            aVar.b(jSONObject6.optString("code"));
                            arrayList3.add(aVar);
                        }
                        bufferedReader3.close();
                        a2.a(arrayList3);
                    }
                } catch (Exception e6) {
                    d.a(e6);
                }
                try {
                    String str7 = new String(Base64.decode(jSONObject.optString("settings"), 0), mark.via.b.a.d);
                    if (!TextUtils.isEmpty(str7)) {
                        JSONObject jSONObject7 = new JSONObject(str7);
                        String[] strArr = a.C0028a.f252a;
                        for (String str8 : strArr) {
                            if (jSONObject7.has(str8) && !jSONObject7.isNull(str8)) {
                                b2.a(str8, jSONObject7.optBoolean(str8));
                            }
                        }
                        String[] strArr2 = a.C0028a.b;
                        for (String str9 : strArr2) {
                            if (jSONObject7.has(str9) && !jSONObject7.isNull(str9)) {
                                b2.a(str9, jSONObject7.optString(str9));
                            }
                        }
                        String[] strArr3 = a.C0028a.c;
                        for (String str10 : strArr3) {
                            if (jSONObject7.has(str10) && !jSONObject7.isNull(str10)) {
                                b2.a(str10, jSONObject7.optInt(str10));
                            }
                        }
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
                a.a.b.j.a.b().a(1, 2, 158);
            }
        }
    }
}
