package o9;

import android.util.Pair;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o9.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f70875a = p0.n0("OpusHead");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f70876a;

        /* renamed from: b, reason: collision with root package name */
        public int f70877b;

        /* renamed from: c, reason: collision with root package name */
        public int f70878c;

        /* renamed from: d, reason: collision with root package name */
        public long f70879d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f70880e;

        /* renamed from: f, reason: collision with root package name */
        private final d0 f70881f;

        /* renamed from: g, reason: collision with root package name */
        private final d0 f70882g;

        /* renamed from: h, reason: collision with root package name */
        private int f70883h;

        /* renamed from: i, reason: collision with root package name */
        private int f70884i;

        public a(d0 d0Var, d0 d0Var2, boolean z10) {
            this.f70882g = d0Var;
            this.f70881f = d0Var2;
            this.f70880e = z10;
            d0Var2.P(12);
            this.f70876a = d0Var2.H();
            d0Var.P(12);
            this.f70884i = d0Var.H();
            g9.o.a(d0Var.n() == 1, "first_chunk must be 1");
            this.f70877b = -1;
        }

        public boolean a() {
            int i11 = this.f70877b + 1;
            this.f70877b = i11;
            if (i11 == this.f70876a) {
                return false;
            }
            this.f70879d = this.f70880e ? this.f70881f.I() : this.f70881f.F();
            if (this.f70877b == this.f70883h) {
                this.f70878c = this.f70882g.H();
                this.f70882g.Q(4);
                int i12 = this.f70884i - 1;
                this.f70884i = i12;
                this.f70883h = i12 > 0 ? this.f70882g.H() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o9.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0887b {

        /* renamed from: a, reason: collision with root package name */
        private final String f70885a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f70886b;

        /* renamed from: c, reason: collision with root package name */
        private final long f70887c;

        /* renamed from: d, reason: collision with root package name */
        private final long f70888d;

        public C0887b(String str, byte[] bArr, long j11, long j12) {
            this.f70885a = str;
            this.f70886b = bArr;
            this.f70887c = j11;
            this.f70888d = j12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface c {
        int a();

        int getSampleCount();

        int readNextSampleSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final p[] f70889a;

        /* renamed from: b, reason: collision with root package name */
        public o1 f70890b;

        /* renamed from: c, reason: collision with root package name */
        public int f70891c;

        /* renamed from: d, reason: collision with root package name */
        public int f70892d = 0;

        public d(int i11) {
            this.f70889a = new p[i11];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class e implements c {

        /* renamed from: a, reason: collision with root package name */
        private final int f70893a;

        /* renamed from: b, reason: collision with root package name */
        private final int f70894b;

        /* renamed from: c, reason: collision with root package name */
        private final d0 f70895c;

        public e(a.b bVar, o1 o1Var) {
            d0 d0Var = bVar.f70874b;
            this.f70895c = d0Var;
            d0Var.P(12);
            int H = d0Var.H();
            if (MimeTypes.AUDIO_RAW.equals(o1Var.f25550l)) {
                int e02 = p0.e0(o1Var.A, o1Var.f25563y);
                if (H == 0 || H % e02 != 0) {
                    s.i("AtomParsers", "Audio sample size mismatch. stsd sample size: " + e02 + ", stsz sample size: " + H);
                    H = e02;
                }
            }
            this.f70893a = H == 0 ? -1 : H;
            this.f70894b = d0Var.H();
        }

        @Override // o9.b.c
        public int a() {
            return this.f70893a;
        }

        @Override // o9.b.c
        public int getSampleCount() {
            return this.f70894b;
        }

        @Override // o9.b.c
        public int readNextSampleSize() {
            int i11 = this.f70893a;
            return i11 == -1 ? this.f70895c.H() : i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class f implements c {

        /* renamed from: a, reason: collision with root package name */
        private final d0 f70896a;

        /* renamed from: b, reason: collision with root package name */
        private final int f70897b;

        /* renamed from: c, reason: collision with root package name */
        private final int f70898c;

        /* renamed from: d, reason: collision with root package name */
        private int f70899d;

        /* renamed from: e, reason: collision with root package name */
        private int f70900e;

        public f(a.b bVar) {
            d0 d0Var = bVar.f70874b;
            this.f70896a = d0Var;
            d0Var.P(12);
            this.f70898c = d0Var.H() & 255;
            this.f70897b = d0Var.H();
        }

        @Override // o9.b.c
        public int a() {
            return -1;
        }

        @Override // o9.b.c
        public int getSampleCount() {
            return this.f70897b;
        }

        @Override // o9.b.c
        public int readNextSampleSize() {
            int i11 = this.f70898c;
            if (i11 == 8) {
                return this.f70896a.D();
            }
            if (i11 == 16) {
                return this.f70896a.J();
            }
            int i12 = this.f70899d;
            this.f70899d = i12 + 1;
            if (i12 % 2 != 0) {
                return this.f70900e & 15;
            }
            int D = this.f70896a.D();
            this.f70900e = D;
            return (D & 240) >> 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        private final int f70901a;

        /* renamed from: b, reason: collision with root package name */
        private final long f70902b;

        /* renamed from: c, reason: collision with root package name */
        private final int f70903c;

        public g(int i11, long j11, int i12) {
            this.f70901a = i11;
            this.f70902b = j11;
            this.f70903c = i12;
        }
    }

    public static List A(a.C0886a c0886a, x xVar, long j11, DrmInitData drmInitData, boolean z10, boolean z11, com.google.common.base.f fVar) {
        o oVar;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < c0886a.f70873d.size(); i11++) {
            a.C0886a c0886a2 = (a.C0886a) c0886a.f70873d.get(i11);
            if (c0886a2.f70870a == 1953653099 && (oVar = (o) fVar.apply(z(c0886a2, (a.b) com.google.android.exoplayer2.util.a.e(c0886a.g(1836476516)), j11, drmInitData, z10, z11))) != null) {
                arrayList.add(v(oVar, (a.C0886a) com.google.android.exoplayer2.util.a.e(((a.C0886a) com.google.android.exoplayer2.util.a.e(((a.C0886a) com.google.android.exoplayer2.util.a.e(c0886a2.f(1835297121))).f(1835626086))).f(1937007212)), xVar));
            }
        }
        return arrayList;
    }

    public static Pair B(a.b bVar) {
        d0 d0Var = bVar.f70874b;
        d0Var.P(8);
        Metadata metadata = null;
        Metadata metadata2 = null;
        while (d0Var.a() >= 8) {
            int e11 = d0Var.e();
            int n11 = d0Var.n();
            int n12 = d0Var.n();
            if (n12 == 1835365473) {
                d0Var.P(e11);
                metadata = C(d0Var, e11 + n11);
            } else if (n12 == 1936553057) {
                d0Var.P(e11);
                metadata2 = u(d0Var, e11 + n11);
            }
            d0Var.P(e11 + n11);
        }
        return Pair.create(metadata, metadata2);
    }

    private static Metadata C(d0 d0Var, int i11) {
        d0Var.Q(8);
        e(d0Var);
        while (d0Var.e() < i11) {
            int e11 = d0Var.e();
            int n11 = d0Var.n();
            if (d0Var.n() == 1768715124) {
                d0Var.P(e11);
                return l(d0Var, e11 + n11);
            }
            d0Var.P(e11 + n11);
        }
        return null;
    }

    private static void D(d0 d0Var, int i11, int i12, int i13, int i14, int i15, DrmInitData drmInitData, d dVar, int i16) {
        DrmInitData drmInitData2;
        int i17;
        int i18;
        byte[] bArr;
        float f11;
        List list;
        String str;
        int i19 = i12;
        int i20 = i13;
        DrmInitData drmInitData3 = drmInitData;
        d dVar2 = dVar;
        d0Var.P(i19 + 16);
        d0Var.Q(16);
        int J = d0Var.J();
        int J2 = d0Var.J();
        d0Var.Q(50);
        int e11 = d0Var.e();
        int i21 = i11;
        if (i21 == 1701733238) {
            Pair s11 = s(d0Var, i19, i20);
            if (s11 != null) {
                i21 = ((Integer) s11.first).intValue();
                drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((p) s11.second).f71011b);
                dVar2.f70889a[i16] = (p) s11.second;
            }
            d0Var.P(e11);
        }
        String str2 = MimeTypes.VIDEO_H263;
        String str3 = i21 == 1831958048 ? MimeTypes.VIDEO_MPEG : i21 == 1211250227 ? MimeTypes.VIDEO_H263 : null;
        float f12 = 1.0f;
        byte[] bArr2 = null;
        String str4 = null;
        List list2 = null;
        int i22 = -1;
        int i23 = -1;
        int i24 = -1;
        int i25 = -1;
        ByteBuffer byteBuffer = null;
        C0887b c0887b = null;
        boolean z10 = false;
        while (true) {
            if (e11 - i19 >= i20) {
                drmInitData2 = drmInitData3;
                break;
            }
            d0Var.P(e11);
            int e12 = d0Var.e();
            String str5 = str2;
            int n11 = d0Var.n();
            if (n11 == 0) {
                drmInitData2 = drmInitData3;
                if (d0Var.e() - i19 == i20) {
                    break;
                }
            } else {
                drmInitData2 = drmInitData3;
            }
            g9.o.a(n11 > 0, "childAtomSize must be positive");
            int n12 = d0Var.n();
            if (n12 == 1635148611) {
                g9.o.a(str3 == null, null);
                d0Var.P(e12 + 8);
                com.google.android.exoplayer2.video.a b11 = com.google.android.exoplayer2.video.a.b(d0Var);
                list2 = b11.f27873a;
                dVar2.f70891c = b11.f27874b;
                if (!z10) {
                    f12 = b11.f27877e;
                }
                str4 = b11.f27878f;
                str = MimeTypes.VIDEO_H264;
            } else if (n12 == 1752589123) {
                g9.o.a(str3 == null, null);
                d0Var.P(e12 + 8);
                com.google.android.exoplayer2.video.f a11 = com.google.android.exoplayer2.video.f.a(d0Var);
                list2 = a11.f27902a;
                dVar2.f70891c = a11.f27903b;
                if (!z10) {
                    f12 = a11.f27906e;
                }
                str4 = a11.f27907f;
                str = MimeTypes.VIDEO_H265;
            } else {
                if (n12 == 1685480259 || n12 == 1685485123) {
                    i17 = J2;
                    i18 = i21;
                    bArr = bArr2;
                    f11 = f12;
                    list = list2;
                    com.google.android.exoplayer2.video.d a12 = com.google.android.exoplayer2.video.d.a(d0Var);
                    if (a12 != null) {
                        str4 = a12.f27887c;
                        str3 = "video/dolby-vision";
                    }
                } else if (n12 == 1987076931) {
                    g9.o.a(str3 == null, null);
                    str = i21 == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                } else if (n12 == 1635135811) {
                    g9.o.a(str3 == null, null);
                    str = "video/av01";
                } else if (n12 == 1668050025) {
                    if (byteBuffer == null) {
                        byteBuffer = a();
                    }
                    ByteBuffer byteBuffer2 = byteBuffer;
                    byteBuffer2.position(21);
                    byteBuffer2.putShort(d0Var.z());
                    byteBuffer2.putShort(d0Var.z());
                    byteBuffer = byteBuffer2;
                    i17 = J2;
                    i18 = i21;
                    e11 += n11;
                    i19 = i12;
                    i20 = i13;
                    dVar2 = dVar;
                    str2 = str5;
                    drmInitData3 = drmInitData2;
                    i21 = i18;
                    J2 = i17;
                } else if (n12 == 1835295606) {
                    if (byteBuffer == null) {
                        byteBuffer = a();
                    }
                    ByteBuffer byteBuffer3 = byteBuffer;
                    short z11 = d0Var.z();
                    short z12 = d0Var.z();
                    short z13 = d0Var.z();
                    i18 = i21;
                    short z14 = d0Var.z();
                    short z15 = d0Var.z();
                    List list3 = list2;
                    short z16 = d0Var.z();
                    byte[] bArr3 = bArr2;
                    short z17 = d0Var.z();
                    float f13 = f12;
                    short z18 = d0Var.z();
                    long F = d0Var.F();
                    long F2 = d0Var.F();
                    i17 = J2;
                    byteBuffer3.position(1);
                    byteBuffer3.putShort(z15);
                    byteBuffer3.putShort(z16);
                    byteBuffer3.putShort(z11);
                    byteBuffer3.putShort(z12);
                    byteBuffer3.putShort(z13);
                    byteBuffer3.putShort(z14);
                    byteBuffer3.putShort(z17);
                    byteBuffer3.putShort(z18);
                    byteBuffer3.putShort((short) (F / 10000));
                    byteBuffer3.putShort((short) (F2 / 10000));
                    byteBuffer = byteBuffer3;
                    list2 = list3;
                    bArr2 = bArr3;
                    f12 = f13;
                    e11 += n11;
                    i19 = i12;
                    i20 = i13;
                    dVar2 = dVar;
                    str2 = str5;
                    drmInitData3 = drmInitData2;
                    i21 = i18;
                    J2 = i17;
                } else {
                    i17 = J2;
                    i18 = i21;
                    bArr = bArr2;
                    f11 = f12;
                    list = list2;
                    if (n12 == 1681012275) {
                        g9.o.a(str3 == null, null);
                        str3 = str5;
                    } else if (n12 == 1702061171) {
                        g9.o.a(str3 == null, null);
                        c0887b = i(d0Var, e12);
                        String str6 = c0887b.f70885a;
                        byte[] bArr4 = c0887b.f70886b;
                        list2 = bArr4 != null ? ImmutableList.of(bArr4) : list;
                        str3 = str6;
                        bArr2 = bArr;
                        f12 = f11;
                        e11 += n11;
                        i19 = i12;
                        i20 = i13;
                        dVar2 = dVar;
                        str2 = str5;
                        drmInitData3 = drmInitData2;
                        i21 = i18;
                        J2 = i17;
                    } else if (n12 == 1885434736) {
                        f12 = q(d0Var, e12);
                        list2 = list;
                        bArr2 = bArr;
                        z10 = true;
                        e11 += n11;
                        i19 = i12;
                        i20 = i13;
                        dVar2 = dVar;
                        str2 = str5;
                        drmInitData3 = drmInitData2;
                        i21 = i18;
                        J2 = i17;
                    } else if (n12 == 1937126244) {
                        bArr2 = r(d0Var, e12, n11);
                        list2 = list;
                        f12 = f11;
                        e11 += n11;
                        i19 = i12;
                        i20 = i13;
                        dVar2 = dVar;
                        str2 = str5;
                        drmInitData3 = drmInitData2;
                        i21 = i18;
                        J2 = i17;
                    } else if (n12 == 1936995172) {
                        int D = d0Var.D();
                        d0Var.Q(3);
                        if (D == 0) {
                            int D2 = d0Var.D();
                            if (D2 == 0) {
                                i22 = 0;
                            } else if (D2 == 1) {
                                i22 = 1;
                            } else if (D2 == 2) {
                                i22 = 2;
                            } else if (D2 == 3) {
                                i22 = 3;
                            }
                        }
                    } else if (n12 == 1668246642) {
                        int n13 = d0Var.n();
                        if (n13 == 1852009592 || n13 == 1852009571) {
                            int J3 = d0Var.J();
                            int J4 = d0Var.J();
                            d0Var.Q(2);
                            boolean z19 = n11 == 19 && (d0Var.D() & 128) != 0;
                            i23 = com.google.android.exoplayer2.video.c.b(J3);
                            i24 = z19 ? 1 : 2;
                            i25 = com.google.android.exoplayer2.video.c.c(J4);
                        } else {
                            s.i("AtomParsers", "Unsupported color type: " + o9.a.a(n13));
                        }
                    }
                }
                list2 = list;
                bArr2 = bArr;
                f12 = f11;
                e11 += n11;
                i19 = i12;
                i20 = i13;
                dVar2 = dVar;
                str2 = str5;
                drmInitData3 = drmInitData2;
                i21 = i18;
                J2 = i17;
            }
            str3 = str;
            i17 = J2;
            i18 = i21;
            e11 += n11;
            i19 = i12;
            i20 = i13;
            dVar2 = dVar;
            str2 = str5;
            drmInitData3 = drmInitData2;
            i21 = i18;
            J2 = i17;
        }
        int i26 = J2;
        byte[] bArr5 = bArr2;
        float f14 = f12;
        List list4 = list2;
        if (str3 == null) {
            return;
        }
        o1.b M = new o1.b().R(i14).e0(str3).I(str4).j0(J).Q(i26).a0(f14).d0(i15).b0(bArr5).h0(i22).T(list4).M(drmInitData2);
        int i27 = i23;
        int i28 = i24;
        int i29 = i25;
        if (i27 != -1 || i28 != -1 || i29 != -1 || byteBuffer != null) {
            M.J(new com.google.android.exoplayer2.video.c(i27, i28, i29, byteBuffer != null ? byteBuffer.array() : null));
        }
        if (c0887b != null) {
            M.G(Ints.n(c0887b.f70887c)).Z(Ints.n(c0887b.f70888d));
        }
        dVar.f70890b = M.E();
    }

    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean b(long[] jArr, long j11, long j12, long j13) {
        int length = jArr.length - 1;
        return jArr[0] <= j12 && j12 < jArr[p0.q(4, 0, length)] && jArr[p0.q(jArr.length - 4, 0, length)] < j13 && j13 <= j11;
    }

    private static int c(d0 d0Var, int i11, int i12, int i13) {
        int e11 = d0Var.e();
        g9.o.a(e11 >= i12, null);
        while (e11 - i12 < i13) {
            d0Var.P(e11);
            int n11 = d0Var.n();
            g9.o.a(n11 > 0, "childAtomSize must be positive");
            if (d0Var.n() == i11) {
                return e11;
            }
            e11 += n11;
        }
        return -1;
    }

    private static int d(int i11) {
        if (i11 == 1936684398) {
            return 1;
        }
        if (i11 == 1986618469) {
            return 2;
        }
        if (i11 == 1952807028 || i11 == 1935832172 || i11 == 1937072756 || i11 == 1668047728) {
            return 3;
        }
        return i11 == 1835365473 ? 5 : -1;
    }

    public static void e(d0 d0Var) {
        int e11 = d0Var.e();
        d0Var.Q(4);
        if (d0Var.n() != 1751411826) {
            e11 += 4;
        }
        d0Var.P(e11);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void f(com.google.android.exoplayer2.util.d0 r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, com.google.android.exoplayer2.drm.DrmInitData r29, o9.b.d r30, int r31) {
        /*
            Method dump skipped, instructions count: 863
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.b.f(com.google.android.exoplayer2.util.d0, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, o9.b$d, int):void");
    }

    static Pair g(d0 d0Var, int i11, int i12) {
        int i13 = i11 + 8;
        int i14 = -1;
        int i15 = 0;
        String str = null;
        Integer num = null;
        while (i13 - i11 < i12) {
            d0Var.P(i13);
            int n11 = d0Var.n();
            int n12 = d0Var.n();
            if (n12 == 1718775137) {
                num = Integer.valueOf(d0Var.n());
            } else if (n12 == 1935894637) {
                d0Var.Q(4);
                str = d0Var.A(4);
            } else if (n12 == 1935894633) {
                i14 = i13;
                i15 = n11;
            }
            i13 += n11;
        }
        if (!C.CENC_TYPE_cenc.equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        g9.o.a(num != null, "frma atom is mandatory");
        g9.o.a(i14 != -1, "schi atom is mandatory");
        p t11 = t(d0Var, i14, i15, str);
        g9.o.a(t11 != null, "tenc atom is mandatory");
        return Pair.create(num, (p) p0.j(t11));
    }

    private static Pair h(a.C0886a c0886a) {
        a.b g11 = c0886a.g(1701606260);
        if (g11 == null) {
            return null;
        }
        d0 d0Var = g11.f70874b;
        d0Var.P(8);
        int c11 = o9.a.c(d0Var.n());
        int H = d0Var.H();
        long[] jArr = new long[H];
        long[] jArr2 = new long[H];
        for (int i11 = 0; i11 < H; i11++) {
            jArr[i11] = c11 == 1 ? d0Var.I() : d0Var.F();
            jArr2[i11] = c11 == 1 ? d0Var.w() : d0Var.n();
            if (d0Var.z() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            d0Var.Q(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static C0887b i(d0 d0Var, int i11) {
        d0Var.P(i11 + 12);
        d0Var.Q(1);
        j(d0Var);
        d0Var.Q(2);
        int D = d0Var.D();
        if ((D & 128) != 0) {
            d0Var.Q(2);
        }
        if ((D & 64) != 0) {
            d0Var.Q(d0Var.D());
        }
        if ((D & 32) != 0) {
            d0Var.Q(2);
        }
        d0Var.Q(1);
        j(d0Var);
        String h11 = w.h(d0Var.D());
        if (MimeTypes.AUDIO_MPEG.equals(h11) || MimeTypes.AUDIO_DTS.equals(h11) || MimeTypes.AUDIO_DTS_HD.equals(h11)) {
            return new C0887b(h11, null, -1L, -1L);
        }
        d0Var.Q(4);
        long F = d0Var.F();
        long F2 = d0Var.F();
        d0Var.Q(1);
        int j11 = j(d0Var);
        byte[] bArr = new byte[j11];
        d0Var.j(bArr, 0, j11);
        return new C0887b(h11, bArr, F2 > 0 ? F2 : -1L, F > 0 ? F : -1L);
    }

    private static int j(d0 d0Var) {
        int D = d0Var.D();
        int i11 = D & 127;
        while ((D & 128) == 128) {
            D = d0Var.D();
            i11 = (i11 << 7) | (D & 127);
        }
        return i11;
    }

    private static int k(d0 d0Var) {
        d0Var.P(16);
        return d0Var.n();
    }

    private static Metadata l(d0 d0Var, int i11) {
        d0Var.Q(8);
        ArrayList arrayList = new ArrayList();
        while (d0Var.e() < i11) {
            Metadata.Entry c11 = h.c(d0Var);
            if (c11 != null) {
                arrayList.add(c11);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Pair m(d0 d0Var) {
        d0Var.P(8);
        int c11 = o9.a.c(d0Var.n());
        d0Var.Q(c11 == 0 ? 8 : 16);
        long F = d0Var.F();
        d0Var.Q(c11 == 0 ? 4 : 8);
        int J = d0Var.J();
        return Pair.create(Long.valueOf(F), "" + ((char) (((J >> 10) & 31) + 96)) + ((char) (((J >> 5) & 31) + 96)) + ((char) ((J & 31) + 96)));
    }

    public static Metadata n(a.C0886a c0886a) {
        a.b g11 = c0886a.g(1751411826);
        a.b g12 = c0886a.g(1801812339);
        a.b g13 = c0886a.g(1768715124);
        if (g11 == null || g12 == null || g13 == null || k(g11.f70874b) != 1835299937) {
            return null;
        }
        d0 d0Var = g12.f70874b;
        d0Var.P(12);
        int n11 = d0Var.n();
        String[] strArr = new String[n11];
        for (int i11 = 0; i11 < n11; i11++) {
            int n12 = d0Var.n();
            d0Var.Q(4);
            strArr[i11] = d0Var.A(n12 - 8);
        }
        d0 d0Var2 = g13.f70874b;
        d0Var2.P(8);
        ArrayList arrayList = new ArrayList();
        while (d0Var2.a() > 8) {
            int e11 = d0Var2.e();
            int n13 = d0Var2.n();
            int n14 = d0Var2.n() - 1;
            if (n14 < 0 || n14 >= n11) {
                s.i("AtomParsers", "Skipped metadata with unknown key index: " + n14);
            } else {
                MdtaMetadataEntry f11 = h.f(d0Var2, e11 + n13, strArr[n14]);
                if (f11 != null) {
                    arrayList.add(f11);
                }
            }
            d0Var2.P(e11 + n13);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static void o(d0 d0Var, int i11, int i12, int i13, d dVar) {
        d0Var.P(i12 + 16);
        if (i11 == 1835365492) {
            d0Var.x();
            String x10 = d0Var.x();
            if (x10 != null) {
                dVar.f70890b = new o1.b().R(i13).e0(x10).E();
            }
        }
    }

    private static long p(d0 d0Var) {
        d0Var.P(8);
        d0Var.Q(o9.a.c(d0Var.n()) != 0 ? 16 : 8);
        return d0Var.F();
    }

    private static float q(d0 d0Var, int i11) {
        d0Var.P(i11 + 8);
        return d0Var.H() / d0Var.H();
    }

    private static byte[] r(d0 d0Var, int i11, int i12) {
        int i13 = i11 + 8;
        while (i13 - i11 < i12) {
            d0Var.P(i13);
            int n11 = d0Var.n();
            if (d0Var.n() == 1886547818) {
                return Arrays.copyOfRange(d0Var.d(), i13, n11 + i13);
            }
            i13 += n11;
        }
        return null;
    }

    private static Pair s(d0 d0Var, int i11, int i12) {
        Pair g11;
        int e11 = d0Var.e();
        while (e11 - i11 < i12) {
            d0Var.P(e11);
            int n11 = d0Var.n();
            g9.o.a(n11 > 0, "childAtomSize must be positive");
            if (d0Var.n() == 1936289382 && (g11 = g(d0Var, e11, n11)) != null) {
                return g11;
            }
            e11 += n11;
        }
        return null;
    }

    private static p t(d0 d0Var, int i11, int i12, String str) {
        int i13;
        int i14;
        int i15 = i11 + 8;
        while (true) {
            byte[] bArr = null;
            if (i15 - i11 >= i12) {
                return null;
            }
            d0Var.P(i15);
            int n11 = d0Var.n();
            if (d0Var.n() == 1952804451) {
                int c11 = o9.a.c(d0Var.n());
                d0Var.Q(1);
                if (c11 == 0) {
                    d0Var.Q(1);
                    i14 = 0;
                    i13 = 0;
                } else {
                    int D = d0Var.D();
                    i13 = D & 15;
                    i14 = (D & 240) >> 4;
                }
                boolean z10 = d0Var.D() == 1;
                int D2 = d0Var.D();
                byte[] bArr2 = new byte[16];
                d0Var.j(bArr2, 0, 16);
                if (z10 && D2 == 0) {
                    int D3 = d0Var.D();
                    bArr = new byte[D3];
                    d0Var.j(bArr, 0, D3);
                }
                return new p(z10, str, D2, bArr2, i14, i13, bArr);
            }
            i15 += n11;
        }
    }

    private static Metadata u(d0 d0Var, int i11) {
        d0Var.Q(12);
        while (d0Var.e() < i11) {
            int e11 = d0Var.e();
            int n11 = d0Var.n();
            if (d0Var.n() == 1935766900) {
                if (n11 < 14) {
                    return null;
                }
                d0Var.Q(5);
                int D = d0Var.D();
                if (D != 12 && D != 13) {
                    return null;
                }
                float f11 = D == 12 ? 240.0f : 120.0f;
                d0Var.Q(1);
                return new Metadata(new SmtaMetadataEntry(f11, d0Var.D()));
            }
            d0Var.P(e11 + n11);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x042b A[EDGE_INSN: B:97:0x042b->B:98:0x042b BREAK  A[LOOP:2: B:76:0x03ca->B:92:0x0424], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static o9.r v(o9.o r38, o9.a.C0886a r39, g9.x r40) {
        /*
            Method dump skipped, instructions count: 1313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.b.v(o9.o, o9.a$a, g9.x):o9.r");
    }

    private static d w(d0 d0Var, int i11, int i12, String str, DrmInitData drmInitData, boolean z10) {
        int i13;
        d0Var.P(12);
        int n11 = d0Var.n();
        d dVar = new d(n11);
        for (int i14 = 0; i14 < n11; i14++) {
            int e11 = d0Var.e();
            int n12 = d0Var.n();
            g9.o.a(n12 > 0, "childAtomSize must be positive");
            int n13 = d0Var.n();
            if (n13 == 1635148593 || n13 == 1635148595 || n13 == 1701733238 || n13 == 1831958048 || n13 == 1836070006 || n13 == 1752589105 || n13 == 1751479857 || n13 == 1932670515 || n13 == 1211250227 || n13 == 1987063864 || n13 == 1987063865 || n13 == 1635135537 || n13 == 1685479798 || n13 == 1685479729 || n13 == 1685481573 || n13 == 1685481521) {
                i13 = e11;
                D(d0Var, n13, i13, n12, i11, i12, drmInitData, dVar, i14);
            } else if (n13 == 1836069985 || n13 == 1701733217 || n13 == 1633889587 || n13 == 1700998451 || n13 == 1633889588 || n13 == 1835823201 || n13 == 1685353315 || n13 == 1685353317 || n13 == 1685353320 || n13 == 1685353324 || n13 == 1685353336 || n13 == 1935764850 || n13 == 1935767394 || n13 == 1819304813 || n13 == 1936684916 || n13 == 1953984371 || n13 == 778924082 || n13 == 778924083 || n13 == 1835557169 || n13 == 1835560241 || n13 == 1634492771 || n13 == 1634492791 || n13 == 1970037111 || n13 == 1332770163 || n13 == 1716281667) {
                i13 = e11;
                f(d0Var, n13, e11, n12, i11, str, z10, drmInitData, dVar, i14);
            } else {
                if (n13 == 1414810956 || n13 == 1954034535 || n13 == 2004251764 || n13 == 1937010800 || n13 == 1664495672) {
                    x(d0Var, n13, e11, n12, i11, str, dVar);
                } else if (n13 == 1835365492) {
                    o(d0Var, n13, e11, i11, dVar);
                } else if (n13 == 1667329389) {
                    dVar.f70890b = new o1.b().R(i11).e0(MimeTypes.APPLICATION_CAMERA_MOTION).E();
                }
                i13 = e11;
            }
            d0Var.P(i13 + n12);
        }
        return dVar;
    }

    private static void x(d0 d0Var, int i11, int i12, int i13, int i14, String str, d dVar) {
        d0Var.P(i12 + 16);
        String str2 = MimeTypes.APPLICATION_TTML;
        ImmutableList immutableList = null;
        long j11 = Long.MAX_VALUE;
        if (i11 != 1414810956) {
            if (i11 == 1954034535) {
                int i15 = i13 - 16;
                byte[] bArr = new byte[i15];
                d0Var.j(bArr, 0, i15);
                immutableList = ImmutableList.of(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i11 == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i11 == 1937010800) {
                j11 = 0;
            } else {
                if (i11 != 1664495672) {
                    throw new IllegalStateException();
                }
                dVar.f70892d = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            }
        }
        dVar.f70890b = new o1.b().R(i14).e0(str2).V(str).i0(j11).T(immutableList).E();
    }

    private static g y(d0 d0Var) {
        long j11;
        d0Var.P(8);
        int c11 = o9.a.c(d0Var.n());
        d0Var.Q(c11 == 0 ? 8 : 16);
        int n11 = d0Var.n();
        d0Var.Q(4);
        int e11 = d0Var.e();
        int i11 = c11 == 0 ? 4 : 8;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            j11 = C.TIME_UNSET;
            if (i13 >= i11) {
                d0Var.Q(i11);
                break;
            }
            if (d0Var.d()[e11 + i13] != -1) {
                long F = c11 == 0 ? d0Var.F() : d0Var.I();
                if (F != 0) {
                    j11 = F;
                }
            } else {
                i13++;
            }
        }
        d0Var.Q(16);
        int n12 = d0Var.n();
        int n13 = d0Var.n();
        d0Var.Q(4);
        int n14 = d0Var.n();
        int n15 = d0Var.n();
        if (n12 == 0 && n13 == 65536 && n14 == -65536 && n15 == 0) {
            i12 = 90;
        } else if (n12 == 0 && n13 == -65536 && n14 == 65536 && n15 == 0) {
            i12 = 270;
        } else if (n12 == -65536 && n13 == 0 && n14 == 0 && n15 == -65536) {
            i12 = 180;
        }
        return new g(n11, j11, i12);
    }

    private static o z(a.C0886a c0886a, a.b bVar, long j11, DrmInitData drmInitData, boolean z10, boolean z11) {
        a.b bVar2;
        long j12;
        long[] jArr;
        long[] jArr2;
        a.C0886a f11;
        Pair h11;
        a.C0886a c0886a2 = (a.C0886a) com.google.android.exoplayer2.util.a.e(c0886a.f(1835297121));
        int d11 = d(k(((a.b) com.google.android.exoplayer2.util.a.e(c0886a2.g(1751411826))).f70874b));
        if (d11 == -1) {
            return null;
        }
        g y10 = y(((a.b) com.google.android.exoplayer2.util.a.e(c0886a.g(1953196132))).f70874b);
        long j13 = C.TIME_UNSET;
        if (j11 == C.TIME_UNSET) {
            bVar2 = bVar;
            j12 = y10.f70902b;
        } else {
            bVar2 = bVar;
            j12 = j11;
        }
        long p11 = p(bVar2.f70874b);
        if (j12 != C.TIME_UNSET) {
            j13 = p0.N0(j12, 1000000L, p11);
        }
        long j14 = j13;
        a.C0886a c0886a3 = (a.C0886a) com.google.android.exoplayer2.util.a.e(((a.C0886a) com.google.android.exoplayer2.util.a.e(c0886a2.f(1835626086))).f(1937007212));
        Pair m11 = m(((a.b) com.google.android.exoplayer2.util.a.e(c0886a2.g(1835296868))).f70874b);
        d w11 = w(((a.b) com.google.android.exoplayer2.util.a.e(c0886a3.g(1937011556))).f70874b, y10.f70901a, y10.f70903c, (String) m11.second, drmInitData, z11);
        if (z10 || (f11 = c0886a.f(1701082227)) == null || (h11 = h(f11)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) h11.first;
            jArr2 = (long[]) h11.second;
            jArr = jArr3;
        }
        if (w11.f70890b == null) {
            return null;
        }
        return new o(y10.f70901a, d11, ((Long) m11.first).longValue(), p11, j14, w11.f70890b, w11.f70892d, w11.f70889a, w11.f70891c, jArr, jArr2);
    }
}
