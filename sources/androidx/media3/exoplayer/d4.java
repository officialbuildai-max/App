package androidx.media3.exoplayer;

/* loaded from: classes2.dex */
public final class d4 implements x2 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.common.util.i f11435a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f11436b;

    /* renamed from: c, reason: collision with root package name */
    private long f11437c;

    /* renamed from: d, reason: collision with root package name */
    private long f11438d;

    /* renamed from: e, reason: collision with root package name */
    private androidx.media3.common.z f11439e = androidx.media3.common.z.f10645d;

    public d4(androidx.media3.common.util.i iVar) {
        this.f11435a = iVar;
    }

    public void a(long j11) {
        this.f11437c = j11;
        if (this.f11436b) {
            this.f11438d = this.f11435a.elapsedRealtime();
        }
    }

    @Override // androidx.media3.exoplayer.x2
    public void b(androidx.media3.common.z zVar) {
        if (this.f11436b) {
            a(getPositionUs());
        }
        this.f11439e = zVar;
    }

    public void c() {
        if (this.f11436b) {
            return;
        }
        this.f11438d = this.f11435a.elapsedRealtime();
        this.f11436b = true;
    }

    public void d() {
        if (this.f11436b) {
            a(getPositionUs());
            this.f11436b = false;
        }
    }

    @Override // androidx.media3.exoplayer.x2
    public androidx.media3.common.z getPlaybackParameters() {
        return this.f11439e;
    }

    @Override // androidx.media3.exoplayer.x2
    public long getPositionUs() {
        long j11 = this.f11437c;
        if (!this.f11436b) {
            return j11;
        }
        long elapsedRealtime = this.f11435a.elapsedRealtime() - this.f11438d;
        androidx.media3.common.z zVar = this.f11439e;
        return j11 + (zVar.f10648a == 1.0f ? androidx.media3.common.util.a1.R0(elapsedRealtime) : zVar.a(elapsedRealtime));
    }

    @Override // androidx.media3.exoplayer.x2
    public /* synthetic */ boolean i() {
        return w2.a(this);
    }
}
