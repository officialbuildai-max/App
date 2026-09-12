package t3;

import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import i3.s;
import java.util.List;
import java.util.Map;
import l2.l0;
import l2.q;
import l2.r;
import l2.s0;
import l2.t;
import l2.w;
import l2.w0;
import l2.x;

/* loaded from: classes2.dex */
public final class b implements r {

    /* renamed from: h, reason: collision with root package name */
    public static final x f76138h = new x() { // from class: t3.a
        @Override // l2.x
        public /* synthetic */ x a(s.a aVar) {
            return w.d(this, aVar);
        }

        @Override // l2.x
        public /* synthetic */ x b(int i11) {
            return w.b(this, i11);
        }

        @Override // l2.x
        public /* synthetic */ r[] c(Uri uri, Map map) {
            return w.a(this, uri, map);
        }

        @Override // l2.x
        public final r[] createExtractors() {
            r[] h11;
            h11 = b.h();
            return h11;
        }

        @Override // l2.x
        public /* synthetic */ x d(boolean z10) {
            return w.c(this, z10);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private t f76139a;

    /* renamed from: b, reason: collision with root package name */
    private s0 f76140b;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC0948b f76143e;

    /* renamed from: c, reason: collision with root package name */
    private int f76141c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f76142d = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f76144f = -1;

    /* renamed from: g, reason: collision with root package name */
    private long f76145g = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a implements InterfaceC0948b {

        /* renamed from: m, reason: collision with root package name */
        private static final int[] f76146m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: n, reason: collision with root package name */
        private static final int[] f76147n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 130, 143, 157, 173, 190, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 230, 253, 279, 307, 337, 371, TTAdConstant.DOWNLOAD_URL_CODE, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: a, reason: collision with root package name */
        private final t f76148a;

        /* renamed from: b, reason: collision with root package name */
        private final s0 f76149b;

        /* renamed from: c, reason: collision with root package name */
        private final t3.c f76150c;

        /* renamed from: d, reason: collision with root package name */
        private final int f76151d;

        /* renamed from: e, reason: collision with root package name */
        private final byte[] f76152e;

        /* renamed from: f, reason: collision with root package name */
        private final j0 f76153f;

        /* renamed from: g, reason: collision with root package name */
        private final int f76154g;

        /* renamed from: h, reason: collision with root package name */
        private final androidx.media3.common.r f76155h;

        /* renamed from: i, reason: collision with root package name */
        private int f76156i;

        /* renamed from: j, reason: collision with root package name */
        private long f76157j;

        /* renamed from: k, reason: collision with root package name */
        private int f76158k;

        /* renamed from: l, reason: collision with root package name */
        private long f76159l;

        public a(t tVar, s0 s0Var, t3.c cVar) {
            this.f76148a = tVar;
            this.f76149b = s0Var;
            this.f76150c = cVar;
            int max = Math.max(1, cVar.f76170c / 10);
            this.f76154g = max;
            j0 j0Var = new j0(cVar.f76174g);
            j0Var.z();
            int z10 = j0Var.z();
            this.f76151d = z10;
            int i11 = cVar.f76169b;
            int i12 = (((cVar.f76172e - (i11 * 4)) * 8) / (cVar.f76173f * i11)) + 1;
            if (z10 == i12) {
                int k11 = a1.k(max, z10);
                this.f76152e = new byte[cVar.f76172e * k11];
                this.f76153f = new j0(k11 * h(z10, i11));
                int i13 = ((cVar.f76170c * cVar.f76172e) * 8) / z10;
                this.f76155h = new r.b().u0(MimeTypes.AUDIO_RAW).Q(i13).p0(i13).k0(h(max, i11)).R(cVar.f76169b).v0(cVar.f76170c).o0(2).N();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected frames per block: " + i12 + "; got: " + z10, null);
        }

        private void d(byte[] bArr, int i11, j0 j0Var) {
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < this.f76150c.f76169b; i13++) {
                    e(bArr, i12, i13, j0Var.e());
                }
            }
            int g11 = g(this.f76151d * i11);
            j0Var.W(0);
            j0Var.V(g11);
        }

        private void e(byte[] bArr, int i11, int i12, byte[] bArr2) {
            t3.c cVar = this.f76150c;
            int i13 = cVar.f76172e;
            int i14 = cVar.f76169b;
            int i15 = (i11 * i13) + (i12 * 4);
            int i16 = (i14 * 4) + i15;
            int i17 = (i13 / i14) - 4;
            int i18 = (short) (((bArr[i15 + 1] & 255) << 8) | (bArr[i15] & 255));
            int min = Math.min(bArr[i15 + 2] & 255, 88);
            int i19 = f76147n[min];
            int i20 = ((i11 * this.f76151d * i14) + i12) * 2;
            bArr2[i20] = (byte) (i18 & 255);
            bArr2[i20 + 1] = (byte) (i18 >> 8);
            for (int i21 = 0; i21 < i17 * 2; i21++) {
                byte b11 = bArr[((i21 / 8) * i14 * 4) + i16 + ((i21 / 2) % 4)];
                int i22 = i21 % 2 == 0 ? b11 & 15 : (b11 & 255) >> 4;
                int i23 = ((((i22 & 7) * 2) + 1) * i19) >> 3;
                if ((i22 & 8) != 0) {
                    i23 = -i23;
                }
                i18 = a1.p(i18 + i23, -32768, 32767);
                i20 += i14 * 2;
                bArr2[i20] = (byte) (i18 & 255);
                bArr2[i20 + 1] = (byte) (i18 >> 8);
                int i24 = min + f76146m[i22];
                int[] iArr = f76147n;
                min = a1.p(i24, 0, iArr.length - 1);
                i19 = iArr[min];
            }
        }

        private int f(int i11) {
            return i11 / (this.f76150c.f76169b * 2);
        }

        private int g(int i11) {
            return h(i11, this.f76150c.f76169b);
        }

        private static int h(int i11, int i12) {
            return i11 * 2 * i12;
        }

        private void i(int i11) {
            long e12 = this.f76157j + a1.e1(this.f76159l, 1000000L, this.f76150c.f76170c);
            int g11 = g(i11);
            this.f76149b.d(e12, 1, g11, this.f76158k - g11, null);
            this.f76159l += i11;
            this.f76158k -= g11;
        }

        @Override // t3.b.InterfaceC0948b
        public void a(int i11, long j11) {
            e eVar = new e(this.f76150c, this.f76151d, i11, j11);
            this.f76148a.f(eVar);
            this.f76149b.c(this.f76155h);
            this.f76149b.f(eVar.getDurationUs());
        }

        @Override // t3.b.InterfaceC0948b
        public void b(long j11) {
            this.f76156i = 0;
            this.f76157j = j11;
            this.f76158k = 0;
            this.f76159l = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0035 -> B:3:0x001b). Please report as a decompilation issue!!! */
        @Override // t3.b.InterfaceC0948b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean c(l2.s r7, long r8) {
            /*
                r6 = this;
                int r0 = r6.f76154g
                int r1 = r6.f76158k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f76151d
                int r0 = androidx.media3.common.util.a1.k(r0, r1)
                t3.c r1 = r6.f76150c
                int r1 = r1.f76172e
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
                int r3 = r6.f76156i
                if (r3 >= r0) goto L3e
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r3 = (int) r3
                byte[] r4 = r6.f76152e
                int r5 = r6.f76156i
                int r3 = r7.read(r4, r5, r3)
                r4 = -1
                if (r3 != r4) goto L38
                goto L1b
            L38:
                int r4 = r6.f76156i
                int r4 = r4 + r3
                r6.f76156i = r4
                goto L1e
            L3e:
                int r7 = r6.f76156i
                t3.c r8 = r6.f76150c
                int r8 = r8.f76172e
                int r7 = r7 / r8
                if (r7 <= 0) goto L75
                byte[] r8 = r6.f76152e
                androidx.media3.common.util.j0 r9 = r6.f76153f
                r6.d(r8, r7, r9)
                int r8 = r6.f76156i
                t3.c r9 = r6.f76150c
                int r9 = r9.f76172e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f76156i = r8
                androidx.media3.common.util.j0 r7 = r6.f76153f
                int r7 = r7.g()
                l2.s0 r8 = r6.f76149b
                androidx.media3.common.util.j0 r9 = r6.f76153f
                r8.b(r9, r7)
                int r8 = r6.f76158k
                int r8 = r8 + r7
                r6.f76158k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f76154g
                if (r7 < r8) goto L75
                r6.i(r8)
            L75:
                if (r1 == 0) goto L82
                int r7 = r6.f76158k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L82
                r6.i(r7)
            L82:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: t3.b.a.c(l2.s, long):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t3.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0948b {
        void a(int i11, long j11);

        void b(long j11);

        boolean c(l2.s sVar, long j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c implements InterfaceC0948b {

        /* renamed from: a, reason: collision with root package name */
        private final t f76160a;

        /* renamed from: b, reason: collision with root package name */
        private final s0 f76161b;

        /* renamed from: c, reason: collision with root package name */
        private final t3.c f76162c;

        /* renamed from: d, reason: collision with root package name */
        private final androidx.media3.common.r f76163d;

        /* renamed from: e, reason: collision with root package name */
        private final int f76164e;

        /* renamed from: f, reason: collision with root package name */
        private long f76165f;

        /* renamed from: g, reason: collision with root package name */
        private int f76166g;

        /* renamed from: h, reason: collision with root package name */
        private long f76167h;

        public c(t tVar, s0 s0Var, t3.c cVar, String str, int i11) {
            this.f76160a = tVar;
            this.f76161b = s0Var;
            this.f76162c = cVar;
            int i12 = (cVar.f76169b * cVar.f76173f) / 8;
            if (cVar.f76172e == i12) {
                int i13 = cVar.f76170c;
                int i14 = i13 * i12 * 8;
                int max = Math.max(i12, (i13 * i12) / 10);
                this.f76164e = max;
                this.f76163d = new r.b().U("audio/wav").u0(str).Q(i14).p0(i14).k0(max).R(cVar.f76169b).v0(cVar.f76170c).o0(i11).N();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected block size: " + i12 + "; got: " + cVar.f76172e, null);
        }

        @Override // t3.b.InterfaceC0948b
        public void a(int i11, long j11) {
            e eVar = new e(this.f76162c, 1, i11, j11);
            this.f76160a.f(eVar);
            this.f76161b.c(this.f76163d);
            this.f76161b.f(eVar.getDurationUs());
        }

        @Override // t3.b.InterfaceC0948b
        public void b(long j11) {
            this.f76165f = j11;
            this.f76166g = 0;
            this.f76167h = 0L;
        }

        @Override // t3.b.InterfaceC0948b
        public boolean c(l2.s sVar, long j11) {
            int i11;
            int i12;
            long j12 = j11;
            while (j12 > 0 && (i11 = this.f76166g) < (i12 = this.f76164e)) {
                int e11 = this.f76161b.e(sVar, (int) Math.min(i12 - i11, j12), true);
                if (e11 == -1) {
                    j12 = 0;
                } else {
                    this.f76166g += e11;
                    j12 -= e11;
                }
            }
            int i13 = this.f76162c.f76172e;
            int i14 = this.f76166g / i13;
            if (i14 > 0) {
                long e12 = this.f76165f + a1.e1(this.f76167h, 1000000L, r1.f76170c);
                int i15 = i14 * i13;
                int i16 = this.f76166g - i15;
                this.f76161b.d(e12, 1, i15, i16, null);
                this.f76167h += i14;
                this.f76166g = i16;
            }
            return j12 <= 0;
        }
    }

    private void g() {
        androidx.media3.common.util.a.i(this.f76140b);
        a1.i(this.f76139a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l2.r[] h() {
        return new l2.r[]{new b()};
    }

    private void i(l2.s sVar) {
        androidx.media3.common.util.a.g(sVar.getPosition() == 0);
        int i11 = this.f76144f;
        if (i11 != -1) {
            sVar.skipFully(i11);
            this.f76141c = 4;
        } else {
            if (!d.a(sVar)) {
                throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav file type.", null);
            }
            sVar.skipFully((int) (sVar.getPeekPosition() - sVar.getPosition()));
            this.f76141c = 1;
        }
    }

    private void j(l2.s sVar) {
        t3.c b11 = d.b(sVar);
        int i11 = b11.f76168a;
        if (i11 == 17) {
            this.f76143e = new a(this.f76139a, this.f76140b, b11);
        } else if (i11 == 6) {
            this.f76143e = new c(this.f76139a, this.f76140b, b11, MimeTypes.AUDIO_ALAW, -1);
        } else if (i11 == 7) {
            this.f76143e = new c(this.f76139a, this.f76140b, b11, MimeTypes.AUDIO_MLAW, -1);
        } else {
            int a11 = w0.a(i11, b11.f76173f);
            if (a11 == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Unsupported WAV format type: " + b11.f76168a);
            }
            this.f76143e = new c(this.f76139a, this.f76140b, b11, MimeTypes.AUDIO_RAW, a11);
        }
        this.f76141c = 3;
    }

    private void k(l2.s sVar) {
        this.f76142d = d.c(sVar);
        this.f76141c = 2;
    }

    private int l(l2.s sVar) {
        androidx.media3.common.util.a.g(this.f76145g != -1);
        return ((InterfaceC0948b) androidx.media3.common.util.a.e(this.f76143e)).c(sVar, this.f76145g - sVar.getPosition()) ? -1 : 0;
    }

    private void m(l2.s sVar) {
        Pair e11 = d.e(sVar);
        this.f76144f = ((Long) e11.first).intValue();
        long longValue = ((Long) e11.second).longValue();
        long j11 = this.f76142d;
        if (j11 != -1 && longValue == 4294967295L) {
            longValue = j11;
        }
        this.f76145g = this.f76144f + longValue;
        long length = sVar.getLength();
        if (length != -1 && this.f76145g > length) {
            u.h("WavExtractor", "Data exceeds input length: " + this.f76145g + ", " + length);
            this.f76145g = length;
        }
        ((InterfaceC0948b) androidx.media3.common.util.a.e(this.f76143e)).a(this.f76144f, this.f76145g);
        this.f76141c = 4;
    }

    @Override // l2.r
    public void b(t tVar) {
        this.f76139a = tVar;
        this.f76140b = tVar.track(0, 1);
        tVar.endTracks();
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        g();
        int i11 = this.f76141c;
        if (i11 == 0) {
            i(sVar);
            return 0;
        }
        if (i11 == 1) {
            k(sVar);
            return 0;
        }
        if (i11 == 2) {
            j(sVar);
            return 0;
        }
        if (i11 == 3) {
            m(sVar);
            return 0;
        }
        if (i11 == 4) {
            return l(sVar);
        }
        throw new IllegalStateException();
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        return d.a(sVar);
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return q.a(this);
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        this.f76141c = j11 == 0 ? 0 : 4;
        InterfaceC0948b interfaceC0948b = this.f76143e;
        if (interfaceC0948b != null) {
            interfaceC0948b.b(j12);
        }
    }
}
