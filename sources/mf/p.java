package mf;

import com.tencent.tinker.android.dex.j;
import com.tencent.tinker.android.dex.u;
import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public class p extends j {

    /* renamed from: d, reason: collision with root package name */
    private v.a f69675d;

    /* renamed from: e, reason: collision with root package name */
    private v.a f69676e;

    /* renamed from: f, reason: collision with root package name */
    private j.h f69677f;

    /* renamed from: g, reason: collision with root package name */
    private j.h f69678g;

    public p(nf.a aVar, com.tencent.tinker.android.dex.j jVar, com.tencent.tinker.android.dex.j jVar2, of.c cVar) {
        super(aVar, jVar, cVar);
        this.f69675d = null;
        this.f69676e = null;
        this.f69677f = null;
        this.f69678g = null;
        if (jVar2 != null) {
            this.f69675d = jVar2.h().f40723p;
            this.f69676e = jVar2.h().f40709b;
            this.f69677f = jVar2.m(this.f69675d);
            this.f69678g = jVar2.m(this.f69676e);
        }
    }

    @Override // mf.j
    protected v.a e(com.tencent.tinker.android.dex.j jVar) {
        return jVar.h().f40723p;
    }

    @Override // mf.j
    protected void f(of.c cVar, int i11, int i12) {
        cVar.o0(i11);
    }

    @Override // mf.j
    protected void j(of.c cVar, int i11, int i12, int i13, int i14) {
        if (i11 != i13) {
            cVar.Y(i11, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public u g(ff.a aVar) {
        return aVar.E();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public int k(u uVar) {
        int j02 = this.f69677f.j0(uVar);
        this.f69678g.c0(j02);
        this.f69675d.f40736c++;
        this.f69676e.f40736c++;
        return j02;
    }
}
