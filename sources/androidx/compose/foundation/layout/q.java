package androidx.compose.foundation.layout;

import androidx.compose.ui.b;
import androidx.compose.ui.f;
import androidx.compose.ui.node.a1;

/* loaded from: classes.dex */
public final class q extends f.c implements a1 {

    /* renamed from: n, reason: collision with root package name */
    private b.InterfaceC0044b f2950n;

    public q(b.InterfaceC0044b interfaceC0044b) {
        this.f2950n = interfaceC0044b;
    }

    @Override // androidx.compose.ui.node.a1
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public z v0(o0.e eVar, Object obj) {
        z zVar = obj instanceof z ? (z) obj : null;
        if (zVar == null) {
            zVar = new z(0.0f, false, null, null, 15, null);
        }
        zVar.e(m.f2936a.a(this.f2950n));
        return zVar;
    }

    public final void E1(b.InterfaceC0044b interfaceC0044b) {
        this.f2950n = interfaceC0044b;
    }
}
