package com.iab.omid.library.vungle.internal;

import android.content.Context;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static g f33868b = new g();

    /* renamed from: a, reason: collision with root package name */
    private Context f33869a;

    private g() {
    }

    public static g c() {
        return f33868b;
    }

    public Context a() {
        return this.f33869a;
    }

    public void b(Context context) {
        this.f33869a = context != null ? context.getApplicationContext() : null;
    }
}
