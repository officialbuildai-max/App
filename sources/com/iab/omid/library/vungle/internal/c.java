package com.iab.omid.library.vungle.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static c f33860c = new c();

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f33861a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f33862b = new ArrayList();

    private c() {
    }

    public static c e() {
        return f33860c;
    }

    public Collection a() {
        return Collections.unmodifiableCollection(this.f33862b);
    }

    public void b(com.iab.omid.library.vungle.adsession.h hVar) {
        this.f33861a.add(hVar);
    }

    public Collection c() {
        return Collections.unmodifiableCollection(this.f33861a);
    }

    public void d(com.iab.omid.library.vungle.adsession.h hVar) {
        boolean g11 = g();
        this.f33861a.remove(hVar);
        this.f33862b.remove(hVar);
        if (!g11 || g()) {
            return;
        }
        i.d().f();
    }

    public void f(com.iab.omid.library.vungle.adsession.h hVar) {
        boolean g11 = g();
        this.f33862b.add(hVar);
        if (g11) {
            return;
        }
        i.d().e();
    }

    public boolean g() {
        return this.f33862b.size() > 0;
    }
}
