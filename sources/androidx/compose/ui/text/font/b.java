package androidx.compose.ui.text.font;

import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class b implements w {

    /* renamed from: b, reason: collision with root package name */
    private final int f6187b;

    public b(int i11) {
        this.f6187b = i11;
    }

    @Override // androidx.compose.ui.text.font.w
    public p a(p pVar) {
        int i11 = this.f6187b;
        return (i11 == 0 || i11 == Integer.MAX_VALUE) ? pVar : new p(RangesKt.m(pVar.h() + this.f6187b, 1, 1000));
    }

    @Override // androidx.compose.ui.text.font.w
    public /* synthetic */ int b(int i11) {
        return v.b(this, i11);
    }

    @Override // androidx.compose.ui.text.font.w
    public /* synthetic */ int c(int i11) {
        return v.c(this, i11);
    }

    @Override // androidx.compose.ui.text.font.w
    public /* synthetic */ h d(h hVar) {
        return v.a(this, hVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f6187b == ((b) obj).f6187b;
    }

    public int hashCode() {
        return this.f6187b;
    }

    public String toString() {
        return "AndroidFontResolveInterceptor(fontWeightAdjustment=" + this.f6187b + ')';
    }
}
