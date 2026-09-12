package s3;

import androidx.media3.common.i;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.container.g;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class q implements m {

    /* renamed from: a, reason: collision with root package name */
    private final g0 f75281a;

    /* renamed from: b, reason: collision with root package name */
    private final String f75282b;

    /* renamed from: c, reason: collision with root package name */
    private String f75283c;

    /* renamed from: d, reason: collision with root package name */
    private s0 f75284d;

    /* renamed from: e, reason: collision with root package name */
    private a f75285e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f75286f;

    /* renamed from: m, reason: collision with root package name */
    private long f75293m;

    /* renamed from: g, reason: collision with root package name */
    private final boolean[] f75287g = new boolean[3];

    /* renamed from: h, reason: collision with root package name */
    private final w f75288h = new w(32, 128);

    /* renamed from: i, reason: collision with root package name */
    private final w f75289i = new w(33, 128);

    /* renamed from: j, reason: collision with root package name */
    private final w f75290j = new w(34, 128);

    /* renamed from: k, reason: collision with root package name */
    private final w f75291k = new w(39, 128);

    /* renamed from: l, reason: collision with root package name */
    private final w f75292l = new w(40, 128);

    /* renamed from: n, reason: collision with root package name */
    private long f75294n = C.TIME_UNSET;

    /* renamed from: o, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75295o = new androidx.media3.common.util.j0();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final s0 f75296a;

        /* renamed from: b, reason: collision with root package name */
        private long f75297b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f75298c;

        /* renamed from: d, reason: collision with root package name */
        private int f75299d;

        /* renamed from: e, reason: collision with root package name */
        private long f75300e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f75301f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f75302g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f75303h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f75304i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f75305j;

        /* renamed from: k, reason: collision with root package name */
        private long f75306k;

        /* renamed from: l, reason: collision with root package name */
        private long f75307l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f75308m;

        public a(s0 s0Var) {
            this.f75296a = s0Var;
        }

        private static boolean b(int i11) {
            return (32 <= i11 && i11 <= 35) || i11 == 39;
        }

        private static boolean c(int i11) {
            return i11 < 32 || i11 == 40;
        }

        private void d(int i11) {
            long j11 = this.f75307l;
            if (j11 != C.TIME_UNSET) {
                long j12 = this.f75297b;
                long j13 = this.f75306k;
                if (j12 == j13) {
                    return;
                }
                boolean z10 = this.f75308m;
                this.f75296a.d(j11, z10 ? 1 : 0, (int) (j12 - j13), i11, null);
            }
        }

        public void a(long j11, int i11, boolean z10) {
            if (this.f75305j && this.f75302g) {
                this.f75308m = this.f75298c;
                this.f75305j = false;
            } else if (this.f75303h || this.f75302g) {
                if (z10 && this.f75304i) {
                    d(i11 + ((int) (j11 - this.f75297b)));
                }
                this.f75306k = this.f75297b;
                this.f75307l = this.f75300e;
                this.f75308m = this.f75298c;
                this.f75304i = true;
            }
        }

        public void e(byte[] bArr, int i11, int i12) {
            if (this.f75301f) {
                int i13 = this.f75299d;
                int i14 = (i11 + 2) - i13;
                if (i14 >= i12) {
                    this.f75299d = i13 + (i12 - i11);
                } else {
                    this.f75302g = (bArr[i14] & 128) != 0;
                    this.f75301f = false;
                }
            }
        }

        public void f() {
            this.f75301f = false;
            this.f75302g = false;
            this.f75303h = false;
            this.f75304i = false;
            this.f75305j = false;
        }

        public void g(long j11, int i11, int i12, long j12, boolean z10) {
            this.f75302g = false;
            this.f75303h = false;
            this.f75300e = j12;
            this.f75299d = 0;
            this.f75297b = j11;
            if (!c(i12)) {
                if (this.f75304i && !this.f75305j) {
                    if (z10) {
                        d(i11);
                    }
                    this.f75304i = false;
                }
                if (b(i12)) {
                    this.f75303h = !this.f75305j;
                    this.f75305j = true;
                }
            }
            boolean z11 = i12 >= 16 && i12 <= 21;
            this.f75298c = z11;
            this.f75301f = z11 || i12 <= 9;
        }
    }

    public q(g0 g0Var, String str) {
        this.f75281a = g0Var;
        this.f75282b = str;
    }

    private void e() {
        androidx.media3.common.util.a.i(this.f75284d);
        a1.i(this.f75285e);
    }

    private void f(long j11, int i11, int i12, long j12) {
        this.f75285e.a(j11, i11, this.f75286f);
        if (!this.f75286f) {
            this.f75288h.b(i12);
            this.f75289i.b(i12);
            this.f75290j.b(i12);
            if (this.f75288h.c() && this.f75289i.c() && this.f75290j.c()) {
                androidx.media3.common.r h11 = h(this.f75283c, this.f75288h, this.f75289i, this.f75290j, this.f75282b);
                this.f75284d.c(h11);
                com.google.common.base.m.u(h11.f10245q != -1);
                this.f75281a.g(h11.f10245q);
                this.f75286f = true;
            }
        }
        if (this.f75291k.b(i12)) {
            w wVar = this.f75291k;
            this.f75295o.U(this.f75291k.f75385d, androidx.media3.container.g.L(wVar.f75385d, wVar.f75386e));
            this.f75295o.X(5);
            this.f75281a.c(j12, this.f75295o);
        }
        if (this.f75292l.b(i12)) {
            w wVar2 = this.f75292l;
            this.f75295o.U(this.f75292l.f75385d, androidx.media3.container.g.L(wVar2.f75385d, wVar2.f75386e));
            this.f75295o.X(5);
            this.f75281a.c(j12, this.f75295o);
        }
    }

    private void g(byte[] bArr, int i11, int i12) {
        this.f75285e.e(bArr, i11, i12);
        if (!this.f75286f) {
            this.f75288h.a(bArr, i11, i12);
            this.f75289i.a(bArr, i11, i12);
            this.f75290j.a(bArr, i11, i12);
        }
        this.f75291k.a(bArr, i11, i12);
        this.f75292l.a(bArr, i11, i12);
    }

    private static androidx.media3.common.r h(String str, w wVar, w wVar2, w wVar3, String str2) {
        int i11 = wVar.f75386e;
        byte[] bArr = new byte[wVar2.f75386e + i11 + wVar3.f75386e];
        System.arraycopy(wVar.f75385d, 0, bArr, 0, i11);
        System.arraycopy(wVar2.f75385d, 0, bArr, wVar.f75386e, wVar2.f75386e);
        System.arraycopy(wVar3.f75385d, 0, bArr, wVar.f75386e + wVar2.f75386e, wVar3.f75386e);
        g.h u11 = androidx.media3.container.g.u(wVar2.f75385d, 3, wVar2.f75386e, null);
        g.c cVar = u11.f10710c;
        return new r.b().f0(str).U(str2).u0(MimeTypes.VIDEO_H265).S(cVar != null ? androidx.media3.common.util.j.f(cVar.f10684a, cVar.f10685b, cVar.f10686c, cVar.f10687d, cVar.f10688e, cVar.f10689f) : null).B0(u11.f10715h).d0(u11.f10716i).T(new i.b().d(u11.f10719l).c(u11.f10720m).e(u11.f10721n).g(u11.f10712e + 8).b(u11.f10713f + 8).a()).q0(u11.f10717j).l0(u11.f10718k).m0(u11.f10709b + 1).g0(Collections.singletonList(bArr)).N();
    }

    private void i(long j11, int i11, int i12, long j12) {
        this.f75285e.g(j11, i11, i12, j12, this.f75286f);
        if (!this.f75286f) {
            this.f75288h.e(i12);
            this.f75289i.e(i12);
            this.f75290j.e(i12);
        }
        this.f75291k.e(i12);
        this.f75292l.e(i12);
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        int i11;
        e();
        while (j0Var.a() > 0) {
            int f11 = j0Var.f();
            int g11 = j0Var.g();
            byte[] e11 = j0Var.e();
            this.f75293m += j0Var.a();
            this.f75284d.b(j0Var, j0Var.a());
            while (f11 < g11) {
                int e12 = androidx.media3.container.g.e(e11, f11, g11, this.f75287g);
                if (e12 == g11) {
                    g(e11, f11, g11);
                    return;
                }
                int i12 = androidx.media3.container.g.i(e11, e12);
                if (e12 <= 0 || e11[e12 - 1] != 0) {
                    i11 = 3;
                } else {
                    e12--;
                    i11 = 4;
                }
                int i13 = e12;
                int i14 = i11;
                int i15 = i13 - f11;
                if (i15 > 0) {
                    g(e11, f11, i13);
                }
                int i16 = g11 - i13;
                long j11 = this.f75293m - i16;
                f(j11, i16, i15 < 0 ? -i15 : 0, this.f75294n);
                i(j11, i16, i12, this.f75294n);
                f11 = i13 + i14;
            }
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75294n = j11;
    }

    @Override // s3.m
    public void c(boolean z10) {
        e();
        if (z10) {
            this.f75281a.e();
            f(this.f75293m, 0, 0, this.f75294n);
            i(this.f75293m, 0, 48, this.f75294n);
        }
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75283c = dVar.b();
        s0 track = tVar.track(dVar.c(), 2);
        this.f75284d = track;
        this.f75285e = new a(track);
        this.f75281a.d(tVar, dVar);
    }

    @Override // s3.m
    public void seek() {
        this.f75293m = 0L;
        this.f75294n = C.TIME_UNSET;
        androidx.media3.container.g.c(this.f75287g);
        this.f75288h.d();
        this.f75289i.d();
        this.f75290j.d();
        this.f75291k.d();
        this.f75292l.d();
        this.f75281a.b();
        a aVar = this.f75285e;
        if (aVar != null) {
            aVar.f();
        }
    }
}
