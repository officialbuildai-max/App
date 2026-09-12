package androidx.compose.material;

import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.w1;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f3487a = new h();

    private h() {
    }

    public final androidx.compose.material.ripple.c a(long j11, boolean z10) {
        androidx.compose.material.ripple.c cVar;
        androidx.compose.material.ripple.c cVar2;
        androidx.compose.material.ripple.c cVar3;
        if (!z10) {
            cVar = RippleKt.f3449g;
            return cVar;
        }
        if (w1.i(j11) > 0.5d) {
            cVar3 = RippleKt.f3447e;
            return cVar3;
        }
        cVar2 = RippleKt.f3448f;
        return cVar2;
    }

    public final long b(long j11, boolean z10) {
        return (z10 || ((double) w1.i(j11)) >= 0.5d) ? j11 : u1.f4733b.f();
    }
}
