package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.n2;

/* loaded from: classes3.dex */
public final class h0 implements u {

    /* renamed from: a, reason: collision with root package name */
    private final e f27640a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f27641b;

    /* renamed from: c, reason: collision with root package name */
    private long f27642c;

    /* renamed from: d, reason: collision with root package name */
    private long f27643d;

    /* renamed from: e, reason: collision with root package name */
    private n2 f27644e = n2.f25527d;

    public h0(e eVar) {
        this.f27640a = eVar;
    }

    public void a(long j11) {
        this.f27642c = j11;
        if (this.f27641b) {
            this.f27643d = this.f27640a.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.u
    public void b(n2 n2Var) {
        if (this.f27641b) {
            a(getPositionUs());
        }
        this.f27644e = n2Var;
    }

    public void c() {
        if (this.f27641b) {
            return;
        }
        this.f27643d = this.f27640a.elapsedRealtime();
        this.f27641b = true;
    }

    public void d() {
        if (this.f27641b) {
            a(getPositionUs());
            this.f27641b = false;
        }
    }

    @Override // com.google.android.exoplayer2.util.u
    public n2 getPlaybackParameters() {
        return this.f27644e;
    }

    @Override // com.google.android.exoplayer2.util.u
    public long getPositionUs() {
        long j11 = this.f27642c;
        if (!this.f27641b) {
            return j11;
        }
        long elapsedRealtime = this.f27640a.elapsedRealtime() - this.f27643d;
        n2 n2Var = this.f27644e;
        return j11 + (n2Var.f25529a == 1.0f ? p0.B0(elapsedRealtime) : n2Var.b(elapsedRealtime));
    }
}
