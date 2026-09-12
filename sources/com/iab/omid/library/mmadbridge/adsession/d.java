package com.iab.omid.library.mmadbridge.adsession;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final f f33709a;

    /* renamed from: b, reason: collision with root package name */
    private final WebView f33710b;

    /* renamed from: c, reason: collision with root package name */
    private final List f33711c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f33712d;

    /* renamed from: e, reason: collision with root package name */
    private final String f33713e;

    /* renamed from: f, reason: collision with root package name */
    private final String f33714f;

    /* renamed from: g, reason: collision with root package name */
    private final String f33715g;

    /* renamed from: h, reason: collision with root package name */
    private final AdSessionContextType f33716h;

    private d(f fVar, WebView webView, String str, List list, String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.f33711c = arrayList;
        this.f33712d = new HashMap();
        this.f33709a = fVar;
        this.f33710b = webView;
        this.f33713e = str;
        this.f33716h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                this.f33712d.put(UUID.randomUUID().toString(), gVar);
            }
        }
        this.f33715g = str2;
        this.f33714f = str3;
    }

    public static d a(f fVar, WebView webView, String str, String str2) {
        oe.g.d(fVar, "Partner is null");
        oe.g.d(webView, "WebView is null");
        if (str2 != null) {
            oe.g.e(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(fVar, webView, null, null, str, str2, AdSessionContextType.HTML);
    }

    public static d b(f fVar, String str, List list, String str2, String str3) {
        oe.g.d(fVar, "Partner is null");
        oe.g.d(str, "OM SDK JS script content is null");
        oe.g.d(list, "VerificationScriptResources is null");
        if (str3 != null) {
            oe.g.e(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(fVar, null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    public AdSessionContextType c() {
        return this.f33716h;
    }

    public String d() {
        return this.f33715g;
    }

    public String e() {
        return this.f33714f;
    }

    public Map f() {
        return Collections.unmodifiableMap(this.f33712d);
    }

    public String g() {
        return this.f33713e;
    }

    public f h() {
        return this.f33709a;
    }

    public List i() {
        return Collections.unmodifiableList(this.f33711c);
    }

    public WebView j() {
        return this.f33710b;
    }
}
