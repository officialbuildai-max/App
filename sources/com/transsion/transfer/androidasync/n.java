package com.transsion.transfer.androidasync;

/* loaded from: classes6.dex */
public class n implements s {

    /* renamed from: a, reason: collision with root package name */
    s f55659a;

    /* renamed from: b, reason: collision with root package name */
    boolean f55660b;

    /* renamed from: d, reason: collision with root package name */
    bv.j f55662d;

    /* renamed from: f, reason: collision with root package name */
    boolean f55664f;

    /* renamed from: c, reason: collision with root package name */
    final ByteBufferList f55661c = new ByteBufferList();

    /* renamed from: e, reason: collision with root package name */
    int f55663e = Integer.MAX_VALUE;

    public n(s sVar) {
        m(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        boolean s11;
        bv.j jVar;
        if (this.f55660b) {
            return;
        }
        synchronized (this.f55661c) {
            this.f55659a.l(this.f55661c);
            s11 = this.f55661c.s();
        }
        if (s11 && this.f55664f) {
            this.f55659a.d();
        }
        if (!s11 || (jVar = this.f55662d) == null) {
            return;
        }
        jVar.a();
    }

    @Override // com.transsion.transfer.androidasync.s
    public AsyncServer a() {
        return this.f55659a.a();
    }

    @Override // com.transsion.transfer.androidasync.s
    public void d() {
        if (a().o() != Thread.currentThread()) {
            a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.d();
                }
            });
            return;
        }
        synchronized (this.f55661c) {
            try {
                if (this.f55661c.r()) {
                    this.f55664f = true;
                } else {
                    this.f55659a.d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void g(boolean z10) {
        this.f55660b = z10;
        if (z10) {
            return;
        }
        r();
    }

    public boolean h() {
        return this.f55661c.r() || this.f55660b;
    }

    @Override // com.transsion.transfer.androidasync.s
    public bv.j i() {
        return this.f55662d;
    }

    protected void j(ByteBufferList byteBufferList) {
    }

    public int k() {
        return this.f55661c.C();
    }

    @Override // com.transsion.transfer.androidasync.s
    public void l(ByteBufferList byteBufferList) {
        if (a().o() == Thread.currentThread()) {
            j(byteBufferList);
            if (!h()) {
                this.f55659a.l(byteBufferList);
            }
            synchronized (this.f55661c) {
                byteBufferList.f(this.f55661c);
            }
            return;
        }
        synchronized (this.f55661c) {
            try {
                if (this.f55661c.C() >= this.f55663e) {
                    return;
                }
                j(byteBufferList);
                byteBufferList.f(this.f55661c);
                a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.this.r();
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void m(s sVar) {
        this.f55659a = sVar;
        sVar.o(new bv.j() { // from class: com.transsion.transfer.androidasync.k
            @Override // bv.j
            public final void a() {
                n.this.r();
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.s
    public void o(bv.j jVar) {
        this.f55662d = jVar;
    }

    @Override // com.transsion.transfer.androidasync.s
    public void p(bv.a aVar) {
        this.f55659a.p(aVar);
    }

    public void q(int i11) {
        this.f55663e = i11;
    }
}
