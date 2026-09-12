package e9;

import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.p3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.v1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.g3;
import e9.c;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* loaded from: classes4.dex */
public class p1 implements e9.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.e f61836a;

    /* renamed from: b, reason: collision with root package name */
    private final k3.b f61837b;

    /* renamed from: c, reason: collision with root package name */
    private final k3.d f61838c;

    /* renamed from: d, reason: collision with root package name */
    private final a f61839d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray f61840e;

    /* renamed from: f, reason: collision with root package name */
    private com.google.android.exoplayer2.util.r f61841f;

    /* renamed from: g, reason: collision with root package name */
    private o2 f61842g;

    /* renamed from: h, reason: collision with root package name */
    private com.google.android.exoplayer2.util.o f61843h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f61844i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final k3.b f61845a;

        /* renamed from: b, reason: collision with root package name */
        private ImmutableList f61846b = ImmutableList.of();

        /* renamed from: c, reason: collision with root package name */
        private ImmutableMap f61847c = ImmutableMap.of();

        /* renamed from: d, reason: collision with root package name */
        private o.b f61848d;

        /* renamed from: e, reason: collision with root package name */
        private o.b f61849e;

        /* renamed from: f, reason: collision with root package name */
        private o.b f61850f;

        public a(k3.b bVar) {
            this.f61845a = bVar;
        }

        private void b(ImmutableMap.b bVar, o.b bVar2, k3 k3Var) {
            if (bVar2 == null) {
                return;
            }
            if (k3Var.f(bVar2.f76237a) != -1) {
                bVar.h(bVar2, k3Var);
                return;
            }
            k3 k3Var2 = (k3) this.f61847c.get(bVar2);
            if (k3Var2 != null) {
                bVar.h(bVar2, k3Var2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static o.b c(o2 o2Var, ImmutableList immutableList, o.b bVar, k3.b bVar2) {
            k3 currentTimeline = o2Var.getCurrentTimeline();
            int currentPeriodIndex = o2Var.getCurrentPeriodIndex();
            Object q11 = currentTimeline.u() ? null : currentTimeline.q(currentPeriodIndex);
            int g11 = (o2Var.isPlayingAd() || currentTimeline.u()) ? -1 : currentTimeline.j(currentPeriodIndex, bVar2).g(com.google.android.exoplayer2.util.p0.B0(o2Var.getCurrentPosition()) - bVar2.q());
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                o.b bVar3 = (o.b) immutableList.get(i11);
                if (i(bVar3, q11, o2Var.isPlayingAd(), o2Var.getCurrentAdGroupIndex(), o2Var.getCurrentAdIndexInAdGroup(), g11)) {
                    return bVar3;
                }
            }
            if (immutableList.isEmpty() && bVar != null) {
                if (i(bVar, q11, o2Var.isPlayingAd(), o2Var.getCurrentAdGroupIndex(), o2Var.getCurrentAdIndexInAdGroup(), g11)) {
                    return bVar;
                }
            }
            return null;
        }

        private static boolean i(o.b bVar, Object obj, boolean z10, int i11, int i12, int i13) {
            if (bVar.f76237a.equals(obj)) {
                return (z10 && bVar.f76238b == i11 && bVar.f76239c == i12) || (!z10 && bVar.f76238b == -1 && bVar.f76241e == i13);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void m(k3 k3Var) {
            ImmutableMap.b builder = ImmutableMap.builder();
            if (this.f61846b.isEmpty()) {
                b(builder, this.f61849e, k3Var);
                if (!com.google.common.base.j.a(this.f61850f, this.f61849e)) {
                    b(builder, this.f61850f, k3Var);
                }
                if (!com.google.common.base.j.a(this.f61848d, this.f61849e) && !com.google.common.base.j.a(this.f61848d, this.f61850f)) {
                    b(builder, this.f61848d, k3Var);
                }
            } else {
                for (int i11 = 0; i11 < this.f61846b.size(); i11++) {
                    b(builder, (o.b) this.f61846b.get(i11), k3Var);
                }
                if (!this.f61846b.contains(this.f61848d)) {
                    b(builder, this.f61848d, k3Var);
                }
            }
            this.f61847c = builder.d();
        }

        public o.b d() {
            return this.f61848d;
        }

        public o.b e() {
            if (this.f61846b.isEmpty()) {
                return null;
            }
            return (o.b) g3.g(this.f61846b);
        }

        public k3 f(o.b bVar) {
            return (k3) this.f61847c.get(bVar);
        }

        public o.b g() {
            return this.f61849e;
        }

        public o.b h() {
            return this.f61850f;
        }

        public void j(o2 o2Var) {
            this.f61848d = c(o2Var, this.f61846b, this.f61849e, this.f61845a);
        }

        public void k(List list, o.b bVar, o2 o2Var) {
            this.f61846b = ImmutableList.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.f61849e = (o.b) list.get(0);
                this.f61850f = (o.b) com.google.android.exoplayer2.util.a.e(bVar);
            }
            if (this.f61848d == null) {
                this.f61848d = c(o2Var, this.f61846b, this.f61849e, this.f61845a);
            }
            m(o2Var.getCurrentTimeline());
        }

        public void l(o2 o2Var) {
            this.f61848d = c(o2Var, this.f61846b, this.f61849e, this.f61845a);
            m(o2Var.getCurrentTimeline());
        }
    }

    public p1(com.google.android.exoplayer2.util.e eVar) {
        this.f61836a = (com.google.android.exoplayer2.util.e) com.google.android.exoplayer2.util.a.e(eVar);
        this.f61841f = new com.google.android.exoplayer2.util.r(com.google.android.exoplayer2.util.p0.Q(), eVar, new r.b() { // from class: e9.a0
            @Override // com.google.android.exoplayer2.util.r.b
            public final void a(Object obj, com.google.android.exoplayer2.util.m mVar) {
                p1.a1((c) obj, mVar);
            }
        });
        k3.b bVar = new k3.b();
        this.f61837b = bVar;
        this.f61838c = new k3.d();
        this.f61839d = new a(bVar);
        this.f61840e = new SparseArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P1(c.a aVar, int i11, o2.e eVar, o2.e eVar2, c cVar) {
        cVar.R(aVar, i11);
        cVar.k(aVar, eVar, eVar2, i11);
    }

    private c.a U0(o.b bVar) {
        com.google.android.exoplayer2.util.a.e(this.f61842g);
        k3 f11 = bVar == null ? null : this.f61839d.f(bVar);
        if (bVar != null && f11 != null) {
            return T0(f11, f11.l(bVar.f76237a, this.f61837b).f25210c, bVar);
        }
        int t11 = this.f61842g.t();
        k3 currentTimeline = this.f61842g.getCurrentTimeline();
        if (t11 >= currentTimeline.t()) {
            currentTimeline = k3.f25205a;
        }
        return T0(currentTimeline, t11, null);
    }

    private c.a V0() {
        return U0(this.f61839d.e());
    }

    private c.a W0(int i11, o.b bVar) {
        com.google.android.exoplayer2.util.a.e(this.f61842g);
        if (bVar != null) {
            return this.f61839d.f(bVar) != null ? U0(bVar) : T0(k3.f25205a, i11, bVar);
        }
        k3 currentTimeline = this.f61842g.getCurrentTimeline();
        if (i11 >= currentTimeline.t()) {
            currentTimeline = k3.f25205a;
        }
        return T0(currentTimeline, i11, null);
    }

    private c.a X0() {
        return U0(this.f61839d.g());
    }

    private c.a Y0() {
        return U0(this.f61839d.h());
    }

    private c.a Z0(PlaybackException playbackException) {
        t9.j jVar;
        return (!(playbackException instanceof ExoPlaybackException) || (jVar = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? S0() : U0(new o.b(jVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a1(c cVar, com.google.android.exoplayer2.util.m mVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b2(c.a aVar, String str, long j11, long j12, c cVar) {
        cVar.Y(aVar, str, j11);
        cVar.j0(aVar, str, j12, j11);
        cVar.Z(aVar, 2, str, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d1(c.a aVar, String str, long j11, long j12, c cVar) {
        cVar.C(aVar, str, j11);
        cVar.e0(aVar, str, j12, j11);
        cVar.Z(aVar, 1, str, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d2(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.U(aVar, eVar);
        cVar.g0(aVar, 2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e2(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.H(aVar, eVar);
        cVar.N(aVar, 2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f1(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.P(aVar, eVar);
        cVar.g0(aVar, 1, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g1(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.t(aVar, eVar);
        cVar.N(aVar, 1, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g2(c.a aVar, com.google.android.exoplayer2.o1 o1Var, com.google.android.exoplayer2.decoder.g gVar, c cVar) {
        cVar.o0(aVar, o1Var);
        cVar.e(aVar, o1Var, gVar);
        cVar.D(aVar, 2, o1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h1(c.a aVar, com.google.android.exoplayer2.o1 o1Var, com.google.android.exoplayer2.decoder.g gVar, c cVar) {
        cVar.w(aVar, o1Var);
        cVar.B(aVar, o1Var, gVar);
        cVar.D(aVar, 1, o1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h2(c.a aVar, com.google.android.exoplayer2.video.y yVar, c cVar) {
        cVar.v0(aVar, yVar);
        cVar.u0(aVar, yVar.f28063a, yVar.f28064b, yVar.f28065c, yVar.f28066d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(o2 o2Var, c cVar, com.google.android.exoplayer2.util.m mVar) {
        cVar.I(o2Var, new c.b(mVar, this.f61840e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2() {
        final c.a S0 = S0();
        m2(S0, 1028, new r.a() { // from class: e9.h1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).h0(c.a.this);
            }
        });
        this.f61841f.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v1(c.a aVar, int i11, c cVar) {
        cVar.E(aVar);
        cVar.m(aVar, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z1(c.a aVar, boolean z10, c cVar) {
        cVar.b(aVar, z10);
        cVar.c0(aVar, z10);
    }

    @Override // e9.a
    public final void A(List list, o.b bVar) {
        this.f61839d.k(list, bVar, (o2) com.google.android.exoplayer2.util.a.e(this.f61842g));
    }

    @Override // com.google.android.exoplayer2.drm.s
    public final void B(int i11, o.b bVar) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1023, new r.a() { // from class: e9.i1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).f0(c.a.this);
            }
        });
    }

    @Override // e9.a
    public void C(c cVar) {
        com.google.android.exoplayer2.util.a.e(cVar);
        this.f61841f.c(cVar);
    }

    @Override // com.google.android.exoplayer2.drm.s
    public final void D(int i11, o.b bVar, final int i12) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1022, new r.a() { // from class: e9.u0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.v1(c.a.this, i12, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.s
    public final void E(int i11, o.b bVar) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1027, new r.a() { // from class: e9.g0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).t0(c.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.s
    public final void F(int i11, o.b bVar) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, InputDeviceCompat.SOURCE_GAMEPAD, new r.a() { // from class: e9.j1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).f(c.a.this);
            }
        });
    }

    protected final c.a S0() {
        return U0(this.f61839d.d());
    }

    protected final c.a T0(k3 k3Var, int i11, o.b bVar) {
        o.b bVar2 = k3Var.u() ? null : bVar;
        long elapsedRealtime = this.f61836a.elapsedRealtime();
        boolean z10 = k3Var.equals(this.f61842g.getCurrentTimeline()) && i11 == this.f61842g.t();
        long j11 = 0;
        if (bVar2 == null || !bVar2.b()) {
            if (z10) {
                j11 = this.f61842g.getContentPosition();
            } else if (!k3Var.u()) {
                j11 = k3Var.r(i11, this.f61838c).e();
            }
        } else if (z10 && this.f61842g.getCurrentAdGroupIndex() == bVar2.f76238b && this.f61842g.getCurrentAdIndexInAdGroup() == bVar2.f76239c) {
            j11 = this.f61842g.getCurrentPosition();
        }
        return new c.a(elapsedRealtime, k3Var, i11, bVar2, j11, this.f61842g.getCurrentTimeline(), this.f61842g.t(), this.f61839d.d(), this.f61842g.getCurrentPosition(), this.f61842g.d());
    }

    @Override // e9.a
    public final void a(final Exception exc) {
        final c.a Y0 = Y0();
        m2(Y0, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new r.a() { // from class: e9.n0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).w0(c.a.this, exc);
            }
        });
    }

    @Override // e9.a
    public final void b(final String str) {
        final c.a Y0 = Y0();
        m2(Y0, PointerIconCompat.TYPE_ZOOM_OUT, new r.a() { // from class: e9.a1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).a(c.a.this, str);
            }
        });
    }

    @Override // e9.a
    public final void c(final String str) {
        final c.a Y0 = Y0();
        m2(Y0, 1012, new r.a() { // from class: e9.d0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).n(c.a.this, str);
            }
        });
    }

    @Override // e9.a
    public final void d(final long j11) {
        final c.a Y0 = Y0();
        m2(Y0, 1010, new r.a() { // from class: e9.f0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).m0(c.a.this, j11);
            }
        });
    }

    @Override // e9.a
    public final void e(final Exception exc) {
        final c.a Y0 = Y0();
        m2(Y0, 1030, new r.a() { // from class: e9.m1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).r0(c.a.this, exc);
            }
        });
    }

    @Override // e9.a
    public final void f(final Object obj, final long j11) {
        final c.a Y0 = Y0();
        m2(Y0, 26, new r.a() { // from class: e9.e1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj2) {
                ((c) obj2).A(c.a.this, obj, j11);
            }
        });
    }

    @Override // e9.a
    public final void g(final Exception exc) {
        final c.a Y0 = Y0();
        m2(Y0, 1029, new r.a() { // from class: e9.n1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).v(c.a.this, exc);
            }
        });
    }

    @Override // e9.a
    public final void h(final int i11, final long j11, final long j12) {
        final c.a Y0 = Y0();
        m2(Y0, 1011, new r.a() { // from class: e9.f1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).F(c.a.this, i11, j11, j12);
            }
        });
    }

    @Override // e9.a
    public final void i(final long j11, final int i11) {
        final c.a X0 = X0();
        m2(X0, PointerIconCompat.TYPE_GRABBING, new r.a() { // from class: e9.o0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).G(c.a.this, j11, i11);
            }
        });
    }

    @Override // e9.a
    public final void j(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a Y0 = Y0();
        m2(Y0, PointerIconCompat.TYPE_CROSSHAIR, new r.a() { // from class: e9.s0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.g1(c.a.this, eVar, (c) obj);
            }
        });
    }

    @Override // e9.a
    public final void k(final com.google.android.exoplayer2.o1 o1Var, final com.google.android.exoplayer2.decoder.g gVar) {
        final c.a Y0 = Y0();
        m2(Y0, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new r.a() { // from class: e9.v
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.g2(c.a.this, o1Var, gVar, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.p
    public final void l(int i11, o.b bVar, final t9.i iVar) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1005, new r.a() { // from class: e9.p0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).n0(c.a.this, iVar);
            }
        });
    }

    @Override // e9.a
    public final void m() {
        if (this.f61844i) {
            return;
        }
        final c.a S0 = S0();
        this.f61844i = true;
        m2(S0, -1, new r.a() { // from class: e9.k
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).L(c.a.this);
            }
        });
    }

    protected final void m2(c.a aVar, int i11, r.a aVar2) {
        this.f61840e.put(i11, aVar);
        this.f61841f.l(i11, aVar2);
    }

    @Override // e9.a
    public final void n(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a X0 = X0();
        m2(X0, PointerIconCompat.TYPE_GRAB, new r.a() { // from class: e9.z
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.d2(c.a.this, eVar, (c) obj);
            }
        });
    }

    @Override // e9.a
    public final void o(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a X0 = X0();
        m2(X0, PointerIconCompat.TYPE_ALL_SCROLL, new r.a() { // from class: e9.c0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.f1(c.a.this, eVar, (c) obj);
            }
        });
    }

    @Override // e9.a
    public final void onAudioDecoderInitialized(final String str, final long j11, final long j12) {
        final c.a Y0 = Y0();
        m2(Y0, PointerIconCompat.TYPE_TEXT, new r.a() { // from class: e9.d
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.d1(c.a.this, str, j12, j11, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onAvailableCommandsChanged(final o2.b bVar) {
        final c.a S0 = S0();
        m2(S0, 13, new r.a() { // from class: e9.u
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).s(c.a.this, bVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.e.a
    public final void onBandwidthSample(final int i11, final long j11, final long j12) {
        final c.a V0 = V0();
        m2(V0, PointerIconCompat.TYPE_CELL, new r.a() { // from class: e9.b1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).a0(c.a.this, i11, j11, j12);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onCues(final ba.f fVar) {
        final c.a S0 = S0();
        m2(S0, 27, new r.a() { // from class: e9.t
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).r(c.a.this, fVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onCues(final List list) {
        final c.a S0 = S0();
        m2(S0, 27, new r.a() { // from class: e9.h0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).k0(c.a.this, list);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onDeviceInfoChanged(final com.google.android.exoplayer2.r rVar) {
        final c.a S0 = S0();
        m2(S0, 29, new r.a() { // from class: e9.x0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).l(c.a.this, rVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onDeviceVolumeChanged(final int i11, final boolean z10) {
        final c.a S0 = S0();
        m2(S0, 30, new r.a() { // from class: e9.y0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).d0(c.a.this, i11, z10);
            }
        });
    }

    @Override // e9.a
    public final void onDroppedFrames(final int i11, final long j11) {
        final c.a X0 = X0();
        m2(X0, PointerIconCompat.TYPE_ZOOM_IN, new r.a() { // from class: e9.j0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).W(c.a.this, i11, j11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onEvents(o2 o2Var, o2.c cVar) {
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onIsLoadingChanged(final boolean z10) {
        final c.a S0 = S0();
        m2(S0, 3, new r.a() { // from class: e9.v0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.z1(c.a.this, z10, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onIsPlayingChanged(final boolean z10) {
        final c.a S0 = S0();
        m2(S0, 7, new r.a() { // from class: e9.l1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).O(c.a.this, z10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onLoadingChanged(boolean z10) {
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onMediaItemTransition(final v1 v1Var, final int i11) {
        final c.a S0 = S0();
        m2(S0, 1, new r.a() { // from class: e9.s
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).o(c.a.this, v1Var, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onMediaMetadataChanged(final a2 a2Var) {
        final c.a S0 = S0();
        m2(S0, 14, new r.a() { // from class: e9.f
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).h(c.a.this, a2Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onMetadata(final Metadata metadata) {
        final c.a S0 = S0();
        m2(S0, 28, new r.a() { // from class: e9.z0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).i(c.a.this, metadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onPlayWhenReadyChanged(final boolean z10, final int i11) {
        final c.a S0 = S0();
        m2(S0, 5, new r.a() { // from class: e9.o
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).g(c.a.this, z10, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onPlaybackParametersChanged(final n2 n2Var) {
        final c.a S0 = S0();
        m2(S0, 12, new r.a() { // from class: e9.h
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).q0(c.a.this, n2Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onPlaybackStateChanged(final int i11) {
        final c.a S0 = S0();
        m2(S0, 4, new r.a() { // from class: e9.x
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).s0(c.a.this, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onPlaybackSuppressionReasonChanged(final int i11) {
        final c.a S0 = S0();
        m2(S0, 6, new r.a() { // from class: e9.m0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).c(c.a.this, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onPlayerError(final PlaybackException playbackException) {
        final c.a Z0 = Z0(playbackException);
        m2(Z0, 10, new r.a() { // from class: e9.r
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).M(c.a.this, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onPlayerErrorChanged(final PlaybackException playbackException) {
        final c.a Z0 = Z0(playbackException);
        m2(Z0, 10, new r.a() { // from class: e9.l0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).z0(c.a.this, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onPlayerStateChanged(final boolean z10, final int i11) {
        final c.a S0 = S0();
        m2(S0, -1, new r.a() { // from class: e9.j
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).y(c.a.this, z10, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onPositionDiscontinuity(int i11) {
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onPositionDiscontinuity(final o2.e eVar, final o2.e eVar2, final int i11) {
        if (i11 == 1) {
            this.f61844i = false;
        }
        this.f61839d.j((o2) com.google.android.exoplayer2.util.a.e(this.f61842g));
        final c.a S0 = S0();
        m2(S0, 11, new r.a() { // from class: e9.r0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.P1(c.a.this, i11, eVar, eVar2, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onRenderedFirstFrame() {
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onRepeatModeChanged(final int i11) {
        final c.a S0 = S0();
        m2(S0, 8, new r.a() { // from class: e9.e0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).K(c.a.this, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onSeekProcessed() {
        final c.a S0 = S0();
        m2(S0, -1, new r.a() { // from class: e9.m
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).X(c.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onShuffleModeEnabledChanged(final boolean z10) {
        final c.a S0 = S0();
        m2(S0, 9, new r.a() { // from class: e9.o1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).l0(c.a.this, z10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onSkipSilenceEnabledChanged(final boolean z10) {
        final c.a Y0 = Y0();
        m2(Y0, 23, new r.a() { // from class: e9.k1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).b0(c.a.this, z10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onSurfaceSizeChanged(final int i11, final int i12) {
        final c.a Y0 = Y0();
        m2(Y0, 24, new r.a() { // from class: e9.p
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).x0(c.a.this, i11, i12);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onTimelineChanged(k3 k3Var, final int i11) {
        this.f61839d.l((o2) com.google.android.exoplayer2.util.a.e(this.f61842g));
        final c.a S0 = S0();
        m2(S0, 0, new r.a() { // from class: e9.t0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).i0(c.a.this, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onTrackSelectionParametersChanged(final TrackSelectionParameters trackSelectionParameters) {
        final c.a S0 = S0();
        m2(S0, 19, new r.a() { // from class: e9.b0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).p0(c.a.this, trackSelectionParameters);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public void onTracksChanged(final p3 p3Var) {
        final c.a S0 = S0();
        m2(S0, 2, new r.a() { // from class: e9.i0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).V(c.a.this, p3Var);
            }
        });
    }

    @Override // e9.a
    public final void onVideoDecoderInitialized(final String str, final long j11, final long j12) {
        final c.a Y0 = Y0();
        m2(Y0, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, new r.a() { // from class: e9.y
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.b2(c.a.this, str, j12, j11, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onVideoSizeChanged(final com.google.android.exoplayer2.video.y yVar) {
        final c.a Y0 = Y0();
        m2(Y0, 25, new r.a() { // from class: e9.d1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.h2(c.a.this, yVar, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2.d
    public final void onVolumeChanged(final float f11) {
        final c.a Y0 = Y0();
        m2(Y0, 22, new r.a() { // from class: e9.w0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).T(c.a.this, f11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.p
    public final void p(int i11, o.b bVar, final t9.h hVar, final t9.i iVar) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1000, new r.a() { // from class: e9.k0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).d(c.a.this, hVar, iVar);
            }
        });
    }

    @Override // e9.a
    public void q(final o2 o2Var, Looper looper) {
        com.google.android.exoplayer2.util.a.g(this.f61842g == null || this.f61839d.f61846b.isEmpty());
        this.f61842g = (o2) com.google.android.exoplayer2.util.a.e(o2Var);
        this.f61843h = this.f61836a.createHandler(looper, null);
        this.f61841f = this.f61841f.e(looper, new r.b() { // from class: e9.l
            @Override // com.google.android.exoplayer2.util.r.b
            public final void a(Object obj, com.google.android.exoplayer2.util.m mVar) {
                p1.this.k2(o2Var, (c) obj, mVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.s
    public final void r(int i11, o.b bVar) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1026, new r.a() { // from class: e9.c1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).J(c.a.this);
            }
        });
    }

    @Override // e9.a
    public void release() {
        ((com.google.android.exoplayer2.util.o) com.google.android.exoplayer2.util.a.i(this.f61843h)).post(new Runnable() { // from class: e9.g
            @Override // java.lang.Runnable
            public final void run() {
                p1.this.l2();
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.s
    public /* synthetic */ void s(int i11, o.b bVar) {
        com.google.android.exoplayer2.drm.l.a(this, i11, bVar);
    }

    @Override // e9.a
    public final void t(final com.google.android.exoplayer2.o1 o1Var, final com.google.android.exoplayer2.decoder.g gVar) {
        final c.a Y0 = Y0();
        m2(Y0, PointerIconCompat.TYPE_VERTICAL_TEXT, new r.a() { // from class: e9.e
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.h1(c.a.this, o1Var, gVar, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.p
    public final void u(int i11, o.b bVar, final t9.h hVar, final t9.i iVar) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1002, new r.a() { // from class: e9.g1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).y0(c.a.this, hVar, iVar);
            }
        });
    }

    @Override // e9.a
    public final void v(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a Y0 = Y0();
        m2(Y0, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, new r.a() { // from class: e9.w
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.e2(c.a.this, eVar, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.p
    public final void w(int i11, o.b bVar, final t9.i iVar) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1004, new r.a() { // from class: e9.n
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).z(c.a.this, iVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.p
    public final void x(int i11, o.b bVar, final t9.h hVar, final t9.i iVar, final IOException iOException, final boolean z10) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1003, new r.a() { // from class: e9.q
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).u(c.a.this, hVar, iVar, iOException, z10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.s
    public final void y(int i11, o.b bVar, final Exception exc) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1024, new r.a() { // from class: e9.q0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).j(c.a.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.p
    public final void z(int i11, o.b bVar, final t9.h hVar, final t9.i iVar) {
        final c.a W0 = W0(i11, bVar);
        m2(W0, 1001, new r.a() { // from class: e9.i
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).p(c.a.this, hVar, iVar);
            }
        });
    }
}
