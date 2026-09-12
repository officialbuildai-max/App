package com.google.android.exoplayer2;

/* loaded from: classes3.dex */
final class o implements com.google.android.exoplayer2.util.u {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.h0 f25532a;

    /* renamed from: b, reason: collision with root package name */
    private final a f25533b;

    /* renamed from: c, reason: collision with root package name */
    private x2 f25534c;

    /* renamed from: d, reason: collision with root package name */
    private com.google.android.exoplayer2.util.u f25535d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f25536e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f25537f;

    /* loaded from: classes3.dex */
    public interface a {
        void onPlaybackParametersChanged(n2 n2Var);
    }

    public o(a aVar, com.google.android.exoplayer2.util.e eVar) {
        this.f25533b = aVar;
        this.f25532a = new com.google.android.exoplayer2.util.h0(eVar);
    }

    private boolean e(boolean z10) {
        x2 x2Var = this.f25534c;
        return x2Var == null || x2Var.isEnded() || (!this.f25534c.isReady() && (z10 || this.f25534c.hasReadStreamToEnd()));
    }

    private void i(boolean z10) {
        if (e(z10)) {
            this.f25536e = true;
            if (this.f25537f) {
                this.f25532a.c();
                return;
            }
            return;
        }
        com.google.android.exoplayer2.util.u uVar = (com.google.android.exoplayer2.util.u) com.google.android.exoplayer2.util.a.e(this.f25535d);
        long positionUs = uVar.getPositionUs();
        if (this.f25536e) {
            if (positionUs < this.f25532a.getPositionUs()) {
                this.f25532a.d();
                return;
            } else {
                this.f25536e = false;
                if (this.f25537f) {
                    this.f25532a.c();
                }
            }
        }
        this.f25532a.a(positionUs);
        n2 playbackParameters = uVar.getPlaybackParameters();
        if (playbackParameters.equals(this.f25532a.getPlaybackParameters())) {
            return;
        }
        this.f25532a.b(playbackParameters);
        this.f25533b.onPlaybackParametersChanged(playbackParameters);
    }

    public void a(x2 x2Var) {
        if (x2Var == this.f25534c) {
            this.f25535d = null;
            this.f25534c = null;
            this.f25536e = true;
        }
    }

    @Override // com.google.android.exoplayer2.util.u
    public void b(n2 n2Var) {
        com.google.android.exoplayer2.util.u uVar = this.f25535d;
        if (uVar != null) {
            uVar.b(n2Var);
            n2Var = this.f25535d.getPlaybackParameters();
        }
        this.f25532a.b(n2Var);
    }

    public void c(x2 x2Var) {
        com.google.android.exoplayer2.util.u uVar;
        com.google.android.exoplayer2.util.u mediaClock = x2Var.getMediaClock();
        if (mediaClock == null || mediaClock == (uVar = this.f25535d)) {
            return;
        }
        if (uVar != null) {
            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.f25535d = mediaClock;
        this.f25534c = x2Var;
        mediaClock.b(this.f25532a.getPlaybackParameters());
    }

    public void d(long j11) {
        this.f25532a.a(j11);
    }

    public void f() {
        this.f25537f = true;
        this.f25532a.c();
    }

    public void g() {
        this.f25537f = false;
        this.f25532a.d();
    }

    @Override // com.google.android.exoplayer2.util.u
    public n2 getPlaybackParameters() {
        com.google.android.exoplayer2.util.u uVar = this.f25535d;
        return uVar != null ? uVar.getPlaybackParameters() : this.f25532a.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.u
    public long getPositionUs() {
        return this.f25536e ? this.f25532a.getPositionUs() : ((com.google.android.exoplayer2.util.u) com.google.android.exoplayer2.util.a.e(this.f25535d)).getPositionUs();
    }

    public long h(boolean z10) {
        i(z10);
        return getPositionUs();
    }
}
