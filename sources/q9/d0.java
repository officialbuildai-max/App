package q9;

import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;
import q9.i0;

/* loaded from: classes4.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final List f73340a;

    /* renamed from: b, reason: collision with root package name */
    private final g9.e0[] f73341b;

    public d0(List list) {
        this.f73340a = list;
        this.f73341b = new g9.e0[list.size()];
    }

    public void a(long j11, com.google.android.exoplayer2.util.d0 d0Var) {
        g9.c.a(j11, d0Var, this.f73341b);
    }

    public void b(g9.n nVar, i0.d dVar) {
        for (int i11 = 0; i11 < this.f73341b.length; i11++) {
            dVar.a();
            g9.e0 track = nVar.track(dVar.c(), 3);
            o1 o1Var = (o1) this.f73340a.get(i11);
            String str = o1Var.f25550l;
            com.google.android.exoplayer2.util.a.b(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            String str2 = o1Var.f25539a;
            if (str2 == null) {
                str2 = dVar.b();
            }
            track.e(new o1.b().S(str2).e0(str).g0(o1Var.f25542d).V(o1Var.f25541c).F(o1Var.D).T(o1Var.f25552n).E());
            this.f73341b[i11] = track;
        }
    }
}
