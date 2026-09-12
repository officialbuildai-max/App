package androidx.compose.ui.draw;

import androidx.compose.ui.unit.LayoutDirection;
import y.m;

/* loaded from: classes.dex */
final class i implements a {

    /* renamed from: a, reason: collision with root package name */
    public static final i f4247a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final long f4248b = m.f78614b.a();

    /* renamed from: c, reason: collision with root package name */
    private static final LayoutDirection f4249c = LayoutDirection.Ltr;

    /* renamed from: d, reason: collision with root package name */
    private static final o0.e f4250d = o0.g.a(1.0f, 1.0f);

    private i() {
    }

    @Override // androidx.compose.ui.draw.a
    public o0.e getDensity() {
        return f4250d;
    }

    @Override // androidx.compose.ui.draw.a
    public LayoutDirection getLayoutDirection() {
        return f4249c;
    }

    @Override // androidx.compose.ui.draw.a
    public long i() {
        return f4248b;
    }
}
