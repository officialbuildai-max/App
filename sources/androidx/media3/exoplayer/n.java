package androidx.media3.exoplayer;

/* loaded from: classes2.dex */
final class n implements x2 {

    /* renamed from: a, reason: collision with root package name */
    private final d4 f12349a;

    /* renamed from: b, reason: collision with root package name */
    private final a f12350b;

    /* renamed from: c, reason: collision with root package name */
    private w3 f12351c;

    /* renamed from: d, reason: collision with root package name */
    private x2 f12352d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12353e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12354f;

    /* loaded from: classes2.dex */
    public interface a {
        void onPlaybackParametersChanged(androidx.media3.common.z zVar);
    }

    public n(a aVar, androidx.media3.common.util.i iVar) {
        this.f12350b = aVar;
        this.f12349a = new d4(iVar);
    }

    private boolean e(boolean z10) {
        w3 w3Var = this.f12351c;
        return w3Var == null || w3Var.isEnded() || (z10 && this.f12351c.getState() != 2) || (!this.f12351c.isReady() && (z10 || this.f12351c.hasReadStreamToEnd()));
    }

    private void j(boolean z10) {
        if (e(z10)) {
            this.f12353e = true;
            if (this.f12354f) {
                this.f12349a.c();
                return;
            }
            return;
        }
        x2 x2Var = (x2) androidx.media3.common.util.a.e(this.f12352d);
        long positionUs = x2Var.getPositionUs();
        if (this.f12353e) {
            if (positionUs < this.f12349a.getPositionUs()) {
                this.f12349a.d();
                return;
            } else {
                this.f12353e = false;
                if (this.f12354f) {
                    this.f12349a.c();
                }
            }
        }
        this.f12349a.a(positionUs);
        androidx.media3.common.z playbackParameters = x2Var.getPlaybackParameters();
        if (playbackParameters.equals(this.f12349a.getPlaybackParameters())) {
            return;
        }
        this.f12349a.b(playbackParameters);
        this.f12350b.onPlaybackParametersChanged(playbackParameters);
    }

    public void a(w3 w3Var) {
        if (w3Var == this.f12351c) {
            this.f12352d = null;
            this.f12351c = null;
            this.f12353e = true;
        }
    }

    @Override // androidx.media3.exoplayer.x2
    public void b(androidx.media3.common.z zVar) {
        x2 x2Var = this.f12352d;
        if (x2Var != null) {
            x2Var.b(zVar);
            zVar = this.f12352d.getPlaybackParameters();
        }
        this.f12349a.b(zVar);
    }

    public void c(w3 w3Var) {
        x2 x2Var;
        x2 mediaClock = w3Var.getMediaClock();
        if (mediaClock == null || mediaClock == (x2Var = this.f12352d)) {
            return;
        }
        if (x2Var != null) {
            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.f12352d = mediaClock;
        this.f12351c = w3Var;
        mediaClock.b(this.f12349a.getPlaybackParameters());
    }

    public void d(long j11) {
        this.f12349a.a(j11);
    }

    public void f() {
        this.f12354f = true;
        this.f12349a.c();
    }

    public void g() {
        this.f12354f = false;
        this.f12349a.d();
    }

    @Override // androidx.media3.exoplayer.x2
    public androidx.media3.common.z getPlaybackParameters() {
        x2 x2Var = this.f12352d;
        return x2Var != null ? x2Var.getPlaybackParameters() : this.f12349a.getPlaybackParameters();
    }

    @Override // androidx.media3.exoplayer.x2
    public long getPositionUs() {
        return this.f12353e ? this.f12349a.getPositionUs() : ((x2) androidx.media3.common.util.a.e(this.f12352d)).getPositionUs();
    }

    public long h(boolean z10) {
        j(z10);
        return getPositionUs();
    }

    @Override // androidx.media3.exoplayer.x2
    public boolean i() {
        return this.f12353e ? this.f12349a.i() : ((x2) androidx.media3.common.util.a.e(this.f12352d)).i();
    }
}
