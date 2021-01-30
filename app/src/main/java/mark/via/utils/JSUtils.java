package mark.via.utils;

/* renamed from: mark.via.n.p */
/* compiled from: JSUtils */
public class JSUtils {
    /* renamed from: a */
    public static String m2183a(String str) {
        return "if(!document.getElementById('via_inject_css_blocker')){var css=document.createElement('link');css.id='via_inject_css_blocker';css.type='text/css';css.rel=\"stylesheet\";css.href='https://" + str + "/via_inject_blocker.css';var o=document.getElementsByTagName('head');if(o.length>0&&o[0].appendChild(css)){}};";
    }
}
