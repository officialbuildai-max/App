package q;

import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.unit.LayoutDirection;
import y.m;

/* loaded from: classes2.dex */
public abstract class a implements a5 {

    /* renamed from: a, reason: collision with root package name */
    private final b f73158a;

    /* renamed from: b, reason: collision with root package name */
    private final b f73159b;

    /* renamed from: c, reason: collision with root package name */
    private final b f73160c;

    /* renamed from: d, reason: collision with root package name */
    private final b f73161d;

    public a(b bVar, b bVar2, b bVar3, b bVar4) {
        this.f73158a = bVar;
        this.f73159b = bVar2;
        this.f73160c = bVar3;
        this.f73161d = bVar4;
    }

    @Override // androidx.compose.ui.graphics.a5
    public final k4 a(long j11, LayoutDirection layoutDirection, o0.e eVar) {
        float a11 = this.f73158a.a(j11, eVar);
        float a12 = this.f73159b.a(j11, eVar);
        float a13 = this.f73160c.a(j11, eVar);
        float a14 = this.f73161d.a(j11, eVar);
        float h11 = m.h(j11);
        float f11 = a11 + a14;
        if (f11 > h11) {
            float f12 = h11 / f11;
            a11 *= f12;
            a14 *= f12;
        }
        float f13 = a14;
        float f14 = a12 + a13;
        if (f14 > h11) {
            float f15 = h11 / f14;
            a12 *= f15;
            a13 *= f15;
        }
        if (a11 >= 0.0f && a12 >= 0.0f && a13 >= 0.0f && f13 >= 0.0f) {
            return b(j11, a11, a12, a13, f13, layoutDirection);
        }
        throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + a11 + ", topEnd = " + a12 + ", bottomEnd = " + a13 + ", bottomStart = " + f13 + ")!").toString());
    }

    public abstract k4 b(long j11, float f11, float f12, float f13, float f14, LayoutDirection layoutDirection);

    public final b c() {
        return this.f73160c;
    }

    public final b d() {
        return this.f73161d;
    }

    public final b e() {
        return this.f73159b;
    }

    public final b f() {
        return this.f73158a;
    }
}
