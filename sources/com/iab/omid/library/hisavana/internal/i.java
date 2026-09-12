package com.iab.omid.library.hisavana.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.hisavana.internal.d;
import com.iab.omid.library.hisavana.walking.TreeWalker;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class i implements d.a, ge.c {

    /* renamed from: f, reason: collision with root package name */
    private static i f33644f;

    /* renamed from: a, reason: collision with root package name */
    private float f33645a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    private final ge.e f33646b;

    /* renamed from: c, reason: collision with root package name */
    private final ge.b f33647c;

    /* renamed from: d, reason: collision with root package name */
    private ge.d f33648d;

    /* renamed from: e, reason: collision with root package name */
    private c f33649e;

    public i(ge.e eVar, ge.b bVar) {
        this.f33646b = eVar;
        this.f33647c = bVar;
    }

    private c a() {
        if (this.f33649e == null) {
            this.f33649e = c.e();
        }
        return this.f33649e;
    }

    public static i d() {
        if (f33644f == null) {
            f33644f = new i(new ge.e(), new ge.b());
        }
        return f33644f;
    }

    @Override // ge.c
    public void a(float f11) {
        this.f33645a = f11;
        Iterator it = a().a().iterator();
        while (it.hasNext()) {
            ((com.iab.omid.library.hisavana.adsession.h) it.next()).l().b(f11);
        }
    }

    @Override // com.iab.omid.library.hisavana.internal.d.a
    public void a(boolean z10) {
        if (z10) {
            TreeWalker.p().q();
        } else {
            TreeWalker.p().o();
        }
    }

    public void b(Context context) {
        this.f33648d = this.f33646b.a(new Handler(), context, this.f33647c.a(), this);
    }

    public float c() {
        return this.f33645a;
    }

    public void e() {
        b.k().b(this);
        b.k().i();
        TreeWalker.p().q();
        this.f33648d.d();
    }

    public void f() {
        TreeWalker.p().s();
        b.k().j();
        this.f33648d.e();
    }
}
