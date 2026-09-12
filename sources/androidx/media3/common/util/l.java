package androidx.media3.common.util;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final i f10487a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10488b;

    public l() {
        this(i.f10469a);
    }

    public l(i iVar) {
        this.f10487a = iVar;
    }

    public synchronized void a() {
        while (!this.f10488b) {
            wait();
        }
    }

    public synchronized boolean b(long j11) {
        if (j11 <= 0) {
            return this.f10488b;
        }
        long elapsedRealtime = this.f10487a.elapsedRealtime();
        long j12 = j11 + elapsedRealtime;
        if (j12 < elapsedRealtime) {
            a();
        } else {
            while (!this.f10488b && elapsedRealtime < j12) {
                wait(j12 - elapsedRealtime);
                elapsedRealtime = this.f10487a.elapsedRealtime();
            }
        }
        return this.f10488b;
    }

    public synchronized void c() {
        boolean z10 = false;
        while (!this.f10488b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z10 = true;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean d() {
        boolean z10;
        z10 = this.f10488b;
        this.f10488b = false;
        return z10;
    }

    public synchronized boolean e() {
        return this.f10488b;
    }

    public synchronized boolean f() {
        if (this.f10488b) {
            return false;
        }
        this.f10488b = true;
        notifyAll();
        return true;
    }
}
