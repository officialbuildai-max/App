package p9;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import g9.a0;
import g9.e0;
import g9.l;
import g9.m;
import g9.n;
import g9.q;
import g9.r;
import java.util.Map;

/* loaded from: classes4.dex */
public class d implements l {

    /* renamed from: d, reason: collision with root package name */
    public static final r f72474d = new r() { // from class: p9.c
        @Override // g9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // g9.r
        public final l[] createExtractors() {
            l[] e11;
            e11 = d.e();
            return e11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private n f72475a;

    /* renamed from: b, reason: collision with root package name */
    private i f72476b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f72477c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] e() {
        return new l[]{new d()};
    }

    private static d0 f(d0 d0Var) {
        d0Var.P(0);
        return d0Var;
    }

    private boolean g(m mVar) {
        f fVar = new f();
        if (fVar.a(mVar, true) && (fVar.f72484b & 2) == 2) {
            int min = Math.min(fVar.f72491i, 8);
            d0 d0Var = new d0(min);
            mVar.peekFully(d0Var.d(), 0, min);
            if (b.p(f(d0Var))) {
                this.f72476b = new b();
            } else if (j.r(f(d0Var))) {
                this.f72476b = new j();
            } else if (h.p(f(d0Var))) {
                this.f72476b = new h();
            }
            return true;
        }
        return false;
    }

    @Override // g9.l
    public void b(n nVar) {
        this.f72475a = nVar;
    }

    @Override // g9.l
    public int c(m mVar, a0 a0Var) {
        com.google.android.exoplayer2.util.a.i(this.f72475a);
        if (this.f72476b == null) {
            if (!g(mVar)) {
                throw ParserException.createForMalformedContainer("Failed to determine bitstream type", null);
            }
            mVar.resetPeekPosition();
        }
        if (!this.f72477c) {
            e0 track = this.f72475a.track(0, 1);
            this.f72475a.endTracks();
            this.f72476b.d(this.f72475a, track);
            this.f72477c = true;
        }
        return this.f72476b.g(mVar, a0Var);
    }

    @Override // g9.l
    public boolean d(m mVar) {
        try {
            return g(mVar);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        i iVar = this.f72476b;
        if (iVar != null) {
            iVar.m(j11, j12);
        }
    }
}
