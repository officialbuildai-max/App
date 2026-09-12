package y1;

import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.common.util.t;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.r;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import y1.c;

/* loaded from: classes2.dex */
public class s1 implements y1.a {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.common.util.i f78863a;

    /* renamed from: b, reason: collision with root package name */
    private final e0.b f78864b;

    /* renamed from: c, reason: collision with root package name */
    private final e0.c f78865c;

    /* renamed from: d, reason: collision with root package name */
    private final a f78866d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray f78867e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.media3.common.util.t f78868f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.media3.common.a0 f78869g;

    /* renamed from: h, reason: collision with root package name */
    private androidx.media3.common.util.p f78870h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f78871i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final e0.b f78872a;

        /* renamed from: b, reason: collision with root package name */
        private ImmutableList f78873b = ImmutableList.of();

        /* renamed from: c, reason: collision with root package name */
        private ImmutableMap f78874c = ImmutableMap.of();

        /* renamed from: d, reason: collision with root package name */
        private r.b f78875d;

        /* renamed from: e, reason: collision with root package name */
        private r.b f78876e;

        /* renamed from: f, reason: collision with root package name */
        private r.b f78877f;

        public a(e0.b bVar) {
            this.f78872a = bVar;
        }

        private void b(ImmutableMap.b bVar, r.b bVar2, androidx.media3.common.e0 e0Var) {
            if (bVar2 == null) {
                return;
            }
            if (e0Var.b(bVar2.f12965a) != -1) {
                bVar.h(bVar2, e0Var);
                return;
            }
            androidx.media3.common.e0 e0Var2 = (androidx.media3.common.e0) this.f78874c.get(bVar2);
            if (e0Var2 != null) {
                bVar.h(bVar2, e0Var2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static r.b c(androidx.media3.common.a0 a0Var, ImmutableList immutableList, r.b bVar, e0.b bVar2) {
            androidx.media3.common.e0 currentTimeline = a0Var.getCurrentTimeline();
            int currentPeriodIndex = a0Var.getCurrentPeriodIndex();
            Object m11 = currentTimeline.q() ? null : currentTimeline.m(currentPeriodIndex);
            int d11 = (a0Var.isPlayingAd() || currentTimeline.q()) ? -1 : currentTimeline.f(currentPeriodIndex, bVar2).d(androidx.media3.common.util.a1.R0(a0Var.getCurrentPosition()) - bVar2.o());
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                r.b bVar3 = (r.b) immutableList.get(i11);
                if (i(bVar3, m11, a0Var.isPlayingAd(), a0Var.getCurrentAdGroupIndex(), a0Var.getCurrentAdIndexInAdGroup(), d11)) {
                    return bVar3;
                }
            }
            if (immutableList.isEmpty() && bVar != null) {
                if (i(bVar, m11, a0Var.isPlayingAd(), a0Var.getCurrentAdGroupIndex(), a0Var.getCurrentAdIndexInAdGroup(), d11)) {
                    return bVar;
                }
            }
            return null;
        }

        private static boolean i(r.b bVar, Object obj, boolean z10, int i11, int i12, int i13) {
            if (bVar.f12965a.equals(obj)) {
                return (z10 && bVar.f12966b == i11 && bVar.f12967c == i12) || (!z10 && bVar.f12966b == -1 && bVar.f12969e == i13);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void m(androidx.media3.common.e0 e0Var) {
            ImmutableMap.b builder = ImmutableMap.builder();
            if (this.f78873b.isEmpty()) {
                b(builder, this.f78876e, e0Var);
                if (!Objects.equals(this.f78877f, this.f78876e)) {
                    b(builder, this.f78877f, e0Var);
                }
                if (!Objects.equals(this.f78875d, this.f78876e) && !Objects.equals(this.f78875d, this.f78877f)) {
                    b(builder, this.f78875d, e0Var);
                }
            } else {
                for (int i11 = 0; i11 < this.f78873b.size(); i11++) {
                    b(builder, (r.b) this.f78873b.get(i11), e0Var);
                }
                if (!this.f78873b.contains(this.f78875d)) {
                    b(builder, this.f78875d, e0Var);
                }
            }
            this.f78874c = builder.d();
        }

        public r.b d() {
            return this.f78875d;
        }

        public r.b e() {
            if (this.f78873b.isEmpty()) {
                return null;
            }
            return (r.b) com.google.common.collect.g3.g(this.f78873b);
        }

        public androidx.media3.common.e0 f(r.b bVar) {
            return (androidx.media3.common.e0) this.f78874c.get(bVar);
        }

        public r.b g() {
            return this.f78876e;
        }

        public r.b h() {
            return this.f78877f;
        }

        public void j(androidx.media3.common.a0 a0Var) {
            this.f78875d = c(a0Var, this.f78873b, this.f78876e, this.f78872a);
        }

        public void k(List list, r.b bVar, androidx.media3.common.a0 a0Var) {
            this.f78873b = ImmutableList.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.f78876e = (r.b) list.get(0);
                this.f78877f = (r.b) androidx.media3.common.util.a.e(bVar);
            }
            if (this.f78875d == null) {
                this.f78875d = c(a0Var, this.f78873b, this.f78876e, this.f78872a);
            }
            m(a0Var.getCurrentTimeline());
        }

        public void l(androidx.media3.common.a0 a0Var) {
            this.f78875d = c(a0Var, this.f78873b, this.f78876e, this.f78872a);
            m(a0Var.getCurrentTimeline());
        }
    }

    public s1(androidx.media3.common.util.i iVar) {
        this.f78863a = (androidx.media3.common.util.i) androidx.media3.common.util.a.e(iVar);
        this.f78868f = new androidx.media3.common.util.t(androidx.media3.common.util.a1.X(), iVar, new t.b() { // from class: y1.u
            @Override // androidx.media3.common.util.t.b
            public final void a(Object obj, androidx.media3.common.p pVar) {
                s1.f1((c) obj, pVar);
            }
        });
        e0.b bVar = new e0.b();
        this.f78864b = bVar;
        this.f78865c = new e0.c();
        this.f78866d = new a(bVar);
        this.f78867e = new SparseArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D1(c.a aVar, int i11, c cVar) {
        cVar.A(aVar);
        cVar.U(aVar, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H1(c.a aVar, boolean z10, c cVar) {
        cVar.M(aVar, z10);
        cVar.g(aVar, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M1(c.a aVar, g2.i iVar, g2.j jVar, int i11, c cVar) {
        cVar.I(aVar, iVar, jVar);
        cVar.k0(aVar, iVar, jVar, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X1(c.a aVar, int i11, a0.e eVar, a0.e eVar2, c cVar) {
        cVar.d(aVar, i11);
        cVar.F(aVar, eVar, eVar2, i11);
    }

    private c.a Z0(r.b bVar) {
        androidx.media3.common.util.a.e(this.f78869g);
        androidx.media3.common.e0 f11 = bVar == null ? null : this.f78866d.f(bVar);
        if (bVar != null && f11 != null) {
            return Y0(f11, f11.h(bVar.f12965a, this.f78864b).f10018c, bVar);
        }
        int t11 = this.f78869g.t();
        androidx.media3.common.e0 currentTimeline = this.f78869g.getCurrentTimeline();
        if (t11 >= currentTimeline.p()) {
            currentTimeline = androidx.media3.common.e0.f10007a;
        }
        return Y0(currentTimeline, t11, null);
    }

    private c.a a1() {
        return Z0(this.f78866d.e());
    }

    private c.a b1(int i11, r.b bVar) {
        androidx.media3.common.util.a.e(this.f78869g);
        if (bVar != null) {
            return this.f78866d.f(bVar) != null ? Z0(bVar) : Y0(androidx.media3.common.e0.f10007a, i11, bVar);
        }
        androidx.media3.common.e0 currentTimeline = this.f78869g.getCurrentTimeline();
        if (i11 >= currentTimeline.p()) {
            currentTimeline = androidx.media3.common.e0.f10007a;
        }
        return Y0(currentTimeline, i11, null);
    }

    private c.a c1() {
        return Z0(this.f78866d.g());
    }

    private c.a d1() {
        return Z0(this.f78866d.h());
    }

    private c.a e1(PlaybackException playbackException) {
        r.b bVar;
        return (!(playbackException instanceof ExoPlaybackException) || (bVar = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? X0() : Z0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f1(c cVar, androidx.media3.common.p pVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i1(c.a aVar, String str, long j11, long j12, c cVar) {
        cVar.W(aVar, str, j11);
        cVar.R(aVar, str, j12, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j2(c.a aVar, String str, long j11, long j12, c cVar) {
        cVar.w(aVar, str, j11);
        cVar.q(aVar, str, j12, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p2(c.a aVar, androidx.media3.common.m0 m0Var, c cVar) {
        cVar.S(aVar, m0Var);
        cVar.f0(aVar, m0Var.f10197a, m0Var.f10198b, 0, m0Var.f10200d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2(androidx.media3.common.a0 a0Var, c cVar, androidx.media3.common.p pVar) {
        cVar.d0(a0Var, new c.b(pVar, this.f78867e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2() {
        final c.a X0 = X0();
        u2(X0, 1028, new t.a() { // from class: y1.m0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).q0(c.a.this);
            }
        });
        this.f78868f.j();
    }

    @Override // androidx.media3.exoplayer.drm.r
    public final void A(int i11, r.b bVar) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, InputDeviceCompat.SOURCE_GAMEPAD, new t.a() { // from class: y1.j1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).k(c.a.this);
            }
        });
    }

    @Override // y1.a
    public void B(final int i11, final int i12, final boolean z10) {
        final c.a d12 = d1();
        u2(d12, 1033, new t.a() { // from class: y1.s
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).f(c.a.this, i11, i12, z10);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.s
    public final void C(int i11, r.b bVar, final g2.i iVar, final g2.j jVar) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1001, new t.a() { // from class: y1.y
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).x0(c.a.this, iVar, jVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.s
    public final void D(int i11, r.b bVar, final g2.j jVar) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1005, new t.a() { // from class: y1.d1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).v0(c.a.this, jVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.s
    public final void E(int i11, r.b bVar, final g2.j jVar) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1004, new t.a() { // from class: y1.j0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).j(c.a.this, jVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.s
    public final void F(int i11, r.b bVar, final g2.i iVar, final g2.j jVar, final int i12) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1000, new t.a() { // from class: y1.v0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                s1.M1(c.a.this, iVar, jVar, i12, (c) obj);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.r
    public final void G(int i11, r.b bVar) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1027, new t.a() { // from class: y1.e1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).Q(c.a.this);
            }
        });
    }

    @Override // y1.a
    public void H(final androidx.media3.common.a0 a0Var, Looper looper) {
        androidx.media3.common.util.a.g(this.f78869g == null || this.f78866d.f78873b.isEmpty());
        this.f78869g = (androidx.media3.common.a0) androidx.media3.common.util.a.e(a0Var);
        this.f78870h = this.f78863a.createHandler(looper, null);
        this.f78868f = this.f78868f.e(looper, new t.b() { // from class: y1.i
            @Override // androidx.media3.common.util.t.b
            public final void a(Object obj, androidx.media3.common.p pVar) {
                s1.this.s2(a0Var, (c) obj, pVar);
            }
        });
    }

    protected final c.a X0() {
        return Z0(this.f78866d.d());
    }

    protected final c.a Y0(androidx.media3.common.e0 e0Var, int i11, r.b bVar) {
        r.b bVar2 = e0Var.q() ? null : bVar;
        long elapsedRealtime = this.f78863a.elapsedRealtime();
        boolean z10 = e0Var.equals(this.f78869g.getCurrentTimeline()) && i11 == this.f78869g.t();
        long j11 = 0;
        if (bVar2 == null || !bVar2.b()) {
            if (z10) {
                j11 = this.f78869g.getContentPosition();
            } else if (!e0Var.q()) {
                j11 = e0Var.n(i11, this.f78865c).b();
            }
        } else if (z10 && this.f78869g.getCurrentAdGroupIndex() == bVar2.f12966b && this.f78869g.getCurrentAdIndexInAdGroup() == bVar2.f12967c) {
            j11 = this.f78869g.getCurrentPosition();
        }
        return new c.a(elapsedRealtime, e0Var, i11, bVar2, j11, this.f78869g.getCurrentTimeline(), this.f78869g.t(), this.f78866d.d(), this.f78869g.getCurrentPosition(), this.f78869g.d());
    }

    @Override // y1.a
    public final void a(final Exception exc) {
        final c.a d12 = d1();
        u2(d12, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new t.a() { // from class: y1.f1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).n0(c.a.this, exc);
            }
        });
    }

    @Override // y1.a
    public final void b(final String str) {
        final c.a d12 = d1();
        u2(d12, PointerIconCompat.TYPE_ZOOM_OUT, new t.a() { // from class: y1.p
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).Z(c.a.this, str);
            }
        });
    }

    @Override // y1.a
    public final void c(final String str) {
        final c.a d12 = d1();
        u2(d12, 1012, new t.a() { // from class: y1.p1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).a0(c.a.this, str);
            }
        });
    }

    @Override // y1.a
    public final void d(final long j11) {
        final c.a d12 = d1();
        u2(d12, 1010, new t.a() { // from class: y1.o0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).j0(c.a.this, j11);
            }
        });
    }

    @Override // y1.a
    public final void e(final Exception exc) {
        final c.a d12 = d1();
        u2(d12, 1030, new t.a() { // from class: y1.g
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).h0(c.a.this, exc);
            }
        });
    }

    @Override // y1.a
    public final void f(final Object obj, final long j11) {
        final c.a d12 = d1();
        u2(d12, 26, new t.a() { // from class: y1.c1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj2) {
                ((c) obj2).G(c.a.this, obj, j11);
            }
        });
    }

    @Override // y1.a
    public final void g(final Exception exc) {
        final c.a d12 = d1();
        u2(d12, 1029, new t.a() { // from class: y1.e0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).o(c.a.this, exc);
            }
        });
    }

    @Override // y1.a
    public final void h(final int i11, final long j11, final long j12) {
        final c.a d12 = d1();
        u2(d12, 1011, new t.a() { // from class: y1.h1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).N(c.a.this, i11, j11, j12);
            }
        });
    }

    @Override // y1.a
    public final void i(final long j11, final int i11) {
        final c.a c12 = c1();
        u2(c12, PointerIconCompat.TYPE_GRABBING, new t.a() { // from class: y1.r0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).T(c.a.this, j11, i11);
            }
        });
    }

    @Override // y1.a
    public void j(final AudioSink.a aVar) {
        final c.a d12 = d1();
        u2(d12, 1031, new t.a() { // from class: y1.n1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).Y(c.a.this, aVar);
            }
        });
    }

    @Override // y1.a
    public void k(final AudioSink.a aVar) {
        final c.a d12 = d1();
        u2(d12, 1032, new t.a() { // from class: y1.l1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).s(c.a.this, aVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.s
    public final void l(int i11, r.b bVar, final g2.i iVar, final g2.j jVar) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1002, new t.a() { // from class: y1.v
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).r(c.a.this, iVar, jVar);
            }
        });
    }

    @Override // y1.a
    public final void m() {
        if (this.f78871i) {
            return;
        }
        final c.a X0 = X0();
        this.f78871i = true;
        u2(X0, -1, new t.a() { // from class: y1.a0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).B(c.a.this);
            }
        });
    }

    @Override // y1.a
    public final void n(final androidx.media3.exoplayer.j jVar) {
        final c.a d12 = d1();
        u2(d12, PointerIconCompat.TYPE_CROSSHAIR, new t.a() { // from class: y1.n0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).K(c.a.this, jVar);
            }
        });
    }

    @Override // y1.a
    public final void o(final androidx.media3.exoplayer.j jVar) {
        final c.a d12 = d1();
        u2(d12, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, new t.a() { // from class: y1.b1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).o0(c.a.this, jVar);
            }
        });
    }

    @Override // y1.a
    public final void onAudioDecoderInitialized(final String str, final long j11, final long j12) {
        final c.a d12 = d1();
        u2(d12, PointerIconCompat.TYPE_TEXT, new t.a() { // from class: y1.m
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                s1.i1(c.a.this, str, j12, j11, (c) obj);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onAudioSessionIdChanged(final int i11) {
        final c.a d12 = d1();
        u2(d12, 21, new t.a() { // from class: y1.y0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).L(c.a.this, i11);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onAvailableCommandsChanged(final a0.b bVar) {
        final c.a X0 = X0();
        u2(X0, 13, new t.a() { // from class: y1.q1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).c0(c.a.this, bVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.upstream.e.a
    public final void onBandwidthSample(final int i11, final long j11, final long j12) {
        final c.a a12 = a1();
        u2(a12, PointerIconCompat.TYPE_CELL, new t.a() { // from class: y1.i0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).J(c.a.this, i11, j11, j12);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onCues(final List list) {
        final c.a X0 = X0();
        u2(X0, 27, new t.a() { // from class: y1.t
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).r0(c.a.this, list);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onCues(final u1.b bVar) {
        final c.a X0 = X0();
        u2(X0, 27, new t.a() { // from class: y1.z
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).i(c.a.this, bVar);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onDeviceInfoChanged(final androidx.media3.common.m mVar) {
        final c.a X0 = X0();
        u2(X0, 29, new t.a() { // from class: y1.u0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).u(c.a.this, mVar);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onDeviceVolumeChanged(final int i11, final boolean z10) {
        final c.a X0 = X0();
        u2(X0, 30, new t.a() { // from class: y1.q0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).s0(c.a.this, i11, z10);
            }
        });
    }

    @Override // y1.a
    public final void onDroppedFrames(final int i11, final long j11) {
        final c.a c12 = c1();
        u2(c12, PointerIconCompat.TYPE_ZOOM_IN, new t.a() { // from class: y1.p0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).h(c.a.this, i11, j11);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onEvents(androidx.media3.common.a0 a0Var, a0.c cVar) {
    }

    @Override // androidx.media3.common.a0.d
    public final void onIsLoadingChanged(final boolean z10) {
        final c.a X0 = X0();
        u2(X0, 3, new t.a() { // from class: y1.o1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                s1.H1(c.a.this, z10, (c) obj);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onIsPlayingChanged(final boolean z10) {
        final c.a X0 = X0();
        u2(X0, 7, new t.a() { // from class: y1.l
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).n(c.a.this, z10);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onLoadingChanged(boolean z10) {
    }

    @Override // androidx.media3.common.a0.d
    public final void onMediaItemTransition(final androidx.media3.common.t tVar, final int i11) {
        final c.a X0 = X0();
        u2(X0, 1, new t.a() { // from class: y1.e
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).t0(c.a.this, tVar, i11);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onMediaMetadataChanged(final androidx.media3.common.v vVar) {
        final c.a X0 = X0();
        u2(X0, 14, new t.a() { // from class: y1.k0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).g0(c.a.this, vVar);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onMetadata(final androidx.media3.common.x xVar) {
        final c.a X0 = X0();
        u2(X0, 28, new t.a() { // from class: y1.k
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).m(c.a.this, xVar);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onPlayWhenReadyChanged(final boolean z10, final int i11) {
        final c.a X0 = X0();
        u2(X0, 5, new t.a() { // from class: y1.r
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).O(c.a.this, z10, i11);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onPlaybackParametersChanged(final androidx.media3.common.z zVar) {
        final c.a X0 = X0();
        u2(X0, 12, new t.a() { // from class: y1.d
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).P(c.a.this, zVar);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onPlaybackStateChanged(final int i11) {
        final c.a X0 = X0();
        u2(X0, 4, new t.a() { // from class: y1.x
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).l0(c.a.this, i11);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onPlaybackSuppressionReasonChanged(final int i11) {
        final c.a X0 = X0();
        u2(X0, 6, new t.a() { // from class: y1.n
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).V(c.a.this, i11);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onPlayerError(final PlaybackException playbackException) {
        final c.a e12 = e1(playbackException);
        u2(e12, 10, new t.a() { // from class: y1.w
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).c(c.a.this, playbackException);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onPlayerErrorChanged(final PlaybackException playbackException) {
        final c.a e12 = e1(playbackException);
        u2(e12, 10, new t.a() { // from class: y1.q
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).D(c.a.this, playbackException);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onPlayerStateChanged(final boolean z10, final int i11) {
        final c.a X0 = X0();
        u2(X0, -1, new t.a() { // from class: y1.j
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).b0(c.a.this, z10, i11);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onPositionDiscontinuity(int i11) {
    }

    @Override // androidx.media3.common.a0.d
    public final void onPositionDiscontinuity(final a0.e eVar, final a0.e eVar2, final int i11) {
        if (i11 == 1) {
            this.f78871i = false;
        }
        this.f78866d.j((androidx.media3.common.a0) androidx.media3.common.util.a.e(this.f78869g));
        final c.a X0 = X0();
        u2(X0, 11, new t.a() { // from class: y1.b0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                s1.X1(c.a.this, i11, eVar, eVar2, (c) obj);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onRenderedFirstFrame() {
    }

    @Override // androidx.media3.common.a0.d
    public final void onRepeatModeChanged(final int i11) {
        final c.a X0 = X0();
        u2(X0, 8, new t.a() { // from class: y1.d0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).z(c.a.this, i11);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onShuffleModeEnabledChanged(final boolean z10) {
        final c.a X0 = X0();
        u2(X0, 9, new t.a() { // from class: y1.g0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).e0(c.a.this, z10);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onSkipSilenceEnabledChanged(final boolean z10) {
        final c.a d12 = d1();
        u2(d12, 23, new t.a() { // from class: y1.m1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).m0(c.a.this, z10);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onSurfaceSizeChanged(final int i11, final int i12) {
        final c.a d12 = d1();
        u2(d12, 24, new t.a() { // from class: y1.h0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).p0(c.a.this, i11, i12);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onTimelineChanged(androidx.media3.common.e0 e0Var, final int i11) {
        this.f78866d.l((androidx.media3.common.a0) androidx.media3.common.util.a.e(this.f78869g));
        final c.a X0 = X0();
        u2(X0, 0, new t.a() { // from class: y1.r1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).w0(c.a.this, i11);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onTrackSelectionParametersChanged(final androidx.media3.common.h0 h0Var) {
        final c.a X0 = X0();
        u2(X0, 19, new t.a() { // from class: y1.g1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).u0(c.a.this, h0Var);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public void onTracksChanged(final androidx.media3.common.i0 i0Var) {
        final c.a X0 = X0();
        u2(X0, 2, new t.a() { // from class: y1.o
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).y(c.a.this, i0Var);
            }
        });
    }

    @Override // y1.a
    public final void onVideoDecoderInitialized(final String str, final long j11, final long j12) {
        final c.a d12 = d1();
        u2(d12, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, new t.a() { // from class: y1.f0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                s1.j2(c.a.this, str, j12, j11, (c) obj);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onVideoSizeChanged(final androidx.media3.common.m0 m0Var) {
        final c.a d12 = d1();
        u2(d12, 25, new t.a() { // from class: y1.z0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                s1.p2(c.a.this, m0Var, (c) obj);
            }
        });
    }

    @Override // androidx.media3.common.a0.d
    public final void onVolumeChanged(final float f11) {
        final c.a d12 = d1();
        u2(d12, 22, new t.a() { // from class: y1.f
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).b(c.a.this, f11);
            }
        });
    }

    @Override // y1.a
    public final void p(List list, r.b bVar) {
        this.f78866d.k(list, bVar, (androidx.media3.common.a0) androidx.media3.common.util.a.e(this.f78869g));
    }

    @Override // androidx.media3.exoplayer.drm.r
    public final void q(int i11, r.b bVar) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1023, new t.a() { // from class: y1.k1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).p(c.a.this);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.r
    public final void r(int i11, r.b bVar, final int i12) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1022, new t.a() { // from class: y1.t0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                s1.D1(c.a.this, i12, (c) obj);
            }
        });
    }

    @Override // y1.a
    public void release() {
        ((androidx.media3.common.util.p) androidx.media3.common.util.a.i(this.f78870h)).post(new Runnable() { // from class: y1.c0
            @Override // java.lang.Runnable
            public final void run() {
                s1.this.t2();
            }
        });
    }

    @Override // y1.a
    public final void s(final androidx.media3.common.r rVar, final androidx.media3.exoplayer.k kVar) {
        final c.a d12 = d1();
        u2(d12, PointerIconCompat.TYPE_VERTICAL_TEXT, new t.a() { // from class: y1.a1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).i0(c.a.this, rVar, kVar);
            }
        });
    }

    @Override // y1.a
    public final void t(final androidx.media3.exoplayer.j jVar) {
        final c.a c12 = c1();
        u2(c12, PointerIconCompat.TYPE_ALL_SCROLL, new t.a() { // from class: y1.s0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).a(c.a.this, jVar);
            }
        });
    }

    @Override // y1.a
    public final void u(final androidx.media3.common.r rVar, final androidx.media3.exoplayer.k kVar) {
        final c.a d12 = d1();
        u2(d12, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new t.a() { // from class: y1.x0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).x(c.a.this, rVar, kVar);
            }
        });
    }

    protected final void u2(c.a aVar, int i11, t.a aVar2) {
        this.f78867e.put(i11, aVar);
        this.f78868f.l(i11, aVar2);
    }

    @Override // y1.a
    public final void v(final androidx.media3.exoplayer.j jVar) {
        final c.a c12 = c1();
        u2(c12, PointerIconCompat.TYPE_GRAB, new t.a() { // from class: y1.l0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).E(c.a.this, jVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.r
    public final void w(int i11, r.b bVar) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1026, new t.a() { // from class: y1.i1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).t(c.a.this);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.r
    public final void x(int i11, r.b bVar, final Exception exc) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1024, new t.a() { // from class: y1.w0
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).X(c.a.this, exc);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.s
    public final void y(int i11, r.b bVar, final g2.i iVar, final g2.j jVar, final IOException iOException, final boolean z10) {
        final c.a b12 = b1(i11, bVar);
        u2(b12, 1003, new t.a() { // from class: y1.h
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((c) obj).v(c.a.this, iVar, jVar, iOException, z10);
            }
        });
    }

    @Override // y1.a
    public void z(c cVar) {
        androidx.media3.common.util.a.e(cVar);
        this.f78868f.c(cVar);
    }
}
