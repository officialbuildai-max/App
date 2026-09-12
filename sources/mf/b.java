package mf;

import com.tencent.tinker.android.dex.j;
import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public class b extends j {

    /* renamed from: d, reason: collision with root package name */
    private v.a f69644d;

    /* renamed from: e, reason: collision with root package name */
    private j.h f69645e;

    public b(nf.a aVar, com.tencent.tinker.android.dex.j jVar, com.tencent.tinker.android.dex.j jVar2, of.c cVar) {
        super(aVar, jVar, cVar);
        this.f69644d = null;
        this.f69645e = null;
        if (jVar2 != null) {
            v.a aVar2 = jVar2.h().f40719l;
            this.f69644d = aVar2;
            this.f69645e = jVar2.m(aVar2);
        }
    }

    @Override // mf.j
    protected v.a e(com.tencent.tinker.android.dex.j jVar) {
        return jVar.h().f40719l;
    }

    @Override // mf.j
    protected void f(of.c cVar, int i11, int i12) {
        cVar.d0(i12);
    }

    @Override // mf.j
    protected void j(of.c cVar, int i11, int i12, int i13, int i14) {
        if (i12 != i14) {
            cVar.N(i12, i14);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.tencent.tinker.android.dex.c a(of.a aVar, com.tencent.tinker.android.dex.c cVar) {
        return aVar.c(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public com.tencent.tinker.android.dex.c g(ff.a aVar) {
        return aVar.j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int k(com.tencent.tinker.android.dex.c cVar) {
        this.f69644d.f40736c++;
        return this.f69645e.Q(cVar);
    }
}
