package com.iab.omid.library.mmadbridge.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.mmadbridge.internal.d;
import com.iab.omid.library.mmadbridge.walking.TreeWalker;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class i implements d.a, me.c {

    /* renamed from: f, reason: collision with root package name */
    private static i f33763f;

    /* renamed from: a, reason: collision with root package name */
    private float f33764a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    private final me.e f33765b;

    /* renamed from: c, reason: collision with root package name */
    private final me.b f33766c;

    /* renamed from: d, reason: collision with root package name */
    private me.d f33767d;

    /* renamed from: e, reason: collision with root package name */
    private c f33768e;

    public i(me.e eVar, me.b bVar) {
        this.f33765b = eVar;
        this.f33766c = bVar;
    }

    private c a() {
        if (this.f33768e == null) {
            this.f33768e = c.e();
        }
        return this.f33768e;
    }

    public static i d() {
        if (f33763f == null) {
            f33763f = new i(new me.e(), new me.b());
        }
        return f33763f;
    }

    @Override // me.c
    public void a(float f11) {
        this.f33764a = f11;
        Iterator it = a().a().iterator();
        while (it.hasNext()) {
            ((com.iab.omid.library.mmadbridge.adsession.h) it.next()).t().b(f11);
        }
    }

    @Override // com.iab.omid.library.mmadbridge.internal.d.a
    public void a(boolean z10) {
        if (z10) {
            TreeWalker.p().q();
        } else {
            TreeWalker.p().o();
        }
    }

    public void b(Context context) {
        this.f33767d = this.f33765b.a(new Handler(), context, this.f33766c.a(), this);
    }

    public float c() {
        return this.f33764a;
    }

    public void e() {
        b.k().b(this);
        b.k().i();
        TreeWalker.p().q();
        this.f33767d.d();
    }

    public void f() {
        TreeWalker.p().s();
        b.k().j();
        this.f33767d.e();
    }
}
