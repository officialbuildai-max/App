package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.i;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes3.dex */
public class t implements s {

    /* renamed from: e, reason: collision with root package name */
    private static volatile u f24485e;

    /* renamed from: a, reason: collision with root package name */
    private final c9.a f24486a;

    /* renamed from: b, reason: collision with root package name */
    private final c9.a f24487b;

    /* renamed from: c, reason: collision with root package name */
    private final y8.e f24488c;

    /* renamed from: d, reason: collision with root package name */
    private final z8.o f24489d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(c9.a aVar, c9.a aVar2, y8.e eVar, z8.o oVar, z8.s sVar) {
        this.f24486a = aVar;
        this.f24487b = aVar2;
        this.f24488c = eVar;
        this.f24489d = oVar;
        sVar.c();
    }

    private i b(n nVar) {
        i.a g11 = i.a().i(this.f24486a.getTime()).o(this.f24487b.getTime()).n(nVar.g()).h(new h(nVar.b(), nVar.d())).g(nVar.c().a());
        if (nVar.c().e() != null && nVar.c().e().a() != null) {
            g11.l(nVar.c().e().a());
        }
        if (nVar.c().b() != null) {
            r8.e b11 = nVar.c().b();
            if (b11.c() != null) {
                g11.m(b11.c());
            }
            if (b11.a() != null) {
                g11.j(b11.a());
            }
            if (b11.b() != null) {
                g11.k(b11.b());
            }
        }
        return g11.d();
    }

    public static t c() {
        u uVar = f24485e;
        if (uVar != null) {
            return uVar.h();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(r8.c.b("proto"));
    }

    public static void f(Context context) {
        if (f24485e == null) {
            synchronized (t.class) {
                try {
                    if (f24485e == null) {
                        f24485e = e.a().a(context).build();
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.s
    public void a(n nVar, r8.j jVar) {
        this.f24488c.a(nVar.f().f(nVar.c().d()), b(nVar), jVar);
    }

    public z8.o e() {
        return this.f24489d;
    }

    public r8.i g(f fVar) {
        return new p(d(fVar), o.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }

    public r8.i h(String str) {
        return new p(d(null), o.a().b(str).a(), this);
    }
}
