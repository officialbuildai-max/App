package z9;

import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import g9.e0;
import g9.n;

/* loaded from: classes4.dex */
final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    private final j f79485a;

    /* renamed from: b, reason: collision with root package name */
    private final c0 f79486b = new c0();

    /* renamed from: c, reason: collision with root package name */
    private final int f79487c;

    /* renamed from: d, reason: collision with root package name */
    private final int f79488d;

    /* renamed from: e, reason: collision with root package name */
    private final int f79489e;

    /* renamed from: f, reason: collision with root package name */
    private final int f79490f;

    /* renamed from: g, reason: collision with root package name */
    private long f79491g;

    /* renamed from: h, reason: collision with root package name */
    private e0 f79492h;

    /* renamed from: i, reason: collision with root package name */
    private long f79493i;

    public b(j jVar) {
        this.f79485a = jVar;
        this.f79487c = jVar.f26484b;
        String str = (String) com.google.android.exoplayer2.util.a.e((String) jVar.f26486d.get("mode"));
        if (com.google.common.base.a.a(str, "AAC-hbr")) {
            this.f79488d = 13;
            this.f79489e = 3;
        } else {
            if (!com.google.common.base.a.a(str, "AAC-lbr")) {
                throw new UnsupportedOperationException("AAC mode not supported");
            }
            this.f79488d = 6;
            this.f79489e = 2;
        }
        this.f79490f = this.f79489e + this.f79488d;
    }

    private static void d(e0 e0Var, long j11, int i11) {
        e0Var.d(j11, 1, i11, 0, null);
    }

    private static long e(long j11, long j12, long j13, int i11) {
        return j11 + p0.N0(j12 - j13, 1000000L, i11);
    }

    @Override // z9.e
    public void a(d0 d0Var, long j11, int i11, boolean z10) {
        com.google.android.exoplayer2.util.a.e(this.f79492h);
        short z11 = d0Var.z();
        int i12 = z11 / this.f79490f;
        long e11 = e(this.f79493i, j11, this.f79491g, this.f79487c);
        this.f79486b.m(d0Var);
        if (i12 == 1) {
            int h11 = this.f79486b.h(this.f79488d);
            this.f79486b.r(this.f79489e);
            this.f79492h.c(d0Var, d0Var.a());
            if (z10) {
                d(this.f79492h, e11, h11);
                return;
            }
            return;
        }
        d0Var.Q((z11 + 7) / 8);
        for (int i13 = 0; i13 < i12; i13++) {
            int h12 = this.f79486b.h(this.f79488d);
            this.f79486b.r(this.f79489e);
            this.f79492h.c(d0Var, h12);
            d(this.f79492h, e11, h12);
            e11 += p0.N0(i12, 1000000L, this.f79487c);
        }
    }

    @Override // z9.e
    public void b(long j11, int i11) {
        this.f79491g = j11;
    }

    @Override // z9.e
    public void c(n nVar, int i11) {
        e0 track = nVar.track(i11, 1);
        this.f79492h = track;
        track.e(this.f79485a.f26485c);
    }

    @Override // z9.e
    public void seek(long j11, long j12) {
        this.f79491g = j11;
        this.f79493i = j12;
    }
}
