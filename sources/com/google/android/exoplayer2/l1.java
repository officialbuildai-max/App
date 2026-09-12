package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.h2;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.s2;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.x2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import la.q;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l1 implements Handler.Callback, n.a, q.a, h2.d, o.a, s2.a {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private int J;
    private h K;
    private long L;
    private int M;
    private boolean N;
    private ExoPlaybackException O;
    private long P;
    private long Q = C.TIME_UNSET;

    /* renamed from: a, reason: collision with root package name */
    private final x2[] f25245a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f25246b;

    /* renamed from: c, reason: collision with root package name */
    private final z2[] f25247c;

    /* renamed from: d, reason: collision with root package name */
    private final la.q f25248d;

    /* renamed from: e, reason: collision with root package name */
    private final la.r f25249e;

    /* renamed from: f, reason: collision with root package name */
    private final t1 f25250f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.e f25251g;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.o f25252h;

    /* renamed from: i, reason: collision with root package name */
    private final HandlerThread f25253i;

    /* renamed from: j, reason: collision with root package name */
    private final Looper f25254j;

    /* renamed from: k, reason: collision with root package name */
    private final k3.d f25255k;

    /* renamed from: l, reason: collision with root package name */
    private final k3.b f25256l;

    /* renamed from: m, reason: collision with root package name */
    private final long f25257m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f25258n;

    /* renamed from: o, reason: collision with root package name */
    private final o f25259o;

    /* renamed from: p, reason: collision with root package name */
    private final ArrayList f25260p;

    /* renamed from: q, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.e f25261q;

    /* renamed from: r, reason: collision with root package name */
    private final f f25262r;

    /* renamed from: s, reason: collision with root package name */
    private final e2 f25263s;

    /* renamed from: t, reason: collision with root package name */
    private final h2 f25264t;

    /* renamed from: u, reason: collision with root package name */
    private final s1 f25265u;

    /* renamed from: v, reason: collision with root package name */
    private final long f25266v;

    /* renamed from: w, reason: collision with root package name */
    private c3 f25267w;

    /* renamed from: x, reason: collision with root package name */
    private l2 f25268x;

    /* renamed from: y, reason: collision with root package name */
    private e f25269y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f25270z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements x2.a {
        a() {
        }

        @Override // com.google.android.exoplayer2.x2.a
        public void a() {
            l1.this.H = true;
        }

        @Override // com.google.android.exoplayer2.x2.a
        public void b() {
            l1.this.f25252h.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List f25272a;

        /* renamed from: b, reason: collision with root package name */
        private final t9.t f25273b;

        /* renamed from: c, reason: collision with root package name */
        private final int f25274c;

        /* renamed from: d, reason: collision with root package name */
        private final long f25275d;

        private b(List list, t9.t tVar, int i11, long j11) {
            this.f25272a = list;
            this.f25273b = tVar;
            this.f25274c = i11;
            this.f25275d = j11;
        }

        /* synthetic */ b(List list, t9.t tVar, int i11, long j11, a aVar) {
            this(list, tVar, i11, j11);
        }
    }

    /* loaded from: classes3.dex */
    private static class c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class d implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final s2 f25276a;

        /* renamed from: b, reason: collision with root package name */
        public int f25277b;

        /* renamed from: c, reason: collision with root package name */
        public long f25278c;

        /* renamed from: d, reason: collision with root package name */
        public Object f25279d;

        public d(s2 s2Var) {
            this.f25276a = s2Var;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.f25279d;
            if ((obj == null) != (dVar.f25279d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i11 = this.f25277b - dVar.f25277b;
            return i11 != 0 ? i11 : com.google.android.exoplayer2.util.p0.o(this.f25278c, dVar.f25278c);
        }

        public void b(int i11, long j11, Object obj) {
            this.f25277b = i11;
            this.f25278c = j11;
            this.f25279d = obj;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private boolean f25280a;

        /* renamed from: b, reason: collision with root package name */
        public l2 f25281b;

        /* renamed from: c, reason: collision with root package name */
        public int f25282c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f25283d;

        /* renamed from: e, reason: collision with root package name */
        public int f25284e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f25285f;

        /* renamed from: g, reason: collision with root package name */
        public int f25286g;

        public e(l2 l2Var) {
            this.f25281b = l2Var;
        }

        public void b(int i11) {
            this.f25280a |= i11 > 0;
            this.f25282c += i11;
        }

        public void c(int i11) {
            this.f25280a = true;
            this.f25285f = true;
            this.f25286g = i11;
        }

        public void d(l2 l2Var) {
            this.f25280a |= this.f25281b != l2Var;
            this.f25281b = l2Var;
        }

        public void e(int i11) {
            if (this.f25283d && this.f25284e != 5) {
                com.google.android.exoplayer2.util.a.a(i11 == 5);
                return;
            }
            this.f25280a = true;
            this.f25283d = true;
            this.f25284e = i11;
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final o.b f25287a;

        /* renamed from: b, reason: collision with root package name */
        public final long f25288b;

        /* renamed from: c, reason: collision with root package name */
        public final long f25289c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f25290d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f25291e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f25292f;

        public g(o.b bVar, long j11, long j12, boolean z10, boolean z11, boolean z12) {
            this.f25287a = bVar;
            this.f25288b = j11;
            this.f25289c = j12;
            this.f25290d = z10;
            this.f25291e = z11;
            this.f25292f = z12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final k3 f25293a;

        /* renamed from: b, reason: collision with root package name */
        public final int f25294b;

        /* renamed from: c, reason: collision with root package name */
        public final long f25295c;

        public h(k3 k3Var, int i11, long j11) {
            this.f25293a = k3Var;
            this.f25294b = i11;
            this.f25295c = j11;
        }
    }

    public l1(x2[] x2VarArr, la.q qVar, la.r rVar, t1 t1Var, com.google.android.exoplayer2.upstream.e eVar, int i11, boolean z10, e9.a aVar, c3 c3Var, s1 s1Var, long j11, boolean z11, Looper looper, com.google.android.exoplayer2.util.e eVar2, f fVar, e9.u1 u1Var) {
        this.f25262r = fVar;
        this.f25245a = x2VarArr;
        this.f25248d = qVar;
        this.f25249e = rVar;
        this.f25250f = t1Var;
        this.f25251g = eVar;
        this.E = i11;
        this.F = z10;
        this.f25267w = c3Var;
        this.f25265u = s1Var;
        this.f25266v = j11;
        this.P = j11;
        this.A = z11;
        this.f25261q = eVar2;
        this.f25257m = t1Var.getBackBufferDurationUs();
        this.f25258n = t1Var.retainBackBufferFromKeyframe();
        l2 j12 = l2.j(rVar);
        this.f25268x = j12;
        this.f25269y = new e(j12);
        this.f25247c = new z2[x2VarArr.length];
        for (int i12 = 0; i12 < x2VarArr.length; i12++) {
            x2VarArr[i12].g(i12, u1Var);
            this.f25247c[i12] = x2VarArr[i12].getCapabilities();
        }
        this.f25259o = new o(this, eVar2);
        this.f25260p = new ArrayList();
        this.f25246b = Sets.h();
        this.f25255k = new k3.d();
        this.f25256l = new k3.b();
        qVar.c(this, eVar);
        this.N = true;
        Handler handler = new Handler(looper);
        this.f25263s = new e2(aVar, handler);
        this.f25264t = new h2(this, aVar, handler, u1Var);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f25253i = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f25254j = looper2;
        this.f25252h = eVar2.createHandler(looper2, this);
    }

    private long A() {
        return B(this.f25268x.f25312p);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ac A[Catch: all -> 0x00af, TryCatch #1 {all -> 0x00af, blocks: (B:6:0x00a2, B:8:0x00ac, B:15:0x00b6, B:17:0x00bc, B:18:0x00bf, B:19:0x00c5, B:21:0x00cf, B:23:0x00d7, B:27:0x00df, B:28:0x00e9, B:30:0x00f9, B:34:0x0103, B:37:0x0115, B:40:0x011e), top: B:5:0x00a2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0(com.google.android.exoplayer2.l1.h r19) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l1.A0(com.google.android.exoplayer2.l1$h):void");
    }

    private long B(long j11) {
        b2 j12 = this.f25263s.j();
        if (j12 == null) {
            return 0L;
        }
        return Math.max(0L, j11 - j12.y(this.L));
    }

    private long B0(o.b bVar, long j11, boolean z10) {
        return C0(bVar, j11, this.f25263s.p() != this.f25263s.q(), z10);
    }

    private void C(com.google.android.exoplayer2.source.n nVar) {
        if (this.f25263s.v(nVar)) {
            this.f25263s.y(this.L);
            T();
        }
    }

    private long C0(o.b bVar, long j11, boolean z10, boolean z11) {
        g1();
        this.C = false;
        if (z11 || this.f25268x.f25301e == 3) {
            X0(2);
        }
        b2 p11 = this.f25263s.p();
        b2 b2Var = p11;
        while (b2Var != null && !bVar.equals(b2Var.f24863f.f24875a)) {
            b2Var = b2Var.j();
        }
        if (z10 || p11 != b2Var || (b2Var != null && b2Var.z(j11) < 0)) {
            for (x2 x2Var : this.f25245a) {
                m(x2Var);
            }
            if (b2Var != null) {
                while (this.f25263s.p() != b2Var) {
                    this.f25263s.b();
                }
                this.f25263s.z(b2Var);
                b2Var.x(1000000000000L);
                p();
            }
        }
        if (b2Var != null) {
            this.f25263s.z(b2Var);
            if (!b2Var.f24861d) {
                b2Var.f24863f = b2Var.f24863f.b(j11);
            } else if (b2Var.f24862e) {
                j11 = b2Var.f24858a.seekToUs(j11);
                b2Var.f24858a.discardBuffer(j11 - this.f25257m, this.f25258n);
            }
            q0(j11);
            T();
        } else {
            this.f25263s.f();
            q0(j11);
        }
        E(false);
        this.f25252h.sendEmptyMessage(2);
        return j11;
    }

    private void D(IOException iOException, int i11) {
        ExoPlaybackException createForSource = ExoPlaybackException.createForSource(iOException, i11);
        b2 p11 = this.f25263s.p();
        if (p11 != null) {
            createForSource = createForSource.copyWithMediaPeriodId(p11.f24863f.f24875a);
        }
        com.google.android.exoplayer2.util.s.d("ExoPlayerImplInternal", "Playback error", createForSource);
        f1(false, false);
        this.f25268x = this.f25268x.e(createForSource);
    }

    private void D0(s2 s2Var) {
        if (s2Var.f() == C.TIME_UNSET) {
            E0(s2Var);
            return;
        }
        if (this.f25268x.f25297a.u()) {
            this.f25260p.add(new d(s2Var));
            return;
        }
        d dVar = new d(s2Var);
        k3 k3Var = this.f25268x.f25297a;
        if (!s0(dVar, k3Var, k3Var, this.E, this.F, this.f25255k, this.f25256l)) {
            s2Var.k(false);
        } else {
            this.f25260p.add(dVar);
            Collections.sort(this.f25260p);
        }
    }

    private void E(boolean z10) {
        b2 j11 = this.f25263s.j();
        o.b bVar = j11 == null ? this.f25268x.f25298b : j11.f24863f.f24875a;
        boolean equals = this.f25268x.f25307k.equals(bVar);
        if (!equals) {
            this.f25268x = this.f25268x.b(bVar);
        }
        l2 l2Var = this.f25268x;
        l2Var.f25312p = j11 == null ? l2Var.f25314r : j11.i();
        this.f25268x.f25313q = A();
        if ((!equals || z10) && j11 != null && j11.f24861d) {
            i1(j11.n(), j11.o());
        }
    }

    private void E0(s2 s2Var) {
        if (s2Var.c() != this.f25254j) {
            this.f25252h.obtainMessage(15, s2Var).a();
            return;
        }
        l(s2Var);
        int i11 = this.f25268x.f25301e;
        if (i11 == 3 || i11 == 2) {
            this.f25252h.sendEmptyMessage(2);
        }
    }

    private void F(k3 k3Var, boolean z10) {
        int i11;
        int i12;
        boolean z11;
        g u02 = u0(k3Var, this.f25268x, this.K, this.f25263s, this.E, this.F, this.f25255k, this.f25256l);
        o.b bVar = u02.f25287a;
        long j11 = u02.f25289c;
        boolean z12 = u02.f25290d;
        long j12 = u02.f25288b;
        boolean z13 = (this.f25268x.f25298b.equals(bVar) && j12 == this.f25268x.f25314r) ? false : true;
        h hVar = null;
        long j13 = C.TIME_UNSET;
        try {
            if (u02.f25291e) {
                if (this.f25268x.f25301e != 1) {
                    X0(4);
                }
                o0(false, false, false, true);
            }
            try {
                if (z13) {
                    i12 = 4;
                    z11 = false;
                    if (!k3Var.u()) {
                        for (b2 p11 = this.f25263s.p(); p11 != null; p11 = p11.j()) {
                            if (p11.f24863f.f24875a.equals(bVar)) {
                                p11.f24863f = this.f25263s.r(k3Var, p11.f24863f);
                                p11.A();
                            }
                        }
                        j12 = B0(bVar, j12, z12);
                    }
                } else {
                    try {
                        try {
                            i12 = 4;
                            z11 = false;
                            if (!this.f25263s.F(k3Var, this.L, x())) {
                                z0(false);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            i11 = 4;
                            hVar = null;
                            l2 l2Var = this.f25268x;
                            k3 k3Var2 = l2Var.f25297a;
                            o.b bVar2 = l2Var.f25298b;
                            if (u02.f25292f) {
                                j13 = j12;
                            }
                            h hVar2 = hVar;
                            l1(k3Var, bVar, k3Var2, bVar2, j13);
                            if (z13 || j11 != this.f25268x.f25299c) {
                                l2 l2Var2 = this.f25268x;
                                Object obj = l2Var2.f25298b.f76237a;
                                k3 k3Var3 = l2Var2.f25297a;
                                this.f25268x = J(bVar, j12, j11, this.f25268x.f25300d, z13 && z10 && !k3Var3.u() && !k3Var3.l(obj, this.f25256l).f25213f, k3Var.f(obj) == -1 ? i11 : 3);
                            }
                            p0();
                            t0(k3Var, this.f25268x.f25297a);
                            this.f25268x = this.f25268x.i(k3Var);
                            if (!k3Var.u()) {
                                this.K = hVar2;
                            }
                            E(false);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i11 = 4;
                    }
                }
                l2 l2Var3 = this.f25268x;
                l1(k3Var, bVar, l2Var3.f25297a, l2Var3.f25298b, u02.f25292f ? j12 : -9223372036854775807L);
                if (z13 || j11 != this.f25268x.f25299c) {
                    l2 l2Var4 = this.f25268x;
                    Object obj2 = l2Var4.f25298b.f76237a;
                    k3 k3Var4 = l2Var4.f25297a;
                    this.f25268x = J(bVar, j12, j11, this.f25268x.f25300d, (!z13 || !z10 || k3Var4.u() || k3Var4.l(obj2, this.f25256l).f25213f) ? z11 : true, k3Var.f(obj2) == -1 ? i12 : 3);
                }
                p0();
                t0(k3Var, this.f25268x.f25297a);
                this.f25268x = this.f25268x.i(k3Var);
                if (!k3Var.u()) {
                    this.K = null;
                }
                E(z11);
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            i11 = 4;
        }
    }

    private void F0(final s2 s2Var) {
        Looper c11 = s2Var.c();
        if (c11.getThread().isAlive()) {
            this.f25261q.createHandler(c11, null).post(new Runnable() { // from class: com.google.android.exoplayer2.k1
                @Override // java.lang.Runnable
                public final void run() {
                    l1.this.S(s2Var);
                }
            });
        } else {
            com.google.android.exoplayer2.util.s.i("TAG", "Trying to send message on a dead thread.");
            s2Var.k(false);
        }
    }

    private void G(com.google.android.exoplayer2.source.n nVar) {
        if (this.f25263s.v(nVar)) {
            b2 j11 = this.f25263s.j();
            j11.p(this.f25259o.getPlaybackParameters().f25529a, this.f25268x.f25297a);
            i1(j11.n(), j11.o());
            if (j11 == this.f25263s.p()) {
                q0(j11.f24863f.f24876b);
                p();
                l2 l2Var = this.f25268x;
                o.b bVar = l2Var.f25298b;
                long j12 = j11.f24863f.f24876b;
                this.f25268x = J(bVar, j12, l2Var.f25299c, j12, false, 5);
            }
            T();
        }
    }

    private void G0(long j11) {
        for (x2 x2Var : this.f25245a) {
            if (x2Var.getStream() != null) {
                H0(x2Var, j11);
            }
        }
    }

    private void H(n2 n2Var, float f11, boolean z10, boolean z11) {
        if (z10) {
            if (z11) {
                this.f25269y.b(1);
            }
            this.f25268x = this.f25268x.f(n2Var);
        }
        m1(n2Var.f25529a);
        for (x2 x2Var : this.f25245a) {
            if (x2Var != null) {
                x2Var.d(f11, n2Var.f25529a);
            }
        }
    }

    private void H0(x2 x2Var, long j11) {
        x2Var.setCurrentStreamFinal();
        if (x2Var instanceof ba.p) {
            ((ba.p) x2Var).H(j11);
        }
    }

    private void I(n2 n2Var, boolean z10) {
        H(n2Var, n2Var.f25529a, true, z10);
    }

    private void I0(boolean z10, AtomicBoolean atomicBoolean) {
        if (this.G != z10) {
            this.G = z10;
            if (!z10) {
                for (x2 x2Var : this.f25245a) {
                    if (!O(x2Var) && this.f25246b.remove(x2Var)) {
                        x2Var.reset();
                    }
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    private l2 J(o.b bVar, long j11, long j12, long j13, boolean z10, int i11) {
        ImmutableList immutableList;
        t9.x xVar;
        la.r rVar;
        this.N = (!this.N && j11 == this.f25268x.f25314r && bVar.equals(this.f25268x.f25298b)) ? false : true;
        p0();
        l2 l2Var = this.f25268x;
        t9.x xVar2 = l2Var.f25304h;
        la.r rVar2 = l2Var.f25305i;
        ?? r12 = l2Var.f25306j;
        if (this.f25264t.s()) {
            b2 p11 = this.f25263s.p();
            t9.x n11 = p11 == null ? t9.x.f76286d : p11.n();
            la.r o11 = p11 == null ? this.f25249e : p11.o();
            ImmutableList t11 = t(o11.f68925c);
            if (p11 != null) {
                c2 c2Var = p11.f24863f;
                if (c2Var.f24877c != j12) {
                    p11.f24863f = c2Var.a(j12);
                }
            }
            xVar = n11;
            rVar = o11;
            immutableList = t11;
        } else if (bVar.equals(this.f25268x.f25298b)) {
            immutableList = r12;
            xVar = xVar2;
            rVar = rVar2;
        } else {
            xVar = t9.x.f76286d;
            rVar = this.f25249e;
            immutableList = ImmutableList.of();
        }
        if (z10) {
            this.f25269y.e(i11);
        }
        return this.f25268x.c(bVar, j11, j12, j13, A(), xVar, rVar, immutableList);
    }

    private void J0(b bVar) {
        this.f25269y.b(1);
        if (bVar.f25274c != -1) {
            this.K = new h(new t2(bVar.f25272a, bVar.f25273b), bVar.f25274c, bVar.f25275d);
        }
        F(this.f25264t.B(bVar.f25272a, bVar.f25273b), false);
    }

    private boolean K(x2 x2Var, b2 b2Var) {
        b2 j11 = b2Var.j();
        return b2Var.f24863f.f24880f && j11.f24861d && ((x2Var instanceof ba.p) || (x2Var instanceof com.google.android.exoplayer2.metadata.f) || x2Var.e() >= j11.m());
    }

    private boolean L() {
        b2 q11 = this.f25263s.q();
        if (!q11.f24861d) {
            return false;
        }
        int i11 = 0;
        while (true) {
            x2[] x2VarArr = this.f25245a;
            if (i11 >= x2VarArr.length) {
                return true;
            }
            x2 x2Var = x2VarArr[i11];
            t9.s sVar = q11.f24860c[i11];
            if (x2Var.getStream() != sVar || (sVar != null && !x2Var.hasReadStreamToEnd() && !K(x2Var, q11))) {
                break;
            }
            i11++;
        }
        return false;
    }

    private void L0(boolean z10) {
        if (z10 == this.I) {
            return;
        }
        this.I = z10;
        if (z10 || !this.f25268x.f25311o) {
            return;
        }
        this.f25252h.sendEmptyMessage(2);
    }

    private static boolean M(boolean z10, o.b bVar, long j11, o.b bVar2, k3.b bVar3, long j12) {
        if (!z10 && j11 == j12 && bVar.f76237a.equals(bVar2.f76237a)) {
            return (bVar.b() && bVar3.t(bVar.f76238b)) ? (bVar3.k(bVar.f76238b, bVar.f76239c) == 4 || bVar3.k(bVar.f76238b, bVar.f76239c) == 2) ? false : true : bVar2.b() && bVar3.t(bVar2.f76238b);
        }
        return false;
    }

    private void M0(boolean z10) {
        this.A = z10;
        p0();
        if (!this.B || this.f25263s.q() == this.f25263s.p()) {
            return;
        }
        z0(true);
        E(false);
    }

    private boolean N() {
        b2 j11 = this.f25263s.j();
        return (j11 == null || j11.k() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean O(x2 x2Var) {
        return x2Var.getState() != 0;
    }

    private void O0(boolean z10, int i11, boolean z11, int i12) {
        this.f25269y.b(z11 ? 1 : 0);
        this.f25269y.c(i12);
        this.f25268x = this.f25268x.d(z10, i11);
        this.C = false;
        d0(z10);
        if (!a1()) {
            g1();
            k1();
            return;
        }
        int i13 = this.f25268x.f25301e;
        if (i13 == 3) {
            d1();
            this.f25252h.sendEmptyMessage(2);
        } else if (i13 == 2) {
            this.f25252h.sendEmptyMessage(2);
        }
    }

    private boolean P() {
        b2 p11 = this.f25263s.p();
        long j11 = p11.f24863f.f24879e;
        return p11.f24861d && (j11 == C.TIME_UNSET || this.f25268x.f25314r < j11 || !a1());
    }

    private static boolean Q(l2 l2Var, k3.b bVar) {
        o.b bVar2 = l2Var.f25298b;
        k3 k3Var = l2Var.f25297a;
        return k3Var.u() || k3Var.l(bVar2.f76237a, bVar).f25213f;
    }

    private void Q0(n2 n2Var) {
        this.f25259o.b(n2Var);
        I(this.f25259o.getPlaybackParameters(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean R() {
        return Boolean.valueOf(this.f25270z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(s2 s2Var) {
        try {
            l(s2Var);
        } catch (ExoPlaybackException e11) {
            com.google.android.exoplayer2.util.s.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e11);
            throw new RuntimeException(e11);
        }
    }

    private void S0(int i11) {
        this.E = i11;
        if (!this.f25263s.G(this.f25268x.f25297a, i11)) {
            z0(true);
        }
        E(false);
    }

    private void T() {
        boolean Z0 = Z0();
        this.D = Z0;
        if (Z0) {
            this.f25263s.j().d(this.L);
        }
        h1();
    }

    private void T0(c3 c3Var) {
        this.f25267w = c3Var;
    }

    private void U() {
        this.f25269y.d(this.f25268x);
        if (this.f25269y.f25280a) {
            this.f25262r.a(this.f25269y);
            this.f25269y = new e(this.f25268x);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0079, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void V(long r9, long r11) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l1.V(long, long):void");
    }

    private void V0(boolean z10) {
        this.F = z10;
        if (!this.f25263s.H(this.f25268x.f25297a, z10)) {
            z0(true);
        }
        E(false);
    }

    private void W() {
        c2 o11;
        this.f25263s.y(this.L);
        if (this.f25263s.D() && (o11 = this.f25263s.o(this.L, this.f25268x)) != null) {
            b2 g11 = this.f25263s.g(this.f25247c, this.f25248d, this.f25250f.getAllocator(), this.f25264t, o11, this.f25249e);
            g11.f24858a.e(this, o11.f24876b);
            if (this.f25263s.p() == g11) {
                q0(o11.f24876b);
            }
            E(false);
        }
        if (!this.D) {
            T();
        } else {
            this.D = N();
            h1();
        }
    }

    private void W0(t9.t tVar) {
        this.f25269y.b(1);
        F(this.f25264t.C(tVar), false);
    }

    private void X() {
        boolean z10;
        boolean z11 = false;
        while (Y0()) {
            if (z11) {
                U();
            }
            b2 b2Var = (b2) com.google.android.exoplayer2.util.a.e(this.f25263s.b());
            if (this.f25268x.f25298b.f76237a.equals(b2Var.f24863f.f24875a.f76237a)) {
                o.b bVar = this.f25268x.f25298b;
                if (bVar.f76238b == -1) {
                    o.b bVar2 = b2Var.f24863f.f24875a;
                    if (bVar2.f76238b == -1 && bVar.f76241e != bVar2.f76241e) {
                        z10 = true;
                        c2 c2Var = b2Var.f24863f;
                        o.b bVar3 = c2Var.f24875a;
                        long j11 = c2Var.f24876b;
                        this.f25268x = J(bVar3, j11, c2Var.f24877c, j11, !z10, 0);
                        p0();
                        k1();
                        z11 = true;
                    }
                }
            }
            z10 = false;
            c2 c2Var2 = b2Var.f24863f;
            o.b bVar32 = c2Var2.f24875a;
            long j112 = c2Var2.f24876b;
            this.f25268x = J(bVar32, j112, c2Var2.f24877c, j112, !z10, 0);
            p0();
            k1();
            z11 = true;
        }
    }

    private void X0(int i11) {
        l2 l2Var = this.f25268x;
        if (l2Var.f25301e != i11) {
            if (i11 != 2) {
                this.Q = C.TIME_UNSET;
            }
            this.f25268x = l2Var.g(i11);
        }
    }

    private void Y() {
        b2 q11 = this.f25263s.q();
        if (q11 == null) {
            return;
        }
        int i11 = 0;
        if (q11.j() != null && !this.B) {
            if (L()) {
                if (q11.j().f24861d || this.L >= q11.j().m()) {
                    la.r o11 = q11.o();
                    b2 c11 = this.f25263s.c();
                    la.r o12 = c11.o();
                    k3 k3Var = this.f25268x.f25297a;
                    l1(k3Var, c11.f24863f.f24875a, k3Var, q11.f24863f.f24875a, C.TIME_UNSET);
                    if (c11.f24861d && c11.f24858a.readDiscontinuity() != C.TIME_UNSET) {
                        G0(c11.m());
                        return;
                    }
                    for (int i12 = 0; i12 < this.f25245a.length; i12++) {
                        boolean c12 = o11.c(i12);
                        boolean c13 = o12.c(i12);
                        if (c12 && !this.f25245a[i12].isCurrentStreamFinal()) {
                            boolean z10 = this.f25247c[i12].getTrackType() == -2;
                            a3 a3Var = o11.f68924b[i12];
                            a3 a3Var2 = o12.f68924b[i12];
                            if (!c13 || !a3Var2.equals(a3Var) || z10) {
                                H0(this.f25245a[i12], c11.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!q11.f24863f.f24883i && !this.B) {
            return;
        }
        while (true) {
            x2[] x2VarArr = this.f25245a;
            if (i11 >= x2VarArr.length) {
                return;
            }
            x2 x2Var = x2VarArr[i11];
            t9.s sVar = q11.f24860c[i11];
            if (sVar != null && x2Var.getStream() == sVar && x2Var.hasReadStreamToEnd()) {
                long j11 = q11.f24863f.f24879e;
                H0(x2Var, (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? -9223372036854775807L : q11.l() + q11.f24863f.f24879e);
            }
            i11++;
        }
    }

    private boolean Y0() {
        b2 p11;
        b2 j11;
        return a1() && !this.B && (p11 = this.f25263s.p()) != null && (j11 = p11.j()) != null && this.L >= j11.m() && j11.f24864g;
    }

    private void Z() {
        b2 q11 = this.f25263s.q();
        if (q11 == null || this.f25263s.p() == q11 || q11.f24864g || !m0()) {
            return;
        }
        p();
    }

    private boolean Z0() {
        if (!N()) {
            return false;
        }
        b2 j11 = this.f25263s.j();
        return this.f25250f.c(j11 == this.f25263s.p() ? j11.y(this.L) : j11.y(this.L) - j11.f24863f.f24876b, B(j11.k()), this.f25259o.getPlaybackParameters().f25529a);
    }

    private void a0() {
        F(this.f25264t.i(), true);
    }

    private boolean a1() {
        l2 l2Var = this.f25268x;
        return l2Var.f25308l && l2Var.f25309m == 0;
    }

    private void b0(c cVar) {
        this.f25269y.b(1);
        throw null;
    }

    private boolean b1(boolean z10) {
        if (this.J == 0) {
            return P();
        }
        if (!z10) {
            return false;
        }
        l2 l2Var = this.f25268x;
        if (!l2Var.f25303g) {
            return true;
        }
        long b11 = c1(l2Var.f25297a, this.f25263s.p().f24863f.f24875a) ? this.f25265u.b() : C.TIME_UNSET;
        b2 j11 = this.f25263s.j();
        return (j11.q() && j11.f24863f.f24883i) || (j11.f24863f.f24875a.b() && !j11.f24861d) || this.f25250f.a(A(), this.f25259o.getPlaybackParameters().f25529a, this.C, b11);
    }

    private void c0() {
        for (b2 p11 = this.f25263s.p(); p11 != null; p11 = p11.j()) {
            for (com.google.android.exoplayer2.trackselection.h hVar : p11.o().f68925c) {
                if (hVar != null) {
                    hVar.a();
                }
            }
        }
    }

    private boolean c1(k3 k3Var, o.b bVar) {
        if (bVar.b() || k3Var.u()) {
            return false;
        }
        k3Var.r(k3Var.l(bVar.f76237a, this.f25256l).f25210c, this.f25255k);
        if (!this.f25255k.i()) {
            return false;
        }
        k3.d dVar = this.f25255k;
        return dVar.f25231i && dVar.f25228f != C.TIME_UNSET;
    }

    private void d0(boolean z10) {
        for (b2 p11 = this.f25263s.p(); p11 != null; p11 = p11.j()) {
            for (com.google.android.exoplayer2.trackselection.h hVar : p11.o().f68925c) {
                if (hVar != null) {
                    hVar.b(z10);
                }
            }
        }
    }

    private void d1() {
        this.C = false;
        this.f25259o.f();
        for (x2 x2Var : this.f25245a) {
            if (O(x2Var)) {
                x2Var.start();
            }
        }
    }

    private void e0() {
        for (b2 p11 = this.f25263s.p(); p11 != null; p11 = p11.j()) {
            for (com.google.android.exoplayer2.trackselection.h hVar : p11.o().f68925c) {
                if (hVar != null) {
                    hVar.c();
                }
            }
        }
    }

    private void f1(boolean z10, boolean z11) {
        o0(z10 || !this.G, false, true, false);
        this.f25269y.b(z11 ? 1 : 0);
        this.f25250f.onStopped();
        X0(1);
    }

    private void g1() {
        this.f25259o.g();
        for (x2 x2Var : this.f25245a) {
            if (O(x2Var)) {
                r(x2Var);
            }
        }
    }

    private void h0() {
        this.f25269y.b(1);
        o0(false, false, false, true);
        this.f25250f.onPrepared();
        X0(this.f25268x.f25297a.u() ? 4 : 2);
        this.f25264t.v(this.f25251g.b());
        this.f25252h.sendEmptyMessage(2);
    }

    private void h1() {
        b2 j11 = this.f25263s.j();
        boolean z10 = this.D || (j11 != null && j11.f24858a.isLoading());
        l2 l2Var = this.f25268x;
        if (z10 != l2Var.f25303g) {
            this.f25268x = l2Var.a(z10);
        }
    }

    private void i1(t9.x xVar, la.r rVar) {
        this.f25250f.b(this.f25245a, xVar, rVar.f68925c);
    }

    private void j(b bVar, int i11) {
        this.f25269y.b(1);
        h2 h2Var = this.f25264t;
        if (i11 == -1) {
            i11 = h2Var.q();
        }
        F(h2Var.f(i11, bVar.f25272a, bVar.f25273b), false);
    }

    private void j0() {
        o0(true, false, true, false);
        this.f25250f.onReleased();
        X0(1);
        this.f25253i.quit();
        synchronized (this) {
            this.f25270z = true;
            notifyAll();
        }
    }

    private void j1() {
        if (this.f25268x.f25297a.u() || !this.f25264t.s()) {
            return;
        }
        W();
        Y();
        Z();
        X();
    }

    private void k() {
        z0(true);
    }

    private void k0(int i11, int i12, t9.t tVar) {
        this.f25269y.b(1);
        F(this.f25264t.z(i11, i12, tVar), false);
    }

    private void k1() {
        b2 p11 = this.f25263s.p();
        if (p11 == null) {
            return;
        }
        long readDiscontinuity = p11.f24861d ? p11.f24858a.readDiscontinuity() : -9223372036854775807L;
        if (readDiscontinuity != C.TIME_UNSET) {
            q0(readDiscontinuity);
            if (readDiscontinuity != this.f25268x.f25314r) {
                l2 l2Var = this.f25268x;
                this.f25268x = J(l2Var.f25298b, readDiscontinuity, l2Var.f25299c, readDiscontinuity, true, 5);
            }
        } else {
            long h11 = this.f25259o.h(p11 != this.f25263s.q());
            this.L = h11;
            long y10 = p11.y(h11);
            V(this.f25268x.f25314r, y10);
            this.f25268x.f25314r = y10;
        }
        this.f25268x.f25312p = this.f25263s.j().i();
        this.f25268x.f25313q = A();
        l2 l2Var2 = this.f25268x;
        if (l2Var2.f25308l && l2Var2.f25301e == 3 && c1(l2Var2.f25297a, l2Var2.f25298b) && this.f25268x.f25310n.f25529a == 1.0f) {
            float a11 = this.f25265u.a(u(), A());
            if (this.f25259o.getPlaybackParameters().f25529a != a11) {
                this.f25259o.b(this.f25268x.f25310n.e(a11));
                H(this.f25268x.f25310n, this.f25259o.getPlaybackParameters().f25529a, false, false);
            }
        }
    }

    private void l(s2 s2Var) {
        if (s2Var.j()) {
            return;
        }
        try {
            s2Var.g().handleMessage(s2Var.i(), s2Var.e());
        } finally {
            s2Var.k(true);
        }
    }

    private void l1(k3 k3Var, o.b bVar, k3 k3Var2, o.b bVar2, long j11) {
        if (!c1(k3Var, bVar)) {
            n2 n2Var = bVar.b() ? n2.f25527d : this.f25268x.f25310n;
            if (this.f25259o.getPlaybackParameters().equals(n2Var)) {
                return;
            }
            this.f25259o.b(n2Var);
            return;
        }
        k3Var.r(k3Var.l(bVar.f76237a, this.f25256l).f25210c, this.f25255k);
        this.f25265u.e((v1.g) com.google.android.exoplayer2.util.p0.j(this.f25255k.f25233k));
        if (j11 != C.TIME_UNSET) {
            this.f25265u.d(w(k3Var, bVar.f76237a, j11));
            return;
        }
        if (com.google.android.exoplayer2.util.p0.c(!k3Var2.u() ? k3Var2.r(k3Var2.l(bVar2.f76237a, this.f25256l).f25210c, this.f25255k).f25223a : null, this.f25255k.f25223a)) {
            return;
        }
        this.f25265u.d(C.TIME_UNSET);
    }

    private void m(x2 x2Var) {
        if (O(x2Var)) {
            this.f25259o.a(x2Var);
            r(x2Var);
            x2Var.disable();
            this.J--;
        }
    }

    private boolean m0() {
        b2 q11 = this.f25263s.q();
        la.r o11 = q11.o();
        int i11 = 0;
        boolean z10 = false;
        while (true) {
            x2[] x2VarArr = this.f25245a;
            if (i11 >= x2VarArr.length) {
                return !z10;
            }
            x2 x2Var = x2VarArr[i11];
            if (O(x2Var)) {
                boolean z11 = x2Var.getStream() != q11.f24860c[i11];
                if (!o11.c(i11) || z11) {
                    if (!x2Var.isCurrentStreamFinal()) {
                        x2Var.h(v(o11.f68925c[i11]), q11.f24860c[i11], q11.m(), q11.l());
                    } else if (x2Var.isEnded()) {
                        m(x2Var);
                    } else {
                        z10 = true;
                    }
                }
            }
            i11++;
        }
    }

    private void m1(float f11) {
        for (b2 p11 = this.f25263s.p(); p11 != null; p11 = p11.j()) {
            for (com.google.android.exoplayer2.trackselection.h hVar : p11.o().f68925c) {
                if (hVar != null) {
                    hVar.onPlaybackSpeed(f11);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void n() {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l1.n():void");
    }

    private void n0() {
        float f11 = this.f25259o.getPlaybackParameters().f25529a;
        b2 q11 = this.f25263s.q();
        boolean z10 = true;
        for (b2 p11 = this.f25263s.p(); p11 != null && p11.f24861d; p11 = p11.j()) {
            la.r v11 = p11.v(f11, this.f25268x.f25297a);
            if (!v11.a(p11.o())) {
                if (z10) {
                    b2 p12 = this.f25263s.p();
                    boolean z11 = this.f25263s.z(p12);
                    boolean[] zArr = new boolean[this.f25245a.length];
                    long b11 = p12.b(v11, this.f25268x.f25314r, z11, zArr);
                    l2 l2Var = this.f25268x;
                    boolean z12 = (l2Var.f25301e == 4 || b11 == l2Var.f25314r) ? false : true;
                    l2 l2Var2 = this.f25268x;
                    this.f25268x = J(l2Var2.f25298b, b11, l2Var2.f25299c, l2Var2.f25300d, z12, 5);
                    if (z12) {
                        q0(b11);
                    }
                    boolean[] zArr2 = new boolean[this.f25245a.length];
                    int i11 = 0;
                    while (true) {
                        x2[] x2VarArr = this.f25245a;
                        if (i11 >= x2VarArr.length) {
                            break;
                        }
                        x2 x2Var = x2VarArr[i11];
                        boolean O = O(x2Var);
                        zArr2[i11] = O;
                        t9.s sVar = p12.f24860c[i11];
                        if (O) {
                            if (sVar != x2Var.getStream()) {
                                m(x2Var);
                            } else if (zArr[i11]) {
                                x2Var.resetPosition(this.L);
                            }
                        }
                        i11++;
                    }
                    q(zArr2);
                } else {
                    this.f25263s.z(p11);
                    if (p11.f24861d) {
                        p11.a(v11, Math.max(p11.f24863f.f24876b, p11.y(this.L)), false);
                    }
                }
                E(true);
                if (this.f25268x.f25301e != 4) {
                    T();
                    k1();
                    this.f25252h.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (p11 == q11) {
                z10 = false;
            }
        }
    }

    private synchronized void n1(com.google.common.base.q qVar, long j11) {
        long elapsedRealtime = this.f25261q.elapsedRealtime() + j11;
        boolean z10 = false;
        while (!((Boolean) qVar.get()).booleanValue() && j11 > 0) {
            try {
                this.f25261q.a();
                wait(j11);
            } catch (InterruptedException unused) {
                z10 = true;
            }
            j11 = elapsedRealtime - this.f25261q.elapsedRealtime();
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    private void o(int i11, boolean z10) {
        x2 x2Var = this.f25245a[i11];
        if (O(x2Var)) {
            return;
        }
        b2 q11 = this.f25263s.q();
        boolean z11 = q11 == this.f25263s.p();
        la.r o11 = q11.o();
        a3 a3Var = o11.f68924b[i11];
        o1[] v11 = v(o11.f68925c[i11]);
        boolean z12 = a1() && this.f25268x.f25301e == 3;
        boolean z13 = !z10 && z12;
        this.J++;
        this.f25246b.add(x2Var);
        x2Var.c(a3Var, v11, q11.f24860c[i11], this.L, z13, z11, q11.m(), q11.l());
        x2Var.handleMessage(11, new a());
        this.f25259o.c(x2Var);
        if (z12) {
            x2Var.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void o0(boolean r29, boolean r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l1.o0(boolean, boolean, boolean, boolean):void");
    }

    private void p() {
        q(new boolean[this.f25245a.length]);
    }

    private void p0() {
        b2 p11 = this.f25263s.p();
        this.B = p11 != null && p11.f24863f.f24882h && this.A;
    }

    private void q(boolean[] zArr) {
        b2 q11 = this.f25263s.q();
        la.r o11 = q11.o();
        for (int i11 = 0; i11 < this.f25245a.length; i11++) {
            if (!o11.c(i11) && this.f25246b.remove(this.f25245a[i11])) {
                this.f25245a[i11].reset();
            }
        }
        for (int i12 = 0; i12 < this.f25245a.length; i12++) {
            if (o11.c(i12)) {
                o(i12, zArr[i12]);
            }
        }
        q11.f24864g = true;
    }

    private void q0(long j11) {
        b2 p11 = this.f25263s.p();
        long z10 = p11 == null ? j11 + 1000000000000L : p11.z(j11);
        this.L = z10;
        this.f25259o.d(z10);
        for (x2 x2Var : this.f25245a) {
            if (O(x2Var)) {
                x2Var.resetPosition(this.L);
            }
        }
        c0();
    }

    private void r(x2 x2Var) {
        if (x2Var.getState() == 2) {
            x2Var.stop();
        }
    }

    private static void r0(k3 k3Var, d dVar, k3.d dVar2, k3.b bVar) {
        int i11 = k3Var.r(k3Var.l(dVar.f25279d, bVar).f25210c, dVar2).f25238p;
        Object obj = k3Var.k(i11, bVar, true).f25209b;
        long j11 = bVar.f25211d;
        dVar.b(i11, j11 != C.TIME_UNSET ? j11 - 1 : Long.MAX_VALUE, obj);
    }

    private static boolean s0(d dVar, k3 k3Var, k3 k3Var2, int i11, boolean z10, k3.d dVar2, k3.b bVar) {
        Object obj = dVar.f25279d;
        if (obj == null) {
            Pair v02 = v0(k3Var, new h(dVar.f25276a.h(), dVar.f25276a.d(), dVar.f25276a.f() == Long.MIN_VALUE ? C.TIME_UNSET : com.google.android.exoplayer2.util.p0.B0(dVar.f25276a.f())), false, i11, z10, dVar2, bVar);
            if (v02 == null) {
                return false;
            }
            dVar.b(k3Var.f(v02.first), ((Long) v02.second).longValue(), v02.first);
            if (dVar.f25276a.f() == Long.MIN_VALUE) {
                r0(k3Var, dVar, dVar2, bVar);
            }
            return true;
        }
        int f11 = k3Var.f(obj);
        if (f11 == -1) {
            return false;
        }
        if (dVar.f25276a.f() == Long.MIN_VALUE) {
            r0(k3Var, dVar, dVar2, bVar);
            return true;
        }
        dVar.f25277b = f11;
        k3Var2.l(dVar.f25279d, bVar);
        if (bVar.f25213f && k3Var2.r(bVar.f25210c, dVar2).f25237o == k3Var2.f(dVar.f25279d)) {
            Pair n11 = k3Var.n(dVar2, bVar, k3Var.l(dVar.f25279d, bVar).f25210c, dVar.f25278c + bVar.q());
            dVar.b(k3Var.f(n11.first), ((Long) n11.second).longValue(), n11.first);
        }
        return true;
    }

    private ImmutableList t(com.google.android.exoplayer2.trackselection.h[] hVarArr) {
        ImmutableList.a aVar = new ImmutableList.a();
        boolean z10 = false;
        for (com.google.android.exoplayer2.trackselection.h hVar : hVarArr) {
            if (hVar != null) {
                Metadata metadata = hVar.getFormat(0).f25548j;
                if (metadata == null) {
                    aVar.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    aVar.a(metadata);
                    z10 = true;
                }
            }
        }
        return z10 ? aVar.e() : ImmutableList.of();
    }

    private void t0(k3 k3Var, k3 k3Var2) {
        if (k3Var.u() && k3Var2.u()) {
            return;
        }
        for (int size = this.f25260p.size() - 1; size >= 0; size--) {
            if (!s0((d) this.f25260p.get(size), k3Var, k3Var2, this.E, this.F, this.f25255k, this.f25256l)) {
                ((d) this.f25260p.get(size)).f25276a.k(false);
                this.f25260p.remove(size);
            }
        }
        Collections.sort(this.f25260p);
    }

    private long u() {
        l2 l2Var = this.f25268x;
        return w(l2Var.f25297a, l2Var.f25298b.f76237a, l2Var.f25314r);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.l1.g u0(com.google.android.exoplayer2.k3 r30, com.google.android.exoplayer2.l2 r31, com.google.android.exoplayer2.l1.h r32, com.google.android.exoplayer2.e2 r33, int r34, boolean r35, com.google.android.exoplayer2.k3.d r36, com.google.android.exoplayer2.k3.b r37) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l1.u0(com.google.android.exoplayer2.k3, com.google.android.exoplayer2.l2, com.google.android.exoplayer2.l1$h, com.google.android.exoplayer2.e2, int, boolean, com.google.android.exoplayer2.k3$d, com.google.android.exoplayer2.k3$b):com.google.android.exoplayer2.l1$g");
    }

    private static o1[] v(com.google.android.exoplayer2.trackselection.h hVar) {
        int length = hVar != null ? hVar.length() : 0;
        o1[] o1VarArr = new o1[length];
        for (int i11 = 0; i11 < length; i11++) {
            o1VarArr[i11] = hVar.getFormat(i11);
        }
        return o1VarArr;
    }

    private static Pair v0(k3 k3Var, h hVar, boolean z10, int i11, boolean z11, k3.d dVar, k3.b bVar) {
        Pair n11;
        Object w02;
        k3 k3Var2 = hVar.f25293a;
        if (k3Var.u()) {
            return null;
        }
        k3 k3Var3 = k3Var2.u() ? k3Var : k3Var2;
        try {
            n11 = k3Var3.n(dVar, bVar, hVar.f25294b, hVar.f25295c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (k3Var.equals(k3Var3)) {
            return n11;
        }
        if (k3Var.f(n11.first) != -1) {
            return (k3Var3.l(n11.first, bVar).f25213f && k3Var3.r(bVar.f25210c, dVar).f25237o == k3Var3.f(n11.first)) ? k3Var.n(dVar, bVar, k3Var.l(n11.first, bVar).f25210c, hVar.f25295c) : n11;
        }
        if (z10 && (w02 = w0(dVar, bVar, i11, z11, n11.first, k3Var3, k3Var)) != null) {
            return k3Var.n(dVar, bVar, k3Var.l(w02, bVar).f25210c, C.TIME_UNSET);
        }
        return null;
    }

    private long w(k3 k3Var, Object obj, long j11) {
        k3Var.r(k3Var.l(obj, this.f25256l).f25210c, this.f25255k);
        k3.d dVar = this.f25255k;
        if (dVar.f25228f != C.TIME_UNSET && dVar.i()) {
            k3.d dVar2 = this.f25255k;
            if (dVar2.f25231i) {
                return com.google.android.exoplayer2.util.p0.B0(dVar2.d() - this.f25255k.f25228f) - (j11 + this.f25256l.q());
            }
        }
        return C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object w0(k3.d dVar, k3.b bVar, int i11, boolean z10, Object obj, k3 k3Var, k3 k3Var2) {
        int f11 = k3Var.f(obj);
        int m11 = k3Var.m();
        int i12 = f11;
        int i13 = -1;
        for (int i14 = 0; i14 < m11 && i13 == -1; i14++) {
            i12 = k3Var.h(i12, bVar, dVar, i11, z10);
            if (i12 == -1) {
                break;
            }
            i13 = k3Var2.f(k3Var.q(i12));
        }
        if (i13 == -1) {
            return null;
        }
        return k3Var2.q(i13);
    }

    private long x() {
        b2 q11 = this.f25263s.q();
        if (q11 == null) {
            return 0L;
        }
        long l11 = q11.l();
        if (!q11.f24861d) {
            return l11;
        }
        int i11 = 0;
        while (true) {
            x2[] x2VarArr = this.f25245a;
            if (i11 >= x2VarArr.length) {
                return l11;
            }
            if (O(x2VarArr[i11]) && this.f25245a[i11].getStream() == q11.f24860c[i11]) {
                long e11 = this.f25245a[i11].e();
                if (e11 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                l11 = Math.max(e11, l11);
            }
            i11++;
        }
    }

    private void x0(long j11, long j12) {
        this.f25252h.sendEmptyMessageAtTime(2, j11 + j12);
    }

    private Pair y(k3 k3Var) {
        if (k3Var.u()) {
            return Pair.create(l2.k(), 0L);
        }
        Pair n11 = k3Var.n(this.f25255k, this.f25256l, k3Var.e(this.F), C.TIME_UNSET);
        o.b B = this.f25263s.B(k3Var, n11.first, 0L);
        long longValue = ((Long) n11.second).longValue();
        if (B.b()) {
            k3Var.l(B.f76237a, this.f25256l);
            longValue = B.f76239c == this.f25256l.n(B.f76238b) ? this.f25256l.j() : 0L;
        }
        return Pair.create(B, Long.valueOf(longValue));
    }

    private void z0(boolean z10) {
        o.b bVar = this.f25263s.p().f24863f.f24875a;
        long C0 = C0(bVar, this.f25268x.f25314r, true, false);
        if (C0 != this.f25268x.f25314r) {
            l2 l2Var = this.f25268x;
            this.f25268x = J(bVar, C0, l2Var.f25299c, l2Var.f25300d, z10, 5);
        }
    }

    public void K0(List list, int i11, long j11, t9.t tVar) {
        this.f25252h.obtainMessage(17, new b(list, tVar, i11, j11, null)).a();
    }

    public void N0(boolean z10, int i11) {
        this.f25252h.obtainMessage(1, z10 ? 1 : 0, i11).a();
    }

    public void P0(n2 n2Var) {
        this.f25252h.obtainMessage(4, n2Var).a();
    }

    public void R0(int i11) {
        this.f25252h.obtainMessage(11, i11, 0).a();
    }

    public void U0(boolean z10) {
        this.f25252h.obtainMessage(12, z10 ? 1 : 0, 0).a();
    }

    @Override // com.google.android.exoplayer2.h2.d
    public void a() {
        this.f25252h.sendEmptyMessage(22);
    }

    @Override // com.google.android.exoplayer2.s2.a
    public synchronized void b(s2 s2Var) {
        if (!this.f25270z && this.f25253i.isAlive()) {
            this.f25252h.obtainMessage(14, s2Var).a();
            return;
        }
        com.google.android.exoplayer2.util.s.i("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        s2Var.k(false);
    }

    public void e1() {
        this.f25252h.obtainMessage(6).a();
    }

    @Override // com.google.android.exoplayer2.source.b0.a
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void g(com.google.android.exoplayer2.source.n nVar) {
        this.f25252h.obtainMessage(9, nVar).a();
    }

    public void g0() {
        this.f25252h.obtainMessage(0).a();
    }

    @Override // com.google.android.exoplayer2.source.n.a
    public void h(com.google.android.exoplayer2.source.n nVar) {
        this.f25252h.obtainMessage(8, nVar).a();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i11;
        b2 q11;
        try {
            switch (message.what) {
                case 0:
                    h0();
                    break;
                case 1:
                    O0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    n();
                    break;
                case 3:
                    A0((h) message.obj);
                    break;
                case 4:
                    Q0((n2) message.obj);
                    break;
                case 5:
                    T0((c3) message.obj);
                    break;
                case 6:
                    f1(false, true);
                    break;
                case 7:
                    j0();
                    return true;
                case 8:
                    G((com.google.android.exoplayer2.source.n) message.obj);
                    break;
                case 9:
                    C((com.google.android.exoplayer2.source.n) message.obj);
                    break;
                case 10:
                    n0();
                    break;
                case 11:
                    S0(message.arg1);
                    break;
                case 12:
                    V0(message.arg1 != 0);
                    break;
                case 13:
                    I0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    D0((s2) message.obj);
                    break;
                case 15:
                    F0((s2) message.obj);
                    break;
                case 16:
                    I((n2) message.obj, false);
                    break;
                case 17:
                    J0((b) message.obj);
                    break;
                case 18:
                    j((b) message.obj, message.arg1);
                    break;
                case 19:
                    android.support.v4.media.session.c.a(message.obj);
                    b0(null);
                    break;
                case 20:
                    k0(message.arg1, message.arg2, (t9.t) message.obj);
                    break;
                case 21:
                    W0((t9.t) message.obj);
                    break;
                case 22:
                    a0();
                    break;
                case 23:
                    M0(message.arg1 != 0);
                    break;
                case 24:
                    L0(message.arg1 == 1);
                    break;
                case 25:
                    k();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e11) {
            e = e11;
            if (e.type == 1 && (q11 = this.f25263s.q()) != null) {
                e = e.copyWithMediaPeriodId(q11.f24863f.f24875a);
            }
            if (e.isRecoverable && this.O == null) {
                com.google.android.exoplayer2.util.s.j("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.O = e;
                com.google.android.exoplayer2.util.o oVar = this.f25252h;
                oVar.b(oVar.obtainMessage(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.O;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.O;
                }
                com.google.android.exoplayer2.util.s.d("ExoPlayerImplInternal", "Playback error", e);
                f1(true, false);
                this.f25268x = this.f25268x.e(e);
            }
        } catch (ParserException e12) {
            int i12 = e12.dataType;
            if (i12 == 1) {
                i11 = e12.contentIsMalformed ? 3001 : 3003;
            } else {
                if (i12 == 4) {
                    i11 = e12.contentIsMalformed ? 3002 : 3004;
                }
                D(e12, r2);
            }
            r2 = i11;
            D(e12, r2);
        } catch (DrmSession.DrmSessionException e13) {
            D(e13, e13.errorCode);
        } catch (BehindLiveWindowException e14) {
            D(e14, 1002);
        } catch (DataSourceException e15) {
            D(e15, e15.reason);
        } catch (IOException e16) {
            D(e16, 2000);
        } catch (RuntimeException e17) {
            ExoPlaybackException createForUnexpected = ExoPlaybackException.createForUnexpected(e17, ((e17 instanceof IllegalStateException) || (e17 instanceof IllegalArgumentException)) ? 1004 : 1000);
            com.google.android.exoplayer2.util.s.d("ExoPlayerImplInternal", "Playback error", createForUnexpected);
            f1(true, false);
            this.f25268x = this.f25268x.e(createForUnexpected);
        }
        U();
        return true;
    }

    public synchronized boolean i0() {
        if (!this.f25270z && this.f25253i.isAlive()) {
            this.f25252h.sendEmptyMessage(7);
            n1(new com.google.common.base.q() { // from class: com.google.android.exoplayer2.j1
                @Override // com.google.common.base.q
                public final Object get() {
                    Boolean R;
                    R = l1.this.R();
                    return R;
                }
            }, this.f25266v);
            return this.f25270z;
        }
        return true;
    }

    public void l0(int i11, int i12, t9.t tVar) {
        this.f25252h.obtainMessage(20, i11, i12, tVar).a();
    }

    @Override // com.google.android.exoplayer2.o.a
    public void onPlaybackParametersChanged(n2 n2Var) {
        this.f25252h.obtainMessage(16, n2Var).a();
    }

    @Override // la.q.a
    public void onTrackSelectionsInvalidated() {
        this.f25252h.sendEmptyMessage(10);
    }

    public void s(long j11) {
        this.P = j11;
    }

    public void y0(k3 k3Var, int i11, long j11) {
        this.f25252h.obtainMessage(3, new h(k3Var, i11, j11)).a();
    }

    public Looper z() {
        return this.f25254j;
    }
}
