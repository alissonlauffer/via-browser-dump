package mark.via.manager;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mark.lib.frogsupport.util.IOUtils;
import mark.via.adapter.HistoryItem;
import mark.via.constants.Constants;
import mark.via.handler.DatabaseHandler;

/* renamed from: mark.via.i.a */
/* compiled from: BookmarkManager */
public class BookmarkManager {

    /* renamed from: a */
    private final Context f1384a;

    public BookmarkManager(Context context) {
        this.f1384a = context;
    }

    /* renamed from: a */
    private static String m1738a(String str) {
        String substring = str.substring(0, str.length() - 5);
        return substring.substring(substring.lastIndexOf(">") + 1);
    }

    /* renamed from: b */
    private static String m1739b(String str) {
        return str.substring(str.indexOf("\">") + 2, str.indexOf("</"));
    }

    /* renamed from: c */
    private static String m1740c(String str) {
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

    /* renamed from: d */
    public int mo1060d(InputStream inputStream) {
        if (inputStream == null) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constants.f1299d));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String trim = readLine.trim();
                if ((trim.startsWith("<dt><h3") && trim.endsWith("</h3>")) || (trim.startsWith("<DT><H3") && trim.endsWith("</H3>"))) {
                    str = m1738a(trim);
                }
                if (trim.startsWith("</DL>") || trim.startsWith("</dl>")) {
                    str = "";
                }
                if (trim.startsWith("<dt><a") || trim.startsWith("<DT><A")) {
                    String b = m1739b(trim);
                    String c = m1740c(trim);
                    if (!b.trim().isEmpty() && !c.trim().isEmpty()) {
                        HistoryItem bVar = new HistoryItem();
                        bVar.mo947l(b);
                        bVar.mo948m(c);
                        bVar.mo942h(str);
                        arrayList.add(bVar);
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int size = arrayList.size();
        if (size > 0) {
            try {
                DatabaseHandler.m1595v(this.f1384a).mo1000z(arrayList);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return size;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00dc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00dd, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0137, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0138, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x013d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0137 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x013d A[ExcHandler: RuntimeException (r0v9 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:12:0x003a] */
    /* renamed from: e */
    public int mo1061e(OutputStream outputStream) {
        int i;
        Exception e;
        Iterator<HistoryItem> it;
        if (outputStream == null) {
            return -1;
        }
        BufferedWriter bufferedWriter = null;
        try {
            DatabaseHandler v = DatabaseHandler.m1595v(this.f1384a);
            String[] u = v.mo996u();
            List<HistoryItem> s = v.mo994s("", false);
            if (u.length > 0 || s.size() > 0) {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(outputStream, Constants.f1299d));
                try {
                    bufferedWriter2.write("<!DOCTYPE NETSCAPE-Bookmark-file-1>\n<!-- This is an automatically generated file.\n     It will be read and overwritten.\n     DO NOT EDIT! -->\n<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">\n<TITLE>Bookmarks</TITLE>\n<H1>Bookmarks</H1>\n<DL><p>");
                    bufferedWriter2.newLine();
                    int i2 = 0;
                    i = 0;
                    for (int length = u.length; i2 < length; length = length) {
                        String str = u[i2];
                        bufferedWriter2.write("<DT><H3 DATA=\"FOLDER\">" + str + "</H3>");
                        bufferedWriter2.newLine();
                        bufferedWriter2.write("<DL><p>");
                        bufferedWriter2.newLine();
                        Iterator<HistoryItem> it2 = (str.isEmpty() ? s : v.mo994s(str, false)).iterator();
                        while (it2.hasNext()) {
                            HistoryItem next = it2.next();
                            if (!"folder://".equals(next.mo941g())) {
                                i++;
                                StringBuilder sb = new StringBuilder();
                                sb.append("<DT><A HREF=\"");
                                it = it2;
                                sb.append(next.mo941g());
                                sb.append("\">");
                                sb.append(next.mo940f());
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
                    for (HistoryItem bVar : v.mo994s("", false)) {
                        if (!"folder://".equals(bVar.mo941g())) {
                            i++;
                            bufferedWriter2.write("<DT><A HREF=\"" + bVar.mo941g() + "\">" + bVar.mo940f() + "</A>");
                            bufferedWriter2.newLine();
                        }
                    }
                    bufferedWriter2.write("</DL><p>");
                    bufferedWriter2.newLine();
                    IOUtils.m1362a(bufferedWriter2);
                } catch (RuntimeException e2) {
                } catch (Exception e3) {
                    e = e3;
                    bufferedWriter = bufferedWriter2;
                    i = 0;
                    try {
                        e.printStackTrace();
                        IOUtils.m1362a(bufferedWriter);
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.m1362a(bufferedWriter);
                        throw th;
                    }
                } catch (Throwable th2) {
                }
                return i;
            }
            IOUtils.m1362a(null);
            return 0;
        } catch (RuntimeException e4) {
            throw e4;
        } catch (Exception e5) {
            e = e5;
            i = 0;
            e.printStackTrace();
            IOUtils.m1362a(bufferedWriter);
            return i;
        }
    }
}
