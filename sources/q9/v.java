package q9;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import q9.i0;

/* loaded from: classes4.dex */
public final class v implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private o1 f73635a;

    /* renamed from: b, reason: collision with root package name */
    private l0 f73636b;

    /* renamed from: c, reason: collision with root package name */
    private g9.e0 f73637c;

    public v(String str) {
        this.f73635a = new o1.b().e0(str).E();
    }

    private void c() {
        com.google.android.exoplayer2.util.a.i(this.f73636b);
        p0.j(this.f73637c);
    }

    @Override // q9.b0
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        c();
        long d11 = this.f73636b.d();
        long e11 = this.f73636b.e();
        if (d11 == C.TIME_UNSET || e11 == C.TIME_UNSET) {
            return;
        }
        o1 o1Var = this.f73635a;
        if (e11 != o1Var.f25554p) {
            o1 E = o1Var.b().i0(e11).E();
            this.f73635a = E;
            this.f73637c.e(E);
        }
        int a11 = d0Var.a();
        this.f73637c.c(d0Var, a11);
        this.f73637c.d(d11, 1, a11, 0, null);
    }

    @Override // q9.b0
    public void b(l0 l0Var, g9.n nVar, i0.d dVar) {
        this.f73636b = l0Var;
        dVar.a();
        g9.e0 track = nVar.track(dVar.c(), 5);
        this.f73637c = track;
        track.e(this.f73635a);
    }
}
