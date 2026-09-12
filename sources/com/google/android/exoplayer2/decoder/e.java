package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.util.p0;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public int f24929a;

    /* renamed from: b, reason: collision with root package name */
    public int f24930b;

    /* renamed from: c, reason: collision with root package name */
    public int f24931c;

    /* renamed from: d, reason: collision with root package name */
    public int f24932d;

    /* renamed from: e, reason: collision with root package name */
    public int f24933e;

    /* renamed from: f, reason: collision with root package name */
    public int f24934f;

    /* renamed from: g, reason: collision with root package name */
    public int f24935g;

    /* renamed from: h, reason: collision with root package name */
    public int f24936h;

    /* renamed from: i, reason: collision with root package name */
    public int f24937i;

    /* renamed from: j, reason: collision with root package name */
    public int f24938j;

    /* renamed from: k, reason: collision with root package name */
    public long f24939k;

    /* renamed from: l, reason: collision with root package name */
    public int f24940l;

    private void b(long j11, int i11) {
        this.f24939k += j11;
        this.f24940l += i11;
    }

    public void a(long j11) {
        b(j11, 1);
    }

    public synchronized void c() {
    }

    public String toString() {
        return p0.C("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f24929a), Integer.valueOf(this.f24930b), Integer.valueOf(this.f24931c), Integer.valueOf(this.f24932d), Integer.valueOf(this.f24933e), Integer.valueOf(this.f24934f), Integer.valueOf(this.f24935g), Integer.valueOf(this.f24936h), Integer.valueOf(this.f24937i), Integer.valueOf(this.f24938j), Long.valueOf(this.f24939k), Integer.valueOf(this.f24940l));
    }
}
