package androidx.media3.exoplayer.source;

import androidx.media3.common.util.a1;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.source.e0;
import androidx.media3.exoplayer.upstream.b;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import l2.s0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.b f12807a;

    /* renamed from: b, reason: collision with root package name */
    private final int f12808b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f12809c;

    /* renamed from: d, reason: collision with root package name */
    private a f12810d;

    /* renamed from: e, reason: collision with root package name */
    private a f12811e;

    /* renamed from: f, reason: collision with root package name */
    private a f12812f;

    /* renamed from: g, reason: collision with root package name */
    private long f12813g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public long f12814a;

        /* renamed from: b, reason: collision with root package name */
        public long f12815b;

        /* renamed from: c, reason: collision with root package name */
        public androidx.media3.exoplayer.upstream.a f12816c;

        /* renamed from: d, reason: collision with root package name */
        public a f12817d;

        public a(long j11, int i11) {
            d(j11, i11);
        }

        @Override // androidx.media3.exoplayer.upstream.b.a
        public androidx.media3.exoplayer.upstream.a a() {
            return (androidx.media3.exoplayer.upstream.a) androidx.media3.common.util.a.e(this.f12816c);
        }

        public a b() {
            this.f12816c = null;
            a aVar = this.f12817d;
            this.f12817d = null;
            return aVar;
        }

        public void c(androidx.media3.exoplayer.upstream.a aVar, a aVar2) {
            this.f12816c = aVar;
            this.f12817d = aVar2;
        }

        public void d(long j11, int i11) {
            androidx.media3.common.util.a.g(this.f12816c == null);
            this.f12814a = j11;
            this.f12815b = j11 + i11;
        }

        public int e(long j11) {
            return ((int) (j11 - this.f12814a)) + this.f12816c.f13039b;
        }

        @Override // androidx.media3.exoplayer.upstream.b.a
        public b.a next() {
            a aVar = this.f12817d;
            if (aVar == null || aVar.f12816c == null) {
                return null;
            }
            return aVar;
        }
    }

    public c0(androidx.media3.exoplayer.upstream.b bVar) {
        this.f12807a = bVar;
        int individualAllocationLength = bVar.getIndividualAllocationLength();
        this.f12808b = individualAllocationLength;
        this.f12809c = new androidx.media3.common.util.j0(32);
        a aVar = new a(0L, individualAllocationLength);
        this.f12810d = aVar;
        this.f12811e = aVar;
        this.f12812f = aVar;
    }

    private void a(a aVar) {
        if (aVar.f12816c == null) {
            return;
        }
        this.f12807a.a(aVar);
        aVar.b();
    }

    private static a d(a aVar, long j11) {
        while (j11 >= aVar.f12815b) {
            aVar = aVar.f12817d;
        }
        return aVar;
    }

    private void g(int i11) {
        long j11 = this.f12813g + i11;
        this.f12813g = j11;
        a aVar = this.f12812f;
        if (j11 == aVar.f12815b) {
            this.f12812f = aVar.f12817d;
        }
    }

    private int h(int i11) {
        a aVar = this.f12812f;
        if (aVar.f12816c == null) {
            aVar.c(this.f12807a.allocate(), new a(this.f12812f.f12815b, this.f12808b));
        }
        return Math.min(i11, (int) (this.f12812f.f12815b - this.f12813g));
    }

    private static a i(a aVar, long j11, ByteBuffer byteBuffer, int i11) {
        a d11 = d(aVar, j11);
        while (i11 > 0) {
            int min = Math.min(i11, (int) (d11.f12815b - j11));
            byteBuffer.put(d11.f12816c.f13038a, d11.e(j11), min);
            i11 -= min;
            j11 += min;
            if (j11 == d11.f12815b) {
                d11 = d11.f12817d;
            }
        }
        return d11;
    }

    private static a j(a aVar, long j11, byte[] bArr, int i11) {
        a d11 = d(aVar, j11);
        int i12 = i11;
        while (i12 > 0) {
            int min = Math.min(i12, (int) (d11.f12815b - j11));
            System.arraycopy(d11.f12816c.f13038a, d11.e(j11), bArr, i11 - i12, min);
            i12 -= min;
            j11 += min;
            if (j11 == d11.f12815b) {
                d11 = d11.f12817d;
            }
        }
        return d11;
    }

    private static a k(a aVar, DecoderInputBuffer decoderInputBuffer, e0.b bVar, androidx.media3.common.util.j0 j0Var) {
        long j11 = bVar.f12849b;
        int i11 = 1;
        j0Var.S(1);
        a j12 = j(aVar, j11, j0Var.e(), 1);
        long j13 = j11 + 1;
        byte b11 = j0Var.e()[0];
        boolean z10 = (b11 & 128) != 0;
        int i12 = b11 & Byte.MAX_VALUE;
        androidx.media3.decoder.c cVar = decoderInputBuffer.f10999b;
        byte[] bArr = cVar.f11029a;
        if (bArr == null) {
            cVar.f11029a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a j14 = j(j12, j13, cVar.f11029a, i12);
        long j15 = j13 + i12;
        if (z10) {
            j0Var.S(2);
            j14 = j(j14, j15, j0Var.e(), 2);
            j15 += 2;
            i11 = j0Var.P();
        }
        int i13 = i11;
        int[] iArr = cVar.f11032d;
        if (iArr == null || iArr.length < i13) {
            iArr = new int[i13];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cVar.f11033e;
        if (iArr3 == null || iArr3.length < i13) {
            iArr3 = new int[i13];
        }
        int[] iArr4 = iArr3;
        if (z10) {
            int i14 = i13 * 6;
            j0Var.S(i14);
            j14 = j(j14, j15, j0Var.e(), i14);
            j15 += i14;
            j0Var.W(0);
            for (int i15 = 0; i15 < i13; i15++) {
                iArr2[i15] = j0Var.P();
                iArr4[i15] = j0Var.L();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f12848a - ((int) (j15 - bVar.f12849b));
        }
        s0.a aVar2 = (s0.a) a1.i(bVar.f12850c);
        cVar.c(i13, iArr2, iArr4, aVar2.f68803b, cVar.f11029a, aVar2.f68802a, aVar2.f68804c, aVar2.f68805d);
        long j16 = bVar.f12849b;
        int i16 = (int) (j15 - j16);
        bVar.f12849b = j16 + i16;
        bVar.f12848a -= i16;
        return j14;
    }

    private static a l(a aVar, DecoderInputBuffer decoderInputBuffer, e0.b bVar, androidx.media3.common.util.j0 j0Var) {
        if (decoderInputBuffer.e()) {
            aVar = k(aVar, decoderInputBuffer, bVar, j0Var);
        }
        if (!decoderInputBuffer.hasSupplementalData()) {
            decoderInputBuffer.b(bVar.f12848a);
            return i(aVar, bVar.f12849b, decoderInputBuffer.f11000c, bVar.f12848a);
        }
        j0Var.S(4);
        a j11 = j(aVar, bVar.f12849b, j0Var.e(), 4);
        int L = j0Var.L();
        bVar.f12849b += 4;
        bVar.f12848a -= 4;
        decoderInputBuffer.b(L);
        a i11 = i(j11, bVar.f12849b, decoderInputBuffer.f11000c, L);
        bVar.f12849b += L;
        int i12 = bVar.f12848a - L;
        bVar.f12848a = i12;
        decoderInputBuffer.g(i12);
        return i(i11, bVar.f12849b, decoderInputBuffer.f11003f, bVar.f12848a);
    }

    public void b(long j11) {
        a aVar;
        if (j11 == -1) {
            return;
        }
        while (true) {
            aVar = this.f12810d;
            if (j11 < aVar.f12815b) {
                break;
            }
            this.f12807a.b(aVar.f12816c);
            this.f12810d = this.f12810d.b();
        }
        if (this.f12811e.f12814a < aVar.f12814a) {
            this.f12811e = aVar;
        }
    }

    public void c(long j11) {
        androidx.media3.common.util.a.a(j11 <= this.f12813g);
        this.f12813g = j11;
        if (j11 != 0) {
            a aVar = this.f12810d;
            if (j11 != aVar.f12814a) {
                while (this.f12813g > aVar.f12815b) {
                    aVar = aVar.f12817d;
                }
                a aVar2 = (a) androidx.media3.common.util.a.e(aVar.f12817d);
                a(aVar2);
                a aVar3 = new a(aVar.f12815b, this.f12808b);
                aVar.f12817d = aVar3;
                if (this.f12813g == aVar.f12815b) {
                    aVar = aVar3;
                }
                this.f12812f = aVar;
                if (this.f12811e == aVar2) {
                    this.f12811e = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.f12810d);
        a aVar4 = new a(this.f12813g, this.f12808b);
        this.f12810d = aVar4;
        this.f12811e = aVar4;
        this.f12812f = aVar4;
    }

    public long e() {
        return this.f12813g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, e0.b bVar) {
        l(this.f12811e, decoderInputBuffer, bVar, this.f12809c);
    }

    public void m(DecoderInputBuffer decoderInputBuffer, e0.b bVar) {
        this.f12811e = l(this.f12811e, decoderInputBuffer, bVar, this.f12809c);
    }

    public void n() {
        a(this.f12810d);
        this.f12810d.d(0L, this.f12808b);
        a aVar = this.f12810d;
        this.f12811e = aVar;
        this.f12812f = aVar;
        this.f12813g = 0L;
        this.f12807a.trim();
    }

    public void o() {
        this.f12811e = this.f12810d;
    }

    public int p(androidx.media3.common.j jVar, int i11, boolean z10) {
        int h11 = h(i11);
        a aVar = this.f12812f;
        int read = jVar.read(aVar.f12816c.f13038a, aVar.e(this.f12813g), h11);
        if (read != -1) {
            g(read);
            return read;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    public void q(androidx.media3.common.util.j0 j0Var, int i11) {
        while (i11 > 0) {
            int h11 = h(i11);
            a aVar = this.f12812f;
            j0Var.l(aVar.f12816c.f13038a, aVar.e(this.f12813g), h11);
            i11 -= h11;
            g(h11);
        }
    }
}
