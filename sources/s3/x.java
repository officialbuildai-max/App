package s3;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class x implements d0 {

    /* renamed from: a, reason: collision with root package name */
    private androidx.media3.common.r f75387a;

    /* renamed from: b, reason: collision with root package name */
    private p0 f75388b;

    /* renamed from: c, reason: collision with root package name */
    private s0 f75389c;

    public x(String str, String str2) {
        this.f75387a = new r.b().U(str2).u0(str).N();
    }

    private void c() {
        androidx.media3.common.util.a.i(this.f75388b);
        a1.i(this.f75389c);
    }

    @Override // s3.d0
    public void a(androidx.media3.common.util.j0 j0Var) {
        c();
        long e11 = this.f75388b.e();
        long f11 = this.f75388b.f();
        if (e11 == C.TIME_UNSET || f11 == C.TIME_UNSET) {
            return;
        }
        androidx.media3.common.r rVar = this.f75387a;
        if (f11 != rVar.f10248t) {
            androidx.media3.common.r N = rVar.b().y0(f11).N();
            this.f75387a = N;
            this.f75389c.c(N);
        }
        int a11 = j0Var.a();
        this.f75389c.b(j0Var, a11);
        this.f75389c.d(e11, 1, a11, 0, null);
    }

    @Override // s3.d0
    public void b(p0 p0Var, l2.t tVar, l0.d dVar) {
        this.f75388b = p0Var;
        dVar.a();
        s0 track = tVar.track(dVar.c(), 5);
        this.f75389c = track;
        track.c(this.f75387a);
    }
}
