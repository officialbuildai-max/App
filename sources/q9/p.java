package q9;

import android.util.SparseArray;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import q9.i0;

/* loaded from: classes4.dex */
public final class p implements m {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f73515a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f73516b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f73517c;

    /* renamed from: g, reason: collision with root package name */
    private long f73521g;

    /* renamed from: i, reason: collision with root package name */
    private String f73523i;

    /* renamed from: j, reason: collision with root package name */
    private g9.e0 f73524j;

    /* renamed from: k, reason: collision with root package name */
    private b f73525k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f73526l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f73528n;

    /* renamed from: h, reason: collision with root package name */
    private final boolean[] f73522h = new boolean[3];

    /* renamed from: d, reason: collision with root package name */
    private final u f73518d = new u(7, 128);

    /* renamed from: e, reason: collision with root package name */
    private final u f73519e = new u(8, 128);

    /* renamed from: f, reason: collision with root package name */
    private final u f73520f = new u(6, 128);

    /* renamed from: m, reason: collision with root package name */
    private long f73527m = C.TIME_UNSET;

    /* renamed from: o, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73529o = new com.google.android.exoplayer2.util.d0();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final g9.e0 f73530a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f73531b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f73532c;

        /* renamed from: d, reason: collision with root package name */
        private final SparseArray f73533d = new SparseArray();

        /* renamed from: e, reason: collision with root package name */
        private final SparseArray f73534e = new SparseArray();

        /* renamed from: f, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.e0 f73535f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f73536g;

        /* renamed from: h, reason: collision with root package name */
        private int f73537h;

        /* renamed from: i, reason: collision with root package name */
        private int f73538i;

        /* renamed from: j, reason: collision with root package name */
        private long f73539j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f73540k;

        /* renamed from: l, reason: collision with root package name */
        private long f73541l;

        /* renamed from: m, reason: collision with root package name */
        private a f73542m;

        /* renamed from: n, reason: collision with root package name */
        private a f73543n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f73544o;

        /* renamed from: p, reason: collision with root package name */
        private long f73545p;

        /* renamed from: q, reason: collision with root package name */
        private long f73546q;

        /* renamed from: r, reason: collision with root package name */
        private boolean f73547r;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private boolean f73548a;

            /* renamed from: b, reason: collision with root package name */
            private boolean f73549b;

            /* renamed from: c, reason: collision with root package name */
            private x.c f73550c;

            /* renamed from: d, reason: collision with root package name */
            private int f73551d;

            /* renamed from: e, reason: collision with root package name */
            private int f73552e;

            /* renamed from: f, reason: collision with root package name */
            private int f73553f;

            /* renamed from: g, reason: collision with root package name */
            private int f73554g;

            /* renamed from: h, reason: collision with root package name */
            private boolean f73555h;

            /* renamed from: i, reason: collision with root package name */
            private boolean f73556i;

            /* renamed from: j, reason: collision with root package name */
            private boolean f73557j;

            /* renamed from: k, reason: collision with root package name */
            private boolean f73558k;

            /* renamed from: l, reason: collision with root package name */
            private int f73559l;

            /* renamed from: m, reason: collision with root package name */
            private int f73560m;

            /* renamed from: n, reason: collision with root package name */
            private int f73561n;

            /* renamed from: o, reason: collision with root package name */
            private int f73562o;

            /* renamed from: p, reason: collision with root package name */
            private int f73563p;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(a aVar) {
                int i11;
                int i12;
                int i13;
                boolean z10;
                if (!this.f73548a) {
                    return false;
                }
                if (!aVar.f73548a) {
                    return true;
                }
                x.c cVar = (x.c) com.google.android.exoplayer2.util.a.i(this.f73550c);
                x.c cVar2 = (x.c) com.google.android.exoplayer2.util.a.i(aVar.f73550c);
                return (this.f73553f == aVar.f73553f && this.f73554g == aVar.f73554g && this.f73555h == aVar.f73555h && (!this.f73556i || !aVar.f73556i || this.f73557j == aVar.f73557j) && (((i11 = this.f73551d) == (i12 = aVar.f73551d) || (i11 != 0 && i12 != 0)) && (((i13 = cVar.f27746l) != 0 || cVar2.f27746l != 0 || (this.f73560m == aVar.f73560m && this.f73561n == aVar.f73561n)) && ((i13 != 1 || cVar2.f27746l != 1 || (this.f73562o == aVar.f73562o && this.f73563p == aVar.f73563p)) && (z10 = this.f73558k) == aVar.f73558k && (!z10 || this.f73559l == aVar.f73559l))))) ? false : true;
            }

