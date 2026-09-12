package androidx.compose.foundation.layout;

import androidx.compose.ui.f;
import androidx.compose.ui.node.a1;

/* loaded from: classes.dex */
public final class s extends f.c implements a1 {

    /* renamed from: n, reason: collision with root package name */
    private float f2955n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2956o;

    public s(float f11, boolean z10) {
        this.f2955n = f11;
        this.f2956o = z10;
    }

    @Override // androidx.compose.ui.node.a1
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public z v0(o0.e eVar, Object obj) {
        z zVar = obj instanceof z ? (z) obj : null;
        if (zVar == null) {
            zVar = new z(0.0f, false, null, null, 15, null);
        }
        zVar.g(this.f2955n);
        zVar.f(this.f2956o);
        return zVar;
    }

    public final void E1(boolean z10) {
        this.f2956o = z10;
    }

    public final void F1(float f11) {
        this.f2955n = f11;
    }
}
