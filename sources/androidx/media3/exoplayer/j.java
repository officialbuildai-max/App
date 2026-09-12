package androidx.media3.exoplayer;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public int f12113a;

    /* renamed from: b, reason: collision with root package name */
    public int f12114b;

    /* renamed from: c, reason: collision with root package name */
    public int f12115c;

    /* renamed from: d, reason: collision with root package name */
    public int f12116d;

    /* renamed from: e, reason: collision with root package name */
    public int f12117e;

    /* renamed from: f, reason: collision with root package name */
    public int f12118f;

    /* renamed from: g, reason: collision with root package name */
    public int f12119g;

    /* renamed from: h, reason: collision with root package name */
    public int f12120h;

    /* renamed from: i, reason: collision with root package name */
    public int f12121i;

    /* renamed from: j, reason: collision with root package name */
    public int f12122j;

    /* renamed from: k, reason: collision with root package name */
    public long f12123k;

    /* renamed from: l, reason: collision with root package name */
    public int f12124l;

    private void b(long j11, int i11) {
        this.f12123k += j11;
        this.f12124l += i11;
    }

    public void a(long j11) {
        b(j11, 1);
    }

    public synchronized void c() {
    }

    public String toString() {
        return androidx.media3.common.util.a1.G("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f12113a), Integer.valueOf(this.f12114b), Integer.valueOf(this.f12115c), Integer.valueOf(this.f12116d), Integer.valueOf(this.f12117e), Integer.valueOf(this.f12118f), Integer.valueOf(this.f12119g), Integer.valueOf(this.f12120h), Integer.valueOf(this.f12121i), Integer.valueOf(this.f12122j), Long.valueOf(this.f12123k), Integer.valueOf(this.f12124l));
    }
}
