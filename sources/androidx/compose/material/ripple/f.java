package androidx.compose.material.ripple;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private final Map f3575a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map f3576b = new LinkedHashMap();

    public final e a(RippleHostView rippleHostView) {
        return (e) this.f3576b.get(rippleHostView);
    }

    public final RippleHostView b(e eVar) {
        return (RippleHostView) this.f3575a.get(eVar);
    }

    public final void c(e eVar) {
        RippleHostView rippleHostView = (RippleHostView) this.f3575a.get(eVar);
        if (rippleHostView != null) {
        }
        this.f3575a.remove(eVar);
    }

    public final void d(e eVar, RippleHostView rippleHostView) {
        this.f3575a.put(eVar, rippleHostView);
        this.f3576b.put(rippleHostView, eVar);
    }
}
