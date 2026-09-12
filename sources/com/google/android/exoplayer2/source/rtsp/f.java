package com.google.android.exoplayer2.source.rtsp;

import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.b0;

/* loaded from: classes3.dex */
final class f implements g9.l {

    /* renamed from: a, reason: collision with root package name */
    private final z9.e f26410a;

    /* renamed from: d, reason: collision with root package name */
    private final int f26413d;

    /* renamed from: g, reason: collision with root package name */
    private g9.n f26416g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f26417h;

    /* renamed from: k, reason: collision with root package name */
    private boolean f26420k;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f26411b = new com.google.android.exoplayer2.util.d0(65507);

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f26412c = new com.google.android.exoplayer2.util.d0();

    /* renamed from: e, reason: collision with root package name */
    private final Object f26414e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private final i f26415f = new i();

    /* renamed from: i, reason: collision with root package name */
    private volatile long f26418i = C.TIME_UNSET;

    /* renamed from: j, reason: collision with root package name */
    private volatile int f26419j = -1;

    /* renamed from: l, reason: collision with root package name */
    private long f26421l = C.TIME_UNSET;

    /* renamed from: m, reason: collision with root package name */
    private long f26422m = C.TIME_UNSET;

    public f(j jVar, int i11) {
        this.f26413d = i11;
        this.f26410a = (z9.e) com.google.android.exoplayer2.util.a.e(new z9.a().a(jVar));
    }

    private static long a(long j11) {
        return j11 - 30;
    }

    @Override // g9.l
    public void b(g9.n nVar) {
        this.f26410a.c(nVar, this.f26413d);
        nVar.endTracks();
        nVar.d(new b0.b(C.TIME_UNSET));
        this.f26416g = nVar;
    }

    @Override // g9.l
    public int c(g9.m mVar, g9.a0 a0Var) {
        com.google.android.exoplayer2.util.a.e(this.f26416g);
        int read = mVar.read(this.f26411b.d(), 0, 65507);
        if (read == -1) {
            return -1;
        }
        if (read == 0) {
            return 0;
        }
        this.f26411b.P(0);
        this.f26411b.O(read);
        g d11 = g.d(this.f26411b);
        if (d11 == null) {
            return 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long a11 = a(elapsedRealtime);
        this.f26415f.e(d11, elapsedRealtime);
        g f11 = this.f26415f.f(a11);
        if (f11 == null) {
            return 0;
        }
        if (!this.f26417h) {
            if (this.f26418i == C.TIME_UNSET) {
                this.f26418i = f11.f26434h;
            }
            if (this.f26419j == -1) {
                this.f26419j = f11.f26433g;
            }
            this.f26410a.b(this.f26418i, this.f26419j);
            this.f26417h = true;
        }
        synchronized (this.f26414e) {
            try {
                if (this.f26420k) {
                    if (this.f26421l != C.TIME_UNSET && this.f26422m != C.TIME_UNSET) {
                        this.f26415f.g();
                        this.f26410a.seek(this.f26421l, this.f26422m);
                        this.f26420k = false;
                        this.f26421l = C.TIME_UNSET;
                        this.f26422m = C.TIME_UNSET;
                    }
                }
                do {
                    this.f26412c.M(f11.f26437k);
                    this.f26410a.a(this.f26412c, f11.f26434h, f11.f26433g, f11.f26431e);
                    f11 = this.f26415f.f(a11);
                } while (f11 != null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return 0;
    }

    @Override // g9.l
    public boolean d(g9.m mVar) {
        throw new UnsupportedOperationException("RTP packets are transmitted in a packet stream do not support sniffing.");
    }

    public boolean e() {
        return this.f26417h;
    }

    public void f() {
        synchronized (this.f26414e) {
            this.f26420k = true;
        }
    }

    public void g(int i11) {
        this.f26419j = i11;
    }

    public void h(long j11) {
        this.f26418i = j11;
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        synchronized (this.f26414e) {
            this.f26421l = j11;
            this.f26422m = j12;
        }
    }
}
