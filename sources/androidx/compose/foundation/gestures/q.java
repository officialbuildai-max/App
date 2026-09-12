package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.w;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
final class q {

    /* renamed from: a, reason: collision with root package name */
    private final Orientation f2804a;

    /* renamed from: b, reason: collision with root package name */
    private long f2805b;

    /* JADX WARN: Multi-variable type inference failed */
    public q() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public q(Orientation orientation) {
        this.f2804a = orientation;
        this.f2805b = y.g.f78593b.c();
    }

    public /* synthetic */ q(Orientation orientation, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : orientation);
    }

    private final long b(float f11) {
        if (this.f2804a == null) {
            long j11 = this.f2805b;
            return y.g.q(this.f2805b, y.g.s(y.g.h(j11, y.g.k(j11)), f11));
        }
        float d11 = d(this.f2805b) - (Math.signum(d(this.f2805b)) * f11);
        float c11 = c(this.f2805b);
        return this.f2804a == Orientation.Horizontal ? y.h.a(d11, c11) : y.h.a(c11, d11);
    }

    public final y.g a(w wVar, float f11) {
        long r11 = y.g.r(this.f2805b, y.g.q(wVar.h(), wVar.k()));
        this.f2805b = r11;
        if ((this.f2804a == null ? y.g.k(r11) : Math.abs(d(r11))) >= f11) {
            return y.g.d(b(f11));
        }
        return null;
    }

    public final float c(long j11) {
        return this.f2804a == Orientation.Horizontal ? y.g.n(j11) : y.g.m(j11);
    }

    public final float d(long j11) {
        return this.f2804a == Orientation.Horizontal ? y.g.m(j11) : y.g.n(j11);
    }

    public final void e() {
        this.f2805b = y.g.f78593b.c();
    }
}