            public void b() {
                this.f73549b = false;
                this.f73548a = false;
            }

            public boolean d() {
                int i11;
                return this.f73549b && ((i11 = this.f73552e) == 7 || i11 == 2);
            }

            public void e(x.c cVar, int i11, int i12, int i13, int i14, boolean z10, boolean z11, boolean z12, boolean z13, int i15, int i16, int i17, int i18, int i19) {
                this.f73550c = cVar;
                this.f73551d = i11;
                this.f73552e = i12;
                this.f73553f = i13;
                this.f73554g = i14;
                this.f73555h = z10;
                this.f73556i = z11;
                this.f73557j = z12;
                this.f73558k = z13;
                this.f73559l = i15;
                this.f73560m = i16;
                this.f73561n = i17;
                this.f73562o = i18;
                this.f73563p = i19;
                this.f73548a = true;
                this.f73549b = true;
            }

            public void f(int i11) {
                this.f73552e = i11;
                this.f73549b = true;
            }
        }

        public b(g9.e0 e0Var, boolean z10, boolean z11) {
            this.f73530a = e0Var;
            this.f73531b = z10;
            this.f73532c = z11;
            this.f73542m = new a();
            this.f73543n = new a();
            byte[] bArr = new byte[128];
            this.f73536g = bArr;
            this.f73535f = new com.google.android.exoplayer2.util.e0(bArr, 0, 0);
            g();
        }

        private void d(int i11) {
            long j11 = this.f73546q;
            if (j11 == C.TIME_UNSET) {
                return;
            }
            boolean z10 = this.f73547r;
            this.f73530a.d(j11, z10 ? 1 : 0, (int) (this.f73539j - this.f73545p), i11, null);
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
            throw new UnsupportedOperationException("Method not decompiled: q9.p.b.a(byte[], int, int):void");
        }

        public boolean b(long j11, int i11, boolean z10, boolean z11) {
            boolean z12 = false;
            if (this.f73538i == 9 || (this.f73532c && this.f73543n.c(this.f73542m))) {
                if (z10 && this.f73544o) {
                    d(i11 + ((int) (j11 - this.f73539j)));
                }
                this.f73545p = this.f73539j;
                this.f73546q = this.f73541l;
                this.f73547r = false;
                this.f73544o = true;
            }
            if (this.f73531b) {
                z11 = this.f73543n.d();
            }
            boolean z13 = this.f73547r;
            int i12 = this.f73538i;
            if (i12 == 5 || (z11 && i12 == 1)) {
                z12 = true;
            }
            boolean z14 = z13 | z12;
            this.f73547r = z14;
            return z14;
        }

        public boolean c() {
            return this.f73532c;
        }

        public void e(x.b bVar) {
            this.f73534e.append(bVar.f27732a, bVar);
        }

        public void f(x.c cVar) {
            this.f73533d.append(cVar.f27738d, cVar);
        }

        public void g() {
            this.f73540k = false;
            this.f73544o = false;
            this.f73543n.b();
        }

        public void h(long j11, int i11, long j12) {
            this.f73538i = i11;
            this.f73541l = j12;
            this.f73539j = j11;
            if (!this.f73531b || i11 != 1) {
                if (!this.f73532c) {
                    return;
                }
                if (i11 != 5 && i11 != 1 && i11 != 2) {
                    return;
                }
            }
            a aVar = this.f73542m;
            this.f73542m = this.f73543n;
            this.f73543n = aVar;
            aVar.b();
            this.f73537h = 0;
            this.f73540k = true;
        }
    }

    public p(d0 d0Var, boolean z10, boolean z11) {
        this.f73515a = d0Var;
        this.f73516b = z10;
        this.f73517c = z11;
    }

    private void d() {
        com.google.android.exoplayer2.util.a.i(this.f73524j);
        p0.j(this.f73525k);
    }

    private void e(long j11, int i11, int i12, long j12) {
        if (!this.f73526l || this.f73525k.c()) {
            this.f73518d.b(i12);
            this.f73519e.b(i12);
            if (this.f73526l) {
                if (this.f73518d.c()) {
                    u uVar = this.f73518d;
                    this.f73525k.f(com.google.android.exoplayer2.util.x.l(uVar.f73633d, 3, uVar.f73634e));
                    this.f73518d.d();
                } else if (this.f73519e.c()) {
                    u uVar2 = this.f73519e;
                    this.f73525k.e(com.google.android.exoplayer2.util.x.j(uVar2.f73633d, 3, uVar2.f73634e));
                    this.f73519e.d();
                }
            } else if (this.f73518d.c() && this.f73519e.c()) {
                ArrayList arrayList = new ArrayList();
                u uVar3 = this.f73518d;
                arrayList.add(Arrays.copyOf(uVar3.f73633d, uVar3.f73634e));
                u uVar4 = this.f73519e;
                arrayList.add(Arrays.copyOf(uVar4.f73633d, uVar4.f73634e));
                u uVar5 = this.f73518d;
                x.c l11 = com.google.android.exoplayer2.util.x.l(uVar5.f73633d, 3, uVar5.f73634e);
                u uVar6 = this.f73519e;
                x.b j13 = com.google.android.exoplayer2.util.x.j(uVar6.f73633d, 3, uVar6.f73634e);
                this.f73524j.e(new o1.b().S(this.f73523i).e0(MimeTypes.VIDEO_H264).I(com.google.android.exoplayer2.util.f.a(l11.f27735a, l11.f27736b, l11.f27737c)).j0(l11.f27740f).Q(l11.f27741g).a0(l11.f27742h).T(arrayList).E());
                this.f73526l = true;
                this.f73525k.f(l11);
                this.f73525k.e(j13);
                this.f73518d.d();
                this.f73519e.d();
            }
        }
        if (this.f73520f.b(i12)) {
            u uVar7 = this.f73520f;
            this.f73529o.N(this.f73520f.f73633d, com.google.android.exoplayer2.util.x.q(uVar7.f73633d, uVar7.f73634e));
            this.f73529o.P(4);
            this.f73515a.a(j12, this.f73529o);
        }
        if (this.f73525k.b(j11, i11, this.f73526l, this.f73528n)) {
            this.f73528n = false;
        }
    }

    private void f(byte[] bArr, int i11, int i12) {
        if (!this.f73526l || this.f73525k.c()) {
            this.f73518d.a(bArr, i11, i12);
            this.f73519e.a(bArr, i11, i12);
        }
        this.f73520f.a(bArr, i11, i12);
        this.f73525k.a(bArr, i11, i12);
    }

    private void g(long j11, int i11, long j12) {
        if (!this.f73526l || this.f73525k.c()) {
            this.f73518d.e(i11);
            this.f73519e.e(i11);
        }
        this.f73520f.e(i11);
        this.f73525k.h(j11, i11, j12);
    }

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        d();
        int e11 = d0Var.e();
        int f11 = d0Var.f();
        byte[] d11 = d0Var.d();
        this.f73521g += d0Var.a();
        this.f73524j.c(d0Var, d0Var.a());
        while (true) {
            int c11 = com.google.android.exoplayer2.util.x.c(d11, e11, f11, this.f73522h);
            if (c11 == f11) {
                f(d11, e11, f11);
                return;
            }
            int f12 = com.google.android.exoplayer2.util.x.f(d11, c11);
            int i11 = c11 - e11;
            if (i11 > 0) {
                f(d11, e11, c11);
            }
            int i12 = f11 - c11;
            long j11 = this.f73521g - i12;
            e(j11, i12, i11 < 0 ? -i11 : 0, this.f73527m);
            g(j11, f12, this.f73527m);
            e11 = c11 + 3;
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f73527m = j11;
        }
        this.f73528n |= (i11 & 2) != 0;
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        this.f73523i = dVar.b();
        g9.e0 track = nVar.track(dVar.c(), 2);
        this.f73524j = track;
        this.f73525k = new b(track, this.f73516b, this.f73517c);
        this.f73515a.b(nVar, dVar);
    }

    @Override // q9.m
    public void packetFinished() {
    }

    @Override // q9.m
    public void seek() {
        this.f73521g = 0L;
        this.f73528n = false;
        this.f73527m = C.TIME_UNSET;
        com.google.android.exoplayer2.util.x.a(this.f73522h);
        this.f73518d.d();
        this.f73519e.d();
        this.f73520f.d();
        b bVar = this.f73525k;
        if (bVar != null) {
            bVar.g();
        }
    }
}
