package z9;

import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.e0;
import g9.n;

/* loaded from: classes4.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    private final j f79494a;

    /* renamed from: c, reason: collision with root package name */
    private e0 f79496c;

    /* renamed from: d, reason: collision with root package name */
    private int f79497d;

    /* renamed from: f, reason: collision with root package name */
    private long f79499f;

    /* renamed from: g, reason: collision with root package name */
    private long f79500g;

    /* renamed from: b, reason: collision with root package name */
    private final c0 f79495b = new c0();

    /* renamed from: e, reason: collision with root package name */
    private long f79498e = C.TIME_UNSET;

    public c(j jVar) {
        this.f79494a = jVar;
    }

    private void d() {
        if (this.f79497d > 0) {
            e();
        }
    }

    private void e() {
        ((e0) p0.j(this.f79496c)).d(this.f79499f, 1, this.f79497d, 0, null);
        this.f79497d = 0;
    }

    private void f(d0 d0Var, boolean z10, int i11, long j11) {
        int a11 = d0Var.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.f79496c)).c(d0Var, a11);
        this.f79497d += a11;
        this.f79499f = j11;
        if (z10 && i11 == 3) {
            e();
        }
    }

    private void g(d0 d0Var, int i11, long j11) {
        this.f79495b.n(d0Var.d());
        this.f79495b.s(2);
        for (int i12 = 0; i12 < i11; i12++) {
            b.C0365b e11 = com.google.android.exoplayer2.audio.b.e(this.f79495b);
            ((e0) com.google.android.exoplayer2.util.a.e(this.f79496c)).c(d0Var, e11.f24666e);
            ((e0) p0.j(this.f79496c)).d(j11, 1, e11.f24666e, 0, null);
            j11 += (e11.f24667f / e11.f24664c) * 1000000;
            this.f79495b.s(e11.f24666e);
        }
    }

    private void h(d0 d0Var, long j11) {
        int a11 = d0Var.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.f79496c)).c(d0Var, a11);
        ((e0) p0.j(this.f79496c)).d(j11, 1, a11, 0, null);
    }

    private static long i(long j11, long j12, long j13, int i11) {
        return j11 + p0.N0(j12 - j13, 1000000L, i11);
    }

    @Override // z9.e
    public void a(d0 d0Var, long j11, int i11, boolean z10) {
        int D = d0Var.D() & 3;
        int D2 = d0Var.D() & 255;
        long i12 = i(this.f79500g, j11, this.f79498e, this.f79494a.f26484b);
        if (D == 0) {
            d();
            if (D2 == 1) {
                h(d0Var, i12);
                return;
            } else {
                g(d0Var, D2, i12);
                return;
            }
        }
        if (D == 1 || D == 2) {
            d();
        } else if (D != 3) {
            throw new IllegalArgumentException(String.valueOf(D));
        }
        f(d0Var, z10, D, i12);
    }

    @Override // z9.e
    public void b(long j11, int i11) {
        com.google.android.exoplayer2.util.a.g(this.f79498e == C.TIME_UNSET);
        this.f79498e = j11;
    }

    @Override // z9.e
    public void c(n nVar, int i11) {
        e0 track = nVar.track(i11, 1);
        this.f79496c = track;
        track.e(this.f79494a.f26485c);
    }

    @Override // z9.e
    public void seek(long j11, long j12) {
        this.f79498e = j11;
        this.f79500g = j12;
    }
}
