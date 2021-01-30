package timber.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: f.a.a */
/* compiled from: Timber */
public final class Timber {

    /* renamed from: a */
    private static final Tree[] f942a;

    /* renamed from: b */
    private static final List<Tree> f943b = new ArrayList();

    /* renamed from: c */
    static volatile Tree[] f944c;

    /* renamed from: d */
    private static final Tree f945d = new C0339a();

    /* renamed from: f.a.a$a */
    /* compiled from: Timber */
    static class C0339a extends Tree {
        C0339a() {
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: a */
        public void mo433a(String str, Object... objArr) {
            for (Tree bVar : Timber.f944c) {
                bVar.mo433a(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: b */
        public void mo434b(String str, Object... objArr) {
            for (Tree bVar : Timber.f944c) {
                bVar.mo434b(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: c */
        public void mo435c(Throwable th) {
            for (Tree bVar : Timber.f944c) {
                bVar.mo435c(th);
            }
        }

        /* access modifiers changed from: protected */
        @Override // timber.log.Timber.Tree
        /* renamed from: i */
        public void mo436i(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    }

    /* renamed from: f.a.a$b */
    /* compiled from: Timber */
    public static abstract class Tree {

        /* renamed from: a */
        final ThreadLocal<String> f946a = new ThreadLocal<>();

        /* renamed from: e */
        private String m980e(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        /* renamed from: j */
        private void m981j(int i, Throwable th, String str, Object... objArr) {
            String f = mo438f();
            if (mo440h(f, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = mo437d(str, objArr);
                    }
                    if (th != null) {
                        str = str + "\n" + m980e(th);
                    }
                } else if (th != null) {
                    str = m980e(th);
                } else {
                    return;
                }
                mo436i(i, f, str, th);
            }
        }

        /* renamed from: a */
        public void mo433a(String str, Object... objArr) {
            m981j(3, null, str, objArr);
        }

        /* renamed from: b */
        public void mo434b(String str, Object... objArr) {
            m981j(6, null, str, objArr);
        }

        /* renamed from: c */
        public void mo435c(Throwable th) {
            m981j(6, th, null, new Object[0]);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public String mo437d(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public String mo438f() {
            String str = this.f946a.get();
            if (str != null) {
                this.f946a.remove();
            }
            return str;
        }

        /* access modifiers changed from: protected */
        @Deprecated
        /* renamed from: g */
        public boolean mo439g(int i) {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public boolean mo440h(String str, int i) {
            return mo439g(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public abstract void mo436i(int i, String str, String str2, Throwable th);
    }

    static {
        Tree[] bVarArr = new Tree[0];
        f942a = bVarArr;
        f944c = bVarArr;
    }

    /* renamed from: a */
    public static void m971a(String str, Object... objArr) {
        f945d.mo433a(str, objArr);
    }

    /* renamed from: b */
    public static void m972b(String str, Object... objArr) {
        f945d.mo434b(str, objArr);
    }

    /* renamed from: c */
    public static void m973c(Throwable th) {
        f945d.mo435c(th);
    }

    /* renamed from: d */
    public static void plant(Tree bVar) {
        if (bVar == null) {
            throw new NullPointerException("tree == null");
        } else if (bVar != f945d) {
            List<Tree> list = f943b;
            synchronized (list) {
                list.add(bVar);
                f944c = (Tree[]) list.toArray(new Tree[list.size()]);
            }
        } else {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
    }

    /* renamed from: e */
    public static void uproot(Tree bVar) {
        List<Tree> list = f943b;
        synchronized (list) {
            if (list.remove(bVar)) {
                f944c = (Tree[]) list.toArray(new Tree[list.size()]);
            } else {
                throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + bVar);
            }
        }
    }
}
