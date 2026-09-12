package androidx.compose.ui.node;

/* loaded from: classes.dex */
public final class o1 extends androidx.compose.runtime.a {
    public o1(LayoutNode layoutNode) {
        super(layoutNode);
    }

    @Override // androidx.compose.runtime.a
    protected void b() {
        ((LayoutNode) a()).X0();
    }

    @Override // androidx.compose.runtime.f
    public void e(int i11, int i12) {
        ((LayoutNode) d()).Y0(i11, i12);
    }

    @Override // androidx.compose.runtime.f
    public void f(int i11, int i12, int i13) {
        ((LayoutNode) d()).P0(i11, i12, i13);
    }

    @Override // androidx.compose.runtime.a, androidx.compose.runtime.f
    public void h() {
        super.h();
        y0 g02 = ((LayoutNode) a()).g0();
        if (g02 != null) {
            g02.onEndApplyChanges();
        }
    }

    @Override // androidx.compose.runtime.f
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void i(int i11, LayoutNode layoutNode) {
        ((LayoutNode) d()).u0(i11, layoutNode);
    }

    @Override // androidx.compose.runtime.f
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void g(int i11, LayoutNode layoutNode) {
    }
}
