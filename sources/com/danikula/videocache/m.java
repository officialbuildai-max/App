package com.danikula.videocache;

/* loaded from: classes3.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private final a f24109a;

    /* renamed from: e, reason: collision with root package name */
    protected volatile boolean f24113e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f24114f;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f24116h;

    /* renamed from: b, reason: collision with root package name */
    private final Object f24110b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private final Object f24111c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private volatile int f24112d = -1;

    /* renamed from: g, reason: collision with root package name */
    private volatile long f24115g = -1;

    public m(a aVar) {
        this.f24109a = (a) l.c(aVar);
        aVar.F(this);
    }

    private void h() {
        synchronized (this.f24110b) {
            try {
                this.f24114f = true;
                this.f24110b.wait(1000L);
                this.f24114f = false;
            } finally {
            }
        }
    }

    public void a(long j11) {
        this.f24109a.E(j11);
        this.f24109a.C(j11);
    }

    public boolean b() {
        return this.f24114f;
    }

    public void c() {
        synchronized (this.f24110b) {
            q.c("-------get new data, notify wait~");
            this.f24114f = false;
            this.f24110b.notifyAll();
        }
    }

    public int d(byte[] bArr, long j11, int i11, String str) {
        n.a(bArr, j11, i11);
        while (!this.f24109a.isCompleted() && !this.f24109a.H(j11, i11, str) && !this.f24113e) {
            this.f24116h = true;
            h();
        }
        if (this.f24116h) {
            q.e("isWaited， isAvailable = " + this.f24109a.H(j11, i11, str) + " ,offset = " + j11);
        }
        this.f24116h = false;
        int D = this.f24109a.D(bArr, j11, i11, str);
        if (D > 0) {
            com.transsnet.downloader.util.i.f60062a.b("4");
        }
        if (this.f24115g < 0 || (j11 - this.f24115g > 512000 && D > 0)) {
            this.f24115g = j11;
            q.f("ProxyCache read， isCompleted = " + this.f24109a.isCompleted() + " ,offset = " + j11);
        }
        return D;
    }

    public void e() {
        synchronized (this.f24111c) {
            q.a("Shutdown proxy");
            try {
                this.f24113e = true;
                this.f24109a.close();
            } catch (Throwable th2) {
                q.a("Shutdown proxy, error = " + th2);
            }
        }
    }

    public void f() {
        q.e("----start");
        this.f24113e = false;
    }

    public void g() {
        q.e("--stop");
        this.f24113e = true;
        c();
    }
}
