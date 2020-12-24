package mark.via.p044m.p045a;

import android.content.Context;
import android.net.Uri;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import mark.lib.frogsupport.checker.DataChecker;
import mark.lib.frogsupport.util.CompatUtils;
import mark.via.adapter.HistoryItem;
import mark.via.adapter.LogItem;
import mark.via.constants.Constants;
import mark.via.gp.R;
import mark.via.handler.DatabaseHandler;
import mark.via.preference.PreferenceManager;
import mark.via.utils.AppUtils;
import mark.via.utils.ArrayUtils;
import mark.via.utils.FileUtils;
import mark.via.utils.InfoUtils;
import timber.log.Timber;

/* renamed from: mark.via.m.a.b */
/* compiled from: PageManager */
public class PageManager {

    /* renamed from: a */
    private static final Comparator<File> f1425a = C0471a.f1424a;

    /* renamed from: a */
    public static String m1937a(Context context) {
        if (DataChecker.m1181c().mo661a(4) || !FileUtils.m2160p(context, "about.html")) {
            FileUtils.m2161q(WebPage.m1961m(CompatUtils.m1336f(context, R.string.hb)) + WebPage.m1962n(WebPage.m1960l(context, 5)) + "<body><div class='frosted-glass'></div><div id=\"content\">" + WebPage.m1949a(context) + "</div></body></html>", new File(context.getFilesDir(), "about.html"));
            DataChecker.m1181c().mo664e(4);
        }
        return "file://" + context.getFilesDir().getPath() + "/about.html";
    }

    /* renamed from: b */
    public static String m1938b(Context context) {
        return m1939c(context, null);
    }

