package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.a1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes2.dex */
public final class d implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    private final boolean f9939b;

    /* renamed from: c, reason: collision with root package name */
    private int f9940c;

    /* renamed from: d, reason: collision with root package name */
    private float f9941d;

    /* renamed from: e, reason: collision with root package name */
    private float f9942e;

    /* renamed from: f, reason: collision with root package name */
    private AudioProcessor.a f9943f;

    /* renamed from: g, reason: collision with root package name */
    private AudioProcessor.a f9944g;

    /* renamed from: h, reason: collision with root package name */
    private AudioProcessor.a f9945h;

    /* renamed from: i, reason: collision with root package name */
    private AudioProcessor.a f9946i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9947j;

    /* renamed from: k, reason: collision with root package name */
    private c f9948k;

    /* renamed from: l, reason: collision with root package name */
    private ByteBuffer f9949l;

    /* renamed from: m, reason: collision with root package name */
    private ShortBuffer f9950m;

    /* renamed from: n, reason: collision with root package name */
    private ByteBuffer f9951n;

    /* renamed from: o, reason: collision with root package name */
    private long f9952o;

    /* renamed from: p, reason: collision with root package name */
    private long f9953p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f9954q;

    public d() {
        this(false);
    }

    d(boolean z10) {
        this.f9941d = 1.0f;
        this.f9942e = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.f9898e;
        this.f9943f = aVar;
        this.f9944g = aVar;
        this.f9945h = aVar;
        this.f9946i = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f9897a;
        this.f9949l = byteBuffer;
        this.f9950m = byteBuffer.asShortBuffer();
        this.f9951n = byteBuffer;
        this.f9940c = -1;
        this.f9939b = z10;
    }

    private boolean b() {
        return Math.abs(this.f9941d - 1.0f) < 1.0E-4f && Math.abs(this.f9942e - 1.0f) < 1.0E-4f && this.f9944g.f9899a == this.f9943f.f9899a;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public AudioProcessor.a a(AudioProcessor.a aVar) {
        if (aVar.f9901c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i11 = this.f9940c;
        if (i11 == -1) {
            i11 = aVar.f9899a;
        }
        this.f9943f = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i11, aVar.f9900b, 2);
        this.f9944g = aVar2;
        this.f9947j = true;
        return aVar2;
    }

    public long c(long j11) {
        if (this.f9953p < 1024) {
            return (long) (this.f9941d * j11);
        }
        long l11 = this.f9952o - ((c) androidx.media3.common.util.a.e(this.f9948k)).l();
        int i11 = this.f9946i.f9899a;
        int i12 = this.f9945h.f9899a;
        return i11 == i12 ? a1.e1(j11, l11, this.f9953p) : a1.e1(j11, l11 * i11, this.f9953p * i12);
    }

    public void d(float f11) {
        androidx.media3.common.util.a.a(f11 > 0.0f);
        if (this.f9942e != f11) {
            this.f9942e = f11;
            this.f9947j = true;
        }
    }

    public void e(float f11) {
        androidx.media3.common.util.a.a(f11 > 0.0f);
        if (this.f9941d != f11) {
            this.f9941d = f11;
            this.f9947j = true;
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f9943f;
            this.f9945h = aVar;
            AudioProcessor.a aVar2 = this.f9944g;
            this.f9946i = aVar2;
            if (this.f9947j) {
                this.f9948k = new c(aVar.f9899a, aVar.f9900b, this.f9941d, this.f9942e, aVar2.f9899a);
            } else {
                c cVar = this.f9948k;
                if (cVar != null) {
                    cVar.i();
                }
            }
        }
        this.f9951n = AudioProcessor.f9897a;
        this.f9952o = 0L;
        this.f9953p = 0L;
        this.f9954q = false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int k11;
        c cVar = this.f9948k;
        if (cVar != null && (k11 = cVar.k()) > 0) {
            if (this.f9949l.capacity() < k11) {
                ByteBuffer order = ByteBuffer.allocateDirect(k11).order(ByteOrder.nativeOrder());
                this.f9949l = order;
                this.f9950m = order.asShortBuffer();
            } else {
                this.f9949l.clear();
                this.f9950m.clear();
            }
            cVar.j(this.f9950m);
            this.f9953p += k11;
            this.f9949l.limit(k11);
            this.f9951n = this.f9949l;
        }
        ByteBuffer byteBuffer = this.f9951n;
        this.f9951n = AudioProcessor.f9897a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return this.f9944g.f9899a != -1 && (this.f9939b || !b());
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isEnded() {
        c cVar;
        return this.f9954q && ((cVar = this.f9948k) == null || cVar.k() == 0);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueEndOfStream() {
        c cVar = this.f9948k;
        if (cVar != null) {
            cVar.s();
        }
        this.f9954q = true;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            c cVar = (c) androidx.media3.common.util.a.e(this.f9948k);
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f9952o += remaining;
            cVar.t(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void reset() {
        this.f9941d = 1.0f;
        this.f9942e = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.f9898e;
        this.f9943f = aVar;
        this.f9944g = aVar;
        this.f9945h = aVar;
        this.f9946i = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f9897a;
        this.f9949l = byteBuffer;
        this.f9950m = byteBuffer.asShortBuffer();
        this.f9951n = byteBuffer;
        this.f9940c = -1;
        this.f9947j = false;
        this.f9948k = null;
        this.f9952o = 0L;
        this.f9953p = 0L;
        this.f9954q = false;
    }
}
