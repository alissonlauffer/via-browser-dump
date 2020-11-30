package mark.via.p044m.p045a;

import android.content.Context;
import android.text.TextUtils;
import mark.lib.frogsupport.util.CompatUtils;
import mark.via.gp.R;
import mark.via.preference.PreferenceManager;
import mark.via.utils.AppUtils;
import mark.via.utils.BrowserUtils;
import mark.via.utils.ChannelUtils;
import mark.via.utils.ViewUtils;

/* renamed from: mark.via.m.a.c */
/* compiled from: WebPage */
public class WebPage {
    /* renamed from: a */
    public static String m1949a(Context context) {
        String f = CompatUtils.m1336f(context, R.string.RES_2131558535);
        String str = "";
        if (AppUtils.m2060h()) {
            f = "我们利用有限的业余时间设计了 Via，虽然它并不那么美好，但正努力前行。\n如果你喜欢我们的作品，可以捐赠来支持我们" + str + "。\n\n所有的捐赠都将用来：提升我们的环境配置以及积极性。\n\n支付宝: 2376688759@qq.com\nPayPal: wiar1824@gmail.com";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>");
        sb.append(CompatUtils.m1336f(context, R.string.RES_2131558571));
        sb.append("</h1><p>");
        sb.append(AppUtils.m2056d().replace("\n", "</p><p>"));
        sb.append("</p><h1>");
        sb.append(CompatUtils.m1336f(context, R.string.RES_2131558494));
        sb.append("</h1><p><a href=\"");
        sb.append("http://viayoo.com/");
        sb.append("\">");
        sb.append(CompatUtils.m1336f(context, R.string.RES_2131558643));
        sb.append("</a></p>");
        sb.append(AppUtils.m2060h() ? "<p><a href=\"http://viayoo.com/contact/qqgroup/\">官方鹅群</a></p>" : str);
        sb.append("<p><a href=\"https://t.me/viatg\">Telegram</a></p><p><a href=\"https://github.com/tuyafeng/Via\">");
        sb.append(CompatUtils.m1336f(context, R.string.RES_2131558577));
        sb.append("</a></p><p><a href=\"");
        sb.append(AppUtils.m2060h() ? "https://viayoo.com/zh-cn/privacy/" : "https://viayoo.com/en/privacy/");
        sb.append("\">");
        sb.append(CompatUtils.m1336f(context, R.string.RES_2131558674));
        sb.append("</a></p>");
        if (!ChannelUtils.m2108c()) {
            str = "<h1>" + CompatUtils.m1336f(context, R.string.RES_2131558534) + "</h1><p>" + f.replace("\n", "</p><p>") + "</p>";
        }
        sb.append(str);
        sb.append("<br><br><br>");
        return sb.toString();
    }

    /* renamed from: b */
    public static String m1950b(String str, String str2) {
        String replaceAll = str2.replaceAll("<.*?>", "");
        return "<div class=\"box\"><a href=\"" + str + "\" title=\"" + replaceAll + "\"></a><p class=\"title\" style=\"background:" + ViewUtils.m2226d(str) + ";\">" + replaceAll + "</p><p class=\"url\">" + BrowserUtils.m2093n(str, true) + "</p></div>";
    }

    /* renamed from: c */
    public static String m1951c(int i) {
        String str = i == 2 ? "var sortable=Sortable.create(bookmark_tags,{disabled:false,delay:150,animation:0,handle:'.box',ghostClass:'sort-ghost',onEnd:function(evt){try{window.via.changeBookmarkOrder(document.title,evt.oldIndex,evt.newIndex)}catch(e){}},});" : i == 1 ? "var sortable=Sortable.create(box_container,{disabled:false,delay:150,animation:0,handle:'.box',ghostClass:'sort-ghost',onEnd:function(evt){try{window.via.changeFavoriteOrder(evt.oldIndex, evt.newIndex)}catch(e){}},});" : "";
        return "<script src=\"file:///android_asset/s3.js\"></script>" + m1957i(m1963o(str));
    }

    /* renamed from: d */
    public static String m1952d(String str, String str2, boolean z) {
        String str3;
        String str4 = "";
        String replaceAll = str2.replaceAll("<.*?>", str4);
        String d = ViewUtils.m2226d(str);
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"box\"><a href=\"");
        sb.append(str);
        sb.append("\" title=\"");
        sb.append(replaceAll);
        sb.append("\"></a><p class=\"title\"");
        if (z) {
            str3 = " style=\"background:" + d + "\"";
        } else {
            str3 = str4;
        }
        sb.append(str3);
        sb.append(">");
        if (replaceAll.trim().length() >= 1) {
            str4 = replaceAll.trim().substring(0, 1);
        }
        sb.append(str4);
        sb.append("</p><p class=\"url\">");
        sb.append(replaceAll);
        sb.append("</p></div>");
        return sb.toString();
    }

