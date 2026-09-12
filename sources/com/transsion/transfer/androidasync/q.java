package com.transsion.transfer.androidasync;

/* loaded from: classes6.dex */
public abstract class q implements p {

    /* renamed from: a, reason: collision with root package name */
    private boolean f55666a;

    /* renamed from: b, reason: collision with root package name */
    bv.a f55667b;

    /* renamed from: c, reason: collision with root package name */
    bv.d f55668c;

    @Override // com.transsion.transfer.androidasync.p
    public bv.d I() {
        return this.f55668c;
    }

    public final bv.a L() {
        return this.f55667b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(Exception exc) {
        if (this.f55666a) {
            return;
        }
        this.f55666a = true;
        if (L() != null) {
            L().g(exc);
        }
    }

    @Override // com.transsion.transfer.androidasync.p
    public final void s(bv.a aVar) {
        this.f55667b = aVar;
    }

    @Override // com.transsion.transfer.androidasync.p
    public void t(bv.d dVar) {
        this.f55668c = dVar;
    }

    @Override // com.transsion.transfer.androidasync.p
    public String v() {
        return null;
    }
}
