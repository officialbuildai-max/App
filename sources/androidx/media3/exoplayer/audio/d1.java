package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class d1 extends androidx.media3.common.audio.b {

    /* renamed from: i, reason: collision with root package name */
    private final float f11230i;

    /* renamed from: j, reason: collision with root package name */
    private final short f11231j;

    /* renamed from: k, reason: collision with root package name */
    private final int f11232k;

    /* renamed from: l, reason: collision with root package name */
    private final long f11233l;

    /* renamed from: m, reason: collision with root package name */
    private final long f11234m;

    /* renamed from: n, reason: collision with root package name */
    private int f11235n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f11236o;

    /* renamed from: p, reason: collision with root package name */
    private int f11237p;

    /* renamed from: q, reason: collision with root package name */
    private long f11238q;

    /* renamed from: r, reason: collision with root package name */
    private int f11239r;

    /* renamed from: s, reason: collision with root package name */
    private byte[] f11240s;

    /* renamed from: t, reason: collision with root package name */
    private int f11241t;

    /* renamed from: u, reason: collision with root package name */
    private int f11242u;

    /* renamed from: v, reason: collision with root package name */
    private byte[] f11243v;

    public d1() {
        this(100000L, 0.2f, 2000000L, 10, (short) 1024);
    }

    public d1(long j11, float f11, long j12, int i11, short s11) {
        boolean z10 = false;
        this.f11239r = 0;
        this.f11241t = 0;
        this.f11242u = 0;
        if (f11 >= 0.0f && f11 <= 1.0f) {
            z10 = true;
        }
        androidx.media3.common.util.a.a(z10);
        this.f11233l = j11;
        this.f11230i = f11;
        this.f11234m = j12;
        this.f11232k = i11;
        this.f11231j = s11;
        byte[] bArr = androidx.media3.common.util.a1.f10437f;
        this.f11240s = bArr;
        this.f11243v = bArr;
    }

    private static int A(byte b11, byte b12) {
        return (b11 << 8) | (b12 & 255);
    }

    private int h(float f11) {
        return i((int) f11);
    }

    private int i(int i11) {
        int i12 = this.f11235n;
        return (i11 / i12) * i12;
    }

    private int j(int i11, int i12) {
        int i13 = this.f11232k;
        return i13 + ((((100 - i13) * (i11 * 1000)) / i12) / 1000);
    }

    private int k(int i11, int i12) {
        return (((this.f11232k - 100) * ((i11 * 1000) / i12)) / 1000) + 100;
    }

    private int l(int i11) {
        int m11 = ((m(this.f11234m) - this.f11239r) * this.f11235n) - (this.f11240s.length / 2);
        androidx.media3.common.util.a.g(m11 >= 0);
        return h(Math.min((i11 * this.f11230i) + 0.5f, m11));
    }

    private int m(long j11) {
        return (int) ((j11 * this.f9909b.f9899a) / 1000000);
    }

    private int n(ByteBuffer byteBuffer) {
        for (int limit = byteBuffer.limit() - 1; limit >= byteBuffer.position(); limit -= 2) {
            if (q(byteBuffer.get(limit), byteBuffer.get(limit - 1))) {
                int i11 = this.f11235n;
                return ((limit / i11) * i11) + i11;
            }
        }
        return byteBuffer.position();
    }

    private int o(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position() + 1; position < byteBuffer.limit(); position += 2) {
            if (q(byteBuffer.get(position), byteBuffer.get(position - 1))) {
                int i11 = this.f11235n;
                return i11 * (position / i11);
            }
        }
        return byteBuffer.limit();
    }

    private boolean q(byte b11, byte b12) {
        return Math.abs(A(b11, b12)) > this.f11231j;
    }

    private void r(byte[] bArr, int i11, int i12) {
        if (i12 == 3) {
            return;
        }
        for (int i13 = 0; i13 < i11; i13 += 2) {
            x(bArr, i13, (A(bArr[i13 + 1], bArr[i13]) * (i12 == 0 ? k(i13, i11 - 1) : i12 == 2 ? j(i13, i11 - 1) : this.f11232k)) / 100);
        }
    }

    private void s(ByteBuffer byteBuffer) {
        g(byteBuffer.remaining()).put(byteBuffer).flip();
    }

    private void t(byte[] bArr, int i11, int i12) {
        androidx.media3.common.util.a.b(i11 % this.f11235n == 0, "byteOutput size is not aligned to frame size " + i11);
        r(bArr, i11, i12);
        g(i11).put(bArr, 0, i11).flip();
    }

    private void u(boolean z10) {
        int length;
        int l11;
        int i11 = this.f11242u;
        byte[] bArr = this.f11240s;
        if (i11 == bArr.length || z10) {
            if (this.f11239r == 0) {
                if (z10) {
                    v(i11, 3);
                    length = i11;
                } else {
                    androidx.media3.common.util.a.g(i11 >= bArr.length / 2);
                    length = this.f11240s.length / 2;
                    v(length, 0);
                }
                l11 = length;
            } else if (z10) {
                int length2 = i11 - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int l12 = l(length2) + (this.f11240s.length / 2);
                v(l12, 2);
                l11 = l12;
                length = length3;
            } else {
                length = i11 - (bArr.length / 2);
                l11 = l(length);
                v(l11, 1);
            }
            androidx.media3.common.util.a.h(length % this.f11235n == 0, "bytesConsumed is not aligned to frame size: %s" + length);
            androidx.media3.common.util.a.g(i11 >= l11);
            this.f11242u -= length;
            int i12 = this.f11241t + length;
            this.f11241t = i12;
            this.f11241t = i12 % this.f11240s.length;
            this.f11239r = this.f11239r + (l11 / this.f11235n);
            this.f11238q += (length - l11) / r2;
        }
    }

    private void v(int i11, int i12) {
        if (i11 == 0) {
            return;
        }
        androidx.media3.common.util.a.a(this.f11242u >= i11);
        if (i12 == 2) {
            int i13 = this.f11241t;
            int i14 = this.f11242u;
            int i15 = i13 + i14;
            byte[] bArr = this.f11240s;
            if (i15 <= bArr.length) {
                System.arraycopy(bArr, (i13 + i14) - i11, this.f11243v, 0, i11);
            } else {
                int length = i14 - (bArr.length - i13);
                if (length >= i11) {
                    System.arraycopy(bArr, length - i11, this.f11243v, 0, i11);
                } else {
                    int i16 = i11 - length;
                    System.arraycopy(bArr, bArr.length - i16, this.f11243v, 0, i16);
                    System.arraycopy(this.f11240s, 0, this.f11243v, i16, length);
                }
            }
        } else {
            int i17 = this.f11241t;
            int i18 = i17 + i11;
            byte[] bArr2 = this.f11240s;
            if (i18 <= bArr2.length) {
                System.arraycopy(bArr2, i17, this.f11243v, 0, i11);
            } else {
                int length2 = bArr2.length - i17;
                System.arraycopy(bArr2, i17, this.f11243v, 0, length2);
                System.arraycopy(this.f11240s, 0, this.f11243v, length2, i11 - length2);
            }
        }
        androidx.media3.common.util.a.b(i11 % this.f11235n == 0, "sizeToOutput is not aligned to frame size: " + i11);
        androidx.media3.common.util.a.g(this.f11241t < this.f11240s.length);
        t(this.f11243v, i11, i12);
    }

    private void w(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f11240s.length));
        int n11 = n(byteBuffer);
        if (n11 == byteBuffer.position()) {
            this.f11237p = 1;
        } else {
            byteBuffer.limit(Math.min(n11, byteBuffer.capacity()));
            s(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private static void x(byte[] bArr, int i11, int i12) {
        if (i12 >= 32767) {
            bArr[i11] = -1;
            bArr[i11 + 1] = Byte.MAX_VALUE;
        } else if (i12 <= -32768) {
            bArr[i11] = 0;
            bArr[i11 + 1] = Byte.MIN_VALUE;
        } else {
            bArr[i11] = (byte) (i12 & 255);
            bArr[i11 + 1] = (byte) (i12 >> 8);
        }
    }

    private void z(ByteBuffer byteBuffer) {
        int i11;
        int i12;
        androidx.media3.common.util.a.g(this.f11241t < this.f11240s.length);
        int limit = byteBuffer.limit();
        int o11 = o(byteBuffer);
        int position = o11 - byteBuffer.position();
        int i13 = this.f11241t;
        int i14 = this.f11242u;
        int i15 = i13 + i14;
        byte[] bArr = this.f11240s;
        if (i15 < bArr.length) {
            i11 = bArr.length - (i14 + i13);
            i12 = i13 + i14;
        } else {
            int length = i14 - (bArr.length - i13);
            i11 = i13 - length;
            i12 = length;
        }
        boolean z10 = o11 < limit;
        int min = Math.min(position, i11);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.f11240s, i12, min);
        int i16 = this.f11242u + min;
        this.f11242u = i16;
        androidx.media3.common.util.a.g(i16 <= this.f11240s.length);
        boolean z11 = z10 && position < i11;
        u(z11);
        if (z11) {
            this.f11237p = 0;
            this.f11239r = 0;
        }
        byteBuffer.limit(limit);
    }

    @Override // androidx.media3.common.audio.b
    protected AudioProcessor.a c(AudioProcessor.a aVar) {
        if (aVar.f9901c == 2) {
            return aVar.f9899a == -1 ? AudioProcessor.a.f9898e : aVar;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // androidx.media3.common.audio.b
    public void d() {
        if (isActive()) {
            this.f11235n = this.f9909b.f9900b * 2;
            int i11 = i(m(this.f11233l) / 2) * 2;
            if (this.f11240s.length != i11) {
                this.f11240s = new byte[i11];
                this.f11243v = new byte[i11];
            }
        }
        this.f11237p = 0;
        this.f11238q = 0L;
        this.f11239r = 0;
        this.f11241t = 0;
        this.f11242u = 0;
    }

    @Override // androidx.media3.common.audio.b
    public void e() {
        if (this.f11242u > 0) {
            u(true);
            this.f11239r = 0;
        }
    }

    @Override // androidx.media3.common.audio.b
    public void f() {
        this.f11236o = false;
        byte[] bArr = androidx.media3.common.util.a1.f10437f;
        this.f11240s = bArr;
        this.f11243v = bArr;
    }

    @Override // androidx.media3.common.audio.b, androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return super.isActive() && this.f11236o;
    }

    public long p() {
        return this.f11238q;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !b()) {
            int i11 = this.f11237p;
            if (i11 == 0) {
                w(byteBuffer);
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException();
                }
                z(byteBuffer);
            }
        }
    }

    public void y(boolean z10) {
        this.f11236o = z10;
    }
}
