package q9;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import q9.i0;

/* loaded from: classes4.dex */
public final class q implements m {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f73564a;

    /* renamed from: b, reason: collision with root package name */
    private String f73565b;

    /* renamed from: c, reason: collision with root package name */
    private g9.e0 f73566c;

    /* renamed from: d, reason: collision with root package name */
    private a f73567d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f73568e;

    /* renamed from: l, reason: collision with root package name */
    private long f73575l;

    /* renamed from: f, reason: collision with root package name */
    private final boolean[] f73569f = new boolean[3];

    /* renamed from: g, reason: collision with root package name */
    private final u f73570g = new u(32, 128);

    /* renamed from: h, reason: collision with root package name */
    private final u f73571h = new u(33, 128);

    /* renamed from: i, reason: collision with root package name */
    private final u f73572i = new u(34, 128);

    /* renamed from: j, reason: collision with root package name */
    private final u f73573j = new u(39, 128);

    /* renamed from: k, reason: collision with root package name */
    private final u f73574k = new u(40, 128);

    /* renamed from: m, reason: collision with root package name */
    private long f73576m = C.TIME_UNSET;

    /* renamed from: n, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73577n = new com.google.android.exoplayer2.util.d0();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final g9.e0 f73578a;

        /* renamed from: b, reason: collision with root package name */
        private long f73579b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f73580c;

        /* renamed from: d, reason: collision with root package name */
        private int f73581d;

        /* renamed from: e, reason: collision with root package name */
        private long f73582e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f73583f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f73584g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f73585h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f73586i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f73587j;

        /* renamed from: k, reason: collision with root package name */
        private long f73588k;

        /* renamed from: l, reason: collision with root package name */
        private long f73589l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f73590m;

        public a(g9.e0 e0Var) {
            this.f73578a = e0Var;
        }

        private static boolean b(int i11) {
            return (32 <= i11 && i11 <= 35) || i11 == 39;
        }

        private static boolean c(int i11) {
            return i11 < 32 || i11 == 40;
        }

        private void d(int i11) {
            long j11 = this.f73589l;
            if (j11 == C.TIME_UNSET) {
                return;
            }
            boolean z10 = this.f73590m;
            this.f73578a.d(j11, z10 ? 1 : 0, (int) (this.f73579b - this.f73588k), i11, null);
        }

        public void a(long j11, int i11, boolean z10) {
            if (this.f73587j && this.f73584g) {
                this.f73590m = this.f73580c;
                this.f73587j = false;
            } else if (this.f73585h || this.f73584g) {
                if (z10 && this.f73586i) {
                    d(i11 + ((int) (j11 - this.f73579b)));
                }
                this.f73588k = this.f73579b;
                this.f73589l = this.f73582e;
                this.f73590m = this.f73580c;
                this.f73586i = true;
            }
        }

        public void e(byte[] bArr, int i11, int i12) {
            if (this.f73583f) {
                int i13 = this.f73581d;
                int i14 = (i11 + 2) - i13;
                if (i14 >= i12) {
                    this.f73581d = i13 + (i12 - i11);
                } else {
                    this.f73584g = (bArr[i14] & 128) != 0;
                    this.f73583f = false;
                }
            }
        }

        public void f() {
            this.f73583f = false;
            this.f73584g = false;
            this.f73585h = false;
            this.f73586i = false;
            this.f73587j = false;
        }

