package com.iab.omid.library.mmadbridge.adsession;

import android.view.View;
import com.iab.omid.library.mmadbridge.internal.i;
import com.iab.omid.library.mmadbridge.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class h extends b {

    /* renamed from: a, reason: collision with root package name */
    private final d f33723a;

    /* renamed from: b, reason: collision with root package name */
    private final c f33724b;

    /* renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.mmadbridge.internal.f f33725c;

    /* renamed from: d, reason: collision with root package name */
    private qe.a f33726d;

    /* renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f33727e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33728f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f33729g;

    /* renamed from: h, reason: collision with root package name */
    private final String f33730h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33731i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f33732j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, d dVar) {
        this(cVar, dVar, UUID.randomUUID().toString());
    }

    h(c cVar, d dVar, String str) {
        this.f33725c = new com.iab.omid.library.mmadbridge.internal.f();
        this.f33728f = false;
        this.f33729g = false;
        this.f33724b = cVar;
        this.f33723a = dVar;
        this.f33730h = str;
        m(null);
        this.f33727e = (dVar.c() == AdSessionContextType.HTML || dVar.c() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.mmadbridge.publisher.a(str, dVar.j()) : new com.iab.omid.library.mmadbridge.publisher.b(str, dVar.f(), dVar.g());
        this.f33727e.y();
        com.iab.omid.library.mmadbridge.internal.c.e().b(this);
        this.f33727e.e(cVar);
    }

    private void h() {
        if (this.f33731i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void i(View view) {
        Collection<h> c11 = com.iab.omid.library.mmadbridge.internal.c.e().c();
        if (c11 == null || c11.isEmpty()) {
            return;
        }
        for (h hVar : c11) {
            if (hVar != this && hVar.n() == view) {
                hVar.f33726d.clear();
            }
        }
    }

    private void l() {
        if (this.f33732j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private void m(View view) {
        this.f33726d = new qe.a(view);
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (this.f33729g) {
            return;
        }
        this.f33725c.c(view, friendlyObstructionPurpose, str);
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void c() {
        if (this.f33729g) {
            return;
        }
        this.f33726d.clear();
        e();
        this.f33729g = true;
        t().u();
        com.iab.omid.library.mmadbridge.internal.c.e().d(this);
        t().o();
        this.f33727e = null;
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void d(View view) {
        if (this.f33729g) {
            return;
        }
        oe.g.d(view, "AdView is null");
        if (n() == view) {
            return;
        }
        m(view);
        t().a();
        i(view);
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void e() {
        if (this.f33729g) {
            return;
        }
        this.f33725c.f();
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void f(View view) {
        if (this.f33729g) {
            return;
        }
        this.f33725c.g(view);
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void g() {
        if (this.f33728f) {
            return;
        }
        this.f33728f = true;
        com.iab.omid.library.mmadbridge.internal.c.e().f(this);
        this.f33727e.b(i.d().c());
        this.f33727e.l(com.iab.omid.library.mmadbridge.internal.a.a().c());
        this.f33727e.f(this, this.f33723a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(List list) {
        if (p()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view = (View) ((qe.a) it.next()).get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(JSONObject jSONObject) {
        l();
        t().m(jSONObject);
        this.f33732j = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n() {
        return (View) this.f33726d.get();
    }

    public List o() {
        return this.f33725c.a();
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        return this.f33728f && !this.f33729g;
    }

    public boolean r() {
        return this.f33729g;
    }

    public String s() {
        return this.f33730h;
    }

    public AdSessionStatePublisher t() {
        return this.f33727e;
    }

    public boolean u() {
        return this.f33724b.b();
    }

    public boolean v() {
        return this.f33724b.c();
    }

    public boolean w() {
        return this.f33728f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        h();
        t().v();
        this.f33731i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        l();
        t().x();
        this.f33732j = true;
    }
}
