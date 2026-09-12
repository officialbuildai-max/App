package com.transsion.transfer.androidasync;

/* loaded from: classes6.dex */
public class r implements bv.d {

    /* renamed from: a, reason: collision with root package name */
    bv.d f55669a;

    /* renamed from: b, reason: collision with root package name */
    int f55670b;

    /* renamed from: c, reason: collision with root package name */
    ByteBufferList f55671c = new ByteBufferList();

    private boolean a(p pVar) {
        if (this.f55670b > this.f55671c.C()) {
            return false;
        }
        bv.d dVar = this.f55669a;
        this.f55669a = null;
        dVar.F(pVar, this.f55671c);
        return true;
    }

    @Override // bv.d
    public void F(p pVar, ByteBufferList byteBufferList) {
        do {
            byteBufferList.g(this.f55671c, Math.min(byteBufferList.C(), this.f55670b - this.f55671c.C()));
            byteBufferList.C();
            if (!a(pVar)) {
                break;
            }
        } while (this.f55669a != null);
        byteBufferList.C();
    }

    public void b(int i11, bv.d dVar) {
        this.f55670b = i11;
        this.f55669a = dVar;
        this.f55671c.B();
    }
}
