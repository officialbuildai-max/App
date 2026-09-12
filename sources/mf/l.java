package mf;

import com.tencent.tinker.android.dex.MethodHandle;
import com.tencent.tinker.android.dex.j;
import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public class l extends j {

    /* renamed from: d, reason: collision with root package name */
    private v.a f69667d;

    /* renamed from: e, reason: collision with root package name */
    private j.h f69668e;

    public l(nf.a aVar, com.tencent.tinker.android.dex.j jVar, com.tencent.tinker.android.dex.j jVar2, of.c cVar) {
        super(aVar, jVar, cVar);
        this.f69667d = null;
        this.f69668e = null;
        v.a aVar2 = jVar2.h().f40716i;
        this.f69667d = aVar2;
        this.f69668e = jVar2.m(aVar2);
    }

    @Override // mf.j
    protected v.a e(com.tencent.tinker.android.dex.j jVar) {
        return jVar.h().f40716i;
    }

    @Override // mf.j
    protected void f(of.c cVar, int i11, int i12) {
        cVar.k0(i11);
    }

    @Override // mf.j
    protected void j(of.c cVar, int i11, int i12, int i13, int i14) {
        if (i11 != i13) {
            cVar.U(i11, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public MethodHandle a(of.a aVar, MethodHandle methodHandle) {
        return aVar.l(methodHandle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public MethodHandle g(ff.a aVar) {
        return aVar.x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int k(MethodHandle methodHandle) {
        this.f69667d.f40736c++;
        return this.f69668e.d0(methodHandle);
    }
}
