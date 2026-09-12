package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c1 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.layout.v f5457a;

    /* renamed from: b, reason: collision with root package name */
    private final LookaheadCapablePlaceable f5458b;

    public c1(androidx.compose.ui.layout.v vVar, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.f5457a = vVar;
        this.f5458b = lookaheadCapablePlaceable;
    }

    public final LookaheadCapablePlaceable a() {
        return this.f5458b;
    }

    public final androidx.compose.ui.layout.v b() {
        return this.f5457a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return Intrinsics.c(this.f5457a, c1Var.f5457a) && Intrinsics.c(this.f5458b, c1Var.f5458b);
    }

    public int hashCode() {
        return (this.f5457a.hashCode() * 31) + this.f5458b.hashCode();
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return this.f5458b.X0().F();
    }

    public String toString() {
        return "PlaceableResult(result=" + this.f5457a + ", placeable=" + this.f5458b + ')';
    }
}
