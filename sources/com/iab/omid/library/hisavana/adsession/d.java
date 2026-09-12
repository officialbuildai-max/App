package com.iab.omid.library.hisavana.adsession;

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
    private final f f33595a;

    /* renamed from: b, reason: collision with root package name */
    private final WebView f33596b;

    /* renamed from: c, reason: collision with root package name */
    private final List f33597c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f33598d;

    /* renamed from: e, reason: collision with root package name */
    private final String f33599e;

    /* renamed from: f, reason: collision with root package name */
    private final String f33600f;

    /* renamed from: g, reason: collision with root package name */
    private final String f33601g;

    /* renamed from: h, reason: collision with root package name */
    private final AdSessionContextType f33602h;

    private d(f fVar, WebView webView, String str, List list, String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.f33597c = arrayList;
        this.f33598d = new HashMap();
        this.f33595a = fVar;
        this.f33596b = webView;
        this.f33599e = str;
        this.f33602h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                this.f33598d.put(UUID.randomUUID().toString(), gVar);
            }
        }
        this.f33601g = str2;
        this.f33600f = str3;
    }

    public static d a(f fVar, String str, List list, String str2, String str3) {
        ie.g.d(fVar, "Partner is null");
        ie.g.d(str, "OM SDK JS script content is null");
        ie.g.d(list, "VerificationScriptResources is null");
        if (str3 != null) {
            ie.g.e(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(fVar, null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    public AdSessionContextType b() {
        return this.f33602h;
    }

    public String c() {
        return this.f33601g;
    }

    public String d() {
        return this.f33600f;
    }

    public Map e() {
        return Collections.unmodifiableMap(this.f33598d);
    }

    public String f() {
        return this.f33599e;
    }

    public f g() {
        return this.f33595a;
    }

    public List h() {
        return Collections.unmodifiableList(this.f33597c);
    }

    public WebView i() {
        return this.f33596b;
    }
}
