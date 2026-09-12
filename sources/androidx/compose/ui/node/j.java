package androidx.compose.ui.node;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final DepthSortedSet f5467a;

    /* renamed from: b, reason: collision with root package name */
    private final DepthSortedSet f5468b;

    public j(boolean z10) {
        this.f5467a = new DepthSortedSet(z10);
        this.f5468b = new DepthSortedSet(z10);
    }

    public final void c(LayoutNode layoutNode, boolean z10) {
        if (z10) {
            this.f5467a.a(layoutNode);
            this.f5468b.a(layoutNode);
        } else {
            if (this.f5467a.b(layoutNode)) {
                return;
            }
            this.f5468b.a(layoutNode);
        }
    }

    public final boolean d(LayoutNode layoutNode) {
        return this.f5467a.b(layoutNode) || this.f5468b.b(layoutNode);
    }

    public final boolean e(LayoutNode layoutNode, boolean z10) {
        boolean b11 = this.f5467a.b(layoutNode);
        return z10 ? b11 : b11 || this.f5468b.b(layoutNode);
    }

    public final boolean f() {
        return this.f5468b.d() && this.f5467a.d();
    }

    public final boolean g(boolean z10) {
        return (z10 ? this.f5467a : this.f5468b).d();
    }

    public final boolean h() {
        return !f();
    }

    public final boolean i(LayoutNode layoutNode) {
        return this.f5468b.f(layoutNode) || this.f5467a.f(layoutNode);
    }
}
