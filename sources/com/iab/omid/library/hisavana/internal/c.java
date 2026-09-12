package com.iab.omid.library.hisavana.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static c f33626c = new c();

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f33627a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f33628b = new ArrayList();

    private c() {
    }

    public static c e() {
        return f33626c;
    }

    public Collection a() {
        return Collections.unmodifiableCollection(this.f33628b);
    }

    public void b(com.iab.omid.library.hisavana.adsession.h hVar) {
        this.f33627a.add(hVar);
    }

    public Collection c() {
        return Collections.unmodifiableCollection(this.f33627a);
    }

    public void d(com.iab.omid.library.hisavana.adsession.h hVar) {
        boolean g11 = g();
        this.f33627a.remove(hVar);
        this.f33628b.remove(hVar);
        if (!g11 || g()) {
            return;
        }
        i.d().f();
    }

    public void f(com.iab.omid.library.hisavana.adsession.h hVar) {
        boolean g11 = g();
        this.f33628b.add(hVar);
        if (g11) {
            return;
        }
        i.d().e();
    }

    public boolean g() {
        return this.f33628b.size() > 0;
    }
}
