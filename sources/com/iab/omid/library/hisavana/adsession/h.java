package com.iab.omid.library.hisavana.adsession;

import android.view.View;
import com.iab.omid.library.hisavana.internal.i;
import com.iab.omid.library.hisavana.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes4.dex */
public class h extends b {

    /* renamed from: a, reason: collision with root package name */
    private final d f33609a;

    /* renamed from: b, reason: collision with root package name */
    private final c f33610b;

    /* renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.hisavana.internal.f f33611c;

    /* renamed from: d, reason: collision with root package name */
    private ke.a f33612d;

    /* renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f33613e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33614f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f33615g;

    /* renamed from: h, reason: collision with root package name */
    private final String f33616h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33617i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f33618j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, d dVar) {
        this(cVar, dVar, UUID.randomUUID().toString());
    }

    h(c cVar, d dVar, String str) {
        this.f33611c = new com.iab.omid.library.hisavana.internal.f();
        this.f33614f = false;
        this.f33615g = false;
        this.f33610b = cVar;
        this.f33609a = dVar;
        this.f33616h = str;
        j(null);
        this.f33613e = (dVar.b() == AdSessionContextType.HTML || dVar.b() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.hisavana.publisher.a(str, dVar.i()) : new com.iab.omid.library.hisavana.publisher.b(str, dVar.e(), dVar.f());
        this.f33613e.u();
        com.iab.omid.library.hisavana.internal.c.e().b(this);
        this.f33613e.e(cVar);
    }

    private void f() {
        if (this.f33617i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void g(View view) {
        Collection<h> c11 = com.iab.omid.library.hisavana.internal.c.e().c();
        if (c11 == null || c11.isEmpty()) {
            return;
        }
        for (h hVar : c11) {
            if (hVar != this && hVar.m() == view) {
                hVar.f33612d.clear();
            }
        }
    }

    private void i() {
        if (this.f33618j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private void j(View view) {
        this.f33612d = new ke.a(view);
    }

    @Override // com.iab.omid.library.hisavana.adsession.b
    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (this.f33615g) {
            return;
        }
        this.f33611c.c(view, friendlyObstructionPurpose, str);
    }

    @Override // com.iab.omid.library.hisavana.adsession.b
    public void c() {
        if (this.f33615g) {
            return;
        }
        this.f33612d.clear();
        v();
        this.f33615g = true;
        l().q();
        com.iab.omid.library.hisavana.internal.c.e().d(this);
        l().l();
        this.f33613e = null;
    }

    @Override // com.iab.omid.library.hisavana.adsession.b
    public void d(View view) {
        if (this.f33615g || m() == view) {
            return;
        }
        j(view);
        l().a();
        g(view);
    }

    @Override // com.iab.omid.library.hisavana.adsession.b
    public void e() {
        if (this.f33614f || this.f33613e == null) {
            return;
        }
        this.f33614f = true;
        com.iab.omid.library.hisavana.internal.c.e().f(this);
        this.f33613e.b(i.d().c());
        this.f33613e.i(com.iab.omid.library.hisavana.internal.a.a().c());
        this.f33613e.f(this, this.f33609a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h(List list) {
        if (o()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view = (View) ((ke.a) it.next()).get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            throw null;
        }
    }

    public String k() {
        return this.f33616h;
    }

    public AdSessionStatePublisher l() {
        return this.f33613e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View m() {
        return (View) this.f33612d.get();
    }

    public List n() {
        return this.f33611c.a();
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return this.f33614f && !this.f33615g;
    }

    public boolean q() {
        return this.f33615g;
    }

    public boolean r() {
        return this.f33610b.b();
    }

    public boolean s() {
        return this.f33614f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        f();
        l().r();
        this.f33617i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        i();
        l().t();
        this.f33618j = true;
    }

    public void v() {
        if (this.f33615g) {
            return;
        }
        this.f33611c.f();
    }
}
