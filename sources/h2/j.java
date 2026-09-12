package h2;

import androidx.media3.common.r;
import androidx.media3.common.util.j0;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import h2.f;
import l2.s0;

/* loaded from: classes2.dex */
public class j extends a {

    /* renamed from: o, reason: collision with root package name */
    private final int f64460o;

    /* renamed from: p, reason: collision with root package name */
    private final long f64461p;

    /* renamed from: q, reason: collision with root package name */
    private final f f64462q;

    /* renamed from: r, reason: collision with root package name */
    private long f64463r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f64464s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f64465t;

    public j(androidx.media3.datasource.a aVar, w1.h hVar, r rVar, int i11, Object obj, long j11, long j12, long j13, long j14, long j15, int i12, long j16, f fVar) {
        super(aVar, hVar, rVar, i11, obj, j11, j12, j13, j14, j15);
        this.f64460o = i12;
        this.f64461p = j16;
        this.f64462q = fVar;
    }

    private void k(c cVar) {
        if (y.q(this.f64422d.f10242n)) {
            r rVar = this.f64422d;
            int i11 = rVar.L;
            if ((i11 <= 1 && rVar.M <= 1) || i11 == -1 || rVar.M == -1) {
                return;
            }
            s0 track = cVar.track(0, 4);
            r rVar2 = this.f64422d;
            int i12 = rVar2.M * rVar2.L;
            long j11 = (this.f64426h - this.f64425g) / i12;
            for (int i13 = 1; i13 < i12; i13++) {
                track.b(new j0(), 0);
                track.d(i13 * j11, 0, 0, 0, null);
            }
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void cancelLoad() {
        this.f64464s = true;
    }

    @Override // h2.m
    public long e() {
        return this.f64473j + this.f64460o;
    }

    @Override // h2.m
    public boolean f() {
        return this.f64465t;
    }

    protected f.b j(c cVar) {
        return cVar;
    }

    protected void l() {
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void load() {
        c h11 = h();
        if (this.f64463r == 0) {
            h11.b(this.f64461p);
            f fVar = this.f64462q;
            f.b j11 = j(h11);
            long j12 = this.f64389k;
            long j13 = j12 == C.TIME_UNSET ? -9223372036854775807L : j12 - this.f64461p;
            long j14 = this.f64390l;
            fVar.d(j11, j13, j14 == C.TIME_UNSET ? -9223372036854775807L : j14 - this.f64461p);
        }
        try {
            w1.h e11 = this.f64420b.e(this.f64463r);
            w1.l lVar = this.f64427i;
            l2.j jVar = new l2.j(lVar, e11.f77640g, lVar.a(e11));
            do {
                try {
                    if (this.f64464s) {
                        break;
                    }
                } finally {
                    this.f64463r = jVar.getPosition() - this.f64420b.f77640g;
                }
            } while (this.f64462q.a(jVar));
            k(h11);
            this.f64463r = jVar.getPosition() - this.f64420b.f77640g;
            l();
            w1.g.a(this.f64427i);
            this.f64465t = !this.f64464s;
        } catch (Throwable th2) {
            l();
            w1.g.a(this.f64427i);
            throw th2;
        }
    }
}
