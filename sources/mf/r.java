package mf;

import com.tencent.tinker.android.dex.j;
import com.tencent.tinker.android.dex.v;
import com.tencent.tinker.android.dex.w;

/* loaded from: classes5.dex */
public class r extends j {

    /* renamed from: d, reason: collision with root package name */
    private v.a f69681d;

    /* renamed from: e, reason: collision with root package name */
    private j.h f69682e;

    public r(nf.a aVar, com.tencent.tinker.android.dex.j jVar, com.tencent.tinker.android.dex.j jVar2, of.c cVar) {
        super(aVar, jVar, cVar);
        this.f69681d = null;
        this.f69682e = null;
        if (jVar2 != null) {
            v.a aVar2 = jVar2.h().f40718k;
            this.f69681d = aVar2;
            this.f69682e = jVar2.m(aVar2);
        }
    }

    @Override // mf.j
    protected v.a e(com.tencent.tinker.android.dex.j jVar) {
        return jVar.h().f40718k;
    }

    @Override // mf.j
    protected void f(of.c cVar, int i11, int i12) {
        cVar.q0(i12);
    }

    @Override // mf.j
    protected void j(of.c cVar, int i11, int i12, int i13, int i14) {
        if (i12 != i14) {
            cVar.a0(i12, i14);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public w a(of.a aVar, w wVar) {
        return aVar.o(wVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public w g(ff.a aVar) {
        return aVar.G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int k(w wVar) {
        this.f69681d.f40736c++;
        return this.f69682e.l0(wVar);
    }
}
