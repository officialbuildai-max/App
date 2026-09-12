package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.media3.common.ParserException;
import androidx.media3.common.e0;
import androidx.media3.common.t;
import androidx.media3.common.x;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.h;
import androidx.media3.exoplayer.n;
import androidx.media3.exoplayer.q3;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.t3;
import androidx.media3.exoplayer.u2;
import androidx.media3.exoplayer.v2;
import androidx.media3.exoplayer.w3;
import androidx.media3.exoplayer.y2;
import androidx.media3.exoplayer.y3;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j2.e0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r2 implements Handler.Callback, q.a, e0.a, q3.d, n.a, t3.a, h.a {

    /* renamed from: e0, reason: collision with root package name */
    private static final long f12570e0 = androidx.media3.common.util.a1.y1(10000);
    private final boolean A;
    private final androidx.media3.exoplayer.h B;
    private c4 C;
    private r3 D;
    private e E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean K;
    private int L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private int Q;
    private h R;
    private long S;
    private long T;
    private int U;
    private boolean V;
    private ExoPlaybackException W;
    private long X;
    private ExoPlayer.c Z;

    /* renamed from: a, reason: collision with root package name */
    private final a4[] f12571a;

    /* renamed from: b, reason: collision with root package name */
    private final y3[] f12573b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean[] f12575c;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f12576c0;

    /* renamed from: d, reason: collision with root package name */
    private final j2.e0 f12577d;

    /* renamed from: e, reason: collision with root package name */
    private final j2.f0 f12579e;

    /* renamed from: f, reason: collision with root package name */
    private final u2 f12580f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.e f12581g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.media3.common.util.p f12582h;

    /* renamed from: i, reason: collision with root package name */
    private final s3 f12583i;

    /* renamed from: j, reason: collision with root package name */
    private final Looper f12584j;

    /* renamed from: k, reason: collision with root package name */
    private final e0.c f12585k;

    /* renamed from: l, reason: collision with root package name */
    private final e0.b f12586l;

    /* renamed from: m, reason: collision with root package name */
    private final long f12587m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f12588n;

    /* renamed from: o, reason: collision with root package name */
    private final n f12589o;

    /* renamed from: p, reason: collision with root package name */
    private final ArrayList f12590p;

    /* renamed from: q, reason: collision with root package name */
    private final androidx.media3.common.util.i f12591q;

    /* renamed from: r, reason: collision with root package name */
    private final f f12592r;

    /* renamed from: s, reason: collision with root package name */
    private final b3 f12593s;

    /* renamed from: t, reason: collision with root package name */
    private final q3 f12594t;

    /* renamed from: u, reason: collision with root package name */
    private final t2 f12595u;

    /* renamed from: v, reason: collision with root package name */
    private final long f12596v;

    /* renamed from: w, reason: collision with root package name */
    private final y1.f4 f12597w;

    /* renamed from: x, reason: collision with root package name */
    private final boolean f12598x;

    /* renamed from: y, reason: collision with root package name */
    private final y1.a f12599y;

    /* renamed from: z, reason: collision with root package name */
    private final androidx.media3.common.util.p f12600z;

    /* renamed from: b0, reason: collision with root package name */
    private long f12574b0 = C.TIME_UNSET;

    /* renamed from: d0, reason: collision with root package name */
    private float f12578d0 = 1.0f;
    private long Y = C.TIME_UNSET;
    private long J = C.TIME_UNSET;

    /* renamed from: a0, reason: collision with root package name */
    private androidx.media3.common.e0 f12572a0 = androidx.media3.common.e0.f10007a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements w3.a {
        a() {
        }

        @Override // androidx.media3.exoplayer.w3.a
        public void a() {
            r2.this.O = true;
        }

        @Override // androidx.media3.exoplayer.w3.a
        public void b() {
            if (r2.this.f12598x || r2.this.P) {
                r2.this.f12582h.sendEmptyMessage(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List f12602a;

        /* renamed from: b, reason: collision with root package name */
        private final g2.v f12603b;

        /* renamed from: c, reason: collision with root package name */
        private final int f12604c;

        /* renamed from: d, reason: collision with root package name */
        private final long f12605d;

        private b(List list, g2.v vVar, int i11, long j11) {
            this.f12602a = list;
            this.f12603b = vVar;
            this.f12604c = i11;
            this.f12605d = j11;
        }

        /* synthetic */ b(List list, g2.v vVar, int i11, long j11, a aVar) {
            this(list, vVar, i11, j11);
        }
    }

    /* loaded from: classes2.dex */
    private static class c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final t3 f12606a;

        /* renamed from: b, reason: collision with root package name */
        public int f12607b;

        /* renamed from: c, reason: collision with root package name */
        public long f12608c;

        /* renamed from: d, reason: collision with root package name */
        public Object f12609d;

        public d(t3 t3Var) {
            this.f12606a = t3Var;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.f12609d;
            if ((obj == null) != (dVar.f12609d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i11 = this.f12607b - dVar.f12607b;
            return i11 != 0 ? i11 : androidx.media3.common.util.a1.n(this.f12608c, dVar.f12608c);
        }

        public void b(int i11, long j11, Object obj) {
            this.f12607b = i11;
            this.f12608c = j11;
            this.f12609d = obj;
        }
    }

    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private boolean f12610a;

        /* renamed from: b, reason: collision with root package name */
        public r3 f12611b;

        /* renamed from: c, reason: collision with root package name */
        public int f12612c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f12613d;

        /* renamed from: e, reason: collision with root package name */
        public int f12614e;

        public e(r3 r3Var) {
            this.f12611b = r3Var;
        }

        public void b(int i11) {
            this.f12610a |= i11 > 0;
            this.f12612c += i11;
        }

        public void c(r3 r3Var) {
            this.f12610a |= this.f12611b != r3Var;
            this.f12611b = r3Var;
        }

        public void d(int i11) {
            if (this.f12613d && this.f12614e != 5) {
                androidx.media3.common.util.a.a(i11 == 5);
                return;
            }
            this.f12610a = true;
            this.f12613d = true;
            this.f12614e = i11;
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final r.b f12615a;

        /* renamed from: b, reason: collision with root package name */
        public final long f12616b;

        /* renamed from: c, reason: collision with root package name */
        public final long f12617c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f12618d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f12619e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f12620f;

        public g(r.b bVar, long j11, long j12, boolean z10, boolean z11, boolean z12) {
            this.f12615a = bVar;
            this.f12616b = j11;
            this.f12617c = j12;
            this.f12618d = z10;
            this.f12619e = z11;
            this.f12620f = z12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.e0 f12621a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12622b;

        /* renamed from: c, reason: collision with root package name */
        public final long f12623c;

        public h(androidx.media3.common.e0 e0Var, int i11, long j11) {
            this.f12621a = e0Var;
            this.f12622b = i11;
            this.f12623c = j11;
        }
    }

    public r2(Context context, w3[] w3VarArr, w3[] w3VarArr2, j2.e0 e0Var, j2.f0 f0Var, u2 u2Var, androidx.media3.exoplayer.upstream.e eVar, int i11, boolean z10, y1.a aVar, c4 c4Var, t2 t2Var, long j11, boolean z11, boolean z12, Looper looper, androidx.media3.common.util.i iVar, f fVar, y1.f4 f4Var, s3 s3Var, ExoPlayer.c cVar) {
        this.f12592r = fVar;
        this.f12577d = e0Var;
        this.f12579e = f0Var;
        this.f12580f = u2Var;
        this.f12581g = eVar;
        this.L = i11;
        this.M = z10;
        this.C = c4Var;
        this.f12595u = t2Var;
        this.f12596v = j11;
        this.X = j11;
        this.G = z11;
        this.f12598x = z12;
        this.f12591q = iVar;
        this.f12597w = f4Var;
        this.Z = cVar;
        this.f12599y = aVar;
        this.f12587m = u2Var.h(f4Var);
        this.f12588n = u2Var.i(f4Var);
        r3 k11 = r3.k(f0Var);
        this.D = k11;
        this.E = new e(k11);
        this.f12573b = new y3[w3VarArr.length];
        this.f12575c = new boolean[w3VarArr.length];
        y3.a d11 = e0Var.d();
        this.f12571a = new a4[w3VarArr.length];
        boolean z13 = false;
        for (int i12 = 0; i12 < w3VarArr.length; i12++) {
            w3VarArr[i12].g(i12, f4Var, iVar);
            this.f12573b[i12] = w3VarArr[i12].getCapabilities();
            if (d11 != null) {
                this.f12573b[i12].n(d11);
            }
            w3 w3Var = w3VarArr2[i12];
            if (w3Var != null) {
                w3Var.g(w3VarArr.length + i12, f4Var, iVar);
                z13 = true;
            }
            this.f12571a[i12] = new a4(w3VarArr[i12], w3VarArr2[i12], i12);
        }
        this.A = z13;
        this.f12589o = new n(this, iVar);
        this.f12590p = new ArrayList();
        this.f12585k = new e0.c();
        this.f12586l = new e0.b();
        e0Var.e(this, eVar);
        this.V = true;
        androidx.media3.common.util.p createHandler = iVar.createHandler(looper, null);
        this.f12600z = createHandler;
        this.f12593s = new b3(aVar, createHandler, new y2.a() { // from class: androidx.media3.exoplayer.o2
            @Override // androidx.media3.exoplayer.y2.a
            public final y2 a(z2 z2Var, long j12) {
                y2 v11;
                v11 = r2.this.v(z2Var, j12);
                return v11;
            }
        }, cVar);
        this.f12594t = new q3(this, aVar, createHandler, f4Var);
        s3 s3Var2 = s3Var == null ? new s3() : s3Var;
        this.f12583i = s3Var2;
        Looper a11 = s3Var2.a();
        this.f12584j = a11;
        this.f12582h = iVar.createHandler(a11, this);
        this.B = new androidx.media3.exoplayer.h(context, a11, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A() {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.r2.A():void");
    }

    private void A1(float f11) {
        this.f12578d0 = f11;
        float f12 = f11 * this.B.f();
        for (a4 a4Var : this.f12571a) {
            a4Var.T(f12);
        }
    }

    private void B(y2 y2Var, int i11, boolean z10, long j11) {
        a4 a4Var = this.f12571a[i11];
        if (a4Var.x()) {
            return;
        }
        boolean z11 = y2Var == this.f12593s.u();
        j2.f0 p11 = y2Var.p();
        z3 z3Var = p11.f65878b[i11];
        j2.z zVar = p11.f65879c[i11];
        boolean z12 = D1() && this.D.f12629e == 3;
        boolean z13 = !z10 && z12;
        this.Q++;
        a4Var.e(z3Var, zVar, y2Var.f13452c[i11], this.S, z13, z11, j11, y2Var.m(), y2Var.f13457h.f13470a, this.f12589o);
        a4Var.n(11, new a(), y2Var);
        if (z12 && z11) {
            a4Var.U();
        }
    }

    private boolean B1() {
        y2 u11;
        y2 k11;
        return D1() && !this.H && (u11 = this.f12593s.u()) != null && (k11 = u11.k()) != null && this.S >= k11.n() && k11.f13458i;
    }

    private void C() {
        D(new boolean[this.f12571a.length], this.f12593s.y().n());
    }

    private void C0() {
        this.E.b(1);
        K0(false, false, false, true);
        this.f12580f.c(this.f12597w);
        w1(this.D.f12625a.q() ? 4 : 2);
        Q1();
        this.f12594t.w(this.f12581g.b());
        this.f12582h.sendEmptyMessage(2);
    }

    private boolean C1() {
        if (!a0(this.f12593s.n())) {
            return false;
        }
        y2 n11 = this.f12593s.n();
        long M = M(n11.l());
        u2.a aVar = new u2.a(this.f12597w, this.D.f12625a, n11.f13457h.f13470a, n11 == this.f12593s.u() ? n11.C(this.S) : n11.C(this.S) - n11.f13457h.f13471b, M, this.f12589o.getPlaybackParameters().f10648a, this.D.f12636l, this.I, F1(this.D.f12625a, n11.f13457h.f13470a) ? this.f12595u.b() : C.TIME_UNSET, this.J);
        boolean f11 = this.f12580f.f(aVar);
        y2 u11 = this.f12593s.u();
        if (f11 || !u11.f13455f || M >= 500000) {
            return f11;
        }
        if (this.f12587m <= 0 && !this.f12588n) {
            return f11;
        }
        u11.f13450a.discardBuffer(this.D.f12643s, false);
        return this.f12580f.f(aVar);
    }

    private void D(boolean[] zArr, long j11) {
        y2 y10 = this.f12593s.y();
        j2.f0 p11 = y10.p();
        for (int i11 = 0; i11 < this.f12571a.length; i11++) {
            if (!p11.c(i11)) {
                this.f12571a[i11].L();
            }
        }
        for (int i12 = 0; i12 < this.f12571a.length; i12++) {
            if (p11.c(i12) && !this.f12571a[i12].w(y10)) {
                B(y10, i12, zArr[i12], j11);
            }
        }
    }

    private boolean D1() {
        r3 r3Var = this.D;
        return r3Var.f12636l && r3Var.f12638n == 0;
    }

    private void E0() {
        try {
            K0(true, false, true, false);
            F0();
            this.f12580f.b(this.f12597w);
            this.B.i();
            this.f12577d.j();
            w1(1);
            this.f12583i.b();
            synchronized (this) {
                this.F = true;
                notifyAll();
            }
        } catch (Throwable th2) {
            this.f12583i.b();
            synchronized (this) {
                this.F = true;
                notifyAll();
                throw th2;
            }
        }
    }

    private boolean E1(boolean z10) {
        if (this.Q == 0) {
            return b0();
        }
        boolean z11 = false;
        if (!z10) {
            return false;
        }
        if (!this.D.f12631g) {
            return true;
        }
        y2 u11 = this.f12593s.u();
        long b11 = F1(this.D.f12625a, u11.f13457h.f13470a) ? this.f12595u.b() : C.TIME_UNSET;
        y2 n11 = this.f12593s.n();
        boolean z12 = n11.s() && n11.f13457h.f13479j;
        if (n11.f13457h.f13470a.b() && !n11.f13455f) {
            z11 = true;
        }
        if (z12 || z11) {
            return true;
        }
        return this.f12580f.a(new u2.a(this.f12597w, this.D.f12625a, u11.f13457h.f13470a, u11.C(this.S), M(n11.j()), this.f12589o.getPlaybackParameters().f10648a, this.D.f12636l, this.I, b11, this.J));
    }

    private ImmutableList F(j2.z[] zVarArr) {
        ImmutableList.a aVar = new ImmutableList.a();
        boolean z10 = false;
        for (j2.z zVar : zVarArr) {
            if (zVar != null) {
                androidx.media3.common.x xVar = zVar.getFormat(0).f10240l;
                if (xVar == null) {
                    aVar.a(new androidx.media3.common.x(new x.a[0]));
                } else {
                    aVar.a(xVar);
                    z10 = true;
                }
            }
        }
        return z10 ? aVar.e() : ImmutableList.of();
    }

    private void F0() {
        for (int i11 = 0; i11 < this.f12571a.length; i11++) {
            this.f12573b[i11].f();
            this.f12571a[i11].H();
        }
    }

    private boolean F1(androidx.media3.common.e0 e0Var, r.b bVar) {
        if (bVar.b() || e0Var.q()) {
            return false;
        }
        e0Var.n(e0Var.h(bVar.f12965a, this.f12586l).f10018c, this.f12585k);
        if (!this.f12585k.f()) {
            return false;
        }
        e0.c cVar = this.f12585k;
        return cVar.f10041i && cVar.f10038f != C.TIME_UNSET;
    }

    private long G() {
        r3 r3Var = this.D;
        return H(r3Var.f12625a, r3Var.f12626b.f12965a, r3Var.f12643s);
    }

    private void G0(int i11, int i12, g2.v vVar) {
        this.E.b(1);
        T(this.f12594t.A(i11, i12, vVar), false);
    }

    private void G1() {
        y2 u11 = this.f12593s.u();
        if (u11 == null) {
            return;
        }
        j2.f0 p11 = u11.p();
        for (int i11 = 0; i11 < this.f12571a.length; i11++) {
            if (p11.c(i11)) {
                this.f12571a[i11].U();
            }
        }
    }

    private long H(androidx.media3.common.e0 e0Var, Object obj, long j11) {
        e0Var.n(e0Var.h(obj, this.f12586l).f10018c, this.f12585k);
        e0.c cVar = this.f12585k;
        if (cVar.f10038f != C.TIME_UNSET && cVar.f()) {
            e0.c cVar2 = this.f12585k;
            if (cVar2.f10041i) {
                return androidx.media3.common.util.a1.R0(cVar2.a() - this.f12585k.f10038f) - (j11 + this.f12586l.o());
            }
        }
        return C.TIME_UNSET;
    }

    private long I(y2 y2Var) {
        if (y2Var == null) {
            return 0L;
        }
        long m11 = y2Var.m();
        if (!y2Var.f13455f) {
            return m11;
        }
        int i11 = 0;
        while (true) {
            a4[] a4VarArr = this.f12571a;
            if (i11 >= a4VarArr.length) {
                return m11;
            }
            if (a4VarArr[i11].w(y2Var)) {
                long k11 = this.f12571a[i11].k(y2Var);
                if (k11 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                m11 = Math.max(k11, m11);
            }
            i11++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void I0() {
        boolean z10;
        float f11 = this.f12589o.getPlaybackParameters().f10648a;
        y2 u11 = this.f12593s.u();
        y2 y10 = this.f12593s.y();
        boolean z11 = 1;
        j2.f0 f0Var = null;
        boolean z12 = true;
        while (u11 != null && u11.f13455f) {
            r3 r3Var = this.D;
            j2.f0 z13 = u11.z(f11, r3Var.f12625a, r3Var.f12636l);
            if (u11 == this.f12593s.u()) {
                f0Var = z13;
            }
            if (!z13.a(u11.p())) {
                if (z12) {
                    y2 u12 = this.f12593s.u();
                    boolean z14 = (this.f12593s.O(u12) & z11) != 0 ? z11 : false;
                    boolean[] zArr = new boolean[this.f12571a.length];
                    long b11 = u12.b((j2.f0) androidx.media3.common.util.a.e(f0Var), this.D.f12643s, z14, zArr);
                    r3 r3Var2 = this.D;
                    boolean z15 = (r3Var2.f12629e == 4 || b11 == r3Var2.f12643s) ? false : z11;
                    r3 r3Var3 = this.D;
                    this.D = X(r3Var3.f12626b, b11, r3Var3.f12627c, r3Var3.f12628d, z15, 5);
                    if (z15) {
                        M0(b11);
                    }
                    x();
                    boolean[] zArr2 = new boolean[this.f12571a.length];
                    int i11 = 0;
                    while (true) {
                        a4[] a4VarArr = this.f12571a;
                        if (i11 >= a4VarArr.length) {
                            break;
                        }
                        int h11 = a4VarArr[i11].h();
                        zArr2[i11] = this.f12571a[i11].x();
                        this.f12571a[i11].B(u12.f13452c[i11], this.f12589o, this.S, zArr[i11]);
                        if (h11 - this.f12571a[i11].h() > 0) {
                            m0(i11, false);
                        }
                        this.Q -= h11 - this.f12571a[i11].h();
                        i11++;
                    }
                    D(zArr2, this.S);
                    u12.f13458i = true;
                    z10 = true;
                } else {
                    this.f12593s.O(u11);
                    if (u11.f13455f) {
                        long max = Math.max(u11.f13457h.f13471b, u11.C(this.S));
                        if (this.A && r() && this.f12593s.x() == u11) {
                            x();
                        }
                        u11.a(z13, max, false);
                    }
                    z10 = true;
                }
                R(z10);
                if (this.D.f12629e != 4) {
                    g0();
                    T1();
                    this.f12582h.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            boolean z16 = z11;
            if (u11 == y10) {
                z12 = false;
            }
            u11 = u11.k();
            z11 = z16;
        }
    }

    private void I1(boolean z10, boolean z11) {
        K0(z10 || !this.N, false, true, false);
        this.E.b(z11 ? 1 : 0);
        this.f12580f.d(this.f12597w);
        this.B.o(this.D.f12636l, 1);
        w1(1);
    }

    private Pair J(androidx.media3.common.e0 e0Var) {
        if (e0Var.q()) {
            return Pair.create(r3.l(), 0L);
        }
        Pair j11 = e0Var.j(this.f12585k, this.f12586l, e0Var.a(this.M), C.TIME_UNSET);
        r.b R = this.f12593s.R(e0Var, j11.first, 0L);
        long longValue = ((Long) j11.second).longValue();
        if (R.b()) {
            e0Var.h(R.f12965a, this.f12586l);
            longValue = R.f12967c == this.f12586l.l(R.f12966b) ? this.f12586l.g() : 0L;
        }
        return Pair.create(R, Long.valueOf(longValue));
    }

    private void J0() {
        I0();
        V0(true);
    }

    private void J1() {
        this.f12589o.g();
        for (a4 a4Var : this.f12571a) {
            a4Var.W();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
    
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void K0(boolean r34, boolean r35, boolean r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.r2.K0(boolean, boolean, boolean, boolean):void");
    }

    private void K1() {
        y2 n11 = this.f12593s.n();
        boolean z10 = this.K || (n11 != null && n11.f13450a.isLoading());
        r3 r3Var = this.D;
        if (z10 != r3Var.f12631g) {
            this.D = r3Var.b(z10);
        }
    }

    private long L() {
        return M(this.D.f12641q);
    }

    private void L0() {
        y2 u11 = this.f12593s.u();
        this.H = u11 != null && u11.f13457h.f13478i && this.G;
    }

    private void L1(r.b bVar, g2.z zVar, j2.f0 f0Var) {
        y2 y2Var = (y2) androidx.media3.common.util.a.e(this.f12593s.n());
        this.f12580f.g(new u2.a(this.f12597w, this.D.f12625a, bVar, y2Var == this.f12593s.u() ? y2Var.C(this.S) : y2Var.C(this.S) - y2Var.f13457h.f13471b, M(y2Var.j()), this.f12589o.getPlaybackParameters().f10648a, this.D.f12636l, this.I, F1(this.D.f12625a, y2Var.f13457h.f13470a) ? this.f12595u.b() : C.TIME_UNSET, this.J), zVar, f0Var.f65879c);
    }

    private long M(long j11) {
        y2 n11 = this.f12593s.n();
        if (n11 == null) {
            return 0L;
        }
        return Math.max(0L, j11 - n11.C(this.S));
    }

    private void M0(long j11) {
        y2 u11 = this.f12593s.u();
        long D = u11 == null ? j11 + 1000000000000L : u11.D(j11);
        this.S = D;
        this.f12589o.d(D);
        for (a4 a4Var : this.f12571a) {
            a4Var.M(u11, this.S);
        }
        x0();
    }

    private void N(int i11) {
        r3 r3Var = this.D;
        S1(r3Var.f12636l, i11, r3Var.f12638n, r3Var.f12637m);
    }

    private static void N0(androidx.media3.common.e0 e0Var, d dVar, e0.c cVar, e0.b bVar) {
        int i11 = e0Var.n(e0Var.h(dVar.f12609d, bVar).f10018c, cVar).f10047o;
        Object obj = e0Var.g(i11, bVar, true).f10017b;
        long j11 = bVar.f10019d;
        dVar.b(i11, j11 != C.TIME_UNSET ? j11 - 1 : Long.MAX_VALUE, obj);
    }

    private void N1(int i11, int i12, List list) {
        this.E.b(1);
        T(this.f12594t.E(i11, i12, list), false);
    }

    private void O() {
        A1(this.f12578d0);
    }

    private static boolean O0(d dVar, androidx.media3.common.e0 e0Var, androidx.media3.common.e0 e0Var2, int i11, boolean z10, e0.c cVar, e0.b bVar) {
        Object obj = dVar.f12609d;
        if (obj == null) {
            Pair R0 = R0(e0Var, new h(dVar.f12606a.g(), dVar.f12606a.c(), dVar.f12606a.e() == Long.MIN_VALUE ? C.TIME_UNSET : androidx.media3.common.util.a1.R0(dVar.f12606a.e())), false, i11, z10, cVar, bVar);
            if (R0 == null) {
                return false;
            }
            dVar.b(e0Var.b(R0.first), ((Long) R0.second).longValue(), R0.first);
            if (dVar.f12606a.e() == Long.MIN_VALUE) {
                N0(e0Var, dVar, cVar, bVar);
            }
            return true;
        }
        int b11 = e0Var.b(obj);
        if (b11 == -1) {
            return false;
        }
        if (dVar.f12606a.e() == Long.MIN_VALUE) {
            N0(e0Var, dVar, cVar, bVar);
            return true;
        }
        dVar.f12607b = b11;
        e0Var2.h(dVar.f12609d, bVar);
        if (bVar.f10021f && e0Var2.n(bVar.f10018c, cVar).f10046n == e0Var2.b(dVar.f12609d)) {
            Pair j11 = e0Var.j(cVar, bVar, e0Var.h(dVar.f12609d, bVar).f10018c, dVar.f12608c + bVar.o());
            dVar.b(e0Var.b(j11.first), ((Long) j11.second).longValue(), j11.first);
        }
        return true;
    }

    private void O1() {
        if (this.D.f12625a.q() || !this.f12594t.t()) {
            return;
        }
        boolean o02 = o0();
        s0();
        t0();
        u0();
        q0();
        r0(o02);
    }

    private void P(androidx.media3.exoplayer.source.q qVar) {
        if (this.f12593s.F(qVar)) {
            this.f12593s.L(this.S);
            g0();
        } else if (this.f12593s.G(qVar)) {
            h0();
        }
    }

    private void P0(androidx.media3.common.e0 e0Var, androidx.media3.common.e0 e0Var2) {
        if (e0Var.q() && e0Var2.q()) {
            return;
        }
        for (int size = this.f12590p.size() - 1; size >= 0; size--) {
            if (!O0((d) this.f12590p.get(size), e0Var, e0Var2, this.L, this.M, this.f12585k, this.f12586l)) {
                ((d) this.f12590p.get(size)).f12606a.j(false);
                this.f12590p.remove(size);
            }
        }
        Collections.sort(this.f12590p);
    }

    private static int P1(int i11, int i12) {
        if (i11 == -1) {
            return 2;
        }
        if (i12 == 2) {
            return 1;
        }
        return i12;
    }

    private void Q(IOException iOException, int i11) {
        ExoPlaybackException createForSource = ExoPlaybackException.createForSource(iOException, i11);
        y2 u11 = this.f12593s.u();
        if (u11 != null) {
            createForSource = createForSource.copyWithMediaPeriodId(u11.f13457h.f13470a);
        }
        androidx.media3.common.util.u.d("ExoPlayerImplInternal", "Playback error", createForSource);
        I1(false, false);
        this.D = this.D.f(createForSource);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.media3.exoplayer.r2.g Q0(androidx.media3.common.e0 r30, androidx.media3.exoplayer.r3 r31, androidx.media3.exoplayer.r2.h r32, androidx.media3.exoplayer.b3 r33, int r34, boolean r35, androidx.media3.common.e0.c r36, androidx.media3.common.e0.b r37) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.r2.Q0(androidx.media3.common.e0, androidx.media3.exoplayer.r3, androidx.media3.exoplayer.r2$h, androidx.media3.exoplayer.b3, int, boolean, androidx.media3.common.e0$c, androidx.media3.common.e0$b):androidx.media3.exoplayer.r2$g");
    }

    private void Q1() {
        r3 r3Var = this.D;
        R1(r3Var.f12636l, r3Var.f12638n, r3Var.f12637m);
    }

    private void R(boolean z10) {
        y2 n11 = this.f12593s.n();
        r.b bVar = n11 == null ? this.D.f12626b : n11.f13457h.f13470a;
        boolean equals = this.D.f12635k.equals(bVar);
        if (!equals) {
            this.D = this.D.c(bVar);
        }
        r3 r3Var = this.D;
        r3Var.f12641q = n11 == null ? r3Var.f12643s : n11.j();
        this.D.f12642r = L();
        if ((!equals || z10) && n11 != null && n11.f13455f) {
            L1(n11.f13457h.f13470a, n11.o(), n11.p());
        }
    }

    private static Pair R0(androidx.media3.common.e0 e0Var, h hVar, boolean z10, int i11, boolean z11, e0.c cVar, e0.b bVar) {
        Pair j11;
        int S0;
        androidx.media3.common.e0 e0Var2 = hVar.f12621a;
        if (e0Var.q()) {
            return null;
        }
        androidx.media3.common.e0 e0Var3 = e0Var2.q() ? e0Var : e0Var2;
        try {
            j11 = e0Var3.j(cVar, bVar, hVar.f12622b, hVar.f12623c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (e0Var.equals(e0Var3)) {
            return j11;
        }
        if (e0Var.b(j11.first) != -1) {
            return (e0Var3.h(j11.first, bVar).f10021f && e0Var3.n(bVar.f10018c, cVar).f10046n == e0Var3.b(j11.first)) ? e0Var.j(cVar, bVar, e0Var.h(j11.first, bVar).f10018c, hVar.f12623c) : j11;
        }
        if (z10 && (S0 = S0(cVar, bVar, i11, z11, j11.first, e0Var3, e0Var)) != -1) {
            return e0Var.j(cVar, bVar, S0, C.TIME_UNSET);
        }
        return null;
    }

    private void R1(boolean z10, int i11, int i12) {
        S1(z10, this.B.o(z10, this.D.f12629e), i11, i12);
    }

    private void S(y2 y2Var) {
        if (!y2Var.f13455f) {
            float f11 = this.f12589o.getPlaybackParameters().f10648a;
            r3 r3Var = this.D;
            y2Var.q(f11, r3Var.f12625a, r3Var.f12636l);
        }
        L1(y2Var.f13457h.f13470a, y2Var.o(), y2Var.p());
        if (y2Var == this.f12593s.u()) {
            M0(y2Var.f13457h.f13471b);
            C();
            y2Var.f13458i = true;
            r3 r3Var2 = this.D;
            r.b bVar = r3Var2.f12626b;
            long j11 = y2Var.f13457h.f13471b;
            this.D = X(bVar, j11, r3Var2.f12627c, j11, false, 5);
        }
        g0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int S0(e0.c cVar, e0.b bVar, int i11, boolean z10, Object obj, androidx.media3.common.e0 e0Var, androidx.media3.common.e0 e0Var2) {
        Object obj2 = e0Var.n(e0Var.h(obj, bVar).f10018c, cVar).f10033a;
        for (int i12 = 0; i12 < e0Var2.p(); i12++) {
            if (e0Var2.n(i12, cVar).f10033a.equals(obj2)) {
                return i12;
            }
        }
        int b11 = e0Var.b(obj);
        int i13 = e0Var.i();
        int i14 = b11;
        int i15 = -1;
        for (int i16 = 0; i16 < i13 && i15 == -1; i16++) {
            i14 = e0Var.d(i14, bVar, cVar, i11, z10);
            if (i14 == -1) {
                break;
            }
            i15 = e0Var2.b(e0Var.m(i14));
        }
        if (i15 == -1) {
            return -1;
        }
        return e0Var2.f(i15, bVar).f10018c;
    }

    private void S1(boolean z10, int i11, int i12, int i13) {
        boolean z11 = z10 && i11 != -1;
        int P1 = P1(i11, i13);
        int V1 = V1(i11, i12);
        r3 r3Var = this.D;
        if (r3Var.f12636l == z11 && r3Var.f12638n == V1 && r3Var.f12637m == P1) {
            return;
        }
        this.D = r3Var.e(z11, P1, V1);
        W1(false, false);
        y0(z11);
        if (!D1()) {
            J1();
            T1();
            this.f12593s.L(this.S);
            return;
        }
        int i14 = this.D.f12629e;
        if (i14 == 3) {
            this.f12589o.f();
            G1();
            this.f12582h.sendEmptyMessage(2);
        } else if (i14 == 2) {
            this.f12582h.sendEmptyMessage(2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c5 A[Catch: all -> 0x00c9, TryCatch #2 {all -> 0x00c9, blocks: (B:76:0x00bd, B:78:0x00c5, B:79:0x00cd, B:81:0x00d1, B:23:0x00dd, B:25:0x00e9, B:27:0x00f1, B:29:0x00fb, B:31:0x0108, B:34:0x010d), top: B:21:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cd A[Catch: all -> 0x00c9, TryCatch #2 {all -> 0x00c9, blocks: (B:76:0x00bd, B:78:0x00c5, B:79:0x00cd, B:81:0x00d1, B:23:0x00dd, B:25:0x00e9, B:27:0x00f1, B:29:0x00fb, B:31:0x0108, B:34:0x010d), top: B:21:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0207  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void T(androidx.media3.common.e0 r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.r2.T(androidx.media3.common.e0, boolean):void");
    }

    private void T0(long j11) {
        long j12 = (this.D.f12629e != 3 || (!this.f12598x && D1())) ? f12570e0 : 1000L;
        if (this.f12598x && D1()) {
            for (a4 a4Var : this.f12571a) {
                j12 = Math.min(j12, androidx.media3.common.util.a1.y1(a4Var.j(this.S, this.T)));
            }
            y2 k11 = this.f12593s.u() != null ? this.f12593s.u().k() : null;
            if (k11 != null && ((float) this.S) + (((float) androidx.media3.common.util.a1.R0(j12)) * this.D.f12639o.f10648a) >= ((float) k11.n())) {
                j12 = Math.min(j12, f12570e0);
            }
        }
        this.f12582h.sendEmptyMessageAtTime(2, j11 + j12);
    }

    private void T1() {
        y2 u11 = this.f12593s.u();
        if (u11 == null) {
            return;
        }
        long readDiscontinuity = u11.f13455f ? u11.f13450a.readDiscontinuity() : -9223372036854775807L;
        if (readDiscontinuity != C.TIME_UNSET) {
            if (!u11.s()) {
                this.f12593s.O(u11);
                R(false);
                g0();
            }
            M0(readDiscontinuity);
            if (readDiscontinuity != this.D.f12643s) {
                r3 r3Var = this.D;
                this.D = X(r3Var.f12626b, readDiscontinuity, r3Var.f12627c, readDiscontinuity, true, 5);
            }
        } else {
            long h11 = this.f12589o.h(u11 != this.f12593s.y());
            this.S = h11;
            long C = u11.C(h11);
            n0(this.D.f12643s, C);
            if (this.f12589o.i()) {
                boolean z10 = !this.E.f12613d;
                r3 r3Var2 = this.D;
                this.D = X(r3Var2.f12626b, C, r3Var2.f12627c, C, z10, 6);
            } else {
                this.D.o(C);
            }
        }
        this.D.f12641q = this.f12593s.n().j();
        this.D.f12642r = L();
        r3 r3Var3 = this.D;
        if (r3Var3.f12636l && r3Var3.f12629e == 3 && F1(r3Var3.f12625a, r3Var3.f12626b) && this.D.f12639o.f10648a == 1.0f) {
            float a11 = this.f12595u.a(G(), this.D.f12642r);
            if (this.f12589o.getPlaybackParameters().f10648a != a11) {
                g1(this.D.f12639o.b(a11));
                V(this.D.f12639o, this.f12589o.getPlaybackParameters().f10648a, false, false);
            }
        }
    }

    private void U(androidx.media3.exoplayer.source.q qVar) {
        if (this.f12593s.F(qVar)) {
            S((y2) androidx.media3.common.util.a.e(this.f12593s.n()));
            return;
        }
        y2 v11 = this.f12593s.v(qVar);
        if (v11 != null) {
            androidx.media3.common.util.a.g(!v11.f13455f);
            float f11 = this.f12589o.getPlaybackParameters().f10648a;
            r3 r3Var = this.D;
            v11.q(f11, r3Var.f12625a, r3Var.f12636l);
            if (this.f12593s.G(qVar)) {
                h0();
            }
        }
    }

    private void U1(androidx.media3.common.e0 e0Var, r.b bVar, androidx.media3.common.e0 e0Var2, r.b bVar2, long j11, boolean z10) {
        if (!F1(e0Var, bVar)) {
            androidx.media3.common.z zVar = bVar.b() ? androidx.media3.common.z.f10645d : this.D.f12639o;
            if (this.f12589o.getPlaybackParameters().equals(zVar)) {
                return;
            }
            g1(zVar);
            V(this.D.f12639o, zVar.f10648a, false, false);
            return;
        }
        e0Var.n(e0Var.h(bVar.f12965a, this.f12586l).f10018c, this.f12585k);
        this.f12595u.e((t.g) androidx.media3.common.util.a1.i(this.f12585k.f10042j));
        if (j11 != C.TIME_UNSET) {
            this.f12595u.d(H(e0Var, bVar.f12965a, j11));
            return;
        }
        if (!Objects.equals(!e0Var2.q() ? e0Var2.n(e0Var2.h(bVar2.f12965a, this.f12586l).f10018c, this.f12585k).f10033a : null, this.f12585k.f10033a) || z10) {
            this.f12595u.d(C.TIME_UNSET);
        }
    }

    private void V(androidx.media3.common.z zVar, float f11, boolean z10, boolean z11) {
        if (z10) {
            if (z11) {
                this.E.b(1);
            }
            this.D = this.D.g(zVar);
        }
        Y1(zVar.f10648a);
        for (a4 a4Var : this.f12571a) {
            a4Var.Q(f11, zVar.f10648a);
        }
    }

    private void V0(boolean z10) {
        r.b bVar = this.f12593s.u().f13457h.f13470a;
        long Y0 = Y0(bVar, this.D.f12643s, true, false);
        if (Y0 != this.D.f12643s) {
            r3 r3Var = this.D;
            this.D = X(bVar, Y0, r3Var.f12627c, r3Var.f12628d, z10, 5);
        }
    }

    private static int V1(int i11, int i12) {
        if (i11 == 0) {
            return 1;
        }
        if (i12 == 1) {
            return 0;
        }
        return i12;
    }

    private void W(androidx.media3.common.z zVar, boolean z10) {
        V(zVar, zVar.f10648a, true, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ac A[Catch: all -> 0x00af, TryCatch #1 {all -> 0x00af, blocks: (B:6:0x00a2, B:8:0x00ac, B:15:0x00b6, B:17:0x00bc, B:18:0x00bf, B:19:0x00c5, B:21:0x00cf, B:23:0x00d7, B:27:0x00df, B:28:0x00e9, B:30:0x00f9, B:34:0x0103, B:37:0x0115, B:40:0x011e), top: B:5:0x00a2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void W0(androidx.media3.exoplayer.r2.h r19) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.r2.W0(androidx.media3.exoplayer.r2$h):void");
    }

    private void W1(boolean z10, boolean z11) {
        this.I = z10;
        this.J = (!z10 || z11) ? C.TIME_UNSET : this.f12591q.elapsedRealtime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    private r3 X(r.b bVar, long j11, long j12, long j13, boolean z10, int i11) {
        ImmutableList immutableList;
        g2.z zVar;
        j2.f0 f0Var;
        this.V = (!this.V && j11 == this.D.f12643s && bVar.equals(this.D.f12626b)) ? false : true;
        L0();
        r3 r3Var = this.D;
        g2.z zVar2 = r3Var.f12632h;
        j2.f0 f0Var2 = r3Var.f12633i;
        ?? r12 = r3Var.f12634j;
        if (this.f12594t.t()) {
            y2 u11 = this.f12593s.u();
            g2.z o11 = u11 == null ? g2.z.f63387d : u11.o();
            j2.f0 p11 = u11 == null ? this.f12579e : u11.p();
            ImmutableList F = F(p11.f65879c);
            if (u11 != null) {
                z2 z2Var = u11.f13457h;
                if (z2Var.f13472c != j12) {
                    u11.f13457h = z2Var.a(j12);
                }
            }
            p0();
            zVar = o11;
            f0Var = p11;
            immutableList = F;
        } else if (bVar.equals(this.D.f12626b)) {
            immutableList = r12;
            zVar = zVar2;
            f0Var = f0Var2;
        } else {
            zVar = g2.z.f63387d;
            f0Var = this.f12579e;
            immutableList = ImmutableList.of();
        }
        if (z10) {
            this.E.d(i11);
        }
        return this.D.d(bVar, j11, j12, j13, L(), zVar, f0Var, immutableList);
    }

    private long X0(r.b bVar, long j11, boolean z10) {
        return Y0(bVar, j11, this.f12593s.u() != this.f12593s.y(), z10);
    }

    private boolean X1() {
        y2 y10 = this.f12593s.y();
        j2.f0 p11 = y10.p();
        boolean z10 = true;
        int i11 = 0;
        while (true) {
            a4[] a4VarArr = this.f12571a;
            if (i11 >= a4VarArr.length) {
                break;
            }
            int h11 = a4VarArr[i11].h();
            int J = this.f12571a[i11].J(y10, p11, this.f12589o);
            if ((J & 2) != 0 && this.P) {
                j1(false);
            }
            this.Q -= h11 - this.f12571a[i11].h();
            z10 &= (J & 1) != 0;
            i11++;
        }
        if (z10) {
            for (int i12 = 0; i12 < this.f12571a.length; i12++) {
                if (p11.c(i12) && !this.f12571a[i12].w(y10)) {
                    B(y10, i12, false, y10.n());
                }
            }
        }
        return z10;
    }

    private boolean Y() {
        y2 y10 = this.f12593s.y();
        if (!y10.f13455f) {
            return false;
        }
        int i11 = 0;
        while (true) {
            a4[] a4VarArr = this.f12571a;
            if (i11 >= a4VarArr.length) {
                return true;
            }
            if (!a4VarArr[i11].o(y10)) {
                return false;
            }
            i11++;
        }
    }

    private long Y0(r.b bVar, long j11, boolean z10, boolean z11) {
        J1();
        W1(false, true);
        if (z11 || this.D.f12629e == 3) {
            w1(2);
        }
        y2 u11 = this.f12593s.u();
        y2 y2Var = u11;
        while (y2Var != null && !bVar.equals(y2Var.f13457h.f13470a)) {
            y2Var = y2Var.k();
        }
        if (z10 || u11 != y2Var || (y2Var != null && y2Var.D(j11) < 0)) {
            z();
            if (y2Var != null) {
                while (this.f12593s.u() != y2Var) {
                    this.f12593s.b();
                }
                this.f12593s.O(y2Var);
                y2Var.B(1000000000000L);
                C();
                y2Var.f13458i = true;
            }
        }
        x();
        if (y2Var != null) {
            this.f12593s.O(y2Var);
            if (!y2Var.f13455f) {
                y2Var.f13457h = y2Var.f13457h.b(j11);
            } else if (y2Var.f13456g) {
                j11 = y2Var.f13450a.seekToUs(j11);
                y2Var.f13450a.discardBuffer(j11 - this.f12587m, this.f12588n);
            }
            M0(j11);
            g0();
        } else {
            this.f12593s.g();
            M0(j11);
        }
        R(false);
        this.f12582h.sendEmptyMessage(2);
        return j11;
    }

    private void Y1(float f11) {
        for (y2 u11 = this.f12593s.u(); u11 != null; u11 = u11.k()) {
            for (j2.z zVar : u11.p().f65879c) {
                if (zVar != null) {
                    zVar.onPlaybackSpeed(f11);
                }
            }
        }
    }

    private static boolean Z(boolean z10, r.b bVar, long j11, r.b bVar2, e0.b bVar3, long j12) {
        if (!z10 && j11 == j12 && bVar.f12965a.equals(bVar2.f12965a)) {
            return (bVar.b() && bVar3.s(bVar.f12966b)) ? (bVar3.h(bVar.f12966b, bVar.f12967c) == 4 || bVar3.h(bVar.f12966b, bVar.f12967c) == 2) ? false : true : bVar2.b() && bVar3.s(bVar2.f12966b);
        }
        return false;
    }

    private void Z0(t3 t3Var) {
        if (t3Var.e() == C.TIME_UNSET) {
            a1(t3Var);
            return;
        }
        if (this.D.f12625a.q()) {
            this.f12590p.add(new d(t3Var));
            return;
        }
        d dVar = new d(t3Var);
        androidx.media3.common.e0 e0Var = this.D.f12625a;
        if (!O0(dVar, e0Var, e0Var, this.L, this.M, this.f12585k, this.f12586l)) {
            t3Var.j(false);
        } else {
            this.f12590p.add(dVar);
            Collections.sort(this.f12590p);
        }
    }

    private synchronized void Z1(com.google.common.base.q qVar, long j11) {
        long elapsedRealtime = this.f12591q.elapsedRealtime() + j11;
        boolean z10 = false;
        while (!((Boolean) qVar.get()).booleanValue() && j11 > 0) {
            try {
                this.f12591q.a();
                wait(j11);
            } catch (InterruptedException unused) {
                z10 = true;
            }
            j11 = elapsedRealtime - this.f12591q.elapsedRealtime();
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean a0(y2 y2Var) {
        return (y2Var == null || y2Var.r() || y2Var.l() == Long.MIN_VALUE) ? false : true;
    }

    private void a1(t3 t3Var) {
        if (t3Var.b() != this.f12584j) {
            this.f12582h.obtainMessage(15, t3Var).a();
            return;
        }
        w(t3Var);
        int i11 = this.D.f12629e;
        if (i11 == 3 || i11 == 2) {
            this.f12582h.sendEmptyMessage(2);
        }
    }

    private boolean b0() {
        y2 u11 = this.f12593s.u();
        long j11 = u11.f13457h.f13474e;
        return u11.f13455f && (j11 == C.TIME_UNSET || this.D.f12643s < j11 || !D1());
    }

    private void b1(final t3 t3Var) {
        Looper b11 = t3Var.b();
        if (b11.getThread().isAlive()) {
            this.f12591q.createHandler(b11, null).post(new Runnable() { // from class: androidx.media3.exoplayer.q2
                @Override // java.lang.Runnable
                public final void run() {
                    r2.this.f0(t3Var);
                }
            });
        } else {
            androidx.media3.common.util.u.h("TAG", "Trying to send message on a dead thread.");
            t3Var.j(false);
        }
    }

    private static boolean c0(r3 r3Var, e0.b bVar) {
        r.b bVar2 = r3Var.f12626b;
        androidx.media3.common.e0 e0Var = r3Var.f12625a;
        return e0Var.q() || e0Var.h(bVar2.f12965a, bVar).f10021f;
    }

    private void c1(long j11) {
        for (a4 a4Var : this.f12571a) {
            a4Var.N(j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(int i11, boolean z10) {
        this.f12599y.B(i11, this.f12571a[i11].m(), z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean e0() {
        return Boolean.valueOf(this.F);
    }

    private void e1(androidx.media3.common.c cVar, boolean z10) {
        this.f12577d.l(cVar);
        androidx.media3.exoplayer.h hVar = this.B;
        if (!z10) {
            cVar = null;
        }
        hVar.l(cVar);
        Q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(t3 t3Var) {
        try {
            w(t3Var);
        } catch (ExoPlaybackException e11) {
            androidx.media3.common.util.u.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e11);
            throw new RuntimeException(e11);
        }
    }

    private void f1(boolean z10, AtomicBoolean atomicBoolean) {
        if (this.N != z10) {
            this.N = z10;
            if (!z10) {
                for (a4 a4Var : this.f12571a) {
                    a4Var.L();
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void g0() {
        boolean C1 = C1();
        this.K = C1;
        if (C1) {
            y2 y2Var = (y2) androidx.media3.common.util.a.e(this.f12593s.n());
            y2Var.e(new v2.b().f(y2Var.C(this.S)).g(this.f12589o.getPlaybackParameters().f10648a).e(this.J).d());
        }
        K1();
    }

    private void g1(androidx.media3.common.z zVar) {
        this.f12582h.removeMessages(16);
        this.f12589o.b(zVar);
    }

    private void h0() {
        this.f12593s.J();
        y2 w11 = this.f12593s.w();
        if (w11 != null) {
            if ((!w11.f13454e || w11.f13455f) && !w11.f13450a.isLoading()) {
                if (this.f12580f.e(this.D.f12625a, w11.f13457h.f13470a, w11.f13455f ? w11.f13450a.getBufferedPositionUs() : 0L)) {
                    if (w11.f13454e) {
                        w11.e(new v2.b().f(w11.C(this.S)).g(this.f12589o.getPlaybackParameters().f10648a).e(this.J).d());
                    } else {
                        w11.v(this, w11.f13457h.f13471b);
                    }
                }
            }
        }
    }

    private void h1(b bVar) {
        this.E.b(1);
        if (bVar.f12604c != -1) {
            this.R = new h(new u3(bVar.f12602a, bVar.f12603b), bVar.f12604c, bVar.f12605d);
        }
        T(this.f12594t.C(bVar.f12602a, bVar.f12603b), false);
    }

    private void i0() {
        for (a4 a4Var : this.f12571a) {
            a4Var.D();
        }
    }

    private void j0() {
        this.E.c(this.D);
        if (this.E.f12610a) {
            this.f12592r.a(this.E);
            this.E = new e(this.D);
        }
    }

    private void j1(boolean z10) {
        if (z10 == this.P) {
            return;
        }
        this.P = z10;
        if (z10 || !this.D.f12640p) {
            return;
        }
        this.f12582h.sendEmptyMessage(2);
    }

    private void k0() {
        y2 x10 = this.f12593s.x();
        if (x10 == null) {
            return;
        }
        j2.f0 p11 = x10.p();
        for (int i11 = 0; i11 < this.f12571a.length; i11++) {
            if (p11.c(i11) && this.f12571a[i11].s() && !this.f12571a[i11].u()) {
                this.f12571a[i11].V();
                B(x10, i11, false, x10.n());
            }
        }
        if (r()) {
            this.f12574b0 = x10.f13450a.readDiscontinuity();
            if (x10.s()) {
                return;
            }
            this.f12593s.O(x10);
            R(false);
            g0();
        }
    }

    private void k1(boolean z10) {
        this.G = z10;
        L0();
        if (!this.H || this.f12593s.y() == this.f12593s.u()) {
            return;
        }
        V0(true);
        R(false);
    }

    private void l0(int i11) {
        a4 a4Var = this.f12571a[i11];
        try {
            a4Var.G((y2) androidx.media3.common.util.a.e(this.f12593s.u()));
        } catch (IOException | RuntimeException e11) {
            int m11 = a4Var.m();
            if (m11 != 3 && m11 != 5) {
                throw e11;
            }
            j2.f0 p11 = this.f12593s.u().p();
            androidx.media3.common.util.u.d("ExoPlayerImplInternal", "Disabling track due to error: " + androidx.media3.common.r.i(p11.f65879c[i11].getSelectedFormat()), e11);
            j2.f0 f0Var = new j2.f0((z3[]) p11.f65878b.clone(), (j2.z[]) p11.f65879c.clone(), p11.f65880d, p11.f65881e);
            f0Var.f65878b[i11] = null;
            f0Var.f65879c[i11] = null;
            y(i11);
            this.f12593s.u().a(f0Var, this.D.f12643s, false);
        }
    }

    private void m0(final int i11, final boolean z10) {
        boolean[] zArr = this.f12575c;
        if (zArr[i11] != z10) {
            zArr[i11] = z10;
            this.f12600z.post(new Runnable() { // from class: androidx.media3.exoplayer.n2
                @Override // java.lang.Runnable
                public final void run() {
                    r2.this.d0(i11, z10);
                }
            });
        }
    }

    private void m1(boolean z10, int i11, boolean z11, int i12) {
        this.E.b(z11 ? 1 : 0);
        R1(z10, i11, i12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0079, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void n0(long r9, long r11) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.r2.n0(long, long):void");
    }

    private void o(b bVar, int i11) {
        this.E.b(1);
        q3 q3Var = this.f12594t;
        if (i11 == -1) {
            i11 = q3Var.r();
        }
        T(q3Var.f(i11, bVar.f12602a, bVar.f12603b), false);
    }

    private boolean o0() {
        z2 t11;
        this.f12593s.L(this.S);
        boolean z10 = false;
        if (this.f12593s.U() && (t11 = this.f12593s.t(this.S, this.D)) != null) {
            y2 h11 = this.f12593s.h(t11);
            if (!h11.f13454e) {
                h11.v(this, t11.f13471b);
            } else if (h11.f13455f) {
                this.f12582h.obtainMessage(8, h11.f13450a).a();
            }
            if (this.f12593s.u() == h11) {
                M0(t11.f13471b);
            }
            R(false);
            z10 = true;
        }
        if (this.K) {
            this.K = a0(this.f12593s.n());
            K1();
        } else {
            g0();
        }
        return z10;
    }

    private void o1(androidx.media3.common.z zVar) {
        g1(zVar);
        W(this.f12589o.getPlaybackParameters(), true);
    }

    private void p0() {
        y2 u11;
        boolean z10;
        if (this.f12593s.u() == this.f12593s.y() && (u11 = this.f12593s.u()) != null) {
            j2.f0 p11 = u11.p();
            boolean z11 = false;
            int i11 = 0;
            boolean z12 = false;
            while (true) {
                if (i11 >= this.f12571a.length) {
                    z10 = true;
                    break;
                }
                if (p11.c(i11)) {
                    if (this.f12571a[i11].m() != 1) {
                        z10 = false;
                        break;
                    } else if (p11.f65878b[i11].f13481a != 0) {
                        z12 = true;
                    }
                }
                i11++;
            }
            if (z12 && z10) {
                z11 = true;
            }
            j1(z11);
        }
    }

    private void p1(ExoPlayer.c cVar) {
        this.Z = cVar;
        this.f12593s.W(this.D.f12625a, cVar);
    }

    private void q() {
        j2.f0 p11 = this.f12593s.u().p();
        for (int i11 = 0; i11 < this.f12571a.length; i11++) {
            if (p11.c(i11)) {
                this.f12571a[i11].f();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q0() {
        /*
            r15 = this;
            r0 = 0
            r1 = r0
        L2:
            boolean r2 = r15.B1()
            if (r2 == 0) goto L81
            if (r1 == 0) goto Ld
            r15.j0()
        Ld:
            r15.f12576c0 = r0
            androidx.media3.exoplayer.b3 r1 = r15.f12593s
            androidx.media3.exoplayer.y2 r1 = r1.b()
            java.lang.Object r1 = androidx.media3.common.util.a.e(r1)
            androidx.media3.exoplayer.y2 r1 = (androidx.media3.exoplayer.y2) r1
            androidx.media3.exoplayer.r3 r2 = r15.D
            androidx.media3.exoplayer.source.r$b r2 = r2.f12626b
            java.lang.Object r2 = r2.f12965a
            androidx.media3.exoplayer.z2 r3 = r1.f13457h
            androidx.media3.exoplayer.source.r$b r3 = r3.f13470a
            java.lang.Object r3 = r3.f12965a
            boolean r2 = r2.equals(r3)
            r3 = 1
            if (r2 == 0) goto L47
            androidx.media3.exoplayer.r3 r2 = r15.D
            androidx.media3.exoplayer.source.r$b r2 = r2.f12626b
            int r4 = r2.f12966b
            r5 = -1
            if (r4 != r5) goto L47
            androidx.media3.exoplayer.z2 r4 = r1.f13457h
            androidx.media3.exoplayer.source.r$b r4 = r4.f13470a
            int r6 = r4.f12966b
            if (r6 != r5) goto L47
            int r2 = r2.f12969e
            int r4 = r4.f12969e
            if (r2 == r4) goto L47
            r2 = r3
            goto L48
        L47:
            r2 = r0
        L48:
            androidx.media3.exoplayer.z2 r4 = r1.f13457h
            androidx.media3.exoplayer.source.r$b r6 = r4.f13470a
            long r11 = r4.f13471b
            long r9 = r4.f13472c
            r13 = r2 ^ 1
            r14 = 0
            r5 = r15
            r7 = r11
            androidx.media3.exoplayer.r3 r2 = r5.X(r6, r7, r9, r11, r13, r14)
            r15.D = r2
            r15.L0()
            r15.T1()
            boolean r2 = r15.r()
            if (r2 == 0) goto L72
            androidx.media3.exoplayer.b3 r2 = r15.f12593s
            androidx.media3.exoplayer.y2 r2 = r2.x()
            if (r1 != r2) goto L72
            r15.i0()
        L72:
            androidx.media3.exoplayer.r3 r1 = r15.D
            int r1 = r1.f12629e
            r2 = 3
            if (r1 != r2) goto L7c
            r15.G1()
        L7c:
            r15.q()
            r1 = r3
            goto L2
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.r2.q0():void");
    }

    private boolean r() {
        if (!this.A) {
            return false;
        }
        for (a4 a4Var : this.f12571a) {
            if (a4Var.u()) {
                return true;
            }
        }
        return false;
    }

    private void r0(boolean z10) {
        if (this.Z.f11068a == C.TIME_UNSET) {
            return;
        }
        if (z10 || !this.D.f12625a.equals(this.f12572a0)) {
            androidx.media3.common.e0 e0Var = this.D.f12625a;
            this.f12572a0 = e0Var;
            this.f12593s.B(e0Var);
        }
        h0();
    }

    private void r1(int i11) {
        this.L = i11;
        int Y = this.f12593s.Y(this.D.f12625a, i11);
        if ((Y & 1) != 0) {
            V0(true);
        } else if ((Y & 2) != 0) {
            x();
        }
        R(false);
    }

    private void s0() {
        y2 x10;
        if (this.H || !this.A || this.f12576c0 || r() || (x10 = this.f12593s.x()) == null || x10 != this.f12593s.y() || x10.k() == null || !x10.k().f13455f) {
            return;
        }
        this.f12593s.c();
        k0();
    }

    private void s1(c4 c4Var) {
        this.C = c4Var;
    }

    private void t() {
        J0();
    }

    private void t0() {
        y2 y10 = this.f12593s.y();
        if (y10 == null) {
            return;
        }
        int i11 = 0;
        if (y10.k() == null || this.H) {
            if (y10.f13457h.f13479j || this.H) {
                a4[] a4VarArr = this.f12571a;
                int length = a4VarArr.length;
                while (i11 < length) {
                    a4 a4Var = a4VarArr[i11];
                    if (a4Var.w(y10) && a4Var.r(y10)) {
                        long j11 = y10.f13457h.f13474e;
                        a4Var.O(y10, (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? -9223372036854775807L : y10.m() + y10.f13457h.f13474e);
                    }
                    i11++;
                }
                return;
            }
            return;
        }
        if (Y()) {
            if (r() && this.f12593s.x() == this.f12593s.y()) {
                return;
            }
            if (y10.k().f13455f || this.S >= y10.k().n()) {
                j2.f0 p11 = y10.p();
                y2 d11 = this.f12593s.d();
                j2.f0 p12 = d11.p();
                androidx.media3.common.e0 e0Var = this.D.f12625a;
                U1(e0Var, d11.f13457h.f13470a, e0Var, y10.f13457h.f13470a, C.TIME_UNSET, false);
                if (d11.f13455f && ((this.A && this.f12574b0 != C.TIME_UNSET) || d11.f13450a.readDiscontinuity() != C.TIME_UNSET)) {
                    this.f12574b0 = C.TIME_UNSET;
                    boolean z10 = this.A && !this.f12576c0;
                    if (z10) {
                        int i12 = 0;
                        while (true) {
                            if (i12 >= this.f12571a.length) {
                                break;
                            }
                            if (p12.c(i12) && !androidx.media3.common.y.a(p12.f65879c[i12].getSelectedFormat().f10243o, p12.f65879c[i12].getSelectedFormat().f10239k) && !this.f12571a[i12].u()) {
                                z10 = false;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (!z10) {
                        c1(d11.n());
                        if (d11.s()) {
                            return;
                        }
                        this.f12593s.O(d11);
                        R(false);
                        g0();
                        return;
                    }
                }
                a4[] a4VarArr2 = this.f12571a;
                int length2 = a4VarArr2.length;
                while (i11 < length2) {
                    a4VarArr2[i11].F(p11, p12, d11.n());
                    i11++;
                }
            }
        }
    }

    private void u0() {
        y2 y10 = this.f12593s.y();
        if (y10 == null || this.f12593s.u() == y10 || y10.f13458i || !X1()) {
            return;
        }
        this.f12593s.y().f13458i = true;
    }

    private void u1(boolean z10) {
        this.M = z10;
        int Z = this.f12593s.Z(this.D.f12625a, z10);
        if ((Z & 1) != 0) {
            V0(true);
        } else if ((Z & 2) != 0) {
            x();
        }
        R(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public y2 v(z2 z2Var, long j11) {
        return new y2(this.f12573b, j11, this.f12577d, this.f12580f.getAllocator(), this.f12594t, z2Var, this.f12579e, this.Z.f11068a);
    }

    private void v0() {
        T(this.f12594t.i(), true);
    }

    private void v1(g2.v vVar) {
        this.E.b(1);
        T(this.f12594t.D(vVar), false);
    }

    private void w(t3 t3Var) {
        if (t3Var.i()) {
            return;
        }
        try {
            t3Var.f().handleMessage(t3Var.h(), t3Var.d());
        } finally {
            t3Var.j(true);
        }
    }

    private void w0(c cVar) {
        this.E.b(1);
        throw null;
    }

    private void w1(int i11) {
        r3 r3Var = this.D;
        if (r3Var.f12629e != i11) {
            if (i11 != 2) {
                this.Y = C.TIME_UNSET;
            }
            this.D = r3Var.h(i11);
        }
    }

    private void x() {
        if (this.A && r()) {
            for (a4 a4Var : this.f12571a) {
                int h11 = a4Var.h();
                a4Var.c(this.f12589o);
                this.Q -= h11 - a4Var.h();
            }
            this.f12574b0 = C.TIME_UNSET;
        }
    }

    private void x0() {
        for (y2 u11 = this.f12593s.u(); u11 != null; u11 = u11.k()) {
            for (j2.z zVar : u11.p().f65879c) {
                if (zVar != null) {
                    zVar.a();
                }
            }
        }
    }

    private void y(int i11) {
        int h11 = this.f12571a[i11].h();
        this.f12571a[i11].b(this.f12589o);
        m0(i11, false);
        this.Q -= h11;
    }

    private void y0(boolean z10) {
        for (y2 u11 = this.f12593s.u(); u11 != null; u11 = u11.k()) {
            for (j2.z zVar : u11.p().f65879c) {
                if (zVar != null) {
                    zVar.b(z10);
                }
            }
        }
    }

    private void y1(Object obj, AtomicBoolean atomicBoolean) {
        for (a4 a4Var : this.f12571a) {
            a4Var.S(obj);
        }
        int i11 = this.D.f12629e;
        if (i11 == 3 || i11 == 2) {
            this.f12582h.sendEmptyMessage(2);
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void z() {
        for (int i11 = 0; i11 < this.f12571a.length; i11++) {
            y(i11);
        }
        this.f12574b0 = C.TIME_UNSET;
    }

    private void z0() {
        for (y2 u11 = this.f12593s.u(); u11 != null; u11 = u11.k()) {
            for (j2.z zVar : u11.p().f65879c) {
                if (zVar != null) {
                    zVar.c();
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.f0.a
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public void f(androidx.media3.exoplayer.source.q qVar) {
        this.f12582h.obtainMessage(9, qVar).a();
    }

    public void B0() {
        this.f12582h.obtainMessage(29).a();
    }

    public synchronized boolean D0() {
        if (!this.F && this.f12584j.getThread().isAlive()) {
            this.f12582h.sendEmptyMessage(7);
            Z1(new com.google.common.base.q() { // from class: androidx.media3.exoplayer.m2
                @Override // com.google.common.base.q
                public final Object get() {
                    Boolean e02;
                    e02 = r2.this.e0();
                    return e02;
                }
            }, this.f12596v);
            return this.F;
        }
        return true;
    }

    public void E(long j11) {
        this.X = j11;
    }

    public void H0(int i11, int i12, g2.v vVar) {
        this.f12582h.obtainMessage(20, i11, i12, vVar).a();
    }

    public void H1() {
        this.f12582h.obtainMessage(6).a();
    }

    public Looper K() {
        return this.f12584j;
    }

    public void M1(int i11, int i12, List list) {
        this.f12582h.obtainMessage(27, i11, i12, list).a();
    }

    public void U0(androidx.media3.common.e0 e0Var, int i11, long j11) {
        this.f12582h.obtainMessage(3, new h(e0Var, i11, j11)).a();
    }

    @Override // androidx.media3.exoplayer.q3.d
    public void a() {
        this.f12582h.removeMessages(2);
        this.f12582h.sendEmptyMessage(22);
    }

    @Override // j2.e0.a
    public void b(w3 w3Var) {
        this.f12582h.sendEmptyMessage(26);
    }

    @Override // androidx.media3.exoplayer.source.q.a
    public void c(androidx.media3.exoplayer.source.q qVar) {
        this.f12582h.obtainMessage(8, qVar).a();
    }

    public void d1(androidx.media3.common.c cVar, boolean z10) {
        this.f12582h.obtainMessage(31, z10 ? 1 : 0, 0, cVar).a();
    }

    @Override // androidx.media3.exoplayer.t3.a
    public synchronized void e(t3 t3Var) {
        if (!this.F && this.f12584j.getThread().isAlive()) {
            this.f12582h.obtainMessage(14, t3Var).a();
            return;
        }
        androidx.media3.common.util.u.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        t3Var.j(false);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ExoPlaybackException exoPlaybackException;
        int i11;
        y2 y10;
        try {
            switch (message.what) {
                case 1:
                    boolean z10 = message.arg1 != 0;
                    int i12 = message.arg2;
                    m1(z10, i12 >> 4, true, i12 & 15);
                    break;
                case 2:
                    A();
                    break;
                case 3:
                    W0((h) message.obj);
                    break;
                case 4:
                    o1((androidx.media3.common.z) message.obj);
                    break;
                case 5:
                    s1((c4) message.obj);
                    break;
                case 6:
                    I1(false, true);
                    break;
                case 7:
                    E0();
                    return true;
                case 8:
                    U((androidx.media3.exoplayer.source.q) message.obj);
                    break;
                case 9:
                    P((androidx.media3.exoplayer.source.q) message.obj);
                    break;
                case 10:
                    I0();
                    break;
                case 11:
                    r1(message.arg1);
                    break;
                case 12:
                    u1(message.arg1 != 0);
                    break;
                case 13:
                    f1(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    Z0((t3) message.obj);
                    break;
                case 15:
                    b1((t3) message.obj);
                    break;
                case 16:
                    W((androidx.media3.common.z) message.obj, false);
                    break;
                case 17:
                    h1((b) message.obj);
                    break;
                case 18:
                    o((b) message.obj, message.arg1);
                    break;
                case 19:
                    android.support.v4.media.session.c.a(message.obj);
                    w0(null);
                    break;
                case 20:
                    G0(message.arg1, message.arg2, (g2.v) message.obj);
                    break;
                case 21:
                    v1((g2.v) message.obj);
                    break;
                case 22:
                    v0();
                    break;
                case 23:
                    k1(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    t();
                    break;
                case 26:
                    J0();
                    break;
                case 27:
                    N1(message.arg1, message.arg2, (List) message.obj);
                    break;
                case 28:
                    p1((ExoPlayer.c) message.obj);
                    break;
                case NOTIFICATION_REDIRECT_VALUE:
                    C0();
                    break;
                case 30:
                    Pair pair = (Pair) message.obj;
                    y1(pair.first, (AtomicBoolean) pair.second);
                    break;
                case TEMPLATE_HTML_SIZE_VALUE:
                    e1((androidx.media3.common.c) message.obj, message.arg1 != 0);
                    break;
                case 32:
                    A1(((Float) message.obj).floatValue());
                    break;
                case 33:
                    N(message.arg1);
                    break;
                case 34:
                    O();
                    break;
            }
        } catch (ParserException e11) {
            int i13 = e11.dataType;
            if (i13 == 1) {
                r2 = e11.contentIsMalformed ? 3001 : 3003;
            } else if (i13 == 4) {
                r2 = e11.contentIsMalformed ? 3002 : 3004;
            }
            Q(e11, r2);
        } catch (DataSourceException e12) {
            Q(e12, e12.reason);
        } catch (ExoPlaybackException e13) {
            ExoPlaybackException exoPlaybackException2 = e13;
            if (exoPlaybackException2.type == 1 && (y10 = this.f12593s.y()) != null) {
                a4[] a4VarArr = this.f12571a;
                int i14 = exoPlaybackException2.rendererIndex;
                exoPlaybackException2 = exoPlaybackException2.copyWithMediaPeriodId((!a4VarArr[i14 % a4VarArr.length].z(i14) || y10.k() == null) ? y10.f13457h.f13470a : y10.k().f13457h.f13470a);
            }
            if (exoPlaybackException2.type == 1) {
                a4[] a4VarArr2 = this.f12571a;
                int i15 = exoPlaybackException2.rendererIndex;
                if (a4VarArr2[i15 % a4VarArr2.length].z(i15)) {
                    this.f12576c0 = true;
                    x();
                    y2 x10 = this.f12593s.x();
                    y2 u11 = this.f12593s.u();
                    if (this.f12593s.u() != x10) {
                        while (u11 != null && u11.k() != x10) {
                            u11 = u11.k();
                        }
                    }
                    this.f12593s.O(u11);
                    if (this.D.f12629e != 4) {
                        g0();
                        this.f12582h.sendEmptyMessage(2);
                    }
                }
            }
            ExoPlaybackException exoPlaybackException3 = this.W;
            if (exoPlaybackException3 != null) {
                exoPlaybackException3.addSuppressed(exoPlaybackException2);
                exoPlaybackException2 = this.W;
            }
            ExoPlaybackException exoPlaybackException4 = exoPlaybackException2;
            if (exoPlaybackException4.type != 1 || this.f12593s.u() == this.f12593s.y()) {
                exoPlaybackException = exoPlaybackException4;
            } else {
                while (this.f12593s.u() != this.f12593s.y()) {
                    this.f12593s.b();
                }
                y2 y2Var = (y2) androidx.media3.common.util.a.e(this.f12593s.u());
                j0();
                z2 z2Var = y2Var.f13457h;
                r.b bVar = z2Var.f13470a;
                long j11 = z2Var.f13471b;
                exoPlaybackException = exoPlaybackException4;
                this.D = X(bVar, j11, z2Var.f13472c, j11, true, 0);
            }
            if (exoPlaybackException.isRecoverable && (this.W == null || (i11 = exoPlaybackException.errorCode) == 5004 || i11 == 5003)) {
                androidx.media3.common.util.u.i("ExoPlayerImplInternal", "Recoverable renderer error", exoPlaybackException);
                if (this.W == null) {
                    this.W = exoPlaybackException;
                }
                androidx.media3.common.util.p pVar = this.f12582h;
                pVar.b(pVar.obtainMessage(25, exoPlaybackException));
            } else {
                androidx.media3.common.util.u.d("ExoPlayerImplInternal", "Playback error", exoPlaybackException);
                I1(true, false);
                this.D = this.D.f(exoPlaybackException);
            }
        } catch (DrmSession.DrmSessionException e14) {
            Q(e14, e14.errorCode);
        } catch (BehindLiveWindowException e15) {
            Q(e15, 1002);
        } catch (IOException e16) {
            Q(e16, 2000);
        } catch (RuntimeException e17) {
            ExoPlaybackException createForUnexpected = ExoPlaybackException.createForUnexpected(e17, ((e17 instanceof IllegalStateException) || (e17 instanceof IllegalArgumentException)) ? 1004 : 1000);
            androidx.media3.common.util.u.d("ExoPlayerImplInternal", "Playback error", createForUnexpected);
            I1(true, false);
            this.D = this.D.f(createForUnexpected);
        }
        j0();
        return true;
    }

    public void i1(List list, int i11, long j11, g2.v vVar) {
        this.f12582h.obtainMessage(17, new b(list, vVar, i11, j11, null)).a();
    }

    public void l1(boolean z10, int i11, int i12) {
        this.f12582h.obtainMessage(1, z10 ? 1 : 0, i11 | (i12 << 4)).a();
    }

    public void n1(androidx.media3.common.z zVar) {
        this.f12582h.obtainMessage(4, zVar).a();
    }

    @Override // androidx.media3.exoplayer.n.a
    public void onPlaybackParametersChanged(androidx.media3.common.z zVar) {
        this.f12582h.obtainMessage(16, zVar).a();
    }

    @Override // j2.e0.a
    public void onTrackSelectionsInvalidated() {
        this.f12582h.sendEmptyMessage(10);
    }

    public void p(int i11, List list, g2.v vVar) {
        this.f12582h.obtainMessage(18, i11, 0, new b(list, vVar, -1, C.TIME_UNSET, null)).a();
    }

    public void q1(int i11) {
        this.f12582h.obtainMessage(11, i11, 0).a();
    }

    @Override // androidx.media3.exoplayer.h.a
    public void s(float f11) {
        this.f12582h.sendEmptyMessage(34);
    }

    public void t1(boolean z10) {
        this.f12582h.obtainMessage(12, z10 ? 1 : 0, 0).a();
    }

    @Override // androidx.media3.exoplayer.h.a
    public void u(int i11) {
        this.f12582h.obtainMessage(33, i11, 0).a();
    }

    public synchronized boolean x1(Object obj, long j11) {
        if (!this.F && this.f12584j.getThread().isAlive()) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.f12582h.obtainMessage(30, new Pair(obj, atomicBoolean)).a();
            if (j11 == C.TIME_UNSET) {
                return true;
            }
            Z1(new com.google.common.base.q() { // from class: androidx.media3.exoplayer.p2
                @Override // com.google.common.base.q
                public final Object get() {
                    return Boolean.valueOf(atomicBoolean.get());
                }
            }, j11);
            return atomicBoolean.get();
        }
        return true;
    }

    public void z1(float f11) {
        this.f12582h.obtainMessage(32, Float.valueOf(f11)).a();
    }
}
