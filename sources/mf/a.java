package mf;

import com.tencent.tinker.android.dex.j;
import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public class a extends j {

    /* renamed from: d, reason: collision with root package name */
    private v.a f69642d;

    /* renamed from: e, reason: collision with root package name */
    private j.h f69643e;

    public a(nf.a aVar, com.tencent.tinker.android.dex.j jVar, com.tencent.tinker.android.dex.j jVar2, of.c cVar) {
        super(aVar, jVar, cVar);
        this.f69642d = null;
        this.f69643e = null;
        if (jVar2 != null) {
            v.a aVar2 = jVar2.h().f40725r;
            this.f69642d = aVar2;
            this.f69643e = jVar2.m(aVar2);
        }
    }

    @Override // mf.j
    protected v.a e(com.tencent.tinker.android.dex.j jVar) {
        return jVar.h().f40725r;
    }

    @Override // mf.j
    protected void f(of.c cVar, int i11, int i12) {
        cVar.b0(i12);
    }

    @Override // mf.j
    protected void j(of.c cVar, int i11, int i12, int i13, int i14) {
        if (i12 != i14) {
            cVar.L(i12, i14);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.tencent.tinker.android.dex.a a(of.a aVar, com.tencent.tinker.android.dex.a aVar2) {
        return aVar.a(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public com.tencent.tinker.android.dex.a g(ff.a aVar) {
        return aVar.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int k(com.tencent.tinker.android.dex.a aVar) {
        this.f69642d.f40736c++;
        return this.f69643e.O(aVar);
    }
}
