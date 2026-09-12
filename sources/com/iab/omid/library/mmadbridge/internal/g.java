package com.iab.omid.library.mmadbridge.internal;

import android.content.Context;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static g f33757b = new g();

    /* renamed from: a, reason: collision with root package name */
    private Context f33758a;

    private g() {
    }

    public static g c() {
        return f33757b;
    }

    public Context a() {
        return this.f33758a;
    }

    public void b(Context context) {
        this.f33758a = context != null ? context.getApplicationContext() : null;
    }
}
