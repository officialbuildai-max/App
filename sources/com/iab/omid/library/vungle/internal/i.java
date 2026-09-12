package com.iab.omid.library.vungle.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.vungle.internal.d;
import com.iab.omid.library.vungle.walking.TreeWalker;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class i implements d.a, se.c {

    /* renamed from: f, reason: collision with root package name */
    private static i f33874f;

    /* renamed from: a, reason: collision with root package name */
    private float f33875a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    private final se.e f33876b;

    /* renamed from: c, reason: collision with root package name */
    private final se.b f33877c;

    /* renamed from: d, reason: collision with root package name */
    private se.d f33878d;

    /* renamed from: e, reason: collision with root package name */
    private c f33879e;

    public i(se.e eVar, se.b bVar) {
        this.f33876b = eVar;
        this.f33877c = bVar;
    }

    private c a() {
        if (this.f33879e == null) {
            this.f33879e = c.e();
        }
        return this.f33879e;
    }

    public static i d() {
        if (f33874f == null) {
            f33874f = new i(new se.e(), new se.b());
        }
        return f33874f;
    }

    @Override // se.c
    public void a(float f11) {
        this.f33875a = f11;
        Iterator it = a().a().iterator();
        while (it.hasNext()) {
            ((com.iab.omid.library.vungle.adsession.h) it.next()).k().b(f11);
        }
    }

    @Override // com.iab.omid.library.vungle.internal.d.a
    public void a(boolean z10) {
        if (z10) {
            TreeWalker.p().q();
        } else {
            TreeWalker.p().o();
        }
    }

    public void b(Context context) {
        this.f33878d = this.f33876b.a(new Handler(), context, this.f33877c.a(), this);
    }

    public float c() {
        return this.f33875a;
    }

    public void e() {
        b.k().b(this);
        b.k().i();
        TreeWalker.p().q();
        this.f33878d.d();
    }

    public void f() {
        TreeWalker.p().s();
        b.k().j();
        this.f33878d.e();
    }
}
