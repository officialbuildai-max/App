package com.iab.omid.library.vungle.adsession;

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
    private final f f33829a;

    /* renamed from: b, reason: collision with root package name */
    private final WebView f33830b;

    /* renamed from: c, reason: collision with root package name */
    private final List f33831c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f33832d;

    /* renamed from: e, reason: collision with root package name */
    private final String f33833e;

    /* renamed from: f, reason: collision with root package name */
    private final String f33834f;

    /* renamed from: g, reason: collision with root package name */
    private final String f33835g;

    /* renamed from: h, reason: collision with root package name */
    private final AdSessionContextType f33836h;

    private d(f fVar, WebView webView, String str, List list, String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.f33831c = arrayList;
        this.f33832d = new HashMap();
        this.f33829a = fVar;
        this.f33830b = webView;
        this.f33833e = str;
        this.f33836h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                this.f33832d.put(UUID.randomUUID().toString(), gVar);
            }
        }
        this.f33835g = str2;
        this.f33834f = str3;
    }

    public static d a(f fVar, WebView webView, String str, String str2) {
        ue.g.d(fVar, "Partner is null");
        ue.g.d(webView, "WebView is null");
        if (str2 != null) {
            ue.g.e(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(fVar, webView, null, null, str, str2, AdSessionContextType.HTML);
    }

    public static d b(f fVar, String str, List list, String str2, String str3) {
        ue.g.d(fVar, "Partner is null");
        ue.g.d(str, "OM SDK JS script content is null");
        ue.g.d(list, "VerificationScriptResources is null");
        if (str3 != null) {
            ue.g.e(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(fVar, null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    public AdSessionContextType c() {
        return this.f33836h;
    }

    public String d() {
        return this.f33835g;
    }

    public String e() {
        return this.f33834f;
    }

    public Map f() {
        return Collections.unmodifiableMap(this.f33832d);
    }

    public String g() {
        return this.f33833e;
    }

    public f h() {
        return this.f33829a;
    }

    public List i() {
        return Collections.unmodifiableList(this.f33831c);
    }

    public WebView j() {
        return this.f33830b;
    }
}
