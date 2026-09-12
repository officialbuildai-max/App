package androidx.media3.exoplayer.video;

import androidx.media3.common.m0;
import androidx.media3.common.util.o0;
import androidx.media3.exoplayer.video.u;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
final class x {

    /* renamed from: a, reason: collision with root package name */
    private final a f13426a;

    /* renamed from: b, reason: collision with root package name */
    private final u f13427b;

    /* renamed from: k, reason: collision with root package name */
    private long f13436k;

    /* renamed from: c, reason: collision with root package name */
    private final u.a f13428c = new u.a();

    /* renamed from: d, reason: collision with root package name */
    private final o0 f13429d = new o0();

    /* renamed from: e, reason: collision with root package name */
    private final o0 f13430e = new o0();

    /* renamed from: f, reason: collision with root package name */
    private final androidx.media3.common.util.w f13431f = new androidx.media3.common.util.w();

    /* renamed from: g, reason: collision with root package name */
    private long f13432g = C.TIME_UNSET;

    /* renamed from: j, reason: collision with root package name */
    private m0 f13435j = m0.f10193e;

    /* renamed from: h, reason: collision with root package name */
    private long f13433h = C.TIME_UNSET;

    /* renamed from: i, reason: collision with root package name */
    private long f13434i = C.TIME_UNSET;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b(long j11, long j12, boolean z10);

        void onVideoSizeChanged(m0 m0Var);
    }

    public x(a aVar, u uVar) {
        this.f13426a = aVar;
        this.f13427b = uVar;
    }

    private void a() {
        this.f13431f.f();
        this.f13426a.a();
    }

    private static Object c(o0 o0Var) {
        androidx.media3.common.util.a.a(o0Var.l() > 0);
        while (o0Var.l() > 1) {
            o0Var.i();
        }
        return androidx.media3.common.util.a.e(o0Var.i());
    }

    private boolean e(long j11) {
        Long l11 = (Long) this.f13430e.j(j11);
        if (l11 == null || l11.longValue() == this.f13436k) {
            return false;
        }
        this.f13436k = l11.longValue();
        return true;
    }

    private boolean f(long j11) {
        m0 m0Var = (m0) this.f13429d.j(j11);
        if (m0Var == null || m0Var.equals(m0.f10193e) || m0Var.equals(this.f13435j)) {
            return false;
        }
        this.f13435j = m0Var;
        return true;
    }

    private void k(boolean z10) {
        long f11 = this.f13431f.f();
        if (f(f11)) {
            this.f13426a.onVideoSizeChanged(this.f13435j);
        }
        this.f13426a.b(z10 ? -1L : this.f13428c.g(), f11, this.f13427b.i());
    }

    public void b() {
        this.f13431f.b();
        this.f13432g = C.TIME_UNSET;
        this.f13433h = C.TIME_UNSET;
        this.f13434i = C.TIME_UNSET;
        if (this.f13430e.l() > 0) {
            Long l11 = (Long) c(this.f13430e);
            l11.longValue();
            this.f13430e.a(0L, l11);
        }
        if (this.f13429d.l() > 0) {
            this.f13429d.a(0L, (m0) c(this.f13429d));
        }
    }

    public boolean d() {
        long j11 = this.f13434i;
        return j11 != C.TIME_UNSET && this.f13433h == j11;
    }

    public void g(long j11) {
        this.f13431f.a(j11);
        this.f13432g = j11;
        this.f13434i = C.TIME_UNSET;
    }

    public void h(long j11) {
        o0 o0Var = this.f13430e;
        long j12 = this.f13432g;
        o0Var.a(j12 == C.TIME_UNSET ? 0L : j12 + 1, Long.valueOf(j11));
    }

    public void i(int i11, int i12) {
        o0 o0Var = this.f13429d;
        long j11 = this.f13432g;
        o0Var.a(j11 == C.TIME_UNSET ? 0L : j11 + 1, new m0(i11, i12));
    }

    public void j(long j11, long j12) {
        while (!this.f13431f.e()) {
            long d11 = this.f13431f.d();
            if (e(d11)) {
                this.f13427b.j();
            }
            int c11 = this.f13427b.c(d11, j11, j12, this.f13436k, false, false, this.f13428c);
            if (c11 == 0 || c11 == 1) {
                this.f13433h = d11;
                k(c11 == 0);
            } else if (c11 == 2 || c11 == 3) {
                this.f13433h = d11;
                a();
            } else {
                if (c11 != 4) {
                    if (c11 != 5) {
                        throw new IllegalStateException(String.valueOf(c11));
                    }
                    return;
                }
                this.f13433h = d11;
            }
        }
    }

    public void l() {
        this.f13434i = this.f13432g;
    }
}
