package androidx.media3.exoplayer.source;

import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.v2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class o implements q, q.a {

    /* renamed from: a, reason: collision with root package name */
    public final r.b f12944a;

    /* renamed from: b, reason: collision with root package name */
    private final long f12945b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.b f12946c;

    /* renamed from: d, reason: collision with root package name */
    private r f12947d;

    /* renamed from: e, reason: collision with root package name */
    private q f12948e;

    /* renamed from: f, reason: collision with root package name */
    private q.a f12949f;

    /* renamed from: g, reason: collision with root package name */
    private a f12950g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12951h;

    /* renamed from: i, reason: collision with root package name */
    private long f12952i = C.TIME_UNSET;

    /* loaded from: classes2.dex */
    public interface a {
        void a(r.b bVar, IOException iOException);

        void b(r.b bVar);
    }

    public o(r.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        this.f12944a = bVar;
        this.f12946c = bVar2;
        this.f12945b = j11;
    }

    private long k(long j11) {
        long j12 = this.f12952i;
        return j12 != C.TIME_UNSET ? j12 : j11;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        q qVar = this.f12948e;
        return qVar != null && qVar.a(v2Var);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long b(long j11, c4 c4Var) {
        return ((q) a1.i(this.f12948e)).b(j11, c4Var);
    }

    @Override // androidx.media3.exoplayer.source.q.a
    public void c(q qVar) {
        ((q.a) a1.i(this.f12949f)).c(this);
        a aVar = this.f12950g;
        if (aVar != null) {
            aVar.b(this.f12944a);
        }
    }

    @Override // androidx.media3.exoplayer.source.q
    public void discardBuffer(long j11, boolean z10) {
        ((q) a1.i(this.f12948e)).discardBuffer(j11, z10);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long e(j2.z[] zVarArr, boolean[] zArr, g2.u[] uVarArr, boolean[] zArr2, long j11) {
        long j12 = this.f12952i;
        long j13 = (j12 == C.TIME_UNSET || j11 != this.f12945b) ? j11 : j12;
        this.f12952i = C.TIME_UNSET;
        return ((q) a1.i(this.f12948e)).e(zVarArr, zArr, uVarArr, zArr2, j13);
    }

    @Override // androidx.media3.exoplayer.source.q
    public void g(q.a aVar, long j11) {
        this.f12949f = aVar;
        q qVar = this.f12948e;
        if (qVar != null) {
            qVar.g(this, k(this.f12945b));
        }
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        return ((q) a1.i(this.f12948e)).getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        return ((q) a1.i(this.f12948e)).getNextLoadPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.q
    public g2.z getTrackGroups() {
        return ((q) a1.i(this.f12948e)).getTrackGroups();
    }

    public void h(r.b bVar) {
        long k11 = k(this.f12945b);
        q g11 = ((r) androidx.media3.common.util.a.e(this.f12947d)).g(bVar, this.f12946c, k11);
        this.f12948e = g11;
        if (this.f12949f != null) {
            g11.g(this, k11);
        }
    }

    public long i() {
        return this.f12952i;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        q qVar = this.f12948e;
        return qVar != null && qVar.isLoading();
    }

    public long j() {
        return this.f12945b;
    }

    @Override // androidx.media3.exoplayer.source.f0.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f(q qVar) {
        ((q.a) a1.i(this.f12949f)).f(this);
    }

    public void m(long j11) {
        this.f12952i = j11;
    }

    @Override // androidx.media3.exoplayer.source.q
    public void maybeThrowPrepareError() {
        try {
            q qVar = this.f12948e;
            if (qVar != null) {
                qVar.maybeThrowPrepareError();
            } else {
                r rVar = this.f12947d;
                if (rVar != null) {
                    rVar.maybeThrowSourceInfoRefreshError();
                }
            }
        } catch (IOException e11) {
            a aVar = this.f12950g;
            if (aVar == null) {
                throw e11;
            }
            if (this.f12951h) {
                return;
            }
            this.f12951h = true;
            aVar.a(this.f12944a, e11);
        }
    }

    public void n() {
        if (this.f12948e != null) {
            ((r) androidx.media3.common.util.a.e(this.f12947d)).j(this.f12948e);
        }
    }

    public void o(r rVar) {
        androidx.media3.common.util.a.g(this.f12947d == null);
        this.f12947d = rVar;
    }

    @Override // androidx.media3.exoplayer.source.q
    public long readDiscontinuity() {
        return ((q) a1.i(this.f12948e)).readDiscontinuity();
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
        ((q) a1.i(this.f12948e)).reevaluateBuffer(j11);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long seekToUs(long j11) {
        return ((q) a1.i(this.f12948e)).seekToUs(j11);
    }
}
