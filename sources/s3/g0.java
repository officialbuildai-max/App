package s3;

import androidx.media3.common.r;
import androidx.media3.container.i;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final List f75055a;

    /* renamed from: b, reason: collision with root package name */
    private final String f75056b;

    /* renamed from: c, reason: collision with root package name */
    private final s0[] f75057c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.container.i f75058d = new androidx.media3.container.i(new i.b() { // from class: s3.f0
        @Override // androidx.media3.container.i.b
        public final void a(long j11, androidx.media3.common.util.j0 j0Var) {
            g0.this.f(j11, j0Var);
        }
    });

    public g0(List list, String str) {
        this.f75055a = list;
        this.f75056b = str;
        this.f75057c = new s0[list.size()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(long j11, androidx.media3.common.util.j0 j0Var) {
        l2.g.a(j11, j0Var, this.f75057c);
    }

    public void b() {
        this.f75058d.d();
    }

    public void c(long j11, androidx.media3.common.util.j0 j0Var) {
        this.f75058d.a(j11, j0Var);
    }

    public void d(l2.t tVar, l0.d dVar) {
        for (int i11 = 0; i11 < this.f75057c.length; i11++) {
            dVar.a();
            s0 track = tVar.track(dVar.c(), 3);
            androidx.media3.common.r rVar = (androidx.media3.common.r) this.f75055a.get(i11);
            String str = rVar.f10243o;
            androidx.media3.common.util.a.b(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption MIME type provided: " + str);
            String str2 = rVar.f10229a;
            if (str2 == null) {
                str2 = dVar.b();
            }
            track.c(new r.b().f0(str2).U(this.f75056b).u0(str).w0(rVar.f10233e).j0(rVar.f10232d).O(rVar.J).g0(rVar.f10246r).N());
            this.f75057c[i11] = track;
        }
    }

    public void e() {
        this.f75058d.d();
    }

    public void g(int i11) {
        this.f75058d.g(i11);
    }
}
