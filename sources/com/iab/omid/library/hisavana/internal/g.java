package com.iab.omid.library.hisavana.internal;

import android.content.Context;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static g f33638b = new g();

    /* renamed from: a, reason: collision with root package name */
    private Context f33639a;

    private g() {
    }

    public static g c() {
        return f33638b;
    }

    public Context a() {
        return this.f33639a;
    }

    public void b(Context context) {
        this.f33639a = context != null ? context.getApplicationContext() : null;
    }
}
