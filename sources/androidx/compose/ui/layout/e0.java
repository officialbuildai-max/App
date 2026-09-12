package androidx.compose.ui.layout;

import androidx.compose.ui.layout.g0;
import androidx.compose.ui.node.y0;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e0 extends g0.a {

    /* renamed from: b, reason: collision with root package name */
    private final y0 f5260b;

    public e0(y0 y0Var) {
        this.f5260b = y0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.g0.a
    public LayoutDirection d() {
        return this.f5260b.getLayoutDirection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.g0.a
    public int e() {
        return this.f5260b.getRoot().m0();
    }
}