    /* renamed from: e */
    public static String m1953e(Context context) {
        PreferenceManager M = PreferenceManager.m1743M(context);
        if (M.mo1086I().isEmpty()) {
            return "<img class=\"smaller\" src=\"file:///android_asset/logo.png\"></img>";
        }
        return M.mo1086I();
    }

    /* renamed from: f */
    public static String m1954f(String str, String str2, String str3) {
        String str4 = "";
        String replaceAll = str2.replaceAll("<.*?>", str4);
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"box\">");
        if (!TextUtils.isEmpty(str3)) {
            str4 = "<div class=\"icon_handle\"><div class=\"" + str3 + " icon\"></div></div>";
        }
        sb.append(str4);
        sb.append("<a href=\"");
        sb.append(str);
        sb.append("\" title=\"");
        sb.append(replaceAll);
        sb.append("\"></a><p class=\"title\">");
        sb.append(replaceAll);
        sb.append("</p></div>");
        return sb.toString();
    }

    /* renamed from: g */
    public static String m1955g(String str, String str2, boolean z, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"box");
        String str4 = "";
        sb.append(z ? " block" : str4);
        sb.append("\"><a href=\"");
        sb.append(str);
        sb.append("\" title=\"");
        sb.append(str);
        sb.append("\"></a><p class=\"title\">");
        sb.append(str3);
        sb.append("<font class=\"tag\">");
        sb.append(z ? "block" : "load");
        sb.append("</font>");
        if (!str2.isEmpty()) {
            str4 = "<font class=\"res tag\">" + str2 + "</font>";
        }
        sb.append(str4);
        sb.append("</p><p class=\"url\">");
        sb.append(str);
        sb.append("</p></div>");
        return sb.toString();
    }

    /* renamed from: h */
    public static String m1956h(String str) {
        return "<div class='hint'>" + str.replace("\n", "<br>") + "</div>";
    }

    /* renamed from: i */
    public static String m1957i(String str) {
        return "<script type=\"text/javascript\">" + str + "</script>";
    }

    /* renamed from: j */
    public static String m1958j() {
        return "function showButton(){document.getElementById(\"search_submit\").style.display=\"block\"}function hideButton(){var a=document.getElementById(\"search_input\").value;\"\"==a&&(document.getElementById(\"search_submit\").style.display=\"none\")}function search(){var a=document.getElementById(\"search_input\").value;return\"\"!=a&&(window.via.searchText(a),document.getElementById(\"search_input\").value=\"\"),!1}";
    }

    /* renamed from: k */
    public static String m1959k(Context context) {
        return "<div class=\"search_part\"><a class=\"logo\" href=\"folder://\" title=\"" + context.getString(R.string.RES_2131558406) + "\">" + m1953e(context) + "</a><form onsubmit=\"return search()\" class=\"search_bar\" title=\"" + context.getString(R.string.RES_2131558689) + "\"><button onclick=\"search()\" id=\"search_submit\" value=\"\" aria-label=\"" + context.getString(R.string.RES_2131558519) + "\"><div class=\"search icon\"></div></button><span><input class=\"search\" onfocus=\"showButton()\" onblur=\"hideButton()\" type=\"text\" value=\"\" autocomplete=\"off\" id=\"search_input\" title=\"" + context.getString(R.string.RES_2131558689) + "\"></span></form></div>";
    }

    /* renamed from: l */
    public static String m1960l(Context context, int i) {
        String str;
        String str2;
        String str3;
        PreferenceManager M = PreferenceManager.m1743M(context);
        boolean z = !ViewUtils.m2239q(M.mo1179q0());
        boolean Z = M.mo1129Z(context);
        boolean z2 = !M.mo1074E().isEmpty();
        String str4 = (Z || z) ? "#fafafa" : "#1b1b1b";
        String str5 = (Z || z) ? "#d5d5d5" : "#2b2b2b";
        String str6 = (Z || z) ? "#e9e9e9" : "#313131";
        if (Z) {
            str = "#000000";
        } else {
            str = ViewUtils.m2222I(M.mo1179q0());
        }
        String str7 = "color: " + str4 + ";";
        String str8 = "color: " + str5 + ";";
        String str9 = "color: " + str6 + ";";
        StringBuilder sb = new StringBuilder();
        sb.append("background-color: ");
        sb.append(str);
        sb.append(";");
        if (z2) {
            str2 = "background: " + str + " url(\"" + M.mo1074E() + "\") no-repeat fixed center; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size:cover;";
        } else {
            str2 = "";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("background-color: rgba(0, 0, 0, ");
        sb3.append(z2 ? String.valueOf(Math.min(((float) M.mo1080G()) / 100.0f, 0.8f)) : "0");
        sb3.append(");");
        String sb4 = sb3.toString();
        String str10 = (Z || z) ? "rgba(255, 255, 255, 0.1)" : "rgba(0, 0, 0, 0.1)";
        String str11 = (z || Z) ? "rgba(0, 0, 0, 0.6)" : "rgba(255, 255, 255, 0.6)";
        StringBuilder sb5 = new StringBuilder();
        sb5.append("* {padding:0;margin:0;box-sizing:border-box;}");
        sb5.append("html{height:100%; max-height:100%;-webkit-tap-highlight-color:");
        sb5.append(str10);
        sb5.append(";-webkit-focus-ring-color: rgba(0, 0, 0, 0); /*-webkit-touch-callout: none; -webkit-user-select: none; -khtml-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none;*/}");
        sb5.append("body{min-height:100%;");
        sb5.append(sb2);
        sb5.append("max-width:100%; width: 600px;margin: auto;text-align: center;}");
        sb5.append(".frosted-glass{");
        sb5.append(sb4);
        sb5.append("position:fixed; left:0; top:0; width: 100%; height: 100%;z-index:-999;}");
        if (AppUtils.m2059g()) {
            sb5.append("html{direction:rtl;}");
        }
        if (i != 1) {
            int i2 = 4;
            if (i == 4) {
                sb5.append("#search_input{height:42px;width:95%;outline:none;border:none; ");
                sb5.append("font-size: 15px;");
                sb5.append("background-color:transparent;");
                sb5.append("}");
                sb5.append(".search_part{margin-bottom:20px;}");
                sb5.append("span {display: block;overflow: hidden;padding-left:5px;vertical-align:middle;}");
                sb5.append(".box a {width: 100%;height: 100%;position: absolute;left: 0;top: 0;}");
                sb5.append(".hint {");
                sb5.append(str8);
                sb5.append("font-size: 15px;");
                sb5.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
                sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
                sb5.append(" padding: 50px 5px; text-align: center; margin: auto;}");
                sb5.append(".logo{");
                sb5.append("font-size: 28px;");
                sb5.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
                sb5.append(" text-decoration:none; ");
                sb5.append(str7);
                sb5.append("}");
                sb5.append(".search.icon {color: ");
                sb5.append((M.mo1083H() != 2 || !z) ? "#666666" : "white");
                sb5.append("; width: 12px; height: 12px; border: solid 2px currentColor; border-radius: 100%; -webkit-transform: rotate(-45deg); transform: rotate(-45deg); text-align: center; margin: auto; } .search.icon:before {content: ''; position: absolute; top: 10px; left: 3px; height: 5px; width: 2px; background-color: currentColor; }");
                sb5.append("img.smaller{");
                if (M.mo1123W() != 0) {
                    str3 = "width: 80px; max-width:80px; border-radius: 50%; min-width:80px;";
                } else {
                    str3 = "";
                }
                sb5.append(str3);
                sb5.append("height: 80px;min-height:80px; object-fit: cover; max-height:80px;}");
                sb5.append("#content{position: absolute; top: ");
                sb5.append(M.mo1065B() ? "15px" : "28%");
                sb5.append("; max-width: 600px;width: 100%;}");
                sb5.append(".box {border: 0; position:relative; display: inline-block;text-align: center;}");
                sb5.append(".url {line-height: 24px;}");
                sb5.append(".search_bar{display:table; vertical-align:middle;width:90%;height:42px;max-width:600px;margin:0 auto; margin-top: 15px;}");
                sb5.append("#search_submit{display: none;outline:none;height:42px; width: 42px; float:right;");
                sb5.append("font-size: 15px;");
                sb5.append(" font-weight:bold; border:none; background-color:transparent; padding: 0 10px 0 10px;}");
                sb5.append("#bookmark_part {text-align: center; width:90%; max-width:600px; background-color: transparent; margin: 0 auto; padding: 0; border-radius: 0px;}");
                sb5.append(".title {margin:2px auto;");
                sb5.append("white-space: nowrap; overflow: hidden;");
                sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
                sb5.append("}");
                sb5.append(".url {height: 20px;line-height: 20px; margin: 0 auto; ");
                sb5.append("white-space: nowrap; overflow: hidden;");
                sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
                sb5.append(str8);
                sb5.append("font-size: 10px;");
                sb5.append("}");
                sb5.append("#box_container{text-align:left;margin:0 auto;font-size: 0;}");
                sb5.append(".sort-ghost {opacity: 0.3;}");
                int i3 = 72;
                int H = M.mo1083H();
                int i4 = 1;
                if (H != 1) {
                    if (H != 2) {
                        sb5.append(".search_bar{border:1px solid ");
                        sb5.append(str10);
                        sb5.append("; border-radius: 100px; background: white; box-shadow: 0 0 2px ");
                        sb5.append(str11);
                        sb5.append(";}");
                        sb5.append("#search_input{color: #6c6c6c;}");
                        sb5.append("#search_submit{color: #666666;}");
                        sb5.append(".box {margin: 0;width: 72px;}");
                        sb5.append(".title {border-radius: 100%; color: #ffffff; width: 3.4em; line-height: 3.4em; height: 3.4em; ");
                        sb5.append("font-size: 15px;");
                        sb5.append("}");
                        sb5.append(".url {width: 56px;}");
                    } else {
                        sb5.append(".search_bar{border-bottom:1px solid ");
                        sb5.append(str10);
                        sb5.append("; background: transparent;}");
                        sb5.append("#search_input{ ");
                        sb5.append(str7);
                        sb5.append("}");
                        sb5.append("#search_submit{ ");
                        sb5.append(str7);
                        sb5.append("}");
                        sb5.append(".box {margin: 0;width: 72px;}");
                        sb5.append(".title {");
                        sb5.append(str7);
                        sb5.append("width: 3.4em; line-height: 3.4em; height: 3.4em; ");
                        sb5.append("font-size: 15px;");
                        sb5.append("}");
                        sb5.append(".url {width: 56px;}");
                    }
                    i2 = 6;
                } else {
                    sb5.append(".search_bar{border: 1px solid ");
                    sb5.append(str10);
                    sb5.append("; background-color: rgba(255, 255, 255, 0.8); border-radius: 2px}");
                    sb5.append("#search_input{color:#666666;}");
                    sb5.append("#search_submit{color: #666666;}");
                    sb5.append(".box {margin: 3px 6px;width: 78px;}");
                    sb5.append(".title {color: #ffffff; width:78px; line-height: 3.8em; height: 3.8em; padding: 0 4px;");
                    sb5.append("font-size: 14px;");
                    sb5.append(" border-radius: 5px;}");
                    sb5.append(".url {width: 80px;display: none}");
                    i3 = 90;
                }
                while (i4 <= i2) {
                    sb5.append("@media only screen and (min-width:");
                    int i5 = i4 + 1;
                    sb5.append(i3 * i5);
                    sb5.append("px){#box_container{width:");
                    sb5.append(i4 * i3);
                    sb5.append("px}}");
                    i4 = i5;
                }
                if (AppUtils.m2059g()) {
                    sb5.append("#box_container{text-align:right;}#search_submit{float:left;}");
                }
            } else if (i == 5) {
                sb5.append("div{");
                sb5.append(str7);
                sb5.append("max-width:800px; padding-left:5%; padding-right:5%; text-align:left;}");
                sb5.append("div>h1{");
                sb5.append("font-size: 20px;");
                sb5.append(" padding-top:55px; padding-bottom:45px; text-align: left; }");
                sb5.append("div>p{ text-align: left; line-height: 1.8em; text-indent:2em;");
                sb5.append("font-size: 15px;");
                sb5.append("}");
                sb5.append("a{color: #6f8de1; ");
                sb5.append("font-size: 15px;");
                sb5.append(" line-height: 1.8em; text-decoration:none; }");
                if (AppUtils.m2059g()) {
                    sb5.append("div,h1,p,div>h1,div>p{text-align:right;}");
                }
            } else if (i == 6) {
                sb5.append(".box {margin: 12px 0; text-align: left; vertical-align:middle;position:relative;display: block;padding-top:10px; padding-bottom:10px; padding-left:10px; padding-right:10px;}");
                sb5.append(".box a {width: 100%;height: 100%;position: absolute;left: 0;top: 0;}");
                sb5.append("span, .url, .box {word-break: break-all;}");
                sb5.append(".block{opacity:0.5;}.tag{background:#cd8282;padding:0 8px;margin:0 4px;color:white;font-size:12px;}.res{background:#5c91cb;}");
                sb5.append(".title {");
                sb5.append(str8);
                sb5.append("font-size: 15px;");
                sb5.append(" padding: 4px 0px;}");
                sb5.append(".url {line-height: 1.2em; max-height: 4.8em;");
                sb5.append("font-size: 15px;");
                sb5.append(str7);
                sb5.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
                sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
                sb5.append("}");
                sb5.append(".hint {line-height: 1.8em; ");
                sb5.append(str8);
                sb5.append("font-size: 15px;");
                sb5.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
                sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
                sb5.append(" padding: 50px 5px; text-align: center; margin: auto;}");
                sb5.append("#filter-box{padding:10px}#filter{border: 1px solid ");
                sb5.append(str10);
                sb5.append(";border-radius:2px;-webkit-appearance:none;-moz-appearance:none;appearance:none;background:transparent;padding:5px;width:100%;");
                sb5.append("font-size: 15px;");
                sb5.append(str7);
                sb5.append("}");
                if (AppUtils.m2059g()) {
                    sb5.append(".box{text-align:right;}");
                }
            }
        } else {
            sb5.append("#content {text-align:left;}");
            sb5.append(".box {vertical-align:middle;position:relative;display: block;padding: 20px 14px;border-bottom: 0px solid ");
            sb5.append(str10);
            sb5.append("}");
            sb5.append(".box a {width: 100%;height: 100%;position: absolute;left: 0;top: 0;}");
            sb5.append(".title {padding-left: 28px;");
            sb5.append(str7);
            sb5.append("font-size: 15px;");
            sb5.append("white-space: nowrap; overflow: hidden;");
            sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
            sb5.append("margin:auto;}");
            sb5.append(".url {display: none;}");
            sb5.append(".hint {");
            sb5.append(str8);
            sb5.append("font-size: 15px;");
            sb5.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
            sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
            sb5.append("padding: 50px 5px;text-align: center;margin: auto; line-height: 1.8em;}");
            sb5.append(".tag.icon {");
            sb5.append(str9);
            sb5.append(" position: absolute; margin-left: 3px; margin-top: 5px; width: 7px; height: 7px; border-radius: 1px 1px 1px 0; border-left: solid 1px currentColor; border-top: solid 1px currentColor; } .tag.icon:before {content: ''; position: absolute; left: 1px; top: 1px; width: 9px; height: 10px; border-radius: 1px; border-left: solid 1px currentColor; border-right: solid 1px currentColor; border-bottom: solid 1px currentColor; -webkit-transform: rotate(-45deg); transform: rotate(-45deg); } .tag.icon:after {content: ''; position: absolute; left: 3px; top: 3px; width: 2px; height: 2px; border-radius: 50%; background-color: currentColor; }");
            sb5.append(".icon_handle {width:50px;/*height:100%;position:absolute;top:0;left:0;*/ z-index: 999; }");
            sb5.append(".bookmark.icon {");
            sb5.append(str9);
            sb5.append(" position: absolute; margin-left: 5px; margin-top: 5px; width: 10px; height: 15px; border-radius: 1px 1px 0 0; border-top: solid 1px currentColor; border-left: solid 1px currentColor; border-right: solid 1px currentColor; } .bookmark.icon:before {content: ''; position: absolute; top: 10px; left: 0px; width: 6px; height: 6px; border-top: solid 1px currentColor; border-left: solid 1px currentColor; -webkit-transform: rotate(45deg); transform: rotate(45deg); }");
            sb5.append(".clock.icon {");
            sb5.append(str9);
            sb5.append(" position: absolute; margin-left: 1px; margin-top: 5px; width: 15px; height: 15px; border: solid 1px currentColor; border-radius: 8px; } .clock.icon:before {content: ''; position: absolute; top: 7px; left: 7px; width: 5px; height: 1px; background-color: currentColor; -webkit-transform-origin: 0% 0%; transform-origin: 0% 0%; } .clock.icon:after {content: ''; position: absolute; top: 2px; left: 7px; width: 1px; height: 6px; background-color: currentColor; -webkit-transform-origin: 0% 0%; transform-origin: 0% 0%; }");
            sb5.append(".btn {padding: 12px 20px; color: #ffffff; border-radius: 2px; border: 0; outline: none;");
            sb5.append("font-size: 15px;");
            sb5.append("; margin: 10px;}");
            sb5.append(".sort-ghost {opacity: 0.3;}");
            if (AppUtils.m2059g()) {
                sb5.append("#content {text-align: right;}.title{padding-left:0px;padding-right: 28px;}");
            }
        }
        return sb5.toString();
    }

    /* renamed from: m */
    public static String m1961m(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head><meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no, minimal-ui\">");
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "<title>" + str + "</title>";
        }
        sb.append(str2);
        sb.append("</head>");
        return sb.toString();
    }

    /* renamed from: n */
    public static String m1962n(String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("<style>");
        for (String str : strArr) {
            sb.append(str);
        }
        sb.append("</style>");
        return sb.toString();
    }

    /* renamed from: o */
    private static String m1963o(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return "try{" + str + "}catch(err){console.log(err)}";
    }
}
