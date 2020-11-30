package mark.via.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mark.lib.frogsupport.checker.DataChecker;
import mark.lib.frogsupport.util.CompatUtils;
import mark.via.adapter.AddonItem;
import mark.via.adapter.HistoryItem;
import mark.via.constants.Constants;
import mark.via.gp.R;
import mark.via.handler.DatabaseHandler;
import mark.via.preference.PreferenceManager;
import org.json.JSONObject;
import timber.log.Timber;

/* renamed from: mark.via.n.n */
/* compiled from: InfoUtils */
public final class InfoUtils {
    /* renamed from: a */
    private static String m2162a(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            List<HistoryItem> o = DatabaseHandler.m1595v(context).mo988o();
            JSONObject jSONObject = new JSONObject();
            for (HistoryItem bVar : o) {
                jSONObject.put("title", bVar.mo940f());
                jSONObject.put("url", bVar.mo941g());
                jSONObject.put("folder", bVar.mo934b());
                jSONObject.put("order", bVar.mo938e());
                sb.append(jSONObject.toString());
                sb.append("\n");
            }
            String trim = sb.toString().trim();
            Charset charset = Constants.f1299d;
            String str = new String(Base64.encode(trim.getBytes(charset), 0), charset);
            if (z) {
                return URLEncoder.encode(str, Constants.f1300e);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    public static HashMap<String, String> m2163b(Context context, boolean z) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bookmark", m2162a(context, z));
        if (!z) {
            hashMap.put("favorite", m2165d(context, false));
        }
        hashMap.put("settings", m2168g(context, z));
        hashMap.put("adrules", "");
        if (z) {
            hashMap.put("other", m2166e(context, true));
        } else {
            hashMap.put("addons", m2167f(context, false));
        }
        return hashMap;
    }

    /* renamed from: c */
    private static String m2164c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, str2);
            String trim = jSONObject.toString().trim();
            Charset charset = Constants.f1299d;
            return URLEncoder.encode(new String(Base64.encode(trim.getBytes(charset), 0), charset), Constants.f1300e);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: d */
    private static String m2165d(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            List<HistoryItem> p = DatabaseHandler.m1595v(context).mo991p();
            JSONObject jSONObject = new JSONObject();
            for (HistoryItem bVar : p) {
                jSONObject.put("title", bVar.mo940f());
                jSONObject.put("url", bVar.mo941g());
                jSONObject.put("folder", bVar.mo934b());
                jSONObject.put("order", bVar.mo938e());
                sb.append(jSONObject.toString());
                sb.append("\n");
            }
            String trim = sb.toString().trim();
            Charset charset = Constants.f1299d;
            String str = new String(Base64.encode(trim.getBytes(charset), 0), charset);
            if (z) {
                return URLEncoder.encode(str, Constants.f1300e);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: e */
    private static String m2166e(Context context, boolean z) {
        try {
            List<AddonItem> m = DatabaseHandler.m1595v(context).mo986m();
            JSONObject jSONObject = new JSONObject();
            for (AddonItem aVar : m) {
                if (aVar.mo924h() && (!z || aVar.mo922f() == 0)) {
                    jSONObject.put(aVar.mo923g().trim(), aVar.mo918b().trim());
                }
            }
            String trim = jSONObject.toString().trim();
            Charset charset = Constants.f1299d;
            String str = new String(Base64.encode(trim.getBytes(charset), 0), charset);
            if (z) {
                return URLEncoder.encode(str, Constants.f1300e);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: f */
    private static String m2167f(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            List<AddonItem> m = DatabaseHandler.m1595v(context).mo986m();
            JSONObject jSONObject = new JSONObject();
            for (AddonItem aVar : m) {
                jSONObject.put("oid", aVar.mo922f());
                jSONObject.put("name", aVar.mo921e());
                jSONObject.put("author", aVar.mo917a());
                jSONObject.put("url", aVar.mo923g());
                jSONObject.put("info", aVar.mo920d());
                jSONObject.put("code", aVar.mo918b());
                jSONObject.toString().length();
                sb.append(jSONObject.toString());
                sb.append("\n");
            }
            String trim = sb.toString().trim();
            Charset charset = Constants.f1299d;
            String str = new String(Base64.encode(trim.getBytes(charset), 0), charset);
            if (z) {
                return URLEncoder.encode(str, Constants.f1300e);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: g */
    private static String m2168g(Context context, boolean z) {
        try {
            PreferenceManager M = PreferenceManager.m1743M(context);
            JSONObject jSONObject = new JSONObject();
            String[] strArr = PreferenceManager.C0465a.f1388a;
            for (String str : strArr) {
                if (M.mo1137c(str)) {
                    jSONObject.put(str, M.mo1161k0(str));
                }
            }
            String[] strArr2 = PreferenceManager.C0465a.f1389b;
            for (String str2 : strArr2) {
                if (M.mo1137c(str2)) {
                    jSONObject.put(str2, M.mo1167m0(str2));
                }
            }
            String[] strArr3 = PreferenceManager.C0465a.f1390c;
            for (String str3 : strArr3) {
                if (M.mo1137c(str3)) {
                    jSONObject.put(str3, M.mo1164l0(str3));
                }
            }
            String trim = jSONObject.toString().trim();
            Charset charset = Constants.f1299d;
            String str4 = new String(Base64.encode(trim.getBytes(charset), 0), charset);
            if (z) {
                return URLEncoder.encode(str4, Constants.f1300e);
            }
            return str4;
        } catch (Exception e) {
            Timber.m973c(e);
            return "";
        }
    }

    /* renamed from: h */
    public static String m2169h(String str) {
        if (str == null) {
            str = "";
        }
        return Base64.encodeToString(str.getBytes(Constants.f1299d), 0);
    }

    /* renamed from: i */
    public static String m2170i(String str) {
        if (str == null) {
            str = "";
        }
        try {
            Charset charset = Constants.f1299d;
            return new String(Base64.decode(str.getBytes(charset), 0), charset);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: j */
    public static String m2171j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLDecoder.decode(str, Constants.f1300e);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: k */
    public static String m2172k(Context context, String str, String str2) {
        String c = m2164c(str, str2);
        if (c.isEmpty()) {
            return "";
        }
        if ("*".equals(str)) {
            str = CompatUtils.m1336f(context, R.string.RES_2131558462);
        }
        return context.getResources().getString(R.string.RES_2131558708, str, c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b1 A[Catch:{ Exception -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0123 A[Catch:{ Exception -> 0x014a }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0165 A[Catch:{ Exception -> 0x01d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01ef A[Catch:{ Exception -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0264 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: l */
    public static boolean m2173l(Context context, String str) {
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PreferenceManager M = PreferenceManager.m1743M(context);
        DatabaseHandler v = DatabaseHandler.m1595v(context);
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            Timber.m973c(e);
        }
        if (jSONObject == null) {
            return false;
        }
        try {
            String str6 = new String(Base64.decode(jSONObject.optString("bookmark"), 0), Constants.f1300e);
            if (!TextUtils.isEmpty(str6)) {
                ArrayList arrayList = new ArrayList();
                Charset charset = Constants.f1299d;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str6.getBytes(charset)), charset));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (TextUtils.isEmpty(readLine)) {
                        break;
                    }
                    JSONObject jSONObject2 = new JSONObject(readLine);
                    HistoryItem bVar = new HistoryItem();
                    bVar.mo947l(jSONObject2.getString("title"));
                    bVar.mo948m(jSONObject2.getString("url"));
                    bVar.mo942h(jSONObject2.getString("folder"));
                    bVar.mo946k(jSONObject2.getInt("order"));
                    arrayList.add(bVar);
                }
                bufferedReader.close();
                v.mo1000z(arrayList);
                i = 1;
                str5 = new String(Base64.decode(jSONObject.optString("favorite"), 0), Constants.f1300e);
                if (!TextUtils.isEmpty(str5)) {
                    ArrayList arrayList2 = new ArrayList();
                    Charset charset2 = Constants.f1299d;
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str5.getBytes(charset2)), charset2));
                    while (true) {
                        String readLine2 = bufferedReader2.readLine();
                        if (TextUtils.isEmpty(readLine2)) {
                            break;
                        }
                        JSONObject jSONObject3 = new JSONObject(readLine2);
                        HistoryItem bVar2 = new HistoryItem();
                        bVar2.mo947l(jSONObject3.getString("title"));
                        bVar2.mo948m(jSONObject3.getString("url"));
                        bVar2.mo942h(jSONObject3.getString("folder"));
                        bVar2.mo946k(jSONObject3.getInt("order"));
                        arrayList2.add(bVar2);
                    }
                    bufferedReader2.close();
                    v.mo966A(arrayList2);
                    i++;
                }
                str4 = new String(Base64.decode(jSONObject.optString("other"), 0), Constants.f1299d);
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject jSONObject4 = new JSONObject(str4);
                    Iterator<String> keys = jSONObject4.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        v.mo970F(new AddonItem(next, (String) jSONObject4.get(next)));
                    }
                    i++;
                }
                str3 = new String(Base64.decode(jSONObject.optString("addons"), 0), Constants.f1300e);
                if (!TextUtils.isEmpty(str3)) {
                    ArrayList arrayList3 = new ArrayList();
                    Charset charset3 = Constants.f1299d;
                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str3.getBytes(charset3)), charset3));
                    while (true) {
                        String readLine3 = bufferedReader3.readLine();
                        if (TextUtils.isEmpty(readLine3)) {
                            break;
                        }
                        JSONObject jSONObject5 = new JSONObject(readLine3);
                        AddonItem aVar = new AddonItem();
                        aVar.mo930n(jSONObject5.getInt("oid"));
                        aVar.mo929m(jSONObject5.optString("name"));
                        aVar.mo925i(jSONObject5.optString("author"));
                        aVar.mo931o(jSONObject5.optString("url"));
                        aVar.mo928l(jSONObject5.optString("info"));
                        aVar.mo926j(jSONObject5.optString("code"));
                        arrayList3.add(aVar);
                    }
                    bufferedReader3.close();
                    v.mo999y(arrayList3);
                    i++;
                }
                str2 = new String(Base64.decode(jSONObject.optString("settings"), 0), Constants.f1299d);
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject6 = new JSONObject(str2);
                    String[] strArr = PreferenceManager.C0465a.f1388a;
                    for (String str7 : strArr) {
                        if (jSONObject6.has(str7) && !jSONObject6.isNull(str7)) {
                            M.mo1203y0(str7, jSONObject6.optBoolean(str7));
                        }
                    }
                    String[] strArr2 = PreferenceManager.C0465a.f1389b;
                    for (String str8 : strArr2) {
                        if (jSONObject6.has(str8) && !jSONObject6.isNull(str8)) {
                            M.mo1066B0(str8, jSONObject6.optString(str8));
                        }
                    }
                    String[] strArr3 = PreferenceManager.C0465a.f1390c;
                    for (String str9 : strArr3) {
                        if (jSONObject6.has(str9) && !jSONObject6.isNull(str9)) {
                            M.mo1206z0(str9, jSONObject6.optInt(str9));
                        }
                    }
                    i++;
                }
                DataChecker.m1181c().mo668i(1, 2, 158);
                if (i <= 0) {
                    return true;
                }
                return false;
            }
        } catch (Exception e2) {
            Timber.m973c(e2);
        }
        i = 0;
        try {
            str5 = new String(Base64.decode(jSONObject.optString("favorite"), 0), Constants.f1300e);
            if (!TextUtils.isEmpty(str5)) {
            }
        } catch (Exception e3) {
            Timber.m973c(e3);
        }
        try {
            str4 = new String(Base64.decode(jSONObject.optString("other"), 0), Constants.f1299d);
            if (!TextUtils.isEmpty(str4)) {
            }
        } catch (Exception e4) {
            Timber.m973c(e4);
        }
        try {
            str3 = new String(Base64.decode(jSONObject.optString("addons"), 0), Constants.f1300e);
            if (!TextUtils.isEmpty(str3)) {
            }
        } catch (Exception e5) {
            Timber.m973c(e5);
        }
        try {
            str2 = new String(Base64.decode(jSONObject.optString("settings"), 0), Constants.f1299d);
            if (!TextUtils.isEmpty(str2)) {
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        DataChecker.m1181c().mo668i(1, 2, 158);
        if (i <= 0) {
        }
    }
}
