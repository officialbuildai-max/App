package com.google.android.exoplayer2.util;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final e f27638a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f27639b;

    public h() {
        this(e.f27621a);
    }

    public h(e eVar) {
        this.f27638a = eVar;
    }

    public synchronized void a() {
        while (!this.f27639b) {
            wait();
        }
    }

    public synchronized boolean b(long j11) {
        if (j11 <= 0) {
            return this.f27639b;
        }
        long elapsedRealtime = this.f27638a.elapsedRealtime();
        long j12 = j11 + elapsedRealtime;
        if (j12 < elapsedRealtime) {
            a();
        } else {
            while (!this.f27639b && elapsedRealtime < j12) {
                wait(j12 - elapsedRealtime);
                elapsedRealtime = this.f27638a.elapsedRealtime();
            }
        }
        return this.f27639b;
    }

    public synchronized void c() {
        boolean z10 = false;
        while (!this.f27639b) {
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
        z10 = this.f27639b;
        this.f27639b = false;
        return z10;
    }

    public synchronized boolean e() {
        return this.f27639b;
    }

    public synchronized boolean f() {
        if (this.f27639b) {
            return false;
        }
        this.f27639b = true;
        notifyAll();
        return true;
    }
}
