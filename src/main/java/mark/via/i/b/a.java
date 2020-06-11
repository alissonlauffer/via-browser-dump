package mark.via.i.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import mark.via.a.b;
import mark.via.a.c;
import mark.via.gp.R;
import mark.via.util.h;
import mark.via.util.i;

/* compiled from: PageManager */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<File> f264a = new C0034a();

    /* renamed from: mark.via.i.b.a$a  reason: collision with other inner class name */
    /* compiled from: PageManager */
    class C0034a implements Comparator<File> {
        C0034a() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified == 0) {
                return 0;
            }
            return lastModified > 0 ? -1 : 1;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b>
     arg types: [java.lang.String, int]
     candidates:
      mark.via.c.b.a(int, int):void
      mark.via.c.b.a(java.lang.String, java.lang.String):void
      mark.via.c.b.a(mark.via.a.b, boolean):void
      mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b> */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ed  */
    public static String a(Context context, String str) {
        String str2;
        String str3 = str;
        boolean z = str3 == null || str.isEmpty();
        mark.via.f.a.b(context);
        String str4 = "folder.html";
        if (a.a.b.j.a.b().a(2) || !h.a(context, "bookmarks.html") || !z) {
            StringBuilder sb = new StringBuilder();
            ArrayList<b> arrayList = new ArrayList();
            mark.via.c.b a2 = mark.via.c.b.a(context);
            String string = context.getString(R.string.g);
            if (z) {
                try {
                    arrayList = a2.g();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str2 = "bookmarks.html";
            } else {
                try {
                    str3 = URLDecoder.decode(str3, mark.via.b.a.e);
                } catch (Exception unused) {
                }
                arrayList = a2.a(str3, true);
                string = str3;
                str2 = str4;
            }
            sb.append(b.c(string));
            sb.append(b.a(b.a(context, 1)));
            sb.append("<body><div class='frosted-glass'></div><div id=\"content\">");
            boolean z2 = false;
            boolean z3 = false;
            for (b bVar : arrayList) {
                if (bVar.f().startsWith("folder://")) {
                    if (!z3) {
                        sb.append("<div id=\"bookmark_folders\">");
                        z3 = true;
                    }
                    sb.append(b.a(bVar.f(), bVar.e(), bVar.f().startsWith("folder://") ? "tag" : "bookmark"));
                } else {
                    if (!z3 || z2) {
                        if (!z2) {
                            sb.append("<div id=\"bookmark_tags\">");
                        }
                        sb.append(b.a(bVar.f(), bVar.e(), !bVar.f().startsWith("folder://") ? "tag" : "bookmark"));
                    } else {
                        sb.append("</div>");
                        sb.append("<div id=\"bookmark_tags\">");
                    }
                    z2 = true;
                    sb.append(b.a(bVar.f(), bVar.e(), !bVar.f().startsWith("folder://") ? "tag" : "bookmark"));
                }
            }
            if (z2) {
                sb.append("</div>");
            }
            if (arrayList.size() != 0) {
                sb.append(b.a(2, mark.via.util.b.i(context)));
            } else if (z) {
                sb.append(b.a(context.getString(R.string.d1) + "<br><br><br><br><input type='button' onclick='window.via.openSettings(" + 0 + ")' class='btn' style='background: #E75656' value='" + context.getString(R.string.e2) + "'></input><br><input type='button' onclick='window.via.openSettings(" + 1 + ")' class='btn' style='background: #6E8CC7' value='" + context.getString(R.string.gu) + "'></input>"));
            }
            sb.append("</div></body></html>");
            h.a(sb.toString(), new File(context.getFilesDir(), str2));
            if (z) {
                a.a.b.j.a.b().c(2);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("file://");
        sb2.append(context.getFilesDir().getPath());
        sb2.append("/");
        if (str3 == null || str3.length() <= 0) {
            str4 = "bookmarks.html";
        }
        sb2.append(str4);
        return sb2.toString();
    }

    private static List<b> b(Context context) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {context.getString(R.string.g), context.getString(R.string.u), context.getString(R.string.f3), context.getString(R.string.ac), context.getString(R.string.du), context.getString(R.string.gr)};
        String[] strArr2 = {"v://bookmark", "v://history", "v://log", "v://offline", "v://home", "v://about"};
        for (int i = 0; i < 6; i++) {
            b bVar = new b();
            bVar.a(i);
            bVar.c(strArr2[i]);
            bVar.b(strArr[i]);
            bVar.b(R.drawable.ae);
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static String c(Context context) {
        mark.via.f.a.b(context);
        if (a.a.b.j.a.b().a(5) || !h.a(context, "catalog.html")) {
            StringBuilder sb = new StringBuilder();
            sb.append(b.c(context.getString(R.string.bh)));
            sb.append(b.a(b.a(context, 1)));
            sb.append("<body><div class='frosted-glass'></div><div id=\"content\">");
            List<b> b = b(context);
            for (b bVar : b) {
                sb.append(b.a(bVar.f(), bVar.e(), "tag"));
            }
            if (b.size() == 0) {
                sb.append(b.a(context.getString(R.string.d1)));
            }
            sb.append("</div></body></html>");
            h.a(sb.toString(), new File(context.getFilesDir(), "catalog.html"));
            a.a.b.j.a.b().c(5);
        }
        return "file://" + context.getFilesDir().getPath() + "/" + "catalog.html";
    }

    public static String d(Context context) {
        mark.via.f.a b = mark.via.f.a.b(context);
        if (a.a.b.j.a.b().a(3) || !h.a(context, "history.html")) {
            StringBuilder sb = new StringBuilder();
            sb.append(b.c(context.getString(R.string.u)));
            sb.append(b.a(b.a(context, 1)));
            sb.append("<body><div class='frosted-glass'></div><div id=\"content\">");
            List<b> h = h(context);
            if (h.size() == 0) {
                sb.append(b.a(context.getString(R.string.d1)));
            } else if (b.E()) {
                sb.append(b.a(context.getString(R.string.dt)));
            }
            for (b bVar : h) {
                sb.append(b.a(bVar.f(), bVar.e(), "clock"));
            }
            sb.append("</div></body></html>");
            h.a(sb.toString(), new File(context.getFilesDir(), "history.html"));
            a.a.b.j.a.b().c(3);
        }
        return "file://" + context.getFilesDir().getPath() + "/" + "history.html";
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d4  */
    public static String e(Context context) {
        boolean z;
        List<b> f;
        String str;
        mark.via.f.a b = mark.via.f.a.b(context);
        File file = new File(context.getFilesDir(), "homepage.html");
        if (a.a.b.j.a.b().a(1) || !file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(b.c(context.getString(R.string.du)));
            sb.append(b.a(b.a(context, 4), b.c0()));
            sb.append("<body><div class='frosted-glass'></div><div id=\"content\">");
            if (!b.t()) {
                sb.append(b.c(context));
                if (b.Z() == 1 || mark.via.util.a.c()) {
                    z = true;
                    f = mark.via.c.b.a(context).f();
                    if (!f.isEmpty()) {
                        sb.append("<div id=\"bookmark_part\"><div id=\"box_container\">");
                        int z2 = b.z();
                        for (b bVar : f) {
                            if (z2 == 1) {
                                str = b.a(bVar.f(), bVar.e());
                            } else {
                                str = b.a(bVar.f(), bVar.e(), z2 != 2);
                            }
                            sb.append(str);
                        }
                        sb.append("</div></div>");
                        sb.append(b.a(1, mark.via.util.b.i(context)));
                    }
                    sb.append(b.b(b.a()));
                    if (z) {
                        sb.append("<style type=\"text/css\">.bdSug_app{display:none !important;}td{margin:4px !important;padding:10px !important;}.bdSug_wpr{overflow-y: scroll !important;max-height:30% !important;}</style><script charset=\"gbk\" src=\"file:///android_asset/opensug.js\"></script><script type=\"text/javascript\">function show(str){var searchbox = document.getElementById(\"search_input\"); searchbox.innerHTML = str; searchbox.blur(); search();} var params = {\"XOffset\":0, \"YOffset\":0, \"fontColor\":\"#666666\", \"fontColorHI\":\"#FFF\", \"fontSize\":\"14px\", \"borderColor\":\"#eee\", \"bgcolorHI\":\"#7B90E3\", \"sugSubmit\":false }; BaiduSuggestion.bind(\"search_input\",params,show); </script>");
                    }
                    sb.append("</div></body></html>");
                    h.a(sb.toString(), file);
                    a.a.b.j.a.b().c(1);
                }
            }
            z = false;
            f = mark.via.c.b.a(context).f();
            if (!f.isEmpty()) {
            }
            sb.append(b.b(b.a()));
            if (z) {
            }
            sb.append("</div></body></html>");
            h.a(sb.toString(), file);
            a.a.b.j.a.b().c(1);
        }
        return "file://" + file.getPath();
    }

    public static String f(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(b.c(context.getString(R.string.ac)));
        sb.append(b.a(b.a(context, 1)));
        sb.append("<body><div class='frosted-glass'></div><div id=\"content\">");
        List<b> g = g(context);
        if (g.size() == 0) {
            sb.append(b.a(context.getString(R.string.d1)));
        } else {
            sb.append(b.a(context.getString(R.string.fc)));
        }
        for (b bVar : g) {
            sb.append(b.a(bVar.f(), bVar.e(), "clock"));
        }
        sb.append("</div></body></html>");
        File file = new File(context.getFilesDir(), "save.html");
        h.a(sb.toString(), file);
        return "file://" + file;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.util.a.a(android.content.Context, boolean):java.lang.String
     arg types: [android.content.Context, int]
     candidates:
      mark.via.util.a.a(android.app.Activity, java.lang.String):void
      mark.via.util.a.a(android.content.Context, android.view.View):void
      mark.via.util.a.a(android.content.Context, int):boolean
      mark.via.util.a.a(android.content.Context, java.lang.String):boolean
      mark.via.util.a.a(android.content.Context, java.lang.String[]):boolean
      mark.via.util.a.a(android.content.Context, boolean):java.lang.String */
    private static List<b> g(Context context) {
        String a2 = mark.via.util.a.a(context, true);
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(mark.via.util.a.a(context, false).substring(0, mark.via.util.a.a(context, false).length() - 1)).listFiles();
        if (listFiles != null && listFiles.length > 0 && !TextUtils.isEmpty(a2)) {
            Arrays.sort(listFiles, f264a);
            for (File file : listFiles) {
                String name = file.getName();
                if (name.endsWith(".mht")) {
                    arrayList.add(new b("file://" + a2 + Uri.encode(name), i.d(name.substring(0, name.length() - 4))));
                }
            }
        }
        return arrayList;
    }

    private static List<b> h(Context context) {
        mark.via.c.b a2 = mark.via.c.b.a(context);
        ArrayList arrayList = new ArrayList();
        try {
            return a2.i();
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static String a(Context context) {
        mark.via.f.a.b(context);
        if (a.a.b.j.a.b().a(4) || !h.a(context, "about.html")) {
            h.a(b.c(a.a.b.p.a.e(context, R.string.gr)) + b.a(b.a(context, 5)) + "<body><div class='frosted-glass'></div><div id=\"content\">" + b.a(context) + "</div></body></html>", new File(context.getFilesDir(), "about.html"));
            a.a.b.j.a.b().c(4);
        }
        return "file://" + context.getFilesDir().getPath() + "/" + "about.html";
    }

    public static String a(Context context, List<c> list, boolean z) {
        int i;
        String str;
        mark.via.f.a b = mark.via.f.a.b(context);
        StringBuilder sb = new StringBuilder();
        sb.append(b.c(context.getString(z ? R.string.g9 : R.string.f3)));
        sb.append(b.a(b.a(context, 6)));
        sb.append("<body><div class='frosted-glass'></div><div id=\"content\">");
        StringBuilder sb2 = new StringBuilder();
        if (list == null || list.isEmpty()) {
            i = 0;
        } else {
            i = 0;
            for (int size = list.size() - 1; size >= 0 && i < 32; size--) {
                c cVar = list.get(size);
                if (cVar != null && (!z || cVar.e())) {
                    sb2.append(b.a(cVar.c(), cVar.b(), cVar.d(), cVar.a()));
                    i++;
                }
            }
        }
        if (i > 0) {
            if (z) {
                str = context.getString(R.string.g8);
            } else {
                str = context.getString(R.string.ek, mark.via.b.a.i + "/" + b.o() + "/hosts.txt");
            }
        } else if (z) {
            str = context.getString(R.string.f_) + context.getString(R.string.ga).replace("\n", "<br>");
        } else {
            str = context.getString(R.string.d1);
        }
        sb.append(b.a(str));
        if (i > 0 && !z) {
            sb.append("<div id=\"filter-box\"><select id=\"filter\" onchange=\"filterChange()\"><option value=\"\">All</option><option value=\".js\">JS</option><option value=\".css\">CSS</option><option value=\".ico|.png|.jpg|.gif|.jpeg|.webp|.svg\">Images</option><option value=\"block\">Block</option></select></div>");
        }
        sb.append((CharSequence) sb2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("function getDomain(a){var b=a.split(\"/\"),c=\"\";return a.indexOf(\"://\")>-0&&b.length>2&&\"\"!=b[2]&&(c=b[2]),c}function boldDomain(){var b,c,d,a=document.getElementsByClassName(\"url\");for(d=a.length-1;d>=0;d--)b=a[d].innerHTML,c=getDomain(b),\"\"!=c&&(a[d].innerHTML=b.replace(c,\"<b>\"+c+\"</b>\"))}boldDomain();");
        sb3.append(z ? "" : "function filterChange(){var filter=document.getElementById(\"filter\");var rules=filter.options[filter.selectedIndex].value.split(\"|\");var es=document.getElementsByClassName(\"box\");var temp;var show;for(var i=0,size=es.length;i<size;i++){temp=es[i].getElementsByClassName(\"title\")[0].innerHTML;show=rules.length<1;for(var j=0,jsize=rules.length;j<jsize;j++){if(temp.indexOf(rules[j])!=-1){show=true;break}}es[i].style.display=show?\"block\":\"none\"}filter.blur()}");
        sb.append(b.b(sb3.toString()));
        sb.append("</div></body></html>");
        File file = new File(context.getFilesDir(), z ? "res.html" : "log.html");
        h.a(sb.toString(), file);
        return "file://" + file;
    }
}
