package h2;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.s0;

/* loaded from: classes2.dex */
public final class o extends a {

    /* renamed from: o, reason: collision with root package name */
    private final int f64475o;

    /* renamed from: p, reason: collision with root package name */
    private final r f64476p;

    /* renamed from: q, reason: collision with root package name */
    private long f64477q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f64478r;

    public o(androidx.media3.datasource.a aVar, w1.h hVar, r rVar, int i11, Object obj, long j11, long j12, long j13, int i12, r rVar2) {
        super(aVar, hVar, rVar, i11, obj, j11, j12, C.TIME_UNSET, C.TIME_UNSET, j13);
        this.f64475o = i12;
        this.f64476p = rVar2;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void cancelLoad() {
    }

    @Override // h2.m
    public boolean f() {
        return this.f64478r;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void load() {
        c h11 = h();
        h11.b(0L);
        s0 track = h11.track(0, this.f64475o);
        track.c(this.f64476p);
        try {
            long a11 = this.f64427i.a(this.f64420b.e(this.f64477q));
            if (a11 != -1) {
                a11 += this.f64477q;
            }
            l2.j jVar = new l2.j(this.f64427i, this.f64477q, a11);
            for (int i11 = 0; i11 != -1; i11 = track.e(jVar, Integer.MAX_VALUE, true)) {
                this.f64477q += i11;
            }
            track.d(this.f64425g, 1, (int) this.f64477q, 0, null);
            w1.g.a(this.f64427i);
            this.f64478r = true;
        } catch (Throwable th2) {
            w1.g.a(this.f64427i);
            throw th2;
        }
    }
}
