package com.google.android.exoplayer2;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

/* loaded from: classes3.dex */
public abstract class h implements x2, z2 {

    /* renamed from: a, reason: collision with root package name */
    private final int f25152a;

    /* renamed from: c, reason: collision with root package name */
    private a3 f25154c;

    /* renamed from: d, reason: collision with root package name */
    private int f25155d;

    /* renamed from: e, reason: collision with root package name */
    private e9.u1 f25156e;

    /* renamed from: f, reason: collision with root package name */
    private int f25157f;

    /* renamed from: g, reason: collision with root package name */
    private t9.s f25158g;

    /* renamed from: h, reason: collision with root package name */
    private o1[] f25159h;

    /* renamed from: i, reason: collision with root package name */
    private long f25160i;

    /* renamed from: j, reason: collision with root package name */
    private long f25161j;

    /* renamed from: l, reason: collision with root package name */
    private boolean f25163l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f25164m;

    /* renamed from: b, reason: collision with root package name */
    private final p1 f25153b = new p1();

    /* renamed from: k, reason: collision with root package name */
    private long f25162k = Long.MIN_VALUE;

    public h(int i11) {
        this.f25152a = i11;
    }

    private void x(long j11, boolean z10) {
        this.f25163l = false;
        this.f25161j = j11;
        this.f25162k = j11;
        r(j11, z10);
    }

    @Override // com.google.android.exoplayer2.x2
    public final void c(a3 a3Var, o1[] o1VarArr, t9.s sVar, long j11, boolean z10, boolean z11, long j12, long j13) {
        com.google.android.exoplayer2.util.a.g(this.f25157f == 0);
        this.f25154c = a3Var;
        this.f25157f = 1;
        q(z10, z11);
        h(o1VarArr, sVar, j12, j13);
        x(j11, z10);
    }

    @Override // com.google.android.exoplayer2.x2
    public /* synthetic */ void d(float f11, float f12) {
        w2.a(this, f11, f12);
    }

    @Override // com.google.android.exoplayer2.x2
    public final void disable() {
        com.google.android.exoplayer2.util.a.g(this.f25157f == 1);
        this.f25153b.a();
        this.f25157f = 0;
        this.f25158g = null;
        this.f25159h = null;
        this.f25163l = false;
        p();
    }

    @Override // com.google.android.exoplayer2.x2
    public final long e() {
        return this.f25162k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ExoPlaybackException f(Throwable th2, o1 o1Var, int i11) {
        return i(th2, o1Var, false, i11);
    }

    @Override // com.google.android.exoplayer2.x2
    public final void g(int i11, e9.u1 u1Var) {
        this.f25155d = i11;
        this.f25156e = u1Var;
    }

    @Override // com.google.android.exoplayer2.x2
    public final z2 getCapabilities() {
        return this;
    }

    @Override // com.google.android.exoplayer2.x2
    public com.google.android.exoplayer2.util.u getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2.x2
    public final int getState() {
        return this.f25157f;
    }

    @Override // com.google.android.exoplayer2.x2
    public final t9.s getStream() {
        return this.f25158g;
    }

    @Override // com.google.android.exoplayer2.x2, com.google.android.exoplayer2.z2
    public final int getTrackType() {
        return this.f25152a;
    }

    @Override // com.google.android.exoplayer2.x2
    public final void h(o1[] o1VarArr, t9.s sVar, long j11, long j12) {
        com.google.android.exoplayer2.util.a.g(!this.f25163l);
        this.f25158g = sVar;
        if (this.f25162k == Long.MIN_VALUE) {
            this.f25162k = j11;
        }
        this.f25159h = o1VarArr;
        this.f25160i = j12;
        v(o1VarArr, j11, j12);
    }

    @Override // com.google.android.exoplayer2.s2.b
    public void handleMessage(int i11, Object obj) {
    }

    @Override // com.google.android.exoplayer2.x2
    public final boolean hasReadStreamToEnd() {
        return this.f25162k == Long.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ExoPlaybackException i(Throwable th2, o1 o1Var, boolean z10, int i11) {
        int i12;
        if (o1Var != null && !this.f25164m) {
            this.f25164m = true;
            try {
                i12 = y2.f(a(o1Var));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.f25164m = false;
            }
            return ExoPlaybackException.createForRenderer(th2, getName(), l(), o1Var, i12, z10, i11);
        }
        i12 = 4;
        return ExoPlaybackException.createForRenderer(th2, getName(), l(), o1Var, i12, z10, i11);
    }

    @Override // com.google.android.exoplayer2.x2
    public final boolean isCurrentStreamFinal() {
        return this.f25163l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a3 j() {
        return (a3) com.google.android.exoplayer2.util.a.e(this.f25154c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final p1 k() {
        this.f25153b.a();
        return this.f25153b;
    }

    protected final int l() {
        return this.f25155d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e9.u1 m() {
        return (e9.u1) com.google.android.exoplayer2.util.a.e(this.f25156e);
    }

    @Override // com.google.android.exoplayer2.x2
    public final void maybeThrowStreamError() {
        ((t9.s) com.google.android.exoplayer2.util.a.e(this.f25158g)).maybeThrowError();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final o1[] n() {
        return (o1[]) com.google.android.exoplayer2.util.a.e(this.f25159h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean o() {
        return hasReadStreamToEnd() ? this.f25163l : ((t9.s) com.google.android.exoplayer2.util.a.e(this.f25158g)).isReady();
    }

    protected abstract void p();

    protected void q(boolean z10, boolean z11) {
    }

    protected abstract void r(long j11, boolean z10);

    @Override // com.google.android.exoplayer2.x2
    public final void reset() {
        com.google.android.exoplayer2.util.a.g(this.f25157f == 0);
        this.f25153b.a();
        s();
    }

    @Override // com.google.android.exoplayer2.x2
    public final void resetPosition(long j11) {
        x(j11, false);
    }

    protected void s() {
    }

    @Override // com.google.android.exoplayer2.x2
    public final void setCurrentStreamFinal() {
        this.f25163l = true;
    }

    @Override // com.google.android.exoplayer2.x2
    public final void start() {
        com.google.android.exoplayer2.util.a.g(this.f25157f == 1);
        this.f25157f = 2;
        t();
    }

    @Override // com.google.android.exoplayer2.x2
    public final void stop() {
        com.google.android.exoplayer2.util.a.g(this.f25157f == 2);
        this.f25157f = 1;
        u();
    }

    @Override // com.google.android.exoplayer2.z2
    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }

    protected void t() {
    }

    protected void u() {
    }

    protected abstract void v(o1[] o1VarArr, long j11, long j12);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int w(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        int c11 = ((t9.s) com.google.android.exoplayer2.util.a.e(this.f25158g)).c(p1Var, decoderInputBuffer, i11);
        if (c11 == -4) {
            if (decoderInputBuffer.h()) {
                this.f25162k = Long.MIN_VALUE;
                return this.f25163l ? -4 : -3;
            }
            long j11 = decoderInputBuffer.f24899e + this.f25160i;
            decoderInputBuffer.f24899e = j11;
            this.f25162k = Math.max(this.f25162k, j11);
        } else if (c11 == -5) {
            o1 o1Var = (o1) com.google.android.exoplayer2.util.a.e(p1Var.f25652b);
            if (o1Var.f25554p != Long.MAX_VALUE) {
                p1Var.f25652b = o1Var.b().i0(o1Var.f25554p + this.f25160i).E();
            }
        }
        return c11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int y(long j11) {
        return ((t9.s) com.google.android.exoplayer2.util.a.e(this.f25158g)).skipData(j11 - this.f25160i);
    }
}
