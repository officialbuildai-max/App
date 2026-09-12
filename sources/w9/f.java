package w9;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.n;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import v9.m;
import x9.i;
import x9.j;

/* loaded from: classes4.dex */
public abstract class f {
    public static n a(j jVar, String str, i iVar, int i11) {
        return new n.b().i(iVar.b(str)).h(iVar.f78229a).g(iVar.f78230b).f(g(jVar, iVar)).b(i11).a();
    }

    public static g9.d b(k kVar, int i11, j jVar) {
        return c(kVar, i11, jVar, 0);
    }

    public static g9.d c(k kVar, int i11, j jVar, int i12) {
        if (jVar.m() == null) {
            return null;
        }
        v9.g f11 = f(i11, jVar.f78234b);
        try {
            e(f11, kVar, jVar, i12, true);
            f11.release();
            return f11.b();
        } catch (Throwable th2) {
            f11.release();
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void d(k kVar, j jVar, int i11, v9.g gVar, i iVar) {
        new m(kVar, a(jVar, ((x9.b) jVar.f78235c.get(i11)).f78180a, iVar, 0), jVar.f78234b, 0, null, gVar).load();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void e(v9.g gVar, k kVar, j jVar, int i11, boolean z10) {
        i iVar = (i) com.google.android.exoplayer2.util.a.e(jVar.m());
        if (z10) {
            i l11 = jVar.l();
            if (l11 == null) {
                return;
            }
            i a11 = iVar.a(l11, ((x9.b) jVar.f78235c.get(i11)).f78180a);
            if (a11 == null) {
                d(kVar, jVar, i11, gVar, iVar);
                iVar = l11;
            } else {
                iVar = a11;
            }
        }
        d(kVar, jVar, i11, gVar, iVar);
    }

    private static v9.g f(int i11, o1 o1Var) {
        String str = o1Var.f25549k;
        return new v9.e((str == null || !(str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM))) ? new o9.g() : new m9.e(), i11, o1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String g(j jVar, i iVar) {
        String j11 = jVar.j();
        return j11 != null ? j11 : iVar.b(((x9.b) jVar.f78235c.get(0)).f78180a).toString();
    }
}
