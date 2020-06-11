package mark.via.h.b;

import a.a.b.i.i;
import a.a.b.p.e;
import android.content.Context;
import android.view.View;
import mark.via.gp.R;
import mark.via.util.s;

/* compiled from: BookmarkHelper */
public class a {

    /* renamed from: mark.via.h.b.a$a  reason: collision with other inner class name */
    /* compiled from: BookmarkHelper */
    class C0031a extends i {

        /* renamed from: a  reason: collision with root package name */
        private boolean f255a;
        final /* synthetic */ String b;
        final /* synthetic */ mark.via.c.b c;
        final /* synthetic */ Context d;
        final /* synthetic */ b e;

        C0031a(String str, mark.via.c.b bVar, Context context, b bVar2) {
            this.b = str;
            this.c = bVar;
            this.d = context;
            this.e = bVar2;
        }

        @Override // a.a.b.i.i
        public void a(boolean z) {
            this.f255a = z;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.c.b.a(mark.via.a.b, boolean):void
         arg types: [mark.via.a.b, int]
         candidates:
          mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b>
          mark.via.c.b.a(int, int):void
          mark.via.c.b.a(java.lang.String, java.lang.String):void
          mark.via.c.b.a(mark.via.a.b, boolean):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.c.b.b(mark.via.a.b, boolean):void
         arg types: [mark.via.a.b, int]
         candidates:
          mark.via.c.b.b(java.lang.String, java.lang.String):void
          mark.via.c.b.b(mark.via.a.b, boolean):void */
        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 2)) {
                String a2 = s.a(strArr[1], this.b);
                this.c.a(new mark.via.a.b(a2, strArr[0], strArr[2]), true);
                if (this.f255a) {
                    mark.via.c.b bVar = this.c;
                    bVar.b(bVar.i(a2), true);
                    a.a.b.j.a.b().d(1);
                }
                e.a(this.d, (int) R.string.el);
                a.a.b.j.a.b().d(2);
                b bVar2 = this.e;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
        }
    }

    /* compiled from: BookmarkHelper */
    class b extends i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ mark.via.a.b f256a;
        final /* synthetic */ String b;
        final /* synthetic */ mark.via.c.b c;
        final /* synthetic */ String d;
        final /* synthetic */ b e;

        b(mark.via.a.b bVar, String str, mark.via.c.b bVar2, String str2, b bVar3) {
            this.f256a = bVar;
            this.b = str;
            this.c = bVar2;
            this.d = str2;
            this.e = bVar3;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.c.b.a(mark.via.a.b, boolean):void
         arg types: [mark.via.a.b, int]
         candidates:
          mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b>
          mark.via.c.b.a(int, int):void
          mark.via.c.b.a(java.lang.String, java.lang.String):void
          mark.via.c.b.a(mark.via.a.b, boolean):void */
        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 2)) {
                this.f256a.b(strArr[0]);
                this.f256a.c(s.a(strArr[1], this.b));
                this.f256a.a(strArr[2]);
                this.c.c(this.d);
                this.c.a(this.f256a, false);
                a.a.b.j.a.b().d(2);
                b bVar = this.e;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* compiled from: BookmarkHelper */
    class c extends i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ mark.via.c.b f257a;
        final /* synthetic */ String b;
        final /* synthetic */ b c;

        c(mark.via.c.b bVar, String str, b bVar2) {
            this.f257a = bVar;
            this.b = str;
            this.c = bVar2;
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 1)) {
                this.f257a.a(this.b, strArr[0]);
                a.a.b.j.a.b().d(2);
                b bVar = this.c;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* compiled from: BookmarkHelper */
    class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f258a;
        final /* synthetic */ String b;
        final /* synthetic */ b c;

        d(Context context, String str, b bVar) {
            this.f258a = context;
            this.b = str;
            this.c = bVar;
        }

        public void onClick(View view) {
            mark.via.c.b.a(this.f258a).d(this.b);
            a.a.b.j.a.b().d(2);
            b bVar = this.c;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: MutableMD:(int, boolean):a.a.b.i.a
     arg types: [int, int]
     candidates:
      a.a.b.i.d.a(java.lang.String, a.a.b.i.i):a.a.b.i.d
      a.a.b.i.d.a(int, java.lang.String):a.a.b.i.d
      a.a.b.i.d.a(java.lang.String, a.a.b.i.i):a.a.b.i.d
      MutableMD:(int, a.a.b.i.i):a.a.b.i.a
      MutableMD:(int, android.view.View$OnClickListener):a.a.b.i.a
      MutableMD:(java.lang.String, a.a.b.i.i):a.a.b.i.a
      MutableMD:(java.lang.String, android.view.View$OnClickListener):a.a.b.i.a
      MutableMD:(java.lang.String, boolean):a.a.b.i.a
      a.a.b.i.a.a(int, int):void
      a.a.b.i.a.a(android.widget.TextView, java.lang.String):boolean
      MutableMD:(int, boolean):a.a.b.i.a */
    public static void a(Context context, String str, String str2, String str3, b bVar) {
        if (str == null || mark.via.util.b.a(context, str, (String) null)) {
            str = "http://";
        }
        if (str2 == null) {
            str2 = "";
        }
        mark.via.c.b a2 = mark.via.c.b.a(context);
        String[] h = a2.h();
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(context).b(R.string.f505a);
        dVar.c(false);
        a.a.b.i.d dVar2 = dVar;
        dVar2.a(0, str2, R.string.dq);
        dVar2.a(1, str, R.string.dr);
        dVar2.a(2, "", R.string.dn, h);
        ((a.a.b.i.d) ((a.a.b.i.d) ((a.a.b.i.d) dVar2.a(R.string.b, false)).a(17039370, new C0031a(str3, a2, context, bVar))).a(17039360, (View.OnClickListener) null)).g();
    }

    public static void b(Context context, String str, b bVar) {
        mark.via.c.b a2 = mark.via.c.b.a(context);
        String[] h = a2.h();
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(context).b(R.string.hy);
        dVar.a(0, str, R.string.dn, h);
        ((a.a.b.i.d) dVar.a(17039370, new c(a2, str, bVar))).g();
    }

    public static void a(Context context, String str, String str2, b bVar) {
        mark.via.c.b a2 = mark.via.c.b.a(context);
        mark.via.a.b i = a2.i(str);
        String f = i.f();
        String[] h = a2.h();
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(context).b(R.string.hw);
        dVar.c(false);
        a.a.b.i.d dVar2 = dVar;
        dVar2.a(0, i.e(), R.string.dq);
        dVar2.a(1, i.f(), R.string.dr);
        dVar2.a(2, i.a(), R.string.dn, h);
        ((a.a.b.i.d) ((a.a.b.i.d) dVar2.a(17039370, new b(i, str2, a2, f, bVar))).a(17039360, (View.OnClickListener) null)).g();
    }

    public static void a(Context context, String str) {
        mark.via.c.b.a(context).c(str);
        a.a.b.j.a.b().d(2);
    }

    public static void a(Context context, String str, b bVar) {
        e.b(context, context.getResources().getString(R.string.f0), a.a.b.p.a.a(context, (int) R.string.c9, str), new d(context, str, bVar));
    }
}
