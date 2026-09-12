package q9;

import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;
import q9.i0;

/* loaded from: classes4.dex */
final class k0 {

    /* renamed from: a, reason: collision with root package name */
    private final List f73459a;

    /* renamed from: b, reason: collision with root package name */
    private final g9.e0[] f73460b;

    public k0(List list) {
        this.f73459a = list;
        this.f73460b = new g9.e0[list.size()];
    }

    public void a(long j11, com.google.android.exoplayer2.util.d0 d0Var) {
        if (d0Var.a() < 9) {
            return;
        }
        int n11 = d0Var.n();
        int n12 = d0Var.n();
        int D = d0Var.D();
        if (n11 == 434 && n12 == 1195456820 && D == 3) {
            g9.c.b(j11, d0Var, this.f73460b);
        }
    }

    public void b(g9.n nVar, i0.d dVar) {
        for (int i11 = 0; i11 < this.f73460b.length; i11++) {
            dVar.a();
            g9.e0 track = nVar.track(dVar.c(), 3);
            o1 o1Var = (o1) this.f73459a.get(i11);
            String str = o1Var.f25550l;
            com.google.android.exoplayer2.util.a.b(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            track.e(new o1.b().S(dVar.b()).e0(str).g0(o1Var.f25542d).V(o1Var.f25541c).F(o1Var.D).T(o1Var.f25552n).E());
            this.f73460b[i11] = track;
        }
    }
}
