package s3;

import android.util.SparseArray;
import androidx.media3.common.i;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.container.g;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class p implements m {

    /* renamed from: a, reason: collision with root package name */
    private final g0 f75230a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f75231b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f75232c;

    /* renamed from: d, reason: collision with root package name */
    private final String f75233d;

    /* renamed from: h, reason: collision with root package name */
    private long f75237h;

    /* renamed from: j, reason: collision with root package name */
    private String f75239j;

    /* renamed from: k, reason: collision with root package name */
    private s0 f75240k;

    /* renamed from: l, reason: collision with root package name */
    private b f75241l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f75242m;

    /* renamed from: o, reason: collision with root package name */
    private boolean f75244o;

    /* renamed from: i, reason: collision with root package name */
    private final boolean[] f75238i = new boolean[3];

    /* renamed from: e, reason: collision with root package name */
    private final w f75234e = new w(7, 128);

    /* renamed from: f, reason: collision with root package name */
    private final w f75235f = new w(8, 128);

    /* renamed from: g, reason: collision with root package name */
    private final w f75236g = new w(6, 128);

    /* renamed from: n, reason: collision with root package name */
    private long f75243n = C.TIME_UNSET;

    /* renamed from: p, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75245p = new androidx.media3.common.util.j0();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final s0 f75246a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f75247b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f75248c;

        /* renamed from: d, reason: collision with root package name */
        private final SparseArray f75249d = new SparseArray();

        /* renamed from: e, reason: collision with root package name */
        private final SparseArray f75250e = new SparseArray();

        /* renamed from: f, reason: collision with root package name */
        private final androidx.media3.container.h f75251f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f75252g;

        /* renamed from: h, reason: collision with root package name */
        private int f75253h;

        /* renamed from: i, reason: collision with root package name */
        private int f75254i;

        /* renamed from: j, reason: collision with root package name */
        private long f75255j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f75256k;

        /* renamed from: l, reason: collision with root package name */
        private long f75257l;

        /* renamed from: m, reason: collision with root package name */
        private a f75258m;

        /* renamed from: n, reason: collision with root package name */
        private a f75259n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f75260o;

        /* renamed from: p, reason: collision with root package name */
        private long f75261p;

        /* renamed from: q, reason: collision with root package name */
        private long f75262q;

        /* renamed from: r, reason: collision with root package name */
        private boolean f75263r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f75264s;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private boolean f75265a;

            /* renamed from: b, reason: collision with root package name */
            private boolean f75266b;

            /* renamed from: c, reason: collision with root package name */
            private g.m f75267c;

            /* renamed from: d, reason: collision with root package name */
            private int f75268d;

            /* renamed from: e, reason: collision with root package name */
            private int f75269e;

            /* renamed from: f, reason: collision with root package name */
            private int f75270f;

            /* renamed from: g, reason: collision with root package name */
            private int f75271g;

            /* renamed from: h, reason: collision with root package name */
            private boolean f75272h;

            /* renamed from: i, reason: collision with root package name */
            private boolean f75273i;

            /* renamed from: j, reason: collision with root package name */
            private boolean f75274j;

            /* renamed from: k, reason: collision with root package name */
            private boolean f75275k;

            /* renamed from: l, reason: collision with root package name */
            private int f75276l;

            /* renamed from: m, reason: collision with root package name */
            private int f75277m;

            /* renamed from: n, reason: collision with root package name */
            private int f75278n;

            /* renamed from: o, reason: collision with root package name */
            private int f75279o;

            /* renamed from: p, reason: collision with root package name */
            private int f75280p;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(a aVar) {
                int i11;
                int i12;
                int i13;
                boolean z10;
                if (!this.f75265a) {
                    return false;
                }
                if (!aVar.f75265a) {
                    return true;
                }
                g.m mVar = (g.m) androidx.media3.common.util.a.i(this.f75267c);
                g.m mVar2 = (g.m) androidx.media3.common.util.a.i(aVar.f75267c);
                return (this.f75270f == aVar.f75270f && this.f75271g == aVar.f75271g && this.f75272h == aVar.f75272h && (!this.f75273i || !aVar.f75273i || this.f75274j == aVar.f75274j) && (((i11 = this.f75268d) == (i12 = aVar.f75268d) || (i11 != 0 && i12 != 0)) && (((i13 = mVar.f10748n) != 0 || mVar2.f10748n != 0 || (this.f75277m == aVar.f75277m && this.f75278n == aVar.f75278n)) && ((i13 != 1 || mVar2.f10748n != 1 || (this.f75279o == aVar.f75279o && this.f75280p == aVar.f75280p)) && (z10 = this.f75275k) == aVar.f75275k && (!z10 || this.f75276l == aVar.f75276l))))) ? false : true;
            }

            public void b() {
                this.f75266b = false;
                this.f75265a = false;
            }

            public boolean d() {
                int i11;
                return this.f75266b && ((i11 = this.f75269e) == 7 || i11 == 2);
            }

            public void e(g.m mVar, int i11, int i12, int i13, int i14, boolean z10, boolean z11, boolean z12, boolean z13, int i15, int i16, int i17, int i18, int i19) {
                this.f75267c = mVar;
                this.f75268d = i11;
                this.f75269e = i12;
                this.f75270f = i13;
                this.f75271g = i14;
                this.f75272h = z10;
                this.f75273i = z11;
                this.f75274j = z12;
                this.f75275k = z13;
                this.f75276l = i15;
                this.f75277m = i16;
                this.f75278n = i17;
                this.f75279o = i18;
                this.f75280p = i19;
                this.f75265a = true;
                this.f75266b = true;
            }

            public void f(int i11) {
                this.f75269e = i11;
                this.f75266b = true;
            }
        }

        public b(s0 s0Var, boolean z10, boolean z11) {
            this.f75246a = s0Var;
            this.f75247b = z10;
            this.f75248c = z11;
            this.f75258m = new a();
            this.f75259n = new a();
            byte[] bArr = new byte[128];
            this.f75252g = bArr;
            this.f75251f = new androidx.media3.container.h(bArr, 0, 0);
            g();
        }

        private void d(int i11) {
            long j11 = this.f75262q;
            if (j11 != C.TIME_UNSET) {
                long j12 = this.f75255j;
                long j13 = this.f75261p;
                if (j12 == j13) {
                    return;
                }
                boolean z10 = this.f75263r;
                this.f75246a.d(j11, z10 ? 1 : 0, (int) (j12 - j13), i11, null);
            }
        }

        private void h() {
            boolean d11 = this.f75247b ? this.f75259n.d() : this.f75264s;
            boolean z10 = this.f75263r;
            int i11 = this.f75254i;
            boolean z11 = true;
            if (i11 != 5 && (!d11 || i11 != 1)) {
                z11 = false;
            }
            this.f75263r = z10 | z11;
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instructions count: 416
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: s3.p.b.a(byte[], int, int):void");
        }

        public boolean b(long j11, int i11, boolean z10) {
            if (this.f75254i == 9 || (this.f75248c && this.f75259n.c(this.f75258m))) {
                if (z10 && this.f75260o) {
                    d(i11 + ((int) (j11 - this.f75255j)));
                }
                this.f75261p = this.f75255j;
                this.f75262q = this.f75257l;
                this.f75263r = false;
                this.f75260o = true;
            }
            h();
            this.f75254i = 24;
            return this.f75263r;
        }

        public boolean c() {
            return this.f75248c;
        }

        public void e(g.l lVar) {
            this.f75250e.append(lVar.f10732a, lVar);
        }

        public void f(g.m mVar) {
            this.f75249d.append(mVar.f10738d, mVar);
        }

        public void g() {
            this.f75256k = false;
            this.f75260o = false;
            this.f75259n.b();
        }

        public void i(long j11, int i11, long j12, boolean z10) {
            this.f75254i = i11;
            this.f75257l = j12;
            this.f75255j = j11;
            this.f75264s = z10;
            if (!this.f75247b || i11 != 1) {
                if (!this.f75248c) {
                    return;
                }
                if (i11 != 5 && i11 != 1 && i11 != 2) {
                    return;
                }
            }
            a aVar = this.f75258m;
            this.f75258m = this.f75259n;
            this.f75259n = aVar;
            aVar.b();
            this.f75253h = 0;
            this.f75256k = true;
        }
    }

    public p(g0 g0Var, boolean z10, boolean z11, String str) {
        this.f75230a = g0Var;
        this.f75231b = z10;
        this.f75232c = z11;
        this.f75233d = str;
    }

    private void e() {
        androidx.media3.common.util.a.i(this.f75240k);
        a1.i(this.f75241l);
    }

    private void f(long j11, int i11, int i12, long j12) {
        if (!this.f75242m || this.f75241l.c()) {
            this.f75234e.b(i12);
            this.f75235f.b(i12);
            if (this.f75242m) {
                if (this.f75234e.c()) {
                    w wVar = this.f75234e;
                    g.m C = androidx.media3.container.g.C(wVar.f75385d, 3, wVar.f75386e);
                    this.f75230a.g(C.f10754t);
                    this.f75241l.f(C);
                    this.f75234e.d();
                } else if (this.f75235f.c()) {
                    w wVar2 = this.f75235f;
                    this.f75241l.e(androidx.media3.container.g.A(wVar2.f75385d, 3, wVar2.f75386e));
                    this.f75235f.d();
                }
            } else if (this.f75234e.c() && this.f75235f.c()) {
                ArrayList arrayList = new ArrayList();
                w wVar3 = this.f75234e;
                arrayList.add(Arrays.copyOf(wVar3.f75385d, wVar3.f75386e));
                w wVar4 = this.f75235f;
                arrayList.add(Arrays.copyOf(wVar4.f75385d, wVar4.f75386e));
                w wVar5 = this.f75234e;
                g.m C2 = androidx.media3.container.g.C(wVar5.f75385d, 3, wVar5.f75386e);
                w wVar6 = this.f75235f;
                g.l A = androidx.media3.container.g.A(wVar6.f75385d, 3, wVar6.f75386e);
                this.f75240k.c(new r.b().f0(this.f75239j).U(this.f75233d).u0(MimeTypes.VIDEO_H264).S(androidx.media3.common.util.j.d(C2.f10735a, C2.f10736b, C2.f10737c)).B0(C2.f10740f).d0(C2.f10741g).T(new i.b().d(C2.f10751q).c(C2.f10752r).e(C2.f10753s).g(C2.f10743i + 8).b(C2.f10744j + 8).a()).q0(C2.f10742h).g0(arrayList).l0(C2.f10754t).N());
                this.f75242m = true;
                this.f75230a.g(C2.f10754t);
                this.f75241l.f(C2);
                this.f75241l.e(A);
                this.f75234e.d();
                this.f75235f.d();
            }
        }
        if (this.f75236g.b(i12)) {
            w wVar7 = this.f75236g;
            this.f75245p.U(this.f75236g.f75385d, androidx.media3.container.g.L(wVar7.f75385d, wVar7.f75386e));
            this.f75245p.W(4);
            this.f75230a.c(j12, this.f75245p);
        }
        if (this.f75241l.b(j11, i11, this.f75242m)) {
            this.f75244o = false;
        }
    }

    private void g(byte[] bArr, int i11, int i12) {
        if (!this.f75242m || this.f75241l.c()) {
            this.f75234e.a(bArr, i11, i12);
            this.f75235f.a(bArr, i11, i12);
        }
        this.f75236g.a(bArr, i11, i12);
        this.f75241l.a(bArr, i11, i12);
    }

    private void h(long j11, int i11, long j12) {
        if (!this.f75242m || this.f75241l.c()) {
            this.f75234e.e(i11);
            this.f75235f.e(i11);
        }
        this.f75236g.e(i11);
        this.f75241l.i(j11, i11, j12, this.f75244o);
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        int i11;
        e();
        int f11 = j0Var.f();
        int g11 = j0Var.g();
        byte[] e11 = j0Var.e();
        this.f75237h += j0Var.a();
        this.f75240k.b(j0Var, j0Var.a());
        while (true) {
            int e12 = androidx.media3.container.g.e(e11, f11, g11, this.f75238i);
            if (e12 == g11) {
                g(e11, f11, g11);
                return;
            }
            int j11 = androidx.media3.container.g.j(e11, e12);
            if (e12 <= 0 || e11[e12 - 1] != 0) {
                i11 = 3;
            } else {
                e12--;
                i11 = 4;
            }
            int i12 = e12;
            int i13 = i11;
            int i14 = i12 - f11;
            if (i14 > 0) {
                g(e11, f11, i12);
            }
            int i15 = g11 - i12;
            long j12 = this.f75237h - i15;
            f(j12, i15, i14 < 0 ? -i14 : 0, this.f75243n);
            h(j12, j11, this.f75243n);
            f11 = i12 + i13;
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75243n = j11;
        this.f75244o |= (i11 & 2) != 0;
    }

    @Override // s3.m
    public void c(boolean z10) {
        e();
        if (z10) {
            this.f75230a.e();
            f(this.f75237h, 0, 0, this.f75243n);
            h(this.f75237h, 9, this.f75243n);
            f(this.f75237h, 0, 0, this.f75243n);
        }
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75239j = dVar.b();
        s0 track = tVar.track(dVar.c(), 2);
        this.f75240k = track;
        this.f75241l = new b(track, this.f75231b, this.f75232c);
        this.f75230a.d(tVar, dVar);
    }

    @Override // s3.m
    public void seek() {
        this.f75237h = 0L;
        this.f75244o = false;
        this.f75243n = C.TIME_UNSET;
        androidx.media3.container.g.c(this.f75238i);
        this.f75234e.d();
        this.f75235f.d();
        this.f75236g.d();
        this.f75230a.b();
        b bVar = this.f75241l;
        if (bVar != null) {
            bVar.g();
        }
    }
}
