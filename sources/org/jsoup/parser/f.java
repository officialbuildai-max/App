package org.jsoup.parser;

import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: j, reason: collision with root package name */
    private static final Map f71962j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f71963k;

    /* renamed from: l, reason: collision with root package name */
    private static final String[] f71964l;

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f71965m;

    /* renamed from: n, reason: collision with root package name */
    private static final String[] f71966n;

    /* renamed from: o, reason: collision with root package name */
    private static final String[] f71967o;

    /* renamed from: p, reason: collision with root package name */
    private static final String[] f71968p;

    /* renamed from: q, reason: collision with root package name */
    private static final String[] f71969q;

    /* renamed from: a, reason: collision with root package name */
    private String f71970a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f71971b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f71972c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f71973d = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71974e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f71975f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f71976g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f71977h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f71978i = false;

    static {
        String[] strArr = {"html", TtmlNode.TAG_HEAD, TtmlNode.TAG_BODY, "frameset", "script", "noscript", TtmlNode.TAG_STYLE, "meta", "link", CampaignEx.JSON_KEY_TITLE, "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", TtmlNode.TAG_P, "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_PRE, TtmlNode.TAG_DIV, "blockquote", "hr", PlaceTypes.ADDRESS, "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", MimeTypes.BASE_TYPE_AUDIO, "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math"};
        f71963k = strArr;
        f71964l = new String[]{"object", "base", "font", TtmlNode.TAG_TT, "i", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, TmcStartParams.KEY_URL_SHORT, "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", EventConstants.KEY_TIME, "acronym", "mark", "ruby", "rt", "rp", "a", "img", TtmlNode.TAG_BR, "wbr", "map", CampaignEx.JSON_KEY_AD_Q, "sub", "sup", "bdo", "iframe", "embed", TtmlNode.TAG_SPAN, "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", NotificationCompat.CATEGORY_PROGRESS, "meter", "area", "param", EventConstants.KEY_SOURCE, "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", EventConstants.KEY_SOURCE, "track", "data", "bdi", "s"};
        f71965m = new String[]{"meta", "link", "base", "frame", "img", TtmlNode.TAG_BR, "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", EventConstants.KEY_SOURCE, "track"};
        f71966n = new String[]{CampaignEx.JSON_KEY_TITLE, "a", TtmlNode.TAG_P, "h1", "h2", "h3", "h4", "h5", "h6", OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_PRE, PlaceTypes.ADDRESS, "li", "th", "td", "script", TtmlNode.TAG_STYLE, "ins", "del", "s"};
        f71967o = new String[]{OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_PRE, "plaintext", CampaignEx.JSON_KEY_TITLE, "textarea"};
        f71968p = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        f71969q = new String[]{"input", "keygen", "object", "select", "textarea"};
        for (String str : strArr) {
            i(new f(str));
        }
        for (String str2 : f71964l) {
            f fVar = new f(str2);
            fVar.f71971b = false;
            fVar.f71972c = false;
            i(fVar);
        }
        for (String str3 : f71965m) {
            f fVar2 = (f) f71962j.get(str3);
            org.jsoup.helper.d.j(fVar2);
            fVar2.f71973d = false;
            fVar2.f71974e = true;
        }
        for (String str4 : f71966n) {
            f fVar3 = (f) f71962j.get(str4);
            org.jsoup.helper.d.j(fVar3);
            fVar3.f71972c = false;
        }
        for (String str5 : f71967o) {
            f fVar4 = (f) f71962j.get(str5);
            org.jsoup.helper.d.j(fVar4);
            fVar4.f71976g = true;
        }
        for (String str6 : f71968p) {
            f fVar5 = (f) f71962j.get(str6);
            org.jsoup.helper.d.j(fVar5);
            fVar5.f71977h = true;
        }
        for (String str7 : f71969q) {
            f fVar6 = (f) f71962j.get(str7);
            org.jsoup.helper.d.j(fVar6);
            fVar6.f71978i = true;
        }
    }

    private f(String str) {
        this.f71970a = str;
    }

    private static void i(f fVar) {
        f71962j.put(fVar.f71970a, fVar);
    }

    public static f k(String str) {
        return l(str, d.f71955d);
    }

    public static f l(String str, d dVar) {
        org.jsoup.helper.d.j(str);
        Map map = f71962j;
        f fVar = (f) map.get(str);
        if (fVar != null) {
            return fVar;
        }
        String b11 = dVar.b(str);
        org.jsoup.helper.d.h(b11);
        f fVar2 = (f) map.get(b11);
        if (fVar2 != null) {
            return fVar2;
        }
        f fVar3 = new f(b11);
        fVar3.f71971b = false;
        return fVar3;
    }

    public boolean a() {
        return this.f71972c;
    }

    public String b() {
        return this.f71970a;
    }

    public boolean c() {
        return this.f71971b;
    }

    public boolean d() {
        return this.f71974e;
    }

    public boolean e() {
        return this.f71977h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f71970a.equals(fVar.f71970a) && this.f71973d == fVar.f71973d && this.f71974e == fVar.f71974e && this.f71972c == fVar.f71972c && this.f71971b == fVar.f71971b && this.f71976g == fVar.f71976g && this.f71975f == fVar.f71975f && this.f71977h == fVar.f71977h && this.f71978i == fVar.f71978i;
    }

    public boolean f() {
        return f71962j.containsKey(this.f71970a);
    }

    public boolean g() {
        return this.f71974e || this.f71975f;
    }

    public boolean h() {
        return this.f71976g;
    }

    public int hashCode() {
        return (((((((((((((((this.f71970a.hashCode() * 31) + (this.f71971b ? 1 : 0)) * 31) + (this.f71972c ? 1 : 0)) * 31) + (this.f71973d ? 1 : 0)) * 31) + (this.f71974e ? 1 : 0)) * 31) + (this.f71975f ? 1 : 0)) * 31) + (this.f71976g ? 1 : 0)) * 31) + (this.f71977h ? 1 : 0)) * 31) + (this.f71978i ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f j() {
        this.f71975f = true;
        return this;
    }

    public String toString() {
        return this.f71970a;
    }
}
