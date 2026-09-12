package androidx.compose.foundation.layout;

import androidx.compose.ui.b;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class l implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final l f2935a = new l();

    private l() {
    }

    @Override // androidx.compose.foundation.layout.k
    public androidx.compose.ui.f a(androidx.compose.ui.f fVar, float f11, boolean z10) {
        if (f11 > 0.0d) {
            return fVar.e(new LayoutWeightElement(RangesKt.h(f11, Float.MAX_VALUE), z10));
        }
        throw new IllegalArgumentException(("invalid weight " + f11 + "; must be greater than zero").toString());
    }

    @Override // androidx.compose.foundation.layout.k
    public androidx.compose.ui.f b(androidx.compose.ui.f fVar, b.InterfaceC0044b interfaceC0044b) {
        return fVar.e(new HorizontalAlignElement(interfaceC0044b));
    }
}
