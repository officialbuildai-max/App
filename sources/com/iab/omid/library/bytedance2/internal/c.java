package com.iab.omid.library.bytedance2.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static c f33496c = new c();

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.bytedance2.adsession.a> f33497a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.bytedance2.adsession.a> f33498b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return f33496c;
    }

    public Collection<com.iab.omid.library.bytedance2.adsession.a> a() {
        return Collections.unmodifiableCollection(this.f33498b);
    }

    public void a(com.iab.omid.library.bytedance2.adsession.a aVar) {
        this.f33497a.add(aVar);
    }

    public Collection<com.iab.omid.library.bytedance2.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f33497a);
    }

    public void b(com.iab.omid.library.bytedance2.adsession.a aVar) {
        boolean d11 = d();
        this.f33497a.remove(aVar);
        this.f33498b.remove(aVar);
        if (!d11 || d()) {
            return;
        }
        i.c().e();
    }

    public void c(com.iab.omid.library.bytedance2.adsession.a aVar) {
        boolean d11 = d();
        this.f33498b.add(aVar);
        if (d11) {
            return;
        }
        i.c().d();
    }

    public boolean d() {
        return this.f33498b.size() > 0;
    }
}
