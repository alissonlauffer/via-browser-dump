package mark.via.e;

import a.a.b.p.e;
import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mark.via.a.b;
import mark.via.gp.R;
import mark.via.util.h;
import org.json.JSONObject;

/* compiled from: BookmarkManager */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f250a;

    public a(Context context) {
        this.f250a = context;
    }

    private static String b(String str) {
        return str.substring(str.indexOf("\">") + 2, str.indexOf("</"));
    }

    private static String c(String str) {
        String[] split = str.split(" +");
        for (String str2 : split) {
            if (str2.startsWith("href=\"") || str2.startsWith("HREF=\"")) {
                int lastIndexOf = str2.lastIndexOf("\">");
                if (lastIndexOf == -1) {
                    return str2.substring(6, str2.length() - 1);
                }
                return str2.substring(6, lastIndexOf);
            }
        }
        return "";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b>
     arg types: [java.lang.String, int]
     candidates:
      mark.via.c.b.a(int, int):void
      mark.via.c.b.a(java.lang.String, java.lang.String):void
      mark.via.c.b.a(mark.via.a.b, boolean):void
      mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0237 A[SYNTHETIC, Splitter:B:62:0x0237] */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    public void a() {
        Throwable th;
        Iterator<b> it;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", mark.via.b.a.f245a);
        Date date = new Date(System.currentTimeMillis());
        String str = this.f250a.getResources().getString(R.string.b2) + "_" + this.f250a.getResources().getString(R.string.be) + "_" + simpleDateFormat.format(date);
        mark.via.f.a b = mark.via.f.a.b(this.f250a);
        String str2 = mark.via.b.a.i + "/" + b.o() + "/";
        File file = new File(str2);
        boolean exists = file.exists();
        if (!exists) {
            exists = file.mkdirs();
        }
        if (exists) {
            File file2 = new File(str2, str + ".html");
            int i = 0;
            while (file2.exists()) {
                i++;
                file2 = new File(str2, str + "_" + i + ".html");
            }
            BufferedWriter bufferedWriter = null;
            try {
                mark.via.c.b a2 = mark.via.c.b.a(this.f250a);
                String[] h = a2.h();
                List<b> a3 = a2.a("", false);
                if (h.length > 0 || a3.size() > 0) {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2.getPath(), false), mark.via.b.a.d));
                    try {
                        bufferedWriter2.write("<!DOCTYPE NETSCAPE-Bookmark-file-1>\n<!-- This is an automatically generated file.\n     It will be read and overwritten.\n     DO NOT EDIT! -->\n<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">\n<TITLE>Bookmarks</TITLE>\n<H1>Bookmarks</H1>\n<DL><p>");
                        bufferedWriter2.newLine();
                        int i2 = 0;
                        for (int length = h.length; i2 < length; length = length) {
                            String str3 = h[i2];
                            bufferedWriter2.write("<DT><H3 DATA=\"FOLDER\">" + str3 + "</H3>");
                            bufferedWriter2.newLine();
                            bufferedWriter2.write("<DL><p>");
                            bufferedWriter2.newLine();
                            Iterator<b> it2 = (str3.isEmpty() ? a3 : a2.a(str3, false)).iterator();
                            while (it2.hasNext()) {
                                b next = it2.next();
                                if (!"folder://".equals(next.f())) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("<DT><A HREF=\"");
                                    it = it2;
                                    sb.append(next.f());
                                    sb.append("\">");
                                    sb.append(next.e());
                                    sb.append("</A>");
                                    bufferedWriter2.write(sb.toString());
                                    bufferedWriter2.newLine();
                                } else {
                                    it = it2;
                                }
                                it2 = it;
                            }
                            bufferedWriter2.write("</DL><p>");
                            bufferedWriter2.newLine();
                            i2++;
                        }
                        for (b bVar : a2.a("", false)) {
                            if (!"folder://".equals(bVar.f())) {
                                bufferedWriter2.write("<DT><A HREF=\"" + bVar.f() + "\">" + bVar.e() + "</A>");
                                bufferedWriter2.newLine();
                            }
                        }
                        bufferedWriter2.write("</DL><p>");
                        bufferedWriter2.newLine();
                        e.b(this.f250a, a.a.b.p.a.e(this.f250a, R.string.cl), this.f250a.getString(R.string.bc) + " " + file2.getPath());
                        bufferedWriter = bufferedWriter2;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        try {
                            e.printStackTrace();
                            if (bufferedWriter == null) {
                                bufferedWriter.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
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
                } else {
                    e.a(this.f250a, (int) R.string.f6);
                }
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
                if (bufferedWriter == null) {
                }
            }
        }
    }

    public int a(File file) {
        if (file == null) {
            return 0;
        }
        String c = h.c(file);
        ArrayList arrayList = new ArrayList();
        if (".txt".equalsIgnoreCase(c)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath()), mark.via.b.a.d));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    JSONObject jSONObject = new JSONObject(readLine);
                    b bVar = new b();
                    bVar.b(jSONObject.getString("title"));
                    bVar.c(jSONObject.getString("url"));
                    bVar.a(jSONObject.getString("folder"));
                    bVar.c(jSONObject.getInt("order"));
                    arrayList.add(bVar);
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (".html".equalsIgnoreCase(c)) {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath()), mark.via.b.a.d));
                String str = "";
                while (true) {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    String trim = readLine2.trim();
                    if ((trim.startsWith("<dt><h3") && trim.endsWith("</h3>")) || (trim.startsWith("<DT><H3") && trim.endsWith("</H3>"))) {
                        str = a(trim);
                    }
                    if (trim.startsWith("</DL>") || trim.startsWith("</dl>")) {
                        str = "";
                    }
                    if (trim.startsWith("<dt><a") || trim.startsWith("<DT><A")) {
                        String b = b(trim);
                        String c2 = c(trim);
                        if (!b.trim().isEmpty() && !c2.trim().isEmpty()) {
                            b bVar2 = new b();
                            bVar2.b(b);
                            bVar2.c(c2);
                            bVar2.a(str);
                            arrayList.add(bVar2);
                        }
                    }
                }
                bufferedReader2.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            try {
                mark.via.c.b.a(this.f250a).b(arrayList);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return size;
    }

    private static String a(String str) {
        String substring = str.substring(0, str.length() - 5);
        return substring.substring(substring.lastIndexOf(">") + 1);
    }
}
