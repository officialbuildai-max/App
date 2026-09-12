package com.iab.omid.library.vungle.adsession;

import android.view.View;
import com.iab.omid.library.vungle.internal.i;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes4.dex */
public class h extends b {

    /* renamed from: a, reason: collision with root package name */
    private final d f33843a;

    /* renamed from: b, reason: collision with root package name */
    private final c f33844b;

    /* renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.vungle.internal.f f33845c;

    /* renamed from: d, reason: collision with root package name */
    private we.a f33846d;

    /* renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f33847e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33848f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f33849g;

    /* renamed from: h, reason: collision with root package name */
    private final String f33850h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33851i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f33852j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, d dVar) {
        this(cVar, dVar, UUID.randomUUID().toString());
    }

    h(c cVar, d dVar, String str) {
        this.f33845c = new com.iab.omid.library.vungle.internal.f();
        this.f33848f = false;
        this.f33849g = false;
        this.f33844b = cVar;
        this.f33843a = dVar;
        this.f33850h = str;
        i(null);
        this.f33847e = (dVar.c() == AdSessionContextType.HTML || dVar.c() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.vungle.publisher.a(str, dVar.j()) : new com.iab.omid.library.vungle.publisher.b(str, dVar.f(), dVar.g());
        this.f33847e.u();
        com.iab.omid.library.vungle.internal.c.e().b(this);
        this.f33847e.e(cVar);
    }

    private void e() {
        if (this.f33851i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void f(View view) {
        Collection<h> c11 = com.iab.omid.library.vungle.internal.c.e().c();
        if (c11 == null || c11.isEmpty()) {
            return;
        }
        for (h hVar : c11) {
            if (hVar != this && hVar.l() == view) {
                hVar.f33846d.clear();
            }
        }
    }

    private void h() {
        if (this.f33852j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private void i(View view) {
        this.f33846d = new we.a(view);
    }

    @Override // com.iab.omid.library.vungle.adsession.b
    public void b() {
        if (this.f33849g) {
            return;
        }
        this.f33846d.clear();
        u();
        this.f33849g = true;
        k().q();
        com.iab.omid.library.vungle.internal.c.e().d(this);
        k().l();
        this.f33847e = null;
    }

    @Override // com.iab.omid.library.vungle.adsession.b
    public void c(View view) {
        if (this.f33849g || l() == view) {
            return;
        }
        i(view);
        k().a();
        f(view);
    }

    @Override // com.iab.omid.library.vungle.adsession.b
    public void d() {
        if (this.f33848f || this.f33847e == null) {
            return;
        }
        this.f33848f = true;
        com.iab.omid.library.vungle.internal.c.e().f(this);
        this.f33847e.b(i.d().c());
        this.f33847e.i(com.iab.omid.library.vungle.internal.a.a().c());
        this.f33847e.f(this, this.f33843a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void g(List list) {
        if (n()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view = (View) ((we.a) it.next()).get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            throw null;
        }
    }

    public String j() {
        return this.f33850h;
    }

    public AdSessionStatePublisher k() {
        return this.f33847e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View l() {
        return (View) this.f33846d.get();
    }

    public List m() {
        return this.f33845c.a();
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        return this.f33848f && !this.f33849g;
    }

    public boolean p() {
        return this.f33849g;
    }

    public boolean q() {
        return this.f33844b.b();
    }

    public boolean r() {
        return this.f33848f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        e();
        k().r();
        this.f33851i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        h();
        k().t();
        this.f33852j = true;
    }

    public void u() {
        if (this.f33849g) {
            return;
        }
        this.f33845c.b();
    }
}
