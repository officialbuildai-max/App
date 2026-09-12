package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class l implements n, n.a {

    /* renamed from: a, reason: collision with root package name */
    public final o.b f26273a;

    /* renamed from: b, reason: collision with root package name */
    private final long f26274b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f26275c;

    /* renamed from: d, reason: collision with root package name */
    private o f26276d;

    /* renamed from: e, reason: collision with root package name */
    private n f26277e;

    /* renamed from: f, reason: collision with root package name */
    private n.a f26278f;

    /* renamed from: g, reason: collision with root package name */
    private a f26279g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f26280h;

    /* renamed from: i, reason: collision with root package name */
    private long f26281i = C.TIME_UNSET;

    /* loaded from: classes3.dex */
    public interface a {
        void a(o.b bVar);

        void b(o.b bVar, IOException iOException);
    }

    public l(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        this.f26273a = bVar;
        this.f26275c = bVar2;
        this.f26274b = j11;
    }

    private long j(long j11) {
        long j12 = this.f26281i;
        return j12 != C.TIME_UNSET ? j12 : j11;
    }

    @Override // com.google.android.exoplayer2.source.n
    public long a(long j11, c3 c3Var) {
        return ((n) p0.j(this.f26277e)).a(j11, c3Var);
    }

    @Override // com.google.android.exoplayer2.source.n
    public long b(com.google.android.exoplayer2.trackselection.h[] hVarArr, boolean[] zArr, t9.s[] sVarArr, boolean[] zArr2, long j11) {
        long j12;
        long j13 = this.f26281i;
        if (j13 == C.TIME_UNSET || j11 != this.f26274b) {
            j12 = j11;
        } else {
            this.f26281i = C.TIME_UNSET;
            j12 = j13;
        }
        return ((n) p0.j(this.f26277e)).b(hVarArr, zArr, sVarArr, zArr2, j12);
    }

    public void c(o.b bVar) {
        long j11 = j(this.f26274b);
        n d11 = ((o) com.google.android.exoplayer2.util.a.e(this.f26276d)).d(bVar, this.f26275c, j11);
        this.f26277e = d11;
        if (this.f26278f != null) {
            d11.e(this, j11);
        }
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        n nVar = this.f26277e;
        return nVar != null && nVar.continueLoading(j11);
    }

    @Override // com.google.android.exoplayer2.source.n
    public void discardBuffer(long j11, boolean z10) {
        ((n) p0.j(this.f26277e)).discardBuffer(j11, z10);
    }

    @Override // com.google.android.exoplayer2.source.n
    public void e(n.a aVar, long j11) {
        this.f26278f = aVar;
        n nVar = this.f26277e;
        if (nVar != null) {
            nVar.e(this, j(this.f26274b));
        }
    }

    public long f() {
        return this.f26281i;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        return ((n) p0.j(this.f26277e)).getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        return ((n) p0.j(this.f26277e)).getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n
    public t9.x getTrackGroups() {
        return ((n) p0.j(this.f26277e)).getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.n.a
    public void h(n nVar) {
        ((n.a) p0.j(this.f26278f)).h(this);
        a aVar = this.f26279g;
        if (aVar != null) {
            aVar.a(this.f26273a);
        }
    }

    public long i() {
        return this.f26274b;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        n nVar = this.f26277e;
        return nVar != null && nVar.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.b0.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void g(n nVar) {
        ((n.a) p0.j(this.f26278f)).g(this);
    }

    public void l(long j11) {
        this.f26281i = j11;
    }

    public void m() {
        if (this.f26277e != null) {
            ((o) com.google.android.exoplayer2.util.a.e(this.f26276d)).k(this.f26277e);
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public void maybeThrowPrepareError() {
        try {
            n nVar = this.f26277e;
            if (nVar != null) {
                nVar.maybeThrowPrepareError();
            } else {
                o oVar = this.f26276d;
                if (oVar != null) {
                    oVar.maybeThrowSourceInfoRefreshError();
                }
            }
        } catch (IOException e11) {
            a aVar = this.f26279g;
            if (aVar == null) {
                throw e11;
            }
            if (this.f26280h) {
                return;
            }
            this.f26280h = true;
            aVar.b(this.f26273a, e11);
        }
    }

    public void n(o oVar) {
        com.google.android.exoplayer2.util.a.g(this.f26276d == null);
        this.f26276d = oVar;
    }

    @Override // com.google.android.exoplayer2.source.n
    public long readDiscontinuity() {
        return ((n) p0.j(this.f26277e)).readDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
        ((n) p0.j(this.f26277e)).reevaluateBuffer(j11);
    }

    @Override // com.google.android.exoplayer2.source.n
    public long seekToUs(long j11) {
        return ((n) p0.j(this.f26277e)).seekToUs(j11);
    }
}
