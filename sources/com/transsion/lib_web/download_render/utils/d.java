package com.transsion.lib_web.download_render.utils;

import gm.i;
import nh.m;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f46242a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f46243b;

    private d() {
    }

    public final boolean a() {
        return f46243b;
    }

    public final void b() {
        i.f64006a.a("DR_", "net connected");
        f46243b = true;
    }

    public final void c() {
        i.f64006a.a("DR_", "net disConnected");
        f46243b = false;
    }

    public final void d() {
        f46243b = m.f70597a.b() == 2;
    }
}
