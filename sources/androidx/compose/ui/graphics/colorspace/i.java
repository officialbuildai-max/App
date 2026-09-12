package androidx.compose.ui.graphics.colorspace;

import androidx.collection.e0;
import androidx.compose.ui.graphics.colorspace.n;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private static final e0 f4462a;

    static {
        g gVar = g.f4428a;
        int b11 = gVar.w().b();
        int b12 = gVar.w().b();
        n.a aVar = n.f4480a;
        DefaultConstructorMarker defaultConstructorMarker = null;
        f4462a = androidx.collection.p.c(b11 | (b12 << 6) | (aVar.b() << 12), h.f4452g.c(gVar.w()), gVar.w().b() | (gVar.t().b() << 6) | (aVar.b() << 12), new h(gVar.w(), gVar.t(), aVar.b(), defaultConstructorMarker), gVar.t().b() | (gVar.w().b() << 6) | (aVar.b() << 12), new h(gVar.t(), gVar.w(), aVar.b(), defaultConstructorMarker));
    }

    public static final e0 a() {
        return f4462a;
    }
}
