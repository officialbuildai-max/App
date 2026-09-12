package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.p0;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class e0 extends v {

    /* renamed from: i, reason: collision with root package name */
    private final long f24702i;

    /* renamed from: j, reason: collision with root package name */
    private final long f24703j;

    /* renamed from: k, reason: collision with root package name */
    private final short f24704k;

    /* renamed from: l, reason: collision with root package name */
    private int f24705l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f24706m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f24707n;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f24708o;

    /* renamed from: p, reason: collision with root package name */
    private int f24709p;

    /* renamed from: q, reason: collision with root package name */
    private int f24710q;

    /* renamed from: r, reason: collision with root package name */
    private int f24711r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f24712s;

    /* renamed from: t, reason: collision with root package name */
    private long f24713t;

    public e0() {
        this(150000L, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, (short) 1024);
    }

    public e0(long j11, long j12, short s11) {
        com.google.android.exoplayer2.util.a.a(j12 <= j11);
        this.f24702i = j11;
        this.f24703j = j12;
        this.f24704k = s11;
        byte[] bArr = p0.f27685f;
        this.f24707n = bArr;
        this.f24708o = bArr;
    }

    private int h(long j11) {
        return (int) ((j11 * this.f24830b.f24585a) / 1000000);
    }

    private int i(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        do {
            limit -= 2;
            if (limit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(limit)) <= this.f24704k);
        int i11 = this.f24705l;
        return ((limit / i11) * i11) + i11;
    }

    private int j(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.getShort(position)) > this.f24704k) {
                int i11 = this.f24705l;
                return i11 * (position / i11);
            }
        }
        return byteBuffer.limit();
    }

    private void l(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        g(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.f24712s = true;
        }
    }

    private void m(byte[] bArr, int i11) {
        g(i11).put(bArr, 0, i11).flip();
        if (i11 > 0) {
            this.f24712s = true;
        }
    }

    private void n(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int j11 = j(byteBuffer);
        int position = j11 - byteBuffer.position();
        byte[] bArr = this.f24707n;
        int length = bArr.length;
        int i11 = this.f24710q;
        int i12 = length - i11;
        if (j11 < limit && position < i12) {
            m(bArr, i11);
            this.f24710q = 0;
            this.f24709p = 0;
            return;
        }
        int min = Math.min(position, i12);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.f24707n, this.f24710q, min);
        int i13 = this.f24710q + min;
        this.f24710q = i13;
        byte[] bArr2 = this.f24707n;
        if (i13 == bArr2.length) {
            if (this.f24712s) {
                m(bArr2, this.f24711r);
                this.f24713t += (this.f24710q - (this.f24711r * 2)) / this.f24705l;
            } else {
                this.f24713t += (i13 - this.f24711r) / this.f24705l;
            }
            r(byteBuffer, this.f24707n, this.f24710q);
            this.f24710q = 0;
            this.f24709p = 2;
        }
        byteBuffer.limit(limit);
    }

    private void o(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f24707n.length));
        int i11 = i(byteBuffer);
        if (i11 == byteBuffer.position()) {
            this.f24709p = 1;
        } else {
            byteBuffer.limit(i11);
            l(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void p(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int j11 = j(byteBuffer);
        byteBuffer.limit(j11);
        this.f24713t += byteBuffer.remaining() / this.f24705l;
        r(byteBuffer, this.f24708o, this.f24711r);
        if (j11 < limit) {
            m(this.f24708o, this.f24711r);
            this.f24709p = 0;
            byteBuffer.limit(limit);
        }
    }

    private void r(ByteBuffer byteBuffer, byte[] bArr, int i11) {
        int min = Math.min(byteBuffer.remaining(), this.f24711r);
        int i12 = this.f24711r - min;
        System.arraycopy(bArr, i11 - i12, this.f24708o, 0, i12);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f24708o, i12, min);
    }

    @Override // com.google.android.exoplayer2.audio.v
    public AudioProcessor.a c(AudioProcessor.a aVar) {
        if (aVar.f24587c == 2) {
            return this.f24706m ? aVar : AudioProcessor.a.f24584e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void d() {
        if (this.f24706m) {
            this.f24705l = this.f24830b.f24588d;
            int h11 = h(this.f24702i) * this.f24705l;
            if (this.f24707n.length != h11) {
                this.f24707n = new byte[h11];
            }
            int h12 = h(this.f24703j) * this.f24705l;
            this.f24711r = h12;
            if (this.f24708o.length != h12) {
                this.f24708o = new byte[h12];
            }
        }
        this.f24709p = 0;
        this.f24713t = 0L;
        this.f24710q = 0;
        this.f24712s = false;
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void e() {
        int i11 = this.f24710q;
        if (i11 > 0) {
            m(this.f24707n, i11);
        }
        if (this.f24712s) {
            return;
        }
        this.f24713t += this.f24711r / this.f24705l;
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void f() {
        this.f24706m = false;
        this.f24711r = 0;
        byte[] bArr = p0.f27685f;
        this.f24707n = bArr;
        this.f24708o = bArr;
    }

    @Override // com.google.android.exoplayer2.audio.v, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f24706m;
    }

    public long k() {
        return this.f24713t;
    }

    public void q(boolean z10) {
        this.f24706m = z10;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !b()) {
            int i11 = this.f24709p;
            if (i11 == 0) {
                o(byteBuffer);
            } else if (i11 == 1) {
                n(byteBuffer);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException();
                }
                p(byteBuffer);
            }
        }
    }
}
