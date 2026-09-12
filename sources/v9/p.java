package v9;

import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.e0;

/* loaded from: classes4.dex */
public final class p extends a {

    /* renamed from: o, reason: collision with root package name */
    private final int f77308o;

    /* renamed from: p, reason: collision with root package name */
    private final o1 f77309p;

    /* renamed from: q, reason: collision with root package name */
    private long f77310q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f77311r;

    public p(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, o1 o1Var, int i11, Object obj, long j11, long j12, long j13, int i12, o1 o1Var2) {
        super(kVar, nVar, o1Var, i11, obj, j11, j12, C.TIME_UNSET, C.TIME_UNSET, j13);
        this.f77308o = i12;
        this.f77309p = o1Var2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void cancelLoad() {
    }

    @Override // v9.n
    public boolean f() {
        return this.f77311r;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void load() {
        c h11 = h();
        h11.b(0L);
        e0 track = h11.track(0, this.f77308o);
        track.e(this.f77309p);
        try {
            long a11 = this.f77263i.a(this.f77256b.e(this.f77310q));
            if (a11 != -1) {
                a11 += this.f77310q;
            }
            g9.f fVar = new g9.f(this.f77263i, this.f77310q, a11);
            for (int i11 = 0; i11 != -1; i11 = track.b(fVar, Integer.MAX_VALUE, true)) {
                this.f77310q += i11;
            }
            track.d(this.f77261g, 1, (int) this.f77310q, 0, null);
            com.google.android.exoplayer2.upstream.m.a(this.f77263i);
            this.f77311r = true;
        } catch (Throwable th2) {
            com.google.android.exoplayer2.upstream.m.a(this.f77263i);
            throw th2;
        }
    }
}
