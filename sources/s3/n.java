package s3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class n implements m {

    /* renamed from: r, reason: collision with root package name */
    private static final double[] f75177r = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    private String f75178a;

    /* renamed from: b, reason: collision with root package name */
    private s0 f75179b;

    /* renamed from: c, reason: collision with root package name */
    private final n0 f75180c;

    /* renamed from: d, reason: collision with root package name */
    private final String f75181d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75182e;

    /* renamed from: f, reason: collision with root package name */
    private final w f75183f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean[] f75184g;

    /* renamed from: h, reason: collision with root package name */
    private final a f75185h;

    /* renamed from: i, reason: collision with root package name */
    private long f75186i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f75187j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f75188k;

    /* renamed from: l, reason: collision with root package name */
    private long f75189l;

    /* renamed from: m, reason: collision with root package name */
    private long f75190m;

    /* renamed from: n, reason: collision with root package name */
    private long f75191n;

    /* renamed from: o, reason: collision with root package name */
    private long f75192o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f75193p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f75194q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        private static final byte[] f75195e = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        private boolean f75196a;

        /* renamed from: b, reason: collision with root package name */
        public int f75197b;

        /* renamed from: c, reason: collision with root package name */
        public int f75198c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f75199d;

        public a(int i11) {
            this.f75199d = new byte[i11];
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f75196a) {
                int i13 = i12 - i11;
                byte[] bArr2 = this.f75199d;
                int length = bArr2.length;
                int i14 = this.f75197b;
                if (length < i14 + i13) {
                    this.f75199d = Arrays.copyOf(bArr2, (i14 + i13) * 2);
                }
                System.arraycopy(bArr, i11, this.f75199d, this.f75197b, i13);
                this.f75197b += i13;
            }
        }

        public boolean b(int i11, int i12) {
            if (this.f75196a) {
                int i13 = this.f75197b - i12;
                this.f75197b = i13;
                if (this.f75198c != 0 || i11 != 181) {
                    this.f75196a = false;
                    return true;
                }
                this.f75198c = i13;
            } else if (i11 == 179) {
                this.f75196a = true;
            }
            byte[] bArr = f75195e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f75196a = false;
            this.f75197b = 0;
            this.f75198c = 0;
        }
    }

    public n(String str) {
        this(null, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(n0 n0Var, String str) {
        this.f75180c = n0Var;
        this.f75181d = str;
        this.f75184g = new boolean[4];
        this.f75185h = new a(128);
        if (n0Var != null) {
            this.f75183f = new w(178, 128);
            this.f75182e = new androidx.media3.common.util.j0();
        } else {
            this.f75183f = null;
            this.f75182e = null;
        }
        this.f75190m = C.TIME_UNSET;
        this.f75192o = C.TIME_UNSET;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.util.Pair e(s3.n.a r8, java.lang.String r9, java.lang.String r10) {
        /*
            byte[] r0 = r8.f75199d
            int r1 = r8.f75197b
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            r4 = r0[r3]
            r5 = r4 & 255(0xff, float:3.57E-43)
            r6 = 6
            r6 = r0[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r5 = r5 >> r1
            r2 = r2 | r5
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r6
            r5 = 7
            r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L3e
            r7 = 3
            if (r6 == r7) goto L38
            if (r6 == r1) goto L30
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L44
        L30:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
        L35:
            float r6 = (float) r6
            float r1 = r1 / r6
            goto L44
        L38:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L35
        L3e:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
            goto L35
        L44:
            androidx.media3.common.r$b r6 = new androidx.media3.common.r$b
            r6.<init>()
            androidx.media3.common.r$b r9 = r6.f0(r9)
            androidx.media3.common.r$b r9 = r9.U(r10)
            java.lang.String r10 = "video/mpeg2"
            androidx.media3.common.r$b r9 = r9.u0(r10)
            androidx.media3.common.r$b r9 = r9.B0(r2)
            androidx.media3.common.r$b r9 = r9.d0(r4)
            androidx.media3.common.r$b r9 = r9.q0(r1)
            java.util.List r10 = java.util.Collections.singletonList(r0)
            androidx.media3.common.r$b r9 = r9.g0(r10)
            androidx.media3.common.r r9 = r9.N()
            r10 = r0[r5]
            r10 = r10 & 15
            int r10 = r10 + (-1)
            if (r10 < 0) goto L9c
            double[] r1 = s3.n.f75177r
            int r2 = r1.length
            if (r10 >= r2) goto L9c
            r4 = r1[r10]
            int r8 = r8.f75198c
            int r8 = r8 + 9
            r8 = r0[r8]
            r10 = r8 & 96
            int r10 = r10 >> r3
            r8 = r8 & 31
            if (r10 == r8) goto L94
            double r0 = (double) r10
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r0 = r0 + r2
            int r8 = r8 + 1
            double r2 = (double) r8
            double r0 = r0 / r2
            double r4 = r4 * r0
        L94:
            r0 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r0 = r0 / r4
            long r0 = (long) r0
            goto L9e
        L9c:
            r0 = 0
        L9e:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.n.e(s3.n$a, java.lang.String, java.lang.String):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012e  */
    @Override // s3.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(androidx.media3.common.util.j0 r21) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.n.a(androidx.media3.common.util.j0):void");
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75190m = j11;
    }

    @Override // s3.m
    public void c(boolean z10) {
        androidx.media3.common.util.a.i(this.f75179b);
        if (z10) {
            boolean z11 = this.f75193p;
            this.f75179b.d(this.f75192o, z11 ? 1 : 0, (int) (this.f75186i - this.f75191n), 0, null);
        }
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75178a = dVar.b();
        this.f75179b = tVar.track(dVar.c(), 2);
        n0 n0Var = this.f75180c;
        if (n0Var != null) {
            n0Var.b(tVar, dVar);
        }
    }

    @Override // s3.m
    public void seek() {
        androidx.media3.container.g.c(this.f75184g);
        this.f75185h.c();
        w wVar = this.f75183f;
        if (wVar != null) {
            wVar.d();
        }
        this.f75186i = 0L;
        this.f75187j = false;
        this.f75190m = C.TIME_UNSET;
        this.f75192o = C.TIME_UNSET;
    }
}
