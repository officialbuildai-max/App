package com.bykv.vk.openvk.Sj.Sj.sP.EjP;

import com.bykv.vk.openvk.Sj.Sj.sP.EjP.b;

/* loaded from: classes2.dex */
public abstract class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private b.InterfaceC0196b f20244a;

    /* renamed from: b, reason: collision with root package name */
    private b.f f20245b;

    /* renamed from: c, reason: collision with root package name */
    private b.d f20246c;

    /* renamed from: d, reason: collision with root package name */
    private b.g f20247d;

    /* renamed from: e, reason: collision with root package name */
    private b.c f20248e;

    /* renamed from: f, reason: collision with root package name */
    private b.e f20249f;

    /* renamed from: g, reason: collision with root package name */
    private b.a f20250g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f20251h = false;

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public void Sj(boolean z10) {
        this.f20251h = z10;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void a(b.g gVar) {
        this.f20247d = gVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void b(b.d dVar) {
        this.f20246c = dVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void c(b.a aVar) {
        this.f20250g = aVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void e(b.f fVar) {
        this.f20245b = fVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void f(b.e eVar) {
        this.f20249f = eVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void i(b.c cVar) {
        this.f20248e = cVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void j(b.InterfaceC0196b interfaceC0196b) {
        this.f20244a = interfaceC0196b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k() {
        try {
            b.g gVar = this.f20247d;
            if (gVar != null) {
                gVar.TKC(this);
            }
        } catch (Throwable unused) {
        }
    }

    public void l() {
        this.f20244a = null;
        this.f20246c = null;
        this.f20245b = null;
        this.f20247d = null;
        this.f20248e = null;
        this.f20249f = null;
        this.f20250g = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(int i11) {
        try {
            b.d dVar = this.f20246c;
            if (dVar != null) {
                dVar.Sj(this, i11);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(int i11, int i12, int i13, int i14) {
        try {
            b.c cVar = this.f20248e;
            if (cVar != null) {
                cVar.Sj(this, i11, i12, i13, i14);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean o(int i11, int i12) {
        try {
            b.e eVar = this.f20249f;
            if (eVar != null) {
                if (eVar.Sj(this, i11, i12)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p() {
        try {
            b.f fVar = this.f20245b;
            if (fVar != null) {
                fVar.Sj(this);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        try {
            b.InterfaceC0196b interfaceC0196b = this.f20244a;
            if (interfaceC0196b != null) {
                interfaceC0196b.sP(this);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean r(int i11, int i12) {
        try {
            b.a aVar = this.f20250g;
            if (aVar != null) {
                if (aVar.sP(this, i11, i12)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
