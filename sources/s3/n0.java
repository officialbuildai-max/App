package s3;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
final class n0 {

    /* renamed from: a, reason: collision with root package name */
    private final List f75200a;

    /* renamed from: b, reason: collision with root package name */
    private final String f75201b;

    /* renamed from: c, reason: collision with root package name */
    private final s0[] f75202c;

    public n0(List list, String str) {
        this.f75200a = list;
        this.f75201b = str;
        this.f75202c = new s0[list.size()];
    }

    public void a(long j11, androidx.media3.common.util.j0 j0Var) {
        if (j0Var.a() < 9) {
            return;
        }
        int q11 = j0Var.q();
        int q12 = j0Var.q();
        int H = j0Var.H();
        if (q11 == 434 && q12 == 1195456820 && H == 3) {
            l2.g.b(j11, j0Var, this.f75202c);
        }
    }

    public void b(l2.t tVar, l0.d dVar) {
        for (int i11 = 0; i11 < this.f75202c.length; i11++) {
            dVar.a();
            s0 track = tVar.track(dVar.c(), 3);
            androidx.media3.common.r rVar = (androidx.media3.common.r) this.f75200a.get(i11);
            String str = rVar.f10243o;
            androidx.media3.common.util.a.b(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption MIME type provided: " + str);
            track.c(new r.b().f0(dVar.b()).U(this.f75201b).u0(str).w0(rVar.f10233e).j0(rVar.f10232d).O(rVar.J).g0(rVar.f10246r).N());
            this.f75202c[i11] = track;
        }
    }
}
