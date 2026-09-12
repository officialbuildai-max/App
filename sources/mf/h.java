package mf;

import com.tencent.tinker.android.dex.j;
import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public class h extends j {

    /* renamed from: d, reason: collision with root package name */
    private v.a f69658d;

    /* renamed from: e, reason: collision with root package name */
    private j.h f69659e;

    public h(nf.a aVar, com.tencent.tinker.android.dex.j jVar, com.tencent.tinker.android.dex.j jVar2, of.c cVar) {
        super(aVar, jVar, cVar);
        this.f69658d = null;
        this.f69659e = null;
        if (jVar2 != null) {
            v.a aVar2 = jVar2.h().f40722o;
            this.f69658d = aVar2;
            this.f69659e = jVar2.m(aVar2);
        }
    }

    @Override // mf.j
    protected v.a e(com.tencent.tinker.android.dex.j jVar) {
        return jVar.h().f40722o;
    }

    @Override // mf.j
    protected void f(of.c cVar, int i11, int i12) {
        cVar.h0(i12);
    }

    @Override // mf.j
    protected void j(of.c cVar, int i11, int i12, int i13, int i14) {
        if (i12 != i14) {
            cVar.R(i12, i14);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.tencent.tinker.android.dex.h a(of.a aVar, com.tencent.tinker.android.dex.h hVar) {
        return aVar.h(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public com.tencent.tinker.android.dex.h g(ff.a aVar) {
        return aVar.r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int k(com.tencent.tinker.android.dex.h hVar) {
        this.f69658d.f40736c++;
        return this.f69659e.X(hVar);
    }
}
