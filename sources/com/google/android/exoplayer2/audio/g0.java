package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes3.dex */
public final class g0 implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    private int f24742b;

    /* renamed from: c, reason: collision with root package name */
    private float f24743c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f24744d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private AudioProcessor.a f24745e;

    /* renamed from: f, reason: collision with root package name */
    private AudioProcessor.a f24746f;

    /* renamed from: g, reason: collision with root package name */
    private AudioProcessor.a f24747g;

    /* renamed from: h, reason: collision with root package name */
    private AudioProcessor.a f24748h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f24749i;

    /* renamed from: j, reason: collision with root package name */
    private f0 f24750j;

    /* renamed from: k, reason: collision with root package name */
    private ByteBuffer f24751k;

    /* renamed from: l, reason: collision with root package name */
    private ShortBuffer f24752l;

    /* renamed from: m, reason: collision with root package name */
    private ByteBuffer f24753m;

    /* renamed from: n, reason: collision with root package name */
    private long f24754n;

    /* renamed from: o, reason: collision with root package name */
    private long f24755o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f24756p;

    public g0() {
        AudioProcessor.a aVar = AudioProcessor.a.f24584e;
        this.f24745e = aVar;
        this.f24746f = aVar;
        this.f24747g = aVar;
        this.f24748h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f24583a;
        this.f24751k = byteBuffer;
        this.f24752l = byteBuffer.asShortBuffer();
        this.f24753m = byteBuffer;
        this.f24742b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.a a(AudioProcessor.a aVar) {
        if (aVar.f24587c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i11 = this.f24742b;
        if (i11 == -1) {
            i11 = aVar.f24585a;
        }
        this.f24745e = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i11, aVar.f24586b, 2);
        this.f24746f = aVar2;
        this.f24749i = true;
        return aVar2;
    }

    public long b(long j11) {
        if (this.f24755o < 1024) {
            return (long) (this.f24743c * j11);
        }
        long l11 = this.f24754n - ((f0) com.google.android.exoplayer2.util.a.e(this.f24750j)).l();
        int i11 = this.f24748h.f24585a;
        int i12 = this.f24747g.f24585a;
        return i11 == i12 ? p0.N0(j11, l11, this.f24755o) : p0.N0(j11, l11 * i11, this.f24755o * i12);
    }

    public void c(float f11) {
        if (this.f24744d != f11) {
            this.f24744d = f11;
            this.f24749i = true;
        }
    }

    public void d(float f11) {
        if (this.f24743c != f11) {
            this.f24743c = f11;
            this.f24749i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f24745e;
            this.f24747g = aVar;
            AudioProcessor.a aVar2 = this.f24746f;
            this.f24748h = aVar2;
            if (this.f24749i) {
                this.f24750j = new f0(aVar.f24585a, aVar.f24586b, this.f24743c, this.f24744d, aVar2.f24585a);
            } else {
                f0 f0Var = this.f24750j;
                if (f0Var != null) {
                    f0Var.i();
                }
            }
        }
        this.f24753m = AudioProcessor.f24583a;
        this.f24754n = 0L;
        this.f24755o = 0L;
        this.f24756p = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int k11;
        f0 f0Var = this.f24750j;
        if (f0Var != null && (k11 = f0Var.k()) > 0) {
            if (this.f24751k.capacity() < k11) {
                ByteBuffer order = ByteBuffer.allocateDirect(k11).order(ByteOrder.nativeOrder());
                this.f24751k = order;
                this.f24752l = order.asShortBuffer();
            } else {
                this.f24751k.clear();
                this.f24752l.clear();
            }
            f0Var.j(this.f24752l);
            this.f24755o += k11;
            this.f24751k.limit(k11);
            this.f24753m = this.f24751k;
        }
        ByteBuffer byteBuffer = this.f24753m;
        this.f24753m = AudioProcessor.f24583a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f24746f.f24585a != -1 && (Math.abs(this.f24743c - 1.0f) >= 1.0E-4f || Math.abs(this.f24744d - 1.0f) >= 1.0E-4f || this.f24746f.f24585a != this.f24745e.f24585a);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        f0 f0Var;
        return this.f24756p && ((f0Var = this.f24750j) == null || f0Var.k() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        f0 f0Var = this.f24750j;
        if (f0Var != null) {
            f0Var.s();
        }
        this.f24756p = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            f0 f0Var = (f0) com.google.android.exoplayer2.util.a.e(this.f24750j);
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f24754n += remaining;
            f0Var.t(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.f24743c = 1.0f;
        this.f24744d = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.f24584e;
        this.f24745e = aVar;
        this.f24746f = aVar;
        this.f24747g = aVar;
        this.f24748h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f24583a;
        this.f24751k = byteBuffer;
        this.f24752l = byteBuffer.asShortBuffer();
        this.f24753m = byteBuffer;
        this.f24742b = -1;
        this.f24749i = false;
        this.f24750j = null;
        this.f24754n = 0L;
        this.f24755o = 0L;
        this.f24756p = false;
    }
}
