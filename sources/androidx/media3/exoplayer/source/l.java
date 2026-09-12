package androidx.media3.exoplayer.source;

import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.source.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.s;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class l extends androidx.media3.exoplayer.source.a {

    /* renamed from: h, reason: collision with root package name */
    private final long f12933h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.media3.common.t f12934i;

    /* loaded from: classes2.dex */
    public static final class b implements r.a {

        /* renamed from: a, reason: collision with root package name */
        private final long f12935a;

        public b(long j11, j jVar) {
            this.f12935a = j11;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        public /* synthetic */ r.a a(s.a aVar) {
            return g2.l.c(this, aVar);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        public /* synthetic */ r.a b(int i11) {
            return g2.l.b(this, i11);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        public /* synthetic */ r.a c(boolean z10) {
            return g2.l.a(this, z10);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        public r.a e(androidx.media3.exoplayer.drm.w wVar) {
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        public r.a f(androidx.media3.exoplayer.upstream.m mVar) {
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public l d(androidx.media3.common.t tVar) {
            return new l(tVar, this.f12935a, null);
        }
    }

    private l(androidx.media3.common.t tVar, long j11, j jVar) {
        this.f12934i = tVar;
        this.f12933h = j11;
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void B() {
    }

    @Override // androidx.media3.exoplayer.source.r
    public synchronized androidx.media3.common.t a() {
        return this.f12934i;
    }

    @Override // androidx.media3.exoplayer.source.r
    public q g(r.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        androidx.media3.common.t a11 = a();
        androidx.media3.common.util.a.e(a11.f10293b);
        androidx.media3.common.util.a.f(a11.f10293b.f10386b, "Externally loaded mediaItems require a MIME type.");
        t.h hVar = a11.f10293b;
        return new k(hVar.f10385a, hVar.f10386b, null);
    }

    @Override // androidx.media3.exoplayer.source.r
    public void j(q qVar) {
        ((k) qVar).i();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public synchronized void l(androidx.media3.common.t tVar) {
        this.f12934i = tVar;
    }

    @Override // androidx.media3.exoplayer.source.r
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public boolean q(androidx.media3.common.t tVar) {
        t.h hVar = tVar.f10293b;
        t.h hVar2 = (t.h) androidx.media3.common.util.a.e(a().f10293b);
        if (hVar != null && hVar.f10385a.equals(hVar2.f10385a) && Objects.equals(hVar.f10386b, hVar2.f10386b)) {
            long j11 = hVar.f10393i;
            if (j11 == C.TIME_UNSET || a1.R0(j11) == this.f12933h) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void z(w1.n nVar) {
        A(new g2.w(this.f12933h, true, false, false, null, a()));
    }
}
