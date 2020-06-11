package mark.via.h.b;

import a.a.b.p.e;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import mark.via.BrowserApp;
import mark.via.gp.R;

/* compiled from: HistoryHelper */
public class c {

    /* compiled from: HistoryHelper */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f259a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        a(Context context, String str, String str2) {
            this.f259a = context;
            this.b = str;
            this.c = str2;
        }

        public void run() {
            try {
                mark.via.c.b.a(this.f259a).b(this.b, this.c);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: HistoryHelper */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f260a;
        final /* synthetic */ String b;

        b(Context context, String str) {
            this.f260a = context;
            this.b = str;
        }

        public void run() {
            try {
                mark.via.c.b.a(this.f260a).f(this.b);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: mark.via.h.b.c$c  reason: collision with other inner class name */
    /* compiled from: HistoryHelper */
    class C0032c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f261a;
        final /* synthetic */ b b;

        C0032c(Context context, b bVar) {
            this.f261a = context;
            this.b = bVar;
        }

        public void onClick(View view) {
            mark.via.util.b.f(this.f261a);
            a.a.b.j.a.b().d(3);
            b bVar = this.b;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.startsWith("file://") && !str.startsWith("view-source:") && !str.startsWith("about:")) {
            BrowserApp.b().execute(new a(context, str, str2));
            a.a.b.j.a.b().d(3);
        }
    }

    public static void a(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            BrowserApp.b().execute(new b(context, str));
            a.a.b.j.a.b().d(3);
        }
    }

    public static void a(Context context, b bVar) {
        e.a(context, (int) R.string.n, (int) R.string.cm, new C0032c(context, bVar));
    }
}
