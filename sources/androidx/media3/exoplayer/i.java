package androidx.media3.exoplayer;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.y3;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class i implements w3, y3 {

    /* renamed from: b, reason: collision with root package name */
    private final int f12091b;

    /* renamed from: d, reason: collision with root package name */
    private z3 f12093d;

    /* renamed from: e, reason: collision with root package name */
    private int f12094e;

    /* renamed from: f, reason: collision with root package name */
    private y1.f4 f12095f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.media3.common.util.i f12096g;

    /* renamed from: h, reason: collision with root package name */
    private int f12097h;

    /* renamed from: i, reason: collision with root package name */
    private g2.u f12098i;

    /* renamed from: j, reason: collision with root package name */
    private androidx.media3.common.r[] f12099j;

    /* renamed from: k, reason: collision with root package name */
    private long f12100k;

    /* renamed from: l, reason: collision with root package name */
    private long f12101l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f12103n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f12104o;

    /* renamed from: q, reason: collision with root package name */
    private y3.a f12106q;

    /* renamed from: a, reason: collision with root package name */
    private final Object f12090a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private final s2 f12092c = new s2();

    /* renamed from: m, reason: collision with root package name */
    private long f12102m = Long.MIN_VALUE;

    /* renamed from: p, reason: collision with root package name */
    private androidx.media3.common.e0 f12105p = androidx.media3.common.e0.f10007a;

    public i(int i11) {
        this.f12091b = i11;
    }

    private void O(long j11, boolean z10) {
        this.f12103n = false;
        this.f12101l = j11;
        this.f12102m = j11;
        F(j11, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final androidx.media3.common.e0 A() {
        return this.f12105p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean B() {
        return hasReadStreamToEnd() ? this.f12103n : ((g2.u) androidx.media3.common.util.a.e(this.f12098i)).isReady();
    }

    protected abstract void C();

    protected void D(boolean z10, boolean z11) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
    }

    protected abstract void F(long j11, boolean z10);

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void H() {
        y3.a aVar;
        synchronized (this.f12090a) {
            aVar = this.f12106q;
        }
        if (aVar != null) {
            aVar.b(this);
        }
    }

    protected void I() {
    }

    protected void J() {
    }

    protected void K() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(androidx.media3.common.r[] rVarArr, long j11, long j12, r.b bVar) {
    }

    protected void M(androidx.media3.common.e0 e0Var) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int N(s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        int c11 = ((g2.u) androidx.media3.common.util.a.e(this.f12098i)).c(s2Var, decoderInputBuffer, i11);
        if (c11 == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.f12102m = Long.MIN_VALUE;
                return this.f12103n ? -4 : -3;
            }
            long j11 = decoderInputBuffer.f11002e + this.f12100k;
            decoderInputBuffer.f11002e = j11;
            this.f12102m = Math.max(this.f12102m, j11);
        } else if (c11 == -5) {
            androidx.media3.common.r rVar = (androidx.media3.common.r) androidx.media3.common.util.a.e(s2Var.f12652b);
            if (rVar.f10248t != Long.MAX_VALUE) {
                s2Var.f12652b = rVar.b().y0(rVar.f10248t + this.f12100k).N();
            }
        }
        return c11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int P(long j11) {
        return ((g2.u) androidx.media3.common.util.a.e(this.f12098i)).skipData(j11 - this.f12100k);
    }

    @Override // androidx.media3.exoplayer.w3
    public /* synthetic */ void c() {
        v3.a(this);
    }

    @Override // androidx.media3.exoplayer.w3
    public /* synthetic */ void d(float f11, float f12) {
        v3.c(this, f11, f12);
    }

    @Override // androidx.media3.exoplayer.w3
    public final void disable() {
        androidx.media3.common.util.a.g(this.f12097h == 1);
        this.f12092c.a();
        this.f12097h = 0;
        this.f12098i = null;
        this.f12099j = null;
        this.f12103n = false;
        C();
    }

    @Override // androidx.media3.exoplayer.w3
    public final long e() {
        return this.f12102m;
    }

    @Override // androidx.media3.exoplayer.y3
    public final void f() {
        synchronized (this.f12090a) {
            this.f12106q = null;
        }
    }

    @Override // androidx.media3.exoplayer.w3
    public final void g(int i11, y1.f4 f4Var, androidx.media3.common.util.i iVar) {
        this.f12094e = i11;
        this.f12095f = f4Var;
        this.f12096g = iVar;
        E();
    }

    @Override // androidx.media3.exoplayer.w3
    public final y3 getCapabilities() {
        return this;
    }

    @Override // androidx.media3.exoplayer.w3
    public x2 getMediaClock() {
        return null;
    }

    @Override // androidx.media3.exoplayer.w3
    public final int getState() {
        return this.f12097h;
    }

    @Override // androidx.media3.exoplayer.w3
    public final g2.u getStream() {
        return this.f12098i;
    }

    @Override // androidx.media3.exoplayer.w3, androidx.media3.exoplayer.y3
    public final int getTrackType() {
        return this.f12091b;
    }

    @Override // androidx.media3.exoplayer.w3
    public final void h(z3 z3Var, androidx.media3.common.r[] rVarArr, g2.u uVar, long j11, boolean z10, boolean z11, long j12, long j13, r.b bVar) {
        androidx.media3.common.util.a.g(this.f12097h == 0);
        this.f12093d = z3Var;
        this.f12097h = 1;
        D(z10, z11);
        p(rVarArr, uVar, j12, j13, bVar);
        O(j12, z10);
    }

    @Override // androidx.media3.exoplayer.t3.b
    public void handleMessage(int i11, Object obj) {
    }

    @Override // androidx.media3.exoplayer.w3
    public final boolean hasReadStreamToEnd() {
        return this.f12102m == Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.w3
    public final boolean isCurrentStreamFinal() {
        return this.f12103n;
    }

    @Override // androidx.media3.exoplayer.w3
    public /* synthetic */ long l(long j11, long j12) {
        return v3.b(this, j11, j12);
    }

    @Override // androidx.media3.exoplayer.w3
    public final void m(androidx.media3.common.e0 e0Var) {
        if (Objects.equals(this.f12105p, e0Var)) {
            return;
        }
        this.f12105p = e0Var;
        M(e0Var);
    }

    @Override // androidx.media3.exoplayer.w3
    public final void maybeThrowStreamError() {
        ((g2.u) androidx.media3.common.util.a.e(this.f12098i)).maybeThrowError();
    }

    @Override // androidx.media3.exoplayer.y3
    public final void n(y3.a aVar) {
        synchronized (this.f12090a) {
            this.f12106q = aVar;
        }
    }

    @Override // androidx.media3.exoplayer.w3
    public final void p(androidx.media3.common.r[] rVarArr, g2.u uVar, long j11, long j12, r.b bVar) {
        androidx.media3.common.util.a.g(!this.f12103n);
        this.f12098i = uVar;
        if (this.f12102m == Long.MIN_VALUE) {
            this.f12102m = j11;
        }
        this.f12099j = rVarArr;
        this.f12100k = j12;
        L(rVarArr, j11, j12, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ExoPlaybackException q(Throwable th2, androidx.media3.common.r rVar, int i11) {
        return r(th2, rVar, false, i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ExoPlaybackException r(Throwable th2, androidx.media3.common.r rVar, boolean z10, int i11) {
        int i12;
        if (rVar != null && !this.f12104o) {
            this.f12104o = true;
            try {
                i12 = x3.i(a(rVar));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.f12104o = false;
            }
            return ExoPlaybackException.createForRenderer(th2, getName(), v(), rVar, i12, z10, i11);
        }
        i12 = 4;
        return ExoPlaybackException.createForRenderer(th2, getName(), v(), rVar, i12, z10, i11);
    }

    @Override // androidx.media3.exoplayer.w3
    public final void release() {
        androidx.media3.common.util.a.g(this.f12097h == 0);
        G();
    }

    @Override // androidx.media3.exoplayer.w3
    public final void reset() {
        androidx.media3.common.util.a.g(this.f12097h == 0);
        this.f12092c.a();
        I();
    }

    @Override // androidx.media3.exoplayer.w3
    public final void resetPosition(long j11) {
        O(j11, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final androidx.media3.common.util.i s() {
        return (androidx.media3.common.util.i) androidx.media3.common.util.a.e(this.f12096g);
    }

    @Override // androidx.media3.exoplayer.w3
    public final void setCurrentStreamFinal() {
        this.f12103n = true;
    }

    @Override // androidx.media3.exoplayer.w3
    public final void start() {
        androidx.media3.common.util.a.g(this.f12097h == 1);
        this.f12097h = 2;
        J();
    }

    @Override // androidx.media3.exoplayer.w3
    public final void stop() {
        androidx.media3.common.util.a.g(this.f12097h == 2);
        this.f12097h = 1;
        K();
    }

    @Override // androidx.media3.exoplayer.y3
    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final z3 t() {
        return (z3) androidx.media3.common.util.a.e(this.f12093d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s2 u() {
        this.f12092c.a();
        return this.f12092c;
    }

    protected final int v() {
        return this.f12094e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long w() {
        return this.f12101l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final y1.f4 x() {
        return (y1.f4) androidx.media3.common.util.a.e(this.f12095f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final androidx.media3.common.r[] y() {
        return (androidx.media3.common.r[]) androidx.media3.common.util.a.e(this.f12099j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long z() {
        return this.f12100k;
    }
}
