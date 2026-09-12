package com.transsion.home.view;

import hj.i;
import java.util.HashMap;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f45839b;

    /* renamed from: a, reason: collision with root package name */
    public static final g f45838a = new g();

    /* renamed from: c, reason: collision with root package name */
    public static final int f45840c = 8;

    private g() {
    }

    private final void c() {
        HashMap hashMap = new HashMap();
        hashMap.put("click", "search");
        i.f64628a.p("guide", hashMap);
    }

    public final boolean a() {
        return f45839b;
    }

    public final void b(boolean z10) {
        com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("search_guide", true);
        if (z10) {
            c();
        }
    }

    public final void d() {
        f45839b = false;
    }

    public final void e(boolean z10) {
        f45839b = z10;
    }
}
