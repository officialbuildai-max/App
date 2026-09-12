package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.p0;
import g9.e0;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f26761a;

    /* renamed from: b, reason: collision with root package name */
    private final int f26762b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f26763c;

    /* renamed from: d, reason: collision with root package name */
    private a f26764d;

    /* renamed from: e, reason: collision with root package name */
    private a f26765e;

    /* renamed from: f, reason: collision with root package name */
    private a f26766f;

    /* renamed from: g, reason: collision with root package name */
    private long f26767g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public long f26768a;

        /* renamed from: b, reason: collision with root package name */
        public long f26769b;

        /* renamed from: c, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.a f26770c;

        /* renamed from: d, reason: collision with root package name */
        public a f26771d;

        public a(long j11, int i11) {
            d(j11, i11);
        }

        @Override // com.google.android.exoplayer2.upstream.b.a
        public com.google.android.exoplayer2.upstream.a a() {
            return (com.google.android.exoplayer2.upstream.a) com.google.android.exoplayer2.util.a.e(this.f26770c);
        }

        public a b() {
            this.f26770c = null;
            a aVar = this.f26771d;
            this.f26771d = null;
            return aVar;
        }

        public void c(com.google.android.exoplayer2.upstream.a aVar, a aVar2) {
            this.f26770c = aVar;
            this.f26771d = aVar2;
        }

        public void d(long j11, int i11) {
            com.google.android.exoplayer2.util.a.g(this.f26770c == null);
            this.f26768a = j11;
            this.f26769b = j11 + i11;
        }

        public int e(long j11) {
            return ((int) (j11 - this.f26768a)) + this.f26770c.f27324b;
        }

        @Override // com.google.android.exoplayer2.upstream.b.a
        public b.a next() {
            a aVar = this.f26771d;
            if (aVar == null || aVar.f26770c == null) {
                return null;
            }
            return aVar;
        }
    }

    public y(com.google.android.exoplayer2.upstream.b bVar) {
        this.f26761a = bVar;
        int individualAllocationLength = bVar.getIndividualAllocationLength();
        this.f26762b = individualAllocationLength;
        this.f26763c = new com.google.android.exoplayer2.util.d0(32);
        a aVar = new a(0L, individualAllocationLength);
        this.f26764d = aVar;
        this.f26765e = aVar;
        this.f26766f = aVar;
    }

    private void a(a aVar) {
        if (aVar.f26770c == null) {
            return;
        }
        this.f26761a.a(aVar);
        aVar.b();
    }

    private static a d(a aVar, long j11) {
        while (j11 >= aVar.f26769b) {
            aVar = aVar.f26771d;
        }
        return aVar;
    }

    private void g(int i11) {
        long j11 = this.f26767g + i11;
        this.f26767g = j11;
        a aVar = this.f26766f;
        if (j11 == aVar.f26769b) {
            this.f26766f = aVar.f26771d;
        }
    }

    private int h(int i11) {
        a aVar = this.f26766f;
        if (aVar.f26770c == null) {
            aVar.c(this.f26761a.allocate(), new a(this.f26766f.f26769b, this.f26762b));
        }
        return Math.min(i11, (int) (this.f26766f.f26769b - this.f26767g));
    }

    private static a i(a aVar, long j11, ByteBuffer byteBuffer, int i11) {
        a d11 = d(aVar, j11);
        while (i11 > 0) {
            int min = Math.min(i11, (int) (d11.f26769b - j11));
            byteBuffer.put(d11.f26770c.f27323a, d11.e(j11), min);
            i11 -= min;
            j11 += min;
            if (j11 == d11.f26769b) {
                d11 = d11.f26771d;
            }
        }
        return d11;
    }

    private static a j(a aVar, long j11, byte[] bArr, int i11) {
        a d11 = d(aVar, j11);
        int i12 = i11;
        while (i12 > 0) {
            int min = Math.min(i12, (int) (d11.f26769b - j11));
            System.arraycopy(d11.f26770c.f27323a, d11.e(j11), bArr, i11 - i12, min);
            i12 -= min;
            j11 += min;
            if (j11 == d11.f26769b) {
                d11 = d11.f26771d;
            }
        }
        return d11;
    }

    private static a k(a aVar, DecoderInputBuffer decoderInputBuffer, a0.b bVar, com.google.android.exoplayer2.util.d0 d0Var) {
        long j11 = bVar.f25766b;
        int i11 = 1;
        d0Var.L(1);
        a j12 = j(aVar, j11, d0Var.d(), 1);
        long j13 = j11 + 1;
        byte b11 = d0Var.d()[0];
        boolean z10 = (b11 & 128) != 0;
        int i12 = b11 & Byte.MAX_VALUE;
        com.google.android.exoplayer2.decoder.c cVar = decoderInputBuffer.f24896b;
        byte[] bArr = cVar.f24917a;
        if (bArr == null) {
            cVar.f24917a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a j14 = j(j12, j13, cVar.f24917a, i12);
        long j15 = j13 + i12;
        if (z10) {
            d0Var.L(2);
            j14 = j(j14, j15, d0Var.d(), 2);
            j15 += 2;
            i11 = d0Var.J();
        }
        int i13 = i11;
        int[] iArr = cVar.f24920d;
        if (iArr == null || iArr.length < i13) {
            iArr = new int[i13];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cVar.f24921e;
        if (iArr3 == null || iArr3.length < i13) {
            iArr3 = new int[i13];
        }
        int[] iArr4 = iArr3;
        if (z10) {
            int i14 = i13 * 6;
            d0Var.L(i14);
            j14 = j(j14, j15, d0Var.d(), i14);
            j15 += i14;
            d0Var.P(0);
            for (int i15 = 0; i15 < i13; i15++) {
                iArr2[i15] = d0Var.J();
                iArr4[i15] = d0Var.H();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f25765a - ((int) (j15 - bVar.f25766b));
        }
        e0.a aVar2 = (e0.a) p0.j(bVar.f25767c);
        cVar.c(i13, iArr2, iArr4, aVar2.f63514b, cVar.f24917a, aVar2.f63513a, aVar2.f63515c, aVar2.f63516d);
        long j16 = bVar.f25766b;
        int i16 = (int) (j15 - j16);
        bVar.f25766b = j16 + i16;
        bVar.f25765a -= i16;
        return j14;
    }

    private static a l(a aVar, DecoderInputBuffer decoderInputBuffer, a0.b bVar, com.google.android.exoplayer2.util.d0 d0Var) {
        if (decoderInputBuffer.o()) {
            aVar = k(aVar, decoderInputBuffer, bVar, d0Var);
        }
        if (!decoderInputBuffer.f()) {
            decoderInputBuffer.m(bVar.f25765a);
            return i(aVar, bVar.f25766b, decoderInputBuffer.f24897c, bVar.f25765a);
        }
        d0Var.L(4);
        a j11 = j(aVar, bVar.f25766b, d0Var.d(), 4);
        int H = d0Var.H();
        bVar.f25766b += 4;
        bVar.f25765a -= 4;
        decoderInputBuffer.m(H);
        a i11 = i(j11, bVar.f25766b, decoderInputBuffer.f24897c, H);
        bVar.f25766b += H;
        int i12 = bVar.f25765a - H;
        bVar.f25765a = i12;
        decoderInputBuffer.q(i12);
        return i(i11, bVar.f25766b, decoderInputBuffer.f24900f, bVar.f25765a);
    }

    public void b(long j11) {
        a aVar;
        if (j11 == -1) {
            return;
        }
        while (true) {
            aVar = this.f26764d;
            if (j11 < aVar.f26769b) {
                break;
            }
            this.f26761a.b(aVar.f26770c);
            this.f26764d = this.f26764d.b();
        }
        if (this.f26765e.f26768a < aVar.f26768a) {
            this.f26765e = aVar;
        }
    }

    public void c(long j11) {
        com.google.android.exoplayer2.util.a.a(j11 <= this.f26767g);
        this.f26767g = j11;
        if (j11 != 0) {
            a aVar = this.f26764d;
            if (j11 != aVar.f26768a) {
                while (this.f26767g > aVar.f26769b) {
                    aVar = aVar.f26771d;
                }
                a aVar2 = (a) com.google.android.exoplayer2.util.a.e(aVar.f26771d);
                a(aVar2);
                a aVar3 = new a(aVar.f26769b, this.f26762b);
                aVar.f26771d = aVar3;
                if (this.f26767g == aVar.f26769b) {
                    aVar = aVar3;
                }
                this.f26766f = aVar;
                if (this.f26765e == aVar2) {
                    this.f26765e = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.f26764d);
        a aVar4 = new a(this.f26767g, this.f26762b);
        this.f26764d = aVar4;
        this.f26765e = aVar4;
        this.f26766f = aVar4;
    }

    public long e() {
        return this.f26767g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, a0.b bVar) {
        l(this.f26765e, decoderInputBuffer, bVar, this.f26763c);
    }

    public void m(DecoderInputBuffer decoderInputBuffer, a0.b bVar) {
        this.f26765e = l(this.f26765e, decoderInputBuffer, bVar, this.f26763c);
    }

    public void n() {
        a(this.f26764d);
        this.f26764d.d(0L, this.f26762b);
        a aVar = this.f26764d;
        this.f26765e = aVar;
        this.f26766f = aVar;
        this.f26767g = 0L;
        this.f26761a.trim();
    }

    public void o() {
        this.f26765e = this.f26764d;
    }

    public int p(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z10) {
        int h11 = h(i11);
        a aVar = this.f26766f;
        int read = gVar.read(aVar.f26770c.f27323a, aVar.e(this.f26767g), h11);
        if (read != -1) {
            g(read);
            return read;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    public void q(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        while (i11 > 0) {
            int h11 = h(i11);
            a aVar = this.f26766f;
            d0Var.j(aVar.f26770c.f27323a, aVar.e(this.f26767g), h11);
            i11 -= h11;
            g(h11);
        }
    }
}