    /* renamed from: c */
    public static String m1939c(Context context, String str) {
        String str2 = str;
        boolean z = str2 == null || str.isEmpty();
        String str3 = "bookmarks.html";
        File file = new File(context.getFilesDir(), z ? str3 : "folder.html");
        if (!z || DataChecker.m1181c().mo661a(2) || !file.exists()) {
            Timber.m971a("generating bookmark page", new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                DatabaseHandler v = DatabaseHandler.m1595v(context);
                if (!z) {
                    try {
                        str2 = URLDecoder.decode(str2, Constants.f1300e);
                    } catch (Exception unused) {
                    }
                }
                List<HistoryItem> r = z ? v.mo993r() : v.mo994s(str2, true);
                bufferedWriter.write(WebPage.m1961m(z ? context.getString(R.string.g) : str2));
                bufferedWriter.write(WebPage.m1962n(WebPage.m1960l(context, 1)));
                bufferedWriter.write("<body><div class='frosted-glass'></div><div id=\"content\">");
                boolean z2 = false;
                boolean z3 = false;
                for (HistoryItem bVar : r) {
                    if (!bVar.mo941g().startsWith("folder://")) {
                        if (z3 && !z2) {
                            bufferedWriter.write("</div>");
                            bufferedWriter.write("<div id=\"bookmark_tags\">");
                        } else if (!z2) {
                            bufferedWriter.write("<div id=\"bookmark_tags\">");
                        }
                        z2 = true;
                    } else if (!z3) {
                        bufferedWriter.write("<div id=\"bookmark_folders\">");
                        z3 = true;
                    }
                    bufferedWriter.write(WebPage.m1954f(bVar.mo941g(), bVar.mo940f(), bVar.mo941g().startsWith("folder://") ? "tag" : "bookmark"));
                }
                if (z2) {
                    bufferedWriter.write("</div>");
                }
                if (r.size() != 0) {
                    bufferedWriter.write(WebPage.m1951c(2));
                } else if (z) {
                    bufferedWriter.write(WebPage.m1956h(context.getString(R.string.d_) + "<br><br><br><br><input type='button' onclick='window.via.openSettings(0)' class='btn' style='background: #E75656' value='" + context.getString(R.string.ei) + "'></input><br><input type='button' onclick='window.via.openSettings(1)' class='btn' style='background: #6E8CC7' value='" + context.getString(R.string.he) + "'></input>"));
                }
                bufferedWriter.write("</div></body></html>");
                bufferedWriter.close();
                fileWriter.close();
                if (z) {
                    DataChecker.m1181c().mo664e(2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Timber.m971a("Generate bookmark page time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("file://");
        sb.append(context.getFilesDir().getPath());
        sb.append("/");
        if (str2 != null && str2.length() > 0) {
            str3 = "folder.html";
        }
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: d */
    private static List<HistoryItem> m1940d(Context context) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {context.getString(R.string.g), context.getString(R.string.u), context.getString(R.string.fm), context.getString(R.string.ac), context.getString(R.string.ea), context.getString(R.string.hb)};
        String[] strArr2 = {"v://bookmark", "v://history", "v://log", "v://offline", "v://home", "v://about"};
        for (int i = 0; i < 6; i++) {
            HistoryItem bVar = new HistoryItem();
            bVar.mo944i(i);
            bVar.mo948m(strArr2[i]);
            bVar.mo947l(strArr[i]);
            bVar.mo945j(R.drawable.ad);
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* renamed from: e */
    public static String m1941e(Context context) {
        if (DataChecker.m1181c().mo661a(5) || !FileUtils.m2160p(context, "catalog.html")) {
            StringBuilder sb = new StringBuilder();
            sb.append(WebPage.m1961m(context.getString(R.string.bj)));
            sb.append(WebPage.m1962n(WebPage.m1960l(context, 1)));
            sb.append("<body><div class='frosted-glass'></div><div id=\"content\">");
            List<HistoryItem> d = m1940d(context);
            for (HistoryItem bVar : d) {
                sb.append(WebPage.m1954f(bVar.mo941g(), bVar.mo940f(), "tag"));
            }
            if (d.size() == 0) {
                sb.append(WebPage.m1956h(context.getString(R.string.d_)));
            }
            sb.append("</div></body></html>");
            FileUtils.m2161q(sb.toString(), new File(context.getFilesDir(), "catalog.html"));
            DataChecker.m1181c().mo664e(5);
        }
        return "file://" + context.getFilesDir().getPath() + "/catalog.html";
    }

    /* renamed from: f */
    public static String m1942f(Context context) {
        PreferenceManager M = PreferenceManager.m1743M(context);
        File file = new File(context.getFilesDir(), "history.html");
        if (DataChecker.m1181c().mo661a(3) || !file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(WebPage.m1961m(context.getString(R.string.u)));
                bufferedWriter.write(WebPage.m1962n(WebPage.m1960l(context, 1)));
                bufferedWriter.write("<body><div class='frosted-glass'></div><div id=\"content\">");
                List<HistoryItem> k = m1947k(context);
                if (k.size() == 0) {
                    bufferedWriter.write(WebPage.m1956h(context.getString(R.string.d_)));
                } else if (M.mo1095L()) {
                    bufferedWriter.write(WebPage.m1956h(context.getString(R.string.e_)));
                }
                for (HistoryItem bVar : k) {
                    bufferedWriter.write(WebPage.m1954f(bVar.mo941g(), bVar.mo940f(), "clock"));
                }
                bufferedWriter.write("</div></body></html>");
                DataChecker.m1181c().mo664e(3);
                bufferedWriter.close();
                fileWriter.close();
            } catch (Exception unused) {
            }
            Timber.m971a("Generate history page time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return "file://" + file.getPath();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0083 A[Catch:{ Exception -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d9 A[Catch:{ Exception -> 0x00f1 }] */
    /* renamed from: g */
    public static String m1943g(Context context) {
        boolean z;
        List<HistoryItem> p;
        String str;
        File file = new File(context.getFilesDir(), "homepage.html");
        PreferenceManager M = PreferenceManager.m1743M(context);
        if (DataChecker.m1181c().mo661a(1) || !file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(WebPage.m1961m(context.getString(R.string.ea)));
                bufferedWriter.write(WebPage.m1962n(WebPage.m1960l(context, 4), M.mo1173o0()));
                bufferedWriter.write("<body><div class='frosted-glass'></div><div id=\"content\">");
                if (!M.mo1065B()) {
                    bufferedWriter.write(WebPage.m1959k(context));
                    if (M.mo1155i0() == 1 || AppUtils.m2060h()) {
                        z = true;
                        p = DatabaseHandler.m1595v(context).mo991p();
                        if (!p.isEmpty()) {
                            bufferedWriter.write("<div id=\"bookmark_part\"><div id=\"box_container\">");
                            int H = M.mo1083H();
                            for (HistoryItem bVar : p) {
                                if (H == 1) {
                                    str = WebPage.m1950b(bVar.mo941g(), bVar.mo940f());
                                } else {
                                    str = WebPage.m1952d(bVar.mo941g(), bVar.mo940f(), H != 2);
                                }
                                bufferedWriter.write(str);
                            }
                            bufferedWriter.write("</div></div>");
                            bufferedWriter.write(WebPage.m1951c(1));
                        }
                        bufferedWriter.write(WebPage.m1957i(WebPage.m1958j()));
                        if (z) {
                            bufferedWriter.write("<style type=\"text/css\">.bdSug_app{display:none !important;}td{margin:4px !important;padding:10px !important;}.bdSug_wpr{overflow-y: scroll !important;max-height:30% !important;}</style><script charset=\"gbk\" src=\"file:///android_asset/opensug.js\"></script><script type=\"text/javascript\">function show(str){var searchbox = document.getElementById(\"search_input\"); searchbox.innerHTML = str; searchbox.blur(); search();} var params = {\"XOffset\":0, \"YOffset\":0, \"fontColor\":\"#666666\", \"fontColorHI\":\"#FFF\", \"fontSize\":\"14px\", \"borderColor\":\"#eee\", \"bgcolorHI\":\"#7B90E3\", \"sugSubmit\":false }; BaiduSuggestion.bind(\"search_input\",params,show); </script>");
                        }
                        bufferedWriter.write("</div></body></html>");
                        bufferedWriter.close();
                        fileWriter.close();
                        DataChecker.m1181c().mo664e(1);
                        Timber.m971a("Generate home page time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
                z = false;
                p = DatabaseHandler.m1595v(context).mo991p();
                if (!p.isEmpty()) {
                }
                bufferedWriter.write(WebPage.m1957i(WebPage.m1958j()));
                if (z) {
                }
                bufferedWriter.write("</div></body></html>");
                bufferedWriter.close();
                fileWriter.close();
                DataChecker.m1181c().mo664e(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Timber.m971a("Generate home page time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return "file://" + file.getPath();
    }

    /* renamed from: h */
    public static String m1944h(Context context, List<LogItem> list, boolean z) {
        int i;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(context.getFilesDir(), z ? "res.html" : "log.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(WebPage.m1961m(context.getString(z ? R.string.gt : R.string.fm)));
            bufferedWriter.write(WebPage.m1962n(WebPage.m1960l(context, 6)));
            bufferedWriter.write("<body><div class='frosted-glass'></div><div id=\"content\">");
            StringBuilder sb = new StringBuilder();
            if (list == null || list.size() <= 0) {
                i = 0;
            } else {
                int max = Math.max(0, list.size() - 64);
                i = 0;
                for (int size = list.size() - 1; size >= max; size--) {
                    LogItem cVar = list.get(size);
                    if (cVar != null) {
                        if (!z || cVar.mo954e()) {
                            i++;
                            sb.append(WebPage.m1955g(cVar.mo952c(), cVar.mo951b(), cVar.mo953d(), cVar.mo950a()));
                        }
                    }
                }
            }
            if (i > 0) {
                if (z) {
                    str = context.getString(R.string.gs);
                } else {
                    str = context.getString(R.string.f3, FileUtils.m2147c(context));
                }
            } else if (z) {
                str = context.getString(R.string.ft) + context.getString(R.string.gv).replace("\n", "<br>");
            } else {
                str = context.getString(R.string.d_);
            }
            bufferedWriter.write(WebPage.m1956h(str));
            if (!z && i > 0) {
                bufferedWriter.write("<div id=\"filter-box\"><select id=\"filter\" onchange=\"filterChange()\"><option value=\"\">All</option><option value=\".js\">JS</option><option value=\".css\">CSS</option><option value=\".ico|.png|.jpg|.gif|.jpeg|.webp|.svg\">Images</option><option value=\"block\">Block</option></select></div>");
            }
            bufferedWriter.write(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("function getDomain(a){var b=a.split(\"/\"),c=\"\";return a.indexOf(\"://\")>-0&&b.length>2&&\"\"!=b[2]&&(c=b[2]),c}function boldDomain(){var b,c,d,a=document.getElementsByClassName(\"url\");for(d=a.length-1;d>=0;d--)b=a[d].innerHTML,c=getDomain(b),\"\"!=c&&(a[d].innerHTML=b.replace(c,\"<b>\"+c+\"</b>\"))}boldDomain();");
            sb2.append(z ? "" : "function filterChange(){var filter=document.getElementById(\"filter\");var rules=filter.options[filter.selectedIndex].value.split(\"|\");var es=document.getElementsByClassName(\"box\");var temp;var show;for(var i=0,size=es.length;i<size;i++){temp=es[i].getElementsByClassName(\"title\")[0].innerHTML;show=rules.length<1;for(var j=0,jsize=rules.length;j<jsize;j++){if(temp.indexOf(rules[j])!=-1){show=true;break}}es[i].style.display=show?\"block\":\"none\"}filter.blur()}");
            bufferedWriter.write(WebPage.m1957i(sb2.toString()));
            bufferedWriter.write("</div></body></html>");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception unused) {
        }
        Timber.m971a("Generate log page time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return "file://" + file.getPath();
    }

    /* renamed from: i */
    public static String m1945i(Context context) {
        File file = new File(context.getFilesDir(), "save.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(WebPage.m1961m(context.getString(R.string.ac)));
            bufferedWriter.write(WebPage.m1962n(WebPage.m1960l(context, 1)));
            bufferedWriter.write("<body><div class='frosted-glass'></div><div id=\"content\">");
            List<HistoryItem> j = m1946j(context);
            if (j.size() == 0) {
                bufferedWriter.write(WebPage.m1956h(context.getString(R.string.d_)));
            } else {
                bufferedWriter.write(WebPage.m1956h(context.getString(R.string.fw)));
            }
            for (HistoryItem bVar : j) {
                bufferedWriter.write(WebPage.m1954f(bVar.mo941g(), bVar.mo940f(), "clock"));
            }
            bufferedWriter.write("</div></body></html>");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception unused) {
        }
        return "file://" + file.getPath();
    }

    /* renamed from: j */
    private static List<HistoryItem> m1946j(Context context) {
        File[] listFiles;
        String[] strArr = {FileUtils.m2159o(context), AppUtils.m2055c(context)};
        ArrayList arrayList = new ArrayList();
        File[] fileArr = new File[0];
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            if (str != null && !str.isEmpty() && (listFiles = new File(str).listFiles()) != null && listFiles.length > 0) {
                fileArr = (File[]) ArrayUtils.m2069a(fileArr, listFiles);
            }
        }
        Arrays.sort(fileArr, f1425a);
        for (File file : fileArr) {
            String name = file.getName();
            if (name.endsWith(".mht")) {
                arrayList.add(new HistoryItem("file://" + file.getParentFile() + "/" + Uri.encode(name), InfoUtils.m2171j(name.substring(0, name.length() - 4))));
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    private static List<HistoryItem> m1947k(Context context) {
        DatabaseHandler v = DatabaseHandler.m1595v(context);
        ArrayList arrayList = new ArrayList();
        try {
            return v.mo997w();
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    /* renamed from: l */
    static /* synthetic */ int m1948l(File file, File file2) {
        long lastModified = file.lastModified() - file2.lastModified();
        if (lastModified == 0) {
            return 0;
        }
        return lastModified > 0 ? -1 : 1;
    }
}
