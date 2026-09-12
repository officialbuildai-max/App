package bo;

import com.transsion.player.config.RenderType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f16721a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static d f16722b;

    private b() {
    }

    public final d a() {
        if (f16722b == null) {
            f16722b = new d(RenderType.SURFACE_VIEW, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, "", 65534, null);
        }
        d dVar = f16722b;
        Intrinsics.e(dVar);
        return dVar;
    }

    public final boolean b() {
        d dVar = f16722b;
        return (dVar != null ? dVar.p() : null) == RenderType.SURFACE_VIEW;
    }

    public final boolean c() {
        d dVar = f16722b;
        if (dVar != null) {
            return dVar.j();
        }
        return true;
    }

    public final void d(d dVar) {
        f16722b = dVar;
    }
}
