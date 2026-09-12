package com.iab.omid.library.bytedance2.internal;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static g f33508b = new g();

    /* renamed from: a, reason: collision with root package name */
    private Context f33509a;

    private g() {
    }

    public static g b() {
        return f33508b;
    }

    public Context a() {
        return this.f33509a;
    }

    public void a(Context context) {
        this.f33509a = context != null ? context.getApplicationContext() : null;
    }
}
