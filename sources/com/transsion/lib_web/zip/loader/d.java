package com.transsion.lib_web.zip.loader;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f46260a;

    /* renamed from: b, reason: collision with root package name */
    private final List f46261b;

    /* renamed from: c, reason: collision with root package name */
    private String f46262c;

    /* renamed from: d, reason: collision with root package name */
    private String f46263d;

    /* renamed from: e, reason: collision with root package name */
    private String f46264e;

    public d(Context context, List loaders) {
        Intrinsics.h(context, "context");
        Intrinsics.h(loaders, "loaders");
        this.f46260a = context;
        this.f46261b = loaders;
        this.f46262c = "";
        this.f46263d = "";
        this.f46264e = "";
    }

    public final WebResourceResponse a(WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null) {
            return null;
        }
        Iterator it = this.f46261b.iterator();
        while (it.hasNext()) {
            WebResourceResponse a11 = ((c) it.next()).a(webResourceRequest);
            if (a11 != null) {
                return a11;
            }
        }
        return null;
    }

    public final boolean b() {
        for (c cVar : this.f46261b) {
        }
        return false;
    }
}
