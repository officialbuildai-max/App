package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.style.p;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public abstract class b {
    public static final long a(long j11, boolean z10, int i11, float f11) {
        return o0.b.f70719b.b(0, c(j11, z10, i11, f11), 0, o0.b.k(j11));
    }

    public static final int b(boolean z10, int i11, int i12) {
        if (z10 || !p.e(i11, p.f6517a.b())) {
            return RangesKt.f(i12, 1);
        }
        return 1;
    }

    public static final int c(long j11, boolean z10, int i11, float f11) {
        int l11 = ((z10 || p.e(i11, p.f6517a.b())) && o0.b.h(j11)) ? o0.b.l(j11) : Integer.MAX_VALUE;
        return o0.b.n(j11) == l11 ? l11 : RangesKt.m(androidx.compose.foundation.text.b.a(f11), o0.b.n(j11), l11);
    }
}
