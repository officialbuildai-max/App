package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final LayoutNode f6081a;

    /* renamed from: b, reason: collision with root package name */
    private final d f6082b;

    public m(LayoutNode layoutNode, d dVar) {
        this.f6081a = layoutNode;
        this.f6082b = dVar;
    }

    public final SemanticsNode a() {
        return new SemanticsNode(this.f6082b, false, this.f6081a, new i());
    }
}
