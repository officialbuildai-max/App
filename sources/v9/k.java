package v9;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.upstream.i0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import v9.g;

/* loaded from: classes4.dex */
public class k extends a {

    /* renamed from: o, reason: collision with root package name */
    private final int f77294o;

    /* renamed from: p, reason: collision with root package name */
    private final long f77295p;

    /* renamed from: q, reason: collision with root package name */
    private final g f77296q;

    /* renamed from: r, reason: collision with root package name */
    private long f77297r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f77298s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f77299t;

    public k(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, o1 o1Var, int i11, Object obj, long j11, long j12, long j13, long j14, long j15, int i12, long j16, g gVar) {
        super(kVar, nVar, o1Var, i11, obj, j11, j12, j13, j14, j15);
        this.f77294o = i12;
        this.f77295p = j16;
        this.f77296q = gVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void cancelLoad() {
        this.f77298s = true;
    }

    @Override // v9.n
    public long e() {
        return this.f77306j + this.f77294o;
    }

    @Override // v9.n
    public boolean f() {
        return this.f77299t;
    }

    protected g.b j(c cVar) {
        return cVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void load() {
        if (this.f77297r == 0) {
            c h11 = h();
            h11.b(this.f77295p);
            g gVar = this.f77296q;
            g.b j11 = j(h11);
            long j12 = this.f77228k;
            long j13 = j12 == C.TIME_UNSET ? -9223372036854775807L : j12 - this.f77295p;
            long j14 = this.f77229l;
            gVar.e(j11, j13, j14 == C.TIME_UNSET ? -9223372036854775807L : j14 - this.f77295p);
        }
        try {
            com.google.android.exoplayer2.upstream.n e11 = this.f77256b.e(this.f77297r);
            i0 i0Var = this.f77263i;
            g9.f fVar = new g9.f(i0Var, e11.f27497g, i0Var.a(e11));
            do {
                try {
                    if (this.f77298s) {
                        break;
                    }
                } finally {
                    this.f77297r = fVar.getPosition() - this.f77256b.f27497g;
                }
            } while (this.f77296q.a(fVar));
            com.google.android.exoplayer2.upstream.m.a(this.f77263i);
            this.f77299t = !this.f77298s;
        } catch (Throwable th2) {
            com.google.android.exoplayer2.upstream.m.a(this.f77263i);
            throw th2;
        }
    }
}
