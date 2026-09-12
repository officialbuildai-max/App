package androidx.compose.ui.layout;

import androidx.compose.ui.layout.g0;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends g0.a {

    /* renamed from: b, reason: collision with root package name */
    private final LookaheadCapablePlaceable f5270b;

    public p(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.f5270b = lookaheadCapablePlaceable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.g0.a
    public LayoutDirection d() {
        return this.f5270b.getLayoutDirection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.g0.a
    public int e() {
        return this.f5270b.s0();
    }
}
