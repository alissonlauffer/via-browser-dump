package mark.via.util;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: JSUtils */
public class k {
    public static HashMap<String, String> a() {
        String[] split = "dgtle.com##.footer-abox\nwww.miui.com###app\nbing.com###BottomAppPro\njianshu.com##.top,.open-app-btn\nsina.cn##[href*=\"://sax\"],.fl_app,.sina_tj_banner,a[data-adid],div[sax-type=\"proxy\"],#pl-blog-artad,#pl-adtop-bar,.foot-bar,.m-client-call,.article-sax\n36kr.com##w.J_appDownloadWrapper\nm.mydrivers.com###dangbei_down,.share,.jptj,#menu,div[style=\"HEIGHT:58px;LINE-HEIGHT:0px;\"]\nm.guokr.com###fixedAdWrap\ncoolapk.com##.under\nm.toutiao.com##.icon-container,.banner-top\nithome.com##.open-app-banner,.open-app\nbbs.gfan.com##.downs\nhuxiu.com###js-open-app\n214sihu.com###android-tip,#weixin-tip,#leftCouple,#rightCouple,.top_box,.global_video_bottom_dbtc\nm.budejie.com###downApp,#topBanner,.top-banner-download\nc.m.163.com##.redpacket-enter,.m-slider-footer\nwoshipm.com##.downapp\nm.thepaper.cn##.app_fixed,.app_down3,.dowloadApp\nm.baidu.com##.page-banner\nqiushibaike.com##sid\nyidianzixun.com##.banner,.layer-download\nplay.163.com###J-download-client-box\nzybang.com##.qb-wgt_guide,.about,.qb-wgt_middle-ad,.askTeacher,.footer-banner,.fixed-topB1anner-container,.after-middleAd\nbaijiahao.baidu.com##.openBox-shareEntry\nzhihu.com##.AppPromotionBar,.DownloadGuide\nm.jiemian.com##.header{height:0!important;display:none!important;}\nifeng.com##.s-wrap\nqingmang.me##.navbar\njingyan.baidu.com##.wgt-ad-fix-bottom-banner.douwan{height:0px!important;},.wgt-ad-bottom\nm.hupu.com##.m-app{height:0 !important}.hupu-azlayer-ath,.m-app-info\nqdaily.com##.mobile.articles,.com-article-detail,.page-content{margin-top: 0 !important;}.com-header-brief\n3g.163.com##.u_floatad,.doc-footer-wrapper,.home_packet\nzhidao.baidu.com##.realNameTip,ec_ad_new\nv.sm.cn##.ucdownload,.ucdownload-short\nzhiyoo.com###down_app, .tips_screen,.mask,.tips_down,#header_app,.zyforum\nwapwenku.baidu.com##.sf-edu-wenku-id-adwrap,.sf-edu-wenku-id-right-fixed-ad-wrap\ndouban.com##.banner_bg,.bottom_ad_download\navgle.com###player_3x2_close{font-size: 250% !important;}img[src*=\".php\"],#blocked-if\nxw.qq.com##.ad-inner\nblog.csdn.net##body{padding-top: 52px !important}body #main{margin-top: 0 !important}#csdn-toolbar {top: 0 !important}.wapappdownloadbox,.btn_app_link\nsohu.com##.top-bill-wrapper,.bill-placeholder,.fixed_setto_desktop,#apkBanner\nbilibili.com##.index__container__src-commonComponent-bottomOpenApp-\nm.so.com##.msocom-bottom-banner\npanda.tv###tip-download\nbing.com###BottomAppPro\nzhanqi.tv##.footer,.js-btn-open-app\nm.caijing.com.cn##.downdiv\nm.people.cn##.m-page-tip,.channl_con\ncnblogs.com##div[id^=\"div-gpt-ad\"]\nwww.baidu.com##.page-banner".split("\n");
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : split) {
            String[] split2 = str.split("##");
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.util.k.a(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      mark.via.util.k.a(java.util.HashMap<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
      mark.via.util.k.a(java.lang.String, boolean):java.lang.String */
    public static String a(HashMap<String, String> hashMap, String str) {
        if (hashMap.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        for (String str2 : hashMap.keySet()) {
            if (str.contains(str2)) {
                return a(hashMap.get(str2), true);
            }
        }
        return a(".adsbygoogle", true);
    }

    public static String a(String str, boolean z) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (trim.length() <= 0) {
            return "";
        }
        String replace = trim.replace("'", "\"");
        String str2 = z ? "via_inject_css_inner" : "via_inject_css_marked";
        StringBuilder sb = new StringBuilder();
        sb.append("if(document&&!document.getElementById('");
        sb.append(str2);
        sb.append("')){css=document.createElement('style');css.type='text/css';css.id='");
        sb.append(str2);
        sb.append("';var textNode=document.createTextNode('");
        if (!replace.endsWith("}")) {
            replace = replace + "{display: none !important;}";
        }
        sb.append(replace);
        sb.append("');css.appendChild(textNode);var o=document.getElementsByTagName(\"head\");if(o.length>0&&o[0].appendChild(css)){}}");
        return sb.toString();
    }
}
