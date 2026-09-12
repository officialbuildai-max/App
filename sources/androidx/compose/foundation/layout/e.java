package androidx.compose.foundation.layout;

import androidx.compose.ui.f;
import androidx.compose.ui.node.a1;

/* loaded from: classes.dex */
final class e extends f.c implements a1 {

    /* renamed from: n, reason: collision with root package name */
    private androidx.compose.ui.b f2925n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2926o;

    public e(androidx.compose.ui.b bVar, boolean z10) {
        this.f2925n = bVar;
        this.f2926o = z10;
    }

    public final androidx.compose.ui.b D1() {
        return this.f2925n;
    }

    public final boolean E1() {
        return this.f2926o;
    }

    @Override // androidx.compose.ui.node.a1
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public e v0(o0.e eVar, Object obj) {
        return this;
    }

    public final void G1(androidx.compose.ui.b bVar) {
        this.f2925n = bVar;
    }

    public final void H1(boolean z10) {
        this.f2926o = z10;
    }
}
