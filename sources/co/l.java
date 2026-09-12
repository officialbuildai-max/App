package co;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes5.dex */
public final class l implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    private int f17706b;

    /* renamed from: c, reason: collision with root package name */
    private float f17707c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f17708d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f17709e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    private AudioProcessor.a f17710f;

    /* renamed from: g, reason: collision with root package name */
    private AudioProcessor.a f17711g;

    /* renamed from: h, reason: collision with root package name */
    private AudioProcessor.a f17712h;

    /* renamed from: i, reason: collision with root package name */
    private AudioProcessor.a f17713i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f17714j;

    /* renamed from: k, reason: collision with root package name */
    private k f17715k;

    /* renamed from: l, reason: collision with root package name */
    private ByteBuffer f17716l;

    /* renamed from: m, reason: collision with root package name */
    private ShortBuffer f17717m;

    /* renamed from: n, reason: collision with root package name */
    private ByteBuffer f17718n;

    /* renamed from: o, reason: collision with root package name */
    private long f17719o;

    /* renamed from: p, reason: collision with root package name */
    private long f17720p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f17721q;

    public l() {
        AudioProcessor.a aVar = AudioProcessor.a.f9898e;
        this.f17710f = aVar;
        this.f17711g = aVar;
        this.f17712h = aVar;
        this.f17713i = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f9897a;
        this.f17716l = byteBuffer;
        this.f17717m = byteBuffer.asShortBuffer();
        this.f17718n = byteBuffer;
        this.f17706b = -1;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public AudioProcessor.a a(AudioProcessor.a aVar) {
        if (aVar.f9901c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i11 = this.f17706b;
        if (i11 == -1) {
            i11 = aVar.f9899a;
        }
        this.f17710f = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i11, aVar.f9900b, 2);
        this.f17711g = aVar2;
        this.f17714j = true;
        return aVar2;
    }

    public float b(float f11) {
        if (this.f17709e != f11) {
            this.f17709e = f11;
            this.f17714j = true;
            k kVar = this.f17715k;
            if (kVar != null) {
                kVar.w(f11);
            }
        }
        return f11;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f17710f;
            this.f17712h = aVar;
            AudioProcessor.a aVar2 = this.f17711g;
            this.f17713i = aVar2;
            if (this.f17714j) {
                this.f17715k = new k(aVar.f9899a, aVar.f9900b, this.f17707c, this.f17708d, this.f17709e, aVar2.f9899a);
            } else {
                k kVar = this.f17715k;
                if (kVar != null) {
                    kVar.i();
                }
            }
        }
        this.f17718n = AudioProcessor.f9897a;
        this.f17719o = 0L;
        this.f17720p = 0L;
        this.f17721q = false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f17718n;
        this.f17718n = AudioProcessor.f9897a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return this.f17711g.f9899a != -1 && (Math.abs(this.f17707c - 1.0f) >= 0.01f || Math.abs(this.f17708d - 1.0f) >= 0.01f || Math.abs(this.f17709e) >= 0.01f || this.f17711g.f9899a != this.f17710f.f9899a);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isEnded() {
        k kVar;
        return this.f17721q && ((kVar = this.f17715k) == null || kVar.k() == 0);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueEndOfStream() {
        k kVar = this.f17715k;
        if (kVar != null) {
            kVar.r();
        }
        this.f17721q = true;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        k kVar = (k) androidx.media3.common.util.a.e(this.f17715k);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f17719o += remaining;
            kVar.s(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int k11 = kVar.k();
        if (k11 > 0) {
            if (this.f17716l.capacity() < k11) {
                ByteBuffer order = ByteBuffer.allocateDirect(k11).order(ByteOrder.nativeOrder());
                this.f17716l = order;
                this.f17717m = order.asShortBuffer();
            } else {
                this.f17716l.clear();
                this.f17717m.clear();
            }
            kVar.j(this.f17717m);
            this.f17720p += k11;
            this.f17716l.limit(k11);
            this.f17718n = this.f17716l;
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void reset() {
        this.f17707c = 1.0f;
        this.f17708d = 1.0f;
        this.f17709e = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.f9898e;
        this.f17710f = aVar;
        this.f17711g = aVar;
        this.f17712h = aVar;
        this.f17713i = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f9897a;
        this.f17716l = byteBuffer;
        this.f17717m = byteBuffer.asShortBuffer();
        this.f17718n = byteBuffer;
        this.f17706b = -1;
        this.f17714j = false;
        this.f17715k = null;
        this.f17719o = 0L;
        this.f17720p = 0L;
        this.f17721q = false;
    }
}
