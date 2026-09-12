package q9;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import q9.i0;

/* loaded from: classes4.dex */
public final class n implements m {

    /* renamed from: q, reason: collision with root package name */
    private static final double[] f73467q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    private String f73468a;

    /* renamed from: b, reason: collision with root package name */
    private g9.e0 f73469b;

    /* renamed from: c, reason: collision with root package name */
    private final k0 f73470c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73471d;

    /* renamed from: e, reason: collision with root package name */
    private final u f73472e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean[] f73473f;

    /* renamed from: g, reason: collision with root package name */
    private final a f73474g;

    /* renamed from: h, reason: collision with root package name */
    private long f73475h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f73476i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f73477j;

    /* renamed from: k, reason: collision with root package name */
    private long f73478k;

    /* renamed from: l, reason: collision with root package name */
    private long f73479l;

    /* renamed from: m, reason: collision with root package name */
    private long f73480m;

    /* renamed from: n, reason: collision with root package name */
    private long f73481n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f73482o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f73483p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        private static final byte[] f73484e = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        private boolean f73485a;

        /* renamed from: b, reason: collision with root package name */
        public int f73486b;

        /* renamed from: c, reason: collision with root package name */
        public int f73487c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f73488d;

        public a(int i11) {
            this.f73488d = new byte[i11];
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f73485a) {
                int i13 = i12 - i11;
                byte[] bArr2 = this.f73488d;
                int length = bArr2.length;
                int i14 = this.f73486b;
                if (length < i14 + i13) {
                    this.f73488d = Arrays.copyOf(bArr2, (i14 + i13) * 2);
                }
                System.arraycopy(bArr, i11, this.f73488d, this.f73486b, i13);
                this.f73486b += i13;
            }
        }

        public boolean b(int i11, int i12) {
            if (this.f73485a) {
                int i13 = this.f73486b - i12;
                this.f73486b = i13;
                if (this.f73487c != 0 || i11 != 181) {
                    this.f73485a = false;
                    return true;
                }
                this.f73487c = i13;
            } else if (i11 == 179) {
                this.f73485a = true;
            }
            byte[] bArr = f73484e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f73485a = false;
            this.f73486b = 0;
            this.f73487c = 0;
        }
    }

    public n() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k0 k0Var) {
        this.f73470c = k0Var;
        this.f73473f = new boolean[4];
        this.f73474g = new a(128);
        if (k0Var != null) {
            this.f73472e = new u(178, 128);
            this.f73471d = new com.google.android.exoplayer2.util.d0();
        } else {
            this.f73472e = null;
            this.f73471d = null;
        }
        this.f73479l = C.TIME_UNSET;
        this.f73481n = C.TIME_UNSET;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.util.Pair d(q9.n.a r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f73488d
            int r1 = r8.f73486b
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
            com.google.android.exoplayer2.o1$b r6 = new com.google.android.exoplayer2.o1$b
            r6.<init>()
            com.google.android.exoplayer2.o1$b r9 = r6.S(r9)
            java.lang.String r6 = "video/mpeg2"
            com.google.android.exoplayer2.o1$b r9 = r9.e0(r6)
            com.google.android.exoplayer2.o1$b r9 = r9.j0(r2)
            com.google.android.exoplayer2.o1$b r9 = r9.Q(r4)
            com.google.android.exoplayer2.o1$b r9 = r9.a0(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            com.google.android.exoplayer2.o1$b r9 = r9.T(r1)
            com.google.android.exoplayer2.o1 r9 = r9.E()
            r1 = r0[r5]
            r1 = r1 & 15
            int r1 = r1 + (-1)
            if (r1 < 0) goto L98
            double[] r2 = q9.n.f73467q
            int r4 = r2.length
            if (r1 >= r4) goto L98
            r1 = r2[r1]
            int r8 = r8.f73487c
            int r8 = r8 + 9
            r8 = r0[r8]
            r0 = r8 & 96
            int r0 = r0 >> r3
            r8 = r8 & 31
            if (r0 == r8) goto L90
            double r3 = (double) r0
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L90:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r0 = (long) r3
            goto L9a
        L98:
            r0 = 0
        L9a:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.n.d(q9.n$a, java.lang.String):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c  */
    @Override // q9.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.google.android.exoplayer2.util.d0 r21) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.n.a(com.google.android.exoplayer2.util.d0):void");
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        this.f73479l = j11;
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        this.f73468a = dVar.b();
        this.f73469b = nVar.track(dVar.c(), 2);
        k0 k0Var = this.f73470c;
        if (k0Var != null) {
            k0Var.b(nVar, dVar);
        }
    }

    @Override // q9.m
    public void packetFinished() {
    }

    @Override // q9.m
    public void seek() {
        com.google.android.exoplayer2.util.x.a(this.f73473f);
        this.f73474g.c();
        u uVar = this.f73472e;
        if (uVar != null) {
            uVar.d();
        }
        this.f73475h = 0L;
        this.f73476i = false;
        this.f73479l = C.TIME_UNSET;
        this.f73481n = C.TIME_UNSET;
    }
}
