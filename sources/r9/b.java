package r9;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.i0;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import g9.a0;
import g9.e0;
import g9.l;
import g9.m;
import g9.n;
import g9.q;
import g9.r;
import java.util.Map;

/* loaded from: classes4.dex */
public final class b implements l {

    /* renamed from: h, reason: collision with root package name */
    public static final r f74309h = new r() { // from class: r9.a
        @Override // g9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // g9.r
        public final l[] createExtractors() {
            l[] f11;
            f11 = b.f();
            return f11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private n f74310a;

    /* renamed from: b, reason: collision with root package name */
    private e0 f74311b;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC0931b f74314e;

    /* renamed from: c, reason: collision with root package name */
    private int f74312c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f74313d = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f74315f = -1;

    /* renamed from: g, reason: collision with root package name */
    private long f74316g = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements InterfaceC0931b {

        /* renamed from: m, reason: collision with root package name */
        private static final int[] f74317m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: n, reason: collision with root package name */
        private static final int[] f74318n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 130, 143, 157, 173, 190, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 230, 253, 279, 307, 337, 371, TTAdConstant.DOWNLOAD_URL_CODE, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: a, reason: collision with root package name */
        private final n f74319a;

        /* renamed from: b, reason: collision with root package name */
        private final e0 f74320b;

        /* renamed from: c, reason: collision with root package name */
        private final r9.c f74321c;

        /* renamed from: d, reason: collision with root package name */
        private final int f74322d;

        /* renamed from: e, reason: collision with root package name */
        private final byte[] f74323e;

        /* renamed from: f, reason: collision with root package name */
        private final d0 f74324f;

        /* renamed from: g, reason: collision with root package name */
        private final int f74325g;

        /* renamed from: h, reason: collision with root package name */
        private final o1 f74326h;

        /* renamed from: i, reason: collision with root package name */
        private int f74327i;

        /* renamed from: j, reason: collision with root package name */
        private long f74328j;

        /* renamed from: k, reason: collision with root package name */
        private int f74329k;

        /* renamed from: l, reason: collision with root package name */
        private long f74330l;

        public a(n nVar, e0 e0Var, r9.c cVar) {
            this.f74319a = nVar;
            this.f74320b = e0Var;
            this.f74321c = cVar;
            int max = Math.max(1, cVar.f74341c / 10);
            this.f74325g = max;
            d0 d0Var = new d0(cVar.f74345g);
            d0Var.v();
            int v11 = d0Var.v();
            this.f74322d = v11;
            int i11 = cVar.f74340b;
            int i12 = (((cVar.f74343e - (i11 * 4)) * 8) / (cVar.f74344f * i11)) + 1;
            if (v11 == i12) {
                int l11 = p0.l(max, v11);
                this.f74323e = new byte[cVar.f74343e * l11];
                this.f74324f = new d0(l11 * h(v11, i11));
                int i13 = ((cVar.f74341c * cVar.f74343e) * 8) / v11;
                this.f74326h = new o1.b().e0(MimeTypes.AUDIO_RAW).G(i13).Z(i13).W(h(max, i11)).H(cVar.f74340b).f0(cVar.f74341c).Y(2).E();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected frames per block: " + i12 + "; got: " + v11, null);
        }

        private void d(byte[] bArr, int i11, d0 d0Var) {
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < this.f74321c.f74340b; i13++) {
                    e(bArr, i12, i13, d0Var.d());
                }
            }
            int g11 = g(this.f74322d * i11);
            d0Var.P(0);
            d0Var.O(g11);
        }

        private void e(byte[] bArr, int i11, int i12, byte[] bArr2) {
            r9.c cVar = this.f74321c;
            int i13 = cVar.f74343e;
            int i14 = cVar.f74340b;
            int i15 = (i11 * i13) + (i12 * 4);
            int i16 = (i14 * 4) + i15;
            int i17 = (i13 / i14) - 4;
            int i18 = (short) (((bArr[i15 + 1] & 255) << 8) | (bArr[i15] & 255));
            int min = Math.min(bArr[i15 + 2] & 255, 88);
            int i19 = f74318n[min];
            int i20 = ((i11 * this.f74322d * i14) + i12) * 2;
            bArr2[i20] = (byte) (i18 & 255);
            bArr2[i20 + 1] = (byte) (i18 >> 8);
            for (int i21 = 0; i21 < i17 * 2; i21++) {
                byte b11 = bArr[((i21 / 8) * i14 * 4) + i16 + ((i21 / 2) % 4)];
                int i22 = i21 % 2 == 0 ? b11 & 15 : (b11 & 255) >> 4;
                int i23 = ((((i22 & 7) * 2) + 1) * i19) >> 3;
                if ((i22 & 8) != 0) {
                    i23 = -i23;
                }
                i18 = p0.q(i18 + i23, -32768, 32767);
                i20 += i14 * 2;
                bArr2[i20] = (byte) (i18 & 255);
                bArr2[i20 + 1] = (byte) (i18 >> 8);
                int i24 = min + f74317m[i22];
                int[] iArr = f74318n;
                min = p0.q(i24, 0, iArr.length - 1);
                i19 = iArr[min];
            }
        }

        private int f(int i11) {
            return i11 / (this.f74321c.f74340b * 2);
        }

        private int g(int i11) {
            return h(i11, this.f74321c.f74340b);
        }

        private static int h(int i11, int i12) {
            return i11 * 2 * i12;
        }

        private void i(int i11) {
            long N0 = this.f74328j + p0.N0(this.f74330l, 1000000L, this.f74321c.f74341c);
            int g11 = g(i11);
            this.f74320b.d(N0, 1, g11, this.f74329k - g11, null);
            this.f74330l += i11;
            this.f74329k -= g11;
        }

        @Override // r9.b.InterfaceC0931b
        public void a(int i11, long j11) {
            this.f74319a.d(new e(this.f74321c, this.f74322d, i11, j11));
            this.f74320b.e(this.f74326h);
        }

        @Override // r9.b.InterfaceC0931b
        public void b(long j11) {
            this.f74327i = 0;
            this.f74328j = j11;
            this.f74329k = 0;
            this.f74330l = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0035 -> B:3:0x001b). Please report as a decompilation issue!!! */
        @Override // r9.b.InterfaceC0931b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean c(g9.m r7, long r8) {
            /*
                r6 = this;
                int r0 = r6.f74325g
                int r1 = r6.f74329k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f74322d
                int r0 = com.google.android.exoplayer2.util.p0.l(r0, r1)
                r9.c r1 = r6.f74321c
                int r1 = r1.f74343e
                int r0 = r0 * r1
                r1 = 0
                int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                r2 = 1
                if (r1 != 0) goto L1d
            L1b:
                r1 = r2
                goto L1e
            L1d:
                r1 = 0
            L1e:
                if (r1 != 0) goto L3e
                int r3 = r6.f74327i
                if (r3 >= r0) goto L3e
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r3 = (int) r3
                byte[] r4 = r6.f74323e
                int r5 = r6.f74327i
                int r3 = r7.read(r4, r5, r3)
                r4 = -1
                if (r3 != r4) goto L38
                goto L1b
            L38:
                int r4 = r6.f74327i
                int r4 = r4 + r3
                r6.f74327i = r4
                goto L1e
            L3e:
                int r7 = r6.f74327i
                r9.c r8 = r6.f74321c
                int r8 = r8.f74343e
                int r7 = r7 / r8
                if (r7 <= 0) goto L75
                byte[] r8 = r6.f74323e
                com.google.android.exoplayer2.util.d0 r9 = r6.f74324f
                r6.d(r8, r7, r9)
                int r8 = r6.f74327i
                r9.c r9 = r6.f74321c
                int r9 = r9.f74343e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f74327i = r8
                com.google.android.exoplayer2.util.d0 r7 = r6.f74324f
                int r7 = r7.f()
                g9.e0 r8 = r6.f74320b
                com.google.android.exoplayer2.util.d0 r9 = r6.f74324f
                r8.c(r9, r7)
                int r8 = r6.f74329k
                int r8 = r8 + r7
                r6.f74329k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f74325g
                if (r7 < r8) goto L75
                r6.i(r8)
            L75:
                if (r1 == 0) goto L82
                int r7 = r6.f74329k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L82
                r6.i(r7)
            L82:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: r9.b.a.c(g9.m, long):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r9.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0931b {
        void a(int i11, long j11);

        void b(long j11);

        boolean c(m mVar, long j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c implements InterfaceC0931b {

        /* renamed from: a, reason: collision with root package name */
        private final n f74331a;

        /* renamed from: b, reason: collision with root package name */
        private final e0 f74332b;

        /* renamed from: c, reason: collision with root package name */
        private final r9.c f74333c;

        /* renamed from: d, reason: collision with root package name */
        private final o1 f74334d;

        /* renamed from: e, reason: collision with root package name */
        private final int f74335e;

        /* renamed from: f, reason: collision with root package name */
        private long f74336f;

        /* renamed from: g, reason: collision with root package name */
        private int f74337g;

        /* renamed from: h, reason: collision with root package name */
        private long f74338h;

        public c(n nVar, e0 e0Var, r9.c cVar, String str, int i11) {
            this.f74331a = nVar;
            this.f74332b = e0Var;
            this.f74333c = cVar;
            int i12 = (cVar.f74340b * cVar.f74344f) / 8;
            if (cVar.f74343e == i12) {
                int i13 = cVar.f74341c;
                int i14 = i13 * i12 * 8;
                int max = Math.max(i12, (i13 * i12) / 10);
                this.f74335e = max;
                this.f74334d = new o1.b().e0(str).G(i14).Z(i14).W(max).H(cVar.f74340b).f0(cVar.f74341c).Y(i11).E();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected block size: " + i12 + "; got: " + cVar.f74343e, null);
        }

        @Override // r9.b.InterfaceC0931b
        public void a(int i11, long j11) {
            this.f74331a.d(new e(this.f74333c, 1, i11, j11));
            this.f74332b.e(this.f74334d);
        }

        @Override // r9.b.InterfaceC0931b
        public void b(long j11) {
            this.f74336f = j11;
            this.f74337g = 0;
            this.f74338h = 0L;
        }

        @Override // r9.b.InterfaceC0931b
        public boolean c(m mVar, long j11) {
            int i11;
            int i12;
            long j12 = j11;
            while (j12 > 0 && (i11 = this.f74337g) < (i12 = this.f74335e)) {
                int b11 = this.f74332b.b(mVar, (int) Math.min(i12 - i11, j12), true);
                if (b11 == -1) {
                    j12 = 0;
                } else {
                    this.f74337g += b11;
                    j12 -= b11;
                }
            }
            int i13 = this.f74333c.f74343e;
            int i14 = this.f74337g / i13;
            if (i14 > 0) {
                long N0 = this.f74336f + p0.N0(this.f74338h, 1000000L, r1.f74341c);
                int i15 = i14 * i13;
                int i16 = this.f74337g - i15;
                this.f74332b.d(N0, 1, i15, i16, null);
                this.f74338h += i14;
                this.f74337g = i16;
            }
            return j12 <= 0;
        }
    }

    private void e() {
        com.google.android.exoplayer2.util.a.i(this.f74311b);
        p0.j(this.f74310a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] f() {
        return new l[]{new b()};
    }

    private void g(m mVar) {
        com.google.android.exoplayer2.util.a.g(mVar.getPosition() == 0);
        int i11 = this.f74315f;
        if (i11 != -1) {
            mVar.skipFully(i11);
            this.f74312c = 4;
        } else {
            if (!d.a(mVar)) {
                throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav file type.", null);
            }
            mVar.skipFully((int) (mVar.getPeekPosition() - mVar.getPosition()));
            this.f74312c = 1;
        }
    }

    private void h(m mVar) {
        r9.c b11 = d.b(mVar);
        int i11 = b11.f74339a;
        if (i11 == 17) {
            this.f74314e = new a(this.f74310a, this.f74311b, b11);
        } else if (i11 == 6) {
            this.f74314e = new c(this.f74310a, this.f74311b, b11, MimeTypes.AUDIO_ALAW, -1);
        } else if (i11 == 7) {
            this.f74314e = new c(this.f74310a, this.f74311b, b11, MimeTypes.AUDIO_MLAW, -1);
        } else {
            int a11 = i0.a(i11, b11.f74344f);
            if (a11 == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Unsupported WAV format type: " + b11.f74339a);
            }
            this.f74314e = new c(this.f74310a, this.f74311b, b11, MimeTypes.AUDIO_RAW, a11);
        }
        this.f74312c = 3;
    }

    private void i(m mVar) {
        this.f74313d = d.c(mVar);
        this.f74312c = 2;
    }

    private int j(m mVar) {
        com.google.android.exoplayer2.util.a.g(this.f74316g != -1);
        return ((InterfaceC0931b) com.google.android.exoplayer2.util.a.e(this.f74314e)).c(mVar, this.f74316g - mVar.getPosition()) ? -1 : 0;
    }

    private void k(m mVar) {
        Pair e11 = d.e(mVar);
        this.f74315f = ((Long) e11.first).intValue();
        long longValue = ((Long) e11.second).longValue();
        long j11 = this.f74313d;
        if (j11 != -1 && longValue == 4294967295L) {
            longValue = j11;
        }
        this.f74316g = this.f74315f + longValue;
        long length = mVar.getLength();
        if (length != -1 && this.f74316g > length) {
            s.i("WavExtractor", "Data exceeds input length: " + this.f74316g + ", " + length);
            this.f74316g = length;
        }
        ((InterfaceC0931b) com.google.android.exoplayer2.util.a.e(this.f74314e)).a(this.f74315f, this.f74316g);
        this.f74312c = 4;
    }

    @Override // g9.l
    public void b(n nVar) {
        this.f74310a = nVar;
        this.f74311b = nVar.track(0, 1);
        nVar.endTracks();
    }

    @Override // g9.l
    public int c(m mVar, a0 a0Var) {
        e();
        int i11 = this.f74312c;
        if (i11 == 0) {
            g(mVar);
            return 0;
        }
        if (i11 == 1) {
            i(mVar);
            return 0;
        }
        if (i11 == 2) {
            h(mVar);
            return 0;
        }
        if (i11 == 3) {
            k(mVar);
            return 0;
        }
        if (i11 == 4) {
            return j(mVar);
        }
        throw new IllegalStateException();
    }

    @Override // g9.l
    public boolean d(m mVar) {
        return d.a(mVar);
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        this.f74312c = j11 == 0 ? 0 : 4;
        InterfaceC0931b interfaceC0931b = this.f74314e;
        if (interfaceC0931b != null) {
            interfaceC0931b.b(j12);
        }
    }
}
