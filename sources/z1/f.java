package z1;

import a2.i;
import a2.j;
import androidx.media3.common.r;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import h2.l;
import i3.s;
import java.util.Map;
import w1.h;

/* loaded from: classes2.dex */
public abstract class f {
    public static h a(j jVar, String str, i iVar, int i11, Map map) {
        return new h.b().i(iVar.b(str)).h(iVar.f166a).g(iVar.f167b).f(g(jVar, iVar)).b(i11).e(map).a();
    }

    public static l2.h b(androidx.media3.datasource.a aVar, int i11, j jVar) {
        return c(aVar, i11, jVar, 0);
    }

    public static l2.h c(androidx.media3.datasource.a aVar, int i11, j jVar, int i12) {
        if (jVar.m() == null) {
            return null;
        }
        h2.f f11 = f(i11, jVar.f171b);
        try {
            e(f11, aVar, jVar, i12, true);
            f11.release();
            return f11.b();
        } catch (Throwable th2) {
            f11.release();
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void d(androidx.media3.datasource.a aVar, j jVar, int i11, h2.f fVar, i iVar) {
        new l(aVar, a(jVar, ((a2.b) jVar.f172c.get(i11)).f116a, iVar, 0, ImmutableMap.of()), jVar.f171b, 0, null, fVar).load();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void e(h2.f fVar, androidx.media3.datasource.a aVar, j jVar, int i11, boolean z10) {
        i iVar = (i) androidx.media3.common.util.a.e(jVar.m());
        if (z10) {
            i l11 = jVar.l();
            if (l11 == null) {
                return;
            }
            i a11 = iVar.a(l11, ((a2.b) jVar.f172c.get(i11)).f116a);
            if (a11 == null) {
                d(aVar, jVar, i11, fVar, iVar);
                iVar = l11;
            } else {
                iVar = a11;
            }
        }
        d(aVar, jVar, i11, fVar, iVar);
    }

    private static h2.f f(int i11, r rVar) {
        String str = rVar.f10242n;
        return new h2.d((str == null || !(str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM))) ? new f3.h(s.a.f65046a, 32) : new d3.e(s.a.f65046a, 2), i11, rVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String g(j jVar, i iVar) {
        String j11 = jVar.j();
        return j11 != null ? j11 : iVar.b(((a2.b) jVar.f172c.get(0)).f116a).toString();
    }
}
