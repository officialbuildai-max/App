package mf;

import com.tencent.tinker.android.dex.j;
import com.tencent.tinker.android.dex.s;
import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public class n extends j {

    /* renamed from: d, reason: collision with root package name */
    private v.a f69671d;

    /* renamed from: e, reason: collision with root package name */
    private j.h f69672e;

    public n(nf.a aVar, com.tencent.tinker.android.dex.j jVar, com.tencent.tinker.android.dex.j jVar2, of.c cVar) {
        super(aVar, jVar, cVar);
        this.f69671d = null;
        this.f69672e = null;
        if (jVar2 != null) {
            v.a aVar2 = jVar2.h().f40711d;
            this.f69671d = aVar2;
            this.f69672e = jVar2.m(aVar2);
        }
    }

    @Override // mf.j
    protected v.a e(com.tencent.tinker.android.dex.j jVar) {
        return jVar.h().f40711d;
    }

    @Override // mf.j
    protected void f(of.c cVar, int i11, int i12) {
        cVar.m0(i11);
    }

    @Override // mf.j
    protected void j(of.c cVar, int i11, int i12, int i13, int i14) {
        if (i11 != i13) {
            cVar.W(i11, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public s a(of.a aVar, s sVar) {
        return aVar.n(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public s g(ff.a aVar) {
        return aVar.A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int k(s sVar) {
        this.f69671d.f40736c++;
        return this.f69672e.g0(sVar);
    }
}