        public void g(long j11, int i11, int i12, long j12, boolean z10) {
            this.f73584g = false;
            this.f73585h = false;
            this.f73582e = j12;
            this.f73581d = 0;
            this.f73579b = j11;
            if (!c(i12)) {
                if (this.f73586i && !this.f73587j) {
                    if (z10) {
                        d(i11);
                    }
                    this.f73586i = false;
                }
                if (b(i12)) {
                    this.f73585h = !this.f73587j;
                    this.f73587j = true;
                }
            }
            boolean z11 = i12 >= 16 && i12 <= 21;
            this.f73580c = z11;
            this.f73583f = z11 || i12 <= 9;
        }
    }

    public q(d0 d0Var) {
        this.f73564a = d0Var;
    }

    private void d() {
        com.google.android.exoplayer2.util.a.i(this.f73566c);
        p0.j(this.f73567d);
    }

    private void e(long j11, int i11, int i12, long j12) {
        this.f73567d.a(j11, i11, this.f73568e);
        if (!this.f73568e) {
            this.f73570g.b(i12);
            this.f73571h.b(i12);
            this.f73572i.b(i12);
            if (this.f73570g.c() && this.f73571h.c() && this.f73572i.c()) {
                this.f73566c.e(g(this.f73565b, this.f73570g, this.f73571h, this.f73572i));
                this.f73568e = true;
            }
        }
        if (this.f73573j.b(i12)) {
            u uVar = this.f73573j;
            this.f73577n.N(this.f73573j.f73633d, com.google.android.exoplayer2.util.x.q(uVar.f73633d, uVar.f73634e));
            this.f73577n.Q(5);
            this.f73564a.a(j12, this.f73577n);
        }
        if (this.f73574k.b(i12)) {
            u uVar2 = this.f73574k;
            this.f73577n.N(this.f73574k.f73633d, com.google.android.exoplayer2.util.x.q(uVar2.f73633d, uVar2.f73634e));
            this.f73577n.Q(5);
            this.f73564a.a(j12, this.f73577n);
        }
    }

    private void f(byte[] bArr, int i11, int i12) {
        this.f73567d.e(bArr, i11, i12);
        if (!this.f73568e) {
            this.f73570g.a(bArr, i11, i12);
            this.f73571h.a(bArr, i11, i12);
            this.f73572i.a(bArr, i11, i12);
        }
        this.f73573j.a(bArr, i11, i12);
        this.f73574k.a(bArr, i11, i12);
    }

    private static o1 g(String str, u uVar, u uVar2, u uVar3) {
        int i11 = uVar.f73634e;
        byte[] bArr = new byte[uVar2.f73634e + i11 + uVar3.f73634e];
        int i12 = 0;
        System.arraycopy(uVar.f73633d, 0, bArr, 0, i11);
        System.arraycopy(uVar2.f73633d, 0, bArr, uVar.f73634e, uVar2.f73634e);
        System.arraycopy(uVar3.f73633d, 0, bArr, uVar.f73634e + uVar2.f73634e, uVar3.f73634e);
        com.google.android.exoplayer2.util.e0 e0Var = new com.google.android.exoplayer2.util.e0(uVar2.f73633d, 0, uVar2.f73634e);
        e0Var.l(44);
        int e11 = e0Var.e(3);
        e0Var.k();
        int e12 = e0Var.e(2);
        boolean d11 = e0Var.d();
        int e13 = e0Var.e(5);
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i14 >= 32) {
                break;
            }
            if (e0Var.d()) {
                i13 |= 1 << i14;
            }
            i14++;
        }
        int[] iArr = new int[6];
        for (int i15 = 0; i15 < 6; i15++) {
            iArr[i15] = e0Var.e(8);
        }
        int e14 = e0Var.e(8);
        for (int i16 = 0; i16 < e11; i16++) {
            if (e0Var.d()) {
                i12 += 89;
            }
            if (e0Var.d()) {
                i12 += 8;
            }
        }
        e0Var.l(i12);
        if (e11 > 0) {
            e0Var.l((8 - e11) * 2);
        }
        e0Var.h();
        int h11 = e0Var.h();
        if (h11 == 3) {
            e0Var.k();
        }
        int h12 = e0Var.h();
        int h13 = e0Var.h();
        if (e0Var.d()) {
            int h14 = e0Var.h();
            int h15 = e0Var.h();
            int h16 = e0Var.h();
            int h17 = e0Var.h();
            h12 -= ((h11 == 1 || h11 == 2) ? 2 : 1) * (h14 + h15);
            h13 -= (h11 == 1 ? 2 : 1) * (h16 + h17);
        }
        e0Var.h();
        e0Var.h();
        int h18 = e0Var.h();
        for (int i17 = e0Var.d() ? 0 : e11; i17 <= e11; i17++) {
            e0Var.h();
            e0Var.h();
            e0Var.h();
        }
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        if (e0Var.d() && e0Var.d()) {
            h(e0Var);
        }
        e0Var.l(2);
        if (e0Var.d()) {
            e0Var.l(8);
            e0Var.h();
            e0Var.h();
            e0Var.k();
        }
        i(e0Var);
        if (e0Var.d()) {
            for (int i18 = 0; i18 < e0Var.h(); i18++) {
                e0Var.l(h18 + 5);
            }
        }
        e0Var.l(2);
        float f11 = 1.0f;
        if (e0Var.d()) {
            if (e0Var.d()) {
                int e15 = e0Var.e(8);
                if (e15 == 255) {
                    int e16 = e0Var.e(16);
                    int e17 = e0Var.e(16);
                    if (e16 != 0 && e17 != 0) {
                        f11 = e16 / e17;
                    }
                } else {
                    float[] fArr = com.google.android.exoplayer2.util.x.f27719b;
                    if (e15 < fArr.length) {
                        f11 = fArr[e15];
                    } else {
                        com.google.android.exoplayer2.util.s.i("H265Reader", "Unexpected aspect_ratio_idc value: " + e15);
                    }
                }
            }
            if (e0Var.d()) {
                e0Var.k();
            }
            if (e0Var.d()) {
                e0Var.l(4);
                if (e0Var.d()) {
                    e0Var.l(24);
                }
            }
            if (e0Var.d()) {
                e0Var.h();
                e0Var.h();
            }
            e0Var.k();
            if (e0Var.d()) {
                h13 *= 2;
            }
        }
        return new o1.b().S(str).e0(MimeTypes.VIDEO_H265).I(com.google.android.exoplayer2.util.f.c(e12, d11, e13, i13, iArr, e14)).j0(h12).Q(h13).a0(f11).T(Collections.singletonList(bArr)).E();
    }

    private static void h(com.google.android.exoplayer2.util.e0 e0Var) {
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = 0;
            while (i12 < 6) {
                int i13 = 1;
                if (e0Var.d()) {
                    int min = Math.min(64, 1 << ((i11 << 1) + 4));
                    if (i11 > 1) {
                        e0Var.g();
                    }
                    for (int i14 = 0; i14 < min; i14++) {
                        e0Var.g();
                    }
                } else {
                    e0Var.h();
                }
                if (i11 == 3) {
                    i13 = 3;
                }
                i12 += i13;
            }
        }
    }

    private static void i(com.google.android.exoplayer2.util.e0 e0Var) {
        int h11 = e0Var.h();
        boolean z10 = false;
        int i11 = 0;
        for (int i12 = 0; i12 < h11; i12++) {
            if (i12 != 0) {
                z10 = e0Var.d();
            }
            if (z10) {
                e0Var.k();
                e0Var.h();
                for (int i13 = 0; i13 <= i11; i13++) {
                    if (e0Var.d()) {
                        e0Var.k();
                    }
                }
            } else {
                int h12 = e0Var.h();
                int h13 = e0Var.h();
                int i14 = h12 + h13;
                for (int i15 = 0; i15 < h12; i15++) {
                    e0Var.h();
                    e0Var.k();
                }
                for (int i16 = 0; i16 < h13; i16++) {
                    e0Var.h();
                    e0Var.k();
                }
                i11 = i14;
            }
        }
    }

    private void j(long j11, int i11, int i12, long j12) {
        this.f73567d.g(j11, i11, i12, j12, this.f73568e);
        if (!this.f73568e) {
            this.f73570g.e(i12);
            this.f73571h.e(i12);
            this.f73572i.e(i12);
        }
        this.f73573j.e(i12);
        this.f73574k.e(i12);
    }

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        d();
        while (d0Var.a() > 0) {
            int e11 = d0Var.e();
            int f11 = d0Var.f();
            byte[] d11 = d0Var.d();
            this.f73575l += d0Var.a();
            this.f73566c.c(d0Var, d0Var.a());
            while (e11 < f11) {
                int c11 = com.google.android.exoplayer2.util.x.c(d11, e11, f11, this.f73569f);
                if (c11 == f11) {
                    f(d11, e11, f11);
                    return;
                }
                int e12 = com.google.android.exoplayer2.util.x.e(d11, c11);
                int i11 = c11 - e11;
                if (i11 > 0) {
                    f(d11, e11, c11);
                }
                int i12 = f11 - c11;
                long j11 = this.f73575l - i12;
                e(j11, i12, i11 < 0 ? -i11 : 0, this.f73576m);
                j(j11, i12, e12, this.f73576m);
                e11 = c11 + 3;
            }
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f73576m = j11;
        }
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        this.f73565b = dVar.b();
        g9.e0 track = nVar.track(dVar.c(), 2);
        this.f73566c = track;
        this.f73567d = new a(track);
        this.f73564a.b(nVar, dVar);
    }

    @Override // q9.m
    public void packetFinished() {
    }

    @Override // q9.m
    public void seek() {
        this.f73575l = 0L;
        this.f73576m = C.TIME_UNSET;
        com.google.android.exoplayer2.util.x.a(this.f73569f);
        this.f73570g.d();
        this.f73571h.d();
        this.f73572i.d();
        this.f73573j.d();
        this.f73574k.d();
        a aVar = this.f73567d;
        if (aVar != null) {
            aVar.f();
        }
    }
}
