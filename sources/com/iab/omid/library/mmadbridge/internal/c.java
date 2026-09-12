package com.iab.omid.library.mmadbridge.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static c f33745c = new c();

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f33746a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f33747b = new ArrayList();

    private c() {
    }

    public static c e() {
        return f33745c;
    }

    public Collection a() {
        return Collections.unmodifiableCollection(this.f33747b);
    }

    public void b(com.iab.omid.library.mmadbridge.adsession.h hVar) {
        this.f33746a.add(hVar);
    }

    public Collection c() {
        return Collections.unmodifiableCollection(this.f33746a);
    }

    public void d(com.iab.omid.library.mmadbridge.adsession.h hVar) {
        boolean g11 = g();
        this.f33746a.remove(hVar);
        this.f33747b.remove(hVar);
        if (!g11 || g()) {
            return;
        }
        i.d().f();
    }

    public void f(com.iab.omid.library.mmadbridge.adsession.h hVar) {
        boolean g11 = g();
        this.f33747b.add(hVar);
        if (g11) {
            return;
        }
        i.d().e();
    }

    public boolean g() {
        return this.f33747b.size() > 0;
    }
}
