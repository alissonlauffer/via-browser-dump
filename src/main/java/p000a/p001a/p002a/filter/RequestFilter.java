package p000a.p001a.p002a.filter;

/* renamed from: a.a.a.f.d */
/* compiled from: RequestFilter */
public class RequestFilter implements Filter {

    /* renamed from: a */
    private String f18a = null;

    /* renamed from: b */
    private int f19b = 0;

    /* renamed from: c */
    private String f20c = null;

    /* renamed from: d */
    private Boolean f21d = null;

    /* renamed from: e */
    private boolean f22e = false;

    public RequestFilter() {
        m36b(null, 0, null, null, false);
    }

    /* renamed from: b */
    private void m36b(String str, int i, String str2, Boolean bool, boolean z) {
        this.f18a = str;
        this.f19b = i;
        this.f20c = str2;
        this.f21d = bool;
        this.f22e = z;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: g */
    public static RequestFilter m37g(String str) {
        String trim;
        int length;
        int i;
        char c;
        if (str == null || (length = (trim = str.trim()).length()) < 5 || trim.charAt(0) == '!' || trim.indexOf(92) >= 0) {
            return null;
        }
        RequestFilter dVar = new RequestFilter();
        int indexOf = trim.indexOf(32);
        if (indexOf <= 0) {
            if (trim.charAt(0) == '@' && trim.charAt(1) == '@') {
                dVar.mo47j(true);
                i = 2;
            } else {
                i = 0;
            }
            int indexOf2 = trim.indexOf(36, i);
            int i2 = indexOf2 < 0 ? length : indexOf2;
            if (i2 - i > 1) {
                if (trim.charAt(i) == '|') {
                    i++;
                    if (trim.charAt(i) == '|' && trim.charAt(i + 1) == '*') {
                        i += 2;
                    }
                } else if (trim.charAt(i) == '*') {
                    i++;
                }
                if (trim.charAt(i2 - 1) == '*') {
                    i2--;
                }
            }
            dVar.mo45h(trim.substring(i, i2));
            if (indexOf2 >= 0) {
                int i3 = indexOf2 + 1;
                boolean z = false;
                int i4 = 0;
                int i5 = 0;
                while (i3 < length) {
                    int indexOf3 = trim.indexOf(44, i3);
                    if (indexOf3 < 0) {
                        indexOf3 = length;
                    }
                    if (trim.startsWith("domain=", i3)) {
                        dVar.mo46i(trim.substring(i3 + 7, indexOf3));
                    } else {
                        boolean z2 = trim.charAt(i3) == '~';
                        if (z2) {
                            i3++;
                        }
                        String substring = trim.substring(i3, indexOf3);
                        substring.hashCode();
                        switch (substring.hashCode()) {
                            case -1332194002:
                                if (substring.equals("background")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1112093552:
                                if (substring.equals("xmlhttprequest")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1023368385:
                                if (substring.equals("object")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -991966464:
                                if (substring.equals("third-party")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -907685685:
                                if (substring.equals("script")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -791789939:
                                if (substring.equals("webrtc")) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -260159210:
                                if (substring.equals("genericblock")) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -229565497:
                                if (substring.equals("websocket")) {
                                    c = 7;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -8255151:
                                if (substring.equals("elemhide")) {
                                    c = '\b';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 98816:
                                if (substring.equals("csp")) {
                                    c = '\t';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 99796:
                                if (substring.equals("dtd")) {
                                    c = '\n';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 118466:
                                if (substring.equals("xbl")) {
                                    c = 11;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3148879:
                                if (substring.equals("font")) {
                                    c = '\f';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3441010:
                                if (substring.equals("ping")) {
                                    c = '\r';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 100313435:
                                if (substring.equals("image")) {
                                    c = 14;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 103772132:
                                if (substring.equals("media")) {
                                    c = 15;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 106069776:
                                if (substring.equals("other")) {
                                    c = 16;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 106852524:
                                if (substring.equals("popup")) {
                                    c = 17;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 158213710:
                                if (substring.equals("stylesheet")) {
                                    c = 18;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 268257181:
                                if (substring.equals("object-subrequest")) {
                                    c = 19;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 861720859:
                                if (substring.equals("document")) {
                                    c = 20;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1100161945:
                                if (substring.equals("generichide")) {
                                    c = 21;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2111590235:
                                if (substring.equals("subdocument")) {
                                    c = 22;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 14:
                                i5 = 4;
                                break;
                            case 1:
                                i5 = 1024;
                                break;
                            case 2:
                            case 5:
                            case 6:
                            case '\b':
                            case '\t':
                            case '\r':
                            case 19:
                            case 21:
                                z = true;
                                i5 = -1;
                                break;
                            case 3:
                                dVar.mo48k(z2 ? Boolean.FALSE : Boolean.TRUE);
                                break;
                            case 4:
                                i5 = 2;
                                break;
                            case 7:
                                i5 = 512;
                                break;
                            case '\n':
                            case 11:
                            case 16:
                                i5 = 1;
                                break;
                            case '\f':
                                i5 = 128;
                                break;
                            case 15:
                                i5 = 64;
                                break;
                            case 17:
                                i5 = 256;
                                z = true;
                                break;
                            case 18:
                                i5 = 8;
                                break;
                            case 20:
                                i5 = 32;
                                break;
                            case 22:
                                i5 = 16;
                                break;
                            default:
                                z = true;
                                i5 = 0;
                                break;
                        }
                        if (i5 > 0) {
                            if (z2) {
                                if (i4 == 0) {
                                    i4 = 65535;
                                }
                                i4 &= i5 ^ -1;
                            } else {
                                i4 |= i5;
                            }
                        }
                    }
                    i3 = indexOf3 + 1;
                }
                if (z && i4 == 0) {
                    return null;
                }
                dVar.mo49l(i4);
            }
            return dVar;
        } else if (!trim.startsWith("127.0.0.1")) {
            return null;
        } else {
            dVar.mo45h('|' + trim.substring(indexOf + 1).trim() + '^');
            return dVar;
        }
    }

    @Override // p000a.p001a.p002a.filter.Filter
    /* renamed from: a */
    public String mo17a() {
        return this.f18a;
    }

    /* renamed from: c */
    public String mo40c() {
        return this.f20c;
    }

    /* renamed from: d */
    public Boolean mo41d() {
        return this.f21d;
    }

    /* renamed from: e */
    public int mo42e() {
        return this.f19b;
    }

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj == null || RequestFilter.class != obj.getClass()) {
            return false;
        }
        RequestFilter dVar = (RequestFilter) obj;
        if (this.f22e == dVar.f22e && this.f18a.equals(dVar.f18a) && this.f19b == dVar.mo42e() && ((this.f20c == null && dVar.mo40c() == null) || ((str = this.f20c) != null && str.equals(dVar.mo40c())))) {
            if (this.f21d == null && dVar.mo41d() == null) {
                return true;
            }
            Boolean bool = this.f21d;
            if (bool != null && bool.equals(dVar.mo41d())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo44f() {
        return this.f22e;
    }

    /* renamed from: h */
    public void mo45h(String str) {
        this.f18a = str;
    }

    /* renamed from: i */
    public void mo46i(String str) {
        this.f20c = str;
    }

    /* renamed from: j */
    public void mo47j(boolean z) {
        this.f22e = z;
    }

    /* renamed from: k */
    public void mo48k(Boolean bool) {
        this.f21d = bool;
    }

    /* renamed from: l */
    public void mo49l(int i) {
        this.f19b = i;
    }

    public String toString() {
        return "Filter{content='" + this.f18a + "', type=" + this.f19b + ", domain=" + this.f20c + ", thirdParty=" + this.f21d + ", isException=" + this.f22e + '}';
    }
}
